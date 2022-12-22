package com.adyen.checkout.components.analytics;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.LogUtil;

public class AnalyticsDispatcher extends JobIntentService {

    /* renamed from: a */
    private static final String f618a = LogUtil.getTag();

    /* renamed from: b */
    private static final String f619b = "analytic_event";

    /* renamed from: c */
    private static final String f620c = "env_url_key";

    /* renamed from: d */
    private static final String f621d = "images/analytics.png";

    /* renamed from: e */
    private static final int f622e = 4747;

    public static void dispatchEvent(Context context, Environment environment, AnalyticEvent analyticEvent) {
        Intent intent = new Intent();
        intent.putExtra(f619b, analyticEvent);
        intent.putExtra(f620c, environment.getBaseUrl());
        enqueueWork(context, (Class<?>) AnalyticsDispatcher.class, 4747, intent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (r0 != null) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleWork(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "analytic_event"
            android.os.Parcelable r0 = r4.getParcelableExtra(r0)
            com.adyen.checkout.components.analytics.AnalyticEvent r0 = (com.adyen.checkout.components.analytics.AnalyticEvent) r0
            java.lang.String r1 = "env_url_key"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r0 != 0) goto L_0x0018
            java.lang.String r4 = f618a
            java.lang.String r0 = "Analytics event is null."
            com.adyen.checkout.core.log.Logger.m1078e(r4, r0)
            return
        L_0x0018:
            if (r4 != 0) goto L_0x0022
            java.lang.String r4 = f618a
            java.lang.String r0 = "env url is null."
            com.adyen.checkout.core.log.Logger.m1078e(r4, r0)
            return
        L_0x0022:
            java.lang.String r1 = f618a
            java.lang.String r2 = "Sending analytic event."
            com.adyen.checkout.core.log.Logger.m1082v(r1, r2)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0075 }
            r2.<init>()     // Catch:{ IOException -> 0x0075 }
            r2.append(r4)     // Catch:{ IOException -> 0x0075 }
            java.lang.String r4 = "images/analytics.png"
            r2.append(r4)     // Catch:{ IOException -> 0x0075 }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0075 }
            java.net.URL r4 = r0.mo14301a(r4)     // Catch:{ IOException -> 0x0075 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0075 }
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ IOException -> 0x0075 }
            javax.net.ssl.SSLSocketFactory r0 = com.adyen.checkout.core.api.SSLSocketUtil.TLS_SOCKET_FACTORY     // Catch:{ IOException -> 0x0070, all -> 0x006d }
            r4.setSSLSocketFactory(r0)     // Catch:{ IOException -> 0x0070, all -> 0x006d }
            r4.connect()     // Catch:{ IOException -> 0x0070, all -> 0x006d }
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ IOException -> 0x0070, all -> 0x006d }
            r0.read()     // Catch:{ all -> 0x005f }
            if (r0 == 0) goto L_0x0059
            r0.close()     // Catch:{ IOException -> 0x0070, all -> 0x006d }
        L_0x0059:
            if (r4 == 0) goto L_0x0082
            r4.disconnect()
            goto L_0x0082
        L_0x005f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r2 = move-exception
            if (r0 == 0) goto L_0x006c
            r0.close()     // Catch:{ all -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x0070, all -> 0x006d }
        L_0x006c:
            throw r2     // Catch:{ IOException -> 0x0070, all -> 0x006d }
        L_0x006d:
            r0 = move-exception
            r1 = r4
            goto L_0x0083
        L_0x0070:
            r0 = move-exception
            r1 = r4
            goto L_0x0076
        L_0x0073:
            r0 = move-exception
            goto L_0x0083
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            java.lang.String r4 = f618a     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "Failed to send analytics event."
            com.adyen.checkout.core.log.Logger.m1079e(r4, r2, r0)     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x0082
            r1.disconnect()
        L_0x0082:
            return
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            r1.disconnect()
        L_0x0088:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.analytics.AnalyticsDispatcher.onHandleWork(android.content.Intent):void");
    }
}
