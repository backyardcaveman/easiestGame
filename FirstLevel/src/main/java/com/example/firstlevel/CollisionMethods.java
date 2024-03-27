package com.example.firstlevel;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CollisionMethods {
    private static int deathCount;

    public static int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        CollisionMethods.deathCount = deathCount;
    }

    public void enemyCollision(Rectangle player, RedCircleEnemy[] enemyArr, Coin[] circleArr) {
        for (RedCircleEnemy circleEnemy : enemyArr) {
            if (player.getBoundsInParent().intersects(circleEnemy.getRedCircleEnemy().getBoundsInParent())) {
                player.setTranslateX(0);
                player.setTranslateY(0);
                setDeathCount(CollisionMethods.getDeathCount() + 1);
                for (Coin coin : circleArr) {
                    coin.getCoin().setVisible(true);
                    coin.setCoinCount(0);
                }
            }
        }
    }
    public void spikeCollision(Rectangle player, SpikeBall enemy, Coin[] circleArr) {

        if(player.getBoundsInParent().intersects(enemy.getSpikeBall().getBoundsInParent())) {
            player.setTranslateY(0);
            player.setTranslateX(0);
            for(Coin coin : circleArr) {
                coin.getCoin().setVisible(true);
                coin.setCoinCount(0);
            }
        }
    }
    public void coinCollision(Rectangle player, Coin coin) {
        if(player.getBoundsInParent().intersects(coin.getCoin().getBoundsInParent())) {
            coin.getCoin().setVisible(false);
            coin.setCoinCount(1);
        }
    }
}
