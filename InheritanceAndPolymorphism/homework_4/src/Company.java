import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    public int income;
    ArrayList <Employee> employeeList;

    public Company(){
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employees.addAll(employees);
    }

    public void fire(Employee employee){
        employeeList.remove(employee);
    }

    public int getIncome(){
        return income = (int) (Math.random() * ((14_000_000 - 8_000_000) + 1));
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        new ArrayList<>(employeeList).sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });

        for (int i = 0; i < count; i++){

        }
        return getTopSalaryStaff(count);
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        new ArrayList<>(employeeList).sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });

        for (int i = 0; i < count; i++){

        }
        return getLowestSalaryStaff(count);
    }
}
