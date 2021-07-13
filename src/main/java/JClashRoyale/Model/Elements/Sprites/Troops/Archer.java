// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

public class Archer extends SingleTargetTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 3 ;
	private final double DAMAGE = 0.0 // TODO : Read From DB
	private final double HITPOINTS = 0.0 // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ; // TODO : ?
	private final double ATTACK_SPEED = 0.0 ; // TODO : ?
	private final TroopType TROOP_TYPE = Enums.GROUND ;
	private final TargetType TARGET_TYPE = Enums.ALL ;

	private final String RUN_ANIMATION_LEFT_PATH = "/assets/sprites/archer/archer_run_left.png" ;
	private final String RUN_ANIMATION_RIGHT_PATH = "/assets/sprites/archer/archer_run_right.png" ;
	private final String BATTLE_ANIMATION_FIRST_PATH = "" ; // TODO : ?
	private final String BATTLE_ANIMATION_SECOND_PATH = "" ; // TODO : ?
	// Constructor
	public Archer() {
		setRangeCircle(RANGE_RADIUS) ;
		setHealthCircle(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		setRunAnimationLeft(RUN_ANIMATION_LEFT_PATH) ;
		setRunAnimationRight(RUN_ANIMATION_RIGHT_PATH) ;
		setBattleAnimationFirst(BATTLE_ANIMATION_FIRST_PATH) ;
		setBattleAnimationSecond(BATTLE_ANIMATION_SECOND_PATH) ;
	}
	// Methods
	
}

