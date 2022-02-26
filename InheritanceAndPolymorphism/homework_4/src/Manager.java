public class Manager
        implements Employee{

    private Company company;
    private int salary;

    public Manager(Company company) {
        this.company = company;
        this.salary = (int) (Math.random() * ((140_000 - 115_000) + 1));
    }

    @Override
    public int getMonthSalary() {
        int income = this.salary;
        int fixSalary = 60_000;
        double bonus = 0.05;
        salary = (int) (fixSalary + (income * bonus));

        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Manager" +
                "company:" + company +
                ", salary:" + salary;
    }
}
