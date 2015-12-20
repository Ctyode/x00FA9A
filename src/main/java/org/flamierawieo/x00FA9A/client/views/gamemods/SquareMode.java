package org.flamierawieo.x00FA9A.client.views.gamemods;

import org.flamierawieo.x00FA9A.client.Beatmap;
import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.ui.View;

import java.io.IOException;

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

    public SquareMode(Beatmap b) {
        super();
        try {
            Sound.loadFromOggFile(b.getOgg()).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {

    }

    @Override
    public void tick(float delta) {
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

}
