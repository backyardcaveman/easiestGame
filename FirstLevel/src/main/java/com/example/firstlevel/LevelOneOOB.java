package com.example.firstlevel;

public class LevelOneOOB {
        private final double oobTopLeftX = 125;
        private final double oobTopLeftY = -20;
        private final double oobBottomLeftX = 125;
        private final double oobBottomLeftY = 29;
        private final double oobTopRightX = 600;
        private final double oobTopRightY = -20;
        private final double oobBottomRightX = 600;
        private final double oobBottomRightY = 29;

    public void setOOB(Player1 player1) {
        //top left corner bounds
        if (player1.getPlayer().getTranslateX() < oobTopLeftX && player1.getPlayer().getTranslateY() < oobTopLeftY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //bottom left corner bounds
        if (player1.getPlayer().getTranslateX() < oobBottomLeftX && player1.getPlayer().getTranslateY() > oobBottomLeftY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //top right corner bounds
        if (player1.getPlayer().getTranslateX() > oobTopRightX && player1.getPlayer().getTranslateY() < oobTopRightY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
        //bottom right corner bounds
        if (player1.getPlayer().getTranslateX() > oobBottomRightX && player1.getPlayer().getTranslateY() > oobBottomRightY) {
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
        }
    }
    public void playerWin(Player1 player1, int coinCount) {
        if (player1.getPlayer().getTranslateX() > 650 && player1.getPlayer().getTranslateY() < oobBottomRightY && coinCount == 6) {
            System.out.println("you win!");
            player1.getPlayer().setTranslateX(0);
            player1.getPlayer().setTranslateY(0);
            //Change scene logic
        }
    }
}
