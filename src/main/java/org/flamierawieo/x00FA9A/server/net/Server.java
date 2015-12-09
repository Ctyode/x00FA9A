package org.flamierawieo.x00FA9A.server.net;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread implements Runnable {

    private ServerSocket serverSocket;
    private boolean closeRequired;
    private Class<? extends AbstractConnection> abstractConnectionClass;

    public Server(Class<? extends AbstractConnection> c) throws IOException {
        serverSocket = new ServerSocket(64154);
        if(c.equals(AbstractConnection.class)) {
            throw new IllegalStateException("u've got to be kiddin' me m8");
        }
        abstractConnectionClass = c;
        closeRequired = false;
    }

    @Override
    public void run() {
        while(!closeRequired) {
            try {
                abstractConnectionClass.getConstructor(Socket.class).newInstance(serverSocket.accept()).start();
            } catch (IOException e) {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "", e);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "", e);
            }
        }
    }

    public void close() {
        closeRequired = true;
    }

}
