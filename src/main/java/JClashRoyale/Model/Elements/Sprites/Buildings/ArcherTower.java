// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

import java.util.Objects;

public class ArcherTower extends Building {
	// Fields : Final
	private final double RANGE_RADIUS = 225.0 ;
	private final double HEALTH_RADIUS = 80.0 ;

	private final double RUN_SPEED = 0.0 ;
	private final double ATTACK_SPEED = 0.8 ;
	private final TroopType TROOP_TYPE = TroopType.BUILDING ;
	private final TroopType TARGET_TYPE = TroopType.ALL ;

	private final double WIDTH = 60.0 ;
	private final double HEIGHT = 65.0 ;

	private final String RED_IDLE_TOWER_PATH = "/JClashRoyale/assets/sprites/archer_tower/archer_tower_red_idle.png" ;
	private final String RED_BATTLE_TOWER_PATH = "/JClashRoyale/assets/sprites/archer_tower/archer_tower_red_battle.gif" ;
	private final String BLUE_IDLE_TOWER_PATH = "/JClashRoyale/assets/sprites/archer_tower/archer_tower_blue_idle.png" ;
	private final String BLUE_BATTLE_TOWER_PATH = "/JClashRoyale/assets/sprites/archer_tower/archer_tower_blue_battle.gif" ;

	private final String DESTROYED_TOWER_PATH = "/JClashRoyale/assets/sprites/archer_tower/archer_tower_destroyed.png" ;
	// Fields : Other
	private boolean isDestroyed ;

	private Image idleTower ;
	private Image battleTower ;
	private Image destroyedTower ;
	// Constructor
	public ArcherTower(ColorType color) {
		isDestroyed = false ;

		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setRunSpeed(RUN_SPEED) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setIdleTower(RED_IDLE_TOWER_PATH) ;
			setBattleTower(RED_BATTLE_TOWER_PATH) ;
		} else if ( color == ColorType.BLUE ) {
			setIdleTower(BLUE_IDLE_TOWER_PATH) ;
			setBattleTower(BLUE_BATTLE_TOWER_PATH) ;
		} else {
			// Pass
		}
		setDestroyedTower(DESTROYED_TOWER_PATH) ;

		setStateImage(idleTower) ;
	}
	// Methods : Setters
	private void setIdleTower(String path) {
		this.idleTower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false) ;
	}
	private void setBattleTower(String path) {
		this.battleTower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false);
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
			setStateImage(battleTower) ;
		} else {
			setStateImage(idleTower) ;
		}

		graphics.drawImage(stateImage , getX() , getY()) ;
	}
}

