package io.github.ztkmkoo.dss.example.http.websocket;

import java.net.URI;
import java.util.concurrent.Future;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.client.WebSocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DssWebSocketClient {

    private static final Logger logger = LoggerFactory.getLogger(DssWebSocketClient.class);

    public static void main(String[] args) {
        URI uri = URI.create("ws://127.0.0.1:8181/websocket");

        WebSocketClient client = new WebSocketClient();
        try {
            try {
                client.start();
                DssWebSocket socket = new DssWebSocket();
                Future<Session> future = client.connect(socket, uri);
                Session session = future.get();
                session.getRemote().sendString("Hello, dss server!");
                session.close();
            } finally {
                client.stop();
            }
        } catch ( Throwable cause ) {
            logger.error("Exception occur", cause);
        }
    }
}
