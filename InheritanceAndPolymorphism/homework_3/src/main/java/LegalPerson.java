public class LegalPerson extends Client {

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        if (amountToTake < amount) {
            double commission = 0.01;
            amount -= amountToTake + (amountToTake * commission);
        }
    }

}
