// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.Random ;
import java.util.Objects ;
import java.util.ArrayList ;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Database;
import JClashRoyale.Model.Player;
import JClashRoyale.Model.SoundSystem;
import javafx.animation.AnimationTimer ;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar ;
import javafx.scene.image.Image ;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color ;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Controller.BattleController ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Sprite ;

import JClashRoyale.Model.Elements.Enums.ColorType ;
import JClashRoyale.Model.Elements.Enums.TroopType ;

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

import JClashRoyale.Model.Cards.KingTowerCard ;
import JClashRoyale.Model.Cards.ArcherTowerCard ;

import JClashRoyale.Model.Elements.Spells.Rage ;
import JClashRoyale.Model.Elements.Spells.Arrows ;
import JClashRoyale.Model.Elements.Spells.Fireball ;

import JClashRoyale.Model.Elements.Sprites.Building ;
import JClashRoyale.Model.Elements.Sprites.AreaSplashTroop ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

import JClashRoyale.Model.Elements.Sprites.Troops.Giant ;
import JClashRoyale.Model.Elements.Sprites.Troops.Wizard ;
import JClashRoyale.Model.Elements.Sprites.Troops.Archer ;
import JClashRoyale.Model.Elements.Sprites.Troops.Valkyrie ;
import JClashRoyale.Model.Elements.Sprites.Troops.Barbarian ;
import JClashRoyale.Model.Elements.Sprites.Troops.MiniPekka ;
import JClashRoyale.Model.Elements.Sprites.Troops.BabyDragon ;

import JClashRoyale.Model.Elements.Sprites.Buildings.Cannon ;
import JClashRoyale.Model.Elements.Sprites.Buildings.KingTower ;
import JClashRoyale.Model.Elements.Sprites.Buildings.ArcherTower ;
import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower ;
import javafx.scene.shape.Rectangle;

/**
 * The type Game manager.
 */
public class GameManager {
	// Fields
	private int elixer ;
	private int elixerBot ;

	private Image battleMap ;

	private Canvas canvas ;
	private GraphicsContext graphics ;

	private ArrayList<Spell> spells ;
	private ArrayList<Sprite> sprites ;

	private KingTower redKingTower ;
	private ArcherTower redArcherTowerLeft ;
	private ArcherTower redArcherTowerRight ;
	
	private KingTower blueKingTower ;
	private ArcherTower blueArcherTowerLeft ;
	private ArcherTower blueArcherTowerRight ;

	private final ArrayList<Card> botDeck = new ArrayList<>();
	private final ArrayList<Card> botOutOfHands = new ArrayList<>();

	/**
	 * Instantiates a new Game manager.
	 */
// Constructor
	public GameManager() {
		elixer = 5 ;
		elixerBot = 5 ;

		canvas = new Canvas(315 , 480) ;
		graphics = canvas.getGraphicsContext2D() ;

		redKingTower = new KingTower(ColorType.RED) ;
		redKingTower.setLocation(125 , 8) ;
		redKingTower.setDamage(KingTowerCard.getDamage()) ;
		redKingTower.setHitpoints(KingTowerCard.getHP()) ;

		redArcherTowerLeft = new ArcherTower(ColorType.RED) ;
		redArcherTowerLeft.setLocation(44 , 60) ;
		redArcherTowerLeft.setDamage(ArcherTowerCard.getDamage()) ;
		redArcherTowerLeft.setHitpoints(ArcherTowerCard.getHP()) ;

		redArcherTowerRight = new ArcherTower(ColorType.RED) ;
		redArcherTowerRight.setLocation(212 , 60) ;
		redArcherTowerRight.setDamage(ArcherTowerCard.getDamage()) ;
		redArcherTowerRight.setHitpoints(ArcherTowerCard.getHP()) ;

		blueKingTower = new KingTower(ColorType.BLUE) ;
		blueKingTower.setLocation(125 , 398) ;
		blueKingTower.setDamage(KingTowerCard.getDamage()) ;
		blueKingTower.setHitpoints(KingTowerCard.getHP()) ;

		blueArcherTowerLeft = new ArcherTower(ColorType.BLUE) ;
		blueArcherTowerLeft.setLocation(44 , 345) ;
		blueArcherTowerLeft.setDamage(ArcherTowerCard.getDamage()) ;
		blueArcherTowerLeft.setHitpoints(ArcherTowerCard.getHP()) ;

		blueArcherTowerRight = new ArcherTower(ColorType.BLUE) ;
		blueArcherTowerRight.setLocation(212 , 345) ;
		blueArcherTowerRight.setDamage(ArcherTowerCard.getDamage()) ;
		blueArcherTowerRight.setHitpoints(ArcherTowerCard.getHP()) ;

		spells = new ArrayList<Spell>() ;
		sprites = new ArrayList<Sprite>() ;

		sprites.add(redKingTower) ;
		sprites.add(redArcherTowerLeft) ;
		sprites.add(redArcherTowerRight) ;

		sprites.add(blueKingTower) ;
		sprites.add(blueArcherTowerLeft) ;
		sprites.add(blueArcherTowerRight) ;

		for (int i = 0; i < 4; i++) {
			botDeck.add(Player.player.getDeck().get(i));
		}
		for (int i = 4; i < 8; i++) {
			botOutOfHands.add(Player.player.getDeck().get(i));
		}
	}

	/**
	 * Sets battle map.
	 *
	 * @param path the path
	 */
// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , 315 , 480 , false , false) ;
	}

	/**
	 * Consume elixer.
	 *
	 * @param value the value
	 */
	public void consumeElixer(int value) {
		this.elixer -= value ;
		BattleController.updateAvailability(elixer);
	}

	/**
	 * Consume elixer bot.
	 *
	 * @param value the value
	 */
	public void consumeElixerBot(int value) {
		this.elixerBot -= value ;
	}

	/**
	 * Gets canvas.
	 *
	 * @return the canvas
	 */
// Methods : Getters
	public Canvas getCanvas() {
		return this.canvas ;
	}

	/**
	 * Gets graphics.
	 *
	 * @return the graphics
	 */
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}

	/**
	 * Gets elixer.
	 *
	 * @return the elixer
	 */
	public int getElixer() {
		return this.elixer ;
	}

	/**
	 * Gets elixer bot.
	 *
	 * @return the elixer bot
	 */
	public int getElixerBot() {
		return this.elixerBot ;
	}

	/**
	 * Left archer tower is destroyed boolean.
	 *
	 * @return the boolean
	 */
	public boolean leftArcherTowerIsDestroyed() {
		return this.redArcherTowerLeft.isDestroyed() ;
	}

	/**
	 * Right archer tower is destroyed boolean.
	 *
	 * @return the boolean
	 */
	public boolean rightArcherTowerIsDestroyed() {
		return this.redArcherTowerRight.isDestroyed() ;
	}

	/**
	 * Add spell.
	 *
	 * @param spell the spell
	 */
