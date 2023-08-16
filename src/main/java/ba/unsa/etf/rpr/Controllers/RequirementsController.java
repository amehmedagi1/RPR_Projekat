package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.domain.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * The type Requirements controller.
 */
public class RequirementsController {
    private Game gameForDisplay;
    /**
     * The Field ram.
     */
    public TextField fieldRam;
    /**
     * The Field hdd.
     */
    public TextField fieldHdd;
    /**
     * The Field cpu.
     */
    public TextField fieldCpu;
    /**
     * The Field gpu.
     */
    public TextField fieldGpu;

    /**
     * Instantiates a new Requirements controller.
     *
     * @param game the game
     */
    public RequirementsController(Game game) {
        gameForDisplay = game;
    }

    /**
     * Initialize.
     */
    @FXML
    public void initialize(){
        fieldRam.setText(String.valueOf(gameForDisplay.getRequiredRAM()));
        fieldHdd.setText(String.valueOf(gameForDisplay.getRequiredMemory()));
        fieldGpu.setText(String.valueOf(gameForDisplay.getRequiredGPU()));
        fieldCpu.setText(String.valueOf(gameForDisplay.getRequiredCPU()));
    }

    /**
     * On action close.
     *
     * @param actionEvent the action event
     */
    public void onActionClose(ActionEvent actionEvent) {
        Stage s = (Stage) fieldCpu.getScene().getWindow();
        s.close();
    }
}
