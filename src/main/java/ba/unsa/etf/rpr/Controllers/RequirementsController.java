package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RequirementsController {
    private Game gameForDisplay;
    public TextField fieldRam;
    public TextField fieldHdd;
    public TextField fieldCpu;
    public TextField fieldGpu;

    public RequirementsController(Game game) {
        gameForDisplay = game;
    }
    @FXML
    public void initialize() {
        fieldRam.setText(String.valueOf(gameForDisplay.getRequiredRAM()));
        fieldHdd.setText(String.valueOf(gameForDisplay.getRequiredMemory()));
        fieldGpu.setText(String.valueOf(gameForDisplay.getRequiredGPU()));
        fieldCpu.setText(String.valueOf(gameForDisplay.getRequiredCPU()));
    }

    public void onActionClose(ActionEvent actionEvent) {
        Stage s = (Stage) fieldCpu.getScene().getWindow();
        s.close();
    }
}
