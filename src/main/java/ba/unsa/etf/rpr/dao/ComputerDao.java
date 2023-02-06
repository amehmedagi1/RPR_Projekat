package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Computer;

import java.util.List;

public interface ComputerDao extends Dao<Computer>{
    List<Computer> searchByComputerSpecification(Computer computer);
}
