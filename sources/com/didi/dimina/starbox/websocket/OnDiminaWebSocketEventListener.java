package com.didi.dimina.starbox.websocket;

public interface OnDiminaWebSocketEventListener {
    void onClose(int i, String str);

    void onClosing(int i, String str);

    void onError(String str);

    void onMessage(String str);

    void onOpen();
}
