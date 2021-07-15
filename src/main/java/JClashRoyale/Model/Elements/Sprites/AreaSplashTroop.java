// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import javafx.scene.image.Image ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Model.Elements.Enums ;
import JClashRoyale.Model.Elements.Sprite ;

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
		this.runAnimationLeft = new Image(path , width , height , false , false) ;
	}
	public void setRunAnimationRight(String path , double width , double height) {
		this.runAnimationRight = new Image(path , width , height , false , false) ;
	}
	public void setBattleAnimationFirst(String path , double width , double height) {
		this.battleAnimationFirst = new Image(path , width , height , false , false) ;
	}
	public void setBattleAnimationSecond(String path , double width , double height) {
		this.battleAnimationSecond = new Image(path , width , height , false , false) ;
	}
	// Methods : Getters
	
	// Methods : Other
	public void draw(GraphicsContext graphics) {
		graphics.drawImage(getStateImage() , getX() , getY()) ;
	}
	public void walk(int frameCount) {
		double x = getX() ;
		double y = getY() - (0.017) * runSpeed ;
		setLocation(x , y) ;

		if ( (frameCount / 15) % 2 == 0 ) {
			setStateImage(runAnimationLeft) ;
		} else { 
			setStateImage(runAnimationRight) ;
		
		}
	}
}

