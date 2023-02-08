package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameExcpetion;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.util.List;

public class GenreManager {
    public Genre add(Genre genre) throws GameExcpetion {
        return DaoFactory.genreDao().add(genre);
    }

    public void update(Genre genre) throws GameExcpetion{
        DaoFactory.genreDao().update(genre);
    }

    public void delete(int id) throws GameExcpetion{
        DaoFactory.genreDao().delete(id);
    }

    public List<Genre> getAll() throws GameExcpetion{
        return DaoFactory.genreDao().getAll();
    }
}
