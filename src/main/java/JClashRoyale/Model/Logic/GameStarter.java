// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import javafx.scene.control.ProgressBar;
import javafx.stage.Stage ;

import javafx.scene.paint.Color ;
import javafx.scene.layout.Pane ;
import javafx.scene.control.TextField;
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
	// Methods : Getters
	public GameManager getGameManager() {
		return this.gameManager ;
	}
	// Methods : Other
	public void initBattle(TextField timer , TextField result , TextField elixer , ProgressBar elixerBar, Pane battleViewPane) {
		gameManager.setBattleMap(BATTLE_MAP_PATH) ;

		Canvas canvas = gameManager.getCanvas() ;
		GraphicsContext graphics = gameManager.getGraphics() ;

		battleViewPane.getChildren().add(canvas) ;

		gameManager.update(timer , result , elixer , elixerBar) ;
	}
}

