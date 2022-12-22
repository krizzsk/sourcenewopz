package jumio.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: jumio.core.r */
/* compiled from: DataPointsUtil */
public class C21377r {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b A[Catch:{ Exception -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2 A[Catch:{ Exception -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b5 A[SYNTHETIC, Splitter:B:29:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2 A[Catch:{ Exception -> 0x00dc }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m42193a(android.content.Context r10, com.jumio.core.persistence.DataManager r11) {
        /*
            java.lang.Class<com.jumio.core.models.SettingsModel> r0 = com.jumio.core.models.SettingsModel.class
            java.io.Serializable r0 = r11.get(r0)
            com.jumio.core.models.SettingsModel r0 = (com.jumio.core.models.SettingsModel) r0
            boolean r1 = r0.isAdditionalDataPointsEnabled()
            if (r1 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Class<jumio.core.a> r1 = jumio.core.C21338a.class
            java.io.Serializable r11 = r11.get(r1)
            r1 = r11
            jumio.core.a r1 = (jumio.core.C21338a) r1
            r11 = 0
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics     // Catch:{ Exception -> 0x0035 }
            r2.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r3 = "window"
            java.lang.Object r3 = r10.getSystemService(r3)     // Catch:{ Exception -> 0x0035 }
            android.view.WindowManager r3 = (android.view.WindowManager) r3     // Catch:{ Exception -> 0x0035 }
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch:{ Exception -> 0x0035 }
            r3.getMetrics(r2)     // Catch:{ Exception -> 0x0035 }
            int r3 = r2.widthPixels     // Catch:{ Exception -> 0x0035 }
            int r2 = r2.heightPixels     // Catch:{ Exception -> 0x0033 }
            r4 = r2
            goto L_0x003b
        L_0x0033:
            r2 = move-exception
            goto L_0x0037
        L_0x0035:
            r2 = move-exception
            r3 = 0
        L_0x0037:
            com.jumio.commons.log.Log.printStackTrace(r2)     // Catch:{ Exception -> 0x00dc }
            r4 = 0
        L_0x003b:
            boolean r7 = jumio.core.C21364k0.m42129a((android.content.Context) r10)     // Catch:{ Exception -> 0x00dc }
            java.util.TimeZone r2 = java.util.TimeZone.getDefault()     // Catch:{ Exception -> 0x00dc }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00dc }
            int r2 = r2.getOffset(r5)     // Catch:{ Exception -> 0x00dc }
            r5 = 3600000(0x36ee80, float:5.044674E-39)
            int r6 = r2 / r5
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00dc }
            r2.<init>()     // Catch:{ Exception -> 0x00dc }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00dc }
            r8 = 24
            if (r5 < r8) goto L_0x00a2
            android.content.Context r5 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Configuration r5 = r5.getConfiguration()     // Catch:{ Exception -> 0x00dc }
            android.os.LocaleList r5 = r5.getLocales()     // Catch:{ Exception -> 0x00dc }
            if (r5 == 0) goto L_0x008d
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x00dc }
            r2.<init>()     // Catch:{ Exception -> 0x00dc }
            r8 = 0
        L_0x0073:
            int r9 = r5.size()     // Catch:{ Exception -> 0x00dc }
            if (r8 >= r9) goto L_0x008d
            java.util.Locale r9 = r5.get(r8)     // Catch:{ Exception -> 0x00dc }
            if (r9 == 0) goto L_0x008a
            java.util.Locale r9 = r5.get(r8)     // Catch:{ Exception -> 0x00dc }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00dc }
            r2.add(r9)     // Catch:{ Exception -> 0x00dc }
        L_0x008a:
            int r8 = r8 + 1
            goto L_0x0073
        L_0x008d:
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Configuration r10 = r10.getConfiguration()     // Catch:{ Exception -> 0x00dc }
            android.os.LocaleList r10 = r10.getLocales()     // Catch:{ Exception -> 0x00dc }
            java.util.Locale r10 = r10.get(r11)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00b0
        L_0x00a2:
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Resources r10 = r10.getResources()     // Catch:{ Exception -> 0x00dc }
            android.content.res.Configuration r10 = r10.getConfiguration()     // Catch:{ Exception -> 0x00dc }
            java.util.Locale r10 = r10.locale     // Catch:{ Exception -> 0x00dc }
        L_0x00b0:
            r5 = r2
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x00d2
            java.lang.String r2 = r10.toString()     // Catch:{ Exception -> 0x00dc }
            java.lang.String r10 = r10.getCountry()     // Catch:{ Exception -> 0x00dc }
            boolean r8 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00dc }
            if (r8 != 0) goto L_0x00d0
            int r8 = r10.length()     // Catch:{ Exception -> 0x00dc }
            r9 = 2
            if (r8 != r9) goto L_0x00d0
            java.lang.String r10 = com.jumio.sdk.util.IsoCountryConverter.convertToAlpha3(r10)     // Catch:{ Exception -> 0x00dc }
            r8 = r10
            goto L_0x00d4
        L_0x00d0:
            r8 = r11
            goto L_0x00d4
        L_0x00d2:
            r2 = r11
            r8 = r2
        L_0x00d4:
            java.lang.String r9 = r0.getCountryForIp()     // Catch:{ Exception -> 0x00dc }
            r1.mo175779a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00e2
        L_0x00dc:
            r10 = move-exception
            java.lang.String r11 = "Failed to build analytics data points model"
            com.jumio.commons.log.Log.m39463e((java.lang.String) r11, (java.lang.Throwable) r10)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21377r.m42193a(android.content.Context, com.jumio.core.persistence.DataManager):void");
    }

    /* renamed from: b */
    public static void m42195b(Context context, String str) {
        m42194a(context, str, m42190a(context, str) + 1);
    }

    /* renamed from: a */
    public static int m42190a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = SystemUtils.getSharedPreferences(context, "Jumio01", 0)) == null) {
            return 0;
        }
        return sharedPreferences.getInt(str, 0);
    }

    /* renamed from: a */
    public static void m42194a(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = SystemUtils.getSharedPreferences(context, "Jumio01", 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(str, i);
            edit.apply();
        }
    }

    /* renamed from: a */
    public static void m42192a(Context context, long j) {
        SharedPreferences sharedPreferences;
        if (context != null && (sharedPreferences = SystemUtils.getSharedPreferences(context, "Jumio01", 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("Jumio06", j);
            edit.apply();
        }
    }

    /* renamed from: a */
    public static long m42191a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = SystemUtils.getSharedPreferences(context, "Jumio01", 0)) == null) {
            return -1;
        }
        return sharedPreferences.getLong("Jumio06", -1);
    }
}
