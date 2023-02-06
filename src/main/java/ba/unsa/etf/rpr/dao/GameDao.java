package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.util.List;


public interface GameDao extends Dao<Game>{

    /**
     * Returns all games form specific genre.
     *
     * @param genre is given as specific
     * @return list of games
     */
    List<Game> searchByGenreName(Genre genre);
    List<Game> searchByComputer(Computer computer);
}
