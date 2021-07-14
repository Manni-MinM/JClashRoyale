// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import javafx.scene.image.Image ;

import JClashRoyale.Model.Elements.Enums ;
import JClashRoyale.Model.Elements.Sprite ;

public class SingleTargetTroop extends Sprite {
	// Fields
	protected Image redRunAnimationLeft ;
	protected Image redRunAnimationRight ;
	protected Image blueRunAnimationLeft ;
	protected Image blueRunAnimationRight ;
	protected Image redBattleAnimationFirst ;
	protected Image redBattleAnimationSecond ;
	protected Image blueBattleAnimationFirst ;
	protected Image blueBattleAnimationSecond ;
	// Constructor
	public SingleTargetTroop() {
		// Pass
	}
	// Methods : Setters
	public void setRedRunAnimationLeft(String path , double width , double height) {
		this.redRunAnimationLeft = new Image(path , width , height , false , false) ;
	}
	public void setRedRunAnimationRight(String path , double width , double height) {
		this.redRunAnimationRight = new Image(path , width , height , false , false) ;
	}
	public void setBlueRunAnimationLeft(String path , double width , double height) {
		this.blueRunAnimationLeft = new Image(path , width , height , false , false) ;
	}
	public void setBlueRunAnimationRight(String path , double width , double height) {
		this.blueRunAnimationRight = new Image(path , width , height , false , false) ;
	}
	public void setRedBattleAnimationFirst(String path , double width , double height) {
		this.redBattleAnimationFirst = new Image(path , width , height , false , false) ;
	}
	public void setRedBattleAnimationSecond(String path , double width , double height) {
		this.redBattleAnimationSecond = new Image(path , width , height , false , false) ;
	}
	public void setBlueBattleAnimationFirst(String path , double width , double height) {
		this.blueBattleAnimationFirst = new Image(path , width , height , false , false) ;
	}
	public void setBlueBattleAnimationSecond(String path , double width , double height) {
		this.blueBattleAnimationSecond = new Image(path , width , height , false , false) ;
	}
	// Methods : Getters
	public Image getRedRunAnimationLeft() {
		return this.redRunAnimationLeft ;
	}
	// Methods : Other
	public void walk(int frameCount) {
		// TODO
		double x = getX() ;
		double y = getY() + (0.017) * runSpeed ;
		setLocation(x , y) ;

		if ( (frameCount / 15) % 2 == 0 ) {
			setStateImage(redRunAnimationLeft) ;
		} else { 
			setStateImage(redRunAnimationRight) ;
		
		}
	}
}

