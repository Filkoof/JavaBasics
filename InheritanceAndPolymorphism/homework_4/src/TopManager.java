public class TopManager
        implements Employee {

    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int income;
        int fixSalary = 80_000;
        if (company.getIncome() > 10_000_000){
            double bonus = 1.5;
            income = (int) (fixSalary + (fixSalary * bonus));
        } else {
            income = fixSalary;
        }
        return income;
    }
}
