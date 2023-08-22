package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * The type Game.
 */
public class Game implements Idable{
    private int id;
    private String gameTitle;
    private Date releaseDate;
    private Genre genre;
    private String requiredCPU;
    private String requiredGPU;
    private int requiredMemory;
    private int requiredRAM;

    /**
     * Gets required cpu.
     *
     * @return the required cpu
     */
    public Game() {

    }

    public Game(String gameTitle, Date releaseDate, Genre genre, String requiredCPU, String requiredGPU, int requiredMemory, int requiredRAM) {
        this.gameTitle = gameTitle;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.requiredCPU = requiredCPU;
        this.requiredGPU = requiredGPU;
        this.requiredMemory = requiredMemory;
        this.requiredRAM = requiredRAM;
    }

    public String getRequiredCPU() {
        return requiredCPU;
    }

    /**
     * Sets required cpu.
     *
     * @param requiredCPU the required cpu
     */
    public void setRequiredCPU(String requiredCPU) {
        this.requiredCPU = requiredCPU;
    }

    /**
     * Gets required gpu.
     *
     * @return the required gpu
     */
    public String getRequiredGPU() {
        return requiredGPU;
    }

    /**
     * Sets required gpu.
     *
     * @param requiredGPU the required gpu
     */
    public void setRequiredGPU(String requiredGPU) {
        this.requiredGPU = requiredGPU;
    }

    /**
     * Gets required memory.
     *
     * @return the required memory
     */
    public int getRequiredMemory() {
        return requiredMemory;
    }

    /**
     * Sets required memory.
     *
     * @param requiredMemory the required memory
     */
    public void setRequiredMemory(int requiredMemory) {
        this.requiredMemory = requiredMemory;
    }

    /**
     * Gets required ram.
     *
     * @return the required ram
     */
    public int getRequiredRAM() {
        return requiredRAM;
    }

    /**
     * Sets required ram.
     *
     * @param requiredRAM the required ram
     */
    public void setRequiredRAM(int requiredRAM) {
        this.requiredRAM = requiredRAM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets game title.
     *
     * @return the game title
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * Sets game title.
     *
     * @param gameTitle the game title
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * Gets release date.
     *
     * @return the release date
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets release date.
     *
     * @param releaseDate the release date
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(gameTitle, game.gameTitle) && Objects.equals(releaseDate, game.releaseDate);
    }

    @Override
    public String toString() {
        return " | " + id + " | " + gameTitle + " | " + releaseDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameTitle, releaseDate);
    }
}
