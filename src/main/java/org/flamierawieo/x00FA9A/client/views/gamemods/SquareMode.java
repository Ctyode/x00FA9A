package org.flamierawieo.x00FA9A.client.views.gamemods;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class SquareMode extends View {

    private enum HitAccuracy {

        HIT_100 (100, 0.4),
        HIT_200 (200, 0.2),
        HIT_300 (300, 0.1);

        private int score;
        private double accuracy;

        /**
         * @param score znachit chto ty dolboeb
         * @param accuracy znachit chto ty kosoi dolboeb
         */

        HitAccuracy(int score, double accuracy) {
            this.score = score;
            this.accuracy = accuracy;
        }

        public int getScore() {
            return score;
        }

        public double getAccuracy() {
            return accuracy;
        }
    }



    private int Score = 0;

    private Image buttonsBackgroundImg, comboBackgroundImg, hpBackgroundImg, statsBackgroundImg, greenButtonImg;

    public SquareMode() {
        buttonsBackgroundImg = Images.BUTTONS_BACKGROUND.getImage();
        comboBackgroundImg = Images.COMBO_BACKGROUND.getImage();
        hpBackgroundImg = Images.HP_BACKGROUND.getImage();
        statsBackgroundImg = Images.STATS_BACKGROUND.getImage();
        greenButtonImg = Images.GREEN_BUTTON.getImage();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);

        g.drawImage(buttonsBackgroundImg, 0.0f, 0.0f);
        g.drawImage(comboBackgroundImg, 0.0f, 0.0f);
        g.drawImage(hpBackgroundImg, 0.0f, 0.0f);
        g.drawImage(statsBackgroundImg, 0.0f, 0.0f);
        g.drawImage(greenButtonImg, 0.0f, 0.0f);

        g.drawString(String.valueOf(Score), 0.0f, 0.0f);

    }

    @Override
    public void tick(double delta) {
        super.tick(delta);

        double currentTime = System.currentTimeMillis() / 1000;
    }

    public int calculateScore(double beatTime, double keyPressedTime) {
        double delta = beatTime - keyPressedTime;

        if(delta > 0) {
            if(delta < HitAccuracy.HIT_300.getAccuracy()) {
                return HitAccuracy.HIT_300.getScore();
            } else if (delta < HitAccuracy.HIT_200.getAccuracy()) {
                return HitAccuracy.HIT_200.getScore();
            } else if (delta < HitAccuracy.HIT_100.getAccuracy()) {
                return HitAccuracy.HIT_100.getScore();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @Override
    public void keyPressed(int i, char c) {
        super.keyPressed(i, c);
        Score++;
    }

    @Override
    public void keyReleased(int i, char c) {
        super.keyReleased(i, c);
    }

}
