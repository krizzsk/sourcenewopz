package com.didi.sdk.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didichuxing.security.safecollector.WsgSecInfo;

class NetworkChangeHandler {
    private static volatile NetworkChangeHandler INSTANCE = null;
    private static final String TAG = "push-debug";
    private static String lastNetworkIdentity = "UNKNOWN";
    private boolean isFirstCallback;

    NetworkChangeHandler() {
    }

    public static NetworkChangeHandler getDefault() {
        if (INSTANCE == null) {
            synchronized (NetworkChangeHandler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NetworkChangeHandler();
                }
            }
        }
        return INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void init(Context context) {
        lastNetworkIdentity = WsgSecInfo.networkType(context);
        registerNetChange(context);
    }

    private void registerNetChange(final Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                this.isFirstCallback = true;
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkRequest.Builder builder = new NetworkRequest.Builder();
                    builder.addCapability(13);
                    connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() {
                        public void onAvailable(Network network) {
                            super.onAvailable(network);
                            NetworkChangeHandler.this.onAvailable(context);
                        }

                        public void onLost(Network network) {
                            super.onLost(network);
                            NetworkChangeHandler.this.onLost(context);
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void onAvailable(Context context) {
        int i = 0;
        if (this.isFirstCallback) {
            this.isFirstCallback = false;
            return;
        }
        String networkType = WsgSecInfo.networkType(context);
        if (networkType != null) {
            i = networkIdMapPushEvent(networkType);
        }
        onStatistic(lastNetworkIdentity, networkType);
        lastNetworkIdentity = networkType;
        if (PushSelector.getDefault().supportJNIv2()) {
            PushClient.getClient().onAppEvent(1, i);
        } else {
            PushClient.getClient().startPushInternal();
        }
    }

    /* access modifiers changed from: package-private */
    public void onLost(Context context) {
        if (this.isFirstCallback) {
            this.isFirstCallback = false;
            return;
        }
        onStatistic(lastNetworkIdentity, "UNKNOWN");
        lastNetworkIdentity = "UNKNOWN";
        PushClient.getClient().onAppEvent(1, 0);
    }

    private void onStatistic(String str, String str2) {
        PushLog.m26280d("push-debug", String.format("网络切换，old => %s,new => %s", new Object[]{str, str2}));
        NetworkChangeEvent networkChangeEvent = new NetworkChangeEvent();
        networkChangeEvent.setLastNetwork(str);
        networkChangeEvent.setCurrentNetwork(str2);
        LogEventManager.getInstance().onNetworkChange(networkChangeEvent);
    }

    private static int networkIdMapPushEvent(String str) {
        if (str.contains("WIFI")) {
            return 2;
        }
        return (str.contains("2G") || str.contains("3G") || str.contains("4G") || str.contains("5G")) ? 1 : 0;
    }
}
