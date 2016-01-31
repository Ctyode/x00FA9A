package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.Keyboard;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.widget.Background;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.Collectors;

public class SettingsMenu extends View {

//    private final ArrayList<Deque<Integer>> deque;
    private Keyboard keyboard;
    private Background settingsLine;
    private Background settingsBackground;

    public SettingsMenu(Keyboard k) {
        super();
        settingsBackground = new Background(Images.SETTINGS_BACKGROUND.getTexture(), 0.499f, -0.5f, 0.603f, 2.0f);
        settingsLine = new Background(Images.SETTINGS_LINE.getTexture(), 0.5f, 0.5f, 0.6f, 0.001f);

        addWidget(settingsBackground);
        addWidget(settingsLine);

//        keyboard = k;
//        deque = new ArrayList<>();
//        k.getKeysSettings().forEach(t -> deque.add(new ArrayDeque<>(t.stream().sorted(Integer::compare).collect(Collectors.toList()))));
//        System.out.println(keyboard.getKeysSettings());
    }
}
