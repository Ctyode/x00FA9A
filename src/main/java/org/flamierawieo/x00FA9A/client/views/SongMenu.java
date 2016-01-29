package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Beatmap;
import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.*;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.widget.List;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

import rx.subjects.PublishSubject;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

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
//    private Button selectModeBackground;
    private Background songListBackground;
    private PublishSubject selectedTrack;

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
        bottomPanelBackground = new Background(Images.BOTTOM_PANEL.getTexture(), -0.389f, 0.0f, 0.701822916f, 0.069010416f);
//        selectModeBackground = Button.builder()
//                .setBackgroundTexture(Images.SELECT_MODE.getTexture())
//                .setPosition(-0.389f, 0.0f)
//                .setSize(0.13671875f, 0.130208f)
//                .setOrigin(0.0f, 0.0f).build();
        songListBackground = new Background(Images.SONG_LIST_BACKGROUND.getTexture(), 0.746f, -0.5f, 0.542f, 2.0f);
        searchBackground = new Background(Images.SEARCH_BACKGROUND.getTexture(), 0.98307f, 0.8958333f, 0.342447916f, 0.0833333f);
        mapHeaderBackground = new Background(Images.MAP_HEADER.getTexture(), -0.389f, 0.888f, 0.62239583f, 0.1171875f);
        activeSongBackground = new Background(Images.ACTIVE_SONG_BACKGROUND.getTexture(), 0.67648958f, 0.48567708f, 0.6796875f, 0.1875f, 0.0f, 0.5f);
        songList = new List(0.746f, 0.0f, 0.5f, 1.0f);
        back = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 1.0f, 0.025f);
        backButton = new Button(new Text("Back", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.05f),
                null, -0.4f, 0.0f, 0.2f, 0.1f, 0.0f, 0.0f, back);

        java.util.List<ListItem> itemList = songList.getItemList();
        Beatmap.getBeatmapCache().forEach(b -> itemList.add(new Item(b)));
        selectedBeatmap = new SelectedBeatmap(0.68619791666f, 0.411458333f, 0.65755208333f, 0.16276041666f);
        selectedTrack = PublishSubject.create();
        selectedTrack.subscribe(o -> selectedBeatmap.setSelectedBeatmap(((Item) o).getBeatmap()));

        addWidget(bottomPanelBackground);
//        addWidget(selectModeBackground);
        addWidget(songListBackground);
        addWidget(songList);
        addWidget(searchBackground);
        addWidget(mapHeaderBackground);
        addWidget(activeSongBackground);
        addWidget(selectedBeatmap);
        addWidget(backButton);
    }

    @Override
    public void onViewStarted() {
        selectedBeatmap.setOnClickRunnable(() -> ViewManager.pushView(new SquareMode(selectedBeatmap.getSelectedBeatmap())));
        backButton.setOnClickRunnable(() -> ViewManager.popView());
//        selectModeBackground.setOnClickRunnable(ViewManager::popView);
    }

}
