public class Operator
        implements Employee {

    private Company company;
    private int salary;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        salary = 50_000;
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Operator" + ", salary:" + salary;
    }
}
