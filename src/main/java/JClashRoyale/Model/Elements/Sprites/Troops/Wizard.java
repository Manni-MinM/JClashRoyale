// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

public class Wizard extends AreaSplashTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 5 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ; // TODO : Medium
	private final double ATTACK_SPEED = 1700.0 ;
	private final TroopType TROOP_TYPE = TroopType.GROUND ;
	private final TargetType TARGET_TYPE = TargetType.ALL ;

	private final String RUN_ANIMATION_LEFT_PATH = "" /*"/assets/sprites/wizard/wizard_run_left.png"*/ ;
	private final String RUN_ANIMATION_RIGHT_PATH = "" /*"/assets/sprites/wizard/wizard_run_right.png"*/ ;
	private final String BATTLE_ANIMATION_FIRST_PATH = "" /*"/assets/sprites/wizard/wizard_battle_first.png"*/ ;
	private final String BATTLE_ANIMATION_SECOND_PATH = "" /*"/assets/sprites/wizard/wizard_battle_second.png"*/ ;
	// Constructor
	public Wizard() {
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

