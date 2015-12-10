package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.ui.widgets.Background;
import org.flamierawieo.x00FA9A.client.ui.widgets.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widgets.SongList;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

public class SongMenu extends View {

    private SongList songList;
    private Button activeSongBackground;
    private Background searchBackground;
    private Button selectModeBackground;
    private Background songListBackground;

    public SongMenu() {
        super();
        selectModeBackground = Button.builder()
                .setBackgroundTexture(Images.SELECT_MODE.getTexture())
                .setPosition(-0.3f, 1.15f)
                .setSize(0.3f, 0.3f)
                .setOrigin(0.0f, 1.0f).build();
        songListBackground = new Background(Images.SONG_LIST_BACKGROUND.getTexture(), 0.5f, -0.5f, 0.6f, 2.0f);
        searchBackground = new Background(Images.SEARCH_BACKGROUND.getTexture(), 0.7f, 0.9f, 0.5f, 0.1f);
        activeSongBackground = Button.builder()
                .setBackgroundTexture(Images.ACTIVE_SONG_BACKGROUND.getTexture())
                .setPosition(0.8f, 0.5f)
                .setSize(0.8f, 0.18f)
                .setOrigin(0.5f, 0.5f).build();
        songList = new SongList(0.5f, 0.5f, 0.5f, 0.5f);

        addWidget(selectModeBackground);
        addWidget(songListBackground);
        addWidget(songList);
        addWidget(searchBackground);
        addWidget(activeSongBackground);
    }

    @Override
    public void onViewStarted(ViewManager viewManager) {
        activeSongBackground.setOnClickRunnable(() -> viewManager.pushView(new SquareMode()));
        selectModeBackground.setOnClickRunnable(viewManager::popView);
    }

}
