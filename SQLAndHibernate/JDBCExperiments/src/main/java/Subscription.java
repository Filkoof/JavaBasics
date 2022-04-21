import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Subscription {
    @EmbeddedId
    private Key id;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionFDate;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getSubscriptionFDate() {
        return subscriptionFDate;
    }

    public void setSubscriptionFDate(Date subscriptionFDate) {
        this.subscriptionFDate = subscriptionFDate;
    }
}
