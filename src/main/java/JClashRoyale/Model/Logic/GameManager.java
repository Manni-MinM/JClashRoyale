// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.ArrayList ;
import java.util.Objects;

import javafx.animation.AnimationTimer ;

import javafx.scene.image.Image ;
import javafx.scene.paint.Color ;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Sprite ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;

import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

import JClashRoyale.Model.Elements.Sprites.Troops.Giant ;
import JClashRoyale.Model.Elements.Sprites.Troops.Wizard ;
import JClashRoyale.Model.Elements.Sprites.Troops.Archer ;
import JClashRoyale.Model.Elements.Sprites.Troops.Valkyrie ;
import JClashRoyale.Model.Elements.Sprites.Troops.Barbarian ;
import JClashRoyale.Model.Elements.Sprites.Troops.MiniPekka ;
import JClashRoyale.Model.Elements.Sprites.Troops.BabyDragon ;

import JClashRoyale.Model.Elements.Sprites.Buildings.Cannon ;
import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower ;

public class GameManager {
	// Fields
	private int elixer ;
	
	private Image battleMap ;

	private Canvas canvas ;
	private GraphicsContext graphics ;

	private ArrayList<Sprite> sprites ;
	// Constructor
	public GameManager() {
		elixer = 0 ;

		canvas = new Canvas(315 , 480) ;
		graphics = canvas.getGraphicsContext2D() ;

		sprites = new ArrayList<Sprite>() ;
	}
	// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))) ;
	}
	public void consumeElixer(int value) {
		this.elixer -= value ;
	}
	// Methods : Getters
	public int getElixer() {
		return this.elixer ;
	}
	public Canvas getCanvas() {
		return this.canvas ;
	}
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}
	// Methods : Private
	private boolean canAttack(Sprite attacker , Sprite defender) {
		if ( attacker.getColorType() == defender.getColorType() )
			return false ;
		if ( !attacker.rangeIntersects(defender.getHealthCircle()) )
			return false ;
		return (attacker.getTargetType() == TroopType.ALL || attacker.getTargetType() == defender.getTroopType()) ;
	}
	// Methods : Other
	public void addSprite(Sprite sprite) {
		sprites.add(sprite) ;
	}
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}
	public void update(TextField timerField , TextField resultField , TextField elixerField) {
		final long startNanoTime = System.nanoTime() ;
		new AnimationTimer() {
			int timeOffset = 0 ;
			int frameCount = 0 ;
			public void handle(long currentNanoTime) {
				double elixerTime = ((currentNanoTime - startNanoTime) / 1000000000.0) - timeOffset ;

				if ( elixerTime >= 1.0 ) {
					timeOffset ++ ;
					elixer = Math.min(elixer + 1 , 10) ;
				} else {
					// Pass
				}
				elixerField.setText(String.valueOf(elixer)) ;

				loadBattleMap() ;
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

				for ( Sprite sprite : sprites ) {
//					sprite.showRangeCircle(graphics) ;
//					sprite.showHealthCircle(graphics) ;
					sprite.draw(graphics) ;
				}
				// TODO : Test Run
				ArrayList<Sprite> toBeRemoved = new ArrayList<Sprite>() ;
				for ( int it = 0 ; it < sprites.size() ; it ++ )
					for ( int jt = 0 ; jt < sprites.size() ; jt ++ ) {
						if ( it == jt )
							continue ;
						Sprite attacker = sprites.get(it) ;
						Sprite defender = sprites.get(jt) ;
						if ( canAttack(attacker , defender) )
							toBeRemoved.add(defender) ;
					}
				for ( Sprite sprite : toBeRemoved )
						sprites.remove(sprite) ;

				frameCount = (frameCount + 1) % 60 ;
			}
		}.start() ;
	}
}

