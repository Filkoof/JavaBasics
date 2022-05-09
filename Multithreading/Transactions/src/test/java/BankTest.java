import junit.framework.TestCase;

public class BankTest  extends TestCase {
    @Override
    protected void setUp() throws Exception {
        String fromAccountNum = String.valueOf(100_000 + (int) (Math.random() * 1_000_000));
        String toAccountNum = String.valueOf(100_000 + (int) (Math.random() * 1_000_000));
        long amountLower = 1 + (long) (Math.random() * 50_000);
        long amountUpper = 50_000 + (long) (Math.random() * 100_000);
    }

    public void testBankLowLimit(){
        
    }

    public void testBankUpperLimit(){

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
