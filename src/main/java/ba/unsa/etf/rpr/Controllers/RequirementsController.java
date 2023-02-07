package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RequirementsController {
    private Game gameForDisplay;
    public TextField fldRam;
    public TextField fldHdd;
    public TextField fldCpu;
    public TextField fldGpu;

    public RequirementsController(Game game) {
        gameForDisplay = game;
    }
    @FXML
    public void initialize() {
        fldRam.setText(String.valueOf(gameForDisplay.getRequiredRAM()));
        fldHdd.setText(String.valueOf(gameForDisplay.getRequiredMemory()));
        fldGpu.setText(String.valueOf(gameForDisplay.getRequiredGPU()));
        fldCpu.setText(String.valueOf(gameForDisplay.getRequiredCPU()));
    }

    public void onActionClose(ActionEvent actionEvent) {
        Stage s = (Stage) fldCpu.getScene().getWindow();
        s.close();
    }
}
