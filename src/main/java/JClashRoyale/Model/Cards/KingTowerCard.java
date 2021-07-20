package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/19/2021
 */
public class KingTowerCard {
    public static int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 2400;
            case 2:
                return 2568;
            case 3:
                return 2736;
            case 4:
                return 2904;
            case 5:
                return 3096;
        }
        return 2400;
    }

    public static int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 50;
            case 2:
                return 53;
            case 3:
                return 57;
            case 4:
                return 60;
            case 5:
                return 64;
        }
        return 50;
    }
}
