// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import javafx.scene.image.Image ;
import javafx.scene.paint.Color ;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

public class GameManager {
	// Fields
	private Image battleMap ;

	private Canvas canvas ;
	private GraphicsContext graphics ;
	// Constructor
	public GameManager() {
		canvas = new Canvas(315 , 480) ;
		graphics = canvas.getGraphicsContext2D() ;
	}
	// Methods : Private
	
	// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(path) ;
	}
	// Methods : Getters
	public Canvas getCanvas() {
		return this.canvas ;
	}
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}
	// Methods : Other
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}
	public void update() {
		// TODO
	}
}

