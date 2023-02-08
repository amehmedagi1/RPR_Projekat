package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameExcpetion;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Game;
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
     * @throws GameExcpetion the game excpetion
     */
    public Genre add(Genre genre) throws GameExcpetion {
        return DaoFactory.genreDao().add(genre);
    }

    /**
     * Update.
     *
     * @param genre the genre
     * @throws GameExcpetion the game excpetion
     */
    public void update(Genre genre) throws GameExcpetion{
        DaoFactory.genreDao().update(genre);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameExcpetion the game excpetion
     */
    public void delete(int id) throws GameExcpetion{
        DaoFactory.genreDao().delete(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     * @throws GameExcpetion the game excpetion
     */
    public List<Genre> getAll() throws GameExcpetion{
        return DaoFactory.genreDao().getAll();
    }
}
