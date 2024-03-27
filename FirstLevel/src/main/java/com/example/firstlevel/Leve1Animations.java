package com.example.firstlevel;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Leve1Animations {

    public Leve1Animations() {
    }
    public void BottomRowAnimation(Circle circle) {
        TranslateTransition bottomCircleOne = new TranslateTransition();
        bottomCircleOne.setDuration(Duration.millis(1000));
        bottomCircleOne.setNode(circle);
        bottomCircleOne.setByY(-250);
        bottomCircleOne.setCycleCount(Animation.INDEFINITE);
        bottomCircleOne.setAutoReverse(true);
        bottomCircleOne.play();
    }
    public void TopRowAnimation(Circle circle) {
        TranslateTransition topCircleOne = new TranslateTransition();
        topCircleOne.setDuration(Duration.millis(1000));
        topCircleOne.setNode(circle);
        topCircleOne.setByY(250);
        topCircleOne.setCycleCount(Animation.INDEFINITE);
        topCircleOne.setAutoReverse(true);
        topCircleOne.play();
    }
    public void CircularPathAnimation(ImageView enemy) {
        Circle circle = new Circle(80);
        circle.setTranslateX(520);
        circle.setTranslateY(20);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(enemy);
        pathTransition.setDuration(Duration.seconds(2));
        pathTransition.setPath(circle);
        pathTransition.setAutoReverse(true);
        pathTransition.setCycleCount(Animation.INDEFINITE);
        pathTransition.play();
    }
}
