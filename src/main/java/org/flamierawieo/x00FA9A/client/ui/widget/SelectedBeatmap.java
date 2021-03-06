package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.*;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.flamierawieo.x00FA9A.client.graphics.Text;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.json.simple.parser.ParseException;
import org.flamierawieo.x00FA9A.client.Beatmap;

import java.io.IOException;

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
        difficulty = 0;
        selectedBeatmap = beatmap;
        artistText.setString(selectedBeatmap.getArtist());
        titleText.setString(selectedBeatmap.getTitle());
    }

    public void setOnClickRunnable(Runnable onClickRunnable) {
        this.onClickRunnable = onClickRunnable;
    }

    @Override
    public void onMouseButtonDown(float x, float y, int button, int mods) {
        byte availableDifficulties = selectedBeatmap.getAvailableDifficulties();
        float relativeMousePositionX = getAbsolutePositionX() - x;
        float relativeMousePositionY = getAbsolutePositionY() - y;
        if (relativeMousePositionX > getAbsolutePositionX() + 0.26f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.26f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00000001) != 0) {
                difficulty = 1;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.3f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.3f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00000010) != 0) {
                difficulty = 2;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.34f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.34f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00000100) != 0) {
                difficulty = 3;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.38f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.38f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00001000) != 0) {
                difficulty = 4;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.42f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.42f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00010000) != 0) {
                difficulty = 5;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.46f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.46f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b00100000) != 0) {
                difficulty = 6;
            }
        } else if (relativeMousePositionX > getAbsolutePositionX() + 0.5f
                && relativeMousePositionY > getAbsolutePositionY() + 0.12f
                && relativeMousePositionX < getAbsolutePositionX() + 0.5f + 0.030924479166f
                && relativeMousePositionY < getAbsolutePositionY() + 0.12f + 0.030598958333f) {
            if ((availableDifficulties & 0b01000000) != 0) {
                difficulty = 7;
            }
        } else if (onClickRunnable != null) {
            onClickRunnable.run();
        }
    }

    @Override
    public void draw() {
        if (selectedBeatmap != null) {
            byte availableDifficulties = selectedBeatmap.getAvailableDifficulties();
            if ((availableDifficulties & 0b00000001) != 0) {
                if (difficulty == 1) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.26f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00000010) != 0) {
                if (difficulty == 2) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.3f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00000100) != 0) {
                if (difficulty == 3) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.34f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00001000) != 0) {
                if (difficulty == 4) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.38f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00010000) != 0) {
                if (difficulty == 5) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.42f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b00100000) != 0) {
                if (difficulty == 6) {
                    selectedDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                } else {
                    availableDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
                }
            } else {
                unavailableDifficulty.draw(getAbsolutePositionX() + 0.46f, getAbsolutePositionY() + 0.12f, 0.030924479166f, 0.030598958333f);
            }
            if ((availableDifficulties & 0b01000000) != 0) {
                if (difficulty == 7) {
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
    }
}
