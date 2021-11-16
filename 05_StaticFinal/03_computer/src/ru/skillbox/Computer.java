public class Computer {
    private final String cpu; //процессор
    private final String ram; // оперативная память
    private final String storage; // Накопитель информации
    private final String screen; //Экран
    private final String keyboard; //Клавиатура
    private final String vendor; //Производитель
    private final String name; //Название

    public Computer(String cpu,
                    String ram,
                    String informationStorage,
                    String screen,
                    String keyboard) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = informationStorage;
        this.screen = screen;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public Computer setCpu(String cpu){
        return new Computer(cpu, ram, storage, screen, keyboard);
    }

    public String getRam(){
        return ram;
    }

    public Computer setRam(String ram){
        return new Computer(cpu, ram, storage, screen, keyboard);
    }

    public String getInformationStorage(){
        return storage;
    }

    public Computer setInformationStorage(String informationStorage){
        return new Computer(cpu, ram, informationStorage, screen, keyboard);
    }

    public String getScreen(){
        return screen;
    }

    public Computer setScreen(String screen){
        return new Computer(cpu, ram, storage, screen, keyboard);
    }

    public String getKeyboard(){
        return keyboard;
    }

    public Computer setKeyboard(String keyboard){
        return new Computer(cpu, ram, storage, screen, keyboard);
    }

    public String toString() {
        return "Производитель: " + vendor +
                "Модель: " + name +
                "Процессор: " + cpu +
                "Оперативная память: " + ram +
                "Накопитель информации: " + storage +
                "Экран: " + screen +
                "Клавиатура: " + keyboard;
    }
}
