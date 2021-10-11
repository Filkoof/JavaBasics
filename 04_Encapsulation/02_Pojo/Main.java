public class Main {

    public static void main(String[] args) {
        Country country = new Country();
        country.setCountryName("Россия");
        country.setArea(17130000);
        country.setCountPopulation(1440000000);
        country.setCapitalName("Москва");
        country.setSeaExit("есть");

        System.out.println("Страна: " + country.getCountryName() + "Площадь: " + country.getArea()
                + "Население: " + country.getCountPopulation()
                + "Столица: " + country.getCapitalName() + "Выход к морю: " + country.getSeaExit() );


    }

}
