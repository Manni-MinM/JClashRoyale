// BWOTSHEWCHB

package JClashRoyale.Model.Elements ;

import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.shape.Circle ;

import JClashRoyale.Model.Elements.Enums ;

public abstract class Spell {
	// Fields
	protected Point2D location ;
	protected Circle rangeCircle ;

	protected int cost ;
	protected double damage ;
	protected double duration ;
	protected double damageBoost ;
	protected double runSpeedBoost ;
	protected double attackSpeedBoost ;

	protected Image animation ;
	// Constructor
	public Spell() {
		// Pass
	}
	// Methods : Setters
	public void setLocation(double x , double y) {
		this.location = new Point2D(x , y) ;
	}
	public void setRangeCircle(double radius) {
		this.rangeCircle = new Circle(location.getX() , location.getY() , radius) ;
	}
	public void setCost(int cost) {
		this.cost = cost ;
	}
	public void setDamage(double damage) {
		this.damage = damage ;
	}
	public void setDuration(double duration) {
		this.duration = duration ;
	}
	public void setDamageBoost(double damageBoost) {
		this.damageBoost = damageBoost ;
	}
	public void setRunSpeedBoost(double runSpeedBoost) {
		this.runSpeedBoost = runSpeedBoost ;
	}
	public void setAttackSpeedBoost(double attackSpeedBoost) {
		this.attackSpeedBoost = attackSpeedBoost ;
	}
	public void setAnimation(String path) {
		this.animation = new Image(path) ;
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
	public int getCost() {
		return this.cost ;
	}
	public double getDamage() {
		return this.damage ;
	}
	public double getDuration() {
		return this.duration ;
	}
	public double getDamageBoost() {
		return this.damageBoost ;
	}
	public double getRunSpeedBoost() {
		return this.runSpeedBoost ;
	}
	public double getAttackSpeedBoost() {
		return this.attackSpeedBoost ;
	}
	// Methods : Private
	private boolean circleIntersects(Circle first , Circle second) {
		if ( first == null || second == null )
			return false ;

		Point2D firstCenter = new Point2D(first.getCenterX() , first.getCenterY()) ;
		Point2D secondCenter = new Point2D(second.getCenterX() , second.getCenterY()) ;

		return (firstCenter.distance(secondCenter) < first.getRadius() + second.getRadius()) ;
	}
	// Methods : Public 
	public boolean rangeIntersects(Circle circle) {
		return circleIntersects(rangeCircle , circle) ;
	}
	public abstract void showAnimation() ;
}

