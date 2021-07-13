// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

public class Cannon extends Building {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 6 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ;
	private final double ATTACK_SPEED = 800.0 ;
	private final double LIFETIME = 30000.0 ;
	private final TroopType TROOP_TYPE = TroopType.BUILDING ;
	private final TargetType TARGET_TYPE = TargetType.GROUND ;

	private final String RED_BODY_PATH = "/assets/sprites/cannon/cannon_red_body.png" ;
	private final String BLUE_BODY_PATH = "/assets/sprites/cannon/cannon_blue_body.png" ;
	private final String RED_BLASTER_PATH = "/assets/sprites/cannon/cannon_red_blaster.png" ;
	private final String BLUE_BLASTER_PATH = "/assets/sprites/cannon/cannon_blue_blaster.png" ;
	// Fields : Other
	private Image redBody ;
	private Image blueBody ;
	private Image redBlaster ;
	private Image blueBlaster ;
	// Constructor
	public Cannon() {
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
		setRedBlaster(RED_BLASTER_PATH) ;
		setBlueBody(BLUE_BODY_PATH) ;
		setBlueBlaster(BLUE_BLASTER_PATH) ;
	}
	// Methods : Setters
	public void setRedBody(String path) {
		this.redBody = new Image(path) ;
	}
	public void setBlueBody(String path) {
		this.blueBody = new Image(path) ;
	}
	public void setRedBlaster(String path) {
		this.redBlaster = new Image(path) ;
	}
	public void setBlueBlaster(String path) {
		this.blueBlaster = new Image(path) ;
	}
	// Methods : Getters

	// Methods : Other
	
}

