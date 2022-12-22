package com.didichuxing.ditest.agent.android.socketanalysis;

import android.content.Context;
import com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketDiskCache;
import com.didichuxing.ditest.agent.android.socketanalysis.cache.SocketMemCache;
import com.didichuxing.ditest.agent.android.socketanalysis.config.SocketConfig;
import com.didichuxing.ditest.agent.android.socketanalysis.config.StatusConfig;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeListener;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import java.util.Timer;
import java.util.TimerTask;

public class SocketEventAnalysis {
    private static SocketEventAnalysis instance;

    private SocketEventAnalysis() {
    }

    public static synchronized SocketEventAnalysis getInstance() {
        SocketEventAnalysis socketEventAnalysis;
        synchronized (SocketEventAnalysis.class) {
            if (instance == null) {
                instance = new SocketEventAnalysis();
            }
            socketEventAnalysis = instance;
        }
        return socketEventAnalysis;
    }

    public void start(Context context) {
        StatusConfig.setSaveState(context);
        SocketDiskCache.getSocketDiskCacheInstance().start(context);
        new Timer(true).schedule(new TimerTask() {
            public void run() {
                Thread.currentThread().setName("OmegaSDK.SocketUpload");
                Thread.currentThread().setPriority(1);
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }
        }, SocketConfig.UPLOAD_INTERVAL, SocketConfig.UPLOAD_INTERVAL);
        registerAppStateCallback();
    }

    private void registerAppStateCallback() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }

            public void onInBackground() {
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }
        });
        ScreenChangeReceiver.addScreenChangeListener(new ScreenChangeListener() {
            public void screenOn() {
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }

            public void screenOff() {
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }
        });
    }
}
