package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.util.List;


/**
 * The interface Game dao.
 */
public interface GameDao extends Dao<Game>{

    /**
     * Returns all games form specific genre.
     *
     * @param genre is given as specific
     * @return list of games
     */
    List<Game> searchByGenreName(Genre genre);

    /**
     * Search by computer list.
     *
     * @param computer the computer
     * @return the list
     */
    List<Game> searchByComputer(Computer computer);

    /**
     * Gets games with genre id.
     *
     * @param genre the genre
     * @return the games with genre id
     */
    List<Game> getGamesWithGenreId(Genre genre);

}
