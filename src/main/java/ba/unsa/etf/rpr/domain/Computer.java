package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Computer implements Idable{
    private int id;
    private String CPU;
    private String GPU;
    private int memory;
    private int RAM;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id && memory == computer.memory && RAM == computer.RAM && Objects.equals(CPU, computer.CPU) && Objects.equals(GPU, computer.GPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CPU, GPU, memory, RAM);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", memory=" + memory +
                ", RAM=" + RAM +
                '}';
    }
}
