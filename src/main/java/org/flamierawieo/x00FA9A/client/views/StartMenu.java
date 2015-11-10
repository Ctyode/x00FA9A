package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.Button;
import org.flamierawieo.x00FA9A.client.ui.View;

import org.newdawn.slick.*;

public class StartMenu extends View {

    private Button singleplayerButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button exitButton;

    public StartMenu(GameContainer container) {
        super(container);
        Image singleplayerImg = Images.SINGLEPLAYER_BUTTON.getImage();
        Image multiplayerImg = Images.MULTIPLAYER_BUTTON.getImage();
        Image optionsImg = Images.OPTIONS_BUTTON.getImage();
        Image exitImg = Images.EXIT_BUTTON.getImage();
        int width = container.getWidth();
        int height = container.getHeight();
        singleplayerButton = new Button(singleplayerImg, (width / 2) - ((singleplayerImg.getWidth() / 2f)), height * 0.1f, () -> System.out.println("singleplayer"));
        multiplayerButton = new Button(multiplayerImg, (width / 2) - ((multiplayerImg.getWidth() / 2f)), height * 0.3f, () -> System.out.println("multiplayer"));
        optionsButton = new Button(optionsImg, (width / 2) - ((optionsImg.getWidth() / 2f)), height * 0.5f, () -> System.out.println("options"));
        exitButton = new Button(exitImg, (width / 2) - ((exitImg.getWidth() / 2f)), height * 0.7f, () -> System.out.println("exit"));
        addWidget(singleplayerButton);
        addWidget(multiplayerButton);
        addWidget(optionsButton);
        addWidget(exitButton);
    }

}