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

public abstract class Spell {
	// Fields
	protected Point2D location ;
	protected Circle rangeCircle ;

	protected double rangeCircleRadius ;

	protected int cost ;
	protected ColorType color ;
	protected double damage ;
	protected double duration ;
	protected double damageBoost ;
	protected double runSpeedBoost ;
	protected double attackSpeedBoost ;

	protected double deploymentTime ;

	protected Image animation ;
	// Constructor
	public Spell() {
		// Pass
	}
	// Methods : Setters
	public void setLocation(double x , double y) {
		this.location = new Point2D(x , y) ;

		double offsetX = animation.getWidth() / 2.0 ;
		double offsetY = animation.getHeight() / 2.0 ;

		this.rangeCircle = new Circle(location.getX() + offsetX , location.getY() + offsetY , rangeCircleRadius) ;
	}
	public void setRangeCircleRadius(double radius) {
		this.rangeCircleRadius = radius ;
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
	public void setAnimation(String path , double width , double height) {
		this.animation = new Image(path , width , height , false , false) ;
	}
	public void setColorType(ColorType color) {
		this.color = color ;
	}
	public void setDeploymentTime(double deploymentTime) {
		this.deploymentTime = deploymentTime ;
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
	public ColorType getColorType() {
		return this.color ;	
	}
	public double getDeploymentTime() {
		return this.deploymentTime ;
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
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(animation , getX() , getY()) ;
	}
	public boolean rangeIntersects(Circle circle) {
		return circleIntersects(rangeCircle , circle) ;
	}
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
	public abstract void affect(Sprite sprite) ;
}

