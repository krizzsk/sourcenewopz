package com.didi.dcrypto.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.Date;

public class DCryptoUtils {
    public static final String CACHE_EMPTY_VALUE = "";
    public static final String KEY_BUNDLE_EXTRA_ENV = "env";
    public static final String KEY_BUNDLE_EXTRA_TERMINAL_ID = "terminal_id";
    public static final String KEY_HOME_ACCOUNT_BALANCE = "MULTICOIN_accountBalance";
    public static final String KEY_HOME_ACCOUNT_STATUS = "MULTICOIN_accountStatus";
    public static final String KEY_HOME_DAILY_PROFIT_AND_LOSS = "MULTICOIN_dailyPnL";
    public static final String KEY_HOME_GET_CRYPTO_PRICE = "MULTICOIN_getCryptoPrice";
    public static final String KEY_HOME_HISTORY_ITEMS = "MULTICOIN_historyItems";
    public static final String KEY_HOME_TOP_BANNER = "MULTICOIN_topBanner";
    public static final String KEY_HOME_UID = "MULTICOIN_uid";
    public static final String KEY_HOME_UI_CONFIG = "MULTICOIN_uiConfig";
    public static final String KEY_IP_BLOCKING_STATUS = "ipBlockingStatus";
    public static final String KEY_IP_BLOCKING_STATUS_BLOCK = "YES";
    public static final String KEY_IP_BLOCKING_STATUS_DEFAULT = "DEFAULT";
    public static final String KEY_IP_BLOCKING_STATUS_UNBLOCK = "NO";
    public static final String PARAMS_DCRYPTO_PLATFORM_KEY = "dcryptoPlatform";
    public static final String PARAMS_DCRYPTO_PLATFORM_VAL = "android";
    public static final String PARAMS_DCRYPTO_VERSION_KEY = "dcryptoVersion";
    public static final String PARAMS_DCRYPTO_VERSION_VALUE = "1.0.3";
    public static final String PARAMS_KEY_ENV = "env";
    public static final String PARAMS_KEY_TERMINAL_ID = "terminalId";
    public static final String SOURCE_DEFAULT = "latour";
    public static final String SOURCE_LATOUR = "latour";
    public static final String SOURCE_MOUTON = "mouton";
    public static String URL_PARAMS = "";
    public static final String VAL_TERMINAL_ID_LATOUR = "300303";
    public static final String VAL_TERMINAL_ID_MOUTON = "5";

    /* renamed from: a */
    private static final String f16489a = "payment";

    /* renamed from: b */
    private static final String f16490b = "wallet_frozen_data";

    /* renamed from: c */
    private static final String f16491c = "DcryptoSharedPreference";

    /* renamed from: d */
    private static final String f16492d = "DCryptoFirstLaunch";

    /* renamed from: e */
    private static final String f16493e = "DCryptoBubbleViewed";
    public static String env = null;

    /* renamed from: f */
    private static final String f16494f = "DCryptoDateMillisecond";

    /* renamed from: g */
    private static final String f16495g = "env_env";

    /* renamed from: h */
    private static final String f16496h = "env_terminal_id";
    public static String hostAppSource = "latour";

    /* renamed from: i */
    private static final int f16497i = 12;

    /* renamed from: j */
    private static final int f16498j = 720;

    /* renamed from: k */
    private static final int f16499k = 43200;

    /* renamed from: l */
    private static final int f16500l = 43200000;

    /* renamed from: m */
    private static final long f16501m = 43200000;

    /* renamed from: n */
    private static long f16502n = 0;

    /* renamed from: o */
    private static final int f16503o = 5;

    /* renamed from: p */
    private static final long f16504p = 300000;
    public static String terminalID;

    public static String getTradingSessionID() {
        return "12345";
    }

    public static boolean hasUserBeenEducated(Context context) {
        return SystemUtils.getSharedPreferences(context, f16491c, 0).getBoolean(f16492d, false);
    }

