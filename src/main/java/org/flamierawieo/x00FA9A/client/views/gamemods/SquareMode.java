package org.flamierawieo.x00FA9A.client.views.gamemods;

import org.flamierawieo.x00FA9A.client.Beatmap;
import org.flamierawieo.x00FA9A.client.Resources;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.ui.View;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

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
    private double startedTime;
    private Deque<Double> deque;

    public SquareMode(Beatmap b) {
        super();
        deque = new ArrayDeque<>(b.getSquareModeTiming().stream().sorted(Double::compare).collect(Collectors.toList()));
        try {
            Sound.loadFromOggFile(b.getOgg()).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewStarted() {
        startedTime = glfwGetTime();
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        double currentTime = glfwGetTime() - startedTime;
        double nearestBeatTime = 0.0;
        double delta = 0.0;
        if(deque.size() > 0) {
            nearestBeatTime = deque.getFirst();
        }
//        System.out.printf("%d %f\n", key, glfwGetTime() - startedTime);
        while((delta = nearestBeatTime - currentTime) < 0 && deque.size() > 0) {
            deque.removeFirst();
            if(deque.size() > 0) {
                nearestBeatTime = deque.getFirst();
            } else {
                nearestBeatTime = 0.0;
            }
        }
        System.out.printf("%f %f %f %d\n", delta, currentTime, nearestBeatTime, calculateScore(nearestBeatTime, currentTime));
    }

    @Override
    public void draw() {

    }

    @Override
    public void tick(float delta) {
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
