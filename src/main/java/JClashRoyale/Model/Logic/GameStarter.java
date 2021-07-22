// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Rectangle;

import javafx.scene.layout.Pane ;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

/**
 * The type Game starter.
 */
public class GameStarter {
    /**
     * The Game manager.
     */
// Fields
	GameManager gameManager ;
    /**
     * The Battle map path.
     */
// Fields : Final
	String BATTLE_MAP_PATH = "/JClashRoyale/assets/map.png" ;

    /**
     * Instantiates a new Game starter.
     */
// Constructor
	public GameStarter() {
		gameManager = new GameManager() ;
	}

    /**
     * Gets game manager.
     *
     * @return the game manager
     */
// Methods : Getters
	public GameManager getGameManager() {
		return this.gameManager ;
	}

    /**
     * Init battle.
     *
     * @param timer          the timer
     * @param elixer         the elixer
     * @param elixerBar      the elixer bar
     * @param battleViewPane the battle view pane
     * @param endGame        the end game
     * @param resultLabel    the result label
     * @param backButton     the back button
     */
// Methods : Other
	public void initBattle(TextField timer , TextField elixer , ProgressBar elixerBar, Pane battleViewPane
	, Rectangle endGame, Label resultLabel, Button backButton) {
		gameManager.setBattleMap(BATTLE_MAP_PATH) ;

		Canvas canvas = gameManager.getCanvas() ;
		GraphicsContext graphics = gameManager.getGraphics() ;

		battleViewPane.getChildren().add(canvas) ;

		gameManager.update(timer , elixer , elixerBar , endGame , resultLabel , backButton) ;
	}
}

