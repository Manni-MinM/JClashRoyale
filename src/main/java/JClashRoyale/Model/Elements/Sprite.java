// BWOTSHEWCHB

package JClashRoyale.Model.Elements ;

import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.shape.Circle ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;

public abstract class Sprite {
	// Fields
	protected Point2D location ;

	protected Circle rangeCircle ;
	protected Circle healthCircle ;

	protected double rangeCircleRadius ;
	protected double healthCircleRadius ;

	protected int cost ;
	protected double damage ;
	protected double runSpeed ;
	protected double hitpoints ;
	protected double attackSpeed ;
	protected TroopType troopType ;
	protected TargetType targetType ;

	protected Image stateImage ;
	// Constructor
	public Sprite() {
		// Pass
	}
	// Methods : Setters
	public void setLocation(double x , double y) {
		this.location = new Point2D(x , y) ;
		this.rangeCircle = new Circle(location.getX() , location.getY() , rangeCircleRadius) ;
		this.healthCircle = new Circle(location.getX() , location.getY() , healthCircleRadius) ;
	}
	public void setRangeCircleRadius(double radius) {
		this.rangeCircleRadius = radius ;
	}
	public void setHealthCircleRadius(double radius) {
		this.healthCircleRadius = radius ;
	}
	public void setCost(int cost) {
		this.cost = cost ;	
	}
	public void setDamage(double damage) {
		this.damage = damage ;
	}
	public void setRunSpeed(double speed) {
		this.runSpeed = speed ;
	}
	public void setHitpoints(double hitpoints) {
		this.hitpoints = hitpoints ;
	}
	public void setAttackSpeed(double speed) {
		this.attackSpeed = speed ;	
	}
	public void setTroopType(TroopType type) {
		this.troopType = type ;
	}
	public void setTargetType(TargetType target) {
		this.targetType = target ;
	}
	public void setStateImage(Image stateImage) {
		this.stateImage = stateImage ;
	}
	// Methods : Getters
	public double getX() {
		return this.location.getX() ;
	}
	public double getY() {
		return this.location.getY() ;
	}
	public Circle getRangeCircle() {
		return this.rangeCircle ;
	}
	public Circle getHealthCircle() {
		return this.healthCircle ;
	}
	public int getCost() {
		return this.cost ;
	}
	public double getDamage() {
		return this.damage ;
	}
	public double getRunSpeed() {
		return this.runSpeed ;
	}
	public double getHitpoints() {
		return this.hitpoints ;
	}
	public double getAttackSpeed() {
		return this.attackSpeed ;
	}
	public TroopType getTroopType() {
		return this.troopType ;
	}
	public TargetType getTargetType() {
		return this.targetType ;
	}
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
	// Methods : Public
	public boolean rangeIntersects(Circle circle) {
		return circleIntersects(rangeCircle , circle) ;
	}
	public boolean healthIntersects(Circle circle) {
		return circleIntersects(healthCircle , circle) ;
	}
	public void showRangeCircle(GraphicsContext graphics) {
		graphics.fillOval(this.getX() , this.getY() , rangeCircle.getRadius() , rangeCircle.getRadius()) ;
	}
	public void showHealthCircle(GraphicsContext graphics) {
		graphics.fillOval(this.getX() , this.getY() , healthCircle.getRadius() , healthCircle.getRadius()) ;
	}
}

