// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Buildings ;

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

	private final String RUN_ANIMATION_LEFT_PATH = "" /*"/assets/sprites/cannon/cannon_run_left.png"*/ ;
	private final String RUN_ANIMATION_RIGHT_PATH = "" /*"/assets/sprites/cannon/cannon_run_right.png"*/ ;
	private final String BATTLE_ANIMATION_FIRST_PATH = "" /*"/assets/sprites/cannon/cannon_battle_first.png"*/ ;
	private final String BATTLE_ANIMATION_SECOND_PATH = "" /*"/assets/sprites/cannon/cannon_battle_second.png"*/ ;
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

		setRunAnimationLeft(RUN_ANIMATION_LEFT_PATH) ;
		setRunAnimationRight(RUN_ANIMATION_RIGHT_PATH) ;
		setBattleAnimationFirst(BATTLE_ANIMATION_FIRST_PATH) ;
		setBattleAnimationSecond(BATTLE_ANIMATION_SECOND_PATH) ;
	}
	// Methods
	
}

