// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Spells ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Spell ;

public class Fireball extends Spell {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 4 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double DURATION = 500.0 ;
	private final double DAMAGE_BOOST = 0.0 ;
	private final double RUN_SPEED_BOOST = 0.0 ;
	private final double ATTACK_SPEED_BOOST = 0.0 ;

	private final String ANIMATION_PATH = "" /*"/assets/sprites/fireball/fireball.png"*/ ;
	// Constructor
	public Fireball() {
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

