package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

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
           // computer.setId(DaoFactory.computerDao().getAll().size()+1);
            DaoFactory.computerDao().add(computer);
        }else {
            System.out.println("Nema nista");
        }
        System.out.println(computer);
        /*ArrayList<Game> games = new ArrayList<>(DaoFactory.gameDao().getAll());
        for(int i = 0; i < games.size(); i++){
            if(computer.getCPU().equals(games.get(i).getRequiredCPU()) && computer.getRAM() >= games.get(i).getRequiredRAM() && computer.getGPU().equals(games.get(i).getRequiredGPU()) && computer.getMemory() >= games.get(i).getRequiredMemory())
                System.out.println(games.get(i).toString());
        }*/
    }

    public void openDialog(String title, String fxml, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.show();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
