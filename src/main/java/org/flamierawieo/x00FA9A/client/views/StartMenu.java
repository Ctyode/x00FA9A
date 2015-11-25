package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.ui.Button;
import org.flamierawieo.x00FA9A.client.ui.View;

import org.newdawn.slick.*;

public class StartMenu extends View {

    private Image singleplayerImg, multiplayerImg, optionsImg, exitImg;
    private Button singleplayerButton, multiplayerButton, optionsButton, exitButton;

    public StartMenu() {
        super();
        singleplayerImg = Images.SINGLEPLAYER_BUTTON.getImage();
        multiplayerImg = Images.MULTIPLAYER_BUTTON.getImage();
        optionsImg = Images.OPTIONS_BUTTON.getImage();
        exitImg = Images.EXIT_BUTTON.getImage();

        singleplayerButton = new Button(singleplayerImg, 0.5f, 0.1f, 0.5f, 0.5f);
        singleplayerButton.onClick(() -> viewManager.pushView(new SongMenu()));
        multiplayerButton = new Button(multiplayerImg, 0.5f, 0.3f, 0.5f, 0.5f);
        optionsButton = new Button(optionsImg, 0.5f, 0.5f, 0.5f, 0.5f);
        exitButton = new Button(exitImg, 0.5f, 0.7f, 0.5f, 0.5f);
        exitButton.onClick(container::exit);

        addWidget(singleplayerButton);
        addWidget(multiplayerButton);
        addWidget(optionsButton);
        addWidget(exitButton);
    }

}