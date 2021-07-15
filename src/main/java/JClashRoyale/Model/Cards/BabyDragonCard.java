package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class BabyDragonCard extends Card{
    public BabyDragonCard(){
        setImageAddress("/JClashRoyale/assets/baby_dragon.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 800;
            case 2:
                return 880;
            case 3:
                return 968;
            case 4:
                return 1064;
            case 5:
                return 1168;
        }
        return 0;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 100;
            case 2:
                return 110;
            case 3:
                return 121;
            case 4:
                return 133;
            case 5:
                return 146;
        }
        return 0;
    }
}
