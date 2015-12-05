package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import java.awt.*;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SongList extends Widget {

    public static class ListItem {

        public static final float ITEM_HEIGHT = 0.1f;

        private String author;
        private String songName;
        private String artist;
        private byte availableDifficulties;
        private Text authorText;
        private Text songNameText;
        private Text artistText;

        public ListItem(String author, String songName, String artist, byte availableDifficulties) {
            this.author = author;
            this.songName = songName;
            this.artist = artist;
            this.availableDifficulties = availableDifficulties;

            authorText = new Text(author, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 40.0f));
            songNameText = new Text(songName, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 40.0f));
            artistText = new Text(artist, Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN, 40.0f));
        }

        public String getAuthor() {
            return author;
        }

        public String getSongName() {
            return songName;
        }

        public String getArtist() {
            return artist;
        }

        public byte getAvailableDifficulties() {
            return availableDifficulties;
        }

        public void draw(float x, float y) {
            authorText.draw(x, y);
            songNameText.draw(x, y + 0.04f);
            artistText.draw(x, y);
        }
    }

    private Collection<ListItem> songs;
    private Predicate<ListItem> filter;

    public SongList(Collection<ListItem> songs, float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        this.songs = songs;
        this.filter = (i) -> true;
    }

    public SongList(Collection<ListItem> songs, float x, float y, float width, float height) {
        this(songs, x, y, width, height, 0.0f, 0.0f);
    }

    public void setFilter(Predicate<ListItem> filter) {
        this.filter = filter;
    }

    @Override
    public void draw() {
        float offset = 0.0f;
        for(ListItem song : songs.stream().filter(filter).collect(Collectors.toList())) {
            song.draw(getAbsolutePositionX(), getAbsolutePositionY() + offset);
            offset += ListItem.ITEM_HEIGHT;
        }
    }
}
