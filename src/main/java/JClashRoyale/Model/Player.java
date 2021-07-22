package JClashRoyale.Model;


import JClashRoyale.Model.Cards.Card;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Player.
 *
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7 /11/2021
 */
public class Player {
    private final String username;
    private int cup;
    private int xp;
    private int level;
    private final ArrayList<Card> deck = new ArrayList<>();

    /**
     * The constant league.
     */
    public static String league;
    /**
     * The constant player.
     */
    public static Player player;

    /**
     * Instantiates a new Player.
     *
     * @param username the username
     * @param cup      the cup
     * @param xp       the xp
     * @param deck     the deck
     */
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

    /**
     * Gets deck.
     *
     * @return the deck
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     * Gets cup.
     *
     * @return the cup
     */
    public int getCup() {
        return cup;
    }

    /**
     * Sets cup.
     *
     * @param cup the cup
     */
    public void setCup(int cup) {
        this.cup = cup;
        setLeague();
        Database.updateCup();
    }

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXP() {
        return xp;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets xp.
     *
     * @param xp the xp
     */
    public void setXp(int xp) {
        this.xp = xp;
        Database.updateXP();
    }

    /**
     * Gets username.
     *
     * @return the username
     */
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
