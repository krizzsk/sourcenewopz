package com.didi.sdk.developermode;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.developermode.DevModeUtil;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;

public class DevModePreference {

    /* renamed from: a */
    private static final String f35811a = "app_configuration";

    /* renamed from: b */
    private static final String f35812b = "dev_environment_flag";

    /* renamed from: c */
    private static final String f35813c = "tab_mis_config_flag";

    /* renamed from: d */
    private static final String f35814d = "tab_mis_config_test_flag";

    /* renamed from: e */
    private static final String f35815e = "public_service_environment_flag";

    /* renamed from: f */
    private static final String f35816f = "side_bar_version";

    /* renamed from: g */
    private static final String f35817g = "pre_release_enable";

    /* renamed from: h */
    private static final String f35818h = "web_view_debug_enable";

    /* renamed from: i */
    private static final String f35819i = "pacific_location_flag";

    /* renamed from: j */
    private static final String f35820j = "omega_debug_flag";

    /* renamed from: k */
    private static final String f35821k = "key_default_push_ip_test";

    /* renamed from: l */
    private static final String f35822l = "key_default_push_port_test";

    /* renamed from: m */
    private static final String f35823m = "key_default_push_file_ip_test";

    /* renamed from: n */
    private static final String f35824n = "key_default_push_file_port_test";

    /* renamed from: o */
    private static final String f35825o = "key_test_common_url";

    /* renamed from: p */
    private static final String f35826p = "key_guide_help_service";

    /* renamed from: q */
    private static final String f35827q = "key_http_dns_enable_flag";

    /* renamed from: r */
    private static final String f35828r = "key_is_upload_oom_flag";

    public static String getPushIp(Context context) {
        if (m25367d(context, "key_default_push_ip_test").contains(":")) {
            return EnvPreferenceUtil.getUrl(context, "key_default_push_ip_test").getHost();
        }
        return m25367d(context, "key_default_push_ip_test");
    }

    public static void setPushIp(Context context, String str) {
        m25358a(context, "key_default_push_ip_test", str);
    }

    public static String getPushPort(Context context) {
        if (m25367d(context, "key_default_push_ip_test").contains(":")) {
            return String.valueOf(EnvPreferenceUtil.getUrl(context, "key_default_push_ip_test").getPort());
        }
        return m25367d(context, "key_default_push_port_test");
    }

    public static void setPushPort(Context context, String str) {
        m25358a(context, "key_default_push_port_test", str);
    }

    public static String getPushFileIp(Context context) {
        return m25367d(context, "key_default_push_file_ip_test");
    }

    public static void setPushFileIp(Context context, String str) {
        m25358a(context, "key_default_push_file_ip_test", str);
    }

    public static String getPushFilePort(Context context) {
        return m25367d(context, "key_default_push_file_port_test");
    }

    public static void setPushFilePort(Context context, String str) {
        m25358a(context, "key_default_push_file_port_test", str);
    }

    public static String getCommonApiUrl(Context context) {
        return m25367d(context, f35825o);
    }

    public static void setCommonApiUrl(Context context, String str) {
        m25358a(context, f35825o, str);
    }

    public static String getHelpServiceHelp(Context context) {
        return m25367d(context, f35826p);
    }

    public static void setHelpServiceUrl(Context context, String str) {
        m25358a(context, f35826p, str);
    }

    public static int getDevEnvironmentFlag(Context context) {
        return m25361b(context, "dev_environment_flag", DevModeUtil.DevEnvironment.RELEASE.ordinal());
    }

    public static void setDevEnvironmentFlag(Context context, int i) {
        m25356a(context, "dev_environment_flag", i);
    }

    public static boolean getMisConfigFlag(Context context) {
        return m25365b(context, f35813c, true);
    }

    public static void setMisConfigFlag(Context context, boolean z) {
        m25359a(context, f35813c, z);
    }

    public static boolean getMisConfigTestFlag(Context context) {
        return m25365b(context, f35814d, false);
    }

    public static void setMisConfigTestFlag(Context context, boolean z) {
        m25359a(context, f35814d, z);
    }

