package JClashRoyale.Controller;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Cards.Card;
import JClashRoyale.Model.Database;
import JClashRoyale.Model.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    private final ArrayList<ImagePackage> cards = new ArrayList<>();
    @FXML
    private ImageView oneSwap;
    @FXML
    private ImageView twoSwap;
    @FXML
    private ImageView threeSwap;
    @FXML
    private ImageView fourSwap;
    private final ArrayList<ImagePackage> swapCards = new ArrayList<>();

    @FXML
    private Label label;

    @FXML
    private ImagePackage selectedCard;

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
        swapCards.forEach(swapCard -> swapCard.getImageView().setOnMouseClicked(mouseEvent -> onMousePressedAction(swapCard.getImageView())));
        cards.forEach(card -> card.getImageView().setOnMouseClicked(mouseEvent -> deckCardOnMousePressedAction(card.getImageView())));
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    private void showDeck() {
        cards.addAll(Arrays.asList(new ImagePackage(one, Player.player.getDeck().get(0)),
                new ImagePackage(two, Player.player.getDeck().get(1)),
                new ImagePackage(three, Player.player.getDeck().get(2)),
                new ImagePackage(four, Player.player.getDeck().get(3)),
                new ImagePackage(five, Player.player.getDeck().get(4)),
                new ImagePackage(six, Player.player.getDeck().get(5)),
                new ImagePackage(seven, Player.player.getDeck().get(6)),
                new ImagePackage(eight, Player.player.getDeck().get(7))));
    }

    private void showSwapDeck() {
        swapCards.addAll(Arrays.asList(new ImagePackage(oneSwap, null),
                new ImagePackage(twoSwap, null),
                new ImagePackage(threeSwap, null),
                new ImagePackage(fourSwap, null)));
        int i = 0;
        for (Card gameCard : Card.gameCards) {
            if (!Player.player.getDeck().contains(gameCard)) {
                swapCards.get(i).setCard(gameCard);
                i++;
            }
        }
    }

    private void onMousePressedAction(ImageView imageView) {
        if (selectedCard != null)
            if (selectedCard.getImageView() == imageView) {
                selectedCard.getImageView().setOpacity(1);
                selectedCard = null;
                return;
            } else if (selectedCard != null) {
                selectedCard.getImageView().setOpacity(1);
                selectedCard = null;
            }
        selectedCard = findImagePackageByImageView(swapCards,imageView);
        assert selectedCard != null;
        selectedCard.getImageView().setOpacity(0.5);
    }

    private void deckCardOnMousePressedAction(ImageView imageView) {
        if (selectedCard == null)
            return;
        Card temp = selectedCard.getCard();
        selectedCard.setCard(Objects.requireNonNull(findImagePackageByImageView(cards, imageView)).getCard());
        selectedCard.getImageView().setOpacity(1);
        Objects.requireNonNull(findImagePackageByImageView(cards, imageView)).setCard(temp);
        selectedCard = null;
    }

    public void saveDeck() {
        Player.player.getDeck().removeAll(Player.player.getDeck());
        for (ImagePackage card : cards) {
            Player.player.getDeck().add(card.getCard());
        }
        label.setTextFill(Color.web("#28C76F"));
        label.setText("Deck saved.");
        Database.updateDeck();
    }

    private ImagePackage findImagePackageByImageView(ArrayList<ImagePackage> imagePackages, ImageView imageView) {
        for (ImagePackage imagePackage : imagePackages) {
            if (imagePackage.getImageView() == imageView) return imagePackage;
        }
        return null;
    }

    static class ImagePackage {
        private final ImageView imageView;
        private Card card;

        public ImagePackage(ImageView imageView, Card card) {
            this.imageView = imageView;
            this.card = card;
            if (card != null) {
                this.imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(this.card.getImageAddress()
                ))));
            }
        }

        public ImageView getImageView() {
            return imageView;
        }

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
            this.imageView.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream(this.card.getImageAddress()
            ))));
        }
    }

}
