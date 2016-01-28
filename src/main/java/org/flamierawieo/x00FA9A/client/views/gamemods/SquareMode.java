package org.flamierawieo.x00FA9A.client.views.gamemods;

import javafx.application.Platform;
import org.flamierawieo.x00FA9A.client.*;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Squares;
import org.flamierawieo.x00FA9A.client.views.SongMenu;

import java.io.IOException;
import java.util.*;
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
    private Beatmap length;
    private int songLength;
    static final Object lock = new Object();


    public SquareMode(Beatmap b) {
        super();
        squares = new Squares(0.1f, 0.1f, 1.0f, 1.0f);
        scoreText = new Text(Integer.toString(score), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        deque = new ArrayList<>();
        b.getSquareModeTiming().forEach(t -> deque.add(new ArrayDeque<>(t.stream().sorted(Double::compare).collect(Collectors.toList()))));
        hints = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
                hints.add(new ArrayDeque<>(deque.get(i)));
            }
        length = b;
        System.out.println(length.getSongLength());
        addWidget(squares);

        try {
//            execWithRate(1000, 2);
            song = Sound.loadFromOggFile(b.getOgg());
            songLength = length.getSongLength();
            Timer timer = new Timer();
            int checkTime = 1000 * length.getSongLength();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        if((glfwGetTime() - startedTime + 1) >= songLength) {
                            System.out.println("mdaaaaaaaa");
                            System.out.println(glfwGetTime() - startedTime + 1);
                            ViewManager.pushView(new SongMenu());
                        } else {
                            System.out.println("((");
                            System.out.println(glfwGetTime() - startedTime + 1);
                        }
                    });
                }
            }, checkTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private synchronized void execWithRate(long timeout, int iterations) throws InterruptedException {
//        synchronized (this) {
//            for (int i = 0; i < iterations; i++) {
//                lock.wait(timeout);
//
//                System.out.println(
//                        " time: " + (System.currentTimeMillis() / 1000 + timeout) +
//                                " iter " + i +
//                                " thread " + Thread.currentThread().getName());
//                ViewManager.pushView(new SongMenu());
//            }
//        }
//    }

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
        for(int j = 0; j <= 8; j++) {
            if (deque.size() > 0 && deque.get(j).size() > 0) {
                nearestBeatTime = deque.get(j).getFirst();
            }
            while ((delta = nearestBeatTime - currentTime) < 0 && deque.size() > 0 && deque.get(j).size() > 0) {
                deque.get(j).removeFirst();
                if (deque.get(j).size() > 0) {
                    nearestBeatTime = deque.get(j).getFirst();
                } else {
                    nearestBeatTime = 0.0;
                }
            }
            int i = calculateScore(nearestBeatTime, currentTime);
            if (i > 0) {
                score += i;
                scoreText.setString(Integer.toString(score));
            }
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

}
