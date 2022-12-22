package com.didi.security.wireless;

public interface ISecurityDispatcher {
    @Deprecated
    String getPhone();

    @Deprecated
    String getTicket();

    String getUid();

    void onInit(int i);
}
