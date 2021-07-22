// BWOTSHEWCHB

package JClashRoyale.Model.Elements ;

import JClashRoyale.Model.Cards.InfernoTowerCard;
import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.paint.Color ;
import javafx.scene.shape.Circle ;
import javafx.scene.canvas.GraphicsContext ;

import java.util.ArrayList ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;

import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower ;

/**
 * The type Sprite.
 */
public abstract class Sprite {
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
     * The Health circle.
     */
    protected Circle healthCircle ;

    /**
     * The Range circle radius.
     */
    protected double rangeCircleRadius ;
    /**
     * The Health circle radius.
     */
    protected double healthCircleRadius ;

    /**
     * The Cost.
     */
    protected int cost ;
    /**
     * The Damage.
     */
    protected double damage ;
    /**
     * The Run speed.
     */
    protected double runSpeed ;
    /**
     * The Hitpoints.
     */
    protected double hitpoints ;
    /**
     * The Attack speed.
     */
    protected double attackSpeed ;
    /**
     * The Last attack.
     */
    protected double lastAttack ;
    /**
     * The Attack state.
     */
    protected boolean attackState ;
    /**
     * The Color type.
     */
    protected ColorType colorType ;
    /**
     * The Troop type.
     */
    protected TroopType troopType ;
    /**
     * The Target type.
     */
    protected TroopType targetType ;

    /**
     * The State image.
     */
    protected Image stateImage ;

