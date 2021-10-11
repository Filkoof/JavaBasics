public class Main {


    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setMemory(256);
        phone.setNameBrand("iPhone");
        phone.setNameModel("11 pro");

        System.out.println("Бренд: " + phone.getNameBrand() + "Модель: " + phone.getNameModel()
                + "Память: " + phone.getMemory());


    }

}
