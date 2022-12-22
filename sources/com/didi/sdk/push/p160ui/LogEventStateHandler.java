package com.didi.sdk.push.p160ui;

import com.didi.sdk.push.log.ConnEvent;
import com.didi.sdk.push.log.LoadErrorEvent;
import com.didi.sdk.push.log.LogEventAdapter;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.log.RequestEvent;
import com.didi.sdk.push.log.TransactionEvent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.ArrayList;
import java.util.Iterator;

@ServiceProvider({LogEventListener.class})
/* renamed from: com.didi.sdk.push.ui.LogEventStateHandler */
public class LogEventStateHandler extends LogEventAdapter {
    private static final ArrayList<LogEventListener> mListeners = new ArrayList<>();

    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onPushLoadError(loadErrorEvent);
        }
    }

    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkChange(networkChangeEvent);
        }
    }

    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onPushNativeLog(nativeLogEvent);
        }
    }

    public void onPushRequest(RequestEvent requestEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onPushRequest(requestEvent);
        }
    }

    public void onTrackTransaction(TransactionEvent transactionEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onTrackTransaction(transactionEvent);
        }
    }

    public void onTrackConnection(ConnEvent connEvent) {
        Iterator<LogEventListener> it = mListeners.iterator();
        while (it.hasNext()) {
            it.next().onTrackConnection(connEvent);
        }
    }

    static void addListener(LogEventListener logEventListener) {
        synchronized (mListeners) {
            mListeners.add(logEventListener);
        }
    }

    static void removeListener(LogEventListener logEventListener) {
        synchronized (mListeners) {
            mListeners.remove(logEventListener);
        }
    }
}
