// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.Building ;

import java.util.Objects;

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
	private final TroopType TARGET_TYPE = TroopType.ALL ;

	private final double WIDTH = 30.0 ;
	private final double HEIGHT = 30.0 ;

	private final String RED_BODY_PATH = "/JClashRoyale/assets/sprites/inferno_tower/inferno_tower_red_body.png" ;
	private final String BLUE_BODY_PATH = "/JClashRoyale/assets/sprites/inferno_tower/inferno_tower_blue_body.png" ;
	// Fields : Other
	private Image body ;
	// Constructor
	public InfernoTower(ColorType color) {
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
		} else if ( color == ColorType.BLUE ) {
			setBody(BLUE_BODY_PATH) ;
		} else {
			// Pass
		}
	}
	// Methods : Setters
	private void setBody(String path) {
		this.body = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , WIDTH , HEIGHT , false , false) ;
	}
	// Methods : Getters
	
	// Methods : Other
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(body , getX() , getY()) ;
	}
}

