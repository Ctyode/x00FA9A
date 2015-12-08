package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.widgets.Background;

public class SettingsMenu extends View {

    private Background settingsLine;
    private Background settingsBackground;

    public SettingsMenu() {
        super();
        settingsBackground = new Background(Images.SETTINGS_BACKGROUND.getTexture(), 0.499f, -0.5f, 0.603f, 2.0f);
        settingsLine = new Background(Images.SETTINGS_LINE.getTexture(), 0.5f, 0.5f, 0.6f, 0.001f);

        addWidget(settingsBackground);
        addWidget(settingsLine);
    }

}
