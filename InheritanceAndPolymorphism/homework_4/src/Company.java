import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    public int income;
    public String nameCompany;
    private final ArrayList <Employee> employeeList = new ArrayList<>();

    public Company(String nameCompany){
        this.nameCompany = nameCompany;
        this.income = (int) (Math.random() * ((14_000_000 - 8_000_000) + 1));
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> hireAll(Employee employee,int count) {
        for (int i = 0; i <= count; i++){
            employeeList.add(employee);
        }

        return employeeList;
    }

    public void fire(Employee employee){
        employeeList.remove(employee);
    }

    public int getIncome(){
        return this.income;
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        new ArrayList<>(employeeList).sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getMonthSalary() - o1.getMonthSalary();
            }
        });

        for (int i = 0; i <= count; i++){
            if (count <= employeeList.size() && count > 0) {
                System.out.println(employeeList.get(i));
            }
        }
        return employeeList;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        new ArrayList<>(employeeList).sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getMonthSalary() - o2.getMonthSalary();
            }
        });

        for (int i = 0; i <= count; i++){
            if (count <= employeeList.size() && count > 0) {
                System.out.println(employeeList.get(i));
            }
        }
        return employeeList;
    }
}
