public class Operator
        implements Employee {

    private Company company;

    public Operator(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        return 60_000;
    }
}
