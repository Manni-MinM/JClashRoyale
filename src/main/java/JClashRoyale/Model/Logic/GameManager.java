// BWOTSHEWCHB

package JClashRoyale.Model.Logic ;

import java.util.Random ;
import java.util.Objects ;
import java.util.ArrayList ;

import javafx.animation.AnimationTimer ;

import javafx.scene.control.ProgressBar ;
import javafx.scene.image.Image ;
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
	// Constructor
	public GameManager() {
		elixer = 0 ;

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
	}
	// Methods : Setters
	public void setBattleMap(String path) {
		this.battleMap = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)) , 315 , 480 , false , false) ;
	}
	public void consumeElixer(int value) {
		this.elixer -= value ;
		BattleController.updateAvailability(elixer);
	}
	public void consumeElixerBot(int value) {
		this.elixerBot -= value ;
	}
	// Methods : Getters
	public Canvas getCanvas() {
		return this.canvas ;
	}
	public GraphicsContext getGraphics() {
		return this.graphics ;
	}
	public int getElixer() {
		return this.elixer ;
	}
	public int getElixerBot() {
		return this.elixerBot ;
	}
	// Methods : Other
	public void addSpell(Spell spell) {
		spells.add(spell) ;
	}
	public void addSprite(Sprite sprite) {
		sprites.add(sprite) ;
	}
	public void loadBattleMap() {
		graphics.drawImage(battleMap , 0 , 0) ;
	}
	public void dummyBot() {
		if ( getElixerBot() < 5 )
			return ;

		Random random = new Random() ;
		int randomInt = random.nextInt(8) ;
		double randomX = random.nextDouble() * 250 + 25 ;
		double randomY = random.nextDouble() * 200 + 20 ;

		if ( randomInt == 0 ) {
			ArcherCard archerCard = new ArcherCard() ;
			Archer archer = new Archer(ColorType.RED) ;
			archer.setHitpoints(archerCard.getHP()) ;
			archer.setDamage(archerCard.getDamage()) ;
			archer.setLocation(randomX , randomY) ;
			if ( getElixerBot() >= archer.getCost() ) {
				addSprite(archer) ;
				consumeElixerBot(archer.getCost()) ;
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
			Barbarian barbarian = new Barbarian(ColorType.RED) ;
			barbarian.setLocation(randomX , randomY) ;
			barbarian.setHitpoints(barbariansCard.getHP()) ;
			barbarian.setDamage(barbariansCard.getDamage()) ;
			if ( getElixerBot() >= barbarian.getCost() ) {
				addSprite(barbarian) ;
				consumeElixerBot(barbarian.getCost()) ;
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
	public void update(TextField timerField , TextField resultField , TextField elixerField , ProgressBar elixerBar) {
		final long startNanoTime = System.nanoTime() ;
		new AnimationTimer() {
			int timeOffset = 0 ;
			int frameCount = 0 ;
			public void handle(long currentNanoTime) {
				double timeNow = ((currentNanoTime - startNanoTime) / 1000000000.0) ;
				double elixerTime = timeNow - timeOffset ;
				double elixerBotTime = timeNow - timeOffset ;

				if ( elixerTime >= 1.0 ) {
					timeOffset ++ ;
					elixer = Math.min(elixer + 1 , 10) ;
					elixerBot = Math.min(elixerBot + 1 , 10) ;
				} else {
					// Pass
				}

				elixerField.setText(String.valueOf(elixer)) ;
				elixerBar.setProgress(elixer / 10.0);
				BattleController.updateAvailability(elixer);

				// TODO : Test
				dummyBot() ;
				System.err.println("ELIXER BOT : " + getElixerBot()) ;

				loadBattleMap() ;
				elixerField.setText(String.valueOf(elixer)) ;

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
					for ( Sprite sprite : affectedSprites )
						spell.affect(sprite) ;
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

