public class Storage {
    private final StorageType type;
    private final int memory;
    private final double weightStorage;

    public Storage(StorageType type, int memory, double weightStorage) {
        this.type = type;
        this.memory = memory;
        this.weightStorage = weightStorage;
    }

    public int getMemory(){
        return memory;
    }

    public double getWeightStorage(){
        return weightStorage;
    }
}
