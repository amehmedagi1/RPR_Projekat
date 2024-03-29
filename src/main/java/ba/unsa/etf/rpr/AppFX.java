package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.Controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * The type App fx.
 */
public class AppFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home-layout.fxml"));
        HomeController homeController = new HomeController();
        fxmlLoader.setController(homeController);
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setTitle("Game specs v1.0");
        stage.getIcons().add(new Image("/ICONS/creeper.png"));
        stage.show();
    }
}
