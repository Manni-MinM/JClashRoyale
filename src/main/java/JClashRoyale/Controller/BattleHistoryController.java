package JClashRoyale.Controller;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Database;
import JClashRoyale.Model.Player;
import JClashRoyale.Model.SoundSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * The type Battle history controller.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /20/2021
 */
public class BattleHistoryController {
    private double x, y;

    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private GridPane gridPane;
    @FXML
    private PieChart pieChart;
    @FXML
    private Label WLlabel;

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
        Label player = new Label("Player");
        alignLabel(player);
        player.setAlignment(Pos.CENTER);
        player.setTextFill(Color.YELLOW);
        gridPane.add(player, 0, 0);
        Label opponent = new Label("Opponent");
        alignLabel(opponent);
        opponent.setAlignment(Pos.CENTER);
        opponent.setTextFill(Color.YELLOW);
        gridPane.add(opponent, 1, 0);
        Label playerScore = new Label("Player Score");
        alignLabel(playerScore);
        playerScore.setAlignment(Pos.CENTER);
        playerScore.setTextFill(Color.YELLOW);
        gridPane.add(playerScore, 2, 0);
        Label opponentScore = new Label("Opponent Score");
        alignLabel(opponentScore);
        opponentScore.setAlignment(Pos.CENTER);
        opponentScore.setTextFill(Color.YELLOW);
        gridPane.add(opponentScore, 3, 0);
        try {
            setResults(Objects.requireNonNull(Database.getBattleResult(Player.player.getUsername())));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        SoundSystem.mouseClickSFX();
        App.setRoot("secondary");
    }

    private void setResults(ResultSet resultSet) throws SQLException {
        int i = 1;
        int winCount = 0;
        do {
            Label player = new Label(resultSet.getString(2));
            alignLabel(player);
            player.setAlignment(Pos.CENTER);
            player.setTextFill(Color.WHITE);
            gridPane.add(player, 0, i);
            Label opponent = new Label(resultSet.getString(3));
            alignLabel(opponent);
            opponent.setAlignment(Pos.CENTER);
            opponent.setTextFill(Color.WHITE);
            gridPane.add(opponent, 1, i);
            Label playerScore = new Label(String.valueOf(resultSet.getInt(4)));
            alignLabel(playerScore);
            playerScore.setAlignment(Pos.CENTER);
            playerScore.setTextFill(Color.WHITE);
            gridPane.add(playerScore, 2, i);
            Label opponentScore = new Label(String.valueOf(resultSet.getInt(5)));
            alignLabel(opponentScore);
            opponentScore.setAlignment(Pos.CENTER);
            opponentScore.setTextFill(Color.WHITE);
            gridPane.add(opponentScore, 3, i);

            i++;
            if (resultSet.getBoolean(6)) winCount++;
        } while (resultSet.next());
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Win", (double) winCount / (i - 1)),
                new PieChart.Data("Loss", (double) (i - 1 - winCount) / (i - 1)));
        WLlabel.setText("Win/Loss : " +(int)((double) winCount / (i - 1) * 100) + "%");
        WLlabel.setTextFill(Color.WHITE);
        pieChart.setData(pieChartData);


    }

    private void alignLabel(Label label) {
        GridPane.setFillWidth(label, true);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER_RIGHT);
        GridPane.setHalignment(label, HPos.RIGHT);
    }


}
