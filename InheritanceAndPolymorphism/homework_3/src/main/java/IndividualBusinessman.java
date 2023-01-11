public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut >= 0) {
            if (amountToPut < 1000) {
                double commission = 0.01;
                amount += amountToPut - (amountToPut * commission);
            } else if (amountToPut >= 1000) {
                double commission = 0.005;
                amount += amountToPut - (amountToPut * commission);
            }
        }
    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake);
    }

}
