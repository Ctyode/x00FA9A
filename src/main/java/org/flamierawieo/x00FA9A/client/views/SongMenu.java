package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.ui.widgets.Background;
import org.flamierawieo.x00FA9A.client.ui.widgets.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widgets.SongList;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

public class SongMenu extends View {

    private final Background bottomPanelBackground;
    private final Background mapHeaderBackground;
    private SongList songList;
    private Button activeSongBackground;
    private Background searchBackground;
    private Button selectModeBackground;
    private Background songListBackground;

    public SongMenu() {
        super();
        bottomPanelBackground = new Background(Images.BOTTOM_PANEL.getTexture(), -0.389f, 0.0f, 0.701822916f, 0.069010416f);
        selectModeBackground = Button.builder()
                .setBackgroundTexture(Images.SELECT_MODE.getTexture())
                .setPosition(-0.389f, 0.0f)
                .setSize(0.13671875f, 0.130208f)
                .setOrigin(0.0f, 0.0f).build();
        songListBackground = new Background(Images.SONG_LIST_BACKGROUND.getTexture(), 0.746f, -0.5f, 0.542f, 2.0f);
        searchBackground = new Background(Images.SEARCH_BACKGROUND.getTexture(), 0.98307f, 0.8958333f, 0.342447916f, 0.0833333f);
        mapHeaderBackground = new Background(Images.MAP_HEADER.getTexture(), -0.389f, 0.888f, 0.62239583f, 0.1171875f);
        activeSongBackground = Button.builder()
                .setBackgroundTexture(Images.ACTIVE_SONG_BACKGROUND.getTexture())
                .setPosition(0.683f, 0.5f)
                .setSize(0.6796875f, 0.1875f)
                .setOrigin(0.0f, 0.5f).build();
        songList = new SongList(0.5f, 0.5f, 0.5f, 0.5f);

        addWidget(bottomPanelBackground);
        addWidget(selectModeBackground);
        addWidget(songListBackground);
        addWidget(songList);
        addWidget(searchBackground);
        addWidget(mapHeaderBackground);
        addWidget(activeSongBackground);
    }

    @Override
    public void onViewStarted(ViewManager viewManager) {
        activeSongBackground.setOnClickRunnable(() -> viewManager.pushView(new SquareMode()));
        selectModeBackground.setOnClickRunnable(viewManager::popView);
    }

}
