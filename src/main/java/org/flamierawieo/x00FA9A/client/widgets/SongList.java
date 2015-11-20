package org.flamierawieo.x00FA9A.client.widgets;

import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v2_3;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.farng.mp3.filename.FilenameTag;
import org.farng.mp3.id3.ID3v2_4;
import org.newdawn.slick.Graphics;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SongList extends Widget {

    private String title;
    private String artist;

    public SongList(float x, float y, float w, float h, float originX, float originY) {
        super(x, y, w, h, originX, originY);

        ID3v2_3 id3v2_3 = new ID3v2_3();
        try {
            id3v2_3.read(new RandomAccessFile(new File("res/testmusic/05 Canada Was The Largest Eurodance Market Outside Europe.mp3"), "r"));
        } catch (TagException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        artist = id3v2_3.getLeadArtist();
        title = id3v2_3.getSongTitle();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawString(artist + " - " + title, 100, 100);
    }
}
