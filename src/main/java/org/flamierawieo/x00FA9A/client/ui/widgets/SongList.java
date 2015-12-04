package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import java.awt.*;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SongList extends Widget {

    public static class ListItem {

        public static final float ITEM_HEIGHT = 0.1f;

        private String artist;
        private String songName;
        private String author;
        private byte availableDifficulties;
        private Text artistText;
        private Text songNameText;
        private Text authorText;

        public ListItem(String artist, String songName, String author, byte availableDifficulties) {
            this.artist = artist;
            this.songName = songName;
            this.author = author;
            this.availableDifficulties = availableDifficulties;

            artistText = new Text(artist, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 30.0f));
            songNameText = new Text(songName, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 40.0f));
            authorText = new Text(author, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 20.0f));
        }

        public String getArtist() {
            return artist;
        }

        public String getSongName() {
            return songName;
        }

        public String getAuthor() {
            return author;
        }

        public byte getAvailableDifficulties() {
            return availableDifficulties;
        }

        public void draw(float x, float y) {
            artistText.draw(x, y);
            songNameText.draw(x, y + 0.03f);
            authorText.draw(x, y + 0.06f);
        }

    }

    private Collection<ListItem> songs;
    private Predicate<ListItem> filter;
    private float scroll;

    public SongList(Collection<ListItem> songs, float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        this.songs = songs;
        this.filter = (i) -> true;
    }

    public SongList(Collection<ListItem> songs, float x, float y, float width, float height) {
        this(songs, x, y, width, height, 0.0f, 0.0f);
    }

    public void removeFilter() {
        filter = (i) -> true;
    }

    public void setFilter(Predicate<ListItem> filter) {
        this.filter = filter;
    }

    @Override
    public void onScroll(double x, double y) {
        scroll -= y * 0.1;
    }

    @Override
    public void draw() {
        float offset = scroll;
        for(ListItem song : songs.stream().filter(filter).collect(Collectors.toList())) {
            song.draw(getAbsolutePositionX(), getAbsolutePositionY() + offset);
            offset += ListItem.ITEM_HEIGHT;
        }
    }

}
