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
	protected Image battleAnimationFirst ;
	protected Image battleAnimationSecond ;
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
	public void setBattleAnimationFirst(String path , double width , double height) {
		this.battleAnimationFirst = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
	}
	public void setBattleAnimationSecond(String path , double width , double height) {
		this.battleAnimationSecond = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path))  , width , height , false , false) ;
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

		if ( (frameCount / 15) % 2 == 0 ) {
			setStateImage(runAnimationLeft) ;
		} else { 
			setStateImage(runAnimationRight) ;
		
		}
	}
}

