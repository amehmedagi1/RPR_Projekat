package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameExcpetion;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;
import javafx.scene.control.Alert;

import java.util.List;

/**
 * The type Game manager.
 */
public class GameManager {

    /**
     * Add game.
     *
     * @param game the game
     * @return the game
     * @throws GameExcpetion the game excpetion
     */
    public Game add(Game game) throws GameExcpetion {
        return DaoFactory.gameDao().add(game);
    }

    /**
     * Update.
     *
     * @param game the game
     * @throws GameExcpetion the game excpetion
     */
    public void update(Game game) throws GameExcpetion {
        DaoFactory.gameDao().update(game);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameExcpetion the game excpetion
     */
    public void delete(int id) throws GameExcpetion {
        DaoFactory.gameDao().delete(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     * @throws GameExcpetion the game excpetion
     */
    public List<Game> getAll() throws GameExcpetion {
        return DaoFactory.gameDao().getAll();
    }

    /**
     * Search by genres list.
     *
     * @param genre the genre
     * @return the list
     */
    public List<Game> searchByGenres(Genre genre) {
        try {
            List<Game> games = DaoFactory.gameDao().searchByGenreName(genre);
            return games;
        } catch (GameExcpetion g) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("You can't add games to databse");
            alert.setHeaderText("Database error occured");
            alert.setContentText(g.getMessage());
            alert.showAndWait();
        }
        return null;
    }
}

