// BWOTSHEWCHB

package JClashRoyale.Controller;

import JClashRoyale.Model.App;
import JClashRoyale.Model.SoundSystem;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
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

import java.io.IOException;
import java.util.*;

import JClashRoyale.Model.Player ;

import JClashRoyale.Model.Cards.Card ;
import JClashRoyale.Model.Cards.GiantCard ;
import JClashRoyale.Model.Cards.ArcherCard ;
import JClashRoyale.Model.Cards.WizardCard ;
import JClashRoyale.Model.Cards.RageCard ;
import JClashRoyale.Model.Cards.ArrowsCard ;
import JClashRoyale.Model.Cards.CannonCard ;
import JClashRoyale.Model.Cards.FireballCard ;
import JClashRoyale.Model.Cards.ValkyrieCard ;
import JClashRoyale.Model.Cards.MiniPekkaCard ;
import JClashRoyale.Model.Cards.BarbariansCard ;
import JClashRoyale.Model.Cards.BabyDragonCard ;
import JClashRoyale.Model.Cards.InfernoTowerCard ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Sprite ;
import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Spells.Rage ;
import JClashRoyale.Model.Elements.Spells.Arrows ;
import JClashRoyale.Model.Elements.Spells.Fireball ;
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
    @FXML private Rectangle endGame;
    @FXML private Button backButton;
    @FXML private Label resultLabel;



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

        if (App.music) SoundSystem.battleTheme();

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
        start();
        Collections.shuffle(deck);
        initCards();
        cards.forEach(card -> card.getImageView().setOnMouseClicked(mouseEvent -> deckCardOnMousePressedAction(card.getImageView())));
        gameViewPane.setOnMouseClicked(this::deployCard);
    }

	@FXML
	private void switchToSecondary() throws IOException {
		SoundSystem.mouseClickSFX();
		if (App.music) SoundSystem.mainMenuTheme();
		App.setRoot("secondary");
	}

    public void start() {
        gameStarter = new GameStarter() ;
		gameManager = gameStarter.getGameManager() ;

		gameStarter.initBattle(timer , result , elixer , elixerBar , gameViewPane, endGame, resultLabel, backButton) ;
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
		if ( selectedCard.getCard() instanceof ArcherCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			ArcherCard archerCard = (ArcherCard)selectedCard.getCard() ;

			Archer archer1 = new Archer(ColorType.BLUE) ;
			Archer archer2 = new Archer(ColorType.BLUE) ;

			double X = event.getX() - (archer1.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (archer1.getStateImage().getHeight() / 2.0) ;

			archer1.setHitpoints(archerCard.getHP()) ;
			archer1.setDamage(archerCard.getDamage()) ;
			archer1.setLocation(X - 10 , Y) ;
			archer2.setHitpoints(archerCard.getHP()) ;
			archer2.setDamage(archerCard.getDamage()) ;
			archer2.setLocation(X + 10 , Y) ;
			if ( gameManager.getElixer() >= archer1.getCost() ) {
				gameManager.addSprite(archer1) ;
				gameManager.addSprite(archer2) ;
				gameManager.consumeElixer(archer1.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof BabyDragonCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			BabyDragonCard babyDragonCard = (BabyDragonCard)selectedCard.getCard() ;

			BabyDragon babyDragon = new BabyDragon(ColorType.BLUE) ;

			double X = event.getX() - (babyDragon.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (babyDragon.getStateImage().getHeight() / 2.0) ;

			babyDragon.setHitpoints(selectedCard.getCard().getHP()) ;
			babyDragon.setDamage(selectedCard.getCard().getDamage()) ;
			babyDragon.setLocation(X , Y) ;
			if ( gameManager.getElixer() >= babyDragon.getCost() ) {
				gameManager.addSprite(babyDragon) ;
				gameManager.consumeElixer(babyDragon.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof BarbariansCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			BarbariansCard barbariansCard = (BarbariansCard)selectedCard.getCard() ;

			Barbarian barbarian1 = new Barbarian(ColorType.BLUE) ;
			Barbarian barbarian2 = new Barbarian(ColorType.BLUE) ;
			Barbarian barbarian3 = new Barbarian(ColorType.BLUE) ;
			Barbarian barbarian4 = new Barbarian(ColorType.BLUE) ;

			double X = event.getX() - (barbarian1.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (barbarian1.getStateImage().getHeight() / 2.0) ;

			barbarian1.setHitpoints(barbariansCard.getHP()) ;
			barbarian1.setDamage(barbariansCard.getDamage()) ;
			barbarian1.setLocation(X + 15 , Y + 10) ;
			barbarian2.setHitpoints(barbariansCard.getHP()) ;
			barbarian2.setDamage(barbariansCard.getDamage()) ;
			barbarian2.setLocation(X - 15 , Y + 10) ;
			barbarian3.setHitpoints(barbariansCard.getHP()) ;
			barbarian3.setDamage(barbariansCard.getDamage()) ;
			barbarian3.setLocation(X + 15 , Y - 10) ;
			barbarian4.setHitpoints(barbariansCard.getHP()) ;
			barbarian4.setDamage(barbariansCard.getDamage()) ;
			barbarian4.setLocation(X - 15 , Y - 10) ;
			if ( gameManager.getElixer() >= barbarian1.getCost() ) {
				gameManager.addSprite(barbarian1) ;
				gameManager.addSprite(barbarian2) ;
				gameManager.addSprite(barbarian3) ;
				gameManager.addSprite(barbarian4) ;
				gameManager.consumeElixer(barbarian1.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof GiantCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			GiantCard giantCard = (GiantCard)selectedCard.getCard() ;

			Giant giant = new Giant(ColorType.BLUE) ;

			double X = event.getX() - (giant.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (giant.getStateImage().getHeight() / 2.0) ;

			giant.setLocation(X , Y) ;
			giant.setHitpoints(selectedCard.getCard().getHP()) ;
			giant.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= giant.getCost() ) {
				gameManager.addSprite(giant) ;
				gameManager.consumeElixer(giant.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof MiniPekkaCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			MiniPekkaCard miniPekkaCard = (MiniPekkaCard)selectedCard.getCard() ;

			MiniPekka miniPekka = new MiniPekka(ColorType.BLUE) ;

			double X = event.getX() - (miniPekka.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (miniPekka.getStateImage().getHeight() / 2.0) ;

			miniPekka.setLocation(X , Y) ;
			miniPekka.setHitpoints(selectedCard.getCard().getHP()) ;
			miniPekka.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= miniPekka.getCost() ) {
				gameManager.addSprite(miniPekka) ;
				gameManager.consumeElixer(miniPekka.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof ValkyrieCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			ValkyrieCard valkyrieCard = (ValkyrieCard)selectedCard.getCard() ;

			Valkyrie valkyrie = new Valkyrie(ColorType.BLUE) ;

			double X = event.getX() - (valkyrie.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (valkyrie.getStateImage().getHeight() / 2.0) ;

			valkyrie.setLocation(X , Y) ;
			valkyrie.setHitpoints(selectedCard.getCard().getHP()) ;
			valkyrie.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= valkyrie.getCost() ) {
				gameManager.addSprite(valkyrie) ;
				gameManager.consumeElixer(valkyrie.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof WizardCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			WizardCard wizardCard = (WizardCard)selectedCard.getCard() ;

			Wizard wizard = new Wizard(ColorType.BLUE) ;

			double X = event.getX() - (wizard.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (wizard.getStateImage().getHeight() / 2.0) ;

			wizard.setLocation(X , Y) ;
			wizard.setHitpoints(selectedCard.getCard().getHP()) ;
			wizard.setDamage(selectedCard.getCard().getDamage()) ;
			if ( gameManager.getElixer() >= wizard.getCost() ) {
				gameManager.addSprite(wizard) ;
				gameManager.consumeElixer(wizard.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof CannonCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			CannonCard cannonCard = (CannonCard)selectedCard.getCard() ;

			Cannon cannon = new Cannon(ColorType.BLUE) ;

			double X = event.getX() - (cannon.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (cannon.getStateImage().getHeight() / 2.0) ;

			cannon.setLocation(X , Y) ;
			cannon.setHitpoints(selectedCard.getCard().getHP()) ;
			cannon.setDamage(selectedCard.getCard().getDamage()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			cannon.setDeploymentTime(timeNow) ;
			if ( gameManager.getElixer() >= cannon.getCost() ) {
				gameManager.addSprite(cannon) ;
				gameManager.consumeElixer(cannon.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof InfernoTowerCard ) {
			if ( gameManager.leftArcherTowerIsDestroyed() && gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 140 )
					return ;
			} else if ( gameManager.leftArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() >= 155) )
					return ;
			} else if ( gameManager.rightArcherTowerIsDestroyed() ) {
				if ( event.getY() < 230 && (event.getY() < 140 || event.getX() < 155) )
						return ;
			} else if ( event.getY() > 450.0 || event.getY() < 230 ) {
				return ;
			} else {
				// Pass
			}
			InfernoTowerCard infernoTowerCard = (InfernoTowerCard)selectedCard.getCard() ;

			InfernoTower infernoTower = new InfernoTower(ColorType.BLUE) ;

			double X = event.getX() - (infernoTower.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (infernoTower.getStateImage().getHeight() / 2.0) ;

			infernoTower.setLocation(X , Y) ;
			infernoTower.setHitpoints(selectedCard.getCard().getHP()) ;
			infernoTower.setDamage(selectedCard.getCard().getDamage()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			infernoTower.setDeploymentTime(timeNow) ;
			if ( gameManager.getElixer() >= infernoTower.getCost() ) {
				gameManager.addSprite(infernoTower) ;
				gameManager.consumeElixer(infernoTower.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof RageCard ) {
			RageCard rageCard = (RageCard)selectedCard.getCard() ;
			Rage rage = new Rage(ColorType.BLUE) ;

			double X = event.getX() - (rage.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (rage.getStateImage().getHeight() / 2.0) ;

			rage.setLocation(X , Y) ;
			rage.setDuration(rageCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			rage.setDeploymentTime(timeNow) ;
			if ( gameManager.getElixer() >= rage.getCost() ) {
				gameManager.addSpell(rage) ;
				gameManager.consumeElixer(rage.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof FireballCard ) {
			FireballCard fireballCard = (FireballCard)selectedCard.getCard() ;
			Fireball fireball = new Fireball(ColorType.BLUE) ;

			double X = event.getX() - (fireball.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (fireball.getStateImage().getHeight() / 2.0) ;

			fireball.setLocation(X , Y) ;
			fireball.setDamage(fireballCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			fireball.setDeploymentTime(timeNow) ;
			if ( gameManager.getElixer() >= fireball.getCost() ) {
				gameManager.addSpell(fireball) ;
				gameManager.consumeElixer(fireball.getCost()) ;
			} else {
				return ;
			}
		} else if ( selectedCard.getCard() instanceof ArrowsCard ) {
			ArrowsCard arrowsCard = (ArrowsCard)selectedCard.getCard() ;
			Arrows arrows = new Arrows(ColorType.BLUE) ;

			double X = event.getX() - (arrows.getStateImage().getWidth() / 2.0) ;
			double Y = event.getY() - (arrows.getStateImage().getHeight() / 2.0) ;

			arrows.setLocation(X , Y) ;
			arrows.setDamage(arrowsCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			arrows.setDeploymentTime(timeNow) ;
			if ( gameManager.getElixer() >= arrows.getCost() ) {
				gameManager.addSpell(arrows) ;
				gameManager.consumeElixer(arrows.getCost()) ;
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
            } else {
                bannedCards.get(imagePackage).setDisable(false);
                bannedCards.get(imagePackage).setVisible(true);
            }
        }
    }

    private static int getCost(ImagePackage imagePackage) {
        if ( imagePackage.getCard() instanceof ArcherCard ) {
            return 3;
        } else if ( imagePackage.getCard() instanceof BabyDragonCard ) {
            return 4;
        } else if ( imagePackage.getCard() instanceof BarbariansCard ) {
            return 5;
        } else if ( imagePackage.getCard() instanceof GiantCard ) {
            return 5;
        } else if ( imagePackage.getCard() instanceof MiniPekkaCard ) {
            return 4;
        } else if ( imagePackage.getCard() instanceof ValkyrieCard ) {
            return 4;
        } else if ( imagePackage.getCard() instanceof WizardCard ) {
            return 5;
        } else if ( imagePackage.getCard() instanceof CannonCard ) {
            return 3;
        } else if ( imagePackage.getCard() instanceof RageCard ) {
            return 2;
        } else if ( imagePackage.getCard() instanceof ArrowsCard ) {
            return 3;
        } else if ( imagePackage.getCard() instanceof FireballCard ) {
            return 4;
        } else if ( imagePackage.getCard() instanceof InfernoTowerCard ) {
            return 5;
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

