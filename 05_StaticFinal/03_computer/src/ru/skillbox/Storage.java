public class Storage {
    final private StorageType type;
    final private int memory;
    final double weightStorage;

    public Storage(StorageType type, int memory, double weightStorage) {
        this.type = type;
        this.memory = memory;
        this.weightStorage = weightStorage;
    }
}
