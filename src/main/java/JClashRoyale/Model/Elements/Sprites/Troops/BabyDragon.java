// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;

public class BabyDragon extends AreaSplashTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 4 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 30.0 ;
	private final double ATTACK_SPEED = 1800.0 ;
	private final TroopType TROOP_TYPE = TroopType.AERIAL ;
	private final TargetType TARGET_TYPE = TargetType.ALL ;

	private final double WIDTH = 30.0 ;
	private final double HEIGHT = 30.0 ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_run_left.png" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_run_right.png" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_run_left.png" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_run_right.png" ;
	private final String RED_BATTLE_ANIMATION_FIRST_PATH = "" /*"/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_battle_first.png"*/ ;
	private final String RED_BATTLE_ANIMATION_SECOND_PATH = "" /*"/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_battle_second.png"*/ ;
	private final String BLUE_BATTLE_ANIMATION_FIRST_PATH = "" /*"/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_battle_first.png"*/ ;
	private final String BLUE_BATTLE_ANIMATION_SECOND_PATH = "" /*"/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_battle_second.png"*/ ;
	// Constructor
	public BabyDragon() {
		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		setRedRunAnimationLeft(RED_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
		setRedRunAnimationRight(RED_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
		setBlueRunAnimationLeft(BLUE_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
		setBlueRunAnimationRight(BLUE_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
//		setRedBattleAnimationFirst(RED_BATTLE_ANIMATION_FIRST_PATH) ;
//		setRedBattleAnimationSecond(RED_BATTLE_ANIMATION_SECOND_PATH) ;
//		setBlueBattleAnimationFirst(BLUE_BATTLE_ANIMATION_FIRST_PATH) ;
//		setBlueBattleAnimationSecond(BLUE_BATTLE_ANIMATION_SECOND_PATH) ;
	}
	// Methods
	
}

