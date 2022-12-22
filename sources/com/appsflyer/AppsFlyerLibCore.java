package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appsflyer.AFFacebookDeferredDeeplink;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.Foreground;
import com.appsflyer.OneLinkHttpTask;
import com.appsflyer.internal.C1671aa;
import com.appsflyer.internal.C1672ab;
import com.appsflyer.internal.C1674ac;
import com.appsflyer.internal.C1675ad;
import com.appsflyer.internal.C1676ae;
import com.appsflyer.internal.C1677af;
import com.appsflyer.internal.C1678ag;
import com.appsflyer.internal.C1682ah;
import com.appsflyer.internal.C1683ai;
import com.appsflyer.internal.C1700j;
import com.appsflyer.internal.C1706s;
import com.appsflyer.internal.C1709t;
import com.appsflyer.internal.C1716v;
import com.appsflyer.internal.C1718w;
import com.appsflyer.internal.C1720x;
import com.appsflyer.internal.C1722y;
import com.appsflyer.internal.C1723z;
import com.appsflyer.internal.model.event.AdRevenue;
import com.appsflyer.internal.model.event.Attr;
import com.appsflyer.internal.model.event.BackgroundEvent;
import com.appsflyer.internal.model.event.BackgroundReferrerLaunch;
import com.appsflyer.internal.model.event.CachedEvent;
import com.appsflyer.internal.model.event.InAppEvent;
import com.appsflyer.internal.model.event.Launch;
import com.appsflyer.internal.model.event.ProxyEvent;
import com.appsflyer.internal.model.event.Stats;
import com.appsflyer.internal.model.event.UninstallTokenEvent;
import com.appsflyer.internal.referrer.GoogleReferrer;
import com.appsflyer.internal.referrer.HuaweiReferrer;
import com.appsflyer.internal.referrer.Payload;
import com.appsflyer.share.Constants;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.raven.config.RavenConfigKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GoogleApiAvailability;
import global.didi.pay.newview.pix.IPixView;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.NetworkInterface;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLibCore extends AppsFlyerLib {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static String FIRST_LAUNCHES_URL = null;
    public static final String INSTALL_REFERRER_PREF = "rfr";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_5.4.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";
    public static String REFERRER_TRACKING_URL = null;
    public static String REGISTER_URL = null;
    public static AppsFlyerLibCore instance = new AppsFlyerLibCore();

    /* renamed from: ı */
    public static final String f1785 = "5.4";

    /* renamed from: Ɩ */
    private static final String f1786;

    /* renamed from: ǃ */
    public static AppsFlyerInAppPurchaseValidatorListener f1787 = null;

    /* renamed from: ɩ */
    public static final String f1788 = "38";
    /* access modifiers changed from: private */

    /* renamed from: ɪ */
    public static AppsFlyerConversionListener f1789 = null;

    /* renamed from: ɹ */
    private static String f1790;

    /* renamed from: ɾ */
    private static String f1791;

    /* renamed from: І */
    private static String f1792;

    /* renamed from: і */
    private static final String f1793;

    /* renamed from: ӏ */
    private static final List<String> f1794 = Arrays.asList(new String[]{"is_cache"});
    protected Uri latestDeepLink = null;

    /* renamed from: ŀ */
    private long f1795 = -1;
    /* access modifiers changed from: private */

    /* renamed from: ł */
    public ScheduledExecutorService f1796 = null;
    /* access modifiers changed from: private */

    /* renamed from: ſ */
    public long f1797;

    /* renamed from: Ɨ */
    private String f1798;

    /* renamed from: ƚ */
    private Map<Long, String> f1799;

    /* renamed from: ǀ */
    private boolean f1800;

    /* renamed from: ȷ */
    private long f1801 = -1;

    /* renamed from: ɍ */
    private boolean f1802 = false;

    /* renamed from: ɔ */
    private boolean f1803 = false;

    /* renamed from: ɟ */
    private C1678ag f1804 = new C1678ag();

    /* renamed from: ɨ */
    private String f1805;

    /* renamed from: ɺ */
    private boolean f1806;

    /* renamed from: ɼ */
    private boolean f1807 = false;

    /* renamed from: ɿ */
    private long f1808 = TimeUnit.SECONDS.toMillis(5);
    /* access modifiers changed from: private */

    /* renamed from: ʅ */
    public long f1809;
    /* access modifiers changed from: private */

    /* renamed from: ʟ */
    public GoogleReferrer f1810;
    /* access modifiers changed from: private */

    /* renamed from: ͻ */
    public Map<String, Object> f1811;

    /* renamed from: Ι */
    public String f1812;

    /* renamed from: ι */
    public String f1813;
    /* access modifiers changed from: private */

    /* renamed from: ϲ */
    public Map<String, Object> f1814;

    /* renamed from: ϳ */
    private Application f1815;

    /* renamed from: Ј */
    private boolean f1816 = false;
    /* access modifiers changed from: private */

    /* renamed from: г */
    public boolean f1817 = false;
    /* access modifiers changed from: private */

    /* renamed from: с */
    public boolean f1818 = false;
    /* access modifiers changed from: private */

    /* renamed from: т */
    public HuaweiReferrer f1819;

    /* renamed from: х */
    private String f1820;

    /* renamed from: Ӏ */
    long f1821;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f1785);
        sb.append("/androidevent?buildnumber=5.4.0&app_id=");
        f1786 = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sregister.%s/api/v");
        sb2.append(f1786);
        REGISTER_URL = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%sadrevenue.%s/api/v");
        sb3.append(f1785);
        sb3.append("/android?buildnumber=5.4.0&app_id=");
        f1792 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f1785);
        sb4.append("/androidevent?app_id=");
        f1793 = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sconversions.%s/api/v");
        sb5.append(f1793);
        FIRST_LAUNCHES_URL = sb5.toString();
        StringBuilder sb6 = new StringBuilder("https://%slaunches.%s/api/v");
        sb6.append(f1793);
        f1790 = sb6.toString();
        StringBuilder sb7 = new StringBuilder("https://%sinapps.%s/api/v");
        sb7.append(f1793);
        f1791 = sb7.toString();
        StringBuilder sb8 = new StringBuilder("https://%sattr.%s/api/v");
        sb8.append(f1793);
        REFERRER_TRACKING_URL = sb8.toString();
    }

    public AppsFlyerLibCore() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLibCore getInstance() {
        return instance;
    }

    public void performOnAppAttribution(Context context, URI uri) {
        if (uri == null || uri.toString().isEmpty()) {
            AppsFlyerConversionListener appsFlyerConversionListener = f1789;
            if (appsFlyerConversionListener != null) {
                StringBuilder sb = new StringBuilder("Link is \"");
                sb.append(uri);
                sb.append(Const.jsQuote);
                appsFlyerConversionListener.onAttributionFailure(sb.toString());
            }
        } else if (context == null) {
            AppsFlyerConversionListener appsFlyerConversionListener2 = f1789;
            if (appsFlyerConversionListener2 != null) {
                StringBuilder sb2 = new StringBuilder("Context is \"");
                sb2.append(context);
                sb2.append(Const.jsQuote);
                appsFlyerConversionListener2.onAttributionFailure(sb2.toString());
            }
        } else {
            AFDeepLinkManager.getInstance();
            AFDeepLinkManager.m1495(context, new HashMap(), Uri.parse(uri.toString()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ǃ */
    public final void mo16026(Context context, Intent intent) {
        if (intent.getStringExtra("appsflyer_preinstall") != null) {
            getInstance();
            String stringExtra = intent.getStringExtra("appsflyer_preinstall");
            try {
                if (new JSONObject(stringExtra).has("pid")) {
                    AppsFlyerProperties.getInstance().set("preInstallName", stringExtra);
                } else {
                    AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
                }
            } catch (JSONException e) {
                AFLogger.afErrorLog("Error parsing JSON for preinstall", e);
            }
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String stringExtra2 = intent.getStringExtra(Payload.REFERRER);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString(Payload.REFERRER, stringExtra2);
            edit.apply();
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                AFEvent weakContext = new BackgroundReferrerLaunch().context(context).mo15926().weakContext();
                weakContext.f1735 = stringExtra2;
                weakContext.f1736 = intent;
                if (stringExtra2 != null && stringExtra2.length() > 5 && m1540(weakContext, getSharedPreferences(context))) {
                    m1560(AFExecutor.getInstance().mo15930(), new C1662e(this, weakContext, (byte) 0), 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    /* renamed from: ǃ */
    private static void m1554(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get(keys.next()));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator<String> keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String next = keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(next));
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        if (jSONArray2.getLong(i2) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i2) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                            i2++;
                            str = next;
                        }
                    }
                    continue;
                } catch (JSONException unused2) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* renamed from: ı */
    static void m1533(Context context, String str) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = getSharedPreferences(context).getString("extraReferrers", (String) null);
            if (string == null) {
                jSONObject = new JSONObject();
                jSONArray = new JSONArray();
            } else {
                JSONObject jSONObject2 = new JSONObject(string);
                if (jSONObject2.has(str)) {
                    jSONArray2 = new JSONArray((String) jSONObject2.get(str));
                } else {
                    jSONArray2 = new JSONArray();
                }
                JSONObject jSONObject3 = jSONObject2;
                jSONArray = jSONArray2;
                jSONObject = jSONObject3;
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                m1554(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject4 = jSONObject.toString();
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("extraReferrers", jSONObject4);
            edit.apply();
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    public void stopTracking(boolean z, Context context) {
        this.f1807 = z;
        C1671aa.m1608();
        try {
            File r10 = C1671aa.m1611(context);
            if (!r10.exists()) {
                r10.mkdir();
            } else {
                for (File file : r10.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file.getName());
                    SystemUtils.log(4, LOG_TAG, sb.toString(), (Throwable) null, "com.appsflyer.AppsFlyerLibCore", 9163);
                    C1671aa.m1610(C1671aa.m1607(file).f1993, context);
                }
            }
        } catch (Exception unused) {
            SystemUtils.log(4, LOG_TAG, "Could not cache request", (Throwable) null, "com.appsflyer.AppsFlyerLibCore", 9168);
        }
        if (this.f1807) {
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            edit.apply();
        }
    }

    public void onPause(Context context) {
        if (Foreground.listener != null) {
            Foreground.listener.onBecameBackground(context);
        }
    }

    public void updateServerUninstallToken(Context context, String str) {
        C1677af.m1620(context, str);
    }

    public void setDebugLog(boolean z) {
        setLogLevel(z ? AFLogger.LogLevel.DEBUG : AFLogger.LogLevel.NONE);
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f1802 = z;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: ι */
    public static void m1577(Context context, String str, long j) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    /* renamed from: ι */
    private static boolean m1583(String str) {
        return AppsFlyerProperties.getInstance().getBoolean(str, false);
    }

    /* renamed from: ι */
    private static boolean m1581() {
        return m1583(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null;
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    public void setCustomerIdAndTrack(String str, Context context) {
        Intent intent;
        if (context == null) {
            return;
        }
        if (m1581()) {
            setCustomerUserId(str);
            AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
            StringBuilder sb = new StringBuilder("CustomerUserId set: ");
            sb.append(str);
            sb.append(" - Initializing AppsFlyer Tacking");
            AFLogger.afInfoLog(sb.toString(), true);
            String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (referrer == null) {
                referrer = "";
            }
            if (context instanceof Activity) {
                intent = ((Activity) context).getIntent();
            } else {
                intent = null;
            }
            m1534(context, string, referrer, intent);
            if (AppsFlyerProperties.getInstance().getString("afUninstallToken") != null) {
                mo16029(context, AppsFlyerProperties.getInstance().getString("afUninstallToken"));
                return;
            }
            return;
        }
        setCustomerUserId(str);
        AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
    }

    public String getOutOfStore(Context context) {
        String str;
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        if (context == null) {
            str = null;
        } else {
            str = m1556("AF_STORE", context.getPackageManager(), context.getPackageName());
        }
        if (str != null) {
            return str;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m1514("Cannot set setOutOfStore with null");
    }

    @Deprecated
    public void sendDeepLinkData(Activity activity) {
        if (activity != null && activity.getIntent() != null) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai aiVar = C1683ai.f1911;
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            aiVar.mo16117("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117("public_api_call", "sendDeepLinkData", activity.getLocalClassName(), "activity_intent_null");
        } else {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117("public_api_call", "sendDeepLinkData", "activity_null");
        }
        try {
            startTracking(activity);
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0081, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0192  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendPushNotificationData(android.app.Activity r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            java.lang.String r0 = "c"
            java.lang.String r3 = "pid"
            r4 = 1
            r5 = 0
            r6 = 2
            java.lang.String r7 = "public_api_call"
            java.lang.String r8 = "sendPushNotificationData"
            if (r2 == 0) goto L_0x0048
            android.content.Intent r9 = r17.getIntent()
            if (r9 == 0) goto L_0x0048
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911
            if (r9 != 0) goto L_0x0022
            com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai
            r9.<init>()
            com.appsflyer.internal.C1683ai.f1911 = r9
        L_0x0022:
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911
            java.lang.String[] r10 = new java.lang.String[r6]
            java.lang.String r11 = r17.getLocalClassName()
            r10[r5] = r11
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r11 = "activity_intent_"
            r5.<init>(r11)
            android.content.Intent r11 = r17.getIntent()
            java.lang.String r11 = r11.toString()
            r5.append(r11)
            java.lang.String r5 = r5.toString()
            r10[r4] = r5
            r9.mo16117(r7, r8, r10)
            goto L_0x007d
        L_0x0048:
            if (r2 == 0) goto L_0x0067
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911
            if (r9 != 0) goto L_0x0055
            com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai
            r9.<init>()
            com.appsflyer.internal.C1683ai.f1911 = r9
        L_0x0055:
            com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911
            java.lang.String[] r10 = new java.lang.String[r6]
            java.lang.String r11 = r17.getLocalClassName()
            r10[r5] = r11
            java.lang.String r5 = "activity_intent_null"
            r10[r4] = r5
            r9.mo16117(r7, r8, r10)
            goto L_0x007d
        L_0x0067:
            com.appsflyer.internal.ai r4 = com.appsflyer.internal.C1683ai.f1911
            if (r4 != 0) goto L_0x0072
            com.appsflyer.internal.ai r4 = new com.appsflyer.internal.ai
            r4.<init>()
            com.appsflyer.internal.C1683ai.f1911 = r4
        L_0x0072:
            com.appsflyer.internal.ai r4 = com.appsflyer.internal.C1683ai.f1911
            java.lang.String r5 = "activity_null"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.mo16117(r7, r8, r5)
        L_0x007d:
            boolean r4 = r2 instanceof android.app.Activity
            if (r4 == 0) goto L_0x00b0
            r4 = r2
            android.app.Activity r4 = (android.app.Activity) r4
            android.content.Intent r7 = r4.getIntent()
            if (r7 == 0) goto L_0x00b0
            android.os.Bundle r8 = r7.getExtras()
            if (r8 == 0) goto L_0x00b0
            java.lang.String r9 = "af"
            java.lang.String r10 = r8.getString(r9)
            if (r10 == 0) goto L_0x00b1
            java.lang.String r11 = java.lang.String.valueOf(r10)
            java.lang.String r12 = "Push Notification received af payload = "
            java.lang.String r11 = r12.concat(r11)
            com.appsflyer.AFLogger.afInfoLog(r11)
            r8.remove(r9)
            android.content.Intent r7 = r7.putExtras(r8)
            r4.setIntent(r7)
            goto L_0x00b1
        L_0x00b0:
            r10 = 0
        L_0x00b1:
            r1.f1798 = r10
            if (r10 == 0) goto L_0x01bd
            long r7 = java.lang.System.currentTimeMillis()
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f1799
            java.lang.String r9 = ")"
            if (r4 != 0) goto L_0x00ce
            java.lang.String r0 = "pushes: initializing pushes history.."
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            r1.f1799 = r0
            r12 = r7
            goto L_0x017f
        L_0x00ce:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0164 }
            java.lang.String r10 = "pushPayloadMaxAging"
            r11 = 1800000(0x1b7740, double:8.89318E-318)
            long r10 = r4.getLong(r10, r11)     // Catch:{ all -> 0x0164 }
            java.util.Map<java.lang.Long, java.lang.String> r4 = r1.f1799     // Catch:{ all -> 0x0164 }
            java.util.Set r4 = r4.keySet()     // Catch:{ all -> 0x0164 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0164 }
            r12 = r7
        L_0x00e6:
            boolean r14 = r4.hasNext()     // Catch:{ all -> 0x0162 }
            if (r14 == 0) goto L_0x017f
            java.lang.Object r14 = r4.next()     // Catch:{ all -> 0x0162 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0162 }
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ all -> 0x0162 }
            java.lang.String r6 = r1.f1798     // Catch:{ all -> 0x0162 }
            r15.<init>(r6)     // Catch:{ all -> 0x0162 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0162 }
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f1799     // Catch:{ all -> 0x0162 }
            java.lang.Object r5 = r5.get(r14)     // Catch:{ all -> 0x0162 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0162 }
            r6.<init>(r5)     // Catch:{ all -> 0x0162 }
            java.lang.Object r5 = r15.get(r3)     // Catch:{ all -> 0x0162 }
            java.lang.Object r2 = r6.get(r3)     // Catch:{ all -> 0x0162 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0162 }
            if (r2 == 0) goto L_0x0142
            java.lang.Object r2 = r15.get(r0)     // Catch:{ all -> 0x0162 }
            java.lang.Object r5 = r6.get(r0)     // Catch:{ all -> 0x0162 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x0162 }
            if (r2 == 0) goto L_0x0142
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0162 }
            java.lang.String r2 = "PushNotificationMeasurement: A previous payload with same PID and campaign was already acknowledged! (old: "
            r0.<init>(r2)     // Catch:{ all -> 0x0162 }
            r0.append(r6)     // Catch:{ all -> 0x0162 }
            java.lang.String r2 = ", new: "
            r0.append(r2)     // Catch:{ all -> 0x0162 }
            r0.append(r15)     // Catch:{ all -> 0x0162 }
            r0.append(r9)     // Catch:{ all -> 0x0162 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0162 }
            com.appsflyer.AFLogger.afInfoLog(r0)     // Catch:{ all -> 0x0162 }
            r2 = 0
            r1.f1798 = r2     // Catch:{ all -> 0x0162 }
            return
        L_0x0142:
            r2 = 0
            long r5 = r14.longValue()     // Catch:{ all -> 0x0162 }
            long r5 = r7 - r5
            int r15 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x0152
            java.util.Map<java.lang.Long, java.lang.String> r5 = r1.f1799     // Catch:{ all -> 0x0162 }
            r5.remove(r14)     // Catch:{ all -> 0x0162 }
        L_0x0152:
            long r5 = r14.longValue()     // Catch:{ all -> 0x0162 }
            int r15 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r15 > 0) goto L_0x015e
            long r12 = r14.longValue()     // Catch:{ all -> 0x0162 }
        L_0x015e:
            r2 = r17
            r6 = 2
            goto L_0x00e6
        L_0x0162:
            r0 = move-exception
            goto L_0x0166
        L_0x0164:
            r0 = move-exception
            r12 = r7
        L_0x0166:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while handling push notification measurement: "
            r2.<init>(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.appsflyer.AFLogger.afErrorLog(r2, r0)
        L_0x017f:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "pushPayloadHistorySize"
            r3 = 2
            int r0 = r0.getInt(r2, r3)
            java.util.Map<java.lang.Long, java.lang.String> r2 = r1.f1799
            int r2 = r2.size()
            if (r2 != r0) goto L_0x01af
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "pushes: removing oldest overflowing push (oldest push:"
            r0.<init>(r2)
            r0.append(r12)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afInfoLog(r0)
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f1799
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r0.remove(r2)
        L_0x01af:
            java.util.Map<java.lang.Long, java.lang.String> r0 = r1.f1799
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = r1.f1798
            r0.put(r2, r3)
            r16.startTracking(r17)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.sendPushNotificationData(android.app.Activity):void");
    }

    public void setUserEmails(AppsFlyerProperties.EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        String str = null;
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : strArr) {
            if (C165110.f1824[emailsCryptType.ordinal()] != 2) {
                arrayList2.add(C1723z.m1704(str2));
                str = "sha256_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$10 */
    static /* synthetic */ class C165110 {

        /* renamed from: ι */
        static final /* synthetic */ int[] f1824;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.AppsFlyerProperties$EmailsCryptType[] r0 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1824 = r0
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.SHA256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1824     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.AppsFlyerProperties$EmailsCryptType r1 = com.appsflyer.AppsFlyerProperties.EmailsCryptType.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C165110.<clinit>():void");
        }
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        AFLogger.afDebugLog(String.format("setResolveDeepLinkURLs %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.f1728 = strArr;
    }

    public void setOneLinkCustomDomain(String... strArr) {
        AFLogger.afDebugLog(String.format("setOneLinkCustomDomain %s", new Object[]{Arrays.toString(strArr)}));
        AFDeepLinkManager.f1727 = strArr;
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, final Context context) {
        if (context != null) {
            this.f1815 = (Application) context.getApplicationContext();
            if (GoogleReferrer.allow(this, context)) {
                if (this.f1810 == null) {
                    this.f1810 = new GoogleReferrer();
                    AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                    this.f1810.start(context, new Runnable() {
                        public final void run() {
                            try {
                                AFLogger.afDebugLog("Install Referrer collected locally");
                                AppsFlyerLibCore.m1569(AppsFlyerLibCore.this);
                            } catch (Throwable th) {
                                AFLogger.afErrorLog(th.getMessage(), th);
                            }
                        }
                    });
                } else {
                    AFLogger.afWarnLog("GoogleReferrer instance already created");
                }
            }
            final SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (getLaunchCounter(sharedPreferences, false) < 2) {
                HuaweiReferrer huaweiReferrer = new HuaweiReferrer(new Runnable() {
                    public final void run() {
                        if (AppsFlyerLibCore.this.getLaunchCounter(sharedPreferences, false) != 1) {
                            return;
                        }
                        if (!GoogleReferrer.allow(AppsFlyerLibCore.this, context) || sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false)) {
                            AppsFlyerLibCore.this.m1535(new Attr().context(context));
                        }
                    }
                }, context);
                this.f1819 = huaweiReferrer;
                huaweiReferrer.start();
            }
            this.f1818 = m1572(context);
        } else {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        }
        return init(str, appsFlyerConversionListener);
    }

    /* renamed from: Ι */
    private boolean m1572(Context context) {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            this.f1814 = new ConcurrentHashMap();
            C16544 r4 = new C1709t.C1711d() {
                /* renamed from: ı */
                public final void mo16034(String str, String str2) {
                    AppsFlyerLibCore.this.f1814.put("signedData", str);
                    AppsFlyerLibCore.this.f1814.put("signature", str2);
                    AppsFlyerLibCore.this.f1814.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                /* renamed from: ǃ */
                public final void mo16035(String str, Exception exc) {
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AppsFlyerLibCore.this.f1814.put("error", message);
                    AFLogger.afErrorLog(str, exc, true);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                C1709t.C17103 r7 = new InvocationHandler(r4) {

                    /* renamed from: ι */
                    private /* synthetic */ C1711d f2024;

                    public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.internal.t.3.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.t.3.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    
*/
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r7)});
            } catch (ClassNotFoundException e) {
                r4.mo16035(e.getClass().getSimpleName(), e);
            } catch (NoSuchMethodException e2) {
                r4.mo16035(e2.getClass().getSimpleName(), e2);
            } catch (IllegalAccessException e3) {
                r4.mo16035(e3.getClass().getSimpleName(), e3);
            } catch (InvocationTargetException e4) {
                r4.mo16035(e4.getClass().getSimpleName(), e4);
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void enableFacebookDeferredApplinks(boolean z) {
        this.f1816 = z;
    }

    public void startTracking(Context context) {
        startTracking(context, (String) null);
    }

    public void startTracking(Context context, String str) {
        startTracking(context, str, (AppsFlyerTrackingRequestListener) null);
    }

    public void startTracking(Context context, String str, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        final String str2 = str;
        if (!this.f1806) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking()' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
            if (str2 == null) {
                return;
            }
        }
        if (Foreground.listener == null) {
            this.f1815 = (Application) context.getApplicationContext();
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117("public_api_call", "startTracking", str2);
            AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{"5.4.0", f1788}));
            StringBuilder sb = new StringBuilder("Build Number: ");
            sb.append(f1788);
            AFLogger.afInfoLog(sb.toString());
            AppsFlyerProperties.getInstance().loadProperties(this.f1815.getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str2);
                C1682ah.m1628(str);
            } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY))) {
                AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
                return;
            }
            Context baseContext = this.f1815.getBaseContext();
            try {
                if ((SystemUtils.getPackageInfo(baseContext.getPackageManager(), baseContext.getPackageName(), 0).applicationInfo.flags & 32768) != 0) {
                    if (baseContext.getResources().getIdentifier("appsflyer_backup_rules", "xml", baseContext.getPackageName()) != 0) {
                        AFLogger.afInfoLog("appsflyer_backup_rules.xml detected, using AppsFlyer defined backup rules for AppsFlyer SDK data", true);
                    } else {
                        AFLogger.m1514("'allowBackup' is set to true; appsflyer_backup_rules.xml not detected.\nAppsFlyer shared preferences should be excluded from auto backup by adding: <exclude domain=\"sharedpref\" path=\"appsflyer-data\"/> to the Application's <full-backup-content> rules");
                    }
                }
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("checkBackupRules Exception: ");
                sb2.append(e.toString());
                AFLogger.afRDLog(sb2.toString());
            }
            if (this.f1816) {
                Context applicationContext = this.f1815.getApplicationContext();
                this.f1811 = new HashMap();
                final long currentTimeMillis = System.currentTimeMillis();
                C16501 r8 = new AFFacebookDeferredDeeplink.AppLinkFetchEvents() {
                    public final void onAppLinkFetchFinished(String str, String str2, String str3) {
                        if (str != null) {
                            AFLogger.afInfoLog("Facebook Deferred AppLink data received: ".concat(String.valueOf(str)));
                            AppsFlyerLibCore.this.f1811.put("link", str);
                            if (str2 != null) {
                                AppsFlyerLibCore.this.f1811.put("target_url", str2);
                            }
                            if (str3 != null) {
                                HashMap hashMap = new HashMap();
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(ShareConstants.PROMO_CODE, str3);
                                hashMap.put("deeplink_context", hashMap2);
                                AppsFlyerLibCore.this.f1811.put("extras", hashMap);
                            }
                        } else {
                            AppsFlyerLibCore.this.f1811.put("link", "");
                        }
                        AppsFlyerLibCore.this.f1811.put("ttr", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }

                    public final void onAppLinkFetchFailed(String str) {
                        AppsFlyerLibCore.this.f1811.put("error", str);
                    }
                };
                try {
                    Class.forName("com.facebook.FacebookSdk").getMethod("sdkInitialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{applicationContext});
                    Class<?> cls = Class.forName("com.facebook.applinks.AppLinkData");
                    Class<?> cls2 = Class.forName("com.facebook.applinks.AppLinkData$CompletionHandler");
                    Method method = cls.getMethod("fetchDeferredAppLinkData", new Class[]{Context.class, String.class, cls2});
                    AFFacebookDeferredDeeplink.C16455 r12 = new InvocationHandler(cls, r8) {

                        /* renamed from: ı */
                        private /* synthetic */ Class f1756;

                        /* renamed from: ɩ */
                        private /* synthetic */ AppLinkFetchEvents f1757;

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object invoke(
/*
Method generation error in method: com.appsflyer.AFFacebookDeferredDeeplink.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, dex: classes.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.AFFacebookDeferredDeeplink.5.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object, class status: UNLOADED
                        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        
*/
                    };
                    Object newProxyInstance = Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r12);
                    String string = applicationContext.getString(applicationContext.getResources().getIdentifier("facebook_app_id", TypedValues.Custom.S_STRING, applicationContext.getPackageName()));
                    if (TextUtils.isEmpty(string)) {
                        r8.onAppLinkFetchFailed("Facebook app id not defined in resources");
                    } else {
                        method.invoke((Object) null, new Object[]{applicationContext, string, newProxyInstance});
                    }
                } catch (NoSuchMethodException e2) {
                    r8.onAppLinkFetchFailed(e2.toString());
                } catch (InvocationTargetException e3) {
                    r8.onAppLinkFetchFailed(e3.toString());
                } catch (ClassNotFoundException e4) {
                    r8.onAppLinkFetchFailed(e4.toString());
                } catch (IllegalAccessException e5) {
                    r8.onAppLinkFetchFailed(e5.toString());
                }
            }
            final AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener2 = appsFlyerTrackingRequestListener;
            Foreground.m1604(context, new Foreground.Listener() {
                public final void onBecameForeground(Activity activity) {
                    if (AppsFlyerLibCore.this.getLaunchCounter(AppsFlyerLibCore.getSharedPreferences(activity), false) < 2) {
                        AFSensorManager r0 = AFSensorManager.m1519((Context) activity);
                        r0.f1768.post(r0.f1777);
                        r0.f1768.post(r0.f1773);
                    }
                    AFLogger.afInfoLog("onBecameForeground");
                    long unused = AppsFlyerLibCore.this.f1809 = System.currentTimeMillis();
                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                    AFEvent key = new Launch().context(activity).key(str2);
                    key.f1739 = appsFlyerTrackingRequestListener2;
                    appsFlyerLibCore.mo16027(key);
                    AFLogger.resetDeltaTime();
                }

                public final void onBecameBackground(Context context) {
                    AFLogger.afInfoLog("onBecameBackground");
                    long unused = AppsFlyerLibCore.this.f1797 = System.currentTimeMillis();
                    AFLogger.afInfoLog("callStatsBackground background call");
                    AppsFlyerLibCore.this.mo16030((WeakReference<Context>) new WeakReference(context));
                    if (C1683ai.f1911 == null) {
                        C1683ai.f1911 = new C1683ai();
                    }
                    C1683ai aiVar = C1683ai.f1911;
                    if (aiVar.mo16124()) {
                        aiVar.mo16123();
                        if (context != null) {
                            String packageName = context.getPackageName();
                            PackageManager packageManager = context.getPackageManager();
                            try {
                                if (C1683ai.f1911 == null) {
                                    C1683ai.f1911 = new C1683ai();
                                }
                                C1683ai.f1911.mo16122(packageName, packageManager);
                                if (C1683ai.f1911 == null) {
                                    C1683ai.f1911 = new C1683ai();
                                }
                                BackgroundEvent trackingStopped = new ProxyEvent().body(C1683ai.f1911.mo16121()).trackingStopped(AppsFlyerLib.getInstance().isTrackingStopped());
                                StringBuilder sb = new StringBuilder();
                                sb.append(ServerConfigHandler.getUrl("https://%smonitorsdk.%s/remote-debug?app_id="));
                                sb.append(packageName);
                                new Thread(new C1675ad((BackgroundEvent) trackingStopped.urlString(sb.toString()))).start();
                            } catch (Throwable unused2) {
                            }
                        }
                        aiVar.mo16119();
                    } else {
                        AFLogger.afDebugLog("RD status is OFF");
                    }
                    AFExecutor instance = AFExecutor.getInstance();
                    try {
                        AFExecutor.m1499(instance.f1753);
                        if (instance.f1754 instanceof ThreadPoolExecutor) {
                            AFExecutor.m1499((ThreadPoolExecutor) instance.f1754);
                        }
                    } catch (Throwable th) {
                        AFLogger.afErrorLog("failed to stop Executors", th);
                    }
                    AFSensorManager r7 = AFSensorManager.m1519(context);
                    r7.f1768.post(r7.f1777);
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* renamed from: ɩ */
    private static void m1559(android.content.Context r4) {
        /*
            boolean r0 = com.appsflyer.AndroidUtils.m1525()
            if (r0 == 0) goto L_0x000e
            r0 = 23
            java.lang.String r1 = "OPPO device found"
            com.appsflyer.AFLogger.afRDLog(r1)
            goto L_0x0010
        L_0x000e:
            r0 = 18
        L_0x0010:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x00c1
            java.lang.String r0 = "keyPropDisableAFKeystore"
            boolean r0 = m1583((java.lang.String) r0)
            if (r0 != 0) goto L_0x00c1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OS SDK is="
            r0.<init>(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r0.append(r1)
            java.lang.String r1 = "; use KeyStore"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afRDLog(r0)
            com.appsflyer.AFKeystoreWrapper r0 = new com.appsflyer.AFKeystoreWrapper
            r0.<init>(r4)
            boolean r1 = r0.mo15937()
            if (r1 != 0) goto L_0x0055
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r4)
            java.lang.String r4 = com.appsflyer.internal.C1676ae.m1619(r1)
            r0.f1762 = r4
            r4 = 0
            r0.f1760 = r4
            java.lang.String r4 = r0.mo15938()
            r0.mo15939(r4)
            goto L_0x009f
        L_0x0055:
            java.lang.String r4 = r0.mo15938()
            java.lang.Object r1 = r0.f1758
            monitor-enter(r1)
            int r2 = r0.f1760     // Catch:{ all -> 0x00be }
            int r2 = r2 + 1
            r0.f1760 = r2     // Catch:{ all -> 0x00be }
            java.lang.String r2 = "Deleting key with alias: "
            java.lang.String r3 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.afInfoLog(r2)     // Catch:{ all -> 0x00be }
            java.lang.Object r2 = r0.f1758     // Catch:{ KeyStoreException -> 0x007c }
            monitor-enter(r2)     // Catch:{ KeyStoreException -> 0x007c }
            java.security.KeyStore r3 = r0.f1761     // Catch:{ all -> 0x0079 }
            r3.deleteEntry(r4)     // Catch:{ all -> 0x0079 }
            monitor-exit(r2)     // Catch:{ all -> 0x0079 }
            goto L_0x0097
        L_0x0079:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ KeyStoreException -> 0x007c }
            throw r4     // Catch:{ KeyStoreException -> 0x007c }
        L_0x007c:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            java.lang.String r3 = "Exception "
            r2.<init>(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x00be }
            r2.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r3 = " occurred"
            r2.append(r3)     // Catch:{ all -> 0x00be }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00be }
            com.appsflyer.AFLogger.afErrorLog(r2, r4)     // Catch:{ all -> 0x00be }
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x00be }
            java.lang.String r4 = r0.mo15938()
            r0.mo15939(r4)
        L_0x009f:
            java.lang.String r4 = "KSAppsFlyerId"
            java.lang.String r1 = r0.mo15936()
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            r2.set((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r4 = "KSAppsFlyerRICounter"
            int r0 = r0.mo15940()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            r1.set((java.lang.String) r4, (java.lang.String) r0)
            return
        L_0x00be:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x00c1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "OS SDK is="
            r4.<init>(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r4.append(r0)
            java.lang.String r0 = "; no KeyStore usage"
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afRDLog(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m1559(android.content.Context):void");
    }

    public void setPhoneNumber(String str) {
        this.f1820 = C1723z.m1704(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ɩ */
    public final void mo16030(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences sharedPreferences = getSharedPreferences(weakReference.get());
            AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
            long j = this.f1797 - this.f1809;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
            }
            C1718w r6 = C1716v.m1695(weakReference.get().getContentResolver());
            if (r6 != null) {
                hashMap.put("amazon_aid", r6.f2031);
                hashMap.put("amazon_aid_limit", String.valueOf(r6.mo16162()));
            }
            String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
            if (string3 != null) {
                hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
            }
            hashMap.put("app_id", weakReference.get().getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", C1676ae.m1619(weakReference));
            hashMap.put("time_in_app", String.valueOf(j / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(getLaunchCounter(sharedPreferences, false)));
            hashMap.put("channel", getConfiguredChannel(weakReference.get()));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.f1803) {
                try {
                    AFLogger.afDebugLog("Running callStats task");
                    new Thread(new C1675ad((BackgroundEvent) new Stats().trackingStopped(isTrackingStopped()).params(hashMap).urlString(ServerConfigHandler.getUrl("https://%sstats.%s/stats")))).start();
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Could not send callStats request", th);
                }
            } else {
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
            }
        }
    }

    @Deprecated
    public void trackAppLaunch(Context context, String str) {
        if (GoogleReferrer.allow(this, context)) {
            if (this.f1810 == null) {
                this.f1810 = new GoogleReferrer();
                AFLogger.afDebugLog("Connecting to Install Referrer Library...");
                this.f1810.start(context, new Runnable() {
                    public final void run() {
                        try {
                            AFLogger.afDebugLog("Install Referrer collected locally");
                            AppsFlyerLibCore.m1569(AppsFlyerLibCore.this);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog(th.getMessage(), th);
                        }
                    }
                });
            } else {
                AFLogger.afWarnLog("GoogleReferrer instance already created");
            }
        }
        m1534(context, str, "", (Intent) null);
    }

    /* access modifiers changed from: protected */
    public void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        HashMap hashMap;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f1748 = str;
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = new HashMap(map);
        }
        context2.f1744 = hashMap;
        context2.f1739 = appsFlyerTrackingRequestListener;
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai aiVar = C1683ai.f1911;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = new JSONObject(context2.f1744 == null ? new HashMap() : context2.f1744).toString();
        aiVar.mo16117("public_api_call", "trackEvent", strArr);
        if (str != null) {
            AFSensorManager r8 = AFSensorManager.m1519(context);
            long currentTimeMillis = System.currentTimeMillis();
            if (r8.f1774 != 0) {
                r8.f1769++;
                if (r8.f1774 - currentTimeMillis < 500) {
                    r8.f1768.removeCallbacks(r8.f1778);
                    r8.f1768.post(r8.f1773);
                }
            } else {
                r8.f1768.post(r8.f1777);
                r8.f1768.post(r8.f1773);
            }
            r8.f1774 = currentTimeMillis;
        }
        mo16027(context2);
    }

    public void sendAdRevenue(Context context, Map<String, Object> map) {
        AFEvent context2 = new AdRevenue().context(context);
        context2.f1744 = map;
        Context context3 = context2.context();
        String url = ServerConfigHandler.getUrl(f1792);
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        sb.append(context3.getPackageName());
        String obj = sb.toString();
        SharedPreferences sharedPreferences = getSharedPreferences(context3);
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        int r4 = m1543(sharedPreferences, "appsFlyerAdRevenueCount", true);
        HashMap hashMap = new HashMap();
        hashMap.put("ad_network", context2.f1744);
        hashMap.put("adrevenue_counter", Integer.valueOf(r4));
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        hashMap.put("af_key", string);
        hashMap.put("launch_counter", Integer.valueOf(launchCounter));
        hashMap.put("af_timestamp", Long.toString(new Date().getTime()));
        hashMap.put("uid", C1676ae.m1619(new WeakReference(context3)));
        String string2 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        hashMap.put("advertiserIdEnabled", AppsFlyerProperties.getInstance().getString("advertiserIdEnabled"));
        if (string2 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string2);
        }
        hashMap.put("device", Build.DEVICE);
        m1552(context3, (Map<String, Object>) hashMap);
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context3.getPackageManager(), context3.getPackageName(), 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            long j = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("install_date", simpleDateFormat.format(new Date(j)));
            String string3 = sharedPreferences.getString("appsFlyerFirstInstall", (String) null);
            if (string3 == null) {
                string3 = m1576(simpleDateFormat, context3);
            }
            hashMap.put("first_launch_date", string3);
        } catch (Throwable th) {
            AFLogger.afErrorLog("AdRevenue - Exception while collecting app version data ", th);
        }
        AFEvent r12 = context2.urlString(obj).params(hashMap).mo15926();
        r12.f1738 = launchCounter;
        m1560(AFExecutor.getInstance().mo15930(), new C1659a(this, r12.key(string), (byte) 0), 1, TimeUnit.MILLISECONDS);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        trackEvent(context, str, map, (AppsFlyerTrackingRequestListener) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* renamed from: ǃ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo16027(com.appsflyer.AFEvent r7) {
        /*
            r6 = this;
            android.content.Context r0 = r7.context()
            boolean r1 = r0 instanceof android.app.Activity
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x001c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
            android.content.Intent r3 = r1.getIntent()
            android.net.Uri r1 = com.appsflyer.internal.ActivityCompat.getReferrer(r1)
            if (r1 == 0) goto L_0x001d
            java.lang.String r1 = r1.toString()
            goto L_0x001e
        L_0x001c:
            r3 = 0
        L_0x001d:
            r1 = r2
        L_0x001e:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = "AppsFlyerKey"
            java.lang.String r4 = r4.getString(r5)
            if (r4 != 0) goto L_0x0030
            java.lang.String r7 = "[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey."
            com.appsflyer.AFLogger.afWarnLog(r7)
            return
        L_0x0030:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r0 = r4.getReferrer(r0)
            if (r0 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r2 = r0
        L_0x003c:
            r7.f1735 = r2
            r7.f1736 = r3
            r7.f1746 = r1
            r6.m1568((com.appsflyer.AFEvent) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.mo16027(com.appsflyer.AFEvent):void");
    }

    /* renamed from: ɩ */
    public final void mo16029(Context context, String str) {
        if (m1581()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(packageManager, packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put(Const.InstantSP.INSTALL_DATE, simpleDateFormat.format(new Date(j)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m1578(context, (Map<String, ? super String>) hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        C1718w r2 = C1716v.m1695(context.getContentResolver());
        if (r2 != null) {
            hashMap.put("amazon_aid", r2.f2031);
            hashMap.put("amazon_aid_limit", String.valueOf(r2.mo16162()));
        }
        String string3 = AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM);
        if (string3 != null) {
            hashMap.put(ServerParameters.ADVERTISING_ID_PARAM, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", C1676ae.m1619(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(getLaunchCounter(getSharedPreferences(context), false)));
        hashMap.put("sdk", Integer.toString(Build.VERSION.SDK_INT));
        String configuredChannel = getConfiguredChannel(context);
        if (configuredChannel != null) {
            hashMap.put("channel", configuredChannel);
        }
        try {
            AFEvent context2 = new UninstallTokenEvent().trackingStopped(isTrackingStopped()).params(hashMap).context(context);
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(REGISTER_URL));
            sb.append(packageName);
            new Thread(new C1675ad((BackgroundEvent) context2.urlString(sb.toString()))).start();
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ı */
    public static Map<String, Object> m1531(Context context) throws C1722y {
        String string = getSharedPreferences(context).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return m1558(string);
        }
        throw new C1722y();
    }

    /* access modifiers changed from: protected */
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f1789 = new AppsFlyerConversionListener() {
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onConversionDataSuccess(Map<String, Object> map) {
                StringBuilder sb = new StringBuilder("Calling onConversionDataLoaded with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                ConversionDataListener.this.onConversionDataLoaded(map);
            }

            public final void onConversionDataFail(String str) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                ConversionDataListener.this.onConversionFailure(str);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ */
    public static Map<String, Object> m1558(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!f1794.contains(next)) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e) {
            AFLogger.afErrorLog(e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: ı */
    private void m1534(Context context, String str, String str2, Intent intent) {
        AFEvent context2 = new Launch().context(context);
        context2.f1748 = null;
        AFEvent key = context2.key(str);
        key.f1744 = null;
        key.f1735 = str2;
        key.f1736 = intent;
        key.f1746 = null;
        m1568(key);
    }

    /* renamed from: Ι */
    private void m1568(AFEvent aFEvent) {
        aFEvent.mo15926();
        boolean z = aFEvent.f1748 == null;
        if (m1581()) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (m1571()) {
                return;
            }
            this.f1801 = System.currentTimeMillis();
        }
        m1560(AFExecutor.getInstance().mo15930(), new C1662e(this, aFEvent.weakContext(), (byte) 0), 150, TimeUnit.MILLISECONDS);
    }

    /* renamed from: Ι */
    private boolean m1571() {
        if (this.f1801 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f1801;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j = this.f1801;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date(j));
            long j2 = this.f1795;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format2 = simpleDateFormat.format(new Date(j2));
            if (currentTimeMillis < this.f1808 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f1808)}));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ı */
    public void m1535(AFEvent aFEvent) {
        String str;
        ScheduledExecutorService scheduledExecutorService;
        Context context = aFEvent.context();
        String str2 = aFEvent.f1748;
        if (context == null) {
            AFLogger.afDebugLog("sendTrackingWithEvent - got null context. skipping event/launch.");
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("sendTrackingWithEvent from activity: ");
            sb.append(context.getClass().getName());
            AFLogger.afInfoLog(sb.toString());
        }
        boolean z = true;
        boolean z2 = false;
        boolean z3 = str2 == null;
        boolean z4 = aFEvent instanceof BackgroundReferrerLaunch;
        boolean z5 = aFEvent instanceof Attr;
        aFEvent.f1737 = z3;
        Map<String, Object> r7 = mo16028(aFEvent);
        String str3 = (String) r7.get("appsflyerKey");
        if (str3 == null || str3.length() == 0) {
            AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
            return;
        }
        if (!isTrackingStopped()) {
            AFLogger.afInfoLog("AppsFlyerLib.sendTrackingWithEvent");
        }
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        if (z5 || z4) {
            str = ServerConfigHandler.getUrl(REFERRER_TRACKING_URL);
        } else if (!z3) {
            str = ServerConfigHandler.getUrl(f1791);
        } else if (launchCounter < 2) {
            str = ServerConfigHandler.getUrl(FIRST_LAUNCHES_URL);
        } else {
            str = ServerConfigHandler.getUrl(f1790);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(context.getPackageName());
        String obj = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj);
        sb3.append("&buildnumber=5.4.0");
        String obj2 = sb3.toString();
        String configuredChannel = getConfiguredChannel(context);
        if (configuredChannel != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj2);
            sb4.append("&channel=");
            sb4.append(configuredChannel);
            obj2 = sb4.toString();
        }
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && r7.get(ServerParameters.ADVERTISING_ID_PARAM) != null) {
            try {
                if (TextUtils.isEmpty(this.f1813) && r7.remove("android_id") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(this.f1812) && r7.remove("imei") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e);
            }
        }
        AFEvent r10 = aFEvent.urlString(obj2).params(r7).mo15926();
        r10.f1738 = launchCounter;
        C1659a aVar = new C1659a(this, r10, (byte) 0);
        if (z3) {
            if (GoogleReferrer.allow(this, context) && !m1561()) {
                AFLogger.afDebugLog("Failed to get new referrer, wait ...");
                z2 = true;
            }
            HuaweiReferrer huaweiReferrer = this.f1819;
            if (huaweiReferrer != null && huaweiReferrer.valid()) {
                z2 = true;
            }
            if (this.f1816 && !m1538()) {
                AFLogger.afDebugLog("fetching Facebook deferred AppLink data, wait ...");
                z2 = true;
            }
            if (!this.f1818 || m1587()) {
                z = z2;
            }
        } else {
            z = false;
        }
        if (AFDeepLinkManager.f1729) {
            AFLogger.afRDLog("ESP deeplink: execute launch on SerialExecutor");
            AFExecutor instance2 = AFExecutor.getInstance();
            if (instance2.f1752 == null) {
                instance2.f1752 = Executors.newSingleThreadScheduledExecutor(instance2.f1751);
            }
            scheduledExecutorService = instance2.f1752;
        } else {
            scheduledExecutorService = AFExecutor.getInstance().mo15930();
        }
        m1560(scheduledExecutorService, aVar, z ? 500 : 0, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ı */
    private boolean m1540(AFEvent aFEvent, SharedPreferences sharedPreferences) {
        int launchCounter = getLaunchCounter(sharedPreferences, false);
        return (!sharedPreferences.getBoolean(AppsFlyerProperties.NEW_REFERRER_SENT, false) && launchCounter == 1) || (launchCounter == 1 && !(aFEvent instanceof Attr));
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ */
    public boolean m1561() {
        GoogleReferrer googleReferrer = this.f1810;
        return googleReferrer != null && googleReferrer.oldMap.size() > 0;
    }

    /* renamed from: ı */
    private boolean m1538() {
        Map<String, Object> map = this.f1811;
        return map != null && !map.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: і */
    public boolean m1587() {
        Map<String, Object> map = this.f1814;
        return map != null && !map.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x02f2 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0305 A[Catch:{ Exception -> 0x030b }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x034c A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0352 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0387 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03a0 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0431 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0446 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0447 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x045b A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0468 A[SYNTHETIC, Splitter:B:206:0x0468] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0486 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0495 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04a2 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04a8 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x04bf A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04d7 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x04ee A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x051c A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0538 A[SYNTHETIC, Splitter:B:243:0x0538] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0557 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x056a  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0573 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x05d3 A[SYNTHETIC, Splitter:B:287:0x05d3] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x05df A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x05ec A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x05f8 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x060f A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0625 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0642 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:330:0x0683 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x068d A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x06a3 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x06b1 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x06b3 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:342:0x06b6 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x06ba A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x06ef A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x070f A[SYNTHETIC, Splitter:B:366:0x070f] */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x07c9  */
    /* JADX WARNING: Removed duplicated region for block: B:445:0x087e A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0887 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:453:0x08b6 A[SYNTHETIC, Splitter:B:453:0x08b6] */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x08fd A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:471:0x0923 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x095a A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x095c A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x097a A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:484:0x098b A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:485:0x098c A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:488:0x09c7 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0b32 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0b4c A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* JADX WARNING: Removed duplicated region for block: B:515:0x0bb1 A[Catch:{ Exception -> 0x00b4, all -> 0x0bbd }] */
    /* renamed from: ɩ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.String, java.lang.Object> mo16028(com.appsflyer.AFEvent r31) {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            java.lang.String r3 = "appsflyerGetConversionDataTiming"
            java.lang.String r4 = "AppsFlyerTimePassedSincePrevLaunch"
            java.lang.String r5 = "yyyy-MM-dd_HHmmssZ"
            java.lang.String r6 = "use cached IMEI: "
            java.lang.String r7 = "uid"
            java.lang.String r8 = "appid"
            java.lang.String r9 = "INSTALL_STORE"
            java.lang.String r10 = "prev_event_name"
            java.lang.String r11 = "preInstallName"
            android.content.Context r12 = r31.context()
            java.lang.String r13 = r31.key()
            java.lang.String r14 = r2.f1748
            org.json.JSONObject r15 = new org.json.JSONObject
            r16 = r5
            java.util.Map<java.lang.String, java.lang.Object> r5 = r2.f1744
            if (r5 != 0) goto L_0x002e
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            goto L_0x0030
        L_0x002e:
            java.util.Map<java.lang.String, java.lang.Object> r5 = r2.f1744
        L_0x0030:
            r15.<init>(r5)
            java.lang.String r5 = r15.toString()
            java.lang.String r15 = r2.f1735
            r17 = r7
            android.content.SharedPreferences r7 = getSharedPreferences(r12)
            r18 = r6
            boolean r6 = r31.mo15927()
            r19 = r8
            android.content.Intent r8 = r31.intent()
            java.lang.String r2 = r2.f1746
            r31 = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.appsflyer.internal.C1716v.m1696(r12, r2)
            java.util.Date r20 = new java.util.Date
            r20.<init>()
            r22 = r8
            r21 = r9
            long r8 = r20.getTime()
            r20 = r13
            java.lang.String r13 = java.lang.Long.toString(r8)
            r23 = r11
            java.lang.String r11 = "af_timestamp"
            r2.put(r11, r13)
            java.lang.String r8 = com.appsflyer.internal.C1692c.m1653(r12, r8)
            if (r8 == 0) goto L_0x007c
            java.lang.String r9 = "cksm_v1"
            r2.put(r9, r8)
        L_0x007c:
            boolean r8 = r30.isTrackingStopped()     // Catch:{ all -> 0x0bbd }
            if (r8 != 0) goto L_0x009a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            java.lang.String r9 = "******* sendTrackingWithEvent: "
            r8.<init>(r9)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x008e
            java.lang.String r9 = "Launch"
            goto L_0x008f
        L_0x008e:
            r9 = r14
        L_0x008f:
            r8.append(r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ all -> 0x0bbd }
            goto L_0x009f
        L_0x009a:
            java.lang.String r8 = "SDK tracking has been stopped"
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ all -> 0x0bbd }
        L_0x009f:
            com.appsflyer.internal.C1671aa.m1608()     // Catch:{ all -> 0x0bbd }
            java.io.File r8 = com.appsflyer.internal.C1671aa.m1611(r12)     // Catch:{ Exception -> 0x00b4 }
            boolean r8 = r8.exists()     // Catch:{ Exception -> 0x00b4 }
            if (r8 != 0) goto L_0x00c4
            java.io.File r8 = com.appsflyer.internal.C1671aa.m1611(r12)     // Catch:{ Exception -> 0x00b4 }
            r8.mkdir()     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00c4
        L_0x00b4:
            java.lang.String r25 = "AppsFlyer_5.4.0"
            java.lang.String r26 = "Could not create cache directory"
            r24 = 4
            r27 = 0
            java.lang.String r28 = "com.appsflyer.AppsFlyerLibCore"
            r29 = 50332(0xc49c, float:7.053E-41)
            com.didi.sdk.apm.SystemUtils.log(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0bbd }
        L_0x00c4:
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r9 = r12.getPackageName()     // Catch:{ Exception -> 0x0100 }
            r13 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r8 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r8, r9, r13)     // Catch:{ Exception -> 0x0100 }
            java.lang.String[] r8 = r8.requestedPermissions     // Catch:{ Exception -> 0x0100 }
            java.util.List r8 = java.util.Arrays.asList(r8)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r9 = "android.permission.INTERNET"
            boolean r9 = r8.contains(r9)     // Catch:{ Exception -> 0x0100 }
            if (r9 != 0) goto L_0x00e5
            java.lang.String r9 = "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ Exception -> 0x0100 }
        L_0x00e5:
            java.lang.String r9 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r9 = r8.contains(r9)     // Catch:{ Exception -> 0x0100 }
            if (r9 != 0) goto L_0x00f2
            java.lang.String r9 = "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r9)     // Catch:{ Exception -> 0x0100 }
        L_0x00f2:
            java.lang.String r9 = "android.permission.ACCESS_WIFI_STATE"
            boolean r8 = r8.contains(r9)     // Catch:{ Exception -> 0x0100 }
            if (r8 != 0) goto L_0x0107
            java.lang.String r8 = "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
            com.appsflyer.AFLogger.afWarnLog(r8)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0107
        L_0x0100:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "Exception while validation permissions. "
            com.appsflyer.AFLogger.afErrorLog(r9, r8)     // Catch:{ all -> 0x0bbd }
        L_0x0107:
            java.lang.String r8 = "af_events_api"
            java.lang.String r9 = "1"
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "brand"
            java.lang.String r9 = android.os.Build.BRAND     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "device"
            java.lang.String r9 = android.os.Build.DEVICE     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "product"
            java.lang.String r9 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "sdk"
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0bbd }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "model"
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "deviceType"
            java.lang.String r9 = android.os.Build.TYPE     // Catch:{ all -> 0x0bbd }
            r2.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            m1552((android.content.Context) r12, (java.util.Map<java.lang.String, java.lang.Object>) r2)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            r9 = r14
            if (r6 == 0) goto L_0x023d
            boolean r10 = m1588((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            if (r10 == 0) goto L_0x0196
            boolean r10 = r8.isOtherSdkStringDisabled()     // Catch:{ all -> 0x0bbd }
            if (r10 != 0) goto L_0x015f
            float r10 = m1585((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r14 = "batteryLevel"
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0bbd }
            r2.put(r14, r10)     // Catch:{ all -> 0x0bbd }
        L_0x015f:
            m1559((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0bbd }
            r14 = 23
            if (r10 < r14) goto L_0x0171
            java.lang.Class<android.app.UiModeManager> r10 = android.app.UiModeManager.class
            java.lang.Object r10 = r12.getSystemService(r10)     // Catch:{ all -> 0x0bbd }
            android.app.UiModeManager r10 = (android.app.UiModeManager) r10     // Catch:{ all -> 0x0bbd }
            goto L_0x0179
        L_0x0171:
            java.lang.String r10 = "uimode"
            java.lang.Object r10 = r12.getSystemService(r10)     // Catch:{ all -> 0x0bbd }
            android.app.UiModeManager r10 = (android.app.UiModeManager) r10     // Catch:{ all -> 0x0bbd }
        L_0x0179:
            if (r10 == 0) goto L_0x0189
            int r10 = r10.getCurrentModeType()     // Catch:{ all -> 0x0bbd }
            r14 = 4
            if (r10 != r14) goto L_0x0189
            java.lang.String r10 = "tv"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0bbd }
            r2.put(r10, r14)     // Catch:{ all -> 0x0bbd }
        L_0x0189:
            boolean r10 = com.appsflyer.internal.instant.AFInstantApps.isInstantApp(r12)     // Catch:{ all -> 0x0bbd }
            if (r10 == 0) goto L_0x0196
            java.lang.String r10 = "inst_app"
            java.lang.Boolean r14 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0bbd }
            r2.put(r10, r14)     // Catch:{ all -> 0x0bbd }
        L_0x0196:
            java.lang.String r10 = "timepassedsincelastlaunch"
            android.content.SharedPreferences r14 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            r26 = r5
            r27 = r6
            r5 = 0
            long r28 = r14.getLong(r4, r5)     // Catch:{ all -> 0x0bbd }
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0bbd }
            m1577(r12, r4, r13)     // Catch:{ all -> 0x0bbd }
            int r4 = (r28 > r5 ? 1 : (r28 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x01b8
            long r13 = r13 - r28
            r24 = 1000(0x3e8, double:4.94E-321)
            long r13 = r13 / r24
            goto L_0x01ba
        L_0x01b8:
            r13 = -1
        L_0x01ba:
            java.lang.String r4 = java.lang.Long.toString(r13)     // Catch:{ all -> 0x0bbd }
            r2.put(r10, r4)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r10 = "oneLinkSlug"
            java.lang.String r4 = r4.getString(r10)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r13 = "onelinkVersion"
            java.lang.String r10 = r10.getString(r13)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x01dc
            java.lang.String r13 = "onelink_id"
            r2.put(r13, r4)     // Catch:{ all -> 0x0bbd }
        L_0x01dc:
            if (r10 == 0) goto L_0x01e3
            java.lang.String r4 = "onelink_ver"
            r2.put(r4, r10)     // Catch:{ all -> 0x0bbd }
        L_0x01e3:
            long r13 = r7.getLong(r3, r5)     // Catch:{ all -> 0x0bbd }
            int r4 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x01fe
            java.lang.String r4 = "gcd_timing"
            java.lang.String r10 = java.lang.Long.toString(r13)     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r10)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r4 = r7.edit()     // Catch:{ all -> 0x0bbd }
            r4.putLong(r3, r5)     // Catch:{ all -> 0x0bbd }
            r4.apply()     // Catch:{ all -> 0x0bbd }
        L_0x01fe:
            java.lang.String r3 = r1.f1820     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0209
            java.lang.String r3 = "phone"
            java.lang.String r4 = r1.f1820     // Catch:{ all -> 0x0bbd }
            r2.put(r3, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0209:
            boolean r3 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "referrer"
            if (r3 != 0) goto L_0x0214
            r2.put(r4, r15)     // Catch:{ all -> 0x0bbd }
        L_0x0214:
            java.lang.String r3 = "extraReferrers"
            r5 = 0
            java.lang.String r3 = r7.getString(r3, r5)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0222
            java.lang.String r5 = "extraReferrers"
            r2.put(r5, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0222:
            java.lang.String r3 = r8.getReferrer(r12)     // Catch:{ all -> 0x0bbd }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0bbd }
            if (r5 != 0) goto L_0x0235
            java.lang.Object r5 = r2.get(r4)     // Catch:{ all -> 0x0bbd }
            if (r5 != 0) goto L_0x0235
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0235:
            r28 = r7
            r29 = r8
            r3 = r26
            goto L_0x02ba
        L_0x023d:
            r26 = r5
            r27 = r6
            android.content.SharedPreferences r3 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ all -> 0x0bbd }
            r5 = 0
            java.lang.String r6 = r3.getString(r10, r5)     // Catch:{ Exception -> 0x02ad }
            java.lang.String r5 = "prev_event_timestamp"
            java.lang.String r13 = "prev_event_value"
            if (r6 == 0) goto L_0x0292
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0289 }
            r14.<init>()     // Catch:{ Exception -> 0x0289 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0289 }
            r15.<init>()     // Catch:{ Exception -> 0x0289 }
            r28 = r7
            r29 = r8
            r7 = -1
            long r7 = r3.getLong(r5, r7)     // Catch:{ Exception -> 0x0287 }
            r15.append(r7)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r7 = r15.toString()     // Catch:{ Exception -> 0x0287 }
            r14.put(r5, r7)     // Catch:{ Exception -> 0x0287 }
            r7 = 0
            java.lang.String r3 = r3.getString(r13, r7)     // Catch:{ Exception -> 0x0287 }
            r14.put(r13, r3)     // Catch:{ Exception -> 0x0287 }
            r14.put(r10, r6)     // Catch:{ Exception -> 0x0287 }
            java.lang.String r3 = "prev_event"
            java.lang.String r6 = r14.toString()     // Catch:{ Exception -> 0x0287 }
            r2.put(r3, r6)     // Catch:{ Exception -> 0x0287 }
            goto L_0x0296
        L_0x0287:
            r0 = move-exception
            goto L_0x028e
        L_0x0289:
            r0 = move-exception
            r28 = r7
            r29 = r8
        L_0x028e:
            r4 = r0
            r3 = r26
            goto L_0x02b5
        L_0x0292:
            r28 = r7
            r29 = r8
        L_0x0296:
            r4.putString(r10, r9)     // Catch:{ Exception -> 0x02ab }
            r3 = r26
            r4.putString(r13, r3)     // Catch:{ Exception -> 0x02a9 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02a9 }
            r4.putLong(r5, r6)     // Catch:{ Exception -> 0x02a9 }
            r4.apply()     // Catch:{ Exception -> 0x02a9 }
            goto L_0x02ba
        L_0x02a9:
            r0 = move-exception
            goto L_0x02b4
        L_0x02ab:
            r0 = move-exception
            goto L_0x02b2
        L_0x02ad:
            r0 = move-exception
            r28 = r7
            r29 = r8
        L_0x02b2:
            r3 = r26
        L_0x02b4:
            r4 = r0
        L_0x02b5:
            java.lang.String r5 = "Error while processing previous event."
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0bbd }
        L_0x02ba:
            java.lang.String r4 = "KSAppsFlyerId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r5 = "KSAppsFlyerRICounter"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r5 = r6.getString(r5)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x02e6
            if (r5 == 0) goto L_0x02e6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0bbd }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0bbd }
            if (r6 <= 0) goto L_0x02e6
            java.lang.String r6 = "reinstallCounter"
            r2.put(r6, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r5 = "originalAppsflyerId"
            r2.put(r5, r4)     // Catch:{ all -> 0x0bbd }
        L_0x02e6:
            java.lang.String r4 = "additionalCustomData"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x02f7
            java.lang.String r5 = "customData"
            r2.put(r5, r4)     // Catch:{ all -> 0x0bbd }
        L_0x02f7:
            android.content.pm.PackageManager r4 = r12.getPackageManager()     // Catch:{ Exception -> 0x030b }
            java.lang.String r5 = r12.getPackageName()     // Catch:{ Exception -> 0x030b }
            java.lang.String r4 = r4.getInstallerPackageName(r5)     // Catch:{ Exception -> 0x030b }
            if (r4 == 0) goto L_0x0312
            java.lang.String r5 = "installer_package"
            r2.put(r5, r4)     // Catch:{ Exception -> 0x030b }
            goto L_0x0312
        L_0x030b:
            r0 = move-exception
            r4 = r0
            java.lang.String r5 = "Exception while getting the app's installer package. "
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0312:
            java.lang.String r4 = "sdkExtension"
            r5 = r29
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0327
            int r6 = r4.length()     // Catch:{ all -> 0x0bbd }
            if (r6 <= 0) goto L_0x0327
            java.lang.String r6 = "sdkExtension"
            r2.put(r6, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0327:
            java.lang.String r4 = r1.getConfiguredChannel(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = m1545((android.content.Context) r12, (java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x0337
            boolean r7 = r6.equals(r4)     // Catch:{ all -> 0x0bbd }
            if (r7 == 0) goto L_0x033b
        L_0x0337:
            if (r6 != 0) goto L_0x0340
            if (r4 == 0) goto L_0x0340
        L_0x033b:
            java.lang.String r6 = "af_latestchannel"
            r2.put(r6, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0340:
            android.content.SharedPreferences r4 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            r6 = r21
            boolean r7 = r4.contains(r6)     // Catch:{ all -> 0x0bbd }
            if (r7 == 0) goto L_0x0352
            r7 = 0
            java.lang.String r4 = r4.getString(r6, r7)     // Catch:{ all -> 0x0bbd }
            goto L_0x0385
        L_0x0352:
            boolean r4 = m1588((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0376
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "api_store_value"
            java.lang.String r4 = r4.getString(r7)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0365
            goto L_0x0377
        L_0x0365:
            java.lang.String r4 = "AF_STORE"
            if (r12 == 0) goto L_0x0376
            android.content.pm.PackageManager r7 = r12.getPackageManager()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = m1556(r4, r7, r8)     // Catch:{ all -> 0x0bbd }
            goto L_0x0377
        L_0x0376:
            r4 = 0
        L_0x0377:
            android.content.SharedPreferences r7 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ all -> 0x0bbd }
            r7.putString(r6, r4)     // Catch:{ all -> 0x0bbd }
            r7.apply()     // Catch:{ all -> 0x0bbd }
        L_0x0385:
            if (r4 == 0) goto L_0x0390
            java.lang.String r6 = "af_installstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0390:
            android.content.SharedPreferences r4 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            r7 = r23
            java.lang.String r6 = r6.getString(r7)     // Catch:{ all -> 0x0bbd }
            if (r6 != 0) goto L_0x042f
            boolean r8 = r4.contains(r7)     // Catch:{ all -> 0x0bbd }
            if (r8 == 0) goto L_0x03ae
            r6 = 0
            java.lang.String r4 = r4.getString(r7, r6)     // Catch:{ all -> 0x0bbd }
            r6 = r4
            goto L_0x0426
        L_0x03ae:
            boolean r4 = m1588((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0416
            java.lang.String r4 = "ro.appsflyer.preinstall.path"
            java.lang.String r4 = m1530((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
            java.io.File r4 = m1563((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
            boolean r6 = m1562((java.io.File) r4)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x03d6
            java.lang.String r4 = "AF_PRE_INSTALL_PATH"
            android.content.pm.PackageManager r6 = r12.getPackageManager()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = m1556(r4, r6, r8)     // Catch:{ all -> 0x0bbd }
            java.io.File r4 = m1563((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
        L_0x03d6:
            boolean r6 = m1562((java.io.File) r4)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x03e2
            java.lang.String r4 = "/data/local/tmp/pre_install.appsflyer"
            java.io.File r4 = m1563((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
        L_0x03e2:
            boolean r6 = m1562((java.io.File) r4)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x03ee
            java.lang.String r4 = "/etc/pre_install.appsflyer"
            java.io.File r4 = m1563((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
        L_0x03ee:
            boolean r6 = m1562((java.io.File) r4)     // Catch:{ all -> 0x0bbd }
            if (r6 != 0) goto L_0x03ff
            java.lang.String r6 = r12.getPackageName()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = m1546((java.io.File) r4, (java.lang.String) r6)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x03ff
            goto L_0x0400
        L_0x03ff:
            r4 = 0
        L_0x0400:
            if (r4 == 0) goto L_0x0403
            goto L_0x0415
        L_0x0403:
            java.lang.String r4 = "AF_PRE_INSTALL_NAME"
            if (r12 != 0) goto L_0x0409
            r4 = 0
            goto L_0x0415
        L_0x0409:
            android.content.pm.PackageManager r6 = r12.getPackageManager()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r12.getPackageName()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = m1556(r4, r6, r8)     // Catch:{ all -> 0x0bbd }
        L_0x0415:
            r6 = r4
        L_0x0416:
            if (r6 == 0) goto L_0x0426
            android.content.SharedPreferences r4 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ all -> 0x0bbd }
            r4.putString(r7, r6)     // Catch:{ all -> 0x0bbd }
            r4.apply()     // Catch:{ all -> 0x0bbd }
        L_0x0426:
            if (r6 == 0) goto L_0x042f
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            r4.set((java.lang.String) r7, (java.lang.String) r6)     // Catch:{ all -> 0x0bbd }
        L_0x042f:
            if (r6 == 0) goto L_0x043a
            java.lang.String r4 = "af_preinstall_name"
            java.lang.String r6 = r6.toLowerCase()     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r6)     // Catch:{ all -> 0x0bbd }
        L_0x043a:
            com.appsflyer.AppsFlyerProperties r4 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "api_store_value"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0447
            goto L_0x0459
        L_0x0447:
            java.lang.String r4 = "AF_STORE"
            if (r12 != 0) goto L_0x044d
            r4 = 0
            goto L_0x0459
        L_0x044d:
            android.content.pm.PackageManager r6 = r12.getPackageManager()     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = r12.getPackageName()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = m1556(r4, r6, r7)     // Catch:{ all -> 0x0bbd }
        L_0x0459:
            if (r4 == 0) goto L_0x0464
            java.lang.String r6 = "af_currentstore"
            java.lang.String r4 = r4.toLowerCase()     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0464:
            java.lang.String r4 = "appsflyerKey"
            if (r20 == 0) goto L_0x0474
            int r6 = r20.length()     // Catch:{ all -> 0x0bbd }
            if (r6 <= 0) goto L_0x0474
            r6 = r20
            r2.put(r4, r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x0489
        L_0x0474:
            java.lang.String r6 = "AppsFlyerKey"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x0bb1
            int r7 = r6.length()     // Catch:{ all -> 0x0bbd }
            if (r7 <= 0) goto L_0x0bb1
            r2.put(r4, r6)     // Catch:{ all -> 0x0bbd }
        L_0x0489:
            java.lang.String r6 = "AppUserId"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x049a
            java.lang.String r7 = "appUserId"
            r2.put(r7, r6)     // Catch:{ all -> 0x0bbd }
        L_0x049a:
            java.lang.String r6 = "userEmails"
            java.lang.String r6 = r5.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x04a8
            java.lang.String r7 = "user_emails"
            r2.put(r7, r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x04bd
        L_0x04a8:
            java.lang.String r6 = "userEmail"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x04bd
            java.lang.String r7 = "sha1_el"
            java.lang.String r6 = com.appsflyer.internal.C1723z.m1705((java.lang.String) r6)     // Catch:{ all -> 0x0bbd }
            r2.put(r7, r6)     // Catch:{ all -> 0x0bbd }
        L_0x04bd:
            if (r9 == 0) goto L_0x04cb
            java.lang.String r6 = "eventName"
            r2.put(r6, r9)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x04cb
            java.lang.String r6 = "eventValue"
            r2.put(r6, r3)     // Catch:{ all -> 0x0bbd }
        L_0x04cb:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            r6 = r19
            java.lang.String r3 = r3.getString(r6)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x04e2
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r3.getString(r6)     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r3)     // Catch:{ all -> 0x0bbd }
        L_0x04e2:
            java.lang.String r3 = "currencyCode"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r6.getString(r3)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0510
            int r6 = r3.length()     // Catch:{ all -> 0x0bbd }
            r7 = 3
            if (r6 == r7) goto L_0x050b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "WARNING: currency code should be 3 characters!!! '"
            r6.<init>(r7)     // Catch:{ all -> 0x0bbd }
            r6.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "' is not a legal value."
            r6.append(r7)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0bbd }
        L_0x050b:
            java.lang.String r6 = "currency"
            r2.put(r6, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0510:
            java.lang.String r3 = "IS_UPDATE"
            com.appsflyer.AppsFlyerProperties r6 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r6.getString(r3)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0521
            java.lang.String r6 = "isUpdate"
            r2.put(r6, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0521:
            boolean r3 = r1.isPreInstalledApp(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "af_preinstalled"
            java.lang.String r3 = java.lang.Boolean.toString(r3)     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "collectFacebookAttrId"
            r6 = 1
            boolean r3 = r5.getBoolean(r3, r6)     // Catch:{ all -> 0x0bbd }
            r7 = 0
            if (r3 == 0) goto L_0x055c
            android.content.pm.PackageManager r3 = r12.getPackageManager()     // Catch:{ NameNotFoundException -> 0x054f, all -> 0x0546 }
            java.lang.String r8 = "com.facebook.katana"
            com.didi.sdk.apm.SystemUtils.getApplicationInfo(r3, r8, r7)     // Catch:{ NameNotFoundException -> 0x054f, all -> 0x0546 }
            java.lang.String r3 = r1.getAttributionId(r12)     // Catch:{ NameNotFoundException -> 0x054f, all -> 0x0546 }
            goto L_0x0555
        L_0x0546:
            r0 = move-exception
            r3 = r0
            java.lang.String r8 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x054d:
            r3 = 0
            goto L_0x0555
        L_0x054f:
            java.lang.String r3 = "Exception while collecting facebook's attribution ID. "
            com.appsflyer.AFLogger.afWarnLog(r3)     // Catch:{ all -> 0x0bbd }
            goto L_0x054d
        L_0x0555:
            if (r3 == 0) goto L_0x055c
            java.lang.String r8 = "fb"
            r2.put(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x055c:
            com.appsflyer.AppsFlyerProperties r3 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "deviceTrackingDisabled"
            boolean r8 = r3.getBoolean(r8, r7)     // Catch:{ all -> 0x0bbd }
            java.lang.String r10 = "true"
            if (r8 == 0) goto L_0x0573
            java.lang.String r3 = "deviceTrackingDisabled"
            r2.put(r3, r10)     // Catch:{ all -> 0x0bbd }
            r20 = r11
            goto L_0x0702
        L_0x0573:
            android.content.SharedPreferences r8 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r13 = "collectIMEI"
            boolean r13 = r3.getBoolean(r13, r6)     // Catch:{ all -> 0x0bbd }
            java.lang.String r14 = "imeiCached"
            r15 = 0
            java.lang.String r14 = r8.getString(r14, r15)     // Catch:{ all -> 0x0bbd }
            if (r13 == 0) goto L_0x0602
            java.lang.String r13 = r1.f1812     // Catch:{ all -> 0x0bbd }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0bbd }
            if (r13 == 0) goto L_0x0602
            boolean r13 = m1541((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            if (r13 == 0) goto L_0x05ff
            java.lang.String r13 = "phone"
            java.lang.Object r13 = r12.getSystemService(r13)     // Catch:{ InvocationTargetException -> 0x05e6, Exception -> 0x05cb }
            android.telephony.TelephonyManager r13 = (android.telephony.TelephonyManager) r13     // Catch:{ InvocationTargetException -> 0x05e6, Exception -> 0x05cb }
            java.lang.Class r15 = r13.getClass()     // Catch:{ InvocationTargetException -> 0x05e6, Exception -> 0x05cb }
            java.lang.String r6 = "getDeviceId"
            r20 = r11
            java.lang.Class[] r11 = new java.lang.Class[r7]     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            java.lang.reflect.Method r6 = r15.getMethod(r6, r11)     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            java.lang.Object[] r11 = new java.lang.Object[r7]     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            java.lang.Object r6 = r6.invoke(r13, r11)     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            if (r6 == 0) goto L_0x05b5
            goto L_0x060a
        L_0x05b5:
            if (r14 == 0) goto L_0x060c
            java.lang.String r6 = java.lang.String.valueOf(r14)     // Catch:{ InvocationTargetException -> 0x05e8, Exception -> 0x05c9 }
            r11 = r18
            java.lang.String r6 = r11.concat(r6)     // Catch:{ InvocationTargetException -> 0x05c7, Exception -> 0x05c5 }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ InvocationTargetException -> 0x05c7, Exception -> 0x05c5 }
            goto L_0x060d
        L_0x05c5:
            r0 = move-exception
            goto L_0x05d0
        L_0x05c7:
            goto L_0x05ea
        L_0x05c9:
            r0 = move-exception
            goto L_0x05ce
        L_0x05cb:
            r0 = move-exception
            r20 = r11
        L_0x05ce:
            r11 = r18
        L_0x05d0:
            r6 = r0
            if (r14 == 0) goto L_0x05df
            java.lang.String r13 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0bbd }
            java.lang.String r11 = r11.concat(r13)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afDebugLog(r11)     // Catch:{ all -> 0x0bbd }
            goto L_0x05e0
        L_0x05df:
            r14 = 0
        L_0x05e0:
            java.lang.String r11 = "WARNING: other reason: "
            com.appsflyer.AFLogger.afErrorLog(r11, r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x060d
        L_0x05e6:
            r20 = r11
        L_0x05e8:
            r11 = r18
        L_0x05ea:
            if (r14 == 0) goto L_0x05f8
            java.lang.String r6 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = r11.concat(r6)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x05f9
        L_0x05f8:
            r14 = 0
        L_0x05f9:
            java.lang.String r6 = "WARNING: READ_PHONE_STATE is missing."
            com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x060d
        L_0x05ff:
            r20 = r11
            goto L_0x060c
        L_0x0602:
            r20 = r11
            java.lang.String r6 = r1.f1812     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x060c
            java.lang.String r6 = r1.f1812     // Catch:{ all -> 0x0bbd }
        L_0x060a:
            r14 = r6
            goto L_0x060d
        L_0x060c:
            r14 = 0
        L_0x060d:
            if (r14 == 0) goto L_0x0625
            java.lang.String r6 = "imeiCached"
            android.content.SharedPreferences r11 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ all -> 0x0bbd }
            r11.putString(r6, r14)     // Catch:{ all -> 0x0bbd }
            r11.apply()     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "imei"
            r2.put(r6, r14)     // Catch:{ all -> 0x0bbd }
            goto L_0x062a
        L_0x0625:
            java.lang.String r6 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ all -> 0x0bbd }
        L_0x062a:
            java.lang.String r6 = "collectAndroidId"
            r11 = 1
            boolean r6 = r3.getBoolean(r6, r11)     // Catch:{ all -> 0x0bbd }
            java.lang.String r11 = "androidIdCached"
            r13 = 0
            java.lang.String r8 = r8.getString(r11, r13)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x0683
            java.lang.String r6 = r1.f1813     // Catch:{ all -> 0x0bbd }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x0683
            boolean r6 = m1541((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x068a
            android.content.ContentResolver r6 = r12.getContentResolver()     // Catch:{ Exception -> 0x0667 }
            java.lang.String r11 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r11)     // Catch:{ Exception -> 0x0667 }
            if (r6 == 0) goto L_0x0655
            goto L_0x068b
        L_0x0655:
            if (r8 == 0) goto L_0x0665
            java.lang.String r6 = "use cached AndroidId: "
            java.lang.String r11 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0667 }
            java.lang.String r6 = r6.concat(r11)     // Catch:{ Exception -> 0x0667 }
            com.appsflyer.AFLogger.afDebugLog(r6)     // Catch:{ Exception -> 0x0667 }
            goto L_0x0681
        L_0x0665:
            r8 = 0
            goto L_0x0681
        L_0x0667:
            r0 = move-exception
            r6 = r0
            if (r8 == 0) goto L_0x0679
            java.lang.String r11 = "use cached AndroidId: "
            java.lang.String r13 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r11 = r11.concat(r13)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afDebugLog(r11)     // Catch:{ all -> 0x0bbd }
            goto L_0x067a
        L_0x0679:
            r8 = 0
        L_0x067a:
            java.lang.String r11 = r6.getMessage()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afErrorLog(r11, r6)     // Catch:{ all -> 0x0bbd }
        L_0x0681:
            r6 = r8
            goto L_0x068b
        L_0x0683:
            java.lang.String r6 = r1.f1813     // Catch:{ all -> 0x0bbd }
            if (r6 == 0) goto L_0x068a
            java.lang.String r6 = r1.f1813     // Catch:{ all -> 0x0bbd }
            goto L_0x068b
        L_0x068a:
            r6 = 0
        L_0x068b:
            if (r6 == 0) goto L_0x06a3
            java.lang.String r8 = "androidIdCached"
            android.content.SharedPreferences r11 = getSharedPreferences(r12)     // Catch:{ all -> 0x0bbd }
            android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ all -> 0x0bbd }
            r11.putString(r8, r6)     // Catch:{ all -> 0x0bbd }
            r11.apply()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "android_id"
            r2.put(r8, r6)     // Catch:{ all -> 0x0bbd }
            goto L_0x06a8
        L_0x06a3:
            java.lang.String r6 = "Android ID was not collected."
            com.appsflyer.AFLogger.afInfoLog(r6)     // Catch:{ all -> 0x0bbd }
        L_0x06a8:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0bbd }
            r6.<init>()     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r1.f1805     // Catch:{ all -> 0x0bbd }
            if (r8 == 0) goto L_0x06b3
            r11 = 1
            goto L_0x06b4
        L_0x06b3:
            r11 = 0
        L_0x06b4:
            if (r11 == 0) goto L_0x06ba
            java.lang.String r3 = r1.f1805     // Catch:{ all -> 0x0bbd }
            r8 = r3
            goto L_0x06ed
        L_0x06ba:
            java.lang.String r8 = "collectOAID"
            r13 = 1
            boolean r8 = r3.getBoolean(r8, r13)     // Catch:{ all -> 0x0bbd }
            if (r8 == 0) goto L_0x06ec
            com.appsflyer.oaid.OaidClient r8 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x06e5 }
            r8.<init>(r12)     // Catch:{ all -> 0x06e5 }
            boolean r3 = r3.isEnableLog()     // Catch:{ all -> 0x06e5 }
            r8.setLogging(r3)     // Catch:{ all -> 0x06e5 }
            com.appsflyer.oaid.OaidClient$Info r3 = r8.fetch()     // Catch:{ all -> 0x06e5 }
            if (r3 == 0) goto L_0x06ec
            java.lang.String r8 = r3.getId()     // Catch:{ all -> 0x06e5 }
            java.lang.Boolean r3 = r3.getLat()     // Catch:{ all -> 0x06e6 }
            if (r3 == 0) goto L_0x06ed
            java.lang.String r13 = "isLat"
            r6.put(r13, r3)     // Catch:{ all -> 0x06e6 }
            goto L_0x06ed
        L_0x06e5:
            r8 = 0
        L_0x06e6:
            java.lang.String r3 = "No OAID library"
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x0bbd }
            goto L_0x06ed
        L_0x06ec:
            r8 = 0
        L_0x06ed:
            if (r8 == 0) goto L_0x0702
            java.lang.String r3 = "isManual"
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ all -> 0x0bbd }
            r6.put(r3, r11)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "val"
            r6.put(r3, r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "oaid"
            r2.put(r3, r6)     // Catch:{ all -> 0x0bbd }
        L_0x0702:
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0715 }
            r3.<init>(r12)     // Catch:{ Exception -> 0x0715 }
            java.lang.String r3 = com.appsflyer.internal.C1676ae.m1619(r3)     // Catch:{ Exception -> 0x0715 }
            r6 = r17
            if (r3 == 0) goto L_0x072e
            r2.put(r6, r3)     // Catch:{ Exception -> 0x0713 }
            goto L_0x072e
        L_0x0713:
            r0 = move-exception
            goto L_0x0718
        L_0x0715:
            r0 = move-exception
            r6 = r17
        L_0x0718:
            r3 = r0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            java.lang.String r11 = "ERROR: could not get uid "
            r8.<init>(r11)     // Catch:{ all -> 0x0bbd }
            java.lang.String r11 = r3.getMessage()     // Catch:{ all -> 0x0bbd }
            r8.append(r11)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x072e:
            java.lang.String r3 = "lang"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x073c }
            java.lang.String r8 = r8.getDisplayLanguage()     // Catch:{ Exception -> 0x073c }
            r2.put(r3, r8)     // Catch:{ Exception -> 0x073c }
            goto L_0x0743
        L_0x073c:
            r0 = move-exception
            r3 = r0
            java.lang.String r8 = "Exception while collecting display language name. "
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0743:
            java.lang.String r3 = "lang_code"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0751 }
            java.lang.String r8 = r8.getLanguage()     // Catch:{ Exception -> 0x0751 }
            r2.put(r3, r8)     // Catch:{ Exception -> 0x0751 }
            goto L_0x0758
        L_0x0751:
            r0 = move-exception
            r3 = r0
            java.lang.String r8 = "Exception while collecting display language code. "
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0758:
            java.lang.String r3 = "country"
            java.util.Locale r8 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0766 }
            java.lang.String r8 = r8.getCountry()     // Catch:{ Exception -> 0x0766 }
            r2.put(r3, r8)     // Catch:{ Exception -> 0x0766 }
            goto L_0x076d
        L_0x0766:
            r0 = move-exception
            r3 = r0
            java.lang.String r8 = "Exception while collecting country name. "
            com.appsflyer.AFLogger.afErrorLog(r8, r3)     // Catch:{ all -> 0x0bbd }
        L_0x076d:
            java.lang.String r3 = "platformextension"
            com.appsflyer.internal.ag r8 = r1.f1804     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = r8.mo16114()     // Catch:{ all -> 0x0bbd }
            r2.put(r3, r8)     // Catch:{ all -> 0x0bbd }
            m1578((android.content.Context) r12, (java.util.Map<java.lang.String, ? super java.lang.String>) r2)     // Catch:{ all -> 0x0bbd }
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0bbd }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0bbd }
            r11 = r16
            r3.<init>(r11, r8)     // Catch:{ all -> 0x0bbd }
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ Exception -> 0x07aa }
            java.lang.String r13 = r12.getPackageName()     // Catch:{ Exception -> 0x07aa }
            android.content.pm.PackageInfo r8 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r8, r13, r7)     // Catch:{ Exception -> 0x07aa }
            long r13 = r8.firstInstallTime     // Catch:{ Exception -> 0x07aa }
            java.lang.String r8 = "installDate"
            java.lang.String r15 = "UTC"
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r15)     // Catch:{ Exception -> 0x07aa }
            r3.setTimeZone(r15)     // Catch:{ Exception -> 0x07aa }
            java.util.Date r15 = new java.util.Date     // Catch:{ Exception -> 0x07aa }
            r15.<init>(r13)     // Catch:{ Exception -> 0x07aa }
            java.lang.String r13 = r3.format(r15)     // Catch:{ Exception -> 0x07aa }
            r2.put(r8, r13)     // Catch:{ Exception -> 0x07aa }
            goto L_0x07b1
        L_0x07aa:
            r0 = move-exception
            r8 = r0
            java.lang.String r13 = "Exception while collecting install date. "
            com.appsflyer.AFLogger.afErrorLog(r13, r8)     // Catch:{ all -> 0x0bbd }
        L_0x07b1:
            android.content.pm.PackageManager r8 = r12.getPackageManager()     // Catch:{ all -> 0x0852 }
            java.lang.String r13 = r12.getPackageName()     // Catch:{ all -> 0x0852 }
            android.content.pm.PackageInfo r8 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r8, r13, r7)     // Catch:{ all -> 0x0852 }
            java.lang.String r13 = "versionCode"
            r14 = r28
            int r13 = r14.getInt(r13, r7)     // Catch:{ all -> 0x084a }
            int r15 = r8.versionCode     // Catch:{ all -> 0x084a }
            if (r15 <= r13) goto L_0x07e6
            java.lang.String r13 = "versionCode"
            int r15 = r8.versionCode     // Catch:{ all -> 0x07dc }
            android.content.SharedPreferences r16 = getSharedPreferences(r12)     // Catch:{ all -> 0x07dc }
            android.content.SharedPreferences$Editor r7 = r16.edit()     // Catch:{ all -> 0x07dc }
            r7.putInt(r13, r15)     // Catch:{ all -> 0x07dc }
            r7.apply()     // Catch:{ all -> 0x07dc }
            goto L_0x07e6
        L_0x07dc:
            r0 = move-exception
            r3 = r0
            r16 = r4
            r29 = r5
            r18 = r6
            goto L_0x085c
        L_0x07e6:
            java.lang.String r7 = "app_version_code"
            int r13 = r8.versionCode     // Catch:{ all -> 0x084a }
            java.lang.String r13 = java.lang.Integer.toString(r13)     // Catch:{ all -> 0x084a }
            r2.put(r7, r13)     // Catch:{ all -> 0x084a }
            java.lang.String r7 = "app_version_name"
            java.lang.String r13 = r8.versionName     // Catch:{ all -> 0x084a }
            r2.put(r7, r13)     // Catch:{ all -> 0x084a }
            r13 = r6
            long r6 = r8.firstInstallTime     // Catch:{ all -> 0x0842 }
            r15 = r4
            r29 = r5
            long r4 = r8.lastUpdateTime     // Catch:{ all -> 0x083c }
            java.lang.String r8 = "date1"
            r16 = r15
            java.text.SimpleDateFormat r15 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x083a }
            r18 = r13
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0838 }
            r15.<init>(r11, r13)     // Catch:{ all -> 0x0838 }
            java.util.Date r13 = new java.util.Date     // Catch:{ all -> 0x0838 }
            r13.<init>(r6)     // Catch:{ all -> 0x0838 }
            java.lang.String r6 = r15.format(r13)     // Catch:{ all -> 0x0838 }
            r2.put(r8, r6)     // Catch:{ all -> 0x0838 }
            java.lang.String r6 = "date2"
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x0838 }
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0838 }
            r7.<init>(r11, r8)     // Catch:{ all -> 0x0838 }
            java.util.Date r8 = new java.util.Date     // Catch:{ all -> 0x0838 }
            r8.<init>(r4)     // Catch:{ all -> 0x0838 }
            java.lang.String r4 = r7.format(r8)     // Catch:{ all -> 0x0838 }
            r2.put(r6, r4)     // Catch:{ all -> 0x0838 }
            java.lang.String r3 = m1576((java.text.SimpleDateFormat) r3, (android.content.Context) r12)     // Catch:{ all -> 0x0838 }
            java.lang.String r4 = "firstLaunchDate"
            r2.put(r4, r3)     // Catch:{ all -> 0x0838 }
            goto L_0x0861
        L_0x0838:
            r0 = move-exception
            goto L_0x085b
        L_0x083a:
            r0 = move-exception
            goto L_0x0847
        L_0x083c:
            r0 = move-exception
            r18 = r13
            r16 = r15
            goto L_0x085b
        L_0x0842:
            r0 = move-exception
            r16 = r4
            r29 = r5
        L_0x0847:
            r18 = r13
            goto L_0x085b
        L_0x084a:
            r0 = move-exception
            r16 = r4
            r29 = r5
            r18 = r6
            goto L_0x085b
        L_0x0852:
            r0 = move-exception
            r16 = r4
            r29 = r5
            r18 = r6
            r14 = r28
        L_0x085b:
            r3 = r0
        L_0x085c:
            java.lang.String r4 = "Exception while collecting app version data "
            com.appsflyer.AFLogger.afErrorLog(r4, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0861:
            boolean r3 = com.appsflyer.internal.C1677af.m1621(r12)     // Catch:{ all -> 0x0bbd }
            r1.f1800 = r3     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "didConfigureTokenRefreshService="
            r3.<init>(r4)     // Catch:{ all -> 0x0bbd }
            boolean r4 = r1.f1800     // Catch:{ all -> 0x0bbd }
            r3.append(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afDebugLog(r3)     // Catch:{ all -> 0x0bbd }
            boolean r3 = r1.f1800     // Catch:{ all -> 0x0bbd }
            if (r3 != 0) goto L_0x0885
            java.lang.String r3 = "tokenRefreshConfigured"
            java.lang.Boolean r4 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0bbd }
            r2.put(r3, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0885:
            if (r27 == 0) goto L_0x08b2
            com.appsflyer.AFDeepLinkManager.getInstance()     // Catch:{ all -> 0x0bbd }
            r3 = r22
            com.appsflyer.AFDeepLinkManager.m1494(r3, r12, r2)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r1.f1798     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x08a8
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r1.f1798     // Catch:{ all -> 0x0bbd }
            r3.<init>(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "isPush"
            r3.put(r4, r10)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "af_deeplink"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
        L_0x08a8:
            r3 = 0
            r1.f1798 = r3     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "open_referrer"
            r4 = r31
            r2.put(r3, r4)     // Catch:{ all -> 0x0bbd }
        L_0x08b2:
            java.lang.String r3 = "sensors"
            if (r27 != 0) goto L_0x08f1
            com.appsflyer.AFSensorManager r4 = com.appsflyer.AFSensorManager.m1519((android.content.Context) r12)     // Catch:{ Exception -> 0x08da }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x08da }
            r5.<init>()     // Catch:{ Exception -> 0x08da }
            java.util.List r4 = r4.mo15942()     // Catch:{ Exception -> 0x08da }
            boolean r6 = r4.isEmpty()     // Catch:{ Exception -> 0x08da }
            if (r6 != 0) goto L_0x08d1
            java.util.Map r4 = com.appsflyer.internal.C1696g.m1675((java.util.List<java.util.Map<java.lang.String, java.lang.Object>>) r4)     // Catch:{ Exception -> 0x08da }
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08da }
            goto L_0x08d6
        L_0x08d1:
            java.lang.String r4 = "na"
            r5.put(r3, r4)     // Catch:{ Exception -> 0x08da }
        L_0x08d6:
            r2.putAll(r5)     // Catch:{ Exception -> 0x08da }
            goto L_0x08f1
        L_0x08da:
            r0 = move-exception
            r4 = r0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "Unexpected exception from AFSensorManager: "
            r5.<init>(r6)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0bbd }
            r5.append(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.AFLogger.afRDLog(r4)     // Catch:{ all -> 0x0bbd }
        L_0x08f1:
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0bbd }
            if (r4 != 0) goto L_0x0919
            com.appsflyer.internal.C1716v.m1696(r12, r2)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "advertiserId"
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0912
            java.lang.String r4 = "GAID_retry"
            r2.put(r4, r10)     // Catch:{ all -> 0x0bbd }
            goto L_0x0919
        L_0x0912:
            java.lang.String r4 = "GAID_retry"
            java.lang.String r5 = "false"
            r2.put(r4, r5)     // Catch:{ all -> 0x0bbd }
        L_0x0919:
            android.content.ContentResolver r4 = r12.getContentResolver()     // Catch:{ all -> 0x0bbd }
            com.appsflyer.internal.w r4 = com.appsflyer.internal.C1716v.m1695(r4)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0937
            java.lang.String r5 = "amazon_aid"
            java.lang.String r6 = r4.f2031     // Catch:{ all -> 0x0bbd }
            r2.put(r5, r6)     // Catch:{ all -> 0x0bbd }
            java.lang.String r5 = "amazon_aid_limit"
            boolean r4 = r4.mo16162()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0bbd }
            r2.put(r5, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0937:
            java.lang.String r4 = "sentRegisterRequestToAF"
            r5 = 0
            boolean r4 = r14.getBoolean(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r5 = "registeredUninstall"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0bbd }
            r2.put(r5, r4)     // Catch:{ all -> 0x0bbd }
            r4 = r27
            int r5 = r1.getLaunchCounter(r14, r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "counter"
            java.lang.String r7 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r7)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "iaecounter"
            if (r9 == 0) goto L_0x095c
            r11 = 1
            goto L_0x095d
        L_0x095c:
            r11 = 0
        L_0x095d:
            java.lang.String r7 = "appsFlyerInAppEventCount"
            int r7 = m1543((android.content.SharedPreferences) r14, (java.lang.String) r7, (boolean) r11)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x0bbd }
            r2.put(r6, r7)     // Catch:{ all -> 0x0bbd }
            r6 = 1
            if (r4 == 0) goto L_0x0983
            if (r5 != r6) goto L_0x0983
            r29.setFirstLaunchCalled()     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "waitForCustomerId"
            boolean r7 = m1583((java.lang.String) r7)     // Catch:{ all -> 0x0bbd }
            if (r7 == 0) goto L_0x0983
            java.lang.String r7 = "wait_cid"
            java.lang.String r8 = java.lang.Boolean.toString(r6)     // Catch:{ all -> 0x0bbd }
            r2.put(r7, r8)     // Catch:{ all -> 0x0bbd }
        L_0x0983:
            java.lang.String r7 = "isFirstCall"
            boolean r8 = m1539((android.content.SharedPreferences) r14)     // Catch:{ all -> 0x0bbd }
            if (r8 != 0) goto L_0x098c
            goto L_0x098d
        L_0x098c:
            r6 = 0
        L_0x098d:
            java.lang.String r6 = java.lang.Boolean.toString(r6)     // Catch:{ all -> 0x0bbd }
            r2.put(r7, r6)     // Catch:{ all -> 0x0bbd }
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x0bbd }
            r6.<init>()     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "cpu_abi"
            java.lang.String r8 = "ro.product.cpu.abi"
            java.lang.String r8 = m1530((java.lang.String) r8)     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "cpu_abi2"
            java.lang.String r8 = "ro.product.cpu.abi2"
            java.lang.String r8 = m1530((java.lang.String) r8)     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "arch"
            java.lang.String r8 = "os.arch"
            java.lang.String r8 = m1530((java.lang.String) r8)     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "build_display_id"
            java.lang.String r8 = "ro.build.display.id"
            java.lang.String r8 = m1530((java.lang.String) r8)     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r8)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0a51
            boolean r4 = r1.f1802     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0a0b
            com.appsflyer.internal.p r4 = com.appsflyer.internal.C1701p.C1702a.f2007     // Catch:{ all -> 0x0bbd }
            android.location.Location r4 = com.appsflyer.internal.C1701p.m1677(r12)     // Catch:{ all -> 0x0bbd }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0bbd }
            r8 = 3
            r7.<init>(r8)     // Catch:{ all -> 0x0bbd }
            if (r4 == 0) goto L_0x0a00
            java.lang.String r8 = "lat"
            double r9 = r4.getLatitude()     // Catch:{ all -> 0x0bbd }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0bbd }
            r7.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "lon"
            double r9 = r4.getLongitude()     // Catch:{ all -> 0x0bbd }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0bbd }
            r7.put(r8, r9)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = "ts"
            long r9 = r4.getTime()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0bbd }
            r7.put(r8, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0a00:
            boolean r4 = r7.isEmpty()     // Catch:{ all -> 0x0bbd }
            if (r4 != 0) goto L_0x0a0b
            java.lang.String r4 = "loc"
            r6.put(r4, r7)     // Catch:{ all -> 0x0bbd }
        L_0x0a0b:
            com.appsflyer.internal.b r4 = com.appsflyer.internal.C1689b.C1691e.f1951     // Catch:{ all -> 0x0bbd }
            com.appsflyer.internal.b$d r4 = r4.mo16135(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = "btl"
            float r8 = r4.f1949     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = java.lang.Float.toString(r8)     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r8)     // Catch:{ all -> 0x0bbd }
            java.lang.String r7 = r4.f1950     // Catch:{ all -> 0x0bbd }
            if (r7 == 0) goto L_0x0a27
            java.lang.String r7 = "btch"
            java.lang.String r4 = r4.f1950     // Catch:{ all -> 0x0bbd }
            r6.put(r7, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0a27:
            r4 = 2
            if (r5 > r4) goto L_0x0a51
            com.appsflyer.AFSensorManager r4 = com.appsflyer.AFSensorManager.m1519((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ all -> 0x0bbd }
            r5.<init>()     // Catch:{ all -> 0x0bbd }
            java.util.List r7 = r4.mo15944()     // Catch:{ all -> 0x0bbd }
            boolean r8 = r7.isEmpty()     // Catch:{ all -> 0x0bbd }
            if (r8 != 0) goto L_0x0a41
            r5.put(r3, r7)     // Catch:{ all -> 0x0bbd }
            goto L_0x0a4e
        L_0x0a41:
            java.util.List r4 = r4.mo15942()     // Catch:{ all -> 0x0bbd }
            boolean r7 = r4.isEmpty()     // Catch:{ all -> 0x0bbd }
            if (r7 != 0) goto L_0x0a4e
            r5.put(r3, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0a4e:
            r6.putAll(r5)     // Catch:{ all -> 0x0bbd }
        L_0x0a51:
            java.util.Map r3 = com.appsflyer.internal.C1703q.m1679(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "dim"
            r6.put(r4, r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "deviceData"
            r2.put(r3, r6)     // Catch:{ all -> 0x0bbd }
            r3 = r16
            java.lang.Object r4 = r2.get(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0bbd }
            r5 = r20
            java.lang.Object r6 = r2.get(r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0bbd }
            r7 = r18
            java.lang.Object r8 = r2.get(r7)     // Catch:{ all -> 0x0bbd }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r9.<init>()     // Catch:{ all -> 0x0bbd }
            r10 = 7
            r11 = 0
            java.lang.String r4 = r4.substring(r11, r10)     // Catch:{ all -> 0x0bbd }
            r9.append(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r8.substring(r11, r10)     // Catch:{ all -> 0x0bbd }
            r9.append(r4)     // Catch:{ all -> 0x0bbd }
            int r4 = r6.length()     // Catch:{ all -> 0x0bbd }
            int r4 = r4 - r10
            java.lang.String r4 = r6.substring(r4)     // Catch:{ all -> 0x0bbd }
            r9.append(r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = com.appsflyer.internal.C1723z.m1705((java.lang.String) r4)     // Catch:{ all -> 0x0bbd }
            java.lang.String r6 = "af_v"
            r2.put(r6, r4)     // Catch:{ all -> 0x0bbd }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r4.<init>()     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.Object r3 = r2.get(r5)     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r4.<init>()     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.Object r3 = r2.get(r7)     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r4.<init>()     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "installDate"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r4.<init>()     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "counter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0bbd }
            r4.<init>()     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "iaecounter"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x0bbd }
            r4.append(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = com.appsflyer.internal.C1723z.m1703(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = com.appsflyer.internal.C1723z.m1705((java.lang.String) r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "af_v2"
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
            boolean r3 = m1565((android.content.Context) r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "ivc"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "is_stop_tracking_used"
            boolean r3 = r14.contains(r3)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0b42
            java.lang.String r3 = "istu"
            java.lang.String r4 = "is_stop_tracking_used"
            r5 = 0
            boolean r4 = r14.getBoolean(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0bbd }
            r2.put(r3, r4)     // Catch:{ all -> 0x0bbd }
        L_0x0b42:
            java.lang.String r3 = "consumeAfDeepLink"
            r4 = r29
            java.lang.Object r3 = r4.getObject(r3)     // Catch:{ all -> 0x0bbd }
            if (r3 == 0) goto L_0x0b5c
            java.lang.String r3 = "consumeAfDeepLink"
            r5 = 0
            boolean r3 = r4.getBoolean(r3, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "is_dp_api"
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
        L_0x0b5c:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0bbd }
            r3.<init>()     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "mcc"
            android.content.res.Resources r5 = r12.getResources()     // Catch:{ all -> 0x0bbd }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0bbd }
            int r5 = r5.mcc     // Catch:{ all -> 0x0bbd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0bbd }
            r3.put(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "mnc"
            android.content.res.Resources r5 = r12.getResources()     // Catch:{ all -> 0x0bbd }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0bbd }
            int r5 = r5.mnc     // Catch:{ all -> 0x0bbd }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0bbd }
            r3.put(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "cell"
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
            com.appsflyer.internal.EventDataCollector r3 = new com.appsflyer.internal.EventDataCollector     // Catch:{ all -> 0x0bbd }
            r3.<init>(r12)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "sig"
            java.lang.String r5 = r3.signature()     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "last_boot_time"
            long r5 = r3.bootTime()     // Catch:{ all -> 0x0bbd }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r5)     // Catch:{ all -> 0x0bbd }
            java.lang.String r4 = "disk"
            java.lang.String r3 = r3.disk()     // Catch:{ all -> 0x0bbd }
            r2.put(r4, r3)     // Catch:{ all -> 0x0bbd }
            goto L_0x0bc6
        L_0x0bb1:
            java.lang.String r3 = "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. "
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0bbd }
            java.lang.String r3 = "AppsFlyer will not track this event."
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ all -> 0x0bbd }
            r2 = 0
            return r2
        L_0x0bbd:
            r0 = move-exception
            r3 = r0
            java.lang.String r4 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.afErrorLog(r4, r3)
        L_0x0bc6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.mo16028(com.appsflyer.AFEvent):java.util.Map");
    }

    /* renamed from: ı */
    public static boolean m1539(SharedPreferences sharedPreferences) {
        return Boolean.parseBoolean(sharedPreferences.getString("sentSuccessfully", (String) null));
    }

    /* renamed from: ǃ */
    private static void m1552(Context context, Map<String, Object> map) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            map.put("sc_o", rotation != 0 ? rotation != 1 ? rotation != 2 ? rotation != 3 ? "" : "lr" : "pr" : "l" : RavenConfigKey.PHONE);
        }
    }

    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    /* access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        String str;
        String obj = uri.toString();
        if (obj == null) {
            obj = null;
        } else if (obj.matches("fb\\d*?://authorize.*") && obj.contains("access_token")) {
            int indexOf = obj.indexOf(63);
            if (indexOf == -1) {
                str = "";
            } else {
                str = obj.substring(indexOf);
            }
            if (str.length() != 0) {
                ArrayList arrayList = new ArrayList();
                if (str.contains(ParamKeys.SIGN_AND)) {
                    arrayList = new ArrayList(Arrays.asList(str.split(ParamKeys.SIGN_AND)));
                } else {
                    arrayList.add(str);
                }
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (str2.contains("access_token")) {
                        it.remove();
                    } else {
                        if (sb.length() != 0) {
                            sb.append(ParamKeys.SIGN_AND);
                        } else if (!str2.startsWith("?")) {
                            sb.append("?");
                        }
                        sb.append(str2);
                    }
                }
                obj = obj.replace(str, sb.toString());
            }
        }
        if (!map.containsKey("af_deeplink")) {
            map.put("af_deeplink", obj);
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("link", uri.toString());
        final WeakReference weakReference = new WeakReference(context);
        C1672ab abVar = new C1672ab(uri, this);
        abVar.setConnProvider(new OneLinkHttpTask.HttpsUrlConnectionProvider());
        if (abVar.mo16110()) {
            abVar.f1894 = new C1672ab.C1673b() {
                /* renamed from: ı */
                public final void mo16037(String str) {
                    if (AppsFlyerLibCore.f1789 != null) {
                        m1599(hashMap);
                        AFLogger.afDebugLog("Calling onAttributionFailure with:\n".concat(String.valueOf(str)));
                        AppsFlyerLibCore.f1789.onAttributionFailure(str);
                    }
                }

                /* renamed from: ι */
                private void m1599(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        AppsFlyerLibCore.m1551((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                /* renamed from: ɩ */
                public final void mo16038(Map<String, String> map) {
                    for (String next : map.keySet()) {
                        hashMap.put(next, map.get(next));
                    }
                    m1599(hashMap);
                    AppsFlyerLibCore.m1570((Map<String, String>) hashMap);
                }
            };
            AFExecutor.getInstance().getThreadPoolExecutor().execute(abVar);
            return;
        }
        m1570(AndroidUtils.m1527(context, hashMap, uri));
    }

    /* access modifiers changed from: private */
    /* renamed from: Ι */
    public static void m1570(Map<String, String> map) {
        if (f1789 != null) {
            try {
                StringBuilder sb = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb.append(map.toString());
                AFLogger.afDebugLog(sb.toString());
                f1789.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ι */
    private static boolean m1582(Context context) {
        try {
            if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), "com.google.android.gms", 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e);
            return false;
        }
    }

    /* renamed from: Ɩ */
    private static boolean m1541(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m1582(context)) {
            return true;
        }
        return false;
    }

    /* renamed from: Ӏ */
    private static boolean m1588(Context context) {
        return !getSharedPreferences(context).contains("appsFlyerCount");
    }

    /* renamed from: ı */
    private static String m1530(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: ɩ */
    private static String m1556(String str, PackageManager packageManager, String str2) {
        Object obj;
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(packageManager, str2, 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            String obj2 = obj.toString();
            if (!obj2.replaceAll("\\p{C}", "").equals(obj2)) {
                StringBuilder sb = new StringBuilder("Manifest meta-data ");
                sb.append(str);
                sb.append(": ");
                sb.append(obj2);
                sb.append(" contains non-printing characters");
                AFLogger.afWarnLog(sb.toString());
            }
            return obj2;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Could not find ");
            sb2.append(str);
            sb2.append(" value in the manifest");
            AFLogger.afErrorLog(sb2.toString(), th);
            return null;
        }
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        if (str != null) {
            try {
                jSONObject.put("pid", str);
            } catch (JSONException e) {
                AFLogger.afErrorLog(e.getMessage(), e);
            }
        }
        if (str2 != null) {
            jSONObject.put("c", str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has("pid")) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031 A[SYNTHETIC, Splitter:B:16:0x0031] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0028=Splitter:B:13:0x0028, B:22:0x003f=Splitter:B:22:0x003f} */
    /* renamed from: ǃ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m1546(java.io.File r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.Properties r1 = new java.util.Properties     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003e, all -> 0x0026 }
            r1.load(r2)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            java.lang.String r4 = r1.getProperty(r5)     // Catch:{ FileNotFoundException -> 0x003f, all -> 0x0024 }
            r2.close()     // Catch:{ all -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0023:
            return r4
        L_0x0024:
            r4 = move-exception
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r0
        L_0x0028:
            java.lang.String r5 = r4.getMessage()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afErrorLog(r5, r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
            goto L_0x0059
        L_0x0035:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            goto L_0x0059
        L_0x003e:
            r2 = r0
        L_0x003f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "PreInstall file wasn't found: "
            r5.<init>(r1)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.getAbsolutePath()     // Catch:{ all -> 0x005a }
            r5.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x005a }
            com.appsflyer.AFLogger.afDebugLog(r4)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x0059:
            return r0
        L_0x005a:
            r4 = move-exception
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r5)
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m1546(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: ɩ */
    private static boolean m1562(File file) {
        return file == null || !file.exists();
    }

    /* renamed from: ɹ */
    private static File m1563(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (str.trim().length() > 0) {
                return new File(str.trim());
            }
            return null;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    public String getConfiguredChannel(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("channel");
        if (string == null) {
            string = context == null ? null : m1556("CHANNEL", context.getPackageManager(), context.getPackageName());
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            if ((SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ǃ */
    public static String m1545(Context context, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", (String) null);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString("CACHED_CHANNEL", str);
        edit.apply();
        return str;
    }

    /* renamed from: ι */
    private static String m1576(SimpleDateFormat simpleDateFormat, Context context) {
        String str;
        String string = getSharedPreferences(context).getString("appsFlyerFirstInstall", (String) null);
        if (string == null) {
            if (m1588(context)) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            } else {
                str = "";
            }
            string = str;
            SharedPreferences.Editor edit = getSharedPreferences(context).edit();
            edit.putString("appsFlyerFirstInstall", string);
            edit.apply();
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string)));
        return string;
    }

    public String getAttributionId(Context context) {
        try {
            return new C1674ac(context).mo16111();
        } catch (Throwable th) {
            AFLogger.afErrorLog("Could not collect facebook attribution id. ", th);
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return SystemUtils.getSharedPreferences(context.getApplicationContext(), "appsflyer-data", 0);
    }

    public final int getLaunchCounter(SharedPreferences sharedPreferences, boolean z) {
        return m1543(sharedPreferences, "appsFlyerCount", z);
    }

    /* renamed from: ǃ */
    private static int m1543(SharedPreferences sharedPreferences, String str, boolean z) {
        int i = sharedPreferences.getInt(str, 0);
        if (z) {
            i++;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        if (C1683ai.f1911.mo16124()) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16120(String.valueOf(i));
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: ɩ */
    public static void m1560(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    public boolean isTrackingStopped() {
        return this.f1807;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[SYNTHETIC, Splitter:B:23:0x0054] */
    /* renamed from: ǃ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String mo16025(java.net.HttpURLConnection r8) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.io.InputStream r2 = r8.getErrorStream()     // Catch:{ all -> 0x0037 }
            if (r2 != 0) goto L_0x0010
            java.io.InputStream r2 = r8.getInputStream()     // Catch:{ all -> 0x0037 }
        L_0x0010:
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0037 }
            r3.<init>(r2)     // Catch:{ all -> 0x0037 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0035 }
            r2.<init>(r3)     // Catch:{ all -> 0x0035 }
        L_0x001a:
            java.lang.String r1 = r2.readLine()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0029
            r0.append(r1)     // Catch:{ all -> 0x0030 }
            r1 = 10
            r0.append(r1)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x0029:
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x002c:
            r3.close()     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x0030:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0039
        L_0x0035:
            r2 = move-exception
            goto L_0x0039
        L_0x0037:
            r2 = move-exception
            r3 = r1
        L_0x0039:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            java.lang.String r5 = "Could not read connection response from: "
            r4.<init>(r5)     // Catch:{ all -> 0x007d }
            java.net.URL r8 = r8.getURL()     // Catch:{ all -> 0x007d }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x007d }
            r4.append(r8)     // Catch:{ all -> 0x007d }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x007d }
            com.appsflyer.AFLogger.afErrorLog(r8, r2)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ all -> 0x005a }
        L_0x0057:
            if (r3 == 0) goto L_0x005a
            goto L_0x002c
        L_0x005a:
            java.lang.String r8 = r0.toString()
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0064 }
            return r8
        L_0x0064:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "string_response"
            r0.put(r1, r8)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x0073 }
            return r8
        L_0x0073:
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            java.lang.String r8 = r8.toString()
            return r8
        L_0x007d:
            r8 = move-exception
            if (r1 == 0) goto L_0x0083
            r1.close()     // Catch:{ all -> 0x0088 }
        L_0x0083:
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ all -> 0x0088 }
        L_0x0088:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.mo16025(java.net.HttpURLConnection):java.lang.String");
    }

    /* renamed from: і */
    private static float m1585(Context context) {
        Intent intent;
        try {
            intent = null;
            intent = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return 1.0f;
        }
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra(NNGestureClassfy.SCALE_LABLE, -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return 50.0f;
        }
        return (((float) intExtra) / ((float) intExtra2)) * 100.0f;
    }

    /* renamed from: ɹ */
    private static boolean m1565(Context context) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e);
                }
            } else if (Build.VERSION.SDK_INT >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Failed collecting ivc data", e2);
                }
            }
        }
        return false;
    }

    public void setLogLevel(AFLogger.LogLevel logLevel) {
        boolean z = logLevel.getLevel() > AFLogger.LogLevel.NONE.getLevel();
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "log", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setMinTimeBetweenSessions(int i) {
        this.f1808 = TimeUnit.SECONDS.toMillis((long) i);
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$e */
    class C1662e implements Runnable {

        /* renamed from: ı */
        private AFEvent f1850;

        /* synthetic */ C1662e(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1662e(AFEvent aFEvent) {
            this.f1850 = aFEvent;
        }

        public final void run() {
            AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
            AFEvent aFEvent = this.f1850;
            aFEvent.f1745 = aFEvent.f1734.get();
            appsFlyerLibCore.m1535(aFEvent);
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$a */
    class C1659a implements Runnable {

        /* renamed from: ɩ */
        private final AFEvent f1838;

        /* synthetic */ C1659a(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent, byte b) {
            this(aFEvent);
        }

        private C1659a(AFEvent aFEvent) {
            this.f1838 = aFEvent.weakContext();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0236, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x023e, code lost:
            if (r1 != null) goto L_0x0240;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0243, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0168, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0169, code lost:
            com.appsflyer.AFLogger.afErrorLog(r0.getMessage(), r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0170, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0171, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0183, code lost:
            com.appsflyer.internal.C1671aa.m1608();
            r3 = new com.appsflyer.internal.C1700j(r2, r6, "5.4.0");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            r2 = com.appsflyer.internal.C1671aa.m1611(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0195, code lost:
            if (r2.exists() == false) goto L_0x0197;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0197, code lost:
            r2.mkdir();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x019c, code lost:
            r2 = r2.listFiles();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a0, code lost:
            if (r2 == null) goto L_0x01b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a7, code lost:
            com.didi.sdk.apm.SystemUtils.log(4, com.appsflyer.AppsFlyerLibCore.LOG_TAG, "reached cache limit, not caching request", (java.lang.Throwable) null, "com.appsflyer.AppsFlyerLibCore$a", 5067);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b6, code lost:
            com.didi.sdk.apm.SystemUtils.log(4, com.appsflyer.AppsFlyerLibCore.LOG_TAG, "caching request...", (java.lang.Throwable) null, "com.appsflyer.AppsFlyerLibCore$a", 5070);
            r2 = new java.io.File(com.appsflyer.internal.C1671aa.m1611(r4), java.lang.Long.toString(java.lang.System.currentTimeMillis()));
            r2.createNewFile();
            r4 = new java.io.OutputStreamWriter(new java.io.FileOutputStream(r2.getPath(), true));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            r4.write("version=");
            r4.write(r3.f1994);
            r4.write(10);
            r4.write("url=");
            r4.write(r3.f1992);
            r4.write(10);
            r4.write("data=");
            r4.write(android.util.Base64.encodeToString(r3.mo16138(), 2));
            r4.write(10);
            r4.flush();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x021d, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x021e, code lost:
            r1 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0220, code lost:
            r1 = r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0222, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
            com.didi.sdk.apm.SystemUtils.log(4, com.appsflyer.AppsFlyerLibCore.LOG_TAG, "Could not cache request", (java.lang.Throwable) null, "com.appsflyer.AppsFlyerLibCore$a", 5089);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x0231, code lost:
            if (r1 != null) goto L_0x0233;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x0240 A[SYNTHETIC, Splitter:B:104:0x0240] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0168 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:34:0x0107] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0233 A[SYNTHETIC, Splitter:B:99:0x0233] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r15 = this;
                com.appsflyer.AFEvent r0 = r15.f1838
                java.util.Map r0 = r0.params()
                com.appsflyer.AFEvent r1 = r15.f1838
                boolean r1 = r1.mo15927()
                com.appsflyer.AFEvent r2 = r15.f1838
                java.lang.String r2 = r2.urlString()
                com.appsflyer.AFEvent r3 = r15.f1838
                int r3 = r3.f1738
                com.appsflyer.AFEvent r4 = r15.f1838
                android.content.Context r4 = r4.context()
                com.appsflyer.AppsFlyerLibCore r5 = com.appsflyer.AppsFlyerLibCore.this
                boolean r5 = r5.isTrackingStopped()
                if (r5 == 0) goto L_0x0025
                return
            L_0x0025:
                r5 = 0
                byte[] r6 = new byte[r5]
                r7 = 2
                r8 = 1
                if (r1 == 0) goto L_0x00f8
                if (r3 > r7) goto L_0x00f8
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                boolean r9 = r9.m1561()
                if (r9 == 0) goto L_0x0064
                java.lang.String r9 = "rfr"
                com.appsflyer.AppsFlyerLibCore r10 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.GoogleReferrer r10 = r10.f1810
                java.util.Map<java.lang.String, java.lang.Object> r10 = r10.oldMap
                r0.put(r9, r10)
                android.content.SharedPreferences r9 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r4)
                android.content.SharedPreferences$Editor r9 = r9.edit()
                java.lang.String r10 = "newGPReferrerSent"
                android.content.SharedPreferences$Editor r9 = r9.putBoolean(r10, r8)
                r9.apply()
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.GoogleReferrer r9 = r9.f1810
                java.util.Map<java.lang.String, java.lang.Object> r9 = r9.newMap
                r1.add(r9)
            L_0x0064:
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f1819
                if (r9 == 0) goto L_0x00a7
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f1819
                java.util.Map<java.lang.String, java.lang.Object> r9 = r9.map
                if (r9 == 0) goto L_0x007a
                r1.add(r9)
                goto L_0x00a7
            L_0x007a:
                com.appsflyer.AppsFlyerLibCore r9 = com.appsflyer.AppsFlyerLibCore.this
                com.appsflyer.internal.referrer.HuaweiReferrer r9 = r9.f1819
                boolean r9 = r9.valid()
                if (r9 == 0) goto L_0x00a7
                if (r3 != r7) goto L_0x00a7
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r9 = "source"
                java.lang.String r10 = "huawei"
                r3.put(r9, r10)
                java.lang.String r9 = "response"
                java.lang.String r10 = "TIMEOUT"
                r3.put(r9, r10)
                com.appsflyer.internal.referrer.MandatoryFields r9 = new com.appsflyer.internal.referrer.MandatoryFields
                r9.<init>()
                r3.putAll(r9)
                r1.add(r3)
            L_0x00a7:
                boolean r3 = r1.isEmpty()
                if (r3 != 0) goto L_0x00b2
                java.lang.String r3 = "referrers"
                r0.put(r3, r1)
            L_0x00b2:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f1811
                if (r1 == 0) goto L_0x00c5
                java.lang.String r1 = "fb_ddl"
                com.appsflyer.AppsFlyerLibCore r3 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r3 = r3.f1811
                r0.put(r1, r3)
            L_0x00c5:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.m1587()
                if (r1 == 0) goto L_0x00d9
                java.lang.String r1 = "lvl"
                com.appsflyer.AppsFlyerLibCore r3 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r3 = r3.f1814
                r0.put(r1, r3)
                goto L_0x00f8
            L_0x00d9:
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                boolean r1 = r1.f1818
                if (r1 == 0) goto L_0x00f8
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.util.Map unused = r1.f1814 = r3
                com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.this
                java.util.Map r1 = r1.f1814
                java.lang.String r3 = "error"
                java.lang.String r9 = "operation timed out."
                r1.put(r3, r9)
            L_0x00f8:
                com.appsflyer.AFEvent r1 = r15.f1838
                boolean r1 = r1 instanceof com.appsflyer.internal.model.event.AdRevenue
                if (r1 != 0) goto L_0x0106
                com.appsflyer.internal.c$a r1 = new com.appsflyer.internal.c$a
                r1.<init>(r0, r4)
                r0.putAll(r1)
            L_0x0106:
                r1 = 0
                com.appsflyer.AFEvent r3 = r15.f1838     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                com.appsflyer.AFEvent r9 = r15.f1838     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                boolean r9 = r9 instanceof com.appsflyer.internal.model.event.AdRevenue     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                if (r9 == 0) goto L_0x0118
                java.lang.String r9 = "af_key"
                java.lang.Object r9 = r0.get(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                goto L_0x0120
            L_0x0118:
                java.lang.String r9 = "appsflyerKey"
                java.lang.Object r9 = r0.get(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
            L_0x0120:
                r3.key(r9)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                monitor-enter(r0)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                com.appsflyer.AFEvent r3 = r15.f1838     // Catch:{ all -> 0x0165 }
                java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x015c }
                r9[r5] = r3     // Catch:{ all -> 0x015c }
                r3 = 48
                r10 = 11758(0x2dee, float:1.6476E-41)
                r11 = 24
                java.lang.Object r3 = com.appsflyer.internal.C1695d.m1671(r3, r10, r11)     // Catch:{ all -> 0x015c }
                java.lang.Class r3 = (java.lang.Class) r3     // Catch:{ all -> 0x015c }
                java.lang.String r10 = "ɩ"
                java.lang.Class[] r11 = new java.lang.Class[r8]     // Catch:{ all -> 0x015c }
                java.lang.Class<com.appsflyer.AFEvent> r12 = com.appsflyer.AFEvent.class
                r11[r5] = r12     // Catch:{ all -> 0x015c }
                java.lang.reflect.Method r3 = r3.getMethod(r10, r11)     // Catch:{ all -> 0x015c }
                java.lang.Object r3 = r3.invoke(r1, r9)     // Catch:{ all -> 0x015c }
                byte[] r3 = (byte[]) r3     // Catch:{ all -> 0x015c }
                monitor-exit(r0)     // Catch:{ all -> 0x0159 }
                com.appsflyer.AppsFlyerLibCore r0 = com.appsflyer.AppsFlyerLibCore.this     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AFEvent r5 = r15.f1838     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AFEvent r5 = r5.post(r3)     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                com.appsflyer.AppsFlyerLibCore.m1536((com.appsflyer.AppsFlyerLibCore) r0, (com.appsflyer.AFEvent) r5)     // Catch:{ IOException -> 0x0156, all -> 0x0168 }
                return
            L_0x0156:
                r0 = move-exception
                r6 = r3
                goto L_0x0172
            L_0x0159:
                r5 = move-exception
                r6 = r3
                goto L_0x0166
            L_0x015c:
                r3 = move-exception
                java.lang.Throwable r5 = r3.getCause()     // Catch:{ all -> 0x0165 }
                if (r5 == 0) goto L_0x0164
                throw r5     // Catch:{ all -> 0x0165 }
            L_0x0164:
                throw r3     // Catch:{ all -> 0x0165 }
            L_0x0165:
                r5 = move-exception
            L_0x0166:
                monitor-exit(r0)     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
                throw r5     // Catch:{ IOException -> 0x0171, all -> 0x0168 }
            L_0x0168:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                return
            L_0x0171:
                r0 = move-exception
            L_0x0172:
                java.lang.String r3 = "Exception while sending request to server. "
                com.appsflyer.AFLogger.afErrorLog(r3, r0)
                if (r6 == 0) goto L_0x0244
                if (r4 == 0) goto L_0x0244
                java.lang.String r3 = "&isCachedRequest=true&timeincache="
                boolean r3 = r2.contains(r3)
                if (r3 != 0) goto L_0x0244
                com.appsflyer.internal.C1671aa.m1608()
                com.appsflyer.internal.j r3 = new com.appsflyer.internal.j
                java.lang.String r5 = "5.4.0"
                r3.<init>(r2, r6, r5)
                java.io.File r2 = com.appsflyer.internal.C1671aa.m1611(r4)     // Catch:{ Exception -> 0x0224 }
                boolean r5 = r2.exists()     // Catch:{ Exception -> 0x0224 }
                if (r5 != 0) goto L_0x019c
                r2.mkdir()     // Catch:{ Exception -> 0x0224 }
                goto L_0x0236
            L_0x019c:
                java.io.File[] r2 = r2.listFiles()     // Catch:{ Exception -> 0x0224 }
                if (r2 == 0) goto L_0x01b6
                int r2 = r2.length     // Catch:{ Exception -> 0x0224 }
                r5 = 40
                if (r2 <= r5) goto L_0x01b6
                java.lang.String r10 = "AppsFlyer_5.4.0"
                java.lang.String r11 = "reached cache limit, not caching request"
                r9 = 4
                r12 = 0
                java.lang.String r13 = "com.appsflyer.AppsFlyerLibCore$a"
                r14 = 5067(0x13cb, float:7.1E-42)
                com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0224 }
                goto L_0x0236
            L_0x01b6:
                java.lang.String r10 = "AppsFlyer_5.4.0"
                java.lang.String r11 = "caching request..."
                r9 = 4
                r12 = 0
                java.lang.String r13 = "com.appsflyer.AppsFlyerLibCore$a"
                r14 = 5070(0x13ce, float:7.105E-42)
                com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0224 }
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0224 }
                java.io.File r4 = com.appsflyer.internal.C1671aa.m1611(r4)     // Catch:{ Exception -> 0x0224 }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0224 }
                java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ Exception -> 0x0224 }
                r2.<init>(r4, r5)     // Catch:{ Exception -> 0x0224 }
                r2.createNewFile()     // Catch:{ Exception -> 0x0224 }
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0224 }
                java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0224 }
                java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x0224 }
                r5.<init>(r2, r8)     // Catch:{ Exception -> 0x0224 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0224 }
                java.lang.String r1 = "version="
                r4.write(r1)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                java.lang.String r1 = r3.f1994     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.write(r1)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r1 = 10
                r4.write(r1)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                java.lang.String r2 = "url="
                r4.write(r2)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                java.lang.String r2 = r3.f1992     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.write(r2)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.write(r1)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                java.lang.String r2 = "data="
                r4.write(r2)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                byte[] r2 = r3.mo16138()     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                java.lang.String r2 = android.util.Base64.encodeToString(r2, r7)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.write(r2)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.write(r1)     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.flush()     // Catch:{ Exception -> 0x0220, all -> 0x021d }
                r4.close()     // Catch:{ IOException -> 0x0236 }
                goto L_0x0236
            L_0x021d:
                r0 = move-exception
                r1 = r4
                goto L_0x023e
            L_0x0220:
                r1 = r4
                goto L_0x0224
            L_0x0222:
                r0 = move-exception
                goto L_0x023e
            L_0x0224:
                java.lang.String r3 = "AppsFlyer_5.4.0"
                java.lang.String r4 = "Could not cache request"
                r2 = 4
                r5 = 0
                java.lang.String r6 = "com.appsflyer.AppsFlyerLibCore$a"
                r7 = 5089(0x13e1, float:7.131E-42)
                com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0222 }
                if (r1 == 0) goto L_0x0236
                r1.close()     // Catch:{ IOException -> 0x0236 }
            L_0x0236:
                java.lang.String r1 = r0.getMessage()
                com.appsflyer.AFLogger.afErrorLog(r1, r0)
                goto L_0x0244
            L_0x023e:
                if (r1 == 0) goto L_0x0243
                r1.close()     // Catch:{ IOException -> 0x0243 }
            L_0x0243:
                throw r0
            L_0x0244:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C1659a.run():void");
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$b */
    static class C1660b implements Runnable {

        /* renamed from: ı */
        private static String f1840 = "https://%sgcdsdk.%s/install_data/v4.0/";

        /* renamed from: ι */
        private static final List<String> f1841 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});

        /* renamed from: ǃ */
        private final String f1842;

        /* renamed from: ɩ */
        private final Application f1843;

        /* renamed from: ɹ */
        private AppsFlyerLibCore f1844;

        /* renamed from: Ι */
        final ScheduledExecutorService f1845;

        /* renamed from: І */
        private final AtomicInteger f1846;

        /* renamed from: і */
        private final int f1847;

        /* synthetic */ C1660b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str, byte b) {
            this(appsFlyerLibCore, application, str);
        }

        private C1660b(AppsFlyerLibCore appsFlyerLibCore, Application application, String str) {
            this.f1845 = AFExecutor.getInstance().mo15930();
            this.f1846 = new AtomicInteger(0);
            this.f1844 = appsFlyerLibCore;
            this.f1843 = application;
            this.f1842 = str;
            this.f1847 = 0;
        }

        private C1660b(C1660b bVar) {
            this.f1845 = AFExecutor.getInstance().mo15930();
            this.f1846 = new AtomicInteger(0);
            this.f1844 = bVar.f1844;
            this.f1843 = bVar.f1843;
            this.f1842 = bVar.f1842;
            this.f1847 = bVar.f1847 + 1;
        }

        /* renamed from: Ι */
        private void m1602(String str, int i) {
            if (500 > i || i >= 600) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                AppsFlyerLibCore.f1789.onConversionDataFail(str);
            } else if (this.f1847 == 2) {
                AFLogger.afDebugLog("Calling onConversionFailure with:\n".concat(String.valueOf(str)));
                AppsFlyerLibCore.f1789.onConversionDataFail(str);
            } else {
                C1660b bVar = new C1660b(this);
                AppsFlyerLibCore.m1560(bVar.f1845, bVar, 10, TimeUnit.MILLISECONDS);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x00a5 A[Catch:{ all -> 0x0273 }] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1 A[Catch:{ y -> 0x0243, all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0110 A[Catch:{ y -> 0x0243, all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0160 A[Catch:{ y -> 0x0243, all -> 0x0270 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x026c  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x027a A[Catch:{ all -> 0x0298 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x028f A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r14 = this;
                java.lang.String r0 = "is_first_launch"
                java.lang.String r1 = "af_siteid"
                java.lang.String r2 = r14.f1842
                if (r2 == 0) goto L_0x02a4
                int r2 = r2.length()
                if (r2 != 0) goto L_0x0010
                goto L_0x02a4
            L_0x0010:
                com.appsflyer.AppsFlyerLibCore r2 = r14.f1844
                boolean r2 = r2.isTrackingStopped()
                if (r2 == 0) goto L_0x0019
                return
            L_0x0019:
                java.util.concurrent.atomic.AtomicInteger r2 = r14.f1846
                r2.incrementAndGet()
                r2 = 0
                r3 = 0
                android.app.Application r4 = r14.f1843     // Catch:{ all -> 0x0273 }
                if (r4 != 0) goto L_0x002a
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f1846
                r0.decrementAndGet()
                return
            L_0x002a:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0273 }
                android.app.Application r6 = r14.f1843     // Catch:{ all -> 0x0273 }
                com.appsflyer.AppsFlyerLibCore r7 = r14.f1844     // Catch:{ all -> 0x0273 }
                android.app.Application r8 = r14.f1843     // Catch:{ all -> 0x0273 }
                java.lang.String r7 = r7.getConfiguredChannel(r8)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = com.appsflyer.AppsFlyerLibCore.m1545((android.content.Context) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0273 }
                java.lang.String r7 = ""
                r8 = 1
                if (r6 == 0) goto L_0x0065
                java.util.List<java.lang.String> r9 = f1841     // Catch:{ all -> 0x0273 }
                java.lang.String r10 = r6.toLowerCase()     // Catch:{ all -> 0x0273 }
                boolean r9 = r9.contains(r10)     // Catch:{ all -> 0x0273 }
                if (r9 != 0) goto L_0x0058
                java.lang.String r9 = "-"
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = r9.concat(r6)     // Catch:{ all -> 0x0273 }
                goto L_0x0066
            L_0x0058:
                java.lang.String r9 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
                java.lang.Object[] r10 = new java.lang.Object[r8]     // Catch:{ all -> 0x0273 }
                r10[r3] = r6     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x0273 }
                com.appsflyer.AFLogger.afWarnLog(r6)     // Catch:{ all -> 0x0273 }
            L_0x0065:
                r6 = r7
            L_0x0066:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0273 }
                r9.<init>()     // Catch:{ all -> 0x0273 }
                java.lang.String r10 = f1840     // Catch:{ all -> 0x0273 }
                java.lang.String r10 = com.appsflyer.ServerConfigHandler.getUrl(r10)     // Catch:{ all -> 0x0273 }
                r9.append(r10)     // Catch:{ all -> 0x0273 }
                android.app.Application r10 = r14.f1843     // Catch:{ all -> 0x0273 }
                java.lang.String r10 = r10.getPackageName()     // Catch:{ all -> 0x0273 }
                r9.append(r10)     // Catch:{ all -> 0x0273 }
                r9.append(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = "?devkey="
                r9.append(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = r14.f1842     // Catch:{ all -> 0x0273 }
                r9.append(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = "&device_id="
                r9.append(r6)     // Catch:{ all -> 0x0273 }
                java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0273 }
                android.app.Application r10 = r14.f1843     // Catch:{ all -> 0x0273 }
                r6.<init>(r10)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = com.appsflyer.internal.C1676ae.m1619(r6)     // Catch:{ all -> 0x0273 }
                r9.append(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x0273 }
                com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0273 }
                if (r9 != 0) goto L_0x00ac
                com.appsflyer.internal.ai r9 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0273 }
                r9.<init>()     // Catch:{ all -> 0x0273 }
                com.appsflyer.internal.C1683ai.f1911 = r9     // Catch:{ all -> 0x0273 }
            L_0x00ac:
                com.appsflyer.internal.ai r9 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0273 }
                java.lang.String r10 = "server_request"
                java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ all -> 0x0273 }
                r9.mo16117(r10, r6, r7)     // Catch:{ all -> 0x0273 }
                java.lang.String r7 = "Calling server for attribution url: "
                java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0273 }
                java.lang.String r7 = r7.concat(r9)     // Catch:{ all -> 0x0273 }
                com.appsflyer.internal.C1682ah.m1629(r7)     // Catch:{ all -> 0x0273 }
                java.net.URL r7 = new java.net.URL     // Catch:{ all -> 0x0273 }
                r7.<init>(r6)     // Catch:{ all -> 0x0273 }
                java.net.URLConnection r7 = r7.openConnection()     // Catch:{ all -> 0x0273 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x0273 }
                java.lang.String r2 = "GET"
                r7.setRequestMethod(r2)     // Catch:{ all -> 0x0270 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "Connection"
                java.lang.String r9 = "close"
                r7.setRequestProperty(r2, r9)     // Catch:{ all -> 0x0270 }
                r7.connect()     // Catch:{ all -> 0x0270 }
                int r2 = r7.getResponseCode()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerLibCore r9 = r14.f1844     // Catch:{ all -> 0x0270 }
                java.lang.String r9 = r9.mo16025((java.net.HttpURLConnection) r7)     // Catch:{ all -> 0x0270 }
                com.appsflyer.internal.ai r10 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0270 }
                if (r10 != 0) goto L_0x00f8
                com.appsflyer.internal.ai r10 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0270 }
                r10.<init>()     // Catch:{ all -> 0x0270 }
                com.appsflyer.internal.C1683ai.f1911 = r10     // Catch:{ all -> 0x0270 }
            L_0x00f8:
                com.appsflyer.internal.ai r10 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0270 }
                java.lang.String r11 = "server_response"
                r12 = 2
                java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ all -> 0x0270 }
                java.lang.String r13 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0270 }
                r12[r3] = r13     // Catch:{ all -> 0x0270 }
                r12[r8] = r9     // Catch:{ all -> 0x0270 }
                r10.mo16117(r11, r6, r12)     // Catch:{ all -> 0x0270 }
                r10 = 200(0xc8, float:2.8E-43)
                r11 = 404(0x194, float:5.66E-43)
                if (r2 == r10) goto L_0x0141
                if (r2 != r11) goto L_0x0113
                goto L_0x0141
            L_0x0113:
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f1789     // Catch:{ all -> 0x0270 }
                if (r0 == 0) goto L_0x0126
                java.lang.String r0 = "Error connection to server: "
                java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x0270 }
                r14.m1602(r0, r2)     // Catch:{ all -> 0x0270 }
            L_0x0126:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = "AttributionIdFetcher response code: "
                r0.<init>(r1)     // Catch:{ all -> 0x0270 }
                r0.append(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = "  url: "
                r0.append(r1)     // Catch:{ all -> 0x0270 }
                r0.append(r6)     // Catch:{ all -> 0x0270 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0270 }
                com.appsflyer.internal.C1682ah.m1629(r0)     // Catch:{ all -> 0x0270 }
                goto L_0x0265
            L_0x0141:
                long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0270 }
                android.app.Application r6 = r14.f1843     // Catch:{ all -> 0x0270 }
                java.lang.String r10 = "appsflyerGetConversionDataTiming"
                long r12 = r12 - r4
                com.appsflyer.AppsFlyerLibCore.m1577(r6, r10, r12)     // Catch:{ all -> 0x0270 }
                java.lang.String r4 = "Attribution data: "
                java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0270 }
                java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0270 }
                com.appsflyer.internal.C1682ah.m1629(r4)     // Catch:{ all -> 0x0270 }
                int r4 = r9.length()     // Catch:{ all -> 0x0270 }
                if (r4 <= 0) goto L_0x0265
                java.util.Map r4 = com.appsflyer.AppsFlyerLibCore.m1558((java.lang.String) r9)     // Catch:{ all -> 0x0270 }
                java.lang.String r5 = "iscache"
                java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x0270 }
                java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0270 }
                if (r2 != r11) goto L_0x0186
                java.lang.String r2 = "error_reason"
                r4.remove(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "status_code"
                r4.remove(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "af_status"
                java.lang.String r6 = "Organic"
                r4.put(r2, r6)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "af_message"
                java.lang.String r6 = "organic install"
                r4.put(r2, r6)     // Catch:{ all -> 0x0270 }
            L_0x0186:
                if (r5 == 0) goto L_0x0199
                boolean r2 = r5.booleanValue()     // Catch:{ all -> 0x0270 }
                if (r2 != 0) goto L_0x0199
                android.app.Application r2 = r14.f1843     // Catch:{ all -> 0x0270 }
                java.lang.String r6 = "appsflyerConversionDataCacheExpiration"
                long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerLibCore.m1577(r2, r6, r10)     // Catch:{ all -> 0x0270 }
            L_0x0199:
                boolean r2 = r4.containsKey(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r6 = "[Invite] Detected App-Invite via channel: "
                java.lang.String r10 = "af_channel"
                if (r2 == 0) goto L_0x01ce
                boolean r2 = r4.containsKey(r10)     // Catch:{ all -> 0x0270 }
                if (r2 == 0) goto L_0x01bd
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
                r2.<init>(r6)     // Catch:{ all -> 0x0270 }
                java.lang.Object r11 = r4.get(r10)     // Catch:{ all -> 0x0270 }
                r2.append(r11)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0270 }
                goto L_0x01ce
            L_0x01bd:
                java.lang.String r2 = "[CrossPromotion] App was installed via %s's Cross Promotion"
                java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ all -> 0x0270 }
                java.lang.Object r12 = r4.get(r1)     // Catch:{ all -> 0x0270 }
                r11[r3] = r12     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = java.lang.String.format(r2, r11)     // Catch:{ all -> 0x0270 }
                com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0270 }
            L_0x01ce:
                boolean r1 = r4.containsKey(r1)     // Catch:{ all -> 0x0270 }
                if (r1 == 0) goto L_0x01e7
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
                r1.<init>(r6)     // Catch:{ all -> 0x0270 }
                java.lang.Object r2 = r4.get(r10)     // Catch:{ all -> 0x0270 }
                r1.append(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0270 }
            L_0x01e7:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0270 }
                r4.put(r0, r1)     // Catch:{ all -> 0x0270 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0270 }
                r1.<init>(r4)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "attributionId"
                if (r1 == 0) goto L_0x01ff
                android.app.Application r6 = r14.f1843     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerLibCore.m1551((android.content.Context) r6, (java.lang.String) r2, (java.lang.String) r1)     // Catch:{ all -> 0x0270 }
                goto L_0x0204
            L_0x01ff:
                android.app.Application r1 = r14.f1843     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerLibCore.m1551((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r9)     // Catch:{ all -> 0x0270 }
            L_0x0204:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = "iscache="
                r1.<init>(r2)     // Catch:{ all -> 0x0270 }
                r1.append(r5)     // Catch:{ all -> 0x0270 }
                java.lang.String r2 = " caching conversion data"
                r1.append(r2)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f1789     // Catch:{ all -> 0x0270 }
                if (r1 == 0) goto L_0x0265
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f1846     // Catch:{ all -> 0x0270 }
                int r1 = r1.intValue()     // Catch:{ all -> 0x0270 }
                if (r1 > r8) goto L_0x0265
                android.app.Application r1 = r14.f1843     // Catch:{ y -> 0x0243 }
                java.util.Map r1 = com.appsflyer.AppsFlyerLibCore.m1531((android.content.Context) r1)     // Catch:{ y -> 0x0243 }
                android.app.Application r2 = r14.f1843     // Catch:{ y -> 0x0243 }
                android.content.SharedPreferences r2 = com.appsflyer.AppsFlyerLibCore.getSharedPreferences(r2)     // Catch:{ y -> 0x0243 }
                java.lang.String r5 = "sixtyDayConversionData"
                boolean r2 = r2.getBoolean(r5, r3)     // Catch:{ y -> 0x0243 }
                if (r2 != 0) goto L_0x0241
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ y -> 0x0243 }
                r1.put(r0, r2)     // Catch:{ y -> 0x0243 }
            L_0x0241:
                r4 = r1
                goto L_0x0249
            L_0x0243:
                r0 = move-exception
                java.lang.String r1 = "Exception while trying to fetch attribution data. "
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x0270 }
            L_0x0249:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = "Calling onConversionDataSuccess with:\n"
                r0.<init>(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0270 }
                r0.append(r1)     // Catch:{ all -> 0x0270 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0270 }
                com.appsflyer.AFLogger.afDebugLog(r0)     // Catch:{ all -> 0x0270 }
                com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.AppsFlyerLibCore.f1789     // Catch:{ all -> 0x0270 }
                r0.onConversionDataSuccess(r4)     // Catch:{ all -> 0x0270 }
            L_0x0265:
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f1846
                r0.decrementAndGet()
                if (r7 == 0) goto L_0x0292
                r7.disconnect()
                goto L_0x0292
            L_0x0270:
                r0 = move-exception
                r2 = r7
                goto L_0x0274
            L_0x0273:
                r0 = move-exception
            L_0x0274:
                com.appsflyer.AppsFlyerConversionListener r1 = com.appsflyer.AppsFlyerLibCore.f1789     // Catch:{ all -> 0x0298 }
                if (r1 == 0) goto L_0x0281
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0298 }
                r14.m1602(r1, r3)     // Catch:{ all -> 0x0298 }
            L_0x0281:
                java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x0298 }
                com.appsflyer.AFLogger.afErrorLog(r1, r0)     // Catch:{ all -> 0x0298 }
                java.util.concurrent.atomic.AtomicInteger r0 = r14.f1846
                r0.decrementAndGet()
                if (r2 == 0) goto L_0x0292
                r2.disconnect()
            L_0x0292:
                java.util.concurrent.ScheduledExecutorService r0 = r14.f1845
                r0.shutdown()
                return
            L_0x0298:
                r0 = move-exception
                java.util.concurrent.atomic.AtomicInteger r1 = r14.f1846
                r1.decrementAndGet()
                if (r2 == 0) goto L_0x02a3
                r2.disconnect()
            L_0x02a3:
                throw r0
            L_0x02a4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.C1660b.run():void");
        }
    }

    /* renamed from: com.appsflyer.AppsFlyerLibCore$c */
    class C1661c implements Runnable {

        /* renamed from: ι */
        private WeakReference<Context> f1849 = null;

        public C1661c(Context context) {
            this.f1849 = new WeakReference<>(context);
        }

        public final void run() {
            if (!AppsFlyerLibCore.this.f1817) {
                AppsFlyerLibCore.this.f1821 = System.currentTimeMillis();
                if (this.f1849 != null) {
                    boolean unused = AppsFlyerLibCore.this.f1817 = true;
                    try {
                        String r1 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        synchronized (this.f1849) {
                            C1671aa.m1608();
                            for (C1700j next : C1671aa.m1609(this.f1849.get())) {
                                StringBuilder sb = new StringBuilder("resending request: ");
                                sb.append(next.f1992);
                                AFLogger.afInfoLog(sb.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(next.f1993, 10);
                                    AppsFlyerLibCore appsFlyerLibCore = AppsFlyerLibCore.this;
                                    CachedEvent cachedEvent = new CachedEvent();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(next.f1992);
                                    sb2.append("&isCachedRequest=true&timeincache=");
                                    sb2.append((currentTimeMillis - parseLong) / 1000);
                                    AFEvent key = cachedEvent.urlString(sb2.toString()).post(next.mo16138()).key(r1);
                                    key.f1734 = this.f1849;
                                    key.f1741 = next.f1993;
                                    key.f1737 = false;
                                    AppsFlyerLibCore.m1536(appsFlyerLibCore, key);
                                } catch (Exception e) {
                                    AFLogger.afErrorLog("Failed to resend cached request", e);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        try {
                            AFLogger.afErrorLog("failed to check cache. ", e2);
                        } catch (Throwable th) {
                            boolean unused2 = AppsFlyerLibCore.this.f1817 = false;
                            throw th;
                        }
                    }
                    boolean unused3 = AppsFlyerLibCore.this.f1817 = false;
                    AppsFlyerLibCore.this.f1796.shutdown();
                    ScheduledExecutorService unused4 = AppsFlyerLibCore.this.f1796 = null;
                }
            }
        }
    }

    public String getSdkVersion() {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "getSdkVersion", new String[0]);
        StringBuilder sb = new StringBuilder("version: 5.4.0 (build ");
        sb.append(f1788);
        sb.append(")");
        return sb.toString();
    }

    public void setImeiData(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setImeiData", str);
        this.f1812 = str;
    }

    public void setOaidData(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setOaidData", str);
        this.f1805 = str;
    }

    public void setAndroidIdData(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setAndroidIdData", str);
        this.f1813 = str;
    }

    public void setAppInviteOneLink(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_ID, str);
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            if (C1683ai.f1911 == null) {
                C1683ai.f1911 = new C1683ai();
            }
            C1683ai.f1911.mo16117("public_api_call", "setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    public void setUserEmails(String... strArr) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setUserEmails", strArr);
        setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, strArr);
    }

    public void setCollectAndroidID(boolean z) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setCollectOaid(boolean z) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setCollectOaid", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_OAID, Boolean.toString(z));
    }

    @Deprecated
    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai aiVar = C1683ai.f1911;
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        aiVar.mo16117("public_api_call", IPixView.PAGE_STATUS_INIT, strArr);
        AFLogger.m1511(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{"5.4.0", f1788}));
        this.f1806 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        C1682ah.m1628(str);
        f1789 = appsFlyerConversionListener;
        return this;
    }

    public void setCustomerUserId(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setAppId(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setAppId", str);
        AppsFlyerProperties.getInstance().set("appid", str);
    }

    public void setExtension(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    public void setIsUpdate(boolean z) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setCurrencyCode(String str) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void trackLocation(Context context, double d, double d2) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "trackLocation", String.valueOf(d), String.valueOf(d2));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d2));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d));
        AFEvent context2 = new InAppEvent().context(context);
        context2.f1748 = AFInAppEventType.LOCATION_COORDINATES;
        context2.f1744 = hashMap;
        mo16027(context2);
    }

    public void reportTrackSession(Context context) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "reportTrackSession", new String[0]);
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.f1916 = false;
        AFEvent context2 = new InAppEvent().context(context);
        context2.f1748 = null;
        context2.f1744 = null;
        mo16027(context2);
    }

    public void setDeviceTrackingDisabled(boolean z) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f1789 = appsFlyerConversionListener;
        }
    }

    public void unregisterConversionListener() {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "unregisterConversionListener", new String[0]);
        f1789 = null;
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f1787 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    /* renamed from: ι */
    private static void m1578(Context context, Map<String, ? super String> map) {
        C1706s sVar = C1706s.C1708d.f2023;
        C1706s.C1707a r2 = C1706s.m1687(context);
        map.put("network", r2.f2020);
        if (r2.f2022 != null) {
            map.put(ErrorConst.ErrorParam.OPERATOR, r2.f2022);
        }
        if (r2.f2021 != null) {
            map.put("carrier", r2.f2021);
        }
    }

    public String getAppsFlyerUID(Context context) {
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("public_api_call", "getAppsFlyerUID", new String[0]);
        return C1676ae.m1619(new WeakReference(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0224 A[Catch:{ y -> 0x0206, all -> 0x0228 }] */
    /* renamed from: ι */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1579(com.appsflyer.AFEvent r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "appsflyerConversionDataCacheExpiration"
            java.net.URL r4 = new java.net.URL
            java.lang.String r5 = r0.f1747
            r4.<init>(r5)
            byte[] r5 = r21.mo15928()
            java.lang.String r6 = r21.key()
            java.lang.String r7 = r0.f1741
            boolean r8 = r21.mo15927()
            android.content.Context r9 = r21.context()
            com.appsflyer.AppsFlyerTrackingRequestListener r10 = r0.f1739
            r11 = 1
            if (r8 == 0) goto L_0x002c
            com.appsflyer.AppsFlyerConversionListener r13 = f1789
            if (r13 == 0) goto L_0x002c
            r13 = 1
            goto L_0x002d
        L_0x002c:
            r13 = 0
        L_0x002d:
            java.net.URLConnection r15 = r4.openConnection()     // Catch:{ all -> 0x022b }
            java.net.HttpURLConnection r15 = (java.net.HttpURLConnection) r15     // Catch:{ all -> 0x022b }
            java.lang.String r14 = "POST"
            r15.setRequestMethod(r14)     // Catch:{ all -> 0x0228 }
            int r14 = r5.length     // Catch:{ all -> 0x0228 }
            java.lang.String r12 = "Content-Length"
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0228 }
            r15.setRequestProperty(r12, r14)     // Catch:{ all -> 0x0228 }
            java.lang.String r12 = "Content-Type"
            boolean r0 = r21.isEncrypt()     // Catch:{ all -> 0x0228 }
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = "application/octet-stream"
            goto L_0x004f
        L_0x004d:
            java.lang.String r0 = "application/json"
        L_0x004f:
            r15.setRequestProperty(r12, r0)     // Catch:{ all -> 0x0228 }
            r0 = 10000(0x2710, float:1.4013E-41)
            r15.setConnectTimeout(r0)     // Catch:{ all -> 0x0228 }
            r15.setDoOutput(r11)     // Catch:{ all -> 0x0228 }
            java.io.DataOutputStream r12 = new java.io.DataOutputStream     // Catch:{ all -> 0x0217 }
            java.io.OutputStream r0 = r15.getOutputStream()     // Catch:{ all -> 0x0217 }
            r12.<init>(r0)     // Catch:{ all -> 0x0217 }
            r12.write(r5)     // Catch:{ all -> 0x0214 }
            r12.close()     // Catch:{ all -> 0x0228 }
            int r0 = r15.getResponseCode()     // Catch:{ all -> 0x0228 }
            java.lang.String r5 = r1.mo16025((java.net.HttpURLConnection) r15)     // Catch:{ all -> 0x0228 }
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0228 }
            if (r12 != 0) goto L_0x007c
            com.appsflyer.internal.ai r12 = new com.appsflyer.internal.ai     // Catch:{ all -> 0x0228 }
            r12.<init>()     // Catch:{ all -> 0x0228 }
            com.appsflyer.internal.C1683ai.f1911 = r12     // Catch:{ all -> 0x0228 }
        L_0x007c:
            com.appsflyer.internal.ai r12 = com.appsflyer.internal.C1683ai.f1911     // Catch:{ all -> 0x0228 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0228 }
            java.lang.String r14 = "server_response"
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ all -> 0x0228 }
            java.lang.String r18 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0228 }
            r16 = 0
            r11[r16] = r18     // Catch:{ all -> 0x0228 }
            r17 = 1
            r11[r17] = r5     // Catch:{ all -> 0x0228 }
            r12.mo16117(r14, r4, r11)     // Catch:{ all -> 0x0228 }
            java.lang.String r4 = "response code: "
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0228 }
            java.lang.String r4 = r4.concat(r11)     // Catch:{ all -> 0x0228 }
            com.appsflyer.AFLogger.afInfoLog(r4)     // Catch:{ all -> 0x0228 }
            android.content.SharedPreferences r4 = getSharedPreferences(r9)     // Catch:{ all -> 0x0228 }
            r11 = 200(0xc8, float:2.8E-43)
            if (r0 != r11) goto L_0x014a
            if (r9 == 0) goto L_0x00b5
            if (r8 == 0) goto L_0x00b5
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0228 }
            r1.f1795 = r11     // Catch:{ all -> 0x0228 }
        L_0x00b5:
            if (r10 == 0) goto L_0x00ba
            r10.onTrackingRequestSuccess()     // Catch:{ all -> 0x0228 }
        L_0x00ba:
            if (r7 == 0) goto L_0x00c3
            com.appsflyer.internal.C1671aa.m1608()     // Catch:{ all -> 0x0228 }
            com.appsflyer.internal.C1671aa.m1610(r7, r9)     // Catch:{ all -> 0x0228 }
            goto L_0x0103
        L_0x00c3:
            java.lang.String r0 = "sentSuccessfully"
            java.lang.String r7 = "true"
            android.content.SharedPreferences r8 = getSharedPreferences(r9)     // Catch:{ all -> 0x0228 }
            android.content.SharedPreferences$Editor r8 = r8.edit()     // Catch:{ all -> 0x0228 }
            r8.putString(r0, r7)     // Catch:{ all -> 0x0228 }
            r8.apply()     // Catch:{ all -> 0x0228 }
            boolean r0 = r1.f1817     // Catch:{ all -> 0x0228 }
            if (r0 != 0) goto L_0x0103
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0228 }
            long r10 = r1.f1821     // Catch:{ all -> 0x0228 }
            long r7 = r7 - r10
            r10 = 15000(0x3a98, double:7.411E-320)
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e7
            goto L_0x0103
        L_0x00e7:
            java.util.concurrent.ScheduledExecutorService r0 = r1.f1796     // Catch:{ all -> 0x0228 }
            if (r0 != 0) goto L_0x0103
            com.appsflyer.AFExecutor r0 = com.appsflyer.AFExecutor.getInstance()     // Catch:{ all -> 0x0228 }
            java.util.concurrent.ScheduledThreadPoolExecutor r0 = r0.mo15930()     // Catch:{ all -> 0x0228 }
            r1.f1796 = r0     // Catch:{ all -> 0x0228 }
            com.appsflyer.AppsFlyerLibCore$c r0 = new com.appsflyer.AppsFlyerLibCore$c     // Catch:{ all -> 0x0228 }
            r0.<init>(r9)     // Catch:{ all -> 0x0228 }
            java.util.concurrent.ScheduledExecutorService r7 = r1.f1796     // Catch:{ all -> 0x0228 }
            r10 = 1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0228 }
            m1560(r7, r0, r10, r8)     // Catch:{ all -> 0x0228 }
        L_0x0103:
            java.lang.String r0 = "afUninstallToken"
            com.appsflyer.AppsFlyerProperties r7 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0228 }
            java.lang.String r0 = r7.getString(r0)     // Catch:{ all -> 0x0228 }
            if (r0 == 0) goto L_0x0135
            java.lang.String r7 = "Uninstall Token exists: "
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0228 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0228 }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ all -> 0x0228 }
            java.lang.String r7 = "sentRegisterRequestToAF"
            r8 = 0
            boolean r7 = r4.getBoolean(r7, r8)     // Catch:{ all -> 0x0228 }
            if (r7 != 0) goto L_0x0135
            java.lang.String r7 = "Resending Uninstall token to AF servers: "
            java.lang.String r8 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0228 }
            java.lang.String r7 = r7.concat(r8)     // Catch:{ all -> 0x0228 }
            com.appsflyer.AFLogger.afDebugLog(r7)     // Catch:{ all -> 0x0228 }
            com.appsflyer.internal.C1677af.m1620(r9, r0)     // Catch:{ all -> 0x0228 }
        L_0x0135:
            android.net.Uri r0 = r1.latestDeepLink     // Catch:{ all -> 0x0228 }
            if (r0 == 0) goto L_0x013c
            r7 = 0
            r1.latestDeepLink = r7     // Catch:{ all -> 0x0228 }
        L_0x013c:
            org.json.JSONObject r0 = com.appsflyer.ServerConfigHandler.m1606(r5)     // Catch:{ all -> 0x0228 }
            java.lang.String r5 = "send_background"
            r7 = 0
            boolean r0 = r0.optBoolean(r5, r7)     // Catch:{ all -> 0x0228 }
            r1.f1803 = r0     // Catch:{ all -> 0x0228 }
            goto L_0x0159
        L_0x014a:
            if (r10 == 0) goto L_0x0159
            java.lang.String r5 = "Failure: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0228 }
            java.lang.String r0 = r5.concat(r0)     // Catch:{ all -> 0x0228 }
            r10.onTrackingRequestFailure(r0)     // Catch:{ all -> 0x0228 }
        L_0x0159:
            r7 = 0
            long r10 = r4.getLong(r3, r7)     // Catch:{ all -> 0x0228 }
            java.lang.String r0 = "attributionId"
            int r5 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0197
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0228 }
            long r18 = r18 - r10
            r10 = 5184000000(0x134fd9000, double:2.561236308E-314)
            int r5 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0197
            java.lang.String r5 = "sixtyDayConversionData"
            android.content.SharedPreferences r10 = getSharedPreferences(r9)     // Catch:{ all -> 0x0228 }
            android.content.SharedPreferences$Editor r10 = r10.edit()     // Catch:{ all -> 0x0228 }
            r11 = 1
            r10.putBoolean(r5, r11)     // Catch:{ all -> 0x0228 }
            r10.apply()     // Catch:{ all -> 0x0228 }
            android.content.SharedPreferences r5 = getSharedPreferences(r9)     // Catch:{ all -> 0x0228 }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0228 }
            r10 = 0
            r5.putString(r0, r10)     // Catch:{ all -> 0x0228 }
            r5.apply()     // Catch:{ all -> 0x0228 }
            m1577(r9, r3, r7)     // Catch:{ all -> 0x0228 }
        L_0x0197:
            r3 = 0
            java.lang.String r5 = r4.getString(r0, r3)     // Catch:{ all -> 0x0228 }
            if (r5 != 0) goto L_0x01b8
            if (r6 == 0) goto L_0x01b8
            if (r13 == 0) goto L_0x01b8
            com.appsflyer.AppsFlyerLibCore$b r0 = new com.appsflyer.AppsFlyerLibCore$b     // Catch:{ all -> 0x0228 }
            android.content.Context r2 = r9.getApplicationContext()     // Catch:{ all -> 0x0228 }
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0228 }
            r3 = 0
            r0.<init>(r1, r2, r6, r3)     // Catch:{ all -> 0x0228 }
            java.util.concurrent.ScheduledExecutorService r2 = r0.f1845     // Catch:{ all -> 0x0228 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0228 }
            r4 = 10
            m1560(r2, r0, r4, r3)     // Catch:{ all -> 0x0228 }
            goto L_0x020e
        L_0x01b8:
            if (r6 != 0) goto L_0x01c0
            java.lang.String r0 = "AppsFlyer dev key is missing."
            com.appsflyer.AFLogger.afWarnLog(r0)     // Catch:{ all -> 0x0228 }
            goto L_0x020e
        L_0x01c0:
            if (r13 == 0) goto L_0x020e
            r3 = 0
            java.lang.String r0 = r4.getString(r0, r3)     // Catch:{ all -> 0x0228 }
            if (r0 == 0) goto L_0x020e
            r0 = 0
            int r0 = r1.getLaunchCounter(r4, r0)     // Catch:{ all -> 0x0228 }
            r3 = 1
            if (r0 <= r3) goto L_0x020e
            java.util.Map r0 = m1531((android.content.Context) r9)     // Catch:{ y -> 0x0206 }
            if (r0 == 0) goto L_0x020e
            boolean r3 = r0.containsKey(r2)     // Catch:{ all -> 0x01fd }
            if (r3 != 0) goto L_0x01e2
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01fd }
            r0.put(r2, r3)     // Catch:{ all -> 0x01fd }
        L_0x01e2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fd }
            java.lang.String r3 = "Calling onConversionDataSuccess with:\n"
            r2.<init>(r3)     // Catch:{ all -> 0x01fd }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x01fd }
            r2.append(r3)     // Catch:{ all -> 0x01fd }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01fd }
            com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x01fd }
            com.appsflyer.AppsFlyerConversionListener r2 = f1789     // Catch:{ all -> 0x01fd }
            r2.onConversionDataSuccess(r0)     // Catch:{ all -> 0x01fd }
            goto L_0x020e
        L_0x01fd:
            r0 = move-exception
            java.lang.String r2 = r0.getLocalizedMessage()     // Catch:{ y -> 0x0206 }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ y -> 0x0206 }
            goto L_0x020e
        L_0x0206:
            r0 = move-exception
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0228 }
            com.appsflyer.AFLogger.afErrorLog(r2, r0)     // Catch:{ all -> 0x0228 }
        L_0x020e:
            if (r15 == 0) goto L_0x0213
            r15.disconnect()
        L_0x0213:
            return
        L_0x0214:
            r0 = move-exception
            r14 = r12
            goto L_0x021a
        L_0x0217:
            r0 = move-exception
            r3 = 0
            r14 = r3
        L_0x021a:
            if (r14 != 0) goto L_0x0224
            if (r10 == 0) goto L_0x0227
            java.lang.String r2 = "No Connectivity"
            r10.onTrackingRequestFailure(r2)     // Catch:{ all -> 0x0228 }
            goto L_0x0227
        L_0x0224:
            r14.close()     // Catch:{ all -> 0x0228 }
        L_0x0227:
            throw r0     // Catch:{ all -> 0x0228 }
        L_0x0228:
            r0 = move-exception
            r14 = r15
            goto L_0x022e
        L_0x022b:
            r0 = move-exception
            r3 = 0
            r14 = r3
        L_0x022e:
            if (r14 == 0) goto L_0x0233
            r14.disconnect()
        L_0x0233:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyerLibCore.m1579(com.appsflyer.AFEvent):void");
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Intent intent;
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai aiVar = C1683ai.f1911;
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        aiVar.mo16117("public_api_call", "validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            sb.append(" ");
            sb.append(str7);
            sb.append(" ");
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f1787;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (context2 instanceof Activity) {
            intent = ((Activity) context2).getIntent();
        } else {
            intent = null;
        }
        new Thread(new C1720x(applicationContext, string, str, str2, str3, str4, str5, map, intent)).start();
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    /* renamed from: Ι */
    static /* synthetic */ void m1569(AppsFlyerLibCore appsFlyerLibCore) {
        AFEvent context = new Attr().context(appsFlyerLibCore.f1815);
        if (appsFlyerLibCore.m1561() && appsFlyerLibCore.m1540(context, getSharedPreferences(appsFlyerLibCore.f1815))) {
            appsFlyerLibCore.m1535(context);
        }
    }

    /* renamed from: ǃ */
    static /* synthetic */ void m1551(Context context, String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: ı */
    static /* synthetic */ void m1536(AppsFlyerLibCore appsFlyerLibCore, AFEvent aFEvent) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(aFEvent.urlString());
        AFLogger.afInfoLog(sb.toString());
        if (aFEvent.f1741 != null) {
            str = Base64.encodeToString(aFEvent.mo15928(), 2);
            AFLogger.afInfoLog("cached data: ".concat(String.valueOf(str)));
        } else {
            str = new JSONObject(aFEvent.params()).toString();
            C1682ah.m1629("data: ".concat(String.valueOf(str)));
        }
        if (C1683ai.f1911 == null) {
            C1683ai.f1911 = new C1683ai();
        }
        C1683ai.f1911.mo16117("server_request", aFEvent.urlString(), str);
        try {
            appsFlyerLibCore.m1579(aFEvent);
        } catch (IOException e) {
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", e);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLibCore.m1579(aFEvent.urlString(aFEvent.urlString().replace("https:", "http:")));
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(e.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            throw e;
        }
    }
}
