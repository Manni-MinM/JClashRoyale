// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

public class MiniPekka extends SingleTargetTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 4 ;
	private final double DAMAGE = 0.0 ; // TODO : Read From DB
	private final double HITPOINTS = 0.0 ; // TODO : Read From DB
	private final double RUN_SPEED = 30.0 ;
	private final double ATTACK_SPEED = 1800.0 ;
	private final TroopType TROOP_TYPE = TroopType.GROUND ;
	private final TargetType TARGET_TYPE = TargetType.GROUND ;

	private final double WIDTH = 30.0 ;
	private final double HEIGHT = 30.0 ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_run_left.png" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_run_right.png" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_run_left.png" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_run_right.png" ;
	private final String RED_BATTLE_ANIMATION_FIRST_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_battle_first.png" ;
	private final String RED_BATTLE_ANIMATION_SECOND_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_battle_second.png" ;
	private final String BLUE_BATTLE_ANIMATION_FIRST_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_battle_first.png" ;
	private final String BLUE_BATTLE_ANIMATION_SECOND_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_battle_second.png" ;
	// Constructor
	public MiniPekka(ColorType color) {
		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setRunSpeed(RUN_SPEED) ;
		setHitpoints(HITPOINTS) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setRunAnimationLeft(RED_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationRight(RED_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
//			setBattleAnimationFirst(RED_BATTLE_ANIMATION_FIRST_PATH , WIDTH , HEIGHT) ;
//			setBattleAnimationSecond(RED_BATTLE_ANIMATION_SECOND_PATH , WIDTH , HEIGHT) ;
		} else if ( color == ColorType.BLUE ) {
			setRunAnimationLeft(BLUE_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationRight(BLUE_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
//			setBattleAnimationFirst(BLUE_BATTLE_ANIMATION_FIRST_PATH , WIDTH , HEIGHT) ;
//			setBattleAnimationSecond(BLUE_BATTLE_ANIMATION_SECOND_PATH , WIDTH , HEIGHT) ;
		} else {
			// Pass
		}
	}
	// Methods
	
}

