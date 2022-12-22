package com.didichuxing.omega.sdk;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.alpha.crash.CrashCallbacks;
import com.didichuxing.omega.sdk.analysis.AnalysisAppListener;
import com.didichuxing.omega.sdk.analysis.AnalysisFragmentListener;
import com.didichuxing.omega.sdk.analysis.AnalysisPageListener;
import com.didichuxing.omega.sdk.analysis.OmegaJS;
import com.didichuxing.omega.sdk.analysis.OmegaWebChromeClient;
import com.didichuxing.omega.sdk.analysis.OmegaWebViewClient;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.analysis.TrackListener;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaCallback;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.OmegaSetting;
import com.didichuxing.omega.sdk.common.backend.ActivityLifecycleRegister;
import com.didichuxing.omega.sdk.common.backend.BackendThread;
import com.didichuxing.omega.sdk.common.backend.HourlyTimeTask;
import com.didichuxing.omega.sdk.common.backend.ScreenChangeReceiver;
import com.didichuxing.omega.sdk.common.collector.AllCollectorsFacade;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.FragmentCollector;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.perforence.ServiceConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.common.utils.OaidStrategy;
import com.didichuxing.omega.sdk.corelink.LinkManager;
import com.didichuxing.omega.sdk.init.BuildConfig;
import com.didichuxing.omega.sdk.prism.OmegaPrismMonitorListener;
import com.xiaojuchefu.prism.monitor.PrismMonitor;
import com.xiaojuchefu.prism.monitor.touch.WebviewEventHelper;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Omega {
    private static final AtomicBoolean init = new AtomicBoolean(false);

    public static void registerCrashCallbacks(CrashCallbacks crashCallbacks) {
    }

    public static void setHotpatchVersion(long j) {
    }

    public static void testNativeCrash() {
    }

    public static void unregisterCrashCallbacks(CrashCallbacks crashCallbacks) {
    }

    public static String getSdkVersion() {
        return OmegaConfig.SDK_VERSION;
    }

    public static void init(Context context) {
        if (context == null) {
            SystemUtils.log(6, "omegasdk", "SDK.init context is null.", (Throwable) null, "com.didichuxing.omega.sdk.Omega", 86);
            return;
        }
        if (!init.compareAndSet(false, true)) {
            SystemUtils.log(5, "omegasdk", "SDK.init called more than once.", (Throwable) null, "com.didichuxing.omega.sdk.Omega", 91);
            return;
        }
        long nanoTime = System.nanoTime();
        OmegaConfig.SDK_VERSION = BuildConfig.VERSION_NAME;
        SystemUtils.log(4, "omegasdk", "SDK.init v" + OmegaConfig.SDK_VERSION, (Throwable) null, "com.didichuxing.omega.sdk.Omega", 97);
        OmegaConfig.APP_ISSUE = CommonUtil.getManifestIssue(context);
        if (TextUtils.isEmpty(OmegaConfig.CUSTOM_APP_VERSION)) {
            OmegaConfig.CUSTOM_APP_VERSION = OmegaConfig.APP_ISSUE;
        }
        OLog.init(context);
        RuntimeCheck.Init(context.getApplicationContext());
        ServiceConfig.getInstanse().Init(context.getApplicationContext());
        CommonUtil.init(context);
        AllCollectorsFacade.initAll(context);
        if (TextUtils.isEmpty(OmegaConfig.CUSTOM_APP_NAME)) {
            setAppName(PackageCollector.getPkgName());
        }
        if (RuntimeCheck.IsMainProcess()) {
            OaidStrategy.init();
        }
        ActivityLifecycleRegister.init((Application) context.getApplicationContext());
        ScreenChangeReceiver.init(context);
        RecordStorage.init(context);
        if (OmegaConfig.SWITCH_OMEGA_ENENT_TRACK_PRISM) {
            PrismMonitor.getInstance().init((Application) context);
            PrismMonitor.getInstance().addOnPrismMonitorListener(new OmegaPrismMonitorListener());
            PrismMonitor.getInstance().start();
        }
        OmegaSetting.initOmegaSetting();
        OmegaConfig.IS_INIT = true;
        if (OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION) {
            LinkManager.init(context);
            SystemUtils.log(4, "omegasdk", "SDK.init EventThread finish", (Throwable) null, "com.didichuxing.omega.sdk.Omega", 148);
        }
        if (context instanceof Application) {
            AnalysisAppListener.whenAppStart((Application) context);
        }
        BackendThread.getInstance().init(context);
        if (RuntimeCheck.IsMainProcess()) {
            HourlyTimeTask.startHourlyTimeTask();
        }
        long nanoTime2 = (System.nanoTime() - nanoTime) / 1000000;
        for (int i = 0; i < OmegaConfig.initListenerList.size(); i++) {
            OmegaConfig.IInitListener iInitListener = OmegaConfig.initListenerList.get(i);
            if (iInitListener != null) {
                iInitListener.initFinished();
            }
        }
        SystemUtils.log(3, "omegasdk", "SDK.init end, take " + nanoTime2 + "ms", (Throwable) null, "com.didichuxing.omega.sdk.Omega", 171);
    }

    public static void setEnableRate(float f) {
        OmegaConfig.ENABLE_RATE = f;
    }

    public static void startSession() {
        CustomCollector.startSession();
    }

    public static String getSessionId() {
        return CustomCollector.getSessionId();
    }

    public static boolean isInSession() {
        return CustomCollector.isInSession();
    }

    public static void stopSession() {
        CustomCollector.stopSession();
    }

    public static void switchCrash(boolean z) {
        OmegaConfig.SWITCH_CRASH = z;
    }

    public static void switchFullUIAutoTracker(boolean z) {
        OmegaConfig.SWITCH_FULL_AUTO_UI = z;
    }

    public static void switchFullUIAutoEnv(boolean z) {
        OmegaConfig.SWITCH_FULL_AUTO_UI_ENV = z;
    }

    public static void switchH5Hijack(boolean z) {
        OmegaConfig.SWITCH_H5_HIJACK = z;
    }

    public static void switchScreenshot(boolean z) {
        OmegaConfig.SWITCH_SCREENSHOT = z;
    }

    public static void switchOomDump(boolean z) {
        OmegaConfig.SWITCH_OOM_DUMP = z;
    }

    public static void switchPrintTraceLog(boolean z) {
        OmegaConfig.SWITCH_PRINT_TRACE_LOG = z;
    }

    public static void switchEventPersistent(boolean z) {
        OmegaConfig.SWITCH_EVENT_PERSISTENT = z;
    }

    public static void switchSync(boolean z) {
        OmegaConfig.SWITCH_SYNC = z;
    }

    public static void switchUseHttps(boolean z) {
        OmegaConfig.SWITCH_USE_HTTPS = z;
    }

    public static void setChannel(String str) {
        OmegaConfig.CHANNEL = str;
    }

    public static void setLogPrint(boolean z) {
        OmegaConfig.LOG_PRINT = z;
    }

    public static void setDebugModel(boolean z) {
        OmegaConfig.DEBUG_MODEL = z;
        OLog.m34765i("setDebugModel: " + z);
    }

    public static boolean getDebugModel() {
        return OmegaConfig.DEBUG_MODEL;
    }

    public static void setAppName(String str) {
        OmegaConfig.CUSTOM_APP_NAME = str;
    }

    public static void setAppVersion(String str) {
        OmegaConfig.CUSTOM_APP_VERSION = str;
    }

    public static String getAppVersion() {
        return TextUtils.isEmpty(OmegaConfig.CUSTOM_APP_VERSION) ? OmegaConfig.APP_ISSUE : OmegaConfig.CUSTOM_APP_VERSION;
    }

    public static void setSendQueueMaxNumber(int i) {
        if (i <= 0 || i > 500) {
            throw new RuntimeException("maxnum must between (0,500).");
        }
        OmegaConfig.EVENT_SEND_QUEUE_MAX_NUMBER = i;
    }

    public static void setSendQueueMaxDelay(long j) {
        if (j < 60000 || j > 1800000) {
            throw new RuntimeException("delay must between (1min,30min).");
        }
        OmegaConfig.EVENT_SEND_QUEUE_MAX_DELAY = j;
    }

    public static void setTimeOffset(long j) {
        OmegaConfig.CUSTOM_TIME_OFFSET = j;
    }

    @Deprecated
    public static void setPhoneNumber(String str) {
        OmegaConfig.PHONE_NUMBER = str;
    }

    public static void fireFragmentResumed(Object obj) {
        AnalysisFragmentListener.whenFragmentResumed(obj);
        FragmentCollector.whenFragmentResumed(obj);
    }

    public static void fireFragmentPaused(Object obj) {
        AnalysisFragmentListener.whenFragmentPaused(obj);
        FragmentCollector.whenFragmentPaused(obj);
    }

    public static void firePageResumed(Object obj) {
        AnalysisPageListener.whenPageResumed(obj);
        PageCollector.whenPageResumed(obj);
    }

    public static void firePagePaused(Object obj) {
        AnalysisPageListener.whenPagePaused(obj);
        PageCollector.whenPagePaused(obj);
    }

    public static void trackEvent(String str) {
        trackEvent(str, (String) null, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2) {
        trackEvent(str, str2, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        Tracker.trackEvent(str, str2, map);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        Tracker.trackEvent(str, (String) null, map);
    }

    @Deprecated
    public static void trackRealtimeEvent(String str) {
        trackRealtimeEvent(str, (String) null);
    }

    @Deprecated
    public static void trackRealtimeEvent(String str, String str2) {
        trackRealtimeEvent(str, str2, (Map<String, Object>) null);
    }

    @Deprecated
    public static void trackRealtimeEvent(String str, String str2, Map<String, Object> map) {
        if (str == null) {
            OLog.m34763e("invalid event, event is null");
            return;
        }
        Event event = new Event(str, str2);
        event.putAllAttrs(map);
        trackRealtimeEvent(event);
    }

    @Deprecated
    public static void trackRealtimeEvent(Event event) {
        Tracker.trackRealtimeEvent(event);
    }

    public static Event newEvent(String str) {
        return new Event(str);
    }

    public static Event newEvent(String str, String str2) {
        return new Event(str, str2);
    }

    public static void trackEvent(Event event) {
        Tracker.trackEvent(event);
    }

    public static void trackEventSampled(Event event, float f) {
        Tracker.trackEventSampled(event, f);
    }

    @Deprecated
    public static void trackTraceLog(String str, String... strArr) {
        Event event = new Event(str);
        event.setFrom("tl");
        try {
            Pattern compile = Pattern.compile("\\[([^=]+)\\=([^\\]]*)\\]");
            for (String matcher : strArr) {
                Matcher matcher2 = compile.matcher(matcher);
                while (matcher2.find()) {
                    if (matcher2.groupCount() == 2) {
                        event.putAttr(matcher2.group(1), matcher2.group(2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        Tracker.trackEvent(event);
    }

    public static void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        Tracker.trackError(str, str2, str3, str4, map);
    }

    @Deprecated
    public static void trackError(String str, String str2, String str3) {
        trackError(str, str2, str3, (Map<String, Object>) null);
    }

    @Deprecated
    public static void trackError(String str, String str2, String str3, Map<String, Object> map) {
        Tracker.trackError((String) null, str, str2, str3, map);
    }

    public static void trackError(String str, Throwable th) {
        Tracker.trackError(str, th);
    }

    public static void trackCounter(String str) {
        Tracker.trackCounter(str);
    }

    public static OmegaWebViewClient newOmegaWebViewClient() {
        return new OmegaWebViewClient();
    }

    public static void attachOmegaJS(WebView webView, WebViewClient webViewClient) {
        if (!(webViewClient instanceof OmegaWebViewClient)) {
            webView.setWebViewClient(new OmegaWebViewClient(webViewClient));
        }
        webView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
        WebviewEventHelper.addWebviewEventObject(webView);
    }

    public static void attachOmegaPrompt(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        webView.setWebViewClient(new OmegaWebViewClient(webViewClient));
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " omega/" + OmegaConfig.SDK_VERSION);
        webView.setWebChromeClient(new OmegaWebChromeClient(webChromeClient));
    }

    public static void addJsOmegaSDK(WebView webView) {
        try {
            webView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
            WebviewEventHelper.addWebviewEventObject(webView);
        } catch (Throwable th) {
            Tracker.trackGood("addJsOmegaSDK fail", th);
        }
    }

    public static void putGlobalKV(String str, Object obj) {
        Tracker.putGlobalAttr(str, obj);
    }

    public static void putGlobalAttr(String str, Object obj) {
        Tracker.putGlobalAttr(str, obj);
    }

    public static Object getGlobalAttr(String str) {
        return Tracker.getGlobalAttr(str);
    }

    public static void removeGlobalKV(String str) {
        Tracker.removeGlobalAttr(str);
    }

    public static void removeGlobalAttr(String str) {
        Tracker.removeGlobalAttr(str);
    }

    public static String getOmegaId() {
        return PersistentInfoCollector.getOmegaId();
    }

    public static String getOmegaIdSafety() {
        return PersistentInfoCollector.getOmegaIdSafety();
    }

    public static boolean isInit() {
        return OmegaConfig.IS_INIT;
    }

    public static void setOaidObserver(OmegaConfig.IOaidObserver iOaidObserver) {
        OmegaConfig.iOaidObserver = iOaidObserver;
    }

    public static void setInitListener(OmegaConfig.IInitListener iInitListener) {
        if (iInitListener != null) {
            OmegaConfig.initListenerList.add(iInitListener);
        }
    }

    public static void setGetUid(OmegaConfig.IGetUid iGetUid) {
        OmegaConfig.iGetUid = iGetUid;
    }

    public static void setGetPhone(OmegaConfig.IGetPhone iGetPhone) {
        OmegaConfig.iGetPhone = iGetPhone;
    }

    public static void setGetDidiToken(OmegaConfig.IGetDidiToken iGetDidiToken) {
        OmegaConfig.iGetDidiToken = iGetDidiToken;
    }

    public static void setGetCityId(OmegaConfig.IGetCityId iGetCityId) {
        OmegaConfig.iGetCityId = iGetCityId;
    }

    public static void setGetDailingCountryCode(OmegaConfig.IGetDailingCountryCode iGetDailingCountryCode) {
        OmegaConfig.iGetDailingCountryCode = iGetDailingCountryCode;
    }

    public static void setLocation(OmegaConfig.ILocation iLocation) {
        OmegaConfig.iLocation = iLocation;
    }

    public static void setPrintLogListener(OmegaCallback.PrintLogListener printLogListener) {
        OmegaCallback.iPrintLogListener = printLogListener;
    }

    public static void setRecordCurrentPageListener(OmegaCallback.RecordCurrentPageListener recordCurrentPageListener) {
        OmegaCallback.iCurrentPageListener = recordCurrentPageListener;
    }

    public static void setAsyncInit(OmegaCallback.AsyncInit asyncInit) {
        OmegaCallback.iAsyncInit = asyncInit;
    }

    public static void setDidiDeviceId(String str) {
        CustomCollector.setDidiDeviceId(str);
    }

    public static void setDidiSuuid(String str) {
        CustomCollector.setDidiSuuid(str);
    }

    public static void setGetuiCid(String str) {
        CustomCollector.setGetuiCid(str);
    }

    public static void setUploadHost(String str) {
        OmegaConfig.setUploadHost(str);
    }

    public static String getUploadHost() {
        return OmegaConfig.getUploadHost();
    }

    public static void putViewAttr(View view, String str, Object obj) {
        UIAutoMarker.putViewAttr(view, str, obj);
    }

    public static void putPageAttr(Context context, String str, Object obj) {
        UIAutoMarker.putPageAttr(context, str, obj);
    }

    public static void addBlackPage(String str) {
        UIAutoMarker.addBlackPage(str);
    }

    public static void addTrackListener(TrackListener trackListener) {
        Tracker.addTrackListener(trackListener);
    }

    public static void removeTrackListener(TrackListener trackListener) {
        Tracker.removeTrackListener(trackListener);
    }

    public static void removeAllTrackListener() {
        Tracker.removeAllTrackListener();
    }

    public static void exSwitchBatteryMonitor(boolean z) {
        OmegaConfig.EX_SWITCH_BATTERY_MONITOR = z;
    }

    public static void exSetLowBatteryThreshold(int i) {
        OmegaConfig.EX_LOW_BATTERY_THRESHOLD = i;
    }

    public static boolean exIsLowBattery() {
        return Security.exIsLowBattery();
    }

    public static void setPluginInfo(String str) {
        OmegaConfig.PLUGIN_INFO = str;
    }

    public static void setCountyId(int i) {
        OmegaConfig.COUNTY_ID = i;
    }

    public static void setCustomLocale(OmegaConfig.ILocale iLocale) {
        OmegaConfig.iLocale = iLocale;
    }

    public static String getOAID() {
        return OmegaConfig.OMEGA_OAID;
    }

    public static void testJavaCrash() {
        throw new NullPointerException("We got a NPE!");
    }

    public static void testANR() {
        SystemClock.sleep(10000);
    }

    public static void addPnBlackList(List<String> list) {
        OmegaConfig.addPnBlackList(list);
    }

    public static void addPnBlackItem(String str) {
        OmegaConfig.addPnBlackItem(str);
    }
}
