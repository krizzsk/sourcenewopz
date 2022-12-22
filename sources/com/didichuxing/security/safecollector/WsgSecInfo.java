package com.didichuxing.security.safecollector;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class WsgSecInfo {

    /* renamed from: a */
    private static volatile Context f48992a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static int f48993b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static StringBuffer f48994c = new StringBuffer();

    /* renamed from: d */
    private static ExecutorService f48995d = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    static /* synthetic */ int m35220b() {
        int i = f48993b;
        f48993b = i + 1;
        return i;
    }

    public static void init(Context context) {
        if (f48992a == null) {
            if (context != null) {
                f48992a = context.getApplicationContext();
                return;
            }
            throw new NullPointerException("context is null when init mysdk");
        }
    }

    public static void setsContext(Context context) {
        if (f48992a == null && context != null) {
            f48992a = context.getApplicationContext();
        }
    }

    public static String appName(Context context) {
        setsContext(context);
        return C16451f.m35265a(context);
    }

    public static String appName() {
        return appName(f48992a);
    }

    public static String packageName(Context context) {
        setsContext(context);
        m35219a("packageName", context);
        return C16451f.m35267b(context);
    }

    public static String packageName() {
        return packageName(f48992a);
    }

    public static int appVersionCode(Context context) {
        setsContext(context);
        return C16451f.m35268c(context);
    }

    public static int appVersionCode() {
        return appVersionCode(f48992a);
    }

    public static String appVersionName(Context context) {
        setsContext(context);
        return C16451f.m35271d(context);
    }

    public static String appVersionName() {
        return appVersionName(f48992a);
    }

    public static String appVersionIssue(Context context) {
        setsContext(context);
        return C16451f.m35273e(context);
    }

    public static String appVersionIssue() {
        return appVersionIssue(f48992a);
    }

    public static String osType(Context context) {
        return C16451f.m35264a();
    }

    public static String osType() {
        return osType(f48992a);
    }

    public static String osVersion(Context context) {
        setsContext(context);
        return C16451f.m35266b();
    }

    public static String osVersion() {
        return osVersion(f48992a);
    }

    public static String model(Context context) {
        setsContext(context);
        return C16451f.m35269c();
    }

    public static String model() {
        return model(f48992a);
    }

    public static String brand(Context context) {
        setsContext(context);
        return C16451f.m35270d();
    }

    public static String brand() {
        return brand(f48992a);
    }

    public static String cpu(Context context) {
        setsContext(context);
        m35219a("cpu", context);
        return C16451f.m35272e();
    }

    public static String cpu() {
        return cpu(f48992a);
    }

    public static String cpuSerialNo(Context context) {
        setsContext(context);
        m35219a("cpuSerialNo", context);
        return C16451f.m35274f();
    }

    public static String cpuSerialNo() {
        return cpuSerialNo(f48992a);
    }

    public static String pixels(Context context) {
        setsContext(context);
        return C16451f.m35275f(context);
    }

    public static String pixels() {
        return pixels(f48992a);
    }

    public static int screenHeight() {
        return C16451f.m35276g(f48992a);
    }

    public static int screenWidth() {
        return C16451f.m35278h(f48992a);
    }

    public static String totalSpace(Context context) {
        setsContext(context);
        return C16451f.m35277g();
    }

    public static String totalDisk() {
        setsContext(f48992a);
        return C16451f.m35281i(f48992a);
    }

    public static String totalSpace() {
        return totalSpace(f48992a);
    }

    public static String isRoot(Context context) {
        setsContext(context);
        return C16451f.m35280i();
    }

    public static boolean isRootBoolean(Context context) {
        setsContext(context);
        return C16451f.m35279h();
    }

    public static boolean isRoot() {
        return isRootBoolean(f48992a);
    }

    public static String androidId(Context context) {
        setsContext(context);
        m35219a("androidId", context);
        return C16451f.m35283j(context);
    }

    public static String androidId() {
        return androidId(f48992a);
    }

    public static String imsi(Context context) {
        setsContext(context);
        m35219a("imsi", context);
        return C16451f.m35285l(context);
    }

    public static String imsi() {
        return imsi(f48992a);
    }

    public static String customId(Context context) {
        setsContext(context);
        m35219a("customId", context);
        return C16451f.m35286m(context);
    }

    public static String customId() {
        return customId(f48992a);
    }

    public static String screenSize(Context context) {
        setsContext(context);
        return C16451f.m35288o(context);
    }

    public static String screenSize() {
        return screenSize(f48992a);
    }

    public static int emulatorType(Context context) {
        setsContext(context);
        return C16451f.m35289p(context);
    }

    public static int emulatorType() {
        return emulatorType(f48992a);
    }

    public static int utcOffset(Context context) {
        setsContext(context);
        m35219a("utcOffset", context);
        return C16451f.m35282j();
    }

    public static int utcOffset() {
        return utcOffset(f48992a);
    }

    public static String countryCode(Context context) {
        setsContext(context);
        m35219a("countryCode", context);
        return C16451f.m35290q(context);
    }

    public static String countryCode() {
        return countryCode(f48992a);
    }

    public static String locale(Context context) {
        setsContext(context);
        m35219a("locale", context);
        return C16449d.m35259f(context);
    }

    public static String locale() {
        return locale(f48992a);
    }

    public static String mcc(Context context) {
        setsContext(context);
        m35219a("mcc", context);
        return C16451f.m35292s(context);
    }

    public static String mcc() {
        return mcc(f48992a);
    }

    public static String mnc(Context context) {
        setsContext(context);
        m35219a("mnc", context);
        return C16451f.m35293t(context);
    }

    public static String mnc() {
        return mnc(f48992a);
    }

    public static String networkOperator(Context context) {
        setsContext(context);
        return C16451f.m35294u(context);
    }

    public static String networkOperator() {
        return networkOperator(f48992a);
    }

    public static String simCarrier(Context context) {
        setsContext(context);
        return C16451f.m35295v(context);
    }

    public static String simCarrier() {
        return simCarrier(f48992a);
    }

    public static String networkType(Context context) {
        setsContext(context);
        m35219a("networkType", context);
        return C16449d.m35252a(context);
    }

    public static String networkType() {
        return networkType(f48992a);
    }

    public static String localIp(Context context) {
        setsContext(context);
        m35219a("localIp", context);
        return C16449d.m35251a();
    }

    public static String localIp() {
        return localIp(f48992a);
    }

    public static String batteryLevel(Context context) {
        setsContext(context);
        m35219a("batteryLevel", context);
        return C16449d.m35254b(context);
    }

    public static String batteryLevel() {
        return batteryLevel(f48992a);
    }

    public static String phoneTime(Context context) {
        return C16449d.m35253b();
    }

    public static String phoneTime() {
        return phoneTime(f48992a);
    }

    public static long phoneTimeLong(Context context) {
        setsContext(context);
        return C16449d.m35255c();
    }

    public static long phoneTimeLong() {
        return phoneTimeLong(f48992a);
    }

    public static String isDebug(Context context) {
        setsContext(context);
        return C16449d.m35256c(context);
    }

    public static boolean isDebugBoolean(Context context) {
        setsContext(context);
        m35219a("isDebug", context);
        return C16449d.m35257d(context);
    }

    public static boolean isDebug() {
        return C16449d.m35257d(f48992a);
    }

    public static String isBackground(Context context) {
        setsContext(context);
        m35219a("isBackground", context);
        return C16449d.m35258e(context);
    }

    public static boolean isBackgroundBoolean(Context context) {
        setsContext(context);
        m35219a("isBackground", context);
        return C16449d.m35258e(context).equals("1");
    }

    public static boolean isBackground() {
        return isBackgroundBoolean(f48992a);
    }

    /* renamed from: a */
    private static void m35219a(final String str, final Context context) {
        try {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            f48995d.submit(new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bundleid", C16451f.m35267b(context));
                    hashMap.put("caller", WsgSecInfo.m35221b(stackTrace));
                    hashMap.put("key", str);
                    hashMap.put("sdkversion", BuildConfig.VERSION_NAME);
                    hashMap.put("timestamp", C16449d.m35253b());
                    StringBuffer a = WsgSecInfo.f48994c;
                    a.append(hashMap.toString());
                    a.append(";");
                    WsgSecInfo.m35220b();
                    if (WsgSecInfo.f48993b > 49) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("params", WsgSecInfo.f48994c.toString());
                        OmegaSDKAdapter.trackEvent("tech_wsg_safe_collect", (Map<String, Object>) hashMap2);
                        int unused = WsgSecInfo.f48993b = 0;
                        StringBuffer unused2 = WsgSecInfo.f48994c = new StringBuffer();
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m35221b(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr == null) {
            return str;
        }
        try {
            if (stackTraceElementArr.length <= 3) {
                return str;
            }
            int i = 2;
            StackTraceElement stackTraceElement = stackTraceElementArr[2];
            while (true) {
                if (i >= stackTraceElementArr.length) {
                    break;
                }
                StackTraceElement stackTraceElement2 = stackTraceElementArr[i];
                if (!stackTraceElement2.getClassName().equals(stackTraceElement.getClassName())) {
                    str = stackTraceElement2.getClassName() + "." + stackTraceElement2.getMethodName();
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        } catch (Throwable unused) {
            return str;
        }
    }
}
