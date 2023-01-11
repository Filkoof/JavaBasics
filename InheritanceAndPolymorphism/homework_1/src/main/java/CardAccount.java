public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        if (amountToTake < amount) {
            double commission = 0.01;
            amount -= amountToTake + (amountToTake * commission);
        }
    }

}
