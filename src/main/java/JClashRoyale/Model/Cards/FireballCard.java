package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * The type Fireball card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public class FireballCard extends Card {
    /**
     * Instantiates a new Fireball card.
     */
    public FireballCard() {
        setImageAddress("/JClashRoyale/assets/fire_fireball.png");
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
                return 325;
            case 2:
                return 357;
            case 3:
                return 393;
            case 4:
                return 432;
            case 5:
                return 474;
        }
        return 325;
    }
}
