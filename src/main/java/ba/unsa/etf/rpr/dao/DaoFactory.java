package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

public class DaoFactory {
    private static final ComputerDao computerDao = ComputerDaoSQLImpl.getInstance();
    private static final GameDao gameDao = GameDaoSQLImpl.getInstance();
    private static final GenreDao genreDao = GenreDaoSQLImpl.getInstance();

    private DaoFactory() {
    }

    public static ComputerDao computerDao() {
        return computerDao;
    }
    public static GameDao gameDao() {
        return gameDao;
    }

    public static GenreDao genreDao() {
        return genreDao;
    }
}
