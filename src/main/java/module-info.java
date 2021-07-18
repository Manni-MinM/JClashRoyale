module JClashRoyale {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;
    requires java.desktop;

    exports JClashRoyale.Model;
    opens JClashRoyale.Model to javafx.fxml;
    exports JClashRoyale.Controller;
    opens JClashRoyale.Controller to javafx.fxml;
}