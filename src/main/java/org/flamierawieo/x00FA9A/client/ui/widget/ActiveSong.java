package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;

public class ActiveSong extends Widget {

    private String artist;
    private String title;
    private String level;
    private Text artistText;
    private Text titleText;
    private Text levelText;

    public ActiveSong(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        artistText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        titleText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        levelText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
    }

    public ActiveSong(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public void setArtist(String artist) {
        this.artist = artist;
        artistText.setString(this.artist);
    }

    public void setTitle(String title) {
        this.title = title;
        titleText.setString(this.title);
    }

    public void setLevel(String level) {
        this.level = level;
        levelText.setString(this.level);
    }

    @Override
    public void draw() {
        artistText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.04515f);
        titleText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.01f);
    }
}
