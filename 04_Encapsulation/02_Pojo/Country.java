public class Country {

    private String countryName;
    private int countPopulation;
    private int area;
    private String capitalName;
    private boolean seaExit;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountPopulation() {
        return countPopulation;
    }

    public void setCountPopulation(int countPopulation) {
        this.countPopulation = countPopulation;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean getSeaExit() {
        return seaExit;
    }

    public void setSeaExit(boolean seaExit) {
        this.seaExit = seaExit;
    }
}