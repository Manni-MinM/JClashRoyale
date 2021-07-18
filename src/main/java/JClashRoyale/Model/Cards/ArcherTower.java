package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/19/2021
 */
public class ArcherTower {
    public static int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 1400;
            case 2:
                return 1512;
            case 3:
                return 1624;
            case 4:
                return 1750;
            case 5:
                return 1890;
        }
        return 0;
    }

    public static int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 50;
            case 2:
                return 54;
            case 3:
                return 58;
            case 4:
                return 62;
            case 5:
                return 69;
        }
        return 0;
    }
}
