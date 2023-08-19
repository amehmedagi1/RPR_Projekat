package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ComputerManager;
import ba.unsa.etf.rpr.Business.GameManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Computer;
import ba.unsa.etf.rpr.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.image.Image;


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
        boolean unesene = true;
        if(fldRam.getText().equals("") || fldHdd.getText().equals("")){
            fldRam.setText("0");
            fldHdd.setText("0");
        }
        if(fldRam.getText().equals("0") || fldHdd.getText().equals("") || fldCpu.getText().equals("") || fldGpu.getText().equals("")) unesene = false;
        Computer computer = new Computer();
        computer.setCPU(fldCpu.getText());
        computer.setGPU(fldGpu.getText());
        computer.setRAM(Integer.parseInt(fldRam.getText()));
        computer.setMemory(Integer.parseInt(fldHdd.getText()));
        ComputerManager manager = new ComputerManager();
        ArrayList<Computer> allComps = new ArrayList<>(DaoFactory.computerDao().getAll());
        ArrayList<Computer> listOfComputers = new ArrayList<>(DaoFactory.computerDao().searchByComputerSpecification(computer));
        if (listOfComputers.size() == 0) {
            listOfComputers.add(computer);
        }
            if (unesene == false) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/ICONS/creeper.png"));
                alert.setTitle("NO SPECS");
                alert.setHeaderText("Warning!");
                alert.setContentText("You must enter your pc specifications in order to see the games it can run!");
                alert.showAndWait();
            }
            ArrayList<Game> games = new ArrayList<>(DaoFactory.gameDao().getAll());
            ArrayList<Game> compatibleGames = new ArrayList<>();
            boolean printed = false;
            for (int i = 0; i < games.size(); i++) {
                if (computer.getCPU().toLowerCase().equals(games.get(i).getRequiredCPU().toLowerCase()) && computer.getRAM() >= games.get(i).getRequiredRAM() && computer.getGPU().toLowerCase().equals(games.get(i).getRequiredGPU().toLowerCase()) && computer.getMemory() >= games.get(i).getRequiredMemory()) {
                    compatibleGames.add(games.get(i));
                    printed = true;

                } else if (i == games.size() - 1 && printed == false && unesene == true) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/ICONS/creeper.png"));
                    alert.setTitle("NO GAMES FOUND");
                    alert.setHeaderText("Warning!");
                    alert.setContentText("No games were found for your specifications");
                    alert.showAndWait();
                    System.out.println("proslo prvo");
                }
            }
            if (printed == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/ICONS/creeper.png"));
                alert.setTitle("Compatible games");
                alert.setHeaderText("We found the games your pc can run");
                alert.setContentText("Games your pc can run are:");
                String ispis = "";
                for (int i = 0; i < compatibleGames.size(); i++) {
                    ispis += compatibleGames.get(i).getGameTitle() + " \n";

                }
                alert.setContentText(ispis);
                alert.showAndWait();
            }
    }

    public void openDialog(String title, String fxml, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.getIcons().add(new Image("/ICONS/creeper.png"));
            stage.show();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
