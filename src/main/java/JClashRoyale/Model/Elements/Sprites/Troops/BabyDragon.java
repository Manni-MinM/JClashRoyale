// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;

/**
 * The type Baby dragon.
 */
public class BabyDragon extends AreaSplashTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 105.0 ;
	private final double HEALTH_RADIUS = 35.0 ;

	private final int COST = 4 ;
	private final double RUN_SPEED = 30.0 ;
	private final double ATTACK_SPEED = 1.8 ;
	private final TroopType TROOP_TYPE = TroopType.AERIAL ;
	private final TroopType TARGET_TYPE = TroopType.ALL ;

	private final double WIDTH = 35.0 ;
	private final double HEIGHT = 35.0 ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_run_left.gif" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_run_right.gif" ;
	private final String RED_RUN_ANIMATION_FORWARD_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_run_forward.gif" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_run_left.gif" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_run_right.gif" ;
	private final String BLUE_RUN_ANIMATION_FORWARD_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_run_forward.gif" ;
	private final String RED_BATTLE_ANIMATION_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_red_battle.gif" ;
	private final String BLUE_BATTLE_ANIMATION_PATH = "/JClashRoyale/assets/sprites/baby_dragon/baby_dragon_blue_battle.gif" ;

	/**
	 * Instantiates a new Baby dragon.
	 *
	 * @param color the color
	 */
// Constructor
	public BabyDragon(ColorType color) {
		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;
		setHealthCircleRadius(HEALTH_RADIUS) ;

		setCost(COST) ;
		setRunSpeed(RUN_SPEED) ;
		setAttackSpeed(ATTACK_SPEED) ;
		setTroopType(TROOP_TYPE) ;
		setTargetType(TARGET_TYPE) ;

		if ( color == ColorType.RED ) {
			setRunAnimationLeft(RED_RUN_ANIMATION_LEFT_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setRunAnimationRight(RED_RUN_ANIMATION_RIGHT_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setRunAnimationForward(RED_RUN_ANIMATION_FORWARD_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setBattleAnimation(RED_BATTLE_ANIMATION_PATH , WIDTH , HEIGHT) ;
		} else if ( color == ColorType.BLUE ) {
			setRunAnimationLeft(BLUE_RUN_ANIMATION_LEFT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationRight(BLUE_RUN_ANIMATION_RIGHT_PATH , WIDTH , HEIGHT) ;
			setRunAnimationForward(BLUE_RUN_ANIMATION_FORWARD_PATH , WIDTH + 5 , HEIGHT + 5) ;
			setBattleAnimation(BLUE_BATTLE_ANIMATION_PATH , WIDTH + 5 , HEIGHT + 5) ;
		} else {
			// Pass
		}

		setStateImage(runAnimationForward) ;
	}
	// Methods
	
}

