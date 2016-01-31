package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;
import org.flamierawieo.x00FA9A.client.views.gamemods.SquareMode;

import java.awt.*;

public class StatsView extends View {

    private Button backButton;
    private Surface back;
    private Text scoreText;
    private int score;
    private int combo;
    private Text comboText;

    public StatsView(SquareMode sm) {
        super();
        score = sm.getFinalScore();
        combo = sm.getFinalCombo();
        comboText = new Text(Integer.toString(combo), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        scoreText = new Text(Integer.toString(score), Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.1f);
        back = new Surface(Colors.WHITE.getColor(), new Color(1.0f, 1.0f, 1.0f, 0.0f), 1.0f, 0.025f);
        backButton = new Button(new Text("Back", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.05f),
                null, -0.1f, 0.1f, 0.2f, 0.1f, 0.0f, 0.0f, back);

        addWidget(backButton);
    }

    @Override
    public void draw() {
        super.draw();
        scoreText.draw(0.5f, 0.1f);
        comboText.draw(0.8f, 0.1f);
    }

    @Override
    public void onViewStarted() {
        backButton.setOnClickRunnable(() -> ViewManager.popView());
    }
}