    /**
     * Instantiates a new Sprite.
     */
// Constructor
	public Sprite() {
		lastAttack = -100.0 ;
		attackState = false ;
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

		double offsetX = stateImage.getWidth() / 2.0 ;
		double offsetY = stateImage.getHeight() / 2.0 ;

		this.rangeCircle = new Circle(location.getX() + offsetX , location.getY() + offsetY , rangeCircleRadius) ;
		this.healthCircle = new Circle(location.getX() + offsetX , location.getY() + offsetY , healthCircleRadius) ;
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
     * Sets health circle radius.
     *
     * @param radius the radius
     */
    public void setHealthCircleRadius(double radius) {
		this.healthCircleRadius = radius ;
	}

    /**
     * Remove range circle.
     */
    public void removeRangeCircle() {
		this.rangeCircle = null ;
	}

    /**
     * Remove health circle.
     */
    public void removeHealthCircle() {
		this.healthCircle = null ;
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
     * Sets run speed.
     *
     * @param speed the speed
     */
    public void setRunSpeed(double speed) {
		this.runSpeed = speed ;
	}

    /**
     * Sets hitpoints.
     *
     * @param hitpoints the hitpoints
     */
    public void setHitpoints(double hitpoints) {
		this.hitpoints = hitpoints ;
	}

    /**
     * Sets attack speed.
     *
     * @param speed the speed
     */
    public void setAttackSpeed(double speed) {
		this.attackSpeed = speed ;	
	}

    /**
     * Sets last attack.
     *
     * @param lastAttack the last attack
     */
    public void setLastAttack(double lastAttack) {
		this.lastAttack = lastAttack ;
	}

    /**
     * Sets attack state.
     *
     * @param attackState the attack state
     */
    public void setAttackState(boolean attackState) {
		this.attackState = attackState ;
		if ( this instanceof InfernoTower && !attackState )
			this.setDamage(20) ;
	}

    /**
     * Sets color type.
     *
     * @param color the color
     */
    public void setColorType(ColorType color) {
		this.colorType = color ;
	}

    /**
     * Sets troop type.
     *
     * @param type the type
     */
    public void setTroopType(TroopType type) {
		this.troopType = type ;
	}

    /**
     * Sets target type.
     *
     * @param target the target
     */
    public void setTargetType(TroopType target) {
		this.targetType = target ;
	}

    /**
     * Sets state image.
     *
     * @param stateImage the state image
     */
    public void setStateImage(Image stateImage) {
		this.stateImage = stateImage ;
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
     * Gets health circle.
     *
     * @return the health circle
     */
    public Circle getHealthCircle() {
		return this.healthCircle ;
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
     * Gets run speed.
     *
     * @return the run speed
     */
    public double getRunSpeed() {
		return this.runSpeed ;
	}

    /**
     * Gets hitpoints.
     *
     * @return the hitpoints
     */
    public double getHitpoints() {
		return this.hitpoints ;
	}

    /**
     * Gets attack speed.
     *
     * @return the attack speed
     */
    public double getAttackSpeed() {
		return this.attackSpeed ;
	}

    /**
     * Gets last attack.
     *
     * @return the last attack
     */
    public double getLastAttack() {
		return this.lastAttack ;
	}

    /**
     * Gets attack state.
     *
     * @return the attack state
     */
    public boolean getAttackState() {
		return this.attackState ;
	}

    /**
     * Gets color type.
     *
     * @return the color type
     */
    public ColorType getColorType() {
		return this.colorType ;
	}

    /**
     * Gets troop type.
     *
     * @return the troop type
     */
    public TroopType getTroopType() {
		return this.troopType ;
	}

    /**
     * Gets target type.
     *
     * @return the target type
     */
    public TroopType getTargetType() {
		return this.targetType ;
	}

    /**
     * Gets state image.
     *
     * @return the state image
     */
    public Image getStateImage() {
		return this.stateImage ;
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
     * Range intersects boolean.
     *
     * @param circle the circle
     * @return the boolean
     */
// Methods : Public
	public boolean rangeIntersects(Circle circle) {
		return circleIntersects(rangeCircle , circle) ;
	}

    /**
     * Health intersects boolean.
     *
     * @param circle the circle
     * @return the boolean
     */
    public boolean healthIntersects(Circle circle) {
		return circleIntersects(healthCircle , circle) ;
	}

    /**
     * Can attack boolean.
     *
     * @param defender the defender
     * @return the boolean
     */
    public boolean canAttack(Sprite defender) {
		if ( this.getColorType() == defender.getColorType() )
			return false ;
		if ( !this.rangeIntersects(defender.getHealthCircle()) )
			return false ;
		return (this.getTargetType() == TroopType.ALL || this.getTargetType() == defender.getTroopType() || defender.getTroopType() == TroopType.BUILDING) ;
	}

    /**
     * Show range circle.
     *
     * @param graphics the graphics
     */
    public void showRangeCircle(GraphicsContext graphics) {
		double offsetX = (stateImage.getWidth() - rangeCircleRadius) / 2.0 ;
		double offsetY = (stateImage.getHeight() - rangeCircleRadius) / 2.0 ;
		graphics.setFill(Color.BLUE) ;
		graphics.fillOval(this.getX() + offsetX , this.getY() + offsetY , rangeCircle.getRadius() , rangeCircle.getRadius()) ;
	}

    /**
     * Show health circle.
     *
     * @param graphics the graphics
     */
    public void showHealthCircle(GraphicsContext graphics) {
		double offsetX = (stateImage.getWidth() - healthCircleRadius) / 2.0 ;
		double offsetY = (stateImage.getHeight() - healthCircleRadius) / 2.0 ;
		graphics.setFill(Color.RED) ;
		graphics.fillOval(this.getX() + offsetX , this.getY() + offsetY , healthCircle.getRadius() , healthCircle.getRadius()) ;
	}

    /**
     * Attack.
     *
     * @param defenders the defenders
     */
    public void attack(ArrayList<Sprite> defenders) {
		this.setAttackState(true) ;
		for ( Sprite defender : defenders )
			defender.setHitpoints(defender.getHitpoints() - this.getDamage()) ;
		if ( this instanceof InfernoTower ) {
			InfernoTowerCard temp = new InfernoTowerCard();
			this.setDamage(Math.max(this.getDamage() + 5, temp.getRange() ));
		}
	}

    /**
     * Walk forward.
     */
// Methods : Abstract
	public abstract void walkForward() ;

    /**
     * Walk bridge.
     */
    public abstract void walkBridge() ;

    /**
     * Walk king tower.
     */
    public abstract void walkKingTower() ;

    /**
     * Walk.
     *
     * @param leftArcherTowerDestroyed  the left archer tower destroyed
     * @param rightArcherTowerDestroyed the right archer tower destroyed
     */
    public abstract void walk(boolean leftArcherTowerDestroyed , boolean rightArcherTowerDestroyed) ;

    /**
     * Draw.
     *
     * @param graphics the graphics
     */
    public abstract void draw(GraphicsContext graphics) ;
}

