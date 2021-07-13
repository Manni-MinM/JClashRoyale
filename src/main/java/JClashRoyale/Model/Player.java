package JClashRoyale.Model;


/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/11/2021
 */
public class Player {
    private final String username;
    private int cup;
    private int xp;
    private int level;

    public static Player player;

    public Player(String username, int cup, int xp) {
        this.username = username;
        this.cup = cup;
        this.xp = xp;
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
}
