package com.didichuxing.mas.sdk.quality.init;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.mas.sdk.quality.collect.crash.CrashCallbacks;
import com.didichuxing.mas.sdk.quality.collect.crash.CrashHandler;
import com.didichuxing.mas.sdk.quality.collect.crash.JavaCrashCallback;
import com.didichuxing.mas.sdk.quality.collect.xcrash.XCrashHelper;
import com.didichuxing.mas.sdk.quality.report.MASCallback;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.OmegaJS;
import com.didichuxing.mas.sdk.quality.report.analysis.OmegaWebChromeClient;
import com.didichuxing.mas.sdk.quality.report.analysis.OmegaWebViewClient;
import com.didichuxing.mas.sdk.quality.report.analysis.TrackListener;
import com.didichuxing.mas.sdk.quality.report.analysis.Tracker;
import com.didichuxing.mas.sdk.quality.report.backend.BatteryChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.backend.ScreenChangeReceiver;
import com.didichuxing.mas.sdk.quality.report.collector.AllCollectorsFacade;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.FragmentCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck;
import com.didichuxing.mas.sdk.quality.report.perforence.ServiceConfig;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MAS {
    public static Context applicationContext;

    public static String getMASSdkVersion() {
        return MASConfig.MAS_SDK_VERSION;
    }

    public static String getOmegaSdkVersion() {
        return MASConfig.OMEGA_SDK_VERSION;
    }

    public static void init(Context context) {
        Context context2 = context;
        long nanoTime = System.nanoTime();
        MASConfig.MAS_SDK_VERSION = BuildConfig.VERSION_NAME;
        SystemUtils.log(4, Constants.LOG_TAG, "SDK.init v" + MASConfig.MAS_SDK_VERSION, (Throwable) null, "com.didichuxing.mas.sdk.quality.init.MAS", 83);
        if (context2 == null) {
            SystemUtils.log(6, Constants.LOG_TAG, "SDK.init context is null.", (Throwable) null, "com.didichuxing.mas.sdk.quality.init.MAS", 87);
            return;
        }
        applicationContext = context2;
        MASConfig.APP_ISSUE = CommonUtil.getManifestString(context2, "issue");
        if (TextUtils.isEmpty(MASConfig.CUSTOM_APP_VERSION)) {
            MASConfig.CUSTOM_APP_VERSION = MASConfig.APP_ISSUE;
        }
        OLog.init(context);
        RuntimeCheck.init(context);
        ServiceConfig.getInstanse().init(context2);
        CommonUtil.init(context);
        AllCollectorsFacade.initAll(context);
        if (TextUtils.isEmpty(MASConfig.CUSTOM_APP_NAME)) {
            setAppName(PackageCollector.getPkgName());
        }
        ScreenChangeReceiver.init(context);
        RecordStorage.init(context);
        MASConfig.IS_INIT = true;
        SystemUtils.log(3, Constants.LOG_TAG, "SDK.init end, take " + ((System.nanoTime() - nanoTime) / 1000000) + "ms", (Throwable) null, "com.didichuxing.mas.sdk.quality.init.MAS", 123);
    }

    public static void setEnableRate(float f) {
        MASConfig.ENABLE_RATE = f;
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

    public static void switchFullUIAutoTracker(boolean z) {
        MASConfig.SWITCH_FULL_AUTO_UI = z;
    }

    public static void switchFullUIAutoEnv(boolean z) {
        MASConfig.SWITCH_FULL_AUTO_UI_ENV = z;
    }

    public static void switchH5Hijack(boolean z) {
        MASConfig.SWITCH_H5_HIJACK = z;
    }

    public static void switchScreenshot(boolean z) {
        MASConfig.SWITCH_SCREENSHOT = z;
    }

    public static void switchOomDump(boolean z) {
        MASConfig.SWITCH_OOM_DUMP = z;
    }

    public static void switchPrintTraceLog(boolean z) {
        MASConfig.SWITCH_PRINT_TRACE_LOG = z;
    }

    public static void switchEventPersistent(boolean z) {
        MASConfig.SWITCH_EVENT_PERSISTENT = z;
    }

    public static void switchSync(boolean z) {
        MASConfig.SWITCH_SYNC = z;
    }

    public static void switchUseHttps(boolean z) {
        if (!MASConfig.SWITCH_USE_HTTPS) {
            MASConfig.SWITCH_USE_HTTPS = z;
        }
    }

    public static void setLogPrint(boolean z) {
        MASConfig.LOG_PRINT = z;
    }

    public static boolean getDebugModel() {
        return MASConfig.DEBUG_MODEL;
    }

    public static void setDebugModel(boolean z) {
        MASConfig.DEBUG_MODEL = z;
        OLog.m34420i("setDebugModel: " + z);
    }

    public static void setAppName(String str) {
        MASConfig.CUSTOM_APP_NAME = str;
    }

    public static String getAppVersion() {
        return TextUtils.isEmpty(MASConfig.CUSTOM_APP_VERSION) ? MASConfig.APP_ISSUE : MASConfig.CUSTOM_APP_VERSION;
    }

    public static void setAppVersion(String str) {
        MASConfig.CUSTOM_APP_VERSION = str;
    }

    public static void setSendQueueMaxNumber(int i) {
        if (i <= 0 || i > 500) {
            throw new RuntimeException("maxnum must between (0,500).");
        }
        MASConfig.EVENT_SEND_QUEUE_MAX_NUMBER = i;
    }

    public static void setSendQueueMaxDelay(long j) {
        if (j < 60000 || j > 1800000) {
            throw new RuntimeException("delay must between (1min,30min).");
        }
        MASConfig.EVENT_SEND_QUEUE_MAX_DELAY = j;
    }

    public static void fireFragmentResumed(Object obj) {
        FragmentCollector.whenFragmentResumed(obj);
    }

    public static void fireFragmentPaused(Object obj) {
        FragmentCollector.whenFragmentPaused(obj);
    }

    public static void firePageResumed(Object obj) {
        PageCollector.whenPageResumed(obj);
    }

    public static void firePagePaused(Object obj) {
        PageCollector.whenPagePaused(obj);
    }

    protected static void trackEvent(String str) {
        trackEvent(str, (String) null, (Map<String, Object>) null);
    }

    protected static void trackEvent(String str, String str2) {
        trackEvent(str, str2, (Map<String, Object>) null);
    }

    protected static void trackEvent(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackMasEvent(str, str2, map);
    }

    protected static void trackEvent(String str, Map<String, Object> map) {
        OmegaSDKAdapter.trackMasEvent(str, (String) null, map);
    }

    @Deprecated
    protected static void trackTraceLog(String str, String... strArr) {
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
        OmegaSDKAdapter.trackMasEvent(event);
    }

    protected static void trackError(String str, String str2, String str3, String str4, Map<String, Object> map) {
        Tracker.trackError(str, str2, str3, str4, map);
    }

    @Deprecated
    protected static void trackError(String str, String str2, String str3) {
        trackError(str, str2, str3, (Map<String, Object>) null);
    }

    @Deprecated
    public static void trackError(String str, String str2, String str3, Map<String, Object> map) {
        Tracker.trackError((String) null, str, str2, str3, map);
    }

    protected static void trackError(String str, Throwable th) {
        Tracker.trackError(str, th);
    }

    public static OmegaWebViewClient newOmegaWebViewClient() {
        return new OmegaWebViewClient();
    }

    public static void attachOmegaJS(WebView webView, WebViewClient webViewClient) {
        if (!(webViewClient instanceof OmegaWebViewClient)) {
            webView.setWebViewClient(new OmegaWebViewClient(webViewClient));
        }
        webView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
    }

    public static void attachOmegaPrompt(WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient) {
        webView.setWebViewClient(new OmegaWebViewClient(webViewClient));
        WebSettings settings = webView.getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " mas/" + MASConfig.MAS_SDK_VERSION);
        webView.setWebChromeClient(new OmegaWebChromeClient(webChromeClient));
    }

    public static void addJsOmegaSDK(WebView webView) {
        try {
            webView.addJavascriptInterface(OmegaJS.getInstance(), "OmegaSDK");
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

    public static void setGetUid(MASConfig.IGetUid iGetUid) {
        MASConfig.iGetUid = iGetUid;
    }

    public static void setGetPhone(MASConfig.IGetPhone iGetPhone) {
        MASConfig.iGetPhone = iGetPhone;
    }

    public static void setGetDidiToken(MASConfig.IGetDidiToken iGetDidiToken) {
        MASConfig.iGetDidiToken = iGetDidiToken;
    }

    public static void setGetCityId(MASConfig.IGetCityId iGetCityId) {
        MASConfig.iGetCityId = iGetCityId;
    }

    public static void setGetExtraParams(MASConfig.IGetExtraParams iGetExtraParams) {
        MASConfig.iGetExtraParams = iGetExtraParams;
    }

    public static void setGetDailingCountryCode(MASConfig.IGetDailingCountryCode iGetDailingCountryCode) {
        MASConfig.iGetDailingCountryCode = iGetDailingCountryCode;
    }

    public static void setGetLocation(MASConfig.ILocation iLocation) {
        MASConfig.iLocation = iLocation;
    }

    public static void setGetLocationConfig(MASConfig.ILocationConfig iLocationConfig) {
        MASConfig.iLocationConfig = iLocationConfig;
    }

    public static void setGetChannel(MASConfig.IGetChannel iGetChannel) {
        MASConfig.iGetChannel = iGetChannel;
    }

    public static void setGetUploadURLWhiteList(MASConfig.IGetUploadURLWhiteList iGetUploadURLWhiteList) {
        MASConfig.iGetUploadURLWhiteList = iGetUploadURLWhiteList;
    }

    public static void setPrintLogListener(MASCallback.PrintLogListener printLogListener) {
        MASCallback.iPrintLogListener = printLogListener;
    }

    public static void setRecordCurrentPageListener(MASCallback.RecordCurrentPageListener recordCurrentPageListener) {
        MASCallback.iCurrentPageListener = recordCurrentPageListener;
    }

    public static void setAsyncInit(MASCallback.AsyncInit asyncInit) {
        MASCallback.iAsyncInit = asyncInit;
    }

    public static void setGetDidiDeviceId(MASConfig.IGetDidiDeviceId iGetDidiDeviceId) {
        MASConfig.iGetDidiDeviceId = iGetDidiDeviceId;
    }

    public static void setGetDidiSuuid(MASConfig.IGetDidiSuuid iGetDidiSuuid) {
        MASConfig.iGetDidiSuuid = iGetDidiSuuid;
    }

    public static void setGetUiCid(MASConfig.IGetUiCid iGetUiCid) {
        MASConfig.iGetUiCid = iGetUiCid;
    }

    public static String getUploadHost() {
        return MASConfig.UPLOAD_HOST;
    }

    public static void setUploadHost(String str) {
        MASConfig.UPLOAD_HOST = str;
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
        MASConfig.EX_SWITCH_BATTERY_MONITOR = z;
    }

    public static void exSetLowBatteryThreshold(int i) {
        MASConfig.EX_LOW_BATTERY_THRESHOLD = i;
    }

    public static boolean exIsLowBattery() {
        int batteryPercent = BatteryChangeReceiver.getBatteryPercent();
        if (batteryPercent >= 0 && batteryPercent <= MASConfig.EX_LOW_BATTERY_THRESHOLD) {
            return true;
        }
        return false;
    }

    public static void setGetPluginInfo(MASConfig.IGetPluginInfo iGetPluginInfo) {
        MASConfig.iGetPluginInfo = iGetPluginInfo;
    }

    public static void setGetHotpatchVersion(MASConfig.IGetHotPatchVersion iGetHotPatchVersion) {
        MASConfig.iGetHotPatchVersion = iGetHotPatchVersion;
    }

    public static void setGetTimeOffset(MASConfig.IGetTimeOffset iGetTimeOffset) {
        MASConfig.iGetTimeOffset = iGetTimeOffset;
    }

    public static void setGetCountyId(MASConfig.IGetCountryId iGetCountryId) {
        MASConfig.iGetCountryId = iGetCountryId;
    }

    public static void setCustomLocale(MASConfig.ILocale iLocale) {
        MASConfig.iLocale = iLocale;
    }

    public static String getOAID() {
        return MASConfig.OMEGA_OAID;
    }

    public static void testJavaCrash(boolean z) {
        XCrashHelper.testJavaCrash(z);
    }

    public static void testANR() {
        SystemClock.sleep(25000);
    }

    public static void testNativeCrash(boolean z) {
        XCrashHelper.testNativeCrash(z);
    }

    public static void registerCrashCallbacks(CrashCallbacks crashCallbacks) {
        XCrashHelper.registerCrashCallbacks(crashCallbacks);
    }

    public static void unregisterCrashCallbacks(CrashCallbacks crashCallbacks) {
        XCrashHelper.unregisterCrashCallbacks(crashCallbacks);
    }

    public static void registJavaCrashCallback(JavaCrashCallback javaCrashCallback) {
        CrashHandler.getInstance().setCrashCallback(javaCrashCallback);
    }
}
