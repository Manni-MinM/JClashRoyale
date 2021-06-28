package JClashRoyale.Controller;

import java.io.IOException;

import JClashRoyale.Model.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}