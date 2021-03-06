// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import javafx.geometry.Point2D ;
import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

import java.util.Objects;

/**
 * The type Area splash troop.
 */
public class AreaSplashTroop extends Sprite {
    /**
     * The Bridge reached.
     */
// Fields
	protected boolean bridgeReached ;

    /**
     * The Destination bridge.
     */
    protected Point2D destinationBridge ;
    /**
     * The Destination king tower.
     */
    protected Point2D destinationKingTower ;

    /**
     * The Run animation left.
     */
    protected Image runAnimationLeft ;
    /**
     * The Run animation right.
     */
    protected Image runAnimationRight ;
    /**
     * The Run animation forward.
     */
    protected Image runAnimationForward ;
    /**
     * The Battle animation.
     */
    protected Image battleAnimation ;

    /**
     * Instantiates a new Area splash troop.
     */
// Constructor
	public AreaSplashTroop() {
		bridgeReached = false ;

	}

    /**
     * Sets run animation left.
     *
     * @param path   the path
     * @param width  the width
     * @param height the height
     */
// Methods : Setters
	public void setRunAnimationLeft(String path , double width , double height) {
		this.runAnimationLeft = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}

    /**
     * Sets run animation right.
     *
     * @param path   the path
     * @param width  the width
     * @param height the height
     */
    public void setRunAnimationRight(String path , double width , double height) {
		this.runAnimationRight = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}

    /**
     * Sets run animation forward.
     *
     * @param path   the path
     * @param width  the width
     * @param height the height
     */
    public void setRunAnimationForward(String path , double width , double height) {
		this.runAnimationForward = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}

    /**
     * Sets battle animation.
     *
     * @param path   the path
     * @param width  the width
     * @param height the height
     */
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
				// (230 , 200)
				destinationBridge = new Point2D(230 , 200) ;
				// (180 , 390)
				destinationKingTower = new Point2D(180 , 390) ;
			} else if ( getColorType() == ColorType.BLUE ) {
				// (230 , 250)
				destinationBridge = new Point2D(230 , 250) ;
				// (180 , 70)
				destinationKingTower = new Point2D(180 , 70) ;
			} else {
				// Pass
			}
		} else {
			if ( getColorType() == ColorType.RED ) {
				// (60 , 200)
				destinationBridge = new Point2D(60 , 200) ;
				// (120 , 390)
				destinationKingTower = new Point2D(120 , 390) ;
			} else if ( getColorType() == ColorType.BLUE ) {
				// (60 , 250)
				destinationBridge = new Point2D(60 , 250) ;
				// (120 , 70)
				destinationKingTower = new Point2D(120 , 70) ;
			} else {
				// Pass
			}
		}

		double distanceBridge = location.distance(destinationBridge) ;
		double distanceKingTower = location.distance(destinationKingTower) ;

		if ( distanceBridge < 3.0 )
			bridgeReached = true ;
		if ( getColorType() == ColorType.BLUE ) {
			if ( rightArcherTowerDestroyed && getX() > 155.0 && getY() < 230.0 )
				bridgeReached = true ;
			if ( leftArcherTowerDestroyed && getX() <= 155.0 && getY() < 230.0 )
				bridgeReached = true ;
		}

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

