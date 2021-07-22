package JClashRoyale.Controller;

import java.io.IOException;
import java.util.Objects;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Player;
import JClashRoyale.Model.SoundSystem;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The type Secondary controller.
 */
public class SecondaryController {

    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private Label cupLabel;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label progressBarLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private ImageView cupIcon;
    @FXML
    private CheckBox SFX;
    @FXML
    private CheckBox music;

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
        cupLabel.setText(Integer.toString(Player.player.getCup()));
        progressBarUpdate(Player.player.getXP());
        showLeague();
        SFX.setSelected(App.sfx);
        music.setSelected(App.music);
    }

    @FXML
    private void switchToPrimary() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("primary");
    }

    @FXML
    private void switchToProfile() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("profileSection");
    }

    @FXML
    private void switchToBattleDeck() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("BattleDeck");
    }

    @FXML
    private void switchToTrainingCamp() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("TrainingCamp");
    }

    @FXML
    private void switchToBattleHistory() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("BattleHistory");
    }

    private void progressBarUpdate(int XP) {
        if (XP <= 300) {
            progressBar.setProgress((double) XP / 300);
            progressBarLabel.setText(Integer.toString(XP) + '/' + "300");
            levelLabel.setText("1");
            Player.player.setLevel(1);
        } else if (XP <= 800) {
            progressBar.setProgress((double) XP / 800);
            progressBarLabel.setText(Integer.toString(XP) + '/' + "800");
            levelLabel.setText("2");
            Player.player.setLevel(2);
        } else if (XP <= 1700) {
            progressBar.setProgress((double) XP / 1700);
            progressBarLabel.setText(Integer.toString(XP) + '/' + "1700");
            levelLabel.setText("3");
            Player.player.setLevel(3);
        } else if (XP <= 3400) {
            progressBar.setProgress((double) XP / 3400);
            progressBarLabel.setText(Integer.toString(XP) + '/' + "3400");
            levelLabel.setText("4");
            Player.player.setLevel(4);
        } else if (XP <= 5900) {
            progressBar.setProgress((double) XP / 5900);
            progressBarLabel.setText(Integer.toString(XP) + '/' + "5900");
            levelLabel.setText("5");
            Player.player.setLevel(5);
        }
    }

    private void showLeague() {
        switch (Player.league) {
            case "BRONZE":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/bronze.png"))));
                break;
            case "SILVER":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/silver.png"))));
                break;
            case "GOLD":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/gold.png"))));
                break;
            case "MASTER":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/master.png"))));
                break;
            case "ROYALE CHAMPION":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/royale_champion.png"))));
                break;
            case "ULTIMATE CHAMPION":
                cupIcon.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/ultimate_champion.png"))));
                break;
        }

    }

    /**
     * Update sfx.
     */
    public void updateSFX() {
        App.sfx = SFX.isSelected();
    }

    /**
     * Update music.
     */
    public void updateMusic() {
        App.music = music.isSelected();
        SoundSystem.updateMusic();
    }
}