package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.widget.Player;

public class StartMenu extends View {

    private Player player;
    private Surface singleplayerButtonSurface;
    private Button singleplayerButton;

    public StartMenu() {
        super();
//        player = new Player(1.2f, 0.92f, 0.2f, 0.2f);
        singleplayerButtonSurface = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 1.0f);
        singleplayerButton = new Button(new Text("Singleplayer", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.05f), null, 0.5f, 0.5f, 0.5f, 0.1f, 0.0f, 0.0f, singleplayerButton);

        addWidget(singleplayerButton);
//        addWidget(player.getPlayButton());
//        addWidget(player.getPauseButton());
    }

    @Override
    public void draw() {
        super.draw();
        singleplayerButtonSurface.draw(0.5f, 0.5f, 0.5f, 0.1f, 0.025f);
    }

    @Override
    public void onViewStarted() {
        singleplayerButton.setOnClickRunnable(() -> ViewManager.pushView(new SongMenu()));
    }
}
