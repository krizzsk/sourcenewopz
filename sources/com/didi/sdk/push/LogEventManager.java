package com.didi.sdk.push;

import com.didi.sdk.push.log.AvailableRateLogEvent;
import com.didi.sdk.push.log.ConnEvent;
import com.didi.sdk.push.log.ConnEventV2;
import com.didi.sdk.push.log.LoadErrorEvent;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.MsgAckLogEvent;
import com.didi.sdk.push.log.MsgFluxLogEvent;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didi.sdk.push.log.PushQualityLogEvent;
import com.didi.sdk.push.log.RequestEvent;
import com.didi.sdk.push.log.TransactionEvent;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LogEventManager {
    private List<LogEventListener> listeners;

    private LogEventManager() {
        this.listeners = new ArrayList();
        Iterator<S> it = ServiceLoader.load(LogEventListener.class).iterator();
        while (it.hasNext()) {
            LogEventListener logEventListener = (LogEventListener) it.next();
            if (logEventListener != null) {
                this.listeners.add(logEventListener);
            }
        }
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static LogEventManager INSTANCE = new LogEventManager();

        private SingletonHolder() {
        }
    }

    public static LogEventManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
        for (LogEventListener onPushLoadError : this.listeners) {
            onPushLoadError.onPushLoadError(loadErrorEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
        for (LogEventListener onNetworkChange : this.listeners) {
            onNetworkChange.onNetworkChange(networkChangeEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
        for (LogEventListener onPushNativeLog : this.listeners) {
            onPushNativeLog.onPushNativeLog(nativeLogEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onPushRequest(RequestEvent requestEvent) {
        for (LogEventListener onPushRequest : this.listeners) {
            onPushRequest.onPushRequest(requestEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackTransaction(TransactionEvent transactionEvent) {
        for (LogEventListener onTrackTransaction : this.listeners) {
            onTrackTransaction.onTrackTransaction(transactionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackConnection(ConnEvent connEvent) {
        for (LogEventListener onTrackConnection : this.listeners) {
            onTrackConnection.onTrackConnection(connEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackConnectionV2(ConnEventV2 connEventV2) {
        for (LogEventListener onTrackConnectionV2 : this.listeners) {
            onTrackConnectionV2.onTrackConnectionV2(connEventV2);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackAvailableRate(AvailableRateLogEvent availableRateLogEvent) {
        for (LogEventListener onTrackAvailableRateEvent : this.listeners) {
            onTrackAvailableRateEvent.onTrackAvailableRateEvent(availableRateLogEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackMsgAckEvent(MsgAckLogEvent msgAckLogEvent) {
        for (LogEventListener onTrackMsgAckEvent : this.listeners) {
            onTrackMsgAckEvent.onTrackMsgAckEvent(msgAckLogEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackMsgFluxEvent(MsgFluxLogEvent msgFluxLogEvent) {
        for (LogEventListener onTrackMsgFluxEvent : this.listeners) {
            onTrackMsgFluxEvent.onTrackMsgFluxEvent(msgFluxLogEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void onTrackPushQualityEvent(PushQualityLogEvent pushQualityLogEvent) {
        for (LogEventListener onTrackPushQualityEvent : this.listeners) {
            onTrackPushQualityEvent.onTrackPushQualityEvent(pushQualityLogEvent);
        }
    }
}
