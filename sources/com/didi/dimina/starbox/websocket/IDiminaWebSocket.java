package com.didi.dimina.starbox.websocket;

public interface IDiminaWebSocket {
    void close(int i, String str);

    void connect(String str, OnDiminaWebSocketEventListener onDiminaWebSocketEventListener);

    void destroy();

    void send(String str);
}
