package JClashRoyale.Model;

import JClashRoyale.Model.Cards.Card;

import java.sql.*;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/9/2021
 */
public class Database {
    private static Connection connection;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerDone(String username, String password) {
        String insertion = "INSERT INTO accounts(username,password,xp,cup,deck) values (\"" + username + "\" , \"" + password + "\"" +
                ", 0, 0, '0-1-2-3-4-5-6-7')";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(insertion);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static boolean successfulLogin(String username, String password) {
        String check = "SELECT * FROM accounts WHERE username='" + username +
                "'AND password='" + password + "'";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(check);
            if (statement.getResultSet().next()) {
                Player.player = new Player(statement.getResultSet().getString(1), statement.getResultSet().getInt(4)
                        , statement.getResultSet().getInt(3), statement.getResultSet().getString(5));
            } else return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static void updateDeck() {
        String deck = "";
        for (Card card : Player.player.getDeck()) {
            deck = deck.concat(Integer.toString(Card.gameCards.indexOf(card)));
            if (Player.player.getDeck().indexOf(card) != 7)
                deck += "-";
        }
        String update = "UPDATE accounts " +
                "SET deck = '" + deck + "'" +
                "WHERE username = '" + Player.player.getUsername() + "';";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(update);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateXP() {
        String update = "UPDATE accounts " +
                "SET xp = '" + Player.player.getXP() + "'" +
                "WHERE username = '" + Player.player.getUsername() + "';";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(update);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateCup() {
        String update = "UPDATE accounts " +
                "SET cup = '" + Player.player.getCup() + "'" +
                "WHERE username = '" + Player.player.getUsername() + "';";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(update);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet getBattleResult(String player) {
        String check = "SELECT * FROM battles WHERE player='" + player +
                "'";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(check);
            if (statement.getResultSet().next()) {
                return statement.getResultSet();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void addBattleResult(String player, String opponent, int playerScore, int opponentScore, boolean playerWon) {
        String insertion = "INSERT INTO battles(player,opponent,playerScore,opponentScore,playerWon)" +
                " values (\"" + player + "\" , \"" + opponent + "\"" +
                ", " + playerScore +
                ", " + opponentScore + ", " + playerWon + ")";
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JClashRoyale",
                    "root", "pashmak64bit");
            Statement statement = connection.createStatement();
            statement.execute(insertion);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
