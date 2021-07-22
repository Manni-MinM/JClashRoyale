// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.Objects ;
import java.util.ArrayList ;

import JClashRoyale.Model.App;
import JClashRoyale.Model.Database;
import JClashRoyale.Model.Logic.Bots.AdvancedAi;
import JClashRoyale.Model.Logic.Bots.IdiotAi;
import JClashRoyale.Model.Player;
import JClashRoyale.Model.SoundSystem;
import javafx.animation.AnimationTimer ;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar ;
import javafx.scene.image.Image ;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas ;
import javafx.scene.canvas.GraphicsContext ;

import JClashRoyale.Controller.BattleController ;

import JClashRoyale.Model.Elements.Spell ;
import JClashRoyale.Model.Elements.Sprite ;

import JClashRoyale.Model.Elements.Enums.ColorType ;

import JClashRoyale.Model.Cards.Card ;

import JClashRoyale.Model.Cards.KingTowerCard ;
import JClashRoyale.Model.Cards.ArcherTowerCard ;

import JClashRoyale.Model.Elements.Spells.Arrows ;
import JClashRoyale.Model.Elements.Spells.Fireball ;

import JClashRoyale.Model.Elements.Sprites.Building ;
import JClashRoyale.Model.Elements.Sprites.SingleTargetTroop ;

import JClashRoyale.Model.Elements.Sprites.Buildings.Cannon ;
import JClashRoyale.Model.Elements.Sprites.Buildings.KingTower ;
import JClashRoyale.Model.Elements.Sprites.Buildings.ArcherTower ;
import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower ;
import javafx.scene.shape.Rectangle;

/**
 * The type Game manager.
 */
public class GameManager {
	private final AI ai;
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
		if (App.advancedAI) ai = new AdvancedAi(this);
		else ai = new IdiotAi(this);

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
					int xp;
					int cup;
					if (App.advancedAI){
						xp = 400;
						cup = 40;
					} else {
						xp = 200;
						cup = 30;
					}
					App.advancedAI = false;
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
						timeOffset += 2;
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

				ai.action();

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


	/**
	 * Gets battle map.
	 *
	 * @return the battle map
	 */
	public Image getBattleMap() {
		return battleMap;
	}

	/**
	 * Gets spells.
	 *
	 * @return the spells
	 */
	public ArrayList<Spell> getSpells() {
		return spells;
	}

	/**
	 * Gets sprites.
	 *
	 * @return the sprites
	 */
	public ArrayList<Sprite> getSprites() {
		return sprites;
	}

	/**
	 * Gets red king tower.
	 *
	 * @return the red king tower
	 */
	public KingTower getRedKingTower() {
		return redKingTower;
	}

	/**
	 * Gets red archer tower left.
	 *
	 * @return the red archer tower left
	 */
	public ArcherTower getRedArcherTowerLeft() {
		return redArcherTowerLeft;
	}

	/**
	 * Gets red archer tower right.
	 *
	 * @return the red archer tower right
	 */
	public ArcherTower getRedArcherTowerRight() {
		return redArcherTowerRight;
	}

	/**
	 * Gets blue king tower.
	 *
	 * @return the blue king tower
	 */
	public KingTower getBlueKingTower() {
		return blueKingTower;
	}

	/**
	 * Gets blue archer tower left.
	 *
	 * @return the blue archer tower left
	 */
	public ArcherTower getBlueArcherTowerLeft() {
		return blueArcherTowerLeft;
	}

	/**
	 * Gets blue archer tower right.
	 *
	 * @return the blue archer tower right
	 */
	public ArcherTower getBlueArcherTowerRight() {
		return blueArcherTowerRight;
	}

	/**
	 * Gets bot deck.
	 *
	 * @return the bot deck
	 */
	public ArrayList<Card> getBotDeck() {
		return botDeck;
	}

	/**
	 * Gets bot out of hands.
	 *
	 * @return the bot out of hands
	 */
	public ArrayList<Card> getBotOutOfHands() {
		return botOutOfHands;
	}
}

