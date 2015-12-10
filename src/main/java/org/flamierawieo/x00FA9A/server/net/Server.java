package org.flamierawieo.x00FA9A.server.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread implements Runnable {

    public interface ConnectionFactory {

        public AbstractConnection newConnection(Socket s) throws IOException;

    }

    private ServerSocket serverSocket;
    private boolean closeRequired;
    private ConnectionFactory connectionFactory;

    public Server(ConnectionFactory f) throws IOException {
        serverSocket = new ServerSocket(64154);
        connectionFactory = f;
        closeRequired = false;
    }

    @Override
    public void run() {
        while(!closeRequired) {
            try {
                connectionFactory.newConnection(serverSocket.accept()).start();
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "", e);
            }
        }
    }

    public void close() {
        closeRequired = true;
    }

}
