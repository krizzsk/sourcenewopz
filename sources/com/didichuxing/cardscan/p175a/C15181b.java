package com.didichuxing.cardscan.p175a;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.didichuxing.cardscan.a.b */
public class C15181b {
    /* renamed from: a */
    public static boolean m33165a(Context context) {
        String str;
        if (context != null) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                if (packageName.equals("com.didiglobal.passenger")) {
                    str = "Global_DDCardDetector";
                } else if (packageName.equals("com.taxis99")) {
                    str = "Brazil_DDCardDetector";
                } else if (packageName.equals("com.sdu.didi.psnger")) {
                    str = "DDCardDetector_Config";
                }
                return m33166a(str);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r3 = r3.getExperiment();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m33166a(java.lang.String r3) {
        /*
            r0 = 0
            com.didichuxing.apollo.sdk.IToggle r3 = com.didichuxing.apollo.sdk.Apollo.getToggle(r3)     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x002c
            boolean r1 = r3.allow()     // Catch:{ Exception -> 0x0028 }
            if (r1 == 0) goto L_0x002c
            com.didichuxing.apollo.sdk.IExperiment r3 = r3.getExperiment()     // Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x002c
            java.lang.String r1 = "expiryEnable"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0028 }
            java.lang.Object r3 = r3.getParam(r1, r2)     // Catch:{ Exception -> 0x0028 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ Exception -> 0x0028 }
            int r3 = r3.intValue()     // Catch:{ Exception -> 0x0028 }
            r1 = 1
            if (r3 != r1) goto L_0x002c
            r0 = 1
            goto L_0x002c
        L_0x0028:
            r3 = move-exception
            r3.printStackTrace()
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.cardscan.p175a.C15181b.m33166a(java.lang.String):boolean");
    }
}
