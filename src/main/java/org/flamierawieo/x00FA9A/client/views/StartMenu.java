package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.widget.Player;

public class StartMenu extends View {

    private Player player;
    private Surface singleplayerButton;

    public StartMenu() {
        super();
        player = new Player(1.2f, 0.92f, 0.2f, 0.2f);
        singleplayerButton = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 0.0f);
        addWidget(player.getPlayButton());
        addWidget(player.getPauseButton());
    }

    @Override
    public void draw() {
        super.draw();
        singleplayerButton.draw(0.5f, 0.5f, 0.5f, 0.1f, 0.025f);
    }

}
