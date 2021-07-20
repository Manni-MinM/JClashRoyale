package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class ArcherCard extends Card{
    public ArcherCard(){
        setImageAddress("/JClashRoyale/assets/archers.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 125;
            case 2:
                return 127;
            case 3:
                return 151;
            case 4:
                return 166;
            case 5:
                return 182;
        }
        return 125;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 33;
            case 2:
                return 44;
            case 3:
                return 48;
            case 4:
                return 53;
            case 5:
                return 58;
        }
        return 33;
    }
}
