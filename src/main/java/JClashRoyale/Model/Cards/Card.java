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
        gameCards.add(new Archer());
        gameCards.add(new Arrows());
        gameCards.add(new BabyDragon());
        gameCards.add(new Barbarians());
        gameCards.add(new Cannon());
        gameCards.add(new Fireball());
        gameCards.add(new Giant());
        gameCards.add(new InfernoTower());
        gameCards.add(new MiniPekka());
        gameCards.add(new Rage());
        gameCards.add(new Valkyrie());
        gameCards.add(new Wizard());
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
