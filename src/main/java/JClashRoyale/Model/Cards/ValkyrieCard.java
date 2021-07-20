package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class ValkyrieCard extends Card {
    public ValkyrieCard() {
        setImageAddress("/JClashRoyale/assets/valkyrie.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 880;
            case 2:
                return 968;
            case 3:
                return 1064;
            case 4:
                return 1170;
            case 5:
                return 1284;
        }
        return 880;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 120;
            case 2:
                return 132;
            case 3:
                return 145;
            case 4:
                return 159;
            case 5:
                return 175;
        }
        return 120;
    }
}
