// BWOTSHEWCHB

package JClashRoyale.Model.Elements.Sprites ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.TroopType ;

/**
 * The type Building.
 */
public abstract class Building extends Sprite {
    /**
     * The Lifetime.
     */
// Fields
	protected double lifetime ;
    /**
     * The Deployment time.
     */
    protected double deploymentTime ;

    /**
     * Instantiates a new Building.
     */
// Constructor
	public Building() {
		// Pass
	}

    /**
     * Sets lifetime.
     *
     * @param lifetime the lifetime
     */
// Methods : Setters
	public void setLifetime(double lifetime) {
		this.lifetime = lifetime ;
	}

    /**
     * Sets deployment time.
     *
     * @param deploymentTime the deployment time
     */
    public void setDeploymentTime(double deploymentTime) {
		this.deploymentTime = deploymentTime ;
	}

    /**
     * Gets lifetime.
     *
     * @return the lifetime
     */
// Methods : Getters
	public double getLifetime() {
		return this.lifetime ;
	}

    /**
     * Gets deployment time.
     *
     * @return the deployment time
     */
    public double getDeploymentTime() {
		return this.deploymentTime ;
	}
	// Methods : Other
	public void walkForward() {
		// Do Nothing
	}
	public void walkBridge() {
		// Do Nothing
	}
	public void walkKingTower() {
		// Do Nothing
	}
	public void walk(boolean leftArcherTowerDestroyed , boolean rightArcherTowerDestroyed) {
		// Do Nothing
	}
}

