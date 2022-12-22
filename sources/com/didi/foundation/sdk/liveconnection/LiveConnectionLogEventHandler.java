package com.didi.foundation.sdk.liveconnection;

import com.didi.sdk.push.BaseLogEventHandler;
import com.didi.sdk.push.log.AvailableRateLogEvent;
import com.didi.sdk.push.log.LoadErrorEvent;
import com.didi.sdk.push.log.LogEventListener;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.NetworkChangeEvent;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider({LogEventListener.class})
public class LiveConnectionLogEventHandler extends BaseLogEventHandler {
    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
        super.onPushNativeLog(nativeLogEvent);
        if (nativeLogEvent != null) {
            m15593a(nativeLogEvent.getMsg());
        }
    }

    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
        Map<String, Object> map;
        super.onNetworkChange(networkChangeEvent);
        if (networkChangeEvent != null && (map = networkChangeEvent.toMap()) != null) {
            m15593a(m15592a(map));
        }
    }

    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
        Map<String, Object> map;
        super.onPushLoadError(loadErrorEvent);
        if (loadErrorEvent != null && (map = loadErrorEvent.toMap()) != null) {
            m15593a(m15592a(map));
        }
    }

    public void onTrackAvailableRateEvent(AvailableRateLogEvent availableRateLogEvent) {
        Map<String, Object> map;
        super.onTrackAvailableRateEvent(availableRateLogEvent);
        if (availableRateLogEvent != null && (map = availableRateLogEvent.toMap()) != null) {
            m15593a(m15592a(map));
        }
    }

    /* renamed from: a */
    private String m15592a(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : map.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append(":");
            stringBuffer.append(next.getValue());
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m15593a(String str) {
        LogListener logListener = LiveConnectionService.getInstance().getLogListener();
        if (logListener != null) {
            logListener.onLog(str);
        }
    }
}
