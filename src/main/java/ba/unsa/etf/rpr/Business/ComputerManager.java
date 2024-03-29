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
        if(computer.getId() != 0) throw new GameException("Computer id must be 0, because it's autogenerated");
        if(DaoFactory.computerDao().getAll().contains(computer)) throw new GameException("Kompjuter vec postoji");
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
     * Validate computer.
     *
     * @param computer the computer
     * @throws GameException
     */
    public void validateComputer(Computer computer){
        if(computer.getCPU().equals("") || computer.getGPU().equals("") || computer.getMemory() == 0 || computer.getRAM() == 0)
            throw new GameException("Specifikacije moraju biti unesene");

    }

    /**
     * Delete.
     *
     * @param id the id
     * @throws GameException the game exception
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
