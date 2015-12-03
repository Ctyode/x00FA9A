package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.widgets.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widgets.Text;

import java.awt.*;

public class StartMenu extends View {

    private Button singleplayerButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button exitButton;
    private Text text;

    public StartMenu() {
        super();
        singleplayerButton = new Button(0.8f, 0.75f, 0.75f, 0.15f, 0.5f, 0.5f, new Sprite(Images.MENU_BUTTON.getTextureID()));
        multiplayerButton = new Button(0.8f, 0.6f, 0.75f, 0.15f, 0.5f, 0.5f, new Sprite(Images.MENU_BUTTON.getTextureID()));
        optionsButton = new Button(0.8f, 0.45f, 0.75f, 0.15f, 0.5f, 0.5f, new Sprite(Images.MENU_BUTTON.getTextureID()));
        exitButton = new Button(0.8f, 0.3f, 0.75f, 0.15f, 0.5f, 0.5f, new Sprite(Images.MENU_BUTTON.getTextureID()));

        addWidget(singleplayerButton);
        addWidget(multiplayerButton);
        addWidget(optionsButton);
        addWidget(exitButton);
    }

    @Override
    public void onViewStarted(ViewManager viewManager) {
        singleplayerButton.setOnClickRunnable(() -> viewManager.pushView(new SongMenu()));
        exitButton.setOnClickRunnable(() -> System.exit(0)); // TODO: Replace with requiring exit
    }
}
