package JClashRoyale.Model;


import JClashRoyale.Model.Cards.Card;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/11/2021
 */
public class Player {
    private final String username;
    private int cup;
    private int xp;
    private int level;
    private final ArrayList<Card> deck = new ArrayList<>();

    public static Player player;

    public Player(String username, int cup, int xp, String deck) {
        this.username = username;
        this.cup = cup;
        this.xp = xp;
        String[] cards = deck.split("-");
        System.out.println(Arrays.toString(cards));
        for (String card : cards) {
            this.deck.add(Card.gameCards.get(Integer.parseInt(card)));
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getCup() {
        return cup;
    }

    public void setCup(int cup) {
        this.cup = cup;
    }

    public int getXP() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getUsername() {
        return username;
    }
}
