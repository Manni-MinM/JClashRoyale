package JClashRoyale.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        String insertion = "INSERT INTO accounts(username,password,xp,cup) values (\"" + username + "\" , \"" + password + "\"" +
                ", 0, 0)";
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
                        , statement.getResultSet().getInt(3));
            }
            else return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
