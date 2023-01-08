package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerDaoSQLImpl implements ComputerDao{
    private Connection connection;
    private String query;

    public ComputerDaoSQLImpl(){
        try {
            query = "SELECT * FROM computers WHERE id = ?";
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_database for game specs", "freedb_amehmedagi1", "4w&vSbrf$e5gxDg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    @Override
    public Computer add(Computer item) {
        return null;
    }


    @Override
    public Computer update(Computer item) {
        return null;
    }


    @Override
    public void delete(int id) {
        //I will do something here
    }

    @Override
    public List<Computer> getAll() {
        return Collections.emptyList();
    }

    /**
     * @param id for searching computer
     * @return specific Computer for specific id from db
     * @author amehemdagi1
     */

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

}
