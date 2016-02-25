package org.flamierawieo.x00FA9A.client.ui.widget;

import org.flamierawieo.x00FA9A.client.ui.Widget;
import java.util.ArrayList;

public class List extends Widget {

    private java.util.List<ListItem> itemList;
    private float scroll;

    public List(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);
        itemList = new ArrayList<>();
    }

    public List(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    public java.util.List<ListItem> getItemList() {
        return itemList;
    }

    @Override
    public void onMouseButtonDown(float x, float y, int button, int mods) {
        float relativeCursorPositionY = y - getAbsolutePositionY();
        float offset = scroll;
        float itemHeight;
        for(ListItem item : itemList) {
            itemHeight = item.getHeight();
            if(offset > -itemHeight && offset < getHeight() && relativeCursorPositionY > offset && relativeCursorPositionY < offset + itemHeight) {
                item.onChosen();
            }
            offset += itemHeight;
        }
    }

    @Override
    public void onScroll(float x, float y, double scrollX, double scrollY) {
        scroll -= scrollY * 0.1;
    }

    @Override
    public void draw() {
        float offset = scroll;
        float itemHeight;
        for(ListItem item : itemList) {
            itemHeight = item.getHeight();
            if(offset > -itemHeight && offset < getHeight()) {
                item.draw(getAbsolutePositionX(), getAbsolutePositionY() + offset);
            }
            offset += itemHeight;
        }
    }

}
