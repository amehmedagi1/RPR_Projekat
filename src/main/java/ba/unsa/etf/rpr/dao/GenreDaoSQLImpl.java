package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;

import java.sql.*;
import java.util.*;

/**
 * The type Genre dao sql.
 */
public class GenreDaoSQLImpl extends AbstractDao<Genre> implements GenreDao{
    private static  GenreDaoSQLImpl genreDaoSQL = null;

    /**
     * Instantiates a new Genre dao sql.
     */
    public GenreDaoSQLImpl(){
        super("genres");
//        try {
//            query = "SELECT * FROM genres WHERE genre_id = ?";
//            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_database for game specs", "freedb_amehmedagi1", "4w&vSbrf$e5gxDg");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static GenreDaoSQLImpl getInstance() {
        if(genreDaoSQL == null) {
            genreDaoSQL = new GenreDaoSQLImpl();
        }
        return genreDaoSQL;
    }

    /**
     * Remove genre dao sql.
     */
    public static void removeGenreDaoSQL() {
        genreDaoSQL = null;
    }

//    @Override
//    public Genre getById(int id) {
//        try {
//            PreparedStatement stmt = this.connection.prepareStatement(query);
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) { // result set is iterator.
//                Genre genre = new Genre();
//                genre.setId(rs.getInt("genre_id"));
//                genre.setGenreName(rs.getString("genre_name"));
//                rs.close();
//                return genre;
//            } else {
//                return null; // if there is no elements in the result set return null
//            }
//        } catch (SQLException e) {
//            e.printStackTrace(); // poor error handling
//        }
//        return null;
//    }
//
//
//    @Override
//    public Genre add(Genre item) {
//        return null;
//    }
//
//
//    @Override
//    public Genre update(Genre item) {
//        return null;
//    }
//
//
//    @Override
//    public void delete(int id) {
//        //I will do something here
//    }
//
//    @Override
//    public List<Genre> getAll() {
//        return Collections.emptyList();
//    }

//    /**
//     * @param id for searching genre for id
//     * @return specific Genre for specific id from db
//     * @author amehemdagi1
//     */

//    public Genre returnGenreForId(int id){
//        try {
//            PreparedStatement stmt = this.connection.prepareStatement(query);
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                Genre genre = new Genre();
//                genre.setId(rs.getInt(1));
//                genre.setGenreName(rs.getString(2));
//                return genre;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public Genre row2object(ResultSet rs) {
        try {
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setGenreName(rs.getString("genre_name"));
            return genre;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> object2row(Genre object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("genre_name", object.getGenreName());
        return row;
    }
}
