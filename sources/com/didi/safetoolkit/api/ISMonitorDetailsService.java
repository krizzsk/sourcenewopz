package com.didi.safetoolkit.api;

import android.content.Context;
import com.didi.safetoolkit.business.monitor.ISMonitorCallback;
import com.didi.safetoolkit.business.monitor.ISMonitorConfigCallback;

public interface ISMonitorDetailsService {
    public static final int EMEGENCY_ASSISTANCE = 9;
    public static final int EMEGENCY_CALL = 12;
    public static final int REAL_TIME_MONITOR = 1;
    public static final int REAL_TIME_MONITOR_OK = 1;
    public static final int REAL_TIME_MONITOR_TO_SAFETY = 2;
    public static final int RECORD_AUDIO = 5;
    public static final int SAFETY_CENTER = 10;
    public static final int SHARE_TRIP = 3;

    void refreshBubbleInfo(ISMonitorConfigCallback iSMonitorConfigCallback);

    void reportMonitorEvent(Context context, int i);

    void reportMonitorState(Context context, int i, int i2, ISMonitorCallback iSMonitorCallback);
}
