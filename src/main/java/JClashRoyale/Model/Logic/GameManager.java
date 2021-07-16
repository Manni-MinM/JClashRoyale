// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.ArrayList ;
import java.util.Objects;

import javafx.animation.AnimationTimer ;

import javafx.scene.image.Image ;
import javafx.scene.paint.Color ;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Sprite ;

import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

import JClashRoyale.Model.Elements.Sprites.Troops.Giant ;
import JClashRoyale.Model.Elements.Sprites.Troops.Wizard ;
import JClashRoyale.Model.Elements.Sprites.Troops.Archer ;
import JClashRoyale.Model.Elements.Sprites.Troops.Valkyrie ;
import JClashRoyale.Model.Elements.Sprites.Troops.Barbarian ;
import JClashRoyale.Model.Elements.Sprites.Troops.MiniPekka ;
import JClashRoyale.Model.Elements.Sprites.Troops.BabyDragon ;

public class GameManager {
	// Fields
	private Image battleMap ;

	private Canvas canvas ;
	private GraphicsContext graphics ;

	private ArrayList<Sprite> sprites ;
	// Constructor
	public GameManager() {
		canvas = new Canvas(315 , 480) ;
		graphics = canvas.getGraphicsContext2D() ;

		sprites = new ArrayList<Sprite>() ;
	}
	// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))) ;
	}
	// Methods : Getters
	public Canvas getCanvas() {
		return this.canvas ;
	}
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}
	// Methods : Private
	
	// Methods : Other
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}
	public void update() {
		// TODO
		Archer archer = new Archer() ;
		archer.setLocation(75 , 75) ;
		sprites.add(archer) ;

		BabyDragon babyDragon = new BabyDragon() ;
		babyDragon.setLocation(175 , 75) ;
		sprites.add(babyDragon) ;

		final long startNanoTime = System.nanoTime() ;
		new AnimationTimer() {
			int frameCount = 0 ;
			boolean found = false ;
			public void handle(long currentNanoTime) {
				double t = (currentNanoTime - startNanoTime) / 1000000000.0 ;

				for ( Sprite sprite : sprites ) {
					if ( sprite instanceof AreaSplashTroop ) {
						AreaSplashTroop troop = (AreaSplashTroop)sprite ;
						troop.walk(frameCount) ;
					} else if ( sprite instanceof SingleTargetTroop ) {
						SingleTargetTroop troop = (SingleTargetTroop)sprite ;
						troop.walk(frameCount) ;
					} else {
						// Pass
					}
				}

				loadBattleMap() ;
				for ( Sprite sprite : sprites )
					graphics.drawImage(sprite.getStateImage() , sprite.getX() , sprite.getY()) ;

				if ( !found && t > 4.0 ) {
					Giant giant = new Giant() ;
					giant.setLocation(275 , 75) ;
					sprites.add(giant) ;
					found = true ;
				}

				frameCount = (frameCount + 1) % 60 ;
			}
		}.start() ;
	}
}

