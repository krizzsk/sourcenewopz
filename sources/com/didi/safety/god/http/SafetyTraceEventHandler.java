package com.didi.safety.god.http;

import android.content.Context;
import com.didi.safety.god.manager.GodManager;
import java.util.Map;

public class SafetyTraceEventHandler {
    public static void trace(Map<String, Object> map, Context context) {
        trace(map);
    }

    public static void trace(Map<String, Object> map) {
        GodManager.getInstance().log(map);
    }
}
