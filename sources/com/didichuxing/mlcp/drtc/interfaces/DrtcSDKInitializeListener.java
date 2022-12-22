package com.didichuxing.mlcp.drtc.interfaces;

public interface DrtcSDKInitializeListener extends C15889c {
    void onSDKInitializeResult(int i);

    void onSDKLogMessage(String str);

    void onSDKReleased();
}
