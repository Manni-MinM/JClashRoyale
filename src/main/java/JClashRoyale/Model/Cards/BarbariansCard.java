package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * The type Barbarians card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public class BarbariansCard extends Card{
    /**
     * Instantiates a new Barbarians card.
     */
    public BarbariansCard(){
        setImageAddress("/JClashRoyale/assets/barbarians.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 300;
            case 2:
                return 330;
            case 3:
                return 363;
            case 4:
                return 438;
            case 5:
                return 480;
        }
        return 300;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 75;
            case 2:
                return 82;
            case 3:
                return 90;
            case 4:
                return 99;
            case 5:
                return 109;
        }
        return 75;
    }
}
