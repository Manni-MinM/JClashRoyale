package JClashRoyale.Controller;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Player;
import JClashRoyale.Model.SoundSystem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Training camp controller.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /11/2021
 */
public class TrainingCampController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;

    private double x, y;

    /**
     * Init.
     *
     * @param stage the stage
     */
    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }

    @FXML
    private void switchToSecondary() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("secondary");
    }

    @FXML
    private void switchToIdiotAI() throws IOException {
        if (App.music) SoundSystem.stopMainMenuMusic();
        SoundSystem.mouseClickSFX();
        App.setRoot("battle");
    }

    @FXML
    private void switchToAdvancedAI() throws IOException {
        if (App.music) SoundSystem.stopMainMenuMusic();
        App.advancedAI = true;
        SoundSystem.mouseClickSFX();
        App.setRoot("battle");
    }

}
