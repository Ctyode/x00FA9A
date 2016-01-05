package org.flamierawieo.x00FA9A.client.views.gamemods;

import org.flamierawieo.x00FA9A.client.*;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.flamierawieo.x00FA9A.client.ui.widget.Background;
import org.flamierawieo.x00FA9A.client.ui.widget.Squares;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class SquareMode extends View {

    private Surface pinkButton;
    private Text scoreText;
    private Background comboBackground;
    private Background statsBackground;
    private Surface greenButton;
    private Background buttonsBackground;
    private Sound song;
    private boolean keyState;
//    private Squares squares;

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

    private int score = 0;
    private double startedTime;
    private Deque<Double> deque;

    public SquareMode(Beatmap b) {
        super();
//        statsBackground = new Background(Images.BUTTONS_BACKGROUND.getTexture(), 0.0f, 0.0f, 0.0f, 0.0f);
//        comboBackground = new Background(Images.BUTTONS_BACKGROUND.getTexture(), 0.0f, 0.0f, 0.0f, 0.0f);
//        squares = new Squares(0.1f, 0.1f, 1.0f, 1.0f);
        scoreText = new Text(Integer.toString(score), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        deque = new ArrayDeque<>(b.getSquareModeTiming().stream().sorted(Double::compare).collect(Collectors.toList()));
        greenButton = new Surface(Color.WHITE, Color.GREEN, 6.0f, 0.025f);
        pinkButton = new Surface(Color.WHITE, Color.PINK, 6.0f, 0.025f);

//        addWidget(squares);
        try {
            song = Sound.loadFromOggFile(b.getOgg());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewStarted() {
        startedTime = glfwGetTime();
        if (song != null) {
            song.play();
        }
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        keyState = true;
        double currentTime = glfwGetTime() - startedTime;
        double nearestBeatTime = 0.0;
        double delta = 0.0;
        if(deque.size() > 0) {
            nearestBeatTime = deque.getFirst();
        }
        while((delta = nearestBeatTime - currentTime) < 0 && deque.size() > 0) {
            deque.removeFirst();
            if(deque.size() > 0) {
                nearestBeatTime = deque.getFirst();
            } else {
                nearestBeatTime = 0.0;
            }
        }
        int i = calculateScore(nearestBeatTime, currentTime);
        if (i > 0) {
            score += i;
            scoreText.setString(Integer.toString(score));
        }
//        System.out.printf("%f %f %f %d\n", delta, currentTime, nearestBeatTime, calculateScore(nearestBeatTime, currentTime));
//        System.out.printf("%d %f\n", key, glfwGetTime() - startedTime);
    }

    @Override
    public void onKeyUp(int key, int scancode, int mods) {
        super.onKeyUp(key, scancode, mods);
        keyState = false;
    }

    @Override
    public void draw() {
        super.draw();
        scoreText.draw(0.1f, 0.1f);
        if(keyState) {
            pinkButton.draw(0.5f, 0.5f, 0.1f, 0.1f);
        } else {
            greenButton.draw(0.5f, 0.5f, 0.1f, 0.1f);
        }
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
            if(-delta < HitAccuracy.HIT_300.getAccuracy()) {
                return HitAccuracy.HIT_300.getScore();
            } else if (-delta < HitAccuracy.HIT_200.getAccuracy()) {
                return HitAccuracy.HIT_200.getScore();
            } else if (-delta < HitAccuracy.HIT_100.getAccuracy()) {
                return HitAccuracy.HIT_100.getScore();
            } else {
                return 0;
            }
        }
    }

}
