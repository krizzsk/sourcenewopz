package com.didi.dimina.container.v8util;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.dimina.container.util.LogUtil;
import java.text.DecimalFormat;
import java.util.HashMap;

public class V8TrackUtil {
    public static String MINA_INDEX_KEY = "minaIndex";
    static DecimalFormat decimalFormat = new DecimalFormat("#.00");

    public static void trackCompileTimeUseCache(HashMap<String, Object> hashMap, double d) {
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, decimalFormat.format(d));
        LogUtil.iRelease("V8Dimina", " [Compile_UseCache] " + hashMap.toString());
    }

    public static void trackCompileTimeNotUseCache(HashMap<String, Object> hashMap, double d) {
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, decimalFormat.format(d));
        LogUtil.iRelease("V8Dimina", " [Compile_NotUseCache] " + hashMap.toString());
    }

    public static void trackRunTimeUseCache(HashMap<String, Object> hashMap, double d) {
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, decimalFormat.format(d));
        LogUtil.iRelease("V8Dimina", " [RunTime_UseCache] " + hashMap.toString());
    }

    public static void trackRunTimeNotUseCache(HashMap<String, Object> hashMap, double d) {
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.TIME_INTERVAL, decimalFormat.format(d));
        LogUtil.iRelease("V8Dimina", " [RunTime_NotUseCache] " + hashMap.toString());
    }
}
