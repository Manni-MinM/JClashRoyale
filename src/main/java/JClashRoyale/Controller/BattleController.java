// BWOTSHEWCHB

package JClashRoyale.Controller ;

import javafx.fxml.FXML ;

import javafx.stage.Stage ;

import javafx.event.ActionEvent ;

import javafx.scene.layout.Pane ;
import javafx.scene.image.ImageView ;
import javafx.scene.control.Label ;
import javafx.scene.control.TextField ;

import JClashRoyale.Model.Logic.GameStarter ;

public class BattleController {
	// Fields
	double x , y ;

	GameStarter gameStarter ;

	@FXML private Pane titlePane ;
	@FXML private TextField timer ;
	@FXML private TextField result ;
	@FXML private TextField elixer ;
	@FXML private Label messageLabel ;
	@FXML private Pane deckViewPane ;
	@FXML private Pane gameViewPane ;
	@FXML private ImageView btnMinimize , btnClose ;
	// Methods
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
	}
	public void start() {
		gameStarter = new GameStarter() ;

		gameStarter.initDeck(deckViewPane) ;
		gameStarter.initBattle(gameViewPane) ;
	}
}

