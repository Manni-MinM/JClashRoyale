// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Spells ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

/**
 * The type Arrows.
 */
public class Arrows extends Spell {
	// Fields : Final
	private final double RANGE_RADIUS = 120.0 ;

	private final int COST = 3 ;
	private final double DURATION = 1 ;
	private final double DAMAGE_BOOST = 0.0 ;
	private final double RUN_SPEED_BOOST = 0.0 ;
	private final double ATTACK_SPEED_BOOST = 0.0 ;

	private final double WIDTH = 120.0 ;
	private final double HEIGHT = 120.0 ;

	private final String ANIMATION_PATH = "/JClashRoyale/assets/sprites/arrows/arrows.gif" ;

    /**
     * Instantiates a new Arrows.
     *
     * @param color the color
     */
// Constructor
	public Arrows(ColorType color) {
		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;

		setCost(COST) ;
		setDuration(DURATION) ;
		setDamageBoost(DAMAGE_BOOST) ;
		setRunSpeedBoost(RUN_SPEED_BOOST) ;
		setAttackSpeedBoost(ATTACK_SPEED_BOOST) ;

		setAnimation(ANIMATION_PATH , WIDTH , HEIGHT) ;
	}
	// Methods
	public void affect(Sprite sprite) {
		sprite.setHitpoints(sprite.getHitpoints() - this.getDamage()) ;
	}
}

