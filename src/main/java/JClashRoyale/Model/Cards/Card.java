package JClashRoyale.Model.Cards;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/13/2021
 */
public abstract class Card {
    private String imageAddress;

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public abstract int getHP();
    public abstract int getDamage();
}
