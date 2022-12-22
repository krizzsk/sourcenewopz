package com.didichuxing.omega.sdk.prism;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.didi.sdk.payment.util.PaymentConstant;
import com.didichuxing.omega.sdk.ScreenShotUtil;
import com.didichuxing.omega.sdk.UIAutoMarker;
import com.didichuxing.omega.sdk.UIAutoTracker;
import com.didichuxing.omega.sdk.analysis.AnalysisActivityListener;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import com.didichuxing.omega.sdk.analysis.AnalysisPageListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.model.EventData;
import java.util.WeakHashMap;

public class OmegaPrismMonitorListener implements PrismMonitor.OnPrismMonitorListener {
    public void onEvent(EventData eventData) {
        if (eventData == null || !OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            return;
        }
        if (eventData.eventType == 3) {
            AnalysisActivityListener.reportOmgAppIn(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 2) {
            AnalysisActivityListener.reportOmgAppOut(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 6) {
            AnalysisActivityListener.reportOmgAppJump(eventData.activity);
        } else if (eventData.eventType == 10) {
            AnalysisActivityListener.reportOmgPageResume(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 11) {
            AnalysisActivityListener.reportOmgPagePause(eventData.activity, (EventData) null);
        } else if (eventData.eventType == 0) {
            reportOmgUi(eventData);
        } else if (eventData.eventType == 14) {
            reportH5OmgUi(eventData);
        }
    }

    public static void reportOmgUi(EventData eventData) {
        Activity activity;
        Event event = new Event("OMGUI");
        event.setFrom(OptionsBridge.UI_KEY);
        if (eventData.view != null) {
            activity = UIAutoTracker.scanForActivity(eventData.view.getContext());
        } else {
            activity = AnalysisActivityListener.getCurActivity();
        }
        if (activity != null) {
            event.putAllAttrs(UIAutoMarker.getPageAttrMap(activity));
            if (eventData.view != null) {
                event.putAllAttrs(UIAutoMarker.getViewAttrMap(eventData.view));
            }
            String str = "UNKNOWN";
            String simplifyClassName = activity != null ? CommonUtil.simplifyClassName(activity.getClass().getName()) : str;
            String currentFramentName = AnalysisFragmentListener.getCurrentFramentName();
            String currentPageName = AnalysisPageListener.getCurrentPageName();
            if (!TextUtils.isEmpty(currentPageName)) {
                event.putAttr("spn", currentPageName);
            }
            if (currentFramentName == null) {
                currentFramentName = simplifyClassName;
            }
            event.putAttr("rpn", simplifyClassName);
            event.putAttr("pn", currentFramentName);
            event.putAttr("at", 1);
            if (eventData.view != null) {
                event.putAttr("rt", CommonUtil.simplifyClassName(eventData.view.getClass().getName()));
            }
            if (eventData.view != null) {
                WeakHashMap<View, String> viewNameMap = UIAutoMarker.getViewNameMap(activity);
                String str2 = null;
                if (viewNameMap != null) {
                    str2 = viewNameMap.get(eventData.view);
                }
                if (str2 == null) {
                    String resourceName = UIAutoTracker.getResourceName(eventData.view);
                    if (resourceName != null) {
                        str = resourceName;
                    }
                } else {
                    str = str2;
                }
                event.putAttr("rn", str);
            }
            String str3 = eventData.f56114vr;
            if (!TextUtils.isEmpty(str3) && eventData.view != null) {
                Object tag = eventData.view.getTag();
                String name = eventData.view.getClass().getName();
                if ((tag != null && tag.toString().equals(PaymentConstant.TAG_SENSITIVE)) || ((name != null && name.contains("EditText") && !OmegaConfig.SWITCH_ATUO_EVENT_INPUT) || (eventData.view instanceof EditText))) {
                    str3 = CommonUtil.copyJoinStr("*", str3.length());
                }
                event.putAttr("text", str3);
            }
            event.setSessionId();
            setPrismAttr(event, eventData);
            String screenShot = ScreenShotUtil.getScreenShot(eventData.view, eventData.mDownX, eventData.mDownY);
            if (!TextUtils.isEmpty(screenShot)) {
                event.putAttr("prism-ck-img", screenShot);
            }
            Tracker.trackEvent(event);
        }
    }

    public static void setPrismAttr(Event event, EventData eventData) {
        if (event != null && eventData != null) {
            OmegaPrismCheck.prismCheck(eventData);
            if (!TextUtils.isEmpty(eventData.f56115w)) {
                event.putAttr("prism-w", eventData.f56115w);
            }
            if (!TextUtils.isEmpty(eventData.f56110vi)) {
                event.putAttr("prism-vi", eventData.f56110vi);
            }
            if (!TextUtils.isEmpty(eventData.f56114vr)) {
                event.putAttr("prism-vr", eventData.f56114vr);
            }
            if (!TextUtils.isEmpty(eventData.f56113vq)) {
                event.putAttr("prism-vq", eventData.f56113vq);
            }
            if (!TextUtils.isEmpty(eventData.f56111vl)) {
                event.putAttr("prism-vl", eventData.f56111vl);
            }
            if (!TextUtils.isEmpty(eventData.f56112vp)) {
                event.putAttr("prism-vp", eventData.f56112vp);
            }
            if (!TextUtils.isEmpty(eventData.f56109vf)) {
                event.putAttr("prism-vf", eventData.f56109vf);
            }
            if (!TextUtils.isEmpty(eventData.f56108h5)) {
                event.putAttr("prism-h5", eventData.f56108h5);
            }
            event.putAttr("fvd", Long.valueOf(eventData.fvd));
            event.putAttr("avd", Long.valueOf(eventData.avd));
        }
    }

    public static void reportH5OmgUi(EventData eventData) {
        if (OmegaConfig.DEBUG_MODEL) {
            Event event = new Event("OMGUI");
            event.setFrom(OptionsBridge.UI_KEY);
            if (!TextUtils.isEmpty(eventData.f56114vr)) {
                event.putAttr("prism-vr", eventData.f56114vr);
            }
            if (!TextUtils.isEmpty(eventData.f56108h5)) {
                event.putAttr("prism-h5", eventData.f56108h5);
            }
            event.setSessionId();
            String screenShot = ScreenShotUtil.getScreenShot(eventData.view, eventData.mDownX, eventData.mDownY);
            if (!TextUtils.isEmpty(screenShot)) {
                event.putAttr("prism-ck-img", screenShot);
            }
            Tracker.trackEvent(event);
        }
    }
}
