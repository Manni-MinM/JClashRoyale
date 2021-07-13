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
	public void setRedRunAnimationLeft(String path) {
		this.redRunAnimationLeft = new Image(path) ;
	}
	public void setRedRunAnimationRight(String path) {
		this.redRunAnimationRight = new Image(path) ;
	}
	public void setBlueRunAnimationLeft(String path) {
		this.blueRunAnimationLeft = new Image(path) ;
	}
	public void setBlueRunAnimationRight(String path) {
		this.blueRunAnimationRight = new Image(path) ;
	}
	public void setRedBattleAnimationFirst(String path) {
		this.redBattleAnimationFirst = new Image(path) ;
	}
	public void setRedBattleAnimationSecond(String path) {
		this.redBattleAnimationSecond = new Image(path) ;
	}
	public void setBlueBattleAnimationFirst(String path) {
		this.blueBattleAnimationFirst = new Image(path) ;
	}
	public void setBlueBattleAnimationSecond(String path) {
		this.blueBattleAnimationSecond = new Image(path) ;
	}
	// Methods : Getters
	
	// Methods : Other
	
}

