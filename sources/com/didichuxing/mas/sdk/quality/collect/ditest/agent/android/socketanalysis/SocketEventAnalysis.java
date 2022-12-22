package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.cache.SocketDiskCache;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.cache.SocketMemCache;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config.SocketConfig;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config.StatusConfig;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeListener;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;
import java.util.Timer;
import java.util.TimerTask;

public class SocketEventAnalysis {

    /* renamed from: a */
    private static SocketEventAnalysis f48033a;

    private SocketEventAnalysis() {
    }

    public static synchronized SocketEventAnalysis getInstance() {
        SocketEventAnalysis socketEventAnalysis;
        synchronized (SocketEventAnalysis.class) {
            if (f48033a == null) {
                f48033a = new SocketEventAnalysis();
            }
            socketEventAnalysis = f48033a;
        }
        return socketEventAnalysis;
    }

    public void start(Context context) {
        StatusConfig.setSaveState(context);
        SocketDiskCache.getSocketDiskCacheInstance().start(context);
        new Timer(true).schedule(new TimerTask() {
            public void run() {
                Thread.currentThread().setName("MASSDK.SocketUpload");
                Thread.currentThread().setPriority(1);
                SocketMemCache.getMemCacheInstance().uploadEventImmediatelyByMemoryCache();
            }
        }, SocketConfig.UPLOAD_INTERVAL, SocketConfig.UPLOAD_INTERVAL);
        m34269a();
    }

    /* renamed from: a */
    private void m34269a() {
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
