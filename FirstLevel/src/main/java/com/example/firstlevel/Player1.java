package com.example.firstlevel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class Player1 extends Rectangle {
    Rectangle player1;
    public Player1() {
        player1 = new Rectangle();
        player1.setWidth(30);
        player1.setHeight(30);
        player1.setFill(Color.BLACK);
        player1.setStrokeType(StrokeType.CENTERED);
        player1.setStrokeWidth(5);
        player1.setStroke(Color.GRAY);
    }

    public Rectangle getPlayer() {
        return this.player1;
    }
}
