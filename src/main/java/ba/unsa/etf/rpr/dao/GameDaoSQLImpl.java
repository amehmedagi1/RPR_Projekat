package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameDaoSQLImpl implements GameDao{
    private Connection connection;
    private String query;

    public GameDaoSQLImpl(){
        try {
            query = "SELECT * FROM games WHERE id = ?";
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_database for game specs", "freedb_amehmedagi1", "4w&vSbrf$e5gxDg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game getById(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Game game = new Game();
                game.setId(rs.getInt("game_id"));
                game.setGameTitle(rs.getString("team_name"));
                game.setReleaseDate(rs.getDate("release_date"));
                game.setGenre(returnGenreForId(rs.getInt("genre_id")));
                rs.close();
                return game;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
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
        //I will do something here
    }

    @Override
    public List<Game> getAll() {
        return Collections.emptyList();
    }

    /**
     * @param id for searching genre for games
     * @return specific Genre for specific game from db
     * @author amehemdagi1
     */

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

    /**
     * @param genre search genre for games
     * @return list of games
     * @author amehmedagi1
     */

    @Override
    public List<Game> searchByGenre(Genre genre) {
        String q = "SELECT * FROM teams WHERE confederation_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(q);
            stmt.setInt(1, genre.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Game> teamLista = new ArrayList<>();
            while (rs.next()) {
                Game g = new Game();
                g.setId(rs.getInt(1));
                g.setGameTitle((rs.getString(2)));
                g.setReleaseDate(rs.getDate(4));
                g.setGenre(genre);
                teamLista.add(g);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
