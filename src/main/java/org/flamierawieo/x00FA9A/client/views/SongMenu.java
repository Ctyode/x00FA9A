package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Background;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.widget.List;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;

import static org.lwjgl.opengl.GL11.*;

public class SongMenu extends View {

    public static final Font artistFont = Fonts.ROBOTO_LIGHT.getFont();
    public static final Font titleFont = Fonts.ROBOTO_LIGHT.getFont();
    public static final Font levelFont = Fonts.ROBOTO_LIGHT.getFont();

    private Background bottomPanelBackground;
    private Background mapHeaderBackground;
    private List songList;
    private Button activeSongBackground;
    private Background searchBackground;
    private Button selectModeBackground;
    private Background songListBackground;

    public static class Item implements List.ListItem {

        private Text artistText;
        private Text titleText;
        private String levelText;

        public Item(String artist, String title, String level) {
            this.artistText = new Text(artist, artistFont, Colors.MEDIUM_GRAY.getColor(), 0.15f);
            this.titleText = new Text(title, titleFont, Colors.DARK_GRAY.getColor(), 0.14f);
            this.levelText = level;
        }

        @Override
        public float getHeight() {
            return 0.09675f;
        }

        @Override
        public void draw(float x, float y) {
            artistText.draw(x + 0.0260416f, y + 0.03515f);
            titleText.draw(x + 0.0260416f, y);
            glColor3f(0.93f, 0.93f, 0.93f);
            glLineWidth(1.0f);
            glBegin(GL_LINES);
            glVertex2f(x + 0.004f, y);
            glVertex2f(x + 0.537760416f, y);
            glEnd();
        }

    }

    public SongMenu() {
        super();
        JSONParser parser = new JSONParser();
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
        songList = new List(0.746f, 0.0f, 0.5f, 1.0f);
        java.util.List<List.ListItem> itemList = songList.getItemList();
        try {
            JSONObject root = (JSONObject) parser.parse(new FileReader("res/json/song_cache.json"));
            String uuid = (String) root.get("cache_uuid");
            System.out.println(uuid);
            JSONArray songs = (JSONArray) root.get("songs");
            songs.forEach(s -> {
                JSONObject song = (JSONObject) s;
                itemList.add(new Item((String) song.get("artist"), (String) song.get("title"), (String) song.get("author")));
            });
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

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
