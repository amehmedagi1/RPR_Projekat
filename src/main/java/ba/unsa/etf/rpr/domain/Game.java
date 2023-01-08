package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Game implements Idable{
    private int id;
    private String gameTitle;
    private Date releaseDate;
    private Genre genre;


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

    public Genre getGenre() {
        return genre;
    }

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
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gameTitle, releaseDate);
    }
}
