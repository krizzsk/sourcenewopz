package com.didichuxing.bigdata.p173dp.locsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.bigdata.p173dp.locsdk.BuildConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.utils.TraceUtils */
public class TraceUtils {

    /* renamed from: a */
    static final String f46180a = "trace_sdk_pref";

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* renamed from: a */
    static String m33157a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() < 3) {
            return str;
        }
        int length = str.length();
        int i = length - 1;
        char charAt = str.charAt(i);
        int i2 = length - 3;
        String substring = str.substring(i2, i);
        StringBuilder sb = new StringBuilder(str);
        StringBuilder delete = sb.delete(i2, length);
        delete.append(charAt);
        delete.append(substring);
        return Base64.encodeToString(sb.toString().getBytes(), 0);
    }

    /* renamed from: b */
    static String m33159b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() < 3) {
            return str;
        }
        String str2 = new String(Base64.decode(str, 0));
        int length = str2.length();
        String substring = str2.substring(length - 2, length);
        int i = length - 3;
        char charAt = str2.charAt(i);
        StringBuilder sb = new StringBuilder(str2);
        StringBuilder delete = sb.delete(i, length);
        delete.append(substring);
        delete.append(charAt);
        return sb.toString();
    }

    public static String encryptUidByAppVersion(Context context, String str) {
        return encryptUidByAppVersion(context, str, getAppVersion(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encryptUidByAppVersion(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r0 = ""
            if (r7 != 0) goto L_0x0045
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            if (r7 != 0) goto L_0x0045
            java.lang.String r7 = "."
            java.lang.String r7 = r9.replace(r7, r0)     // Catch:{ Exception -> 0x0045 }
            long r1 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0045 }
            long r3 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0045 }
            long r1 = r1 * r3
            r3 = 65535(0xffff, double:3.23786E-319)
            long r1 = r1 & r3
            r7 = 32
            long r3 = r1 << r7
            r7 = 16
            long r5 = r1 << r7
            long r3 = r3 | r5
            long r1 = r1 | r3
            java.lang.String r7 = m33160c(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            r3.append(r7)     // Catch:{ Exception -> 0x0045 }
            long r4 = java.lang.Long.parseLong(r8)     // Catch:{ Exception -> 0x0045 }
            long r1 = r1 ^ r4
            r3.append(r1)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r7 = r8
        L_0x0046:
            boolean r1 = android.text.TextUtils.equals(r8, r7)
            if (r1 == 0) goto L_0x006d
            java.lang.Throwable r1 = new java.lang.Throwable
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r8)
            java.lang.String r8 = ","
            r2.append(r8)
            r2.append(r9)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8)
            java.lang.String r8 = "tracesdk_err_encrypt_uid"
            m33158a(r8, r1)
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils.encryptUidByAppVersion(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String decryptUidByAppVersion(Context context, String str) {
        return decryptUidByAppVersion(context, str, getAppVersion(context));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decryptUidByAppVersion(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            boolean r7 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r0 = ""
            if (r7 != 0) goto L_0x0045
            boolean r7 = android.text.TextUtils.isEmpty(r9)
            if (r7 != 0) goto L_0x0045
            java.lang.String r7 = "."
            java.lang.String r7 = r9.replace(r7, r0)     // Catch:{ Exception -> 0x0045 }
            long r1 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0045 }
            long r3 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x0045 }
            long r1 = r1 * r3
            r3 = 65535(0xffff, double:3.23786E-319)
            long r1 = r1 & r3
            r7 = 32
            long r3 = r1 << r7
            r7 = 16
            long r5 = r1 << r7
            long r3 = r3 | r5
            long r1 = r1 | r3
            java.lang.String r7 = m33160c(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            r3.append(r7)     // Catch:{ Exception -> 0x0045 }
            long r4 = java.lang.Long.parseLong(r8)     // Catch:{ Exception -> 0x0045 }
            long r1 = r1 ^ r4
            r3.append(r1)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r7 = r8
        L_0x0046:
            boolean r1 = android.text.TextUtils.equals(r7, r8)
            if (r1 == 0) goto L_0x006d
            java.lang.Throwable r1 = new java.lang.Throwable
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r8)
            java.lang.String r8 = ","
            r2.append(r8)
            r2.append(r9)
            java.lang.String r8 = r2.toString()
            r1.<init>(r8)
            java.lang.String r8 = "tracesdk_err_decrypt_uid"
            m33158a(r8, r1)
        L_0x006d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.utils.TraceUtils.decryptUidByAppVersion(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    private static String m33160c(String str) {
        char charAt;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (i != str.length() && ((charAt = str.charAt(i)) == '+' || charAt == '0')) {
                sb.append(charAt);
                i++;
            }
        }
        return sb.toString();
    }

    public static void setPhone(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String appVersion = getAppVersion(context);
            SystemUtils.getSharedPreferences(context, f46180a, 0).edit().putString("phone", encryptUidByAppVersion(context, str, appVersion)).putString("phone_version", appVersion).apply();
        }
    }

    public static String getPhone(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, f46180a, 0);
        String string = sharedPreferences.getString("phone", "");
        String string2 = sharedPreferences.getString("phone_version", "");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            return decryptUidByAppVersion(context, string, string2);
        }
        try {
            ILoginStoreApi store = OneLoginFacade.getStore();
            String globalPhone = store != null ? store.getGlobalPhone() : null;
            if (!TextUtils.isEmpty(globalPhone)) {
                return globalPhone;
            }
            return "";
        } catch (NoClassDefFoundError e) {
            m33158a("tracesdk_err_getphone", e);
        } catch (Exception e2) {
            m33158a("tracesdk_err_getphone", e2);
        }
    }

    public static String getUid(Context context) {
        try {
            ILoginStoreApi store = OneLoginFacade.getStore();
            String uid = store != null ? store.getUid() : null;
            if (!TextUtils.isEmpty(uid)) {
                return uid;
            }
            return "";
        } catch (NoClassDefFoundError e) {
            m33158a("tracesdk_err_getuid", e);
            return "";
        } catch (Exception e2) {
            m33158a("tracesdk_err_getuid", e2);
            return "";
        }
    }

    /* renamed from: a */
    private static void m33158a(String str, Throwable th) {
        if (str != null && th != null) {
            Event event = new Event(str);
            event.putAttr("errmsg", th.getMessage());
            event.putAttr("sdk_ver", BuildConfig.VERSION_NAME);
            OmegaSDKAdapter.trackEvent(event);
        }
    }
}
