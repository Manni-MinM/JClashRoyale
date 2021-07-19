// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

import java.util.Objects;

public class SingleTargetTroop extends Sprite {
	// Fields
	protected boolean bridgeReached ;

	protected Point2D destinationBridge ;
	protected Point2D destinationKingTower ;

	protected Image runAnimationLeft ;
	protected Image runAnimationRight ;
	protected Image runAnimationForward ;
	protected Image battleAnimation ;
	// Constructor
	public SingleTargetTroop() {
		bridgeReached = false ;
	}
	// Methods : Setters
	public void setRunAnimationLeft(String path , double width , double height) {
		this.runAnimationLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}
	public void setRunAnimationRight(String path , double width , double height) {
		this.runAnimationRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}
	public void setRunAnimationForward(String path , double width , double height) {
		this.runAnimationForward = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}
	public void setBattleAnimation(String path , double width , double height) {
		this.battleAnimation = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}
	// Methods : Getters
	
	// Methods : Other
	public void draw(GraphicsContext graphics) {
		if ( attackState )
			setStateImage(battleAnimation) ;

		graphics.drawImage(getStateImage() , getX() , getY()) ;
	}
	public void walkForward() {
		double x = getX() ;
		double y = getY() ;
		if ( getColorType() == ColorType.BLUE ) {
			y -= (0.017) * runSpeed ;
		} else if ( getColorType() == ColorType.RED ) {
			y += (0.017) * runSpeed ;
		}
		setLocation(x , y) ;
		setStateImage(runAnimationForward) ;
	}
	public void walkBridge() {
		double distance = location.distance(destinationBridge) ;

		double cos = (getX() - destinationBridge.getX()) / distance ;
		double sin = (getY() - destinationBridge.getY()) / distance ;

		double x = getX() ;
		double y = getY() ;
		x -= (0.017) * runSpeed * cos ;
		y -= (0.017) * runSpeed * sin ;

		setLocation(x , y) ;
		if ( cos < 0.0 ) {
			setStateImage(runAnimationRight) ;
		} else {
			setStateImage(runAnimationLeft) ;
		}
	}
	public void walkKingTower() {
		double distance = location.distance(destinationKingTower) ;

		double cos = (getX() - destinationKingTower.getX()) / distance ;
		double sin = (getY() - destinationKingTower.getY()) / distance ;

		double x = getX() ;
		double y = getY() ;
		x -= (0.017) * runSpeed * cos ;
		y -= (0.017) * runSpeed * sin ;

		setLocation(x , y) ;
		if ( cos < 0.0 ) {
			setStateImage(runAnimationRight) ;
		} else {
			setStateImage(runAnimationLeft) ;
		}
	}
	public void walk(boolean leftArcherTowerDestroyed , boolean rightArcherTowerDestroyed) {
		if ( getX() > 155.0 ) {
			if ( getColorType() == ColorType.RED ) {
				// (230 , 220)
				destinationBridge = new Point2D(230 , 220) ;
				// (180 , 390)
				destinationKingTower = new Point2D(180 , 390) ;
			} else if ( getColorType() == ColorType.BLUE ) {
				// (230 , 260)
				destinationBridge = new Point2D(230 , 260) ;
				// (180 , 70)
				destinationKingTower = new Point2D(180 , 70) ;
			} else {
				// Pass
			}
		} else {
			if ( getColorType() == ColorType.RED ) {
				// (60 , 220)
				destinationBridge = new Point2D(60 , 220) ;
				// (120 , 390)
				destinationKingTower = new Point2D(125 , 390) ;
			} else if ( getColorType() == ColorType.BLUE ) {
				// (60 , 260)
				destinationBridge = new Point2D(60 , 260) ;
				// (120 , 70)
				destinationKingTower = new Point2D(125 , 70) ;
			} else {
				// Pass
			}
		}

		double distanceBridge = location.distance(destinationBridge) ;
		double distanceKingTower = location.distance(destinationKingTower) ;

		if ( distanceBridge < 3.0 )
			bridgeReached = true ;

		if ( !bridgeReached ) {
			walkBridge() ;
		} else if ( bridgeReached ) {
			if ( getX() > 155.0 ) {
				if ( rightArcherTowerDestroyed ) {
					walkKingTower() ;
				} else {
					walkForward() ;
				}
			} else {
				if ( leftArcherTowerDestroyed ) {
					walkKingTower() ;
				} else {
					walkForward() ;
				}
			}
		}
	}
}

