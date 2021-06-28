package JClashRoyale.Controller;

import java.io.IOException;

import JClashRoyale.Model.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
