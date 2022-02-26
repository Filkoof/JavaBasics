public class Manager
        implements Employee{

    private Company company;
    private int salary;
    private final int sales;

    public Manager(Company company) {
        this.company = company;
        this.sales = (int) (Math.random() * ((140_000 - 115_000) + 1)  + 115_000);
    }

    @Override
    public int getMonthSalary() {
        salary = (int) (60_000 + (this.sales * 0.05));

        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Manager" + ", salary:" + salary;
    }
}
