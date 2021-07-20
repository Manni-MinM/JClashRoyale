// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

public class MiniPekka extends SingleTargetTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 40.0 ;
	private final double HEALTH_RADIUS = 35.0 ;

	private final int COST = 4 ;
	private final double RUN_SPEED = 30.0 ;
	private final double ATTACK_SPEED = 1.8 ;
	private final TroopType TROOP_TYPE = TroopType.GROUND ;
	private final TroopType TARGET_TYPE = TroopType.GROUND ;

	private final double WIDTH = 35.0 ;
	private final double HEIGHT = 35.0 ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_run_left.gif" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_run_right.gif" ;
	private final String RED_RUN_ANIMATION_FORWARD_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_run_forward.gif" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_run_left.gif" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_run_right.gif" ;
	private final String BLUE_RUN_ANIMATION_FORWARD_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_run_forward.gif" ;
	private final String RED_BATTLE_ANIMATION_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_red_battle.gif" ;
	private final String BLUE_BATTLE_ANIMATION_PATH = "/JClashRoyale/assets/sprites/mini_pekka/mini_pekka_blue_battle.gif" ;
	// Constructor
	public MiniPekka(ColorType color) {
		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setCost(COST) ;
		setRunSpeed(RUN_SPEED) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setRunAnimationLeft(RED_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationRight(RED_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationForward(RED_RUN_ANIMATION_FORWARD_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setBattleAnimation(RED_BATTLE_ANIMATION_PATH , WIDTH + 15 , HEIGHT + 15) ;
		} else if ( color == ColorType.BLUE ) {
			setRunAnimationLeft(BLUE_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationRight(BLUE_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationForward(BLUE_RUN_ANIMATION_FORWARD_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setBattleAnimation(BLUE_BATTLE_ANIMATION_PATH , WIDTH , HEIGHT) ;
		} else {
			// Pass
		}

		setStateImage(runAnimationForward) ;
	}
	// Methods
	
}

