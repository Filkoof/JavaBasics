public class TopManager
        implements Employee {

    private Company company;
    private int salary;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int fixSalary = 80_000;
        if (company.getIncome() > 10_000_000){
            double bonus = 1.5;
            salary = (int) (fixSalary + (fixSalary * bonus));
        } else {
            salary = fixSalary;
        }
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "TopManager" + ", salary:" + salary;
    }
}
