// BWOTSHEWCHB

package JClashRoyale.Model.Elements ;

import javafx.application.Application ;
import javafx.scene.Group ;
import javafx.scene.Scene ;
import javafx.scene.paint.* ;
import javafx.scene.image.* ;
import javafx.scene.shape.* ;
import javafx.scene.canvas.* ;
import javafx.util.* ;
import javafx.event.* ;
import javafx.geometry.* ;
import javafx.animation.* ;
import javafx.stage.Stage ;

import JClashRoyale.Model.Elements.Enums ;

public abstract class Sprite {
	// Fields
	protected Point2D location ;
	protected Circle rangeCircle ;
	protected Circle healthCircle ;

	protected int cost ;
	protected double damage ;
	protected double runSpeed ;
	protected double hitpoints ;
	protected double attackSpeed ;
	protected TroopType troopType ;
	protected TargetType targetType ;
	protected AttackType attackType ;

	protected Image runAnimationLeft ;
	protected Image runAnimationRight ;
	protected Image battleAnimationFirst ;
	protected Image battleAnimationSecond ;
	// Constructor
	public Sprite() {
		// Pass
	}
	// Methods : Setters
	public void setLocation(double x , double y) {
		this.location = new Point2D(x , y) ;
	}
	public void setRangeCircle(double radius) {
		this.rangeCircle = new Circle(location.getX() , location.getY() , radius) ;
	}
	public void setHealthCircle(double radius) {
		this.healthCircle = new Circle(location.getX() , location.getY() , radius) ;
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
	public void setAttackType(AttackType attackType) {
		this.attackType = attackType ;
	}
	public void setRunAnimationLeft(String path) {
		this.runAnimationLeft = new Image(path) ;
	}
	public void setRunAnimationRight(String path) {
		this.runAnimationRight = new Image(path) ;
	}
	public void setBattleAnimationLeft(String path) {
		this.battleAnimationFirst = new Image(path) ;
	}
	public void setBattleAnimationRight(String path) {
		this.battleAnimationSecond = new Image(path) ;
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
	public AttackType getAttackType() {
		return this.attackType ;
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
	public boolean healthIntersects(Circle circle) {
		return circleIntersects(healthCircle , circle) ;
	}
	public void showRangeCircle(GraphicsContext graphics) {
		graphics.fillOval(this.getX() , this.getY() , rangeCircle.getRadius() , rangeCircle.getRadius()) ;
	}
	public void showHealthCircle(GraphicsContext graphics) {
		graphics.fillOval(this.getX() , this.getY() , healthCircle.getRadius() , healthCircle.getRadius()) ;
	}
	public void walk() {
		// TODO
	}
	public abstract void attack() ;
}

