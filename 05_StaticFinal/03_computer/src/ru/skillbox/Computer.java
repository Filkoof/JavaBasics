public class Computer {
    private Cpu cpu; //процессор
    private Ram ram; // оперативная память
    private Storage storage; // Накопитель информации
    private Screen screen; //Экран
    private Keyboard keyboard; //Клавиатура
    private String vendor; //Производитель
    private String name; //Название
    private double totalWeight;

    public Computer(Cpu cpu,
                    Ram ram,
                    Storage storage,
                    Screen screen,
                    Keyboard keyboard,
                    String vendor,
                    String name) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
        this.vendor = vendor;
        this.name = name;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu){
        this.cpu = cpu;
    }

    public Ram getRam(){
        return ram;
    }

    public void setRam(Ram ram){
        this.ram = ram;
    }

    public Storage getStorage(){
        return storage;
    }

    public void setStorage(Storage storage){
        this.storage = storage;
    }

    public Screen getScreen(){
        return screen;
    }

    public void setScreen(Screen screen){
        this.screen = screen;
    }

    public Keyboard getKeyboard(){
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard){
        this.keyboard = keyboard;
    }

    public double calculateTotalWeight(){
        totalWeight = cpu.getWeightCpu()
                + ram.getWeightRam()
                + storage.getWeightStorage()
                + screen.getWeightScreen()
                + keyboard.getWeightKeyboard();
        return totalWeight;
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
