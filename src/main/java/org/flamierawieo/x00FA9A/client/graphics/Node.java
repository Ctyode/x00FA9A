package org.flamierawieo.x00FA9A.client.graphics;

import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class Node implements Drawable {

    private Node parentNode;
    private List<Node> childNodes;
    private Drawable drawable;

    public Node(Node parentNode, Drawable drawable) {
        this.parentNode = parentNode;
        this.drawable = drawable;
        childNodes = new ArrayList<>();
        this.parentNode.appendChild(this);
    }

    @Override
    public void draw(Graphics g) {
        drawable.draw(g);
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

}
