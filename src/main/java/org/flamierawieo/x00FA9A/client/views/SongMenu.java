package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Background;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.widget.List;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

import java.awt.*;

public class SongMenu extends View {

    private List songList;
    private Button activeSongBackground;
    private Background searchBackground;
    private Button selectModeBackground;
    private Background songListBackground;

    public class Item implements List.ListItem {

        private Text text;

        public Item(String text, Font font) {
            this.text = new Text(text, font, Color.black);
        }

        @Override
        public float getHeight() {
            return text.getHeight();
        }

        @Override
        public void draw(float x, float y) {
            text.draw(x, y);
        }

    }

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
        songList = new List(0.55f, 0.0f, 0.5f, 1.0f);
        java.util.List<List.ListItem> itemList = songList.getItemList();
        Font font = Fonts.ROBOTO_LIGHT.getFont().deriveFont(50.0f);
        for(int i = 0; i < 100; i++) {
            itemList.add(new Item("Item #" + i, font));
        }

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
