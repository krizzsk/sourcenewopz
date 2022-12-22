package com.didiglobal.pay.paysecure.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.foundation.util.AlgorithmUtil;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u001d\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\b\u0010\u0012\u001a\u0004\u0018\u0001H\u0011H\u0002¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/util/DeviceUtils;", "", "()V", "sCachedDeviceId", "", "sInitial", "Ljava/util/concurrent/atomic/AtomicBoolean;", "createVirtualDeviceId", "getDeviceId", "context", "Landroid/content/Context;", "init", "", "isValidDeviceId", "", "imei", "requireNonNull", "T", "obj", "(Ljava/lang/Object;)Ljava/lang/Object;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DeviceUtils.kt */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    /* renamed from: a */
    private static final AtomicBoolean f50469a = new AtomicBoolean(false);

    /* renamed from: b */
    private static String f50470b;

    private DeviceUtils() {
    }

    public final void init(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (!f50469a.getAndSet(true)) {
            m36281a(context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:19|(1:21)|24|25|(1:27)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0074 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String getDeviceId(android.content.Context r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m36281a(r6)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = f50470b     // Catch:{ all -> 0x009b }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x009b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x0012
            java.lang.String r6 = f50470b     // Catch:{ all -> 0x009b }
            goto L_0x0099
        L_0x0012:
            if (r6 != 0) goto L_0x0017
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ all -> 0x009b }
        L_0x0017:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r0.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r6.getPackageName()     // Catch:{ all -> 0x009b }
            r0.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "_preferences"
            r0.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x009b }
            r1 = 0
            android.content.SharedPreferences r0 = com.didi.sdk.apm.SystemUtils.getSharedPreferences(r6, r0, r1)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "imei_"
            r2 = 0
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r0.getString(r1, r3)     // Catch:{ all -> 0x009b }
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x009b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x0048
            f50470b = r1     // Catch:{ all -> 0x009b }
            r6 = r1
            goto L_0x0099
        L_0x0048:
            r1 = r2
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x009b }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x009b }
            r4 = 28
            if (r3 > r4) goto L_0x007b
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            int r3 = r6.checkCallingOrSelfPermission(r3)     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x007b
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "phone"
            java.lang.Object r6 = r6.getSystemService(r3)     // Catch:{ Exception -> 0x0074 }
            if (r6 == 0) goto L_0x006c
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch:{ Exception -> 0x0074 }
            if (r6 == 0) goto L_0x0074
            java.lang.String r2 = r6.getDeviceId()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0074
        L_0x006c:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException     // Catch:{ Exception -> 0x0074 }
            java.lang.String r3 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            r6.<init>(r3)     // Catch:{ Exception -> 0x0074 }
            throw r6     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            boolean r6 = r5.m36283a((java.lang.String) r2)     // Catch:{ all -> 0x009b }
            if (r6 == 0) goto L_0x007b
            r1 = r2
        L_0x007b:
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x009b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x009b }
            if (r6 == 0) goto L_0x0089
            java.lang.String r6 = r5.m36282a()     // Catch:{ all -> 0x009b }
            goto L_0x008a
        L_0x0089:
            r6 = r1
        L_0x008a:
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "imei_"
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r6)     // Catch:{ all -> 0x009b }
            r0.apply()     // Catch:{ all -> 0x009b }
            f50470b = r6     // Catch:{ all -> 0x009b }
        L_0x0099:
            monitor-exit(r5)
            return r6
        L_0x009b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.pay.paysecure.util.DeviceUtils.getDeviceId(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    private final boolean m36283a(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            if (str == null) {
                Intrinsics.throwNpe();
            }
            if (str.length() >= 15) {
                int length = str.length() - 1;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    char charAt = str.charAt(i);
                    i++;
                    if (charAt != str.charAt(i)) {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private final String m36282a() {
        SecureRandom secureRandom = new SecureRandom();
        return AlgorithmUtil.md5(Build.BRAND + Build.MODEL + Build.FINGERPRINT + System.nanoTime() + secureRandom.nextLong());
    }

    /* renamed from: a */
    private final <T> T m36281a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
