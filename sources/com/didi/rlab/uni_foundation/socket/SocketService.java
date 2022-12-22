package com.didi.rlab.uni_foundation.socket;

public interface SocketService {
    boolean isReady();

    void sendMessage(long j, String str);

    void start();

    void stop();
}
