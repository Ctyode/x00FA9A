package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.ui.Button;
import org.flamierawieo.x00FA9A.client.ui.View;
import static org.lwjgl.opengl.GL11.*;

public class StartMenu extends View {

    private Button exitButton;

    public StartMenu() {
        super();
        exitButton = new Button(new Sprite(Images.MENU_BUTTON.getTextureID(), 0.0f, 0.5f, 1.0f, 0.2f), 0.5f, 0.5f, 0.5f, 0.5f);
        exitButton.setOnClickRunnable(() -> System.exit(0)); // TODO: Replace with requiring exit

        addWidget(exitButton);
    }

}
