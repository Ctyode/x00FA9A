package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Background;
import org.flamierawieo.x00FA9A.client.ui.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

public class SongMenu extends View {

    private Button activeSongBackground;
    private Background searchBackground;
    private Button selectModeBackground;
    private Background songListBackground;

    public SongMenu() {
        super();
        selectModeBackground = new Button(-0.3f, 1.15f, 0.3f, 0.3f, 0.0f, 1.0f, new Sprite(Images.SELECT_MODE.getTextureID()));
        songListBackground = new Background(new Sprite(Images.SONG_LIST_BACKGROUND.getTextureID()), 0.5f, -0.5f, 0.6f, 2.0f);
        searchBackground = new Background(new Sprite(Images.SEARCH_BACKGROUND.getTextureID()), 0.7f, 0.9f, 0.5f, 0.1f);
        activeSongBackground = new Button(0.8f, 0.5f, 0.8f, 0.18f, 0.5f, 0.5f, new Sprite(Images.ACTIVE_SONG_BACKGROUND.getTextureID()));

        addWidget(selectModeBackground);
        addWidget(songListBackground);
        addWidget(searchBackground);
        addWidget(activeSongBackground);
    }

    @Override
    public void onViewStarted(ViewManager viewManager) {
        activeSongBackground.setOnClickRunnable(() -> viewManager.pushView(new SquareMode()));
        selectModeBackground.setOnClickRunnable(() -> viewManager.popView());
    }
}
