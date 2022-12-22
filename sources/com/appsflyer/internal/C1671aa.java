package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AppsFlyerLibCore;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.appsflyer.internal.aa */
public final class C1671aa {

    /* renamed from: ɩ */
    private static C1671aa f1890 = new C1671aa();

    private C1671aa() {
    }

    /* renamed from: ǃ */
    public static C1671aa m1608() {
        return f1890;
    }

    /* renamed from: ι */
    public static File m1611(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    /* renamed from: ǃ */
    public static List<C1700j> m1609(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb = new StringBuilder("Found cached request");
                    sb.append(file2.getName());
                    SystemUtils.log(4, AppsFlyerLibCore.LOG_TAG, sb.toString(), (Throwable) null, "com.appsflyer.internal.aa", 110);
                    arrayList.add(m1607(file2));
                }
            }
        } catch (Exception unused) {
            SystemUtils.log(4, AppsFlyerLibCore.LOG_TAG, "Could not cache request", (Throwable) null, "com.appsflyer.internal.aa", 115);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025 A[SYNTHETIC, Splitter:B:13:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* renamed from: ı */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.C1700j m1607(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            int r3 = (int) r2     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            char[] r2 = new char[r3]     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r1.read(r2)     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            com.appsflyer.internal.j r3 = new com.appsflyer.internal.j     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r3.f1993 = r4     // Catch:{ Exception -> 0x002a, all -> 0x001f }
            r1.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            return r3
        L_0x001f:
            r4 = move-exception
            r0 = r1
            goto L_0x0023
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            throw r4
        L_0x0029:
            r1 = r0
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.C1671aa.m1607(java.io.File):com.appsflyer.internal.j");
    }

    /* renamed from: ǃ */
    public static void m1610(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb = new StringBuilder("Deleting ");
        sb.append(str);
        sb.append(" from cache");
        SystemUtils.log(4, AppsFlyerLibCore.LOG_TAG, sb.toString(), (Throwable) null, "com.appsflyer.internal.aa", 145);
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder("Could not delete ");
                sb2.append(str);
                sb2.append(" from cache");
                SystemUtils.log(4, AppsFlyerLibCore.LOG_TAG, sb2.toString(), e, "com.appsflyer.internal.aa", 150);
            }
        }
    }
}
