package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameException;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import javafx.scene.control.Alert;

import java.util.List;

/**
 * The type Computer manager.
 */
public class ComputerManager {
    /**
     * Add computer.
     *
     * @param computer the computer
     * @return the computer
     * @throws GameException the game excpetion
     */
    public Computer add(Computer computer) throws GameException {
       return DaoFactory.computerDao().add(computer);
    }

    /**
     * Search computer by specification computer.
     *
     * @param computer the computer
     * @return the computer
     */
    public Computer searchComputerBySpecification(Computer computer) {
        try {
            List<Computer> computers = DaoFactory.computerDao().searchByComputerSpecification(computer);
            return computers.get(0);
        }catch(GameException g) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("You can't add computer to databse");
            alert.setHeaderText("Database error occured");
            alert.setContentText(g.getMessage());
            alert.showAndWait();
        }
        return null;
    }

    /**
     * Update.
     *
     * @param computer the computer
     * @throws GameException the game excpetion
     */
    public void update(Computer computer) throws GameException {
        DaoFactory.computerDao().update(computer);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameException the game excpetion
     */
    public void delete(int id) throws GameException {
        DaoFactory.computerDao().delete(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     * @throws GameException the game excpetion
     */
    public List<Computer> getAll() throws GameException {
        return DaoFactory.computerDao().getAll();
    }
}
