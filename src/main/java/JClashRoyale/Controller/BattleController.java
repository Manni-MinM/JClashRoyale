// BWOTSHEWCHB

package JClashRoyale.Controller;

import javafx.fxml.FXML;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.*;

import JClashRoyale.Model.Player ;

import JClashRoyale.Model.Cards.Card ;
import JClashRoyale.Model.Cards.GiantCard ;
import JClashRoyale.Model.Cards.ArcherCard ;
import JClashRoyale.Model.Cards.WizardCard ;
import JClashRoyale.Model.Cards.CannonCard ;
import JClashRoyale.Model.Cards.ValkyrieCard ;
import JClashRoyale.Model.Cards.MiniPekkaCard ;
import JClashRoyale.Model.Cards.BabyDragonCard ;
import JClashRoyale.Model.Cards.BarbariansCard ;
import JClashRoyale.Model.Cards.InfernoTowerCard ;

import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Sprites.Troops.Giant ;
import JClashRoyale.Model.Elements.Sprites.Troops.Archer ;
import JClashRoyale.Model.Elements.Sprites.Troops.Wizard ;
import JClashRoyale.Model.Elements.Sprites.Troops.Valkyrie ;
import JClashRoyale.Model.Elements.Sprites.Troops.MiniPekka ;
import JClashRoyale.Model.Elements.Sprites.Troops.Barbarian ;
import JClashRoyale.Model.Elements.Sprites.Troops.BabyDragon ;
import JClashRoyale.Model.Elements.Sprites.Buildings.Cannon ;
import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower ;

import JClashRoyale.Model.Logic.GameStarter ;
import JClashRoyale.Model.Logic.GameManager ;

public class BattleController {
    // Fields
    double x, y;
    private final ArrayList<Card> deck = new ArrayList<>(Player.player.getDeck());
    private final ArrayList<ImagePackage> cards = new ArrayList<>();
    private final ArrayList<Card> outOfHandCards = new ArrayList<>();
    private ImagePackage selectedCard;
    private ImagePackage nextCard;
    public static HashMap<ImagePackage , Rectangle> bannedCards = new HashMap<>();

    GameStarter gameStarter ;
	GameManager gameManager ;

