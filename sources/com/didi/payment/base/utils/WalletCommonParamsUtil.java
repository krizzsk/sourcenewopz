package com.didi.payment.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.proxy.CommonProxyHolder;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.TextUtil;
import java.util.HashMap;
import java.util.Map;

public class WalletCommonParamsUtil {

    /* renamed from: a */
    private static final String f30018a = "com.taxis99";

    /* renamed from: b */
    private static final String f30019b = "com.xiaojukeji.didi.brazil.customer";

    /* renamed from: c */
    private static final String f30020c = "com.app99.driver";

    /* renamed from: d */
    private static final String f30021d = "com.pay99.wallet";

    /* renamed from: e */
    private static final String f30022e = "com.didiglobal.passenger";

    /* renamed from: f */
    private static final String f30023f = "com.xiaojukeji.didi.global.customer";

    /* renamed from: g */
    private static final String f30024g = "com.didiglobal.driver";

    /* renamed from: h */
    private static Map<String, Object> f30025h;

    public static String getCommonParamWithCache(Context context, String str, String str2) {
        Object commonParamWithCache = getCommonParamWithCache(context, str);
        return (commonParamWithCache == null || TextUtil.isEmpty(commonParamWithCache.toString())) ? str2 : commonParamWithCache.toString();
    }

    public static Object getCommonParamWithCache(Context context, String str) {
        if (context == null || TextUtil.isEmpty(str)) {
            return null;
        }
        Object a = m21022a(str);
        if (a != null) {
            return a;
        }
        Object commonParam = getCommonParam(context, str);
        if (commonParam == null) {
            return null;
        }
        m21023a(str, commonParam);
        return commonParam;
    }

    /* renamed from: a */
    private static Object m21022a(String str) {
        if (f30025h == null) {
            f30025h = new HashMap();
        }
        return f30025h.get(str);
    }

    /* renamed from: a */
    private static void m21023a(String str, Object obj) {
        if (f30025h == null) {
            f30025h = new HashMap();
        }
        f30025h.put(str, obj);
    }

    public static HashMap<String, Object> getAllParams(Context context) {
        if (context == null) {
            return new HashMap<>();
        }
        CommonProxyHolder.ICommonProxy proxy = CommonProxyHolder.getProxy();
        if (proxy == null) {
            return new HashMap<>();
        }
        return proxy.getBaseParams(context);
    }

    public static Object getCommonParam(Context context, String str) {
        CommonProxyHolder.ICommonProxy proxy;
        if (context == null || str == null || (proxy = CommonProxyHolder.getProxy()) == null) {
            return null;
        }
        if (str.equals("terminal_id")) {
            return proxy.getTerminalId(context);
        }
        HashMap<String, Object> baseParams = proxy.getBaseParams(context);
        if (CollectionUtil.isEmpty((Map) baseParams)) {
            return null;
        }
        return baseParams.get(str);
    }

    public static boolean isDriverClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m21024a(packageName, f30024g) || m21024a(packageName, "com.app99.driver");
    }

    /* renamed from: a */
    private static boolean m21024a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.equals(str, str2) || str.startsWith(str2)) {
            return true;
        }
        return false;
    }

    public static boolean isPassengerClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m21024a(packageName, f30022e) || m21024a(packageName, "com.taxis99");
    }

    public static boolean isPassengerBrazilClient() {
        return m21024a(ApplicationContextProvider.Companion.getContext().getPackageName(), "com.taxis99");
    }

    public static boolean is99PayClient() {
        return m21024a(ApplicationContextProvider.Companion.getContext().getPackageName(), f30021d);
    }

    public static boolean isSodaClient() {
        String packageName = ApplicationContextProvider.Companion.getContext().getPackageName();
        return m21024a(packageName, f30023f) || m21024a(packageName, f30019b);
    }

    public static String getCountry(Context context) {
        Object commonParam = getCommonParam(context, "country");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getUID(Context context) {
        Object commonParam = getCommonParam(context, "uid");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getTerminalId(Context context) {
        Object commonParam = getCommonParam(context, "terminal_id");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLang(Context context) {
        Object commonParam = getCommonParam(context, "lang");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLat(Context context) {
        Object commonParam = getCommonParam(context, "lat");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getLng(Context context) {
        Object commonParam = getCommonParam(context, "lng");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getIP(Context context) {
        Object commonParam = getCommonParam(context, "ip");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getToken(Context context) {
        Object commonParam = getCommonParam(context, "token");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }

    public static String getPhone(Context context) {
        Object commonParam = getCommonParam(context, "phone");
        if (commonParam == null) {
            return "";
        }
        return commonParam.toString();
    }
}
