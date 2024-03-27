package com.example.firstlevel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Coin extends Circle {
    private final Circle coin;
    private int coinCount;
    public Coin(double coordinateX, double coordinateY) {
        coin = new Circle(8, Color.YELLOW);
        coin.setStroke(Color.GOLD);
        coin.setStrokeWidth(3);
        coin.setTranslateX(coordinateX);
        coin.setTranslateY(coordinateY);
    }
    public Circle getCoin() {
        return this.coin;
    }
    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }
    public int getCoinCount() {
        return this.coinCount;
    }
}
