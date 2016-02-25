package org.flamierawieo.x00FA9A.client.views.gamemods;

import org.flamierawieo.x00FA9A.client.*;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Squares;
import org.flamierawieo.x00FA9A.client.views.StatsView;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.lwjgl.glfw.GLFW.*;

public class SquareMode extends View {

    public enum HitAccuracy {

        HIT_100 (100, 0.4, 0.5, 0),
        HIT_200 (200, 0.2, 0.2, 1),
        HIT_300 (300, 0.1, 0.1, 1);

        private int score;

        private double accuracy;

        private double combo;

        private int finalCombo;
        /**
         * @param score znachit chto ty dolboeb
         * @param accuracy znachit chto ty kosoi dolboeb
         */

        HitAccuracy(int score, double accuracy, double combo, int finalCombo) {
            this.score = score;
            this.accuracy = accuracy;
            this.combo = combo;
            this.finalCombo = finalCombo;
        }
        public int getScore() {
            return score;
        }

        public double getAccuracy() {
            return accuracy;
        }

        public double getCombo() {
            return combo;
        }

        public int getFinalCombo() {
            return finalCombo;
        }

    }

    private Text scoreText;
    private Text comboText;
    private Text percentText;

    private int score = 0;
    private int combo = 0;
    private int percent = 0;
    private double accuracy;

    private int finalScore;
    private int finalCombo;
    private double finalPercent;

    private Sound song;
    private Squares squares;
    private Beatmap beatmap;

    private double startedTime;
    private List<Deque<Double>> deque;
    private List<Deque<Double>> hints;
    private int maxScore;
    private boolean isKeyDown;

    public SquareMode(Beatmap b) {
        super();
        beatmap = b;
        squares = new Squares(0.1f, 0.1f, 1.0f, 1.0f);
        percentText = new Text(Double.toString(percent), Fonts.ROBOTO_LIGHT.getFont(), Color.black, 0.1f);
        comboText = new Text(Integer.toString(combo), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        scoreText = new Text(Integer.toString(score), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        deque = new ArrayList<>();
        b.getSquareModeTiming().forEach(t -> deque.add(new ArrayDeque<>(t.stream().sorted(Double::compare).collect(Collectors.toList()))));
        hints = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            hints.add(new ArrayDeque<>(deque.get(i)));
        }

        maxScore = beatmap.getTimingSum() * 300;

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
        for(int l = 0; l <= 8; l++) {
            if (deque.size() > 0 && deque.get(l).size() > 0) {
                nearestBeatTime = deque.get(l).getFirst();
            }
            while ((nearestBeatTime - currentTime) < 0 && deque.size() > 0 && deque.get(l).size() > 0) {
                deque.get(l).removeFirst();
                if (deque.get(l).size() > 0) {
                    nearestBeatTime = deque.get(l).getFirst();
                } else {
                    nearestBeatTime = 0.0;
                }
            }
            int i = calculateScore(nearestBeatTime, currentTime);
            if (i > 0) {
                score += i;
                scoreText.setString(Integer.toString(score));
                finalScore = score;
            }
            int j = calculateCombo(nearestBeatTime, currentTime);
            if (j > 0) {
                combo += j;
                comboText.setString(Integer.toString(combo));
                finalCombo = combo;
            }
        }
        isKeyDown = true;
        if (isKeyDown) {
            percent += 1;
        }

        int maxCurrentScore = percent * 300;
        accuracy = ((double) score * 100 / maxCurrentScore);
        percentText.setString(String.format("%.2f%%", accuracy));
        finalPercent = accuracy;

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
        squares.draw();
        scoreText.draw(-0.05f, 0.1f);
        comboText.draw(0.5f, 0.1f);
        percentText.draw(0.9f, 0.1f);
    }

    @Override
    public void tick(float delta) {
        super.tick(delta);
        squares.tick(delta);
        double currentTime = glfwGetTime() - startedTime;
        double nearestBeatTime = 0.0;

        double d;
        for (int i = 0; i <= 8; i++) {
            if (hints.get(i).size() > 0) {
                nearestBeatTime = hints.get(i).getFirst();
            }

            while ((d = nearestBeatTime - currentTime) < 0 && hints.get(i).size() > 0) {
                hints.get(i).removeFirst();
                if (hints.get(i).size() > 0) {
                    nearestBeatTime = hints.get(i).getFirst();
                } else {
                    nearestBeatTime = 0.0;
                }
            }

            if (d < 1.1) {
                if (hints.get(i).size() > 0) {
                    hints.get(i).removeFirst();
                    squares.addHint(i, (float) d);
                }
            }

            endGameCheck(currentTime);
        }
    }

    public void endGameCheck(Double currentTime) {
        if (beatmap.getSongLength() <= currentTime) {
            ViewManager.popView();
            ViewManager.pushView(new StatsView(this));
            song.stop();
        }
    }

    public int calculateScore(double beatTime, double keyPressedTime) {
        double delta = Math.abs(beatTime - keyPressedTime);

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

    public int calculateCombo(double beatTime, double keyPressedTime) {
        double delta = Math.abs(beatTime - keyPressedTime);

        if(delta > 0) {
            if(delta < HitAccuracy.HIT_300.getCombo()) {
                return HitAccuracy.HIT_300.getFinalCombo();
            } else if (delta < HitAccuracy.HIT_200.getCombo()) {
                return HitAccuracy.HIT_200.getFinalCombo();
            } else if (delta < HitAccuracy.HIT_100.getCombo()) {
                return HitAccuracy.HIT_100.getFinalCombo();
            } else {
                return 0;
            }
        } else {
            if(-delta < HitAccuracy.HIT_300.getCombo()) {
                return HitAccuracy.HIT_300.getFinalCombo();
            } else if (-delta < HitAccuracy.HIT_200.getCombo()) {
                return HitAccuracy.HIT_200.getFinalCombo();
            } else if (-delta < HitAccuracy.HIT_100.getCombo()) {
                return HitAccuracy.HIT_100.getFinalCombo();
            } else {
                return 0;
            }
        }
    }

    public int getFinalCombo() {
        return finalCombo;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public double getFinalPercent() {
        return finalPercent;
    }

}
