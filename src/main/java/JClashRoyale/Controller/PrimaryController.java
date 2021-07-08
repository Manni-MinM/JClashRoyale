package JClashRoyale.Controller;

import java.io.IOException;


import JClashRoyale.Model.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class PrimaryController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private Label messageLabel;

    private double x, y;

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



    public void loginFailure(){
        messageLabel.setTextFill(Color.web("#d91414"));
        messageLabel.setText("Incorrect Username/Password, Please register first.");
    }

    public void loginSuccess(){
        messageLabel.setTextFill(Color.web("#28C76F"));
        messageLabel.setText("Logged in successfully.");
    }

    public void registerFailure(){
        messageLabel.setTextFill(Color.web("#d91414"));
        messageLabel.setText("Registration failed. The username has already been taken.");
    }

    public void registerSuccess(){
        messageLabel.setTextFill(Color.web("#28C76F"));
        messageLabel.setText("Registered successfully.");
    }
}
