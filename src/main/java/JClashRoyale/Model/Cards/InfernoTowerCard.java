package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class InfernoTowerCard extends Card implements AdjustableDamage{
    public InfernoTowerCard(){
        setImageAddress("/JClashRoyale/assets/inferno_tower.png");
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
        return 800;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 20;
            case 2:
                return 22;
            case 3:
                return 24;
            case 4:
                return 26;
            case 5:
                return 29;
        }
        return 20;
    }

    @Override
    public int getRange() {
        switch (Player.player.getLevel()) {
            case 1:
                return 400;
            case 2:
                return 440;
            case 3:
                return 484;
            case 4:
                return 532;
            case 5:
                return 584;
        }
        return 0;
    }
}
