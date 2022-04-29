import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String fillTable = """
                insert into skillbox.linkedpurchaselist (course_id, student_id)
                select st.id, c.id from purchaselist pur\s
                join students st on pur.student_name=st.name\s
                join courses c on pur.course_name=c.name;""";
        session.createSQLQuery(fillTable).executeUpdate();

        transaction.commit();
        sessionFactory.close();
    }
}
