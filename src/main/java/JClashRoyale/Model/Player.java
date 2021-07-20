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

    public static String league;
    public static Player player;

    public Player(String username, int cup, int xp, String deck) {
        this.username = username;
        this.cup = cup;
        setLeague();
        this.xp = xp;
        String[] cards = deck.split("-");
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
        setLeague();
        Database.updateCup();
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
        Database.updateXP();
    }

    public String getUsername() {
        return username;
    }

    private void setLeague() {
        if (cup <= 50)
            league = "BRONZE";
        else if (cup <= 100)
            league = "SILVER";
        else if (cup <= 150)
            league = "GOLD";
        else if (cup <= 200)
            league = "MASTER";
        else if (cup <= 250)
            league = "ROYALE CHAMPION";
        else
            league = "ULTIMATE CHAMPION";
    }
}
