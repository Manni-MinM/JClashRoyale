module JClashRoyale {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    exports JClashRoyale.Model;
    opens JClashRoyale.Model to javafx.fxml;
    exports JClashRoyale.Controller;
    opens JClashRoyale.Controller to javafx.fxml;
}