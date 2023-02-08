package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;

import java.util.List;

/**
 * The interface Computer dao.
 */
public interface ComputerDao extends Dao<Computer>{
    /**
     * Search by computer specification list.
     *
     * @param computer the computer
     * @return the list
     */
    List<Computer> searchByComputerSpecification(Computer computer);
}
