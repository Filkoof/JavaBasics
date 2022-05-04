import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseListKey implements Serializable {
    @Column(name = "student_name")
    private int studentName;

    @Column(name = "course_name")
    private int courseName;

    public PurchaseListKey() {
    }

    public int getStudentName() {
        return studentName;
    }

    public void setStudentName(int studentName) {
        this.studentName = studentName;
    }

    public int getCourseName() {
        return courseName;
    }

    public void setCourseName(int courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseListKey purchaseListKey= (PurchaseListKey) o;
        return studentName == purchaseListKey.studentName && courseName == purchaseListKey.courseName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }
}
