// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

public class InfernoTower extends Building {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 5 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ;
	private final double ATTACK_SPEED = 400.0 ;
	private final double LIFETIME = 40000.0 ;
	private final TroopType TROOP_TYPE = TroopType.BUILDING ;
	private final TargetType TARGET_TYPE = TargetType.ALL ;

	private final String RED_BODY_PATH = "/assets/sprites/inferno_tower/inferno_tower_red_body.png" ;
	private final String BLUE_BODY_PATH = "/assets/sprites/inferno_tower/inferno_tower_blue_body.png" ;
	// Fields : Other
	private Image redBody ;
	private Image blueBody ;
	// Constructor
	public InfernoTower() {
		setRangeCircle(RANGE_RADIUS) ;
		setHealthCircle(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setLifetime(LIFETIME) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		setRedBody(RED_BODY_PATH) ;
		setBlueBody(BLUE_BODY_PATH) ;
	}
	// Methods : Setters
	public void setRedBody(String path) {
		this.redBody = new Image(path) ;
	}
	public void setBlueBody(String path) {
		this.blueBody = new Image(path) ;
	}
	// Methods : Getters
	
	// Methods : Other
	
}

