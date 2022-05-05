import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Course> courseCriteriaQuery = builder.createQuery(Course.class);
        Root<Course> courseRoot = courseCriteriaQuery.from(Course.class);
        courseCriteriaQuery.select(courseRoot);

        CriteriaQuery<Student> studentCriteriaQuery = builder.createQuery(Student.class);
        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);
        studentCriteriaQuery.select(studentRoot);

        CriteriaQuery<PurchaseList> purchaseListCriteriaQuery = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = purchaseListCriteriaQuery.from(PurchaseList.class);
        purchaseListCriteriaQuery.select(root);


        List<PurchaseList> purchaseLists = session.createQuery(purchaseListCriteriaQuery).getResultList();

        for (PurchaseList purchaseList : purchaseLists) {
            courseCriteriaQuery.where(builder.equal(courseRoot.get("name"), purchaseList.getCourseName()));
            int courseId = Objects.requireNonNull(session.createQuery(courseCriteriaQuery)
                    .stream()
                    .findFirst()
                    .orElse(null))
                    .getId();

            studentCriteriaQuery.where(builder.equal(studentRoot.get("name"), purchaseList.getStudentName()));
            int studentId = Objects.requireNonNull(session.createQuery(studentCriteriaQuery)
                    .stream()
                    .findFirst()
                    .orElse(null))
                    .getId();


            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(new LinkedPurchaseListKey(studentId,courseId),
                    studentId,courseId);
            session.saveOrUpdate(linkedPurchaseList);
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
