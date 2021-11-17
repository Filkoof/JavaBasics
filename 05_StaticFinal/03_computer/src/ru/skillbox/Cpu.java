public class Cpu {
    private final double frequency;
    private final int cores;
    private final String manufacturer;
    private final double weightCpu;

    public Cpu(double frequency,
               int cores,
               String manufacturer,
               double weightCpu) {
        this.frequency = frequency;
        this.cores = cores;
        this.manufacturer = manufacturer;
        this.weightCpu = weightCpu;
    }

    public double getFrequency(){
        return frequency;
    }

    public int getCores(){
        return cores;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public double getWeightCpu(){
        return weightCpu;
    }

}
