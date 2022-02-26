public class TopManager
        implements Employee {

    private Company company;
    private int salary = 80_000;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10_000_000) {
            salary = (int) (salary + (salary * 1.5));
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
