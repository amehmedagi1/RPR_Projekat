package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * The type Computer.
 */
public class Computer implements Idable{
    private int id;
    private String CPU;
    private String GPU;
    private int memory;
    private int RAM;
    private int gameID;

    public Computer() {
    }

    public Computer(String CPU, String GPU, int memory, int RAM, int gameID) {
        this.CPU = CPU;
        this.GPU = GPU;
        this.memory = memory;
        this.RAM = RAM;
        this.gameID = gameID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets cpu.
     *
     * @return the cpu
     */
    public String getCPU() {
        return CPU;
    }

    /**
     * Sets cpu.
     *
     * @param CPU the cpu
     */
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    /**
     * Gets gpu.
     *
     * @return the gpu
     */
    public String getGPU() {
        return GPU;
    }

    /**
     * Sets gpu.
     *
     * @param GPU the gpu
     */
    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    /**
     * Gets memory.
     *
     * @return the memory
     */
    public int getMemory() {
        return memory;
    }

    /**
     * Sets memory.
     *
     * @param memory the memory
     */
    public void setMemory(int memory) {
        this.memory = memory;
    }

    /**
     * Gets ram.
     *
     * @return the ram
     */
    public int getRAM() {
        return RAM;
    }

    /**
     * Sets ram.
     *
     * @param RAM the ram
     */
    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public int getGameId() {
        return gameID;
    }

    /**
     * Sets game.
     *
     * @param gameID the game id
     */
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return memory == computer.memory && RAM == computer.RAM && Objects.equals(CPU.toLowerCase(), computer.CPU.toLowerCase()) && Objects.equals(GPU.toLowerCase(), computer.GPU.toLowerCase());
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
