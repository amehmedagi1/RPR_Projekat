package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Check controller.
 */
public class CheckController {

    /**
     * The Fld ram.
     */
    public TextField fldRam;
    /**
     * The Fld hdd.
     */
    public TextField fldHdd;
    /**
     * The Fld cpu.
     */
    public TextField fldCpu;
    /**
     * The Fld gpu.
     */
    public TextField fldGpu;

    /**
     * Instantiates a new Check controller.
     */
    public CheckController() {}

    /**
     * On action submit.
     *
     * @param actionEvent the action event
     */
    public void onActionSubmit(ActionEvent actionEvent) {
        Computer computer = new Computer();
        computer.setCPU(fldCpu.getText());
        computer.setGPU(fldGpu.getText());
        computer.setRAM(Integer.parseInt(fldRam.getText()));
        computer.setMemory(Integer.parseInt(fldHdd.getText()));
        computer.setGameID(2);
        ArrayList<Computer> listOfComputers = new ArrayList<>(DaoFactory.computerDao().searchByComputerSpecification(computer));
        if(listOfComputers.size() == 0) {
            computer.setId(DaoFactory.computerDao().getAll().size()+1);
            DaoFactory.computerDao().add(computer);
        }else {
            System.out.println("Nema nista");
        }
        System.out.println(computer);
    }
}
