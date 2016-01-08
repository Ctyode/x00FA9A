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
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
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

    private Text scoreText;
    private Squares squares;
    private int score = 0;
    private double startedTime;
    private List<Deque<Double>> deque;
    private List<Deque<Double>> hints;
    private Sound song;
//    private Background comboBackground;
//    private Background statsBackground;
//    private Background buttonsBackground;

    public SquareMode(Beatmap b) {
        super();
//        statsBackground = new Background(Images.BUTTONS_BACKGROUND.getTexture(), 0.0f, 0.0f, 0.0f, 0.0f);
//        comboBackground = new Background(Images.BUTTONS_BACKGROUND.getTexture(), 0.0f, 0.0f, 0.0f, 0.0f);
        squares = new Squares(0.1f, 0.1f, 1.0f, 1.0f);
        scoreText = new Text(Integer.toString(score), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        deque = new ArrayList<>();
        b.getSquareModeTiming().forEach(t -> deque.add(new ArrayDeque<>(t.stream().sorted(Double::compare).collect(Collectors.toList()))));
        hints = new ArrayList<>();
        hints.add(new ArrayDeque<>(deque.get(0)));

        addWidget(squares);
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
        double currentTime = glfwGetTime() - startedTime;
        double nearestBeatTime = 0.0;
        double delta = 0.0;
        switch (key) {
            case GLFW_KEY_1:
                squares.setButtonState(0, true);
                break;
            case GLFW_KEY_2:
                squares.setButtonState(1, true);
                break;
            case GLFW_KEY_3:
                squares.setButtonState(2, true);
                break;
            case GLFW_KEY_4:
                squares.setButtonState(3, true);
                break;
            case GLFW_KEY_5:
                squares.setButtonState(4, true);
                break;
            case GLFW_KEY_6:
                squares.setButtonState(5, true);
                break;
            case GLFW_KEY_7:
                squares.setButtonState(6, true);
                break;
            case GLFW_KEY_8:
                squares.setButtonState(7, true);
                break;
            case GLFW_KEY_9:
                squares.setButtonState(8, true);
                break;
        }
        if(deque.size() > 0) {
            nearestBeatTime = deque.get(0).getFirst();
        }
        while((delta = nearestBeatTime - currentTime) < 0 && deque.size() > 0) {
            deque.get(0).removeFirst();
            if(deque.get(0).size() > 0) {
                nearestBeatTime = deque.get(0).getFirst();
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
        switch (key) {
            case GLFW_KEY_1:
                squares.setButtonState(0, false);
                break;
            case GLFW_KEY_2:
                squares.setButtonState(1, false);
                break;
            case GLFW_KEY_3:
                squares.setButtonState(2, false);
                break;
            case GLFW_KEY_4:
                squares.setButtonState(3, false);
                break;
            case GLFW_KEY_5:
                squares.setButtonState(4, false);
                break;
            case GLFW_KEY_6:
                squares.setButtonState(5, false);
                break;
            case GLFW_KEY_7:
                squares.setButtonState(6, false);
                break;
            case GLFW_KEY_8:
                squares.setButtonState(7, false);
                break;
            case GLFW_KEY_9:
                squares.setButtonState(8, false);
                break;
        }
    }

    @Override
    public void draw() {
        super.draw();
        scoreText.draw(-0.05f, 0.1f);
    }

    @Override
    public void tick(float delta) {
        super.tick(delta);
        double currentTime = glfwGetTime() - startedTime;
        double nearestBeatTime = 0.0;
        double d = 0.0;
        if(hints.size() > 0) {
            nearestBeatTime = hints.get(0).getFirst();
        }
        while((d = nearestBeatTime - currentTime) < 0 && hints.size() > 0) {
            hints.get(0).removeFirst();
            if(hints.get(0).size() > 0) {
                nearestBeatTime = hints.get(0).getFirst();
            } else {
                nearestBeatTime = 0.0;
            }
        }
        if(d < 0.5) {
            hints.get(0).removeFirst();
            squares.addHint(0, (float) d);
        }
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
