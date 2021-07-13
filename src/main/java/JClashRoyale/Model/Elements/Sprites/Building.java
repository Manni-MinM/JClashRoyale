// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.TroopType ;
import JClashRoyale.Model.Elements.Enums.TargetType ;

public abstract class Building extends Sprite {
	// Fields
	protected double lifetime ;
	// Constructor
	public Building() {
		// Pass
	}
	// Methods : Setters
	public void setLifetime(double lifetime) {
		this.lifetime = lifetime ;
	}
	// Methods : Getters
	public double getLifetime() {
		return this.lifetime ;
	}
	// Methods : Other
	
}
