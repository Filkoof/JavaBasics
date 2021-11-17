public class Ram {
    private final RamType type;
    private final int memory;
    private final double weightRam;

    public Ram(RamType type, int memory, double weightRam) {
        this.type = type;
        this.memory = memory;
        this.weightRam = weightRam;
    }

    public int getMemory(){
        return memory;
    }

    public double getWeightRam(){
        return weightRam;
    }
}
