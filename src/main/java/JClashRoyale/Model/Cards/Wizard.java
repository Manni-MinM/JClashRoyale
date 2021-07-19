package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public class Wizard extends Card{
    public Wizard(){
        setImageAddress("/JClashRoyale/assets/wizard.png");
    }

    @Override
    public int getHP() {
        switch (Player.player.getLevel()) {
            case 1:
                return 340;
            case 2:
                return 374;
            case 3:
                return 411;
            case 4:
                return 452;
            case 5:
                return 496;
        }
        return 0;
    }

    @Override
    public int getDamage() {
        switch (Player.player.getLevel()) {
            case 1:
                return 130;
            case 2:
                return 143;
            case 3:
                return 157;
            case 4:
                return 172;
            case 5:
                return 189;
        }
        return 0;
    }
}