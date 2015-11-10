package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.BasicView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SongSelectionMenu extends BasicView {

    public SongSelectionMenu(int state) {
        super(state);
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

        super.init(container, game);

        Image songsBackgroundImg = Images.SONGS_BACKGROUND.getImage();

    }
}
