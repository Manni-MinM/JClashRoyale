// BWOTSHEWCHB

package JClashRoyale.Controller;

import JClashRoyale.Model.Cards.Card;
import JClashRoyale.Model.Player;
import javafx.fxml.FXML;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import JClashRoyale.Model.Logic.GameStarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class BattleController {
    // Fields
    double x, y;
    private final ArrayList<Card> deck = new ArrayList<>(Player.player.getDeck());
    private final ArrayList<ImagePackage> cards = new ArrayList<>();

    GameStarter gameStarter;

    @FXML
    private Pane titlePane;
    @FXML
    private TextField timer;
    @FXML
    private TextField result;
    @FXML
    private TextField elixer;
    @FXML
    private Label messageLabel;
    @FXML
    private Pane deckViewPane;
    @FXML
    private Pane gameViewPane;
    @FXML
    private ImageView btnMinimize, btnClose;
    @FXML
    private ImageView one, two, three, four;

    // Methods
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
        Collections.shuffle(deck);
        initCards();
    }

    public void start() {
        gameStarter = new GameStarter();

        gameStarter.initDeck(deckViewPane);
        gameStarter.initBattle(gameViewPane);
    }

    private void initCards() {
        cards.addAll(Arrays.asList(new ImagePackage(one, deck.get(0)),
                new ImagePackage(two, deck.get(1)),
                new ImagePackage(three, deck.get(2)),
                new ImagePackage(four, deck.get(3))));
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

