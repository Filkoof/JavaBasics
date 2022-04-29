import javax.persistence.*;
import java.util.Date;

@Table(name = "PurchaseList")
public class PurchaseList {
    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "student_name")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "course_name")
    private Course course;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse (Course course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
