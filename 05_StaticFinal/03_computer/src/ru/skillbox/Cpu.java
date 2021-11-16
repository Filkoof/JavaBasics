public class Cpu {
    final private double frequency;
    final private int cores;
    final private String manufacturer;
    final double weightCpu;

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

    public Cpu setFrequency(double frequency){
        return new Cpu(frequency, cores, manufacturer, weightCpu);
    }

    public int getCores(){
        return cores;
    }

    public Cpu setCores(int cores){
        return new Cpu(frequency, cores, manufacturer, weightCpu);
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public Cpu setManufacturer(String manufacturer){
        return new Cpu(frequency, cores, manufacturer, weightCpu);
    }

    public double getWeightCpu(){
        return weightCpu;
    }

    public Cpu setWeightCpu(double weightCpu){
        return new Cpu(frequency, cores, manufacturer, weightCpu);
    }
}
