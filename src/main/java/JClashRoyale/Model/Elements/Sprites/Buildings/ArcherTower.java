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
	private final double HEALTH_RADIUS = 125.0 ;

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
	// Fields : Other
	private Image idleTower ;
	private Image battleTower ;
	// Constructor
	public ArcherTower(ColorType color) {
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

		setStateImage(idleTower) ;
	}
	// Methods : Setters
	private void setIdleTower(String path) {
		this.idleTower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false) ;
	}
	private void setBattleTower(String path) {
		this.battleTower = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , WIDTH , HEIGHT , false , false);
	}
	// Methods : Getters

	// Methods : Other
	public void draw(GraphicsContext graphics) {
		if ( attackState )
			setStateImage(battleTower) ;

		graphics.drawImage(stateImage , getX() , getY()) ;
	}
}

