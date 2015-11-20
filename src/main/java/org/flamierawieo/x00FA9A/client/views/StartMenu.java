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

    public StartMenu() {
        super();

        Image singleplayerImg = Images.SINGLEPLAYER_BUTTON.getImage();
        Image multiplayerImg = Images.MULTIPLAYER_BUTTON.getImage();
        Image optionsImg = Images.OPTIONS_BUTTON.getImage();
        Image exitImg = Images.EXIT_BUTTON.getImage();

<<<<<<< HEAD
        singleplayerButton = new Button(singleplayerImg, 0.5f, 0.1f, 0.5f, 0.5f);
        multiplayerButton = new Button(multiplayerImg, 0.5f, 0.3f, 0.5f, 0.5f);
        optionsButton = new Button(optionsImg, 0.5f, 0.5f, 0.5f, 0.5f);
        exitButton = new Button(exitImg, 0.5f, 0.7f, 0.5f, 0.5f);
=======
        singleplayerButton = new Button(singleplayerImg, (width / 2) -
                ((singleplayerImg.getWidth() / 2f)), height * 0.1f);
        singleplayerButton.onClick(() -> viewManager.pushView(new SongMenu()));

        multiplayerButton = new Button(multiplayerImg, (width / 2) -
                ((multiplayerImg.getWidth() / 2f)), height * 0.3f);
        optionsButton = new Button(optionsImg, (width / 2) -
                ((optionsImg.getWidth() / 2f)), height * 0.5f);
        exitButton = new Button(exitImg, (width / 2) -
                ((exitImg.getWidth() / 2f)), height * 0.7f);
        exitButton.onClick(() -> container.exit());
>>>>>>> refs/remotes/origin/master

        addWidget(singleplayerButton);
        addWidget(multiplayerButton);
        addWidget(optionsButton);
        addWidget(exitButton);
    }

}