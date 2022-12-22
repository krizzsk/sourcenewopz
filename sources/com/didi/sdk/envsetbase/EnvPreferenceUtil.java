package com.didi.sdk.envsetbase;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnvPreferenceUtil {
    public static final String KEY_AT_DRIVER_PHONE_KEY = "key_at_driver_phone_key";
    public static final String KEY_AT_TOOGLE_KEY = "key_autotest_toggle_key";
    public static final String KEY_DEFAULT_PUSH_FILE_IP_TEST = "key_default_push_file_ip_test";
    public static final String KEY_DEFAULT_PUSH_FILE_PORT_TEST = "key_default_push_file_port_test";
    public static final String KEY_DEFAULT_PUSH_IP_TEST = "key_default_push_ip_test";
    public static final String KEY_DEFAULT_PUSH_PORT_TEST = "key_default_push_port_test";
    public static final String KEY_DEV_ENVIRONMENT_FLAG = "dev_environment_flag";
    public static final String KEY_DEV_ENVIRONMENT_MAP = "dev_environment_map";
    public static final String KEY_DEV_ENV_SELECT = "dev_env_select";

    /* renamed from: a */
    private static final String f35835a = "EnvPreferenceUtil";

    /* renamed from: b */
    private static final String f35836b = "app_configuration";

    /* renamed from: c */
    private static Map<String, String> f35837c;

    public static boolean isTest(Context context) {
        return getIntSafely(context, KEY_DEV_ENVIRONMENT_FLAG, 0) != 0;
    }

    public static URL getUrl(Context context, String str) {
        URL url;
        String stringSafely = getStringSafely(context, str, (String) null);
        try {
            if (!TextUtils.isEmpty(stringSafely)) {
                if (stringSafely.startsWith("http")) {
                    url = new URL(stringSafely);
                } else if (!stringSafely.contains("//")) {
                    url = new URL("http://" + stringSafely);
                } else {
                    url = null;
                }
                EnvLog.log(f35835a, "getUrl" + str + ": " + url);
                return url;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        EnvLog.log(f35835a, "getUrl key : null");
        return null;
    }

    public static Map<String, String> getEnvMap() {
        Map<String, String> map = f35837c;
        if (map != null) {
            return map;
        }
        String stringSafely = getStringSafely(EnvApi.sContext, KEY_DEV_ENVIRONMENT_MAP, "");
        if (TextUtils.isEmpty(stringSafely)) {
            return null;
        }
        try {
            f35837c = (Map) new Gson().fromJson(stringSafely, new TypeToken<Map<String, String>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f35837c;
    }

    public static void saveEnvMap(Map<String, String> map) {
        if (map != null) {
            f35837c = map;
            EnvLog.log(f35835a, "saveEnvMap:" + f35837c.toString());
            commitString(EnvApi.sContext, KEY_DEV_ENVIRONMENT_MAP, new Gson().toJson((Object) map));
        }
    }

    public static void saveUrlMap(Map<String, String> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                commitString(EnvApi.sContext, next, map.get(next));
            }
        }
    }

    /* renamed from: a */
    private static SharedPreferences m25374a(Context context) {
        if (context == null) {
            return null;
        }
        return SystemUtils.getSharedPreferences(context.getApplicationContext(), f35836b, 0);
    }

    public static void commitInt(Context context, String str, int i) {
        if (context != null) {
            m25374a(context).edit().putInt(str, i).commit();
        }
    }

    public static void commitString(Context context, String str, String str2) {
        if (context != null) {
            m25374a(context).edit().putString(str, str2).commit();
        }
    }

    public static void commitBoolean(Context context, String str, boolean z) {
        if (context != null) {
            m25374a(context).edit().putBoolean(str, z).commit();
        }
    }

    public static int getIntSafely(Context context, String str, int i) {
        if (context == null) {
            EnvLog.log(f35835a, "getIntSafely: context is null");
            return i;
        }
        int i2 = m25374a(context).getInt(str, i);
        EnvLog.log(f35835a, "getIntSafely: " + str + ":" + i2);
        return i2;
    }

    public static String getStringSafely(Context context, String str, String str2) {
        return context == null ? str2 : m25374a(context).getString(str, str2);
    }

    public static boolean getBooleanSafely(Context context, String str, boolean z) {
        return context == null ? z : m25374a(context).getBoolean(str, z);
    }

    public static boolean needChangePush(Context context) {
        if (!EnvApi.isDebug()) {
            return false;
        }
        String string = getString(context, KEY_DEFAULT_PUSH_IP_TEST);
        return !TextUtils.isEmpty(string) && string.contains(":");
    }

    public static boolean needChangePushFile(Context context) {
        if (!EnvApi.isDebug()) {
            return false;
        }
        String string = getString(context, KEY_DEFAULT_PUSH_FILE_IP_TEST);
        return !TextUtils.isEmpty(string) && string.contains(":");
    }

    public static int getDevEnvironmentFlag(Context context) {
        return getIntSafely(context, KEY_DEV_ENVIRONMENT_FLAG, DevEnvironment.RELEASE.ordinal());
    }

    public static void setDevEnvironmentFlag(Context context, int i) {
        commitInt(context, KEY_DEV_ENVIRONMENT_FLAG, i);
    }

    public static String getPushIp(Context context) {
        String string = getString(context, KEY_DEFAULT_PUSH_IP_TEST);
        if (string.contains(":")) {
            string = getUrl(context, KEY_DEFAULT_PUSH_IP_TEST).getHost();
        }
        EnvLog.log(f35835a, "getPushIp : " + string);
        return string;
    }

    public static void setPushIp(Context context, String str) {
        commitString(context, KEY_DEFAULT_PUSH_IP_TEST, str);
    }

    public static String getPushPort(Context context) {
        String str;
        if (getString(context, KEY_DEFAULT_PUSH_IP_TEST).contains(":")) {
            str = String.valueOf(getUrl(context, KEY_DEFAULT_PUSH_IP_TEST).getPort());
        } else {
            str = getString(context, KEY_DEFAULT_PUSH_PORT_TEST);
        }
        EnvLog.log(f35835a, "getPushPort : " + str);
        return str;
    }

    public static void setPushPort(Context context, String str) {
        commitString(context, KEY_DEFAULT_PUSH_PORT_TEST, str);
    }

    public static String getPushFileIp(Context context) {
        String string = getString(context, KEY_DEFAULT_PUSH_FILE_IP_TEST);
        if (string.contains(":")) {
            string = getUrl(context, KEY_DEFAULT_PUSH_FILE_IP_TEST).getHost();
        }
        EnvLog.log(f35835a, "getPushFileIp : " + string);
        return string;
    }

    public static void setPushFileIp(Context context, String str) {
        commitString(context, KEY_DEFAULT_PUSH_FILE_IP_TEST, str);
    }

    public static String getPushFilePort(Context context) {
        String str;
        if (getString(context, KEY_DEFAULT_PUSH_FILE_IP_TEST).contains(":")) {
            str = String.valueOf(getUrl(context, KEY_DEFAULT_PUSH_FILE_IP_TEST).getPort());
        } else {
            str = getString(context, KEY_DEFAULT_PUSH_FILE_PORT_TEST);
        }
        EnvLog.log(f35835a, "getPushFilePort : " + str);
        return str;
    }

    public static void setPushFilePort(Context context, String str) {
        commitString(context, KEY_DEFAULT_PUSH_FILE_PORT_TEST, str);
    }

    public static void savePushFile(String str, Context context) {
        int lastIndexOf;
        if (str.contains(":") && (lastIndexOf = str.lastIndexOf(":")) < str.length()) {
            setPushFileIp(context, str.substring(0, lastIndexOf));
            setPushFilePort(context, str.substring(lastIndexOf + 1, str.length()));
        }
    }

    public static void savePush(String str, Context context) {
        int lastIndexOf;
        if (str.contains(":") && (lastIndexOf = str.lastIndexOf(":")) < str.length()) {
            setPushIp(context, str.substring(0, lastIndexOf));
            setPushPort(context, str.substring(lastIndexOf + 1, str.length()));
        }
    }

    public static boolean getATToggleStatus(Context context) {
        return getBooleanSafely(context, KEY_AT_TOOGLE_KEY, false);
    }

    public static void saveATToggleStatus(Context context, boolean z) {
        commitBoolean(context, KEY_AT_TOOGLE_KEY, z);
    }

    public static String getDriverPhone(Context context) {
        return getStringSafely(context, KEY_AT_DRIVER_PHONE_KEY, "");
    }

    public static void saveDriverPhone(Context context, String str) {
        commitString(context, KEY_AT_DRIVER_PHONE_KEY, str);
    }

    public static void clear(Context context) {
        if (context != null) {
            m25374a(context).edit().clear().apply();
        }
    }

    public static void commitLong(Context context, String str, long j) {
        if (context != null) {
            m25374a(context).edit().putLong(str, j).apply();
        }
    }

    public static void commitFloat(Context context, String str, float f) {
        if (context != null) {
            m25374a(context).edit().putFloat(str, f).apply();
        }
    }

    public static long getLongSafely(Context context, String str, long j) {
        return context == null ? j : m25374a(context).getLong(str, j);
    }

    public static float getFloatSafely(Context context, String str, float f) {
        return context == null ? f : m25374a(context).getFloat(str, f);
    }

    public static String getString(Context context, String str) {
        if (context == null) {
            return null;
        }
        return m25374a(context).getString(str, "");
    }

    public enum DevEnvironment {
        RELEASE("线上环境"),
        DEBUG("线下环境"),
        UNDEFINE("未定义，业务线可控制环境");
        
        private String meaning;

        private DevEnvironment(String str) {
            this.meaning = str;
        }

        public String getMeaning() {
            return this.meaning;
        }

        public static List<String> getDevEnvironmentTypeMeanings() {
            ArrayList arrayList = new ArrayList();
            for (DevEnvironment meaning2 : values()) {
                arrayList.add(meaning2.getMeaning());
            }
            return arrayList;
        }

        public static DevEnvironment getDevEnvironmentByOrdinal(int i) {
            for (DevEnvironment devEnvironment : values()) {
                if (devEnvironment.ordinal() == i) {
                    return devEnvironment;
                }
            }
            return UNDEFINE;
        }
    }
}
