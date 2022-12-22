package com.didichuxing.omega.sdk.analysis;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.UIAutoMarker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;

public class AnalysisFragmentListener {
    public static volatile String mFragmentName;
    private static long pageDurationResume;

    public static String getCurrentFramentName() {
        return mFragmentName;
    }

    public static void whenFragmentResumed(Object obj) {
        String name = obj.getClass().getName();
        mFragmentName = name;
        AnalysisDelegater.setFragmentName(mFragmentName);
        pageDurationResume = System.currentTimeMillis();
        Event event = new Event("OMGPageResume");
        event.putAttr("ub", OmegaConfig.isUnwind ? "un" : "br");
        event.putAllAttrs(UIAutoMarker.getPageAttrMap(AnalysisActivityListener.getCurActivity()));
        String encryptBlackItem = OmegaConfig.encryptBlackItem(name);
        if (!TextUtils.isEmpty(encryptBlackItem)) {
            event.putAttr("pn", encryptBlackItem);
        }
        if (OmegaConfig.EX_SWITCH_BATTERY_MONITOR) {
            event.putBatteryInfo();
        }
        Security.putPageResumeInfo(event);
        Tracker.trackEvent(event);
    }

    public static void whenFragmentPaused(Object obj) {
        String name = obj.getClass().getName();
        Event event = new Event("OMGPagePause");
        event.putAllAttrs(UIAutoMarker.getPageAttrMap(AnalysisActivityListener.getCurActivity()));
        String encryptBlackItem = OmegaConfig.encryptBlackItem(name);
        if (!TextUtils.isEmpty(encryptBlackItem)) {
            event.putAttr("pn", encryptBlackItem);
        }
        long currentTimeMillis = System.currentTimeMillis() - pageDurationResume;
        if (currentTimeMillis > 7200000 || currentTimeMillis < 0) {
            currentTimeMillis = 0;
        }
        event.putAttr("pd", Long.valueOf(currentTimeMillis));
        Tracker.trackEvent(event);
    }
}
