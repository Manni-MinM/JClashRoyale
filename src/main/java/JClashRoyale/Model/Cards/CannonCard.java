package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * The type Cannon card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public class CannonCard extends Card{
    /**
     * Instantiates a new Cannon card.
     */
    public CannonCard(){
        setImageAddress("/JClashRoyale/assets/cannon.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 380;
            case 2:
                return 418;
            case 3:
                return 459;
            case 4:
                return 505;
            case 5:
                return 554;
        }
        return 380;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 60;
            case 2:
                return 66;
            case 3:
                return 72;
            case 4:
                return 79;
            case 5:
                return 87;
        }
        return 60;
    }
}
