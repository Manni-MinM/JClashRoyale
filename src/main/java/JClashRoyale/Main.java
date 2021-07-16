package JClashRoyale;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Database;

/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 6/29/2021
 */
public class Main {
    public static void main(String[] args) {
        Database.successfulLogin("asd","asd");
        App app = new App();
        app.run();
    }
}
