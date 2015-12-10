package org.flamierawieo.x00FA9A.server;

import org.flamierawieo.x00FA9A.server.net.Server;

import java.io.IOException;

public class X00FA9AServer extends Thread implements Runnable {

    Server server;

    public X00FA9AServer() throws IOException {
        server = new Server(ClientConnection::new);
    }

    @Override
    public void run() {
        server.run();
    }

}
