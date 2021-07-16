// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import javafx.stage.Stage ;

import javafx.scene.paint.Color ;
import javafx.scene.layout.Pane ;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Logic.GameManager ;

public class GameStarter {
	// Fields
	GameManager gameManager ;
	// Fields : Final
	String BATTLE_MAP_PATH = "/JClashRoyale/assets/battle_map.png" ;
	// Constructor
	public GameStarter() {
		gameManager = new GameManager() ;
	}
	// Methods
	public void initDeck(Pane deckViewPane) {
		// TODO
	}
	public void initBattle(Pane battleViewPane) {
		gameManager.setBattleMap(BATTLE_MAP_PATH) ;

		Canvas canvas = gameManager.getCanvas() ;
		GraphicsContext graphics = gameManager.getGraphics() ;

		battleViewPane.getChildren().add(canvas) ;

		// TODO
//		gameManager.update() ;
	}
}

