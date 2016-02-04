package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.graphics.Surface;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.ui.widget.Button;

public class SelectMode extends View {

    private Surface back;
    private Button backButton;
    private Button spinnerMode;
    private Surface spinnerModeSurface;
    private Button pianoMode;
    private Surface pianoModeSurface;
    private Button squareMode;
    private Surface squareModeSurface;

    public SelectMode() {
        super();
        squareModeSurface = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 3.0f, 0.025f);
        squareMode = new Button(new Text("kvadraty", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.04f),
                null, 0.1f, 0.5f, 0.15f, 0.15f, 0.0f, 0.0f, squareModeSurface);
        pianoModeSurface = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 3.0f, 0.025f);
        pianoMode = new Button(new Text("pianina", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.04f),
                null, 0.3f, 0.5f, 0.15f, 0.15f, 0.0f, 0.0f, pianoModeSurface);
        spinnerModeSurface = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 3.0f, 0.025f);
        spinnerMode = new Button(new Text("krutite baraban", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.04f),
                null, 0.6f, 0.5f, 0.15f, 0.15f, 0.0f, 0.0f, spinnerModeSurface);
        back = new Surface(Colors.WHITE.getColor(), Colors.WHITE.getColor(), 3.0f, 0.025f);
        backButton = new Button(new Text("Back", Fonts.ROBOTO_LIGHT.getFont(), Colors.BLACK.getColor(), 0.05f),
                null, -0.4f, 0.0f, 0.2f, 0.1f, 0.0f, 0.0f, back);

        addWidget(backButton);
        addWidget(squareMode);
        addWidget(pianoMode);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void onViewStarted() {
        super.onViewStarted();
        squareMode.setOnClickRunnable(() -> ViewManager.pushView(new SongMenu()));
        backButton.setOnClickRunnable(ViewManager::popView);
    }
}
