package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenu extends View {

    private Widget singleplayerButton, multiplayerButton, optionsButton, exitButton;

    public StartMenu() {

    }


    @Override
    public void init(GameContainer container, StateBasedGame game)
            throws SlickException {

        super.init(container, game);

        // initialize menu buttons
        Image singleplayerImg = Images.SINGLEPLAYER_BUTTON.getImage();
        Image multiplayerImg = Images.MULTIPLAYER_BUTTON.getImage();
        Image optionsImg = Images.OPTIONS_BUTTON.getImage();
        Image exitImg = Images.EXIT_BUTTON.getImage();

        singleplayerButton = new Widget(null, container, singleplayerImg,
                (width / 2) - ((singleplayerImg.getWidth() / 2f)), height * 0.1f
        );

        multiplayerButton = new Widget(null, container, multiplayerImg,
                (width / 2) - ((multiplayerImg.getWidth() / 2f)), height * 0.3f
        );

        optionsButton = new Widget(null, container, optionsImg,
                (width / 2) - ((optionsImg.getWidth() / 2f)), height * 0.5f
        );

        exitButton = new Widget(null, container, exitImg,
                (width / 2) - ((exitImg.getWidth() / 2f)), height * 0.7f
        );

    }


    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g)
            throws SlickException {

        int width = container.getWidth();
        int height = container.getHeight();

        g.setBackground(Color.black);
        g.setColor(Color.white);

        singleplayerButton.draw();
        multiplayerButton.draw();
        optionsButton.draw();
        exitButton.draw();

    }
}