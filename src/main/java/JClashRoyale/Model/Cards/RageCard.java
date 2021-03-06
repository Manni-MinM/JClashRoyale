package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * The type Rage card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public class RageCard extends Card {
    /**
     * Instantiates a new Rage card.
     */
    public RageCard(){
        setImageAddress("/JClashRoyale/assets/rage.png");
    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * Gets attribute.
     *
     * @return the attribute
     */
    public double getAttribute() {
        switch (Player.player.getLevel()) {
            case 1:
                return 6;
            case 2:
                return 6.5;
            case 3:
                return 7;
            case 4:
                return 7.5;
            case 5:
                return 8;
        }
        return 6;
    }
}
