// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

public class Cannon extends Building {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 3 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ;
	private final double ATTACK_SPEED = 800.0 ;
	private final double LIFETIME = 30000.0 ;
	private final TroopType TROOP_TYPE = TroopType.BUILDING ;
	private final TroopType TARGET_TYPE = TroopType.GROUND ;

	private final double WIDTH = 30.0 ;
	private final double HEIGHT = 30.0 ;

	private final String RED_BODY_PATH = "/JClashRoyale/assets/sprites/cannon/cannon_red_body.png" ;
	private final String BLUE_BODY_PATH = "/JClashRoyale/assets/sprites/cannon/cannon_blue_body.png" ;
	private final String RED_BLASTER_PATH = "/JClashRoyale/assets/sprites/cannon/cannon_red_blaster.png" ;
	private final String BLUE_BLASTER_PATH = "/JClashRoyale/assets/sprites/cannon/cannon_blue_blaster.png" ;
	// Fields : Other
	private Image body ;
	private Image blaster ;
	// Constructor
	public Cannon(ColorType color) {
		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setLifetime(LIFETIME) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setBody(RED_BODY_PATH) ;
			setBlaster(RED_BLASTER_PATH) ;
		} else if ( color == ColorType.BLUE ) {
			setBody(BLUE_BODY_PATH) ;
			setBlaster(BLUE_BLASTER_PATH) ;
		} else {
			// Pass
		}
	}
	// Methods : Setters
	private void setBody(String path) {
		this.body = new Image(path , 1.5 * WIDTH , 1.5 * HEIGHT , false , false) ;
	}
	private void setBlaster(String path) {
		this.blaster = new Image(path , WIDTH , HEIGHT , false , false) ;
	}
	// Methods : Getters

	// Methods : Other
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(body , getX() , getY()) ;
		graphics.drawImage(blaster , getX() , getY()) ;
	}
}

