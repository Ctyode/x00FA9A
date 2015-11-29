package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.shared.Tickable;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class Node implements Drawable, Tickable {

    private float originX;
    private float originY;
    private float relativePositionX;
    private float relativePositionY;
    private Node parentNode;
    private List<Node> childNodes;

    public Node(Node parentNode, float x, float y, float originX, float originY) {
        relativePositionX = x;
        relativePositionY = y;
        this.originX = originX;
        this.originY = originY;
        this.parentNode = parentNode;
        childNodes = new ArrayList<>();
        if(parentNode != null) {
            this.parentNode.appendChild(this);
        }
    }

    public Node(float x, float y) {
        this(null, x, y, 0, 0);
    }

    public Node(float x, float y, float originX, float originY) {
        this(null, x, y, originX, originY);
    }

    @Override
    public void draw(Graphics g) {
        childNodes.forEach((n) -> n.draw(g));
    }

    public void reparentTo(Node newParent) {
        if(parentNode != null) {
            parentNode.removeChild(this);
        }
        parentNode = newParent;
        parentNode.appendChild(this);
    }

    public void appendChild(Node newChild) {
        childNodes.add(newChild);
    }

    public void removeChild(Node child) {
        childNodes.remove(child);
    }

    public List<Node> getChildNodes() {
        return childNodes;
    }

    @Override
    public void tick(double delta) {

    }

}
