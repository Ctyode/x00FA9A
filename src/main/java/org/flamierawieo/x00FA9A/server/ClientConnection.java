package org.flamierawieo.x00FA9A.server;

import org.flamierawieo.x00FA9A.server.net.AbstractConnection;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ClientConnection extends AbstractConnection {

    JSONParser jsonParser;
    RootDispatcher rootDispatcher;

    public ClientConnection(Socket s) throws IOException {
        super(s);
        jsonParser = new JSONParser();
        rootDispatcher = new RootDispatcher();
    }

    @Override
    protected void onMessage(String s) {
        try {
            List command = (List) jsonParser.parse(s);
        } catch(ParseException ignore) { /* whatever */ }
    }

}
