package com.didi.travel.psnger.core.poll;

public interface IPollCallbackProtocol {
    void onNotifyUpdateUI(int i);

    void onPollStop();

    void onPollTimeout();

    void onSendRequest(int i);
}