    public static void setBubbleViewed(Context context, boolean z) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putBoolean(f16493e, z);
        edit.apply();
    }

    public static boolean isBubbleViewed(Context context) {
        return SystemUtils.getSharedPreferences(context, f16491c, 0).getBoolean(f16493e, false);
    }

    public static void setDcryptoEnv(Context context, String str, String str2) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putString(f16495g, str);
        edit.putString(f16496h, str2);
        edit.apply();
    }

    public static String getAccountFrozenStatus(Context context) {
        return SystemUtils.getSharedPreferences(context, "payment", 0).getString(f16490b, "");
    }

    public static void setDcryptoCache(Context context, String str, String str2) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void clearDcryptoCache(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putString(str, "");
        edit.apply();
    }

    public static String getDcryptoCache(Context context, String str) {
        return SystemUtils.getSharedPreferences(context, f16491c, 0).getString(str, "");
    }

    /* renamed from: a */
    private static long m12126a() {
        return new Date(System.currentTimeMillis()).getTime();
    }

    public boolean shouldFetchGraphData(Context context, String str) {
        return m12126a() - getGraphTimestamp(context, str) >= 300000;
    }

    public void putChartCacheValue(Context context, String str, long j) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public long getChartCacheValue(Context context, String str) {
        return SystemUtils.getSharedPreferences(context, f16491c, 0).getLong(str, 0);
    }

    public void setGraphTimestamp(Context context, String str) {
        putChartCacheValue(context, str, m12126a());
    }

    public void clearTimestamp(Context context, String str) {
        putChartCacheValue(context, str, 0);
    }

    public long getGraphTimestamp(Context context, String str) {
        return getChartCacheValue(context, str);
    }

    public static boolean shouldFetchIPBlock() {
        return m12126a() - getIPBlockTimestamp() >= f16501m;
    }

    public static void setIPBlockTimestamp() {
        f16502n = m12126a();
    }

    public static void clearIPBlockTimestamp() {
        f16502n = 0;
    }

    public static long getIPBlockTimestamp() {
        return f16502n;
    }

    public static void setDcryptoIPStatus(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f16491c, 0).edit();
        edit.putString(KEY_IP_BLOCKING_STATUS, str);
        edit.apply();
    }

    public static String getDcryptoIPStatus(Context context) {
        return SystemUtils.getSharedPreferences(context, f16491c, 0).getString(KEY_IP_BLOCKING_STATUS, KEY_IP_BLOCKING_STATUS_DEFAULT);
    }

    public static void getBundle(DCryptoMainFragment dCryptoMainFragment) {
        Bundle arguments = dCryptoMainFragment.getArguments();
        if (arguments != null) {
            String str = (String) arguments.get("env");
            env = str;
            String str2 = (String) arguments.get("terminal_id");
            terminalID = str2;
            if (str == null || str2 == null) {
                SystemUtils.log(4, "Param", "DCryptoMainFragment extraVal Env = [EMPTY] extraVal TerminalId = [EMPTY]", (Throwable) null, "com.didi.dcrypto.util.DCryptoUtils", 306);
            } else {
                if (str2.equalsIgnoreCase("5")) {
                    hostAppSource = SOURCE_MOUTON;
                    URL_PARAMS = "&env=" + str + ParamKeys.SIGN_AND + PARAMS_KEY_TERMINAL_ID + "=" + str2;
                } else if (str2.equalsIgnoreCase(VAL_TERMINAL_ID_LATOUR)) {
                    hostAppSource = "latour";
                    URL_PARAMS = "&env=" + str + ParamKeys.SIGN_AND + PARAMS_KEY_TERMINAL_ID + "=" + str2;
                } else {
                    hostAppSource = "latour";
                    URL_PARAMS = "";
                }
                SystemUtils.log(4, "Param", "DCryptoMainFragment extraVal Env = " + str + " extraVal TerminalId = " + str2, (Throwable) null, "com.didi.dcrypto.util.DCryptoUtils", 304);
            }
        }
        URL_PARAMS += "&dcryptoVersion=1.0.3&dcryptoPlatform=android";
        if (dCryptoMainFragment.getContext() != null) {
            setDcryptoEnv(dCryptoMainFragment.getContext(), env, terminalID);
        }
    }
}
