package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.BasicView;
import org.flamierawieo.x00FA9A.client.ui.Button;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class StartMenu extends BasicView {

    private Button singleplayerButton, multiplayerButton, optionsButton, exitButton;

    public StartMenu(int state) {
        super(state);
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

        singleplayerButton = new Button(container, singleplayerImg,
                (width / 2) - ((singleplayerImg.getWidth() / 2f)), height * 0.1f
        );

        multiplayerButton = new Button(container, multiplayerImg,
                (width / 2) - ((multiplayerImg.getWidth() / 2f)), height * 0.3f
        );

        optionsButton = new Button(container, optionsImg,
                (width / 2) - ((optionsImg.getWidth() / 2f)), height * 0.5f
        );

        exitButton = new Button(container, exitImg,
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