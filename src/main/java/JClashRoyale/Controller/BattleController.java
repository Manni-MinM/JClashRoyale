package JClashRoyale.Controller ;

import java.io.IOException ;

import javafx.fxml.FXML ;

import javafx.stage.Stage ;

import javafx.event.ActionEvent ;

import javafx.scene.layout.Pane ;
import javafx.scene.image.ImageView ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField ;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;
import javafx.scene.paint.Color ;

public class BattleController {

	@FXML private Pane titlePane ;
	@FXML private ImageView btnMinimize , btnClose ;
	@FXML private Label messageLabel ;

	@FXML private TextField elixer ;
	@FXML private TextField result ;
	@FXML private TextField timer ;

	@FXML private Pane gameViewPane ;

	@FXML private Pane deckViewPane ;

	private double x , y;

	public void init(Stage stage) {
		titlePane.setOnMousePressed(mouseEvent -> {
			x = mouseEvent.getSceneX() ;
			y = mouseEvent.getSceneY() ;
		});
		titlePane.setOnMouseDragged(mouseEvent -> {
			stage.setX(mouseEvent.getScreenX() - x) ;
			stage.setY(mouseEvent.getScreenY() - y) ;
		});

		btnClose.setOnMouseClicked(mouseEvent -> stage.close()) ;
		btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true)) ;
	
		// TODO
		Canvas canvas = new Canvas(315 , 480) ;
		GraphicsContext graphics = canvas.getGraphicsContext2D() ;

		gameViewPane.getChildren().add(canvas) ;
	}
}

