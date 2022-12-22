package com.appsflyer.internal.referrer;

import android.content.Context;
import com.appsflyer.internal.ContentFetcher;
import java.util.Map;

public class HuaweiReferrer extends ContentFetcher<Map<String, Object>> {
    public Map<String, Object> map;

    /* renamed from: ɩ */
    private Runnable f2019;

    public HuaweiReferrer(Runnable runnable, Context context) {
        super(context, "com.huawei.appmarket.commondata", "ffe391e0ea186d0734ed601e4e70e3224b7309d48e2075bac46d8c667eae7212", 0);
        this.f2019 = runnable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0092, code lost:
        if (r3 == null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0094, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0097, code lost:
        r12.map = r2;
        r12.f2019.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009e, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0086, code lost:
        if (r3 != null) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> query() {
        /*
            r12 = this;
            java.lang.String r0 = "FEATURE_NOT_SUPPORTED"
            java.lang.String r1 = "response"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r3 = "source"
            java.lang.String r4 = "huawei"
            r2.put(r3, r4)
            com.appsflyer.internal.referrer.MandatoryFields r3 = new com.appsflyer.internal.referrer.MandatoryFields
            r3.<init>()
            r2.putAll(r3)
            r3 = 0
            android.content.Context r4 = r12.context     // Catch:{ Exception -> 0x008b }
            android.content.ContentResolver r5 = r4.getContentResolver()     // Catch:{ Exception -> 0x008b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008b }
            java.lang.String r6 = "content://"
            r4.<init>(r6)     // Catch:{ Exception -> 0x008b }
            java.lang.String r6 = r12.authority     // Catch:{ Exception -> 0x008b }
            r4.append(r6)     // Catch:{ Exception -> 0x008b }
            java.lang.String r6 = "/item/5"
            r4.append(r6)     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x008b }
            android.net.Uri r6 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x008b }
            r7 = 0
            r8 = 0
            r4 = 1
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ Exception -> 0x008b }
            android.content.Context r10 = r12.context     // Catch:{ Exception -> 0x008b }
            java.lang.String r10 = r10.getPackageName()     // Catch:{ Exception -> 0x008b }
            r11 = 0
            r9[r11] = r10     // Catch:{ Exception -> 0x008b }
            r10 = 0
            android.database.Cursor r3 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x008b }
            if (r3 == 0) goto L_0x0081
            boolean r5 = r3.moveToFirst()     // Catch:{ Exception -> 0x008b }
            if (r5 == 0) goto L_0x007d
            java.lang.String r5 = "OK"
            r2.put(r1, r5)     // Catch:{ Exception -> 0x008b }
            java.lang.String r5 = "referrer"
            java.lang.String r6 = r3.getString(r11)     // Catch:{ Exception -> 0x008b }
            r2.put(r5, r6)     // Catch:{ Exception -> 0x008b }
            java.lang.String r5 = "install_begin_ts"
            long r6 = r3.getLong(r4)     // Catch:{ Exception -> 0x008b }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x008b }
            r2.put(r5, r4)     // Catch:{ Exception -> 0x008b }
            java.lang.String r4 = "install_end_ts"
            r5 = 2
            long r5 = r3.getLong(r5)     // Catch:{ Exception -> 0x008b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x008b }
            r2.put(r4, r5)     // Catch:{ Exception -> 0x008b }
            goto L_0x0086
        L_0x007d:
            r2.put(r1, r0)     // Catch:{ Exception -> 0x008b }
            goto L_0x0086
        L_0x0081:
            java.lang.String r4 = "SERVICE_UNAVAILABLE"
            r2.put(r1, r4)     // Catch:{ Exception -> 0x008b }
        L_0x0086:
            if (r3 == 0) goto L_0x0097
            goto L_0x0094
        L_0x0089:
            r0 = move-exception
            goto L_0x009f
        L_0x008b:
            r4 = move-exception
            r2.put(r1, r0)     // Catch:{ all -> 0x0089 }
            r12.onError(r4)     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x0097
        L_0x0094:
            r3.close()
        L_0x0097:
            r12.map = r2
            java.lang.Runnable r0 = r12.f2019
            r0.run()
            return r2
        L_0x009f:
            if (r3 == 0) goto L_0x00a4
            r3.close()
        L_0x00a4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.referrer.HuaweiReferrer.query():java.util.Map");
    }
}
