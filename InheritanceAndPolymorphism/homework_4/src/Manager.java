public class Manager
        implements Employee {

    private Company company;

    public Manager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int income = (int) (Math.random() * ((140_000 - 115_000) + 1));
        int fixSalary = 60_000;
        double bonus = 0.05;

        return (int) (fixSalary + (income * bonus));
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
