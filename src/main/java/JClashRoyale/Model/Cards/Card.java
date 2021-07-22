package JClashRoyale.Model.Cards;

import java.util.ArrayList;

/**
 * The type Card.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /13/2021
 */
public abstract class Card {
    private String imageAddress;
    /**
     * The constant gameCards.
     */
    public static ArrayList<Card> gameCards = new ArrayList<>();
    static {
        gameCards.add(new ArcherCard());
        gameCards.add(new ArrowsCard());
        gameCards.add(new BabyDragonCard());
        gameCards.add(new BarbariansCard());
        gameCards.add(new CannonCard());
        gameCards.add(new FireballCard());
        gameCards.add(new GiantCard());
        gameCards.add(new InfernoTowerCard());
        gameCards.add(new MiniPekkaCard());
        gameCards.add(new RageCard());
        gameCards.add(new ValkyrieCard());
        gameCards.add(new WizardCard());
    }


    /**
     * Gets image address.
     *
     * @return the image address
     */
    public String getImageAddress() {
        return imageAddress;
    }

    /**
     * Sets image address.
     *
     * @param imageAddress the image address
     */
    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public abstract int getHP();

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public abstract int getDamage();
}
