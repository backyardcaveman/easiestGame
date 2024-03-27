package com.example.firstlevel;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Level1 extends Application {
    private final Player1 player1 = new Player1();
    private final PlayerBounds playerBounds = new PlayerBounds(4,4,725,130,-130);
    private final LevelOneOOB levelOneOOB = new LevelOneOOB();
    private int coinTotal;
    private int deathCount;
    private final MapOne mapOne = new MapOne();
    private final SpikeBall spikeBall = new SpikeBall();
    private final Leve1Animations animations = new Leve1Animations();
    private final PlayerMovement playerMovement = new PlayerMovement();
    private final CollisionMethods collision = new CollisionMethods();
    private final CoinTotalText coinTotalText = new CoinTotalText();
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        Label deathCountText = new Label();
        deathCountText.setText("Deaths: " + CollisionMethods.getDeathCount());
        root.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        //Creating map with shapes
        Rectangle startRect = new Rectangle(126,97, Color.GREEN);
        HBox startBox = new HBox(startRect);
        startBox.setAlignment(Pos.CENTER_LEFT);
        startBox.setTranslateX(4);
        Rectangle endRect = new Rectangle(126,97, Color.GREEN);
        HBox endBox = new HBox(endRect);
        endBox.setAlignment(Pos.CENTER_RIGHT);
        endBox.setTranslateX(-4);
        //Animation Timer
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(playerMovement.iswPressed().get()) {
                    player1.getPlayer().setTranslateY(player1.getPlayer().getTranslateY() - playerMovement.getMovementVariable());
                }
                if(playerMovement.isaPressed().get()) {
                    player1.getPlayer().setTranslateX(player1.getPlayer().getTranslateX() - playerMovement.getMovementVariable());
                }
                if(playerMovement.issPressed().get()) {
                    player1.getPlayer().setTranslateY(player1.getPlayer().getTranslateY() + playerMovement.getMovementVariable());
                }
                if(playerMovement.isdPressed().get()) {
                    player1.getPlayer().setTranslateX(player1.getPlayer().getTranslateX() + playerMovement.getMovementVariable());
                }
                playerBounds.setBounds(player1);
                levelOneOOB.setOOB(player1);
            }
        };
        // Determine when to run timer
        playerMovement.getKeyPressed().addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                timer.start();
            } else {
                timer.stop();
            }
        }));
        // Create/set enemy shapes
        RedCircleEnemy[] enemyArray = {
        new RedCircleEnemy(175,125),
        new RedCircleEnemy(275,125),
        new RedCircleEnemy(225,-125),
        new RedCircleEnemy(325,-125),
        };
        //Coins
        Coin[] coinArray = {
        new Coin(355, 20),
        new Coin(355, 0),
        new Coin(375,20),
        new Coin(375,0),
        new Coin(395,20),
        new Coin(395,0)
        };
        //Collision Timer
        AnimationTimer collisionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for(RedCircleEnemy x : enemyArray) {
                    collision.enemyCollision(player1.getPlayer(), enemyArray, coinArray);
                }
                collision.spikeCollision(player1.getPlayer(), spikeBall, coinArray);
                for(Coin coin : coinArray) {
                    collision.coinCollision(player1.getPlayer(), coin);
                }
                //Increment Coin Counter
                coinTotal = coinArray[0].getCoinCount() + coinArray[1].getCoinCount() +
                        coinArray[2].getCoinCount() + coinArray[3].getCoinCount() +
                        coinArray[4].getCoinCount() + coinArray[5].getCoinCount();
                coinTotalText.getCoinCountText().setText("Coins: " + coinTotal);
                levelOneOOB.playerWin(player1, coinTotal);
            }
        };
        collisionTimer.start();
        //Call circle animation functions
        animations.BottomRowAnimation(enemyArray[0].getRedCircleEnemy());
        animations.BottomRowAnimation(enemyArray[1].getRedCircleEnemy());
        animations.TopRowAnimation(enemyArray[2].getRedCircleEnemy());
        animations.TopRowAnimation(enemyArray[3].getRedCircleEnemy());
        animations.CircularPathAnimation(spikeBall.getSpikeBall());
        //Add to Scene
        root.setAlignment(Pos.CENTER);
        root.add(mapOne.getMapOne(), 1,1);
        root.add(startBox, 1,1);
        root.add(endBox,1,1);
        root.add(spikeBall.getSpikeBall(), 1,1);
        root.add(coinTotalText.getCoinCountText(), 1,2);
        root.add(deathCountText, 1,2);
        //Add redCircleEnemies to scene
        for (RedCircleEnemy redCircleEnemy : enemyArray) {
            root.add(redCircleEnemy.getRedCircleEnemy(), 1, 1);
        }
        for (Coin coin : coinArray) {
            root.add(coin.getCoin(), 1, 1);
        }
        root.add(player1.getPlayer(), 1,1);
        Scene scene = new Scene(root, 800, 600);
        //Define movement
        playerMovement.keyPressHandler(scene);
        playerMovement.keyReleaseHandler(scene);
        primaryStage.setTitle("Level 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
