package JClashRoyale.Controller;

import java.io.IOException;


import JClashRoyale.Model.App;
import JClashRoyale.Model.Database;
import JClashRoyale.Model.SoundSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * The type Primary controller.
 */
public class PrimaryController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

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
        App.setRoot("secondary");
    }


    /**
     * Login button on action.
     *
     * @param e the e
     */
    public void loginButtonOnAction(ActionEvent e) {
        SoundSystem.mouseClickSFX();
        if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank()) {
            blankCredentials();
            return;
        }
        if (Database.successfulLogin(usernameTextField.getText(),passwordPasswordField.getText())) {
            loginSuccess();
            try {
                SoundSystem.mainMenuTheme();
                switchToSecondary();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else
            loginFailure();
    }

    /**
     * Register button on action.
     *
     * @param e the e
     */
    public void registerButtonOnAction(ActionEvent e) {
        SoundSystem.mouseClickSFX();
        if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank()) {
            blankCredentials();
            return;
        }
        if (Database.registerDone(usernameTextField.getText(), passwordPasswordField.getText()))
            registerSuccess();
        else
            registerFailure();
    }

    private void blankCredentials() {
        messageLabel.setTextFill(Color.web("#d91414"));
        messageLabel.setText("Please fill all required fields.");
    }

    private void loginFailure() {
        messageLabel.setTextFill(Color.web("#d91414"));
        messageLabel.setText("Incorrect Username/Password, \nPlease register first.");
    }

    private void loginSuccess() {
        messageLabel.setTextFill(Color.web("#28C76F"));
        messageLabel.setText("Logged in successfully.");
    }

    private void registerFailure() {
        messageLabel.setTextFill(Color.web("#d91414"));
        messageLabel.setText("Registration failed. The username \nhas already been taken.");
    }

    private void registerSuccess() {
        messageLabel.setTextFill(Color.web("#28C76F"));
        messageLabel.setText("Registered successfully.");
    }


}
