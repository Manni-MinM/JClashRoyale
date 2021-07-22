package JClashRoyale.Model.Logic.Bots;

import JClashRoyale.Model.Cards.*;
import JClashRoyale.Model.Elements.Enums;
import JClashRoyale.Model.Elements.Spells.Fireball;
import JClashRoyale.Model.Elements.Spells.Rage;
import JClashRoyale.Model.Elements.Sprites.Troops.*;
import JClashRoyale.Model.Logic.AI;
import JClashRoyale.Model.Logic.GameManager;

import java.util.Random;

/**
 * The type Idiot ai.
 */
public class IdiotAi extends AI {
    private final GameManager gameManager;

    /**
     * Instantiates a new Idiot ai.
     *
     * @param gameManager the game manager
     */
    public IdiotAi(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Dummy bot.
     */
    @Override
    public void action() {
        if (gameManager.getElixerBot() < 5)
            return;

        Random random = new Random();
        int randomInt = random.nextInt(8);
        double randomX = random.nextDouble() * 250 + 25;
        double randomY = random.nextDouble() * 200 + 20;

        if (randomInt == 0) {
            ArcherCard archerCard = new ArcherCard();
            Archer archer1 = new Archer(Enums.ColorType.RED);
            archer1.setHitpoints(archerCard.getHP());
            archer1.setDamage(archerCard.getDamage());
            archer1.setLocation(randomX - 10, randomY);
            Archer archer2 = new Archer(Enums.ColorType.RED);
            archer2.setHitpoints(archerCard.getHP());
            archer2.setDamage(archerCard.getDamage());
            archer2.setLocation(randomX + 10, randomY);
            if (gameManager.getElixerBot() >= archer1.getCost()) {
                gameManager.addSprite(archer1);
                gameManager.addSprite(archer2);
                gameManager.consumeElixerBot(archer1.getCost());
            } else {
                return;
            }
        } else if (randomInt == 1) {
            BabyDragonCard babyDragonCard = new BabyDragonCard();
            BabyDragon babyDragon = new BabyDragon(Enums.ColorType.RED);
            babyDragon.setHitpoints(babyDragonCard.getHP());
            babyDragon.setDamage(babyDragonCard.getDamage());
            babyDragon.setLocation(randomX, randomY);
            if (gameManager.getElixerBot() >= babyDragon.getCost()) {
                gameManager.addSprite(babyDragon);
                gameManager.consumeElixerBot(babyDragon.getCost());
            } else {
                return;
            }
        } else if (randomInt == 2) {
            BarbariansCard barbariansCard = new BarbariansCard();
            Barbarian barbarian1 = new Barbarian(Enums.ColorType.RED);
            barbarian1.setHitpoints(barbariansCard.getHP());
            barbarian1.setDamage(barbariansCard.getDamage());
            barbarian1.setLocation(randomX + 15, randomY + 10);
            Barbarian barbarian2 = new Barbarian(Enums.ColorType.RED);
            barbarian2.setHitpoints(barbariansCard.getHP());
            barbarian2.setDamage(barbariansCard.getDamage());
            barbarian2.setLocation(randomX - 15, randomY + 10);
            Barbarian barbarian3 = new Barbarian(Enums.ColorType.RED);
            barbarian3.setHitpoints(barbariansCard.getHP());
            barbarian3.setDamage(barbariansCard.getDamage());
            barbarian3.setLocation(randomX + 15, randomY - 10);
            Barbarian barbarian4 = new Barbarian(Enums.ColorType.RED);
            barbarian4.setHitpoints(barbariansCard.getHP());
            barbarian4.setDamage(barbariansCard.getDamage());
            barbarian4.setLocation(randomX - 15, randomY - 10);
            if (gameManager.getElixerBot() >= barbarian1.getCost()) {
                gameManager.addSprite(barbarian1);
                gameManager.addSprite(barbarian2);
                gameManager.addSprite(barbarian3);
                gameManager.addSprite(barbarian4);
                gameManager.consumeElixerBot(barbarian1.getCost());
            } else {
                return;
            }
        } else if (randomInt == 3) {
            GiantCard giantCard = new GiantCard();
            Giant giant = new Giant(Enums.ColorType.RED);
            giant.setLocation(randomX, randomY);
            giant.setHitpoints(giantCard.getHP());
            giant.setDamage(giantCard.getDamage());
            if (gameManager.getElixerBot() >= giant.getCost()) {
                gameManager.addSprite(giant);
                gameManager.consumeElixerBot(giant.getCost());
            } else {
                return;
            }
        } else if (randomInt == 4) {
            MiniPekkaCard miniPekkaCard = new MiniPekkaCard();
            MiniPekka miniPekka = new MiniPekka(Enums.ColorType.RED);
            miniPekka.setLocation(randomX, randomY);
            miniPekka.setHitpoints(miniPekkaCard.getHP());
            miniPekka.setDamage(miniPekkaCard.getDamage());
            if (gameManager.getElixerBot() >= miniPekka.getCost()) {
                gameManager.addSprite(miniPekka);
                gameManager.consumeElixerBot(miniPekka.getCost());
            } else {
                return;
            }
        } else if (randomInt == 5) {
            ValkyrieCard valkyrieCard = new ValkyrieCard();
            Valkyrie valkyrie = new Valkyrie(Enums.ColorType.RED);
            valkyrie.setLocation(randomX, randomY);
            valkyrie.setHitpoints(valkyrieCard.getHP());
            valkyrie.setDamage(valkyrieCard.getDamage());
            if (gameManager.getElixerBot() >= valkyrie.getCost()) {
                gameManager.addSprite(valkyrie);
                gameManager.consumeElixerBot(valkyrie.getCost());
            } else {
                return;
            }
        } else if (randomInt == 6) {
            RageCard rageCard = new RageCard();
            Rage rage = new Rage(Enums.ColorType.RED);
            rage.setLocation(randomX, randomY);
            rage.setDuration(rageCard.getAttribute());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            rage.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= rage.getCost()) {
                gameManager.addSpell(rage);
                gameManager.consumeElixerBot(rage.getCost());
            } else {
                return;
            }
        } else if (randomInt == 7) {
            FireballCard fireballCard = new FireballCard();
            Fireball fireball = new Fireball(Enums.ColorType.RED);
            fireball.setLocation(randomX, randomY);
            fireball.setDamage(fireballCard.getAttribute());
            double timeNow = ((long) System.nanoTime()) / 1000000000.0;
            fireball.setDeploymentTime(timeNow);
            if (gameManager.getElixerBot() >= fireball.getCost()) {
                gameManager.addSpell(fireball);
                gameManager.consumeElixerBot(fireball.getCost());
            } else {
                return;
            }
        }
    }
}