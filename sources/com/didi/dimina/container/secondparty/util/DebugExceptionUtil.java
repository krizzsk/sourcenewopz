package com.didi.dimina.container.secondparty.util;

import android.util.Log;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.bundle.bean.DMConfigBean;
import com.didi.dimina.container.util.CollectionsUtil;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DebugExceptionUtil {
    public static final String TAG = "Dimina-PM DebugExceptionUtil";

    /* renamed from: a */
    private static final Map<String, Long> f17483a = new HashMap();

    public static void throwRuntimeExceptionIfDebug(Exception exc) {
        LogUtil.eRelease(TAG, "运行时抛出异常 -> " + Log.getStackTraceString(exc));
        LogUtil.eRelease(TAG, Log.getStackTraceString(exc));
        if (Dimina.getConfig() != null) {
            Dimina.getConfig().isDebug();
        }
    }

    public static void throwRuntimeExceptionIfDebug(String str) {
        throwRuntimeExceptionIfDebug(new Exception(str));
    }

    public static void log(String str, String str2, List<?> list) {
        LogUtil.iRelease("", str + "\t size=" + CollectionsUtil.getSize((Collection) list));
        if (CollectionsUtil.isEmpty((Collection) list)) {
            LogUtil.iRelease(str2, "list 为null 或者 size=0");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            LogUtil.iRelease(str2, "第" + i + "个 ->" + list.get(i));
        }
    }

    public static void log(String str, String str2, DMConfigBean dMConfigBean) {
        LogUtil.iRelease(str + "\t" + str2, "dmConfigBean主信息=" + dMConfigBean);
    }

    public static void dottingPmTime(String str, String str2) {
        if (f17483a.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            Long put = f17483a.put(str, Long.valueOf(currentTimeMillis));
            if (put != null) {
                LogUtil.iRelease("计时", " | " + (currentTimeMillis - put.longValue()) + " | " + str2 + " | tag:" + str);
                return;
            }
            return;
        }
        f17483a.put(str, Long.valueOf(System.currentTimeMillis()));
        LogUtil.iRelease("计时 -> 开始", str2 + " | tag:" + str);
    }
}
