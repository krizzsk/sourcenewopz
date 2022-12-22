package com.didi.dimina.container.debug;

import com.didi.dimina.container.DMMina;

public interface IWebSocketMsgSender {
    void close(int i, String str);

    void destroy();

    void doSend(String str);

    void handleMsg(DMMina dMMina, String str);

    void sendMsgToIDE(String str, String str2);

    boolean startConnect(DMMina dMMina, String str, OnWebSocketStatus onWebSocketStatus);
}
