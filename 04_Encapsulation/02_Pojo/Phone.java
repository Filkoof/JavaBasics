public class Phone {

    private String nameBrand;
    private int memory;
    private String nameModel;
    private boolean haveCamera;

    public Phone(String nameBrand, String nameModel) {
        this.nameBrand = nameBrand;
        this.nameModel = nameModel;
    }

    public String getNameBrand() {

        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {

        this.nameBrand = nameBrand;
    }

    public int getMemory() {

        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public boolean setHaveCamera() {
        return haveCamera;
    }

    public void getHaveCamera(boolean haveCamera) {
        this.haveCamera = haveCamera;
    }


}
