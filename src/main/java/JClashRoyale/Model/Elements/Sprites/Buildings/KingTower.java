// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

import java.util.Objects;

public class KingTower extends Building {
	// Fields : Final
	private final double RANGE_RADIUS = 210.0 ;
	private final double HEALTH_RADIUS = 95.0 ;

	private final double RUN_SPEED = 0.0 ;
	private final double ATTACK_SPEED = 1 ;
	private final TroopType TROOP_TYPE = TroopType.BUILDING ;
	private final TroopType TARGET_TYPE = TroopType.ALL ;

	private final double WIDTH = 70.0 ;
	private final double HEIGHT = 75.0 ;

	private final String RED_TOWER_PATH = "/JClashRoyale/assets/sprites/king_tower/king_tower_red.png" ;
	private final String BLUE_TOWER_PATH = "/JClashRoyale/assets/sprites/king_tower/king_tower_blue.png" ;

	private final String DESTROYED_TOWER_PATH = "/JClashRoyale/assets/sprites/king_tower/king_tower_destroyed.png" ;
	// Fields : Other
	private boolean isDestroyed ;

	private Image tower ;
	private Image destroyedTower ;
	// Constructor
	public KingTower(ColorType color) {
		isDestroyed = false ;

		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setRunSpeed(RUN_SPEED) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setTower(RED_TOWER_PATH) ;
		} else if ( color == ColorType.BLUE ) {
			setTower(BLUE_TOWER_PATH) ;
		} else {
			// Pass
		}
		setDestroyedTower(DESTROYED_TOWER_PATH) ;

		setStateImage(tower) ;
	}
	// Methods : Setters
	private void setTower(String path) {
		this.tower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false) ;
	}
	private void setDestroyedTower(String path) {
		this.destroyedTower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false);
	}
	// Methods : Getters

	// Methods : Other
	public void destroy() {
		isDestroyed = true ;
		setRangeCircleRadius(0) ;
		setHealthCircleRadius(0) ;
		removeRangeCircle() ;
		removeHealthCircle() ;
	}
	public void draw(GraphicsContext graphics) {
		if ( isDestroyed ) {
			setStateImage(destroyedTower) ;
		} else if ( attackState ) {
			setStateImage(tower) ;
		} else {
			setStateImage(tower) ;
		}

		graphics.drawImage(stateImage , getX() , getY()) ;
	}
}

