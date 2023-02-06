package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.sql.*;
import java.util.*;

public class ComputerDaoSQLImpl extends AbstractDao<Computer> implements ComputerDao{


    private static  ComputerDaoSQLImpl instance = null;
    private ComputerDaoSQLImpl(){
        super("computers");
    }




    public static ComputerDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ComputerDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Computer row2object(ResultSet rs) {
        try {
            Computer computer = new Computer();
            computer.setId(rs.getInt("id"));
            computer.setCPU(rs.getString("CPU"));
            computer.setGPU(rs.getString("GPU"));
            computer.setMemory(rs.getInt("Memory"));
            computer.setRAM(rs.getInt("RAM"));
            //treba još za igrice ovdje
            return computer;
        } catch (SQLException e) {
            return new Computer();
            //treba bacati ovdje novokreirani izuzetak
        }
    }

    @Override
    public Map<String, Object> object2row(Computer object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("CPU", object.getCPU());
        row.put("GPU", object.getGPU());
        row.put("Memory", object.getMemory());
        row.put("RAM", object.getRAM());
        //dodati jos game
        return row;
    }

    @Override
    public List<Computer> searchByComputerSpecification(Computer computer) {
        String query = "SELECT * FROM computers WHERE CPU=?, GPU=?, Memory=?,RAM=?";
        return executeQuery(query, new Object[]{computer.getCPU(), computer.getGPU(), computer.getMemory(), computer.getRAM()});
    }



/*
    @Override
    public Computer getById(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Computer computer = new Computer();
                computer.setId(rs.getInt("computer_id"));
                computer.setCPU(rs.getString("CPU"));
                computer.setGPU(rs.getString("GPU"));
                computer.setMemory(rs.getInt("Memory"));
                computer.setRAM(rs.getInt("RAM"));
                computer.setGame(returnGameForId(rs.getInt("game_id")));
                rs.close();
                return computer;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }
*/
    /*
    @Override
    public Computer add(Computer item) {
        return null;
    }

*/
    /*
    @Override
    public Computer update(Computer item) {
        return null;
    }

*/
    /*
    @Override
    public void delete(int id) {
        //I will do something here
    }
*/
    /*
    @Override
    public List<Computer> getAll() {
        return Collections.emptyList();
    }
*/
    /**
     * @param id for searching computer
     * @return specific Computer for specific id from db
     * @author amehemdagi1
     */
/*
    public Game returnGameForId(int id){
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt(1));
                game.setGameTitle(rs.getString(2));
                game.setReleaseDate(rs.getDate(4));
                game.setGenre(returnGenreForId(rs.getInt(3)));
                return game;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    /*
    public Genre returnGenreForId(int id){
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getInt(1));
                genre.setGenreName(rs.getString(2));
                return genre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
*/

/*
    public Computer returnComputerForId(int id){
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Computer computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setCPU(rs.getString(2));
                computer.setGPU(rs.getString(3));
                computer.setMemory(rs.getInt(4));
                computer.setRAM(rs.getInt(5));
                computer.setGame(returnGameForId(rs.getInt(6)));
                return computer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
*/
}
