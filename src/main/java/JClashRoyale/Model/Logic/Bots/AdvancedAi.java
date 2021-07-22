package JClashRoyale.Model.Logic.Bots;

import JClashRoyale.Model.Cards.*;
import JClashRoyale.Model.Elements.Enums;
import JClashRoyale.Model.Elements.Spells.Arrows;
import JClashRoyale.Model.Elements.Spells.Fireball;
import JClashRoyale.Model.Elements.Spells.Rage;
import JClashRoyale.Model.Elements.Sprite;
import JClashRoyale.Model.Elements.Sprites.Buildings.ArcherTower;
import JClashRoyale.Model.Elements.Sprites.Buildings.Cannon;
import JClashRoyale.Model.Elements.Sprites.Buildings.InfernoTower;
import JClashRoyale.Model.Elements.Sprites.Buildings.KingTower;
import JClashRoyale.Model.Elements.Sprites.Troops.*;
import JClashRoyale.Model.Logic.AI;
import JClashRoyale.Model.Logic.GameManager;

import java.util.Random;

/**
 * The type Advanced ai.
 */
public class AdvancedAi extends AI {
    private final GameManager gameManager;

    /**
     * Instantiates a new Advanced ai.
     *
     * @param gameManager the game manager
     */
    public AdvancedAi(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Advanced bot.
     */
    @Override
    public void action() {
        if (gameManager.getElixerBot() < 5)
            return;

        Random random = new Random();
        int randomInt = random.nextInt(4);
        double randomX = random.nextDouble() * 250 + 25;
        double randomY = random.nextDouble() * 200 + 20;
        if ((gameManager.getBlueArcherTowerLeft().getHitpoints() <= 400 && (!gameManager.getBlueArcherTowerLeft().isDestroyed())) && ((doesHaveCard(new ArrowsCard()) | doesHaveCard(new FireballCard())))) {
            if (findCardInDeck(new ArrowsCard()) != null)
                deployCard(gameManager.getBlueArcherTowerLeft().getX(), gameManager.getBlueArcherTowerLeft().getY(), findCardInDeck(new ArrowsCard()));
            else
                deployCard(gameManager.getBlueArcherTowerLeft().getX(), gameManager.getBlueArcherTowerLeft().getY(), findCardInDeck(new FireballCard()));
            return;
        } else if ((gameManager.getBlueArcherTowerRight().getHitpoints() <= 400 && (!gameManager.getBlueArcherTowerLeft().isDestroyed())) && ((doesHaveCard(new ArrowsCard()) | doesHaveCard(new FireballCard())))) {
            if (findCardInDeck(new ArrowsCard()) != null)
                deployCard(gameManager.getBlueArcherTowerRight().getX(), gameManager.getBlueArcherTowerRight().getY(), findCardInDeck(new ArrowsCard()));
            else
                deployCard(gameManager.getBlueArcherTowerRight().getX(), gameManager.getBlueArcherTowerRight().getY(), findCardInDeck(new FireballCard()));
            return;
        }

        if (doesHaveCard(new RageCard()) && findSpriteInMap() != null) {
            deployCard(findSpriteInMap().getX() - findSpriteInMap().getStateImage()
                    .getWidth() / 2, findSpriteInMap().getY() - findSpriteInMap().getStateImage()
                    .getHeight() / 2, findCardInDeck(new RageCard()));
            return;

        }


        if (gameManager.getRedArcherTowerLeft().getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
            if (findCardInDeck(new CannonCard()) != null)
                deployCard(random.nextDouble() * 155 + 25, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
            else
                deployCard(random.nextDouble() * 155 + 25, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
            return;
        } else if (gameManager.getRedArcherTowerRight().getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
            if (findCardInDeck(new CannonCard()) != null)
                deployCard(random.nextDouble() * 155 + 130, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
            else
                deployCard(random.nextDouble() * 155 + 130, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
            return;
        } else if (gameManager.getRedKingTower().getHitpoints() <= 1000 && (doesHaveCard(new CannonCard()) | doesHaveCard(new InfernoTowerCard()))) {
            if (findCardInDeck(new CannonCard()) != null)
                deployCard(randomX, random.nextDouble() * 230 + 20, findCardInDeck(new CannonCard()));
            else
                deployCard(randomX, random.nextDouble() * 230 + 20, findCardInDeck(new InfernoTowerCard()));
            return;
        }


        deployCard(randomX, randomY, gameManager.getBotDeck().get(randomInt));

    }

    /**
     * Does have card boolean.
     *
     * @param card the card
     * @return the boolean
     */
    public boolean doesHaveCard(Card card) {
        for (Card card1 : gameManager.getBotDeck()) {
            if (card.getClass().getName().equalsIgnoreCase(card1.getClass().getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find sprite in map sprite.
     *
     * @return the sprite
     */
    public Sprite findSpriteInMap() {
        for (Sprite sprite : gameManager.getSprites()) {
            if ((sprite instanceof KingTower) | (sprite instanceof ArcherTower | (sprite.getColorType().equals(Enums.ColorType.BLUE))))
                continue;
            return sprite;
        }
        return null;
    }

    /**
     * Find card in deck card.
     *
     * @param card the card
     * @return the card
     */
    public Card findCardInDeck(Card card) {
        for (Card card1 : gameManager.getBotDeck()) {
            if (card.getClass().getName().equalsIgnoreCase(card1.getClass().getName())) {
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
    public void deployCard(double randomX, double randomY, Card selectedCard) {
        if (selectedCard instanceof ArcherCard) {

            Archer archer1 = new Archer(Enums.ColorType.RED);
            Archer archer2 = new Archer(Enums.ColorType.RED);


            archer1.setHitpoints(selectedCard.getHP());
            archer1.setDamage(selectedCard.getDamage());
            archer1.setLocation(randomX - 10, randomY);
            archer2.setHitpoints(selectedCard.getHP());
            archer2.setDamage(selectedCard.getDamage());
            archer2.setLocation(randomX + 10, randomY);
            if (gameManager.getElixerBot() >= archer1.getCost()) {
                gameManager.addSprite(archer1);
                gameManager.addSprite(archer2);
                gameManager.consumeElixerBot(archer1.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof BabyDragonCard) {

            BabyDragon babyDragon = new BabyDragon(Enums.ColorType.RED);


            babyDragon.setHitpoints(selectedCard.getHP());
            babyDragon.setDamage(selectedCard.getDamage());
            babyDragon.setLocation(randomX, randomY);
            if (gameManager.getElixerBot() >= babyDragon.getCost()) {
                gameManager.addSprite(babyDragon);
                gameManager.consumeElixerBot(babyDragon.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof BarbariansCard) {
            BarbariansCard barbariansCard = (BarbariansCard) selectedCard;

            Barbarian barbarian1 = new Barbarian(Enums.ColorType.RED);
            Barbarian barbarian2 = new Barbarian(Enums.ColorType.RED);
            Barbarian barbarian3 = new Barbarian(Enums.ColorType.RED);
            Barbarian barbarian4 = new Barbarian(Enums.ColorType.RED);


            barbarian1.setHitpoints(barbariansCard.getHP());
            barbarian1.setDamage(barbariansCard.getDamage());
            barbarian1.setLocation(randomX + 15, randomY + 10);
            barbarian2.setHitpoints(barbariansCard.getHP());
            barbarian2.setDamage(barbariansCard.getDamage());
            barbarian2.setLocation(randomX - 15, randomY + 10);
            barbarian3.setHitpoints(barbariansCard.getHP());
            barbarian3.setDamage(barbariansCard.getDamage());
            barbarian3.setLocation(randomX + 15, randomY - 10);
            barbarian4.setHitpoints(barbariansCard.getHP());
            barbarian4.setDamage(barbariansCard.getDamage());
            barbarian4.setLocation(randomX - 15, randomY - 10);
            if (gameManager.getElixerBot() >= barbarian1.getCost()) {
                gameManager.addSprite(barbarian1);
                gameManager.addSprite(barbarian2);
                gameManager.addSprite(barbarian3);
                gameManager.addSprite(barbarian4);
                gameManager.consumeElixerBot(barbarian1.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof GiantCard) {

            Giant giant = new Giant(Enums.ColorType.RED);


            giant.setLocation(randomX, randomY);
            giant.setHitpoints(selectedCard.getHP());
            giant.setDamage(selectedCard.getDamage());
            if (gameManager.getElixerBot() >= giant.getCost()) {
                gameManager.addSprite(giant);
                gameManager.consumeElixerBot(giant.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof MiniPekkaCard) {

            MiniPekka miniPekka = new MiniPekka(Enums.ColorType.RED);


            miniPekka.setLocation(randomX, randomY);
            miniPekka.setHitpoints(selectedCard.getHP());
            miniPekka.setDamage(selectedCard.getDamage());
            if (gameManager.getElixerBot() >= miniPekka.getCost()) {
                gameManager.addSprite(miniPekka);
                gameManager.consumeElixerBot(miniPekka.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof ValkyrieCard) {

            Valkyrie valkyrie = new Valkyrie(Enums.ColorType.RED);


            valkyrie.setLocation(randomX, randomY);
            valkyrie.setHitpoints(selectedCard.getHP());
            valkyrie.setDamage(selectedCard.getDamage());
            if (gameManager.getElixerBot() >= valkyrie.getCost()) {
                gameManager.addSprite(valkyrie);
                gameManager.consumeElixerBot(valkyrie.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof WizardCard) {

            Wizard wizard = new Wizard(Enums.ColorType.RED);


            wizard.setLocation(randomX, randomY);
            wizard.setHitpoints(selectedCard.getHP());
            wizard.setDamage(selectedCard.getDamage());
            if (gameManager.getElixerBot() >= wizard.getCost()) {
                gameManager.addSprite(wizard);
                gameManager.consumeElixerBot(wizard.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof CannonCard) {

            Cannon cannon = new Cannon(Enums.ColorType.RED);


            cannon.setLocation(randomX, randomY);
            cannon.setHitpoints(selectedCard.getHP());
            cannon.setDamage(selectedCard.getDamage());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            cannon.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= cannon.getCost()) {
                gameManager.addSprite(cannon);
                gameManager.consumeElixerBot(cannon.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof InfernoTowerCard) {

            InfernoTower infernoTower = new InfernoTower(Enums.ColorType.RED);


            infernoTower.setLocation(randomX, randomY);
            infernoTower.setHitpoints(selectedCard.getHP());
            infernoTower.setDamage(selectedCard.getDamage());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            infernoTower.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= infernoTower.getCost()) {
                gameManager.addSprite(infernoTower);
                gameManager.consumeElixerBot(infernoTower.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof RageCard) {
            RageCard rageCard = (RageCard) selectedCard;
            Rage rage = new Rage(Enums.ColorType.RED);


            rage.setLocation(randomX, randomY);
            rage.setDuration(rageCard.getAttribute());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            rage.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= rage.getCost()) {
                gameManager.addSpell(rage);
                gameManager.consumeElixerBot(rage.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof FireballCard) {
            FireballCard fireballCard = (FireballCard) selectedCard;
            Fireball fireball = new Fireball(Enums.ColorType.RED);


            fireball.setLocation(randomX, randomY);
            fireball.setDamage(fireballCard.getAttribute());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            fireball.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= fireball.getCost()) {
                gameManager.addSpell(fireball);
                gameManager.consumeElixerBot(fireball.getCost());
                ;
            } else {
                return;
            }
        } else if (selectedCard instanceof ArrowsCard) {
            ArrowsCard arrowsCard = (ArrowsCard) selectedCard;
            Arrows arrows = new Arrows(Enums.ColorType.RED);


            arrows.setLocation(randomX, randomY);
            arrows.setDamage(arrowsCard.getAttribute());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            arrows.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= arrows.getCost()) {
                gameManager.addSpell(arrows);
                gameManager.consumeElixerBot(arrows.getCost());
                ;
            } else {
                return;
            }
        } else {
            // Pass
        }
        gameManager.getBotDeck().remove(selectedCard);
        gameManager.getBotDeck().add(gameManager.getBotOutOfHands().get(0));
        gameManager.getBotOutOfHands().remove(0);
        gameManager.getBotOutOfHands().add(selectedCard);


    }
}