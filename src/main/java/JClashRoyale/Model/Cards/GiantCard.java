package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class GiantCard extends Card{
    public GiantCard(){
        setImageAddress("/JClashRoyale/assets/giant.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 2000;
            case 2:
                return 2200;
            case 3:
                return 2420;
            case 4:
                return 2660;
            case 5:
                return 2920;
        }
        return 2000;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 126;
            case 2:
                return 138;
            case 3:
                return 152;
            case 4:
                return 167;
            case 5:
                return 183;
        }
        return 126;
    }
}
