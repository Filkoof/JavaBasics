import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("КомпанияКо");

        company.hireAll(new Operator(company), 180);
        company.hireAll(new Manager(company), 80);
        company.hireAll(new TopManager(company), 10);

        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));

        for (int i = 0; i < company.employeeList.size() / 2; i++){
            company.fire(company.employeeList.get(i));
        }

        System.out.println(company.getTopSalaryStaff(10));
        System.out.println(company.getLowestSalaryStaff(30));
    }
}
