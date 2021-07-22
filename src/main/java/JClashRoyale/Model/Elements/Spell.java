// BWOTSHEWCHB

package JClashRoyale.Model.Elements ;

import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.shape.Circle ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Spells.Rage ;
import JClashRoyale.Model.Elements.Spells.Arrows ;
import JClashRoyale.Model.Elements.Spells.Fireball ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

import java.util.Objects;

/**
 * The type Spell.
 */
public abstract class Spell {
	/**
	 * The Location.
	 */
// Fields
	protected Point2D location ;
	/**
	 * The Range circle.
	 */
	protected Circle rangeCircle ;

	/**
	 * The Range circle radius.
	 */
	protected double rangeCircleRadius ;

	/**
	 * The Cost.
	 */
	protected int cost ;
	/**
	 * The Color.
	 */
	protected ColorType color ;
	/**
	 * The Damage.
	 */
	protected double damage ;
	/**
	 * The Duration.
	 */
	protected double duration ;
	/**
	 * The Damage boost.
	 */
	protected double damageBoost ;
	/**
	 * The Run speed boost.
	 */
	protected double runSpeedBoost ;
	/**
	 * The Attack speed boost.
	 */
	protected double attackSpeedBoost ;

	/**
	 * The Deployment time.
	 */
	protected double deploymentTime ;

	/**
	 * The Animation.
	 */
	protected Image animation ;

	/**
	 * Instantiates a new Spell.
	 */
// Constructor
	public Spell() {
		// Pass
	}

	/**
	 * Sets location.
	 *
	 * @param x the x
	 * @param y the y
	 */
// Methods : Setters
	public void setLocation(double x , double y) {
		this.location = new Point2D(x , y) ;

		double offsetX = animation.getWidth() / 2.0 ;
		double offsetY = animation.getHeight() / 2.0 ;

		this.rangeCircle = new Circle(location.getX() + offsetX , location.getY() + offsetY , rangeCircleRadius) ;
	}

	/**
	 * Sets range circle radius.
	 *
	 * @param radius the radius
	 */
	public void setRangeCircleRadius(double radius) {
		this.rangeCircleRadius = radius ;
	}

	/**
	 * Sets cost.
	 *
	 * @param cost the cost
	 */
	public void setCost(int cost) {
		this.cost = cost ;
	}

	/**
	 * Sets damage.
	 *
	 * @param damage the damage
	 */
	public void setDamage(double damage) {
		this.damage = damage ;
	}

	/**
	 * Sets duration.
	 *
	 * @param duration the duration
	 */
	public void setDuration(double duration) {
		this.duration = duration ;
	}

	/**
	 * Sets damage boost.
	 *
	 * @param damageBoost the damage boost
	 */
	public void setDamageBoost(double damageBoost) {
		this.damageBoost = damageBoost ;
	}

	/**
	 * Sets run speed boost.
	 *
	 * @param runSpeedBoost the run speed boost
	 */
	public void setRunSpeedBoost(double runSpeedBoost) {
		this.runSpeedBoost = runSpeedBoost ;
	}

	/**
	 * Sets attack speed boost.
	 *
	 * @param attackSpeedBoost the attack speed boost
	 */
	public void setAttackSpeedBoost(double attackSpeedBoost) {
		this.attackSpeedBoost = attackSpeedBoost ;
	}

	/**
	 * Sets animation.
	 *
	 * @param path   the path
	 * @param width  the width
	 * @param height the height
	 */
	public void setAnimation(String path , double width , double height) {
		this.animation = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , width , height , false , false) ;
	}

	/**
	 * Sets color type.
	 *
	 * @param color the color
	 */
	public void setColorType(ColorType color) {
		this.color = color ;
	}

	/**
	 * Sets deployment time.
	 *
	 * @param deploymentTime the deployment time
	 */
	public void setDeploymentTime(double deploymentTime) {
		this.deploymentTime = deploymentTime ;
	}

	/**
	 * Gets x.
	 *
	 * @return the x
	 */
// Methods : Getters
	public double getX() {
		return this.location.getX() ;
	}

	/**
	 * Gets y.
	 *
	 * @return the y
	 */
	public double getY() {
		return this.location.getY() ;
	}

	/**
	 * Gets range circle.
	 *
	 * @return the range circle
	 */
	public Circle getRangeCircle() {
		return this.rangeCircle ;
	}

	/**
	 * Gets cost.
	 *
	 * @return the cost
	 */
	public int getCost() {
		return this.cost ;
	}

	/**
	 * Gets damage.
	 *
	 * @return the damage
	 */
	public double getDamage() {
		return this.damage ;
	}

	/**
	 * Gets duration.
	 *
	 * @return the duration
	 */
	public double getDuration() {
		return this.duration ;
	}

	/**
	 * Gets damage boost.
	 *
	 * @return the damage boost
	 */
	public double getDamageBoost() {
		return this.damageBoost ;
	}

	/**
	 * Gets run speed boost.
	 *
	 * @return the run speed boost
	 */
	public double getRunSpeedBoost() {
		return this.runSpeedBoost ;
	}

	/**
	 * Gets attack speed boost.
	 *
	 * @return the attack speed boost
	 */
	public double getAttackSpeedBoost() {
		return this.attackSpeedBoost ;
	}

	/**
	 * Gets color type.
	 *
	 * @return the color type
	 */
	public ColorType getColorType() {
		return this.color ;	
	}

	/**
	 * Gets deployment time.
	 *
	 * @return the deployment time
	 */
	public double getDeploymentTime() {
		return this.deploymentTime ;
	}

	/**
	 * Gets state image.
	 *
	 * @return the state image
	 */
	public Image getStateImage() {
		return this.animation ;
	}
	// Methods : Private
	private boolean circleIntersects(Circle first , Circle second) {
		if ( first == null || second == null )
			return false ;

		Point2D firstCenter = new Point2D(first.getCenterX() , first.getCenterY()) ;
		Point2D secondCenter = new Point2D(second.getCenterX() , second.getCenterY()) ;

		return (firstCenter.distance(secondCenter) < (first.getRadius() + second.getRadius()) / 2.0) ;
	}

	/**
	 * Draw.
	 *
	 * @param graphics the graphics
	 */
// Methods : Public
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(animation , getX() , getY()) ;
	}

	/**
	 * Range intersects boolean.
	 *
	 * @param circle the circle
	 * @return the boolean
	 */
	public boolean rangeIntersects(Circle circle) {
		return circleIntersects(rangeCircle , circle) ;
	}

	/**
	 * Can affect boolean.
	 *
	 * @param sprite the sprite
	 * @return the boolean
	 */
	public boolean canAffect(Sprite sprite) {
		if ( this instanceof Rage ) {
			if ( this.getColorType() != sprite.getColorType() )
				return false ;
			if ( !this.rangeIntersects(sprite.getHealthCircle()) )
				return false ;
			return true ;
		} else {
			if ( this.getColorType() == sprite.getColorType() )
				return false ;
			if ( !this.rangeIntersects(sprite.getHealthCircle()) )
				return false ;
			return true ;
		}
	}

	/**
	 * Affect.
	 *
	 * @param sprite the sprite
	 */
	public abstract void affect(Sprite sprite) ;
}

