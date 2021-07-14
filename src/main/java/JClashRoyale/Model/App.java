package JClashRoyale.Model;

import JClashRoyale.Controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/JClashRoyale/" + "battle" + ".fxml"));
        scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage = stage1;
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(true);
        stage.setTitle("JClashRoyale");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/JClashRoyale/assets/icon.png"))));

		BattleController battleController = (BattleController)fxmlLoader.getController() ;
        battleController.init(stage) ;
		battleController.start() ;

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/JClashRoyale/" + fxml + ".fxml"));
        scene.setRoot(fxmlLoader.load());
        if (fxmlLoader.getController() instanceof PrimaryController)
            ((PrimaryController) fxmlLoader.getController()).init(stage);
        else if (fxmlLoader.getController() instanceof SecondaryController)
            ((SecondaryController) fxmlLoader.getController()).init(stage);
        else if (fxmlLoader.getController() instanceof ProfileSectionController)
            ((ProfileSectionController) fxmlLoader.getController()).init(stage);
        else if (fxmlLoader.getController() instanceof BattleDeckSectionController)
            ((BattleDeckSectionController) fxmlLoader.getController()).init(stage);
        stage.hide();
        stage.show();
    }

    public void run() {
        launch();
    }

}
