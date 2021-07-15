package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class Cannon extends Card{
    public Cannon(){
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
        return 0;
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
        return 0;
    }
}
