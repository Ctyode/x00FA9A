package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.widgets.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;

import java.awt.*;

public class StartMenu extends View {

    private Button singleplayerButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button exitButton;

    public StartMenu() {
        super();
        singleplayerButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setText(new Text("Singleplayer", new Font(Font.SANS_SERIF, Font.PLAIN, 14), Color.black))
                .setPosition(0.8f, 0.75f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        multiplayerButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setPosition(0.8f, 0.6f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        optionsButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setPosition(0.8f, 0.45f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        exitButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setPosition(0.8f, 0.3f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();

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
