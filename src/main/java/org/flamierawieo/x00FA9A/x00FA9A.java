package org.flamierawieo.x00FA9A;

import org.flamierawieo.x00FA9A.client.Options;
import org.flamierawieo.x00FA9A.client.x00FA9AClient;
import org.newdawn.slick.*;

public class x00FA9A {

    public static final int VIEW_STARTMENU = 1;
    public static final int VIEW_GAME = 4;

    public x00FA9A () {
    }

    public static void main(String[] args) {

        x00FA9AClient client = x00FA9AClient.getInstance();
        try {
            AppGameContainer app = new AppGameContainer(client);

            // int[] containerSize = Options.getContainerSize();
            app.setDisplayMode(800, 600, false);

            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }

    }

}

