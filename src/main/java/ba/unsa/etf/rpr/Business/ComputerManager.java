package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.Exceptions.GameExcpetion;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
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
     */
    public Computer add(Computer computer) {
        try {
            computerDao().add(computer);
            return computer;
        }catch (GameExcpetion g) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You can't add computer to databse");
            alert.setHeaderText("Database error occured");
            alert.setContentText(g.getMessage());
            alert.showAndWait();
        }
        return null;
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
}
