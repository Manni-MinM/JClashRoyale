package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class MiniPekkaCard extends Card{
    public MiniPekkaCard(){
        setImageAddress("/JClashRoyale/assets/mini_pekka.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 600;
            case 2:
                return 660;
            case 3:
                return 726;
            case 4:
                return 798;
            case 5:
                return 876;
        }
        return 0;
    }

    @Override
    public int getDamage() {
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
        return 0;
    }
}
