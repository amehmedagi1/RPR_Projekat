package ba.unsa.etf.rpr.domain;

public class Computer {
    private int id;
    private String CPU;
    private String GPU;
    private int memory;
    private int RAM;

    public Computer(){};

    public Computer(int id, String cpu, String gpu, int memory, int ram) {
        this.id = id;
        CPU = cpu;
        GPU = gpu;
        this.memory = memory;
        RAM = ram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }
}
