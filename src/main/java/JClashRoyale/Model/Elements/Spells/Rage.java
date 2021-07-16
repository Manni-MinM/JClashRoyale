// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Spells ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Spell ;

public class Rage extends Spell {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 3 ;
	private final double DAMAGE = 0.0 ;
	private final double DURATION = 0.0 ; // TODO : Read From DB
	private final double DAMAGE_BOOST = 1.4 ;
	private final double RUN_SPEED_BOOST = 1.4 ;
	private final double ATTACK_SPEED_BOOST = 0.6 ;

	private final String ANIMATION_PATH = "" /*"/assets/sprites/rage/rage.png"*/ ;
	// Constructor
	public Rage() {
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

