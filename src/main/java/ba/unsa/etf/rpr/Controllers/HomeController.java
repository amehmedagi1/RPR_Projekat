package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Game;
import ba.unsa.etf.rpr.domain.Genre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Date;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * The type Home controller.
 */
public class HomeController {
    /**
     * The Btn check.
     */
    public Button btnCheck;
    /**
     * The Tv games.
     */
    public TableView<Game> tvGames;
    /**
     * The Lv genres.
     */
    public ListView<Genre> lvGenres;
    /**
     * The Title column.
     */
    public TableColumn<Game, String> titleColumn = new TableColumn<>();
    /**
     * The Release date.
     */
    public TableColumn<Game, Date> releaseDate = new TableColumn<>();
    private ObservableList<Game> games = FXCollections.observableArrayList();
    private ObservableList<Genre> genres = FXCollections.observableArrayList();

    /**
     * Instantiates a new Home controller.
     */
    public HomeController() {
        genres.addAll(DaoFactory.genreDao().getAll());
    }

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("gameTitle"));
        releaseDate.setCellValueFactory(new PropertyValueFactory<Game, Date>("releaseDate"));
        lvGenres.setItems(genres);
        lvGenres.getSelectionModel().selectFirst();

        lvGenres.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            tvGames.getItems().clear();
            games.clear();
            games.addAll(DaoFactory.gameDao().getGamesWithGenreId(lvGenres.getSelectionModel().getSelectedItem()));
            System.out.println(games);
            tvGames.setItems(games);
        });

    }


    /**
     * On action requirements.
     *
     * @param actionEvent the action event
     */
    public void onActionRequirements(ActionEvent actionEvent){
        openDialog("Requirements page","/fxml/requirements-layout.fxml", new RequirementsController(tvGames.getSelectionModel().getSelectedItem()));
    }

    /**
     * On action check.
     *
     * @param actionEvent the action event
     */
    public void onActionCheck(ActionEvent actionEvent) {
        openDialog("Check dialog", "/fxml/check-layout.fxml", new CheckController());

    }


    /**
     * Open dialog.
     *
     * @param title      the title
     * @param fxml       the fxml
     * @param controller the controller
     */
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
