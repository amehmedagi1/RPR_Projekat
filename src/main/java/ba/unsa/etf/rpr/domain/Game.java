package ba.unsa.etf.rpr.domain;

import java.util.Date;

public class Game {
    private int id;
    private String gameTitle;
    private Date releaseDate;

    public Game () {};


    public Game(int id, String gameTitle, Date releaseDate) {
        this.id = id;
        this.gameTitle = gameTitle;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
