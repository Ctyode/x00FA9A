package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.Beatmap;
import org.flamierawieo.x00FA9A.client.Colors;
import org.flamierawieo.x00FA9A.client.Fonts;
import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;

import static org.lwjgl.opengl.GL11.*;

public class SelectedBeatmap extends Widget {

    private Beatmap selectedBeatmap;
    private Text artistText;
    private Text titleText;
    private Text levelText;
    private Sprite selectedDifficulty;
    private Sprite availableDifficulty;
    private Sprite unavailableDifficulty;
    private int difficulty;
    private Runnable onClickRunnable;

    public SelectedBeatmap(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        artistText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        titleText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        levelText = new Text("", Fonts.ROBOTO_LIGHT.getFont(), Colors.GRAY.getColor(), 0.04f);
        selectedDifficulty = new Sprite(Images.SELECTED_DIFFICULTY.getTexture());
        availableDifficulty = new Sprite(Images.AVAILABLE_DIFFICULTY.getTexture());
        unavailableDifficulty = new Sprite(Images.UNAVAILABLE_DIFFICULTY.getTexture());
    }

    public SelectedBeatmap(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public Beatmap getSelectedBeatmap() {
        return selectedBeatmap;
    }

    public void setSelectedBeatmap(Beatmap beatmap) {
        selectedBeatmap = beatmap;
        artistText.setString(selectedBeatmap.getArtist());
        titleText.setString(selectedBeatmap.getTitle());
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        if(onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw() {
        if (selectedBeatmap != null) {
            byte availableDifficulties = selectedBeatmap.getAvailableDifficulties();
            if ((availableDifficulties & 0b00000001) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00000010) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00000100) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00001000) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00010000) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00100000) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b01000000) != 0) {
                availableDifficulty.draw(getAbsolutePositionX() + 0.5f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                if (difficulty == 0) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.5f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.5f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.5f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
        }
        artistText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.11458333f);
        titleText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.07291666f);
        levelText.draw(getAbsolutePositionX() + 0.0260416f, getAbsolutePositionY() + 0.0338541666f);
        glColor3f(1.0f, 0.0f, 0.0f);
        glLineWidth(1.0f);
        glBegin(GL_LINES);
        glVertex2f(getAbsolutePositionX(), getAbsolutePositionY());
        glVertex2f(getAbsolutePositionX() + getWidth(), getAbsolutePositionY());
        glEnd();
        glBegin(GL_LINES);
        glVertex2f(getAbsolutePositionX() + getWidth(), getAbsolutePositionY());
        glVertex2f(getAbsolutePositionX() + getWidth(), getAbsolutePositionY() + getHeight());
        glEnd();
        glBegin(GL_LINES);
        glVertex2f(getAbsolutePositionX(), getAbsolutePositionY() + getHeight());
        glVertex2f(getAbsolutePositionX() + getWidth(), getAbsolutePositionY() + getHeight());
        glEnd();
        glBegin(GL_LINES);
        glVertex2f(getAbsolutePositionX(), getAbsolutePositionY());
        glVertex2f(getAbsolutePositionX(), getAbsolutePositionY() + getHeight());
        glEnd();
    }

}
