package com.didi.map.sdk.sharetrack.google.inner.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.yanzhenjie.permission.runtime.Permission;
import java.text.DecimalFormat;
import java.util.Locale;

/* renamed from: com.didi.map.sdk.sharetrack.google.inner.utils.utils */
public class C10194utils {
    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        String str;
        if (context == null) {
            return "null";
        }
        try {
            if (ContextCompat.checkSelfPermission(context, Permission.READ_PHONE_STATE) == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        str = telephonyManager.getImei();
                    } else {
                        str = telephonyManager.getDeviceId();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "null";
                }
                if (TextUtils.isEmpty(str)) {
                    return "null";
                }
                return str;
            }
        } catch (Exception unused) {
        }
        return "null";
    }

    public static String getUsingLanguage(Context context) {
        Locale a = m20356a(context.getResources().getConfiguration());
        if (a != null) {
            return m20355a(a);
        }
        return null;
    }

    /* renamed from: a */
    private static Locale m20356a(Configuration configuration) {
        if (configuration == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return configuration.locale;
        }
        LocaleList locales = configuration.getLocales();
        if (locales.size() > 0) {
            return locales.get(0);
        }
        return null;
    }

    /* renamed from: a */
    private static String m20355a(Locale locale) {
        if (locale == null) {
            return "";
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return "";
        }
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append("-");
            sb.append(country);
        }
        return sb.toString();
    }

    public static boolean isAppDebug(Context context) {
        boolean z;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!(applicationInfo == null || (applicationInfo.flags & 2) == 0)) {
                z = true;
                DLog.m20357d("util", "[isAppDebug] isDebug = " + z, new Object[0]);
                return z;
            }
        } catch (Exception unused) {
        }
        z = false;
        DLog.m20357d("util", "[isAppDebug] isDebug = " + z, new Object[0]);
        return z;
    }

    public static double m2L(double d, double d2) {
        double cos = d / ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * 2.003750834E7d) / 180.0d);
        try {
            return Double.valueOf(new DecimalFormat("#.0000").format(cos)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return cos;
        }
    }
}
