package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;

import org.flamierawieo.x00FA9A.client.ui.Background;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.newdawn.slick.Image;

public class SongMenu extends View {

    private Background songListBackground, activeSongBackground, searchBackground;

    public SongMenu() {
        super();
        int width = container.getWidth();
        int height = container.getHeight();

        Image songListBackgroundImg = Images.SONG_LIST_BACKGROUND.getImage();
        Image activeSongBackgroundImg = Images.ACTIVE_SONG_BACKGROUND.getImage();
        Image searchBackgroundImg = Images.SEARCH_BACKGROUND.getImage();

        songListBackground = new Background(songListBackgroundImg,
                (width - songListBackgroundImg.getWidth()) * 0.95f,
                (height - songListBackgroundImg.getHeight()) * 0.5f );
        activeSongBackground = new Background(activeSongBackgroundImg,
                (width - activeSongBackgroundImg.getWidth()) * 1.03f,
                (height - activeSongBackgroundImg.getHeight()) * 0.5f );
        searchBackground = new Background(searchBackgroundImg,
                (width - searchBackgroundImg.getWidth()) * 0.98f,
                (height - searchBackgroundImg.getHeight()) * 0.05f );

        addWidget(songListBackground);
        addWidget(activeSongBackground);
        addWidget(searchBackground);

    }



}
