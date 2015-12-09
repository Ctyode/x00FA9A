package org.flamierawieo.x00FA9A.server;

import org.flamierawieo.x00FA9A.server.net.AbstractConnection;
import org.flamierawieo.x00FA9A.server.net.Server;

import java.io.IOException;

public class X00FA9AServer extends Thread implements Runnable {

    Server server;

    public X00FA9AServer() throws IOException {
        server = new Server(AbstractConnection.class);
    }

    @Override
    public void run() {

    }

}