    @FXML private Pane titlePane;
    @FXML private TextField timer;
    @FXML private TextField result;
    @FXML private TextField elixer;
    @FXML private ProgressBar elixerBar;
    @FXML private Label messageLabel;
    @FXML private Pane deckViewPane;
    @FXML private Pane gameViewPane;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private ImageView one, two, three, four, next;
    @FXML private Rectangle cardBan1 , cardBan2 , cardBan3 , cardBan4;

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
        cards.forEach(card -> card.getImageView().setOnMouseClicked(mouseEvent -> deckCardOnMousePressedAction(card.getImageView())));
        gameViewPane.setOnMouseClicked(this::deployCard);
    }

    public void start() {
        gameStarter = new GameStarter() ;
		gameManager = gameStarter.getGameManager() ;

		gameStarter.initBattle(timer , result , elixer , elixerBar , gameViewPane) ;
    }

    private void initCards() {
        cards.addAll(Arrays.asList(new ImagePackage(one, deck.get(0)),
                new ImagePackage(two, deck.get(1)),
                new ImagePackage(three, deck.get(2)),
                new ImagePackage(four, deck.get(3))));
        bannedCards.put(cards.get(0), cardBan1);
        bannedCards.put(cards.get(1), cardBan2);
        bannedCards.put(cards.get(2), cardBan3);
        bannedCards.put(cards.get(3), cardBan4);
        nextCard = new ImagePackage(next, deck.get(4));
        for (int i = 5; i < 8; i++) outOfHandCards.add(deck.get(i));
    }

    private void deckCardOnMousePressedAction(ImageView imageView) {
        if (selectedCard != null)
            if (selectedCard.getImageView() == imageView) {
                selectedCard.getImageView().setOpacity(1);
                selectedCard = null;
                return;
            } else if (selectedCard != null) {
                selectedCard.getImageView().setOpacity(1);
                selectedCard = null;
            }
        selectedCard = findImagePackageByImageView(cards, imageView);
        assert selectedCard != null;
        selectedCard.getImageView().setOpacity(0.5);
    }

    private ImagePackage findImagePackageByImageView(ArrayList<ImagePackage> imagePackages, ImageView imageView) {
        for (ImagePackage imagePackage : imagePackages) {
            if (imagePackage.getImageView() == imageView) return imagePackage;
        }
        return null;
    }

    public void deployCard(MouseEvent event) {
		if ( event.getY() > 450.0 || event.getY() < 250 )
			return ;
		if ( selectedCard.getCard() instanceof ArcherCard ) {
			Archer archer = new Archer(ColorType.BLUE) ;
			archer.setHitpoints(selectedCard.getCard().getHP()) ;
			archer.setDamage(selectedCard.getCard().getDamage()) ;
			archer.setLocation(event.getX() , event.getY()) ;
			if ( gameManager.getElixer() >= archer.getCost() ) {
				gameManager.addSprite(archer) ;
				gameManager.consumeElixer(archer.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof BabyDragonCard ) {
			BabyDragon babyDragon = new BabyDragon(ColorType.BLUE) ;
			babyDragon.setHitpoints(selectedCard.getCard().getHP()) ;
			babyDragon.setDamage(selectedCard.getCard().getDamage()) ;
			babyDragon.setLocation(event.getX() , event.getY()) ;
			if ( gameManager.getElixer() >= babyDragon.getCost() ) {
				gameManager.addSprite(babyDragon) ;
				gameManager.consumeElixer(babyDragon.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof BarbariansCard ) {
			Barbarian barbarian = new Barbarian(ColorType.RED) ;
			barbarian.setLocation(event.getX() , event.getY()) ;
			barbarian.setHitpoints(selectedCard.getCard().getHP()) ;
			barbarian.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= barbarian.getCost() ) {
				gameManager.addSprite(barbarian) ;
				gameManager.consumeElixer(barbarian.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof GiantCard ) {
			Giant giant = new Giant(ColorType.RED) ;
			giant.setLocation(event.getX() , event.getY()) ;
			giant.setHitpoints(selectedCard.getCard().getHP()) ;
			giant.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= giant.getCost() ) {
				gameManager.addSprite(giant) ;
				gameManager.consumeElixer(giant.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof MiniPekkaCard ) {
			MiniPekka miniPekka = new MiniPekka(ColorType.BLUE) ;
			miniPekka.setLocation(event.getX() , event.getY()) ;
			miniPekka.setHitpoints(selectedCard.getCard().getHP()) ;
			miniPekka.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= miniPekka.getCost() ) {
				gameManager.addSprite(miniPekka) ;
				gameManager.consumeElixer(miniPekka.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof ValkyrieCard ) {
			Valkyrie valkyrie = new Valkyrie(ColorType.BLUE) ;
			valkyrie.setLocation(event.getX() , event.getY()) ;
			valkyrie.setHitpoints(selectedCard.getCard().getHP()) ;
			valkyrie.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= valkyrie.getCost() ) {
				gameManager.addSprite(valkyrie) ;
				gameManager.consumeElixer(valkyrie.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof WizardCard ) {
			Wizard wizard = new Wizard(ColorType.BLUE) ;
			wizard.setLocation(event.getX() , event.getY()) ;
			wizard.setHitpoints(selectedCard.getCard().getHP()) ;
			wizard.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= wizard.getCost() ) {
				gameManager.addSprite(wizard) ;
				gameManager.consumeElixer(wizard.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof CannonCard ) {
			Cannon cannon = new Cannon(ColorType.BLUE) ;
			cannon.setLocation(event.getX() , event.getY()) ;
			cannon.setHitpoints(selectedCard.getCard().getHP()) ;
			cannon.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= cannon.getCost() ) {
				gameManager.addSprite(cannon) ;
				gameManager.consumeElixer(cannon.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof InfernoTowerCard ) {
			InfernoTower infernoTower = new InfernoTower(ColorType.BLUE) ;
			infernoTower.setLocation(event.getX() , event.getY()) ;
			infernoTower.setHitpoints(selectedCard.getCard().getHP()) ;
			infernoTower.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= infernoTower.getCost() ) {
				gameManager.addSprite(infernoTower) ;
				gameManager.consumeElixer(infernoTower.getCost()) ;
			} else {
				return ;
			}
		} else {
			// Pass
		}

        Card temp = selectedCard.getCard();
        selectedCard.getImageView().setOpacity(1);
        selectedCard.setCard(nextCard.getCard());
        nextCard.setCard(outOfHandCards.get(0));
        outOfHandCards.remove(0);
        outOfHandCards.add(temp);
        selectedCard = null;
    }

    public static void updateAvailability( int elixer ){
        for (ImagePackage imagePackage : bannedCards.keySet()) {
            if (elixer >= getCost(imagePackage)){
                bannedCards.get(imagePackage).setDisable(true);
                bannedCards.get(imagePackage).setVisible(false);
            }
        }
    }

    private static int getCost(ImagePackage imagePackage) {
        if ( imagePackage.getCard() instanceof ArcherCard ) {
            Archer temp = new Archer(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof BabyDragonCard ) {
            BabyDragon temp = new BabyDragon(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof BarbariansCard ) {
            Barbarian temp = new Barbarian(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof GiantCard ) {
            Giant temp = new Giant(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof MiniPekkaCard ) {
            MiniPekka temp = new MiniPekka(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof ValkyrieCard ) {
            Valkyrie temp = new Valkyrie(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof WizardCard ) {
            Wizard temp = new Wizard(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof CannonCard ) {
            Cannon temp = new Cannon(ColorType.BLUE);
            return temp.getCost();
        } else if ( imagePackage.getCard() instanceof InfernoTowerCard ) {
            InfernoTower temp = new InfernoTower(ColorType.BLUE);
            return temp.getCost();
        }

        return 0;
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

