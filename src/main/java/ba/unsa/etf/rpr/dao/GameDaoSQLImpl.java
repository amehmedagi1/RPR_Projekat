package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class GameDaoSQLImpl implements GameDao{
    private Connection connection;

    public GameDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_database for game specs", "freedb_amehmedagi1", "4w&vSbrf$e5gxDg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Game getById(int id) {
        return null;
    }

    @Override
    public Game add(Game item) {
        return null;
    }

    @Override
    public Game update(Game item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Game> getAll() {
        return null;
    }
}
