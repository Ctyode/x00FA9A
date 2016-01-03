package org.flamierawieo.x00FA9A.client.ui.widget;

public interface ListItem {

    float getHeight();
    default void onChosen() {}
    void draw(float x, float y);

}
