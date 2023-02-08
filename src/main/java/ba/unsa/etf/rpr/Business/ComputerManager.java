package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameExcpetion;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import javafx.scene.control.Alert;

import java.util.List;

import static ba.unsa.etf.rpr.dao.DaoFactory.computerDao;

/**
 * The type Computer manager.
 */
public class ComputerManager {
    /**
     * Add computer.
     *
     * @param computer the computer
     * @return the computer
     * @throws GameExcpetion the game excpetion
     */
    public Computer add(Computer computer) throws GameExcpetion{
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
        }catch(GameExcpetion g) {
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
     * @throws GameExcpetion the game excpetion
     */
    public void update(Computer computer) throws GameExcpetion{
        DaoFactory.computerDao().update(computer);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameExcpetion the game excpetion
     */
    public void delete(int id) throws GameExcpetion{
        DaoFactory.computerDao().delete(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     * @throws GameExcpetion the game excpetion
     */
    public List<Computer> getAll() throws GameExcpetion{
        return DaoFactory.computerDao().getAll();
    }
}
