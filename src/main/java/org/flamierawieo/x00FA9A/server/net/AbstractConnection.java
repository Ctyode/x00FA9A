package org.flamierawieo.x00FA9A.server.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractConnection extends Thread implements Runnable {

    private final Logger logger;
    private Socket socket;
    private boolean closeRequired;
    private InputStream inputStream;
    private OutputStream outputStream;

    public AbstractConnection(Socket s) throws IOException {
        socket = s;
        logger = Logger.getLogger(getClass().getName());
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    @Override
    public void run() {
        int available;
        while(!closeRequired) {
            try {
                available = inputStream.available();
                if(available > 0) {
                    byte[] bytes = new byte[available];
                    int read = inputStream.read(bytes);
                    if(read != available) {
                        logger.log(Level.WARNING, "read != available");
                        logger.log(Level.OFF, "fuck off m8 no one cares");
                    }
                    onMessage(new String(bytes, "UTF-8"));
                }
            } catch(IOException e) {
                logger.log(Level.SEVERE, "", e);
            }
        }
    }

    protected void send(String s) {
        try {
            outputStream.write(s.getBytes("UTF-8"));
        } catch(IOException e) {
            logger.log(Level.WARNING, "", e);
        }
    }

    protected abstract void onMessage(String s);

    public void close() {
        closeRequired = true;
    }

}
