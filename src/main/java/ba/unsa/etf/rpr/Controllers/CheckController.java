package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CheckController {

    public TextField fldRam;
    public TextField fldHdd;
    public TextField fldCpu;
    public TextField fldGpu;
    public CheckController() {}
    public void onActionSubmit(ActionEvent actionEvent) {
        Computer computer = new Computer();
        computer.setCPU(fldCpu.getText());
        computer.setGPU(fldGpu.getText());
        computer.setRAM(Integer.parseInt(fldRam.getText()));
        computer.setMemory(Integer.parseInt(fldHdd.getText()));
        ArrayList<Computer> listOfComputers = new ArrayList<>(DaoFactory.computerDao().searchByComputerSpecification(computer));
        if(listOfComputers.size() == 0) {
            DaoFactory.computerDao().add(computer);
            System.out.println("Kompjuter dodan");
        }else {
            System.out.println("Nema nista");
        }
        System.out.println(computer);
    }
}
