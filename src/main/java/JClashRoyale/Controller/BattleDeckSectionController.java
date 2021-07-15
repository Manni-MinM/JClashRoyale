package JClashRoyale.Controller;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Cards.Card;
import JClashRoyale.Model.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


/**
 * @author Amir Iravanimanesh & Manni Moghimi
 * @since 7/11/2021
 */
public class BattleDeckSectionController {
    @FXML
    private Pane titlePane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView three;
    @FXML
    private ImageView four;
    @FXML
    private ImageView five;
    @FXML
    private ImageView six;
    @FXML
    private ImageView seven;
    @FXML
    private ImageView eight;
    private ArrayList<ImageView> cards = new ArrayList<>();
    @FXML
    private ImageView oneSwap;
    @FXML
    private ImageView twoSwap;
    @FXML
    private ImageView threeSwap;
    @FXML
    private ImageView fourSwap;
    private ArrayList<ImageView> swapCards = new ArrayList<>();

    @FXML
    private ImageView selectedCard;

    private double x, y;

    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
        showDeck();
        showSwapDeck();
        swapCards.forEach(swapCard -> swapCard.setOnMouseClicked(mouseEvent -> onMousePressedAction(mouseEvent, swapCard)));
        cards.forEach(card -> card.setOnMouseClicked(mouseEvent -> deckCardOnMousePressedAction(mouseEvent, card)));
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    private void showDeck() {
        cards.addAll(Arrays.asList(one, two, three, four, five, six, seven, eight));
        for (int i = 0; i < 8; i++) {
            cards.get(i).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                    Player.player.getDeck().get(i).getImageAddress()
            ))));
        }
    }

    private void showSwapDeck() {
        swapCards.addAll(Arrays.asList(oneSwap, twoSwap, threeSwap, fourSwap));
        int i = 0;
        for (Card gameCard : Card.gameCards) {
            if (!Player.player.getDeck().contains(gameCard)) {
                swapCards.get(i).setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                        gameCard.getImageAddress()
                ))));
                i++;
            }
        }
    }

    private void onMousePressedAction(MouseEvent event, ImageView imageView) {
        if (selectedCard == imageView){
            selectedCard.setOpacity(1);
            selectedCard = new ImageView();
            return;
        } else if (selectedCard != null) selectedCard.setOpacity(1);
        selectedCard = imageView;
        selectedCard.setOpacity(0.5);
    }

    private void deckCardOnMousePressedAction(MouseEvent event, ImageView imageView) {
        if (!swapCards.contains(selectedCard))
            return;
        Image temp = selectedCard.getImage();
        selectedCard.setImage(imageView.getImage());
        imageView.setImage(temp);
        selectedCard.setOpacity(1);
        selectedCard = new ImageView();
    }

}
