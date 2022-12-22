package com.didichuxing.mlcp.drtc.interfaces;

public interface CallingServiceListener extends C15889c {

    /* renamed from: com.didichuxing.mlcp.drtc.interfaces.CallingServiceListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onNetworkQuality(CallingServiceListener callingServiceListener, int i) {
        }

        public static void $default$onNewRemoteFeedWithCount(CallingServiceListener callingServiceListener, String str, int i) {
        }

        public static void $default$onRemoteFeedLeaveWithCount(CallingServiceListener callingServiceListener, String str, int i) {
        }
    }

    void onCameraNoPermission();

    void onConnectReady(boolean z, int i);

    void onDisconnectedByError();

    void onJoinFailed(String str);

    void onNetworkQuality(int i);

    void onNewRemoteFeed(String str);

    void onNewRemoteFeedWithCount(String str, int i);

    void onRemoteFeedLeave(String str);

    void onRemoteFeedLeaveWithCount(String str, int i);

    void onSessionDestroy();
}
