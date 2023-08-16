package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameException;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Genre;

import java.util.List;

/**
 * The type Genre manager.
 */
public class GenreManager {
    /**
     * Add genre.
     *
     * @param genre the genre
     * @return the genre
     * @throws GameException the game excpetion
     */
    public Genre add(Genre genre) throws GameException {
        return DaoFactory.genreDao().add(genre);
    }

    /**
     * Update.
     *
     * @param genre the genre
     * @throws GameException the game excpetion
     */
    public void update(Genre genre) throws GameException {
        DaoFactory.genreDao().update(genre);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameException the game excpetion
     */
    public void delete(int id) throws GameException {
        DaoFactory.genreDao().delete(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     * @throws GameException the game excpetion
     */
    public List<Genre> getAll() throws GameException {
        return DaoFactory.genreDao().getAll();
    }
}
