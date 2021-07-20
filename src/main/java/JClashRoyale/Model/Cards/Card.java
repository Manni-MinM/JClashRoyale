package JClashRoyale.Model.Cards;

import java.util.ArrayList;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public abstract class Card {
    private String imageAddress;
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


    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public abstract int getHP();

    public abstract int getDamage();
}
