package com.example.firstlevel;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class RedCircleEnemy extends Circle {
    private final Circle redCircleEnemy;
    public RedCircleEnemy(double coordinateX, double coordinateY) {
        redCircleEnemy = new Circle(10, Color.RED);
        redCircleEnemy.setTranslateX(coordinateX);
        redCircleEnemy.setTranslateY(coordinateY);
    }
    public Circle getRedCircleEnemy() {
        return redCircleEnemy;
    }

}
