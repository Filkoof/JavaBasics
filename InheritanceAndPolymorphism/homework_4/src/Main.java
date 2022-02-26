public class Main {

    public static void main(String[] args) {
        Company company = new Company("КомпанияКо");

        company.hireAll(new Operator(company), 180);
        company.hireAll(new Manager(company), 80);
        company.hireAll(new TopManager(company), 10);

        System.out.println(company.getTopSalaryStaff(12));
        System.out.println(company.getLowestSalaryStaff(10));

        for (int i = 0; i < company.getEmployeeList().size() / 2; i++){
            company.fire(company.getEmployeeList().get(i));
        }

        System.out.println(company.getTopSalaryStaff(12));
        System.out.println(company.getLowestSalaryStaff(10));
    }
}
