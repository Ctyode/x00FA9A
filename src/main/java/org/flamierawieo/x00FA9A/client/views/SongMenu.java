package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.*;
import org.flamierawieo.x00FA9A.client.graphics.*;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.*;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.widget.List;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

import rx.subjects.PublishSubject;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.glfw.GLFW.*;

public class SongMenu extends View {

    public static final Font artistFont = Fonts.ROBOTO_LIGHT.getFont();
    public static final Font titleFont = Fonts.ROBOTO_LIGHT.getFont();
    public static final Font levelFont = Fonts.ROBOTO_LIGHT.getFont();

    private Button backButton;
    private Surface back;
    private SelectedBeatmap selectedBeatmap;
    private Background bottomPanelBackground;
    private Background mapHeaderBackground;
    private List songList;
    private Background activeSongBackground;
    private Background searchBackground;
    private Background songListBackground;
    private PublishSubject selectedTrack;
    private boolean isSongSelected;
    private Sprite selectedBeatmapBackground;
    private final Vignette vignette;
    private final Surface whatever;

    public class Item implements ListItem {

        private Beatmap beatmap;
        private Text artistText;
        private Text titleText;

        public Item(Beatmap b) {
            this.beatmap = b;
            this.artistText = new Text(beatmap.getArtist(), artistFont, Colors.MEDIUM_GRAY.getColor(), 0.04f);
            this.titleText = new Text(beatmap.getTitle(), titleFont, Colors.DARK_GRAY.getColor(), 0.03f);
        }

        public Beatmap getBeatmap() {
            return beatmap;
        }

        @Override
        public float getHeight() {
            return 0.0975f;
        }

        @Override
        public void onChosen() {
            selectedTrack.onNext(this);
            isSongSelected = true;
        }

        @Override
        public void draw(float x, float y) {
            artistText.draw(x + 0.0260416f, y + 0.04515f);
            titleText.draw(x + 0.0260416f, y + 0.01f);
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
        isSongSelected = true;
        whatever = new Surface(Color.WHITE, Color.WHITE, 1.0f, 0.02f, 0.1f);
        bottomPanelBackground = new Background(Images.BOTTOM_PANEL.getTexture(), -0.389f, 0.0f, 0.701822916f, 0.069010416f);
        songListBackground = new Background(Images.SONG_LIST_BACKGROUND.getTexture(), 0.746f, -0.5f, 0.542f, 2.0f);
        searchBackground = new Background(Images.SEARCH_BACKGROUND.getTexture(), 0.98307f, 0.8958333f, 0.342447916f, 0.0833333f);
        mapHeaderBackground = new Background(Images.MAP_HEADER.getTexture(), -0.389f, 0.888f, 0.62239583f, 0.1171875f);
        vignette = new Vignette();
        activeSongBackground = new Background(Images.ACTIVE_SONG_BACKGROUND.getTexture(), 0.67648958f, 0.48567708f, 0.6796875f, 0.1875f, 0.0f, 0.5f);
        songList = new List(0.746f, 0.0f, 0.5f, 1.0f);
        back = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 1.0f, 0.025f);
        backButton = new Button(new Text("Back", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.05f),
                null, -0.4f, 0.0f, 0.2f, 0.1f, 0.0f, 0.0f, back);

        java.util.List<ListItem> itemList = songList.getItemList();
        Beatmap.getBeatmapCache().forEach(b -> itemList.add(new Item(b)));
        selectedBeatmap = new SelectedBeatmap(0.68619791666f, 0.411458333f, 0.65755208333f, 0.16276041666f);
        selectedTrack = PublishSubject.create();
        selectedTrack.subscribe(o -> {
            if(o != null) {
                selectedBeatmap.setSelectedBeatmap(((Item) o).getBeatmap());
            }
        });
        selectedBeatmapBackground = new Sprite(Images.BASIC_BACKGROUND.getTexture());
        selectedTrack.subscribe(o -> {
            if(o != null) {
                Beatmap beatmap = ((Item) o).getBeatmap();
                selectedBeatmapBackground.setTexture(Resources.getTexture(beatmap.getBackground().getAbsolutePath()));
            } else {
                selectedBeatmapBackground.setTexture(Images.BASIC_BACKGROUND.getTexture());
            }
        });
    }

    @Override
    public void onMouseButtonDown(float x, float y, int button, int mods) {
        if(isHovered(backButton, x, y)) {
            backButton.onMouseButtonDown(x, y, button, mods);
            return;
        }
        if(isHovered(selectedBeatmap, x, y)) {
            selectedBeatmap.onMouseButtonDown(x, y, button, mods);
            return;
        }
        if(isHovered(songList, x, y)) {
            songList.onMouseButtonDown(x, y, button, mods);
            return;
        }
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        if(key == GLFW_KEY_ESCAPE) {
            isSongSelected = false;
            selectedTrack.onNext(null);
        }
    }

    @Override
    public void onViewStarted() {
        selectedBeatmap.setOnClickRunnable(() -> ViewManager.pushView(new SquareMode(selectedBeatmap.getSelectedBeatmap())));
        backButton.setOnClickRunnable(() -> System.exit(0));
    }

    @Override
    public void tick(float delta) {
        super.tick(delta);
        bottomPanelBackground.tick(delta);
        songListBackground.tick(delta);
        songList.tick(delta);
        searchBackground.tick(delta);
        mapHeaderBackground.tick(delta);
        activeSongBackground.tick(delta);
        selectedBeatmap.tick(delta);
        backButton.tick(delta);
        if(isSongSelected) {
            activeSongBackground.setX((activeSongBackground.getX() + 0.67648958f) / 2.0f);
            selectedBeatmap.setX(0.68619791666f);
        } else {
            activeSongBackground.setX(2.0f);
            selectedBeatmap.setX(2.0f);
        }
    }

    @Override
    public void draw() {
        super.draw();
        selectedBeatmapBackground.draw(-((ViewManager.getAspect() - 1.0f) / 2.0f), 0.0f, ViewManager.getAspect(), 1.0f);
//        vignette.draw(0.0f, 0.0f, 1.0f, 1.0f);
        whatever.draw(0.5f, 0.5f, 0.2f, 0.2f);
        bottomPanelBackground.draw();
        songListBackground.draw();
        songList.draw();
        searchBackground.draw();
        mapHeaderBackground.draw();
        activeSongBackground.draw();
        selectedBeatmap.draw();
        backButton.draw();
    }
}
