package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Player;

import java.awt.*;

public class StartMenu extends View {

    private Player player;
    private Button pauseButton;
    private Button singleplayerButton;
    private Button multiplayerButton;
    private Button optionsButton;
    private Button exitButton;

    public StartMenu() {
        super();
        System.out.println(ViewManager.getAspect());
        player = new Player(1.2f, 0.92f, 0.2f, 0.2f);
        singleplayerButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setText(new Text("Singleplayer", Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN), Color.black, 0.07f))
                .setPosition(0.8f, 0.75f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        multiplayerButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setText(new Text("Multiplayer", Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN), Color.black, 0.07f))
                .setPosition(0.8f, 0.6f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        optionsButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setText(new Text("Settings", Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN), Color.black, 0.07f))
                .setPosition(0.8f, 0.45f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();
        exitButton = Button.builder()
                .setBackgroundTexture(Images.MENU_BUTTON.getTexture())
                .setText(new Text("Exit", Fonts.ROBOTO_LIGHT.getFont().deriveFont(Font.PLAIN), Color.black, 0.07f))
                .setPosition(0.8f, 0.3f)
                .setSize(0.75f, 0.15f)
                .setOrigin(0.5f, 0.5f).build();

        addWidget(player.getPlayButton());
        addWidget(player.getPauseButton());
        addWidget(singleplayerButton);
        addWidget(multiplayerButton);
        addWidget(optionsButton);
        addWidget(exitButton);
    }

    @Override
    public void onViewStarted() {
        singleplayerButton.setOnClickRunnable(() -> ViewManager.pushView(new SongMenu()));
        optionsButton.setOnClickRunnable(() -> ViewManager.pushView(new SettingsMenu()));
        exitButton.setOnClickRunnable(() -> System.exit(0)); // TODO: Replace with requiring exit
    }

}
