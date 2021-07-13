// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;

public class Valkyrie extends AreaSplashTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 4 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 0.0 ; // TODO : Medium
	private final double ATTACK_SPEED = 1500.0 ;
	private final TroopType TROOP_TYPE = TroopType.GROUND ;
	private final TargetType TARGET_TYPE = TargetType.GROUND ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/assets/sprites/valkyrie/valkyrie_red_run_left.png" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/assets/sprites/valkyrie/valkyire_red_run_right.png" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/assets/sprites/valkyrie/valkyrie_blue_run_left.png" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/assets/sprites/valkyrie/valkyire_blue_run_right.png" ;
	private final String RED_BATTLE_ANIMATION_FIRST_PATH = "" /*"/assets/sprites/valkyrie/valkyrie_red_battle_first.png"*/ ;
	private final String RED_BATTLE_ANIMATION_SECOND_PATH = "" /*"/assets/sprites/valkyrie/valkyrie_red_battle_second.png"*/ ;
	private final String BLUE_BATTLE_ANIMATION_FIRST_PATH = "" /*"/assets/sprites/valkyrie/valkyrie_blue_battle_first.png"*/ ;
	private final String BLUE_BATTLE_ANIMATION_SECOND_PATH = "" /*"/assets/sprites/valkyrie/valkyrie_blue_battle_second.png"*/ ;
	// Constructor
	public Valkyrie() {
		setRangeCircle(RANGE_RADIUS) ;
		setHealthCircle(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		setRedRunAnimationLeft(RED_RUN_ANIMATION_LEFT_PATH) ;
		setRedRunAnimationRight(RED_RUN_ANIMATION_RIGHT_PATH) ;
		setBlueRunAnimationLeft(BLUE_RUN_ANIMATION_LEFT_PATH) ;
		setBlueRunAnimationRight(BLUE_RUN_ANIMATION_RIGHT_PATH) ;
		setRedBattleAnimationFirst(RED_BATTLE_ANIMATION_FIRST_PATH) ;
		setRedBattleAnimationSecond(RED_BATTLE_ANIMATION_SECOND_PATH) ;
		setBlueBattleAnimationFirst(BLUE_BATTLE_ANIMATION_FIRST_PATH) ;
		setBlueBattleAnimationSecond(BLUE_BATTLE_ANIMATION_SECOND_PATH) ;
	}
	// Methods
	
}

