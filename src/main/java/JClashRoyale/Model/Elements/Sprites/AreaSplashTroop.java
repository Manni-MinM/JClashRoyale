// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;

import java.util.Objects;

public class AreaSplashTroop extends Sprite {
	// Fields
	protected Image runAnimationLeft ;
	protected Image runAnimationRight ;
	protected Image runAnimationForward ;
	protected Image battleAnimation ;
	// Constructor
	public AreaSplashTroop() {
		// Pass
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
		graphics.drawImage(getStateImage() , getX() , getY()) ;
	}
	public void walk(int frameCount) {
		double x = getX() ;
		double y = getY() ;
		if ( getColorType() == ColorType.BLUE ) {
			y -= (0.017) * runSpeed ;
		} else if ( getColorType() == ColorType.RED ) {
			y += (0.017) * runSpeed ;
		} else {
			// Pass
		}
		setLocation(x , y) ;
		// TODO
		setStateImage(runAnimationForward) ;
	}
}

