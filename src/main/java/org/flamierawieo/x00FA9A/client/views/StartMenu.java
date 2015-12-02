package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Button;
import org.flamierawieo.x00FA9A.client.ui.View;

public class StartMenu extends View {

    private Button exitButton;

    public StartMenu() {
        super();
        exitButton = new Button(0.5f, 0.5f, 1.0f, 0.2f, 0.5f, 0.5f, new Sprite(Images.MENU_BUTTON.getTextureID()));
        exitButton.setOnClickRunnable(() -> System.exit(0)); // TODO: Replace with requiring exit

        addWidget(exitButton);
    }

}
