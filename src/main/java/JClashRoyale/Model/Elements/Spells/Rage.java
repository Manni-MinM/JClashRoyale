// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Spells ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

import java.util.ArrayList ;

public class Rage extends Spell {
	// Fields : Final
	private final double RANGE_RADIUS = 150.0 ;

	private final int COST = 3 ;
	private final double DAMAGE = 0.0 ;
	private final double DAMAGE_BOOST = 1.4 ;
	private final double RUN_SPEED_BOOST = 1.4 ;
	private final double ATTACK_SPEED_BOOST = 0.6 ;

	private final double WIDTH = 150.0 ;
	private final double HEIGHT = 150.0 ;

	private ArrayList<Sprite> affected = new ArrayList<Sprite>() ;

	private final String ANIMATION_PATH = "/JClashRoyale/assets/sprites/rage/rage.gif" ;
	// Constructor
	public Rage(ColorType color) {
		setColorType(color) ;

		setRangeCircleRadius(RANGE_RADIUS) ;

		setCost(COST) ;
		setDamage(DAMAGE) ;
		setDamageBoost(DAMAGE_BOOST) ;
		setRunSpeedBoost(RUN_SPEED_BOOST) ;
		setAttackSpeedBoost(ATTACK_SPEED_BOOST) ;

		setAnimation(ANIMATION_PATH , WIDTH , HEIGHT) ;
	}
	// Methods
	public void affect(Sprite sprite) {
		if ( affected.contains(sprite) )
			return ;
		sprite.setDamage(sprite.getDamage() * this.getDamageBoost()) ;
		sprite.setRunSpeed(sprite.getRunSpeed() * this.getRunSpeedBoost()) ;
		sprite.setAttackSpeed(sprite.getAttackSpeed() * this.getAttackSpeedBoost()) ;
		affected.add(sprite) ;
	}
}

