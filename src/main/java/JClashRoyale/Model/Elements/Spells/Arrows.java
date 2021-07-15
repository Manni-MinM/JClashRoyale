// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Spells ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Enums.TroopType ;

public class Arrows extends Spell {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 3 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double DURATION = 500.0 ;
	private final double DAMAGE_BOOST = 0.0 ;
	private final double RUN_SPEED_BOOST = 0.0 ;
	private final double ATTACK_SPEED_BOOST = 0.0 ;

	private final String ANIMATION_PATH = "" /*"/assets/sprites/arrows/arrows.png"*/ ;
	// Constructor
	public Arrows() {
		setRangeCircle(RANGE_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setDuration(DURATION) ;
		setDamageBoost(DAMAGE_BOOST) ;
		setRunSpeedBoost(RUN_SPEED_BOOST) ;
		setAttackSpeedBoost(ATTACK_SPEED_BOOST) ;

		setAnimation(ANIMATION_PATH) ;
	}
	// Methods
	
}

