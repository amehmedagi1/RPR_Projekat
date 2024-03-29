package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * The type Genre.
 */
public class Genre implements Idable{
    private int id;
    private String genreName;

    /**
     * Instantiates a new Genre.
     *
     * @param genreName the genre name
     */
    public Genre(String genreName){
        this.genreName = genreName;
    }

    /**
     * Instantiates a new Genre.
     */
    public Genre(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets genre name.
     *
     * @return the genre name
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * Sets genre name.
     *
     * @param genreName the genre name
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id && Objects.equals(genreName, genre.genreName);
    }

    @Override
    public String toString() {
        return genreName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genreName);
    }
}
