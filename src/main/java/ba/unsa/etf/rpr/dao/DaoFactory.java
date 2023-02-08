package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

/**
 * The type Dao factory.
 */
public class DaoFactory {
    private static final ComputerDao computerDao = ComputerDaoSQLImpl.getInstance();
    private static final GameDao gameDao = GameDaoSQLImpl.getInstance();
    private static final GenreDao genreDao = GenreDaoSQLImpl.getInstance();

    private DaoFactory() {
    }

    /**
     * Computer dao computer dao.
     *
     * @return the computer dao
     */
    public static ComputerDao computerDao() {
        return computerDao;
    }

    /**
     * Game dao game dao.
     *
     * @return the game dao
     */
    public static GameDao gameDao() {
        return gameDao;
    }

    /**
     * Genre dao genre dao.
     *
     * @return the genre dao
     */
    public static GenreDao genreDao() {
        return genreDao;
    }
}
