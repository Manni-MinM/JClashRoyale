// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites.Troops ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;
import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;

public class Wizard extends AreaSplashTroop {
	// Fields : Final
	private final double RANGE_RADIUS = 0.0 ; // TODO : ?
	private final double HEALTH_RADIUS = 0.0 ; // TODO : ?

	private final int COST = 5 ;
	private final double RUN_SPEED = 20.0 ;
	private final double ATTACK_SPEED = 1700.0 ;
	private final TroopType TROOP_TYPE = TroopType.GROUND ;
	private final TargetType TARGET_TYPE = TargetType.ALL ;
	
	private final double WIDTH = 30.0 ;
	private final double HEIGHT = 30.0 ;

	private final String RED_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_red_run_left.png" ;
	private final String RED_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_red_run_right.png" ;
	private final String BLUE_RUN_ANIMATION_LEFT_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_blue_run_left.png" ;
	private final String BLUE_RUN_ANIMATION_RIGHT_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_blue_run_right.png" ;
	private final String RED_BATTLE_ANIMATION_FIRST_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_red_battle_first.png" ;
	private final String RED_BATTLE_ANIMATION_SECOND_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_red_battle_second.png" ;
	private final String BLUE_BATTLE_ANIMATION_FIRST_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_blue_battle_first.png" ;
	private final String BLUE_BATTLE_ANIMATION_SECOND_PATH = "/JClashRoyale/assets/sprites/wizard/wizard_blue_battle_second.png" ;
	// Constructor
	public Wizard(ColorType color) {
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

