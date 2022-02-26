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
        salary = 60_000 + (int) (salary + (income * 0.05));

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
