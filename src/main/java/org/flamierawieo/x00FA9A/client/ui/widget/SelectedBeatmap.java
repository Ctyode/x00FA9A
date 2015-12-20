package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.Beatmap;
import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;

public class SelectedBeatmap extends Widget {

    private Beatmap selectedBeatmap;
    private Text artistText;
    private Text titleText;
    private Text levelText;
    private Runnable onClickRunnable;

    public SelectedBeatmap(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        artistText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        titleText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        levelText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
    }

    public SelectedBeatmap(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public Beatmap getSelectedBeatmap() {
        return selectedBeatmap;
    }

    public void setSelectedBeatmap(Beatmap beatmap) {
        selectedBeatmap = beatmap;
        artistText.setString(selectedBeatmap.getArtist());
        titleText.setString(selectedBeatmap.getTitle());
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw() {
        artistText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.13015f);
        titleText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.095f);
        levelText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.06f);
    }

}
