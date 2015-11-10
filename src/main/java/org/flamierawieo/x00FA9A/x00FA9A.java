package org.flamierawieo.x00FA9A;

import org.flamierawieo.x00FA9A.client.x00FA9AClient;
import org.newdawn.slick.*;

public class x00FA9A {

    public static void main(String[] args) {
        x00FA9AClient client = x00FA9AClient.getInstance();
        try {
            AppGameContainer app = new AppGameContainer(client);
            app.setDisplayMode(800, 600, false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}

