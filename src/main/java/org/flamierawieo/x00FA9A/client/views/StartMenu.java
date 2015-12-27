package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.graphics.Circle;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.widget.Player;

import java.awt.*;

public class StartMenu extends View {

    private Player player;
    private Surface singleplayerButton;
    private Circle circle;

    public StartMenu() {
        super();
        player = new Player(1.2f, 0.92f, 0.2f, 0.2f);
        circle = new Circle(new Color(0.0f, 1.0f, 0.0f, 0.5f), new Color(1.0f, 0.0f, 0.0f, 0.5f), 20.0f);
        singleplayerButton = new Surface(new Color(0.0f, 1.0f, 0.0f, 0.5f), new Color(1.0f, 0.0f, 0.0f, 0.5f), 20.0f, 0.1f);
        addWidget(player.getPlayButton());
        addWidget(player.getPauseButton());
    }

    @Override
    public void draw() {
        super.draw();
//        singleplayerButton.draw(0.1f, 0.1f, 0.5f, 0.5f);
        circle.draw(1.5f, 1.5f, 0.2f, 0.0f, 1.0f, 64);
    }

}