// Methods : Other
	public void addSpell(Spell spell) {
		spells.add(spell) ;
	}

	/**
	 * Add sprite.
	 *
	 * @param sprite the sprite
	 */
	public void addSprite(Sprite sprite) {
		sprites.add(sprite) ;
	}

	/**
	 * Load battle map.
	 */
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}

	/**
	 * Dummy bot.
	 */
	public void dummyBot() {
		if ( getElixerBot() < 5 )
			return ;

		Random random = new Random() ;
		int randomInt = random.nextInt(8) ;
		double randomX = random.nextDouble() * 250 + 25 ;
		double randomY = random.nextDouble() * 200 + 20 ;

		if ( randomInt == 0 ) {
			ArcherCard archerCard = new ArcherCard() ;
			Archer archer1 = new Archer(ColorType.RED) ;
			archer1.setHitpoints(archerCard.getHP()) ;
			archer1.setDamage(archerCard.getDamage()) ;
			archer1.setLocation(randomX - 10 , randomY) ;
			Archer archer2 = new Archer(ColorType.RED) ;
			archer2.setHitpoints(archerCard.getHP()) ;
			archer2.setDamage(archerCard.getDamage()) ;
			archer2.setLocation(randomX + 10 , randomY) ;
			if ( getElixerBot() >= archer1.getCost() ) {
				addSprite(archer1) ;
				addSprite(archer2) ;
				consumeElixerBot(archer1.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 1 ) {
			BabyDragonCard babyDragonCard = new BabyDragonCard() ;
			BabyDragon babyDragon = new BabyDragon(ColorType.RED) ;
			babyDragon.setHitpoints(babyDragonCard.getHP()) ;
			babyDragon.setDamage(babyDragonCard.getDamage()) ;
			babyDragon.setLocation(randomX , randomY) ;
			if ( getElixerBot() >= babyDragon.getCost() ) {
				addSprite(babyDragon) ;
				consumeElixerBot(babyDragon.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 2 ) {
			BarbariansCard barbariansCard = new BarbariansCard() ;
			Barbarian barbarian1 = new Barbarian(ColorType.RED) ;
			barbarian1.setHitpoints(barbariansCard.getHP()) ;
			barbarian1.setDamage(barbariansCard.getDamage()) ;
			barbarian1.setLocation(randomX + 15 , randomY + 10) ;
			Barbarian barbarian2 = new Barbarian(ColorType.RED) ;
			barbarian2.setHitpoints(barbariansCard.getHP()) ;
			barbarian2.setDamage(barbariansCard.getDamage()) ;
			barbarian2.setLocation(randomX - 15 , randomY + 10) ;
			Barbarian barbarian3 = new Barbarian(ColorType.RED) ;
			barbarian3.setHitpoints(barbariansCard.getHP()) ;
			barbarian3.setDamage(barbariansCard.getDamage()) ;
			barbarian3.setLocation(randomX + 15 , randomY - 10) ;
			Barbarian barbarian4 = new Barbarian(ColorType.RED) ;
			barbarian4.setHitpoints(barbariansCard.getHP()) ;
			barbarian4.setDamage(barbariansCard.getDamage()) ;
			barbarian4.setLocation(randomX - 15 , randomY - 10) ;
			if ( getElixerBot() >= barbarian1.getCost() ) {
				addSprite(barbarian1) ;
				addSprite(barbarian2) ;
				addSprite(barbarian3) ;
				addSprite(barbarian4) ;
				consumeElixerBot(barbarian1.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 3 ) {
			GiantCard giantCard = new GiantCard() ;
			Giant giant = new Giant(ColorType.RED) ;
			giant.setLocation(randomX , randomY) ;
			giant.setHitpoints(giantCard.getHP()) ;
			giant.setDamage(giantCard.getDamage()) ;
			if ( getElixerBot() >= giant.getCost() ) {
				addSprite(giant) ;
				consumeElixerBot(giant.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 4 ) {
			MiniPekkaCard miniPekkaCard = new MiniPekkaCard() ;
			MiniPekka miniPekka = new MiniPekka(ColorType.RED) ;
			miniPekka.setLocation(randomX , randomY) ;
			miniPekka.setHitpoints(miniPekkaCard.getHP()) ;
			miniPekka.setDamage(miniPekkaCard.getDamage()) ;
			if ( getElixerBot() >= miniPekka.getCost() ) {
				addSprite(miniPekka) ;
				consumeElixerBot(miniPekka.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 5 ) {
			ValkyrieCard valkyrieCard = new ValkyrieCard() ;
			Valkyrie valkyrie = new Valkyrie(ColorType.RED) ;
			valkyrie.setLocation(randomX , randomY) ;
			valkyrie.setHitpoints(valkyrieCard.getHP()) ;
			valkyrie.setDamage(valkyrieCard.getDamage()) ;
			if ( getElixerBot() >= valkyrie.getCost() ) {
				addSprite(valkyrie) ;
				consumeElixerBot(valkyrie.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 6 ) {
			RageCard rageCard = new RageCard() ;
			Rage rage = new Rage(ColorType.RED) ;
			rage.setLocation(randomX , randomY) ;
			rage.setDuration(rageCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			rage.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= rage.getCost() ) {
				addSpell(rage) ;
				consumeElixerBot(rage.getCost()) ;
			} else {
				return ;
			}
		} else if ( randomInt == 7 ) {
			FireballCard fireballCard = new FireballCard() ;
			Fireball fireball = new Fireball(ColorType.RED) ;
			fireball.setLocation(randomX , randomY) ;
			fireball.setDamage(fireballCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			fireball.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= fireball.getCost() ) {
				addSpell(fireball) ;
				consumeElixerBot(fireball.getCost()) ;
			} else {
				return ;
			}
		} 
	}

	/**
	 * Advanced bot.
	 */
	public void advancedBot() {
		if ( getElixerBot() < 5 )
			return ;

		Random random = new Random() ;
		int randomInt = random.nextInt(4) ;
		double randomX = random.nextDouble() * 250 + 25 ;
		double randomY = random.nextDouble() * 200 + 20 ;
		System.out.println(botDeck);
		if (blueArcherTowerLeft.getHitpoints() <= 400 && (doesHaveCard(new ArrowsCard()) | doesHaveCard(new FireballCard()))) {
			if (findCardInDeck(new ArrowsCard()) != null)
				deployCard(blueArcherTowerLeft.getX(), blueArcherTowerLeft.getY(), findCardInDeck(new ArrowsCard()));
			else
				deployCard(blueArcherTowerLeft.getX(), blueArcherTowerLeft.getY(), findCardInDeck(new FireballCard()));
			return;
		}
		else if (blueArcherTowerRight.getHitpoints() <= 400 && (doesHaveCard(new ArrowsCard()) | doesHaveCard(new FireballCard()))) {
			if (findCardInDeck(new ArrowsCard()) != null)
				deployCard(blueArcherTowerRight.getX(), blueArcherTowerRight.getY(), findCardInDeck(new ArrowsCard()));
			else
				deployCard(blueArcherTowerRight.getX(), blueArcherTowerRight.getY(), findCardInDeck(new FireballCard()));
			return;
		}

		if (doesHaveCard(new RageCard()) && findSpriteInMap() != null) {
			deployCard(findSpriteInMap().getX() - findSpriteInMap().getStateImage()
					.getWidth() / 2, findSpriteInMap().getY() - findSpriteInMap().getStateImage()
					.getHeight() / 2, findCardInDeck(new RageCard()));
			return;

		}


		if (redArcherTowerLeft.getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
			if (findCardInDeck(new CannonCard()) != null)
				deployCard(random.nextDouble() * 155 + 25, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
			else
				deployCard(random.nextDouble() * 155 + 25, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
			return;
		}
		else if (redArcherTowerRight.getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
			if (findCardInDeck(new CannonCard()) != null)
				deployCard(random.nextDouble() * 155 + 130, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
			else
				deployCard(random.nextDouble() * 155 + 130, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
			return;
		}
		else if (redKingTower.getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
			if (findCardInDeck(new CannonCard()) != null)
				deployCard(randomX, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
			else
				deployCard(randomX, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
			return;
		}




		deployCard(randomX,randomY,botDeck.get(randomInt));

	}

	private boolean doesHaveCard (Card card){
		for (Card card1 : botDeck) {
			if (card.getClass().getName().equalsIgnoreCase(card1.getClass().getName())){
				return true;
			}
		}
		return false;
	}

	private Sprite findSpriteInMap(){
		for (Sprite sprite : sprites) {
			if ((sprite instanceof KingTower) | (sprite instanceof ArcherTower | (sprite.getColorType().equals(ColorType.BLUE)))) continue;
			return sprite;
		}
		return null;
	}

	private Card findCardInDeck(Card card){
		for (Card card1 : botDeck) {
			if (card.getClass().getName().equalsIgnoreCase(card1.getClass().getName())){
				return card1;
			}
		}
		return null;
	}


	/**
	 * Deploy card.
	 *
	 * @param randomX      the random x
	 * @param randomY      the random y
	 * @param selectedCard the selected card
	 */
	public void deployCard(double randomX , double randomY, Card selectedCard) {
		if ( selectedCard instanceof ArcherCard ) {

			Archer archer1 = new Archer(ColorType.RED) ;
			Archer archer2 = new Archer(ColorType.RED) ;



			archer1.setHitpoints(selectedCard.getHP()) ;
			archer1.setDamage(selectedCard.getDamage()) ;
			archer1.setLocation(randomX - 10 , randomY) ;
			archer2.setHitpoints(selectedCard.getHP()) ;
			archer2.setDamage(selectedCard.getDamage()) ;
			archer2.setLocation(randomX + 10 , randomY) ;
			if ( getElixerBot() >= archer1.getCost() ) {
				addSprite(archer1) ;
				addSprite(archer2) ;
				consumeElixerBot(archer1.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof BabyDragonCard ) {

			BabyDragon babyDragon = new BabyDragon(ColorType.RED) ;


			babyDragon.setHitpoints(selectedCard.getHP()) ;
			babyDragon.setDamage(selectedCard.getDamage()) ;
			babyDragon.setLocation(randomX , randomY) ;
			if ( getElixerBot() >= babyDragon.getCost() ) {
				addSprite(babyDragon) ;
				consumeElixerBot(babyDragon.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof BarbariansCard ) {
			BarbariansCard barbariansCard = (BarbariansCard)selectedCard ;

			Barbarian barbarian1 = new Barbarian(ColorType.RED) ;
			Barbarian barbarian2 = new Barbarian(ColorType.RED) ;
			Barbarian barbarian3 = new Barbarian(ColorType.RED) ;
			Barbarian barbarian4 = new Barbarian(ColorType.RED) ;


			barbarian1.setHitpoints(barbariansCard.getHP()) ;
			barbarian1.setDamage(barbariansCard.getDamage()) ;
			barbarian1.setLocation(randomX + 15 , randomY + 10) ;
			barbarian2.setHitpoints(barbariansCard.getHP()) ;
			barbarian2.setDamage(barbariansCard.getDamage()) ;
			barbarian2.setLocation(randomX - 15 , randomY + 10) ;
			barbarian3.setHitpoints(barbariansCard.getHP()) ;
			barbarian3.setDamage(barbariansCard.getDamage()) ;
			barbarian3.setLocation(randomX + 15 , randomY - 10) ;
			barbarian4.setHitpoints(barbariansCard.getHP()) ;
			barbarian4.setDamage(barbariansCard.getDamage()) ;
			barbarian4.setLocation(randomX - 15 , randomY - 10) ;
			if ( getElixerBot() >= barbarian1.getCost() ) {
				addSprite(barbarian1) ;
				addSprite(barbarian2) ;
				addSprite(barbarian3) ;
				addSprite(barbarian4) ;
				consumeElixerBot(barbarian1.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof GiantCard ) {

			Giant giant = new Giant(ColorType.RED) ;


			giant.setLocation(randomX , randomY) ;
			giant.setHitpoints(selectedCard.getHP()) ;
			giant.setDamage(selectedCard.getDamage()) ;
			if ( getElixerBot() >= giant.getCost() ) {
				addSprite(giant) ;
				consumeElixerBot(giant.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof MiniPekkaCard ) {

			MiniPekka miniPekka = new MiniPekka(ColorType.RED) ;


			miniPekka.setLocation(randomX , randomY) ;
			miniPekka.setHitpoints(selectedCard.getHP()) ;
			miniPekka.setDamage(selectedCard.getDamage()) ;
			if ( getElixerBot() >= miniPekka.getCost() ) {
				addSprite(miniPekka) ;
				consumeElixerBot(miniPekka.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof ValkyrieCard ) {

			Valkyrie valkyrie = new Valkyrie(ColorType.RED) ;


			valkyrie.setLocation(randomX , randomY) ;
			valkyrie.setHitpoints(selectedCard.getHP()) ;
			valkyrie.setDamage(selectedCard.getDamage()) ;
			if ( getElixerBot() >= valkyrie.getCost() ) {
				addSprite(valkyrie) ;
				consumeElixerBot(valkyrie.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof WizardCard ) {

			Wizard wizard = new Wizard(ColorType.RED) ;


			wizard.setLocation(randomX , randomY) ;
			wizard.setHitpoints(selectedCard.getHP()) ;
			wizard.setDamage(selectedCard.getDamage()) ;
			if ( getElixerBot() >= wizard.getCost() ) {
				addSprite(wizard) ;
				consumeElixerBot(wizard.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof CannonCard ) {

			Cannon cannon = new Cannon(ColorType.RED) ;


			cannon.setLocation(randomX , randomY) ;
			cannon.setHitpoints(selectedCard.getHP()) ;
			cannon.setDamage(selectedCard.getDamage()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			cannon.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= cannon.getCost() ) {
				addSprite(cannon) ;
				consumeElixerBot(cannon.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof InfernoTowerCard ) {

			InfernoTower infernoTower = new InfernoTower(ColorType.RED) ;


			infernoTower.setLocation(randomX , randomY) ;
			infernoTower.setHitpoints(selectedCard.getHP()) ;
			infernoTower.setDamage(selectedCard.getDamage()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			infernoTower.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= infernoTower.getCost() ) {
				addSprite(infernoTower) ;
				consumeElixerBot(infernoTower.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof RageCard ) {
			RageCard rageCard = (RageCard)selectedCard ;
			Rage rage = new Rage(ColorType.RED) ;


			rage.setLocation(randomX , randomY) ;
			rage.setDuration(rageCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			rage.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= rage.getCost() ) {
				addSpell(rage) ;
				consumeElixerBot(rage.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof FireballCard ) {
			FireballCard fireballCard = (FireballCard)selectedCard ;
			Fireball fireball = new Fireball(ColorType.RED) ;


			fireball.setLocation(randomX , randomY) ;
			fireball.setDamage(fireballCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			fireball.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= fireball.getCost() ) {
				addSpell(fireball) ;
				consumeElixerBot(fireball.getCost()); ;
			} else {
				return ;
			}
		} else if ( selectedCard instanceof ArrowsCard ) {
			ArrowsCard arrowsCard = (ArrowsCard)selectedCard ;
			Arrows arrows = new Arrows(ColorType.RED) ;


			arrows.setLocation(randomX , randomY) ;
			arrows.setDamage(arrowsCard.getAttribute()) ;
			double timeNow = ((long)System.nanoTime()) / 1000000000.0 ;
			arrows.setDeploymentTime(timeNow) ;
			if ( getElixerBot() >= arrows.getCost() ) {
				addSpell(arrows) ;
				consumeElixerBot(arrows.getCost()); ;
			} else {
				return ;
			}
		} else {
			// Pass
		}
		botDeck.remove(selectedCard);
		botDeck.add(botOutOfHands.get(0));
		botOutOfHands.remove(0);
		botOutOfHands.add(selectedCard);


	}


	/**
	 * Update.
	 *
	 * @param timerField  the timer field
	 * @param elixerField the elixer field
	 * @param elixerBar   the elixer bar
	 * @param endGame     the end game
	 * @param resultLabel the result label
	 * @param backButton  the back button
	 */
	public void update(TextField timerField, TextField elixerField, ProgressBar elixerBar
			, Rectangle endGame, Label resultLabel, Button backButton) {
		final long startNanoTime = System.nanoTime() ;
		new AnimationTimer() {
			int timeOffset = 0 ;
			int frameCount = 0 ;
			public void handle(long currentNanoTime) {
				double timeNow = ((currentNanoTime - startNanoTime) / 1000000000.0) ;
				double elixerTime = timeNow - timeOffset ;
				double elixerBotTime = timeNow - timeOffset ;
				if ( (int) (180 - timeNow) % 60 < 10 ) {
					timerField.setText((int) ((180 - timeNow) / 60) + ":0" + (int) (180 - timeNow)%60);
				} else {
					timerField.setText((int) ((180 - timeNow) / 60) + ":" + (int) (180 - timeNow)%60);
				}

				if (blueKingTower.isDestroyed() || redKingTower.isDestroyed() || (timeNow >= 180)){
					int playerScore = 0;
					int opponentScore = 0;
					boolean won;

					if (blueArcherTowerLeft.isDestroyed()) opponentScore++;
					if (blueArcherTowerRight.isDestroyed()) opponentScore++;
					if (blueKingTower.isDestroyed()) opponentScore = 3;
					if (redArcherTowerLeft.isDestroyed()) playerScore++;
					if (redArcherTowerRight.isDestroyed()) playerScore++;
					if (redKingTower.isDestroyed()) playerScore = 3;
					String opponent = "Idiot Bot";
					if (App.advancedAI) opponent = "Advanced AI";
					if (playerScore > opponentScore){
						won = true;
						Database.addBattleResult(Player.player.getUsername(),opponent, playerScore, opponentScore,true);
					} else if (opponentScore > playerScore){
						won = false;
						Database.addBattleResult(Player.player.getUsername(),opponent, playerScore, opponentScore,false);
					} else {
						double playerHP = blueArcherTowerLeft.getHitpoints() + blueArcherTowerRight.getHitpoints() + blueKingTower.getHitpoints();
						double opponentHP = redArcherTowerLeft.getHitpoints() + redArcherTowerRight.getHitpoints() + redKingTower.getHitpoints();
						if (playerHP > opponentHP){
							won = true;
							Database.addBattleResult(Player.player.getUsername(),opponent, playerScore + 1, opponentScore,true);
						} else {
							won = false;
							Database.addBattleResult(Player.player.getUsername(),opponent, playerScore, opponentScore + 1,false);
						}
					}
					resultLabel.setVisible(true);
					resultLabel.setDisable(false);
					endGame.setVisible(true);
					endGame.setDisable(false);
					backButton.setVisible(true);
					backButton.setDisable(false);
					if (won) resultLabel.setText("You: " + playerScore + " --- Opponent: " + opponentScore + " YOU WON");
					else resultLabel.setText("You: " + playerScore + " --- Opponent: " + opponentScore + " YOU LOST!!!");
					if (App.music) SoundSystem.stopBattleMusic();
					App.advancedAI = false;
					int xp;
					int cup;
					if (App.advancedAI){
						xp = 400;
						cup = 40;
					} else {
						xp = 200;
						cup = 30;
					}
					if (won){
						Player.player.setCup(Player.player.getCup() + cup);
						Player.player.setXp(Player.player.getXP() + xp);
						this.stop() ;
					} else {
						Player.player.setCup(Player.player.getCup() - cup);
						Player.player.setXp(Player.player.getXP() + 70);
						this.stop() ;
					}
				}
				if (timeNow <= 120) {
					if (elixerTime >= 2.0) {
						timeOffset++;
						elixer = Math.min(elixer + 1, 10);
						elixerBot = Math.min(elixerBot + 1, 10);
					} else {
						// Pass
					}
				} else {
					if (elixerTime >= 1.0) {
						timeOffset++;
						elixer = Math.min(elixer + 1, 10);
						elixerBot = Math.min(elixerBot + 1, 10);
					} else {
						// Pass
					}
				}

				elixerField.setText(String.valueOf(elixer)) ;
				elixerBar.setProgress(elixer / 10.0);
				BattleController.updateAvailability(elixer);

				graphics.clearRect(0 , 0 , 315 , 480) ;
				loadBattleMap() ;
				elixerField.setText(String.valueOf(elixer)) ;

				if (!App.advancedAI)
					dummyBot() ;
				else advancedBot();

				ArrayList<Sprite> walkingSprites = new ArrayList<Sprite>() ;
				ArrayList<Sprite> attackingSprites = new ArrayList<Sprite>() ;

				for ( Sprite sprite : sprites ) {
					if ( sprite.getAttackState() ) {
						attackingSprites.add(sprite) ;
					} else {
						walkingSprites.add(sprite) ;
					}
				}

				for ( Sprite sprite : walkingSprites ) {
					if ( sprite.getColorType() == ColorType.BLUE ) {
						sprite.walk(redArcherTowerLeft.isDestroyed() , redArcherTowerRight.isDestroyed()) ;
					} else {
						sprite.walk(blueArcherTowerLeft.isDestroyed() , blueArcherTowerRight.isDestroyed()) ;
					}
				}

				ArrayList<Sprite> toBeRemoved = new ArrayList<Sprite>() ;
				ArrayList<Spell> toBeRemovedSpell = new ArrayList<Spell>() ;
				for ( int it = 0 ; it < spells.size() ; it ++ ) {
					Spell spell = spells.get(it) ;
					ArrayList<Sprite> affectedSprites = new ArrayList<Sprite>() ;
					for ( int jt = 0 ; jt < sprites.size() ; jt ++ ) {
						if ( it == jt )
							continue ;
						Sprite sprite = sprites.get(jt) ;
						if ( spell.canAffect(sprite) ) {
							affectedSprites.add(sprite) ;
						}
					}
					for ( Sprite defender : affectedSprites ) {
						spell.affect(defender) ;
						if ( defender.getHitpoints() <= 0 ) {
							if ( defender instanceof KingTower ) {
								KingTower kingTower = (KingTower)defender ;
								kingTower.destroy() ;
							} else if ( defender instanceof ArcherTower ) {
								ArcherTower archerTower = (ArcherTower)defender ;
								archerTower.destroy() ;
							} else {
								toBeRemoved.add(defender) ;
							}
						} else {
							// Pass
						}
					}
					if ( spell instanceof Arrows || spell instanceof Fireball )
						spell.setDamage(0) ;
				}
				for ( int it = 0 ; it < sprites.size() ; it ++ ) {
					Sprite attacker = sprites.get(it) ;
					ArrayList<Sprite> defenders = new ArrayList<Sprite>() ;
					for ( int jt = 0 ; jt < sprites.size() ; jt ++ ) {
						if ( it == jt )
							continue ;
						Sprite defender = sprites.get(jt) ;
						if ( attacker.canAttack(defender) ) {
							defenders.add(defender) ;
							if ( attacker instanceof SingleTargetTroop ) {
								break ;
							} else {
								// Pass
							}
						}
					}
					if ( defenders.isEmpty() ) {
						attacker.setAttackState(false) ;
					} else if ( timeNow - attacker.getLastAttack() > attacker.getAttackSpeed() ) {
						attacker.attack(defenders) ;
						attacker.setLastAttack(timeNow) ;
						for ( Sprite defender : defenders ) {
							if ( defender.getHitpoints() <= 0 ) {
								attacker.setAttackState(false) ;
								if ( defender instanceof KingTower ) {
									KingTower kingTower = (KingTower)defender ;
									kingTower.destroy() ;
								} else if ( defender instanceof ArcherTower ) {
									ArcherTower archerTower = (ArcherTower)defender ;
									archerTower.destroy() ;
								} else {
									toBeRemoved.add(defender) ;
								}
							} else {
								// Pass
							}
						}
					} else {
						// Pass
					}
				}
				for ( Sprite sprite : sprites )
					if ( sprite instanceof Cannon || sprite instanceof InfernoTower ) {
						Building building = (Building)sprite ;
						if ( (currentNanoTime / 1000000000.0) - building.getDeploymentTime() >= building.getLifetime() )
							toBeRemoved.add(building) ;
					}
				for ( Sprite sprite : toBeRemoved )
						sprites.remove(sprite) ;

				for ( Spell spell : spells )
					if ( (currentNanoTime / 1000000000.0) - spell.getDeploymentTime() >= spell.getDuration() )
						toBeRemovedSpell.add(spell) ;
				for ( Spell spell : toBeRemovedSpell )
					spells.remove(spell) ;

				for ( Spell spell : spells ) {
					spell.draw(graphics) ;
				}
				for ( Sprite sprite : sprites ) {
//					sprite.showRangeCircle(graphics) ;
//					sprite.showHealthCircle(graphics) ;
					sprite.draw(graphics) ;
				}

				frameCount = (frameCount + 1) % 60 ;
			}
		}.start() ;
	}
}

