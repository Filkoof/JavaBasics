import java.util.ArrayList;
import java.util.List;

public class Company {

    private final String nameCompany;
    private final int income;
    public ArrayList <Employee> employeeList = new ArrayList<>();

    public Company(String nameCompany){
        this.nameCompany = nameCompany;
        this.income = (int) (Math.random() * ((14_000_000 - 8_000_000) + 1) + 8_000_000);
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
        employeeList.sort(new SalaryComparator());
        for (int i = employeeList.size() - 1; i >= employeeList.size() - count; i--){
            if (count <= employeeList.size() && count > 0) {
                System.out.println(employeeList.get(i));
            }
        }
        return employeeList;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        employeeList.sort(new SalaryComparator());
        for (int i = 0; i <= count; i++){
            if (count <= employeeList.size() && count > 0) {
                System.out.println(employeeList.get(i));
            }
        }
        return employeeList;
    }
}
