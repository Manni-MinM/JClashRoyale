// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.ArrayList ;
import java.util.Objects;

import JClashRoyale.Controller.BattleController;
import javafx.animation.AnimationTimer ;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image ;
import javafx.scene.paint.Color ;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Spell ;
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

	private ArrayList<Spell> spells ;
	private ArrayList<Sprite> sprites ;
	// Constructor
	public GameManager() {
		elixer = 0 ;

		canvas = new Canvas(315 , 480) ;
		graphics = canvas.getGraphicsContext2D() ;

		spells = new ArrayList<Spell>() ;
		sprites = new ArrayList<Sprite>() ;
	}
	// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))) ;
	}
	public void consumeElixer(int value) {
		this.elixer -= value ;
		BattleController.updateAvailability(elixer);
	}
	// Methods : Getters
	public int getElixer() {
		return elixer ;
	}
	public Canvas getCanvas() {
		return this.canvas ;
	}
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}
	// Methods : Private
	private void attack(Sprite attacker , Sprite defender) {
	}
	// Methods : Other
	public void addSprite(Sprite sprite) {
		sprites.add(sprite) ;
	}
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}
	public void update(TextField timerField , TextField resultField , TextField elixerField , ProgressBar elixerBar) {
		final long startNanoTime = System.nanoTime() ;
		new AnimationTimer() {
			int timeOffset = 0 ;
			int frameCount = 0 ;
			public void handle(long currentNanoTime) {
				double timeNow = ((currentNanoTime - startNanoTime) / 1000000000.0) ;
				double elixerTime = timeNow - timeOffset ;

				if ( elixerTime >= 1.0 ) {
					timeOffset ++ ;
					elixer = Math.min(elixer + 1 , 10) ;
				} else {
					// Pass
				}

				elixerField.setText(String.valueOf(elixer)) ;
				elixerBar.setProgress(elixer / 10.0);
				BattleController.updateAvailability(elixer);

				loadBattleMap() ;
				elixerField.setText(String.valueOf(elixer)) ;

				ArrayList<Sprite> walkingSprites = new ArrayList<Sprite>() ;
				ArrayList<Sprite> attackingSprites = new ArrayList<Sprite>() ;

				for ( Sprite sprite : sprites ) {
					if ( sprite.getAttackState() ) {
						attackingSprites.add(sprite) ;
					} else {
						walkingSprites.add(sprite) ;
					}
				}

				for ( Sprite sprite : walkingSprites )
					sprite.walk(frameCount) ;

				ArrayList<Sprite> toBeRemoved = new ArrayList<Sprite>() ;
				for ( int it = 0 ; it < sprites.size() ; it ++ ) {
					Sprite attacker = sprites.get(it) ;
					ArrayList<Sprite> defenders = new ArrayList<Sprite>() ;
					for ( int jt = 0 ; jt < sprites.size() ; jt ++ ) {
						if ( it == jt )
							continue ;
						Sprite defender = sprites.get(jt) ;
						if ( attacker.canAttack(defender) ) {
							defenders.add(defender) ;
							if ( attacker instanceof SingleTargetTroop ) {
								break ;
							} else {
								// Pass
							}
						}
					}
					if ( defenders.isEmpty() ) {
						attacker.setAttackState(false) ;
					} else if ( timeNow - attacker.getLastAttack() > attacker.getAttackSpeed() ) {
						attacker.attack(defenders) ;
						attacker.setLastAttack(timeNow) ;
						for ( Sprite defender : defenders ) {
							if ( defender.getHitpoints() <= 0 ) {
								attacker.setAttackState(false) ;
								toBeRemoved.add(defender) ;
							} else {
								// Pass
							}
						}
					} else {
						// Pass
					}
				}
				for ( Sprite sprite : toBeRemoved )
						sprites.remove(sprite) ;

				for ( Sprite sprite : sprites ) {
//					sprite.showRangeCircle(graphics) ;
//					sprite.showHealthCircle(graphics) ;
					sprite.draw(graphics) ;
				}

				frameCount = (frameCount + 1) % 60 ;
			}
		}.start() ;
	}
}

