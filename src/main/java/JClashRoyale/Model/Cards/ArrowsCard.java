package JClashRoyale.Model.Cards;

import JClashRoyale.Model.Player;

/**
 * The type Arrows card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public class ArrowsCard extends Card{
    /**
     * Instantiates a new Arrows card.
     */
    public ArrowsCard(){
        setImageAddress("/JClashRoyale/assets/arrows.png");
    }

    @Override
    public int getHP() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * Gets attribute.
     *
     * @return the attribute
     */
    public double getAttribute() {

        switch (Player.player.getLevel()) {
            case 1:
                return 144;
            case 2:
                return 156;
            case 3:
                return 174;
            case 4:
                return 189;
            case 5:
                return 210;
        }
        return 144;
    }
}