    public static void setPublicServiceEnviornmentFlag(Context context, boolean z) {
        m25359a(context, f35815e, z);
    }

    public static void setSideBarSwitchFlag(Context context, boolean z) {
        m25359a(context, f35816f, z);
    }

    public static void setPreEnabble(Context context, boolean z) {
        m25359a(context, f35817g, z);
    }

    public static boolean getPreEnable(Context context) {
        return m25365b(context, f35817g, false);
    }

    public static void setWebViewDebugEnabble(Context context, boolean z) {
        m25359a(context, f35818h, z);
    }

    public static boolean getWebViewDebugEnable(Context context) {
        return m25365b(context, f35818h, false);
    }

    public static void setPacificSwitchFlag(Context context, boolean z) {
        m25359a(context, f35819i, z);
    }

    public static void setOmegaSDKDebugFlag(Context context, boolean z) {
        m25359a(context, f35820j, z);
    }

    public static boolean getOmegaSDKDebugFlag(Context context) {
        return m25365b(context, f35820j, false);
    }

    public static void setIsUploadoomFlag(Context context, boolean z) {
        m25359a(context, f35828r, z);
    }

    public static boolean getIsUploadoomFlag(Context context) {
        return m25365b(context, f35828r, true);
    }

    public static boolean getPublicServiceEnvironmentFlag(Context context) {
        return m25365b(context, f35815e, true);
    }

    public static boolean getPacificSwitchFlag(Context context) {
        return m25365b(context, f35819i, false);
    }

    public static boolean getCountrySwitchFlag(Context context) {
        return m25365b(context, f35816f, true);
    }

    public static boolean getHttpDnsEnable(Context context) {
        return m25365b(context, f35827q, true);
    }

    public static void setHttpDnsEnable(Context context, boolean z) {
        m25359a(context, f35827q, z);
    }

    /* renamed from: a */
    private static SharedPreferences m25354a(Context context) {
        return SystemUtils.getSharedPreferences(context, f35811a, 0);
    }

    public static void clear(Context context) {
        m25354a(context).edit().clear().apply();
    }

    /* renamed from: a */
    private static void m25356a(Context context, String str, int i) {
        m25354a(context).edit().putInt(str, i).apply();
    }

    /* renamed from: a */
    private static void m25357a(Context context, String str, long j) {
        m25354a(context).edit().putLong(str, j).apply();
    }

    /* renamed from: a */
    private static void m25355a(Context context, String str, float f) {
        m25354a(context).edit().putFloat(str, f).apply();
    }

    /* renamed from: a */
    private static void m25358a(Context context, String str, String str2) {
        m25354a(context).edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    private static void m25359a(Context context, String str, boolean z) {
        m25354a(context).edit().putBoolean(str, z).apply();
    }

    /* renamed from: a */
    private static int m25353a(Context context, String str) {
        return m25354a(context).getInt(str, 0);
    }

    /* renamed from: b */
    private static long m25362b(Context context, String str) {
        return m25354a(context).getLong(str, 0);
    }

    /* renamed from: c */
    private static float m25366c(Context context, String str) {
        return m25354a(context).getFloat(str, 0.0f);
    }

    /* renamed from: d */
    private static String m25367d(Context context, String str) {
        return m25354a(context).getString(str, "");
    }

    /* renamed from: e */
    private static boolean m25368e(Context context, String str) {
        return m25354a(context).getBoolean(str, false);
    }

    /* renamed from: b */
    private static int m25361b(Context context, String str, int i) {
        return m25354a(context).getInt(str, i);
    }

    /* renamed from: b */
    private static long m25363b(Context context, String str, long j) {
        return m25354a(context).getLong(str, j);
    }

    /* renamed from: b */
    private static float m25360b(Context context, String str, float f) {
        return m25354a(context).getFloat(str, f);
    }

    /* renamed from: b */
    private static String m25364b(Context context, String str, String str2) {
        return m25354a(context).getString(str, str2);
    }

    /* renamed from: b */
    private static boolean m25365b(Context context, String str, boolean z) {
        return m25354a(context).getBoolean(str, z);
    }
}
