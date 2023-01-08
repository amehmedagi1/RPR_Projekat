package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.util.List;


public interface GameDao extends Dao<Game>{

    /**
     * Returns all teams form specific genre.
     *
     * @param genre is given as specific genre
     * @return list of teams
     */
    List<Game> searchByGenre(Genre genre);

}
