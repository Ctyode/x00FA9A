package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;

import org.flamierawieo.x00FA9A.client.ui.Background;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.widgets.SongList;
import org.newdawn.slick.Image;

public class SongMenu extends View {

    private Background songListBackground, activeSongBackground, searchBackground;
    private SongList songList;

    public SongMenu() {
        super();
        int width = container.getWidth();
        int height = container.getHeight();

        Image songListBackgroundImg = Images.SONG_LIST_BACKGROUND.getImage();
        Image activeSongBackgroundImg = Images.ACTIVE_SONG_BACKGROUND.getImage();
        Image searchBackgroundImg = Images.SEARCH_BACKGROUND.getImage();

        songListBackground = new Background(songListBackgroundImg, 0.95f, 0.5f, 1.0f, 0.5f);
        activeSongBackground = new Background(activeSongBackgroundImg, 1.03f, 0.5f, 1.0f, 0.5f);
        searchBackground = new Background(searchBackgroundImg, 0.98f, 0.05f, 1.0f, 0.5f);
        songList = new SongList(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);

        addWidget(songListBackground);
        addWidget(activeSongBackground);
        addWidget(searchBackground);
        addWidget(songList);

    }



}
