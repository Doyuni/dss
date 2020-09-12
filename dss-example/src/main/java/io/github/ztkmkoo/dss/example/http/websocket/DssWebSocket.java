package io.github.ztkmkoo.dss.example.http.websocket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DssWebSocket extends WebSocketAdapter {

    private final Logger logger = LoggerFactory.getLogger(DssWebSocket.class);

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        logger.info("Socket Connected: " + session);
    }

    @Override
    public void onWebSocketText(String message) {
        super.onWebSocketText(message);
        logger.info("Received Text message: " + message);
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        super.onWebSocketClose(statusCode, reason);
        logger.info("Socket Closed: [" + statusCode + "] " + reason);
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        super.onWebSocketError(cause);
        logger.error("Websocket error", cause);
    }
}
