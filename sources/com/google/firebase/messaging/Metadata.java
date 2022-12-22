package com.google.firebase.messaging;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.didi.sdk.apm.SystemUtils;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class Metadata {
    private String appVersionCode;
    private String appVersionName;
    private final Context context;
    private int gmsVersionCode;
    private int iidImplementation = 0;

    Metadata(Context context2) {
        this.context = context2;
    }

    static String getDefaultSenderId(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo getPackageInfo(String str) {
        try {
            return SystemUtils.getPackageInfo(this.context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            SystemUtils.log(5, Constants.TAG, sb.toString(), (Throwable) null, "com.google.firebase.messaging.Metadata", 2);
            return null;
        }
    }

    private synchronized void populateAppVersionInfo() {
        PackageInfo packageInfo = getPackageInfo(this.context.getPackageName());
        if (packageInfo != null) {
            this.appVersionCode = Integer.toString(packageInfo.versionCode);
            this.appVersionName = packageInfo.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String getAppVersionCode() {
        if (this.appVersionCode == null) {
            populateAppVersionInfo();
        }
        return this.appVersionCode;
    }

    /* access modifiers changed from: package-private */
    public synchronized String getAppVersionName() {
        if (this.appVersionName == null) {
            populateAppVersionInfo();
        }
        return this.appVersionName;
    }

    /* access modifiers changed from: package-private */
    public synchronized int getGmsVersionCode() {
        PackageInfo packageInfo;
        if (this.gmsVersionCode == 0 && (packageInfo = getPackageInfo("com.google.android.gms")) != null) {
            this.gmsVersionCode = packageInfo.versionCode;
        }
        return this.gmsVersionCode;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0083, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int getIidImplementation() {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.iidImplementation     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r10)
            return r0
        L_0x0007:
            android.content.Context r0 = r10.context     // Catch:{ all -> 0x0084 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x0084 }
            java.lang.String r1 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r2 = "com.google.android.gms"
            int r1 = r0.checkPermission(r1, r2)     // Catch:{ all -> 0x0084 }
            r2 = -1
            r3 = 0
            if (r1 != r2) goto L_0x0027
            java.lang.String r5 = "FirebaseMessaging"
            java.lang.String r6 = "Google Play services missing or without correct permission."
            r4 = 6
            r7 = 0
            java.lang.String r8 = "com.google.firebase.messaging.Metadata"
            r9 = 3
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0084 }
            monitor-exit(r10)
            return r3
        L_0x0027:
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0084 }
            r2 = 1
            if (r1 != 0) goto L_0x004b
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r1.<init>(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0084 }
            java.util.List r1 = r0.queryIntentServices(r1, r3)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x004b
            int r1 = r1.size()     // Catch:{ all -> 0x0084 }
            if (r1 > 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            r10.iidImplementation = r2     // Catch:{ all -> 0x0084 }
            monitor-exit(r10)
            return r2
        L_0x004b:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r1.<init>(r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = "com.google.android.gms"
            r1.setPackage(r4)     // Catch:{ all -> 0x0084 }
            java.util.List r0 = r0.queryBroadcastReceivers(r1, r3)     // Catch:{ all -> 0x0084 }
            r1 = 2
            if (r0 == 0) goto L_0x0069
            int r0 = r0.size()     // Catch:{ all -> 0x0084 }
            if (r0 > 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            r10.iidImplementation = r1     // Catch:{ all -> 0x0084 }
            monitor-exit(r10)
            return r1
        L_0x0069:
            java.lang.String r4 = "FirebaseMessaging"
            java.lang.String r5 = "Failed to resolve IID implementation package, falling back"
            r3 = 5
            r6 = 0
            java.lang.String r7 = "com.google.firebase.messaging.Metadata"
            r8 = 13
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0084 }
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastO()     // Catch:{ all -> 0x0084 }
            if (r0 == 0) goto L_0x0080
            r10.iidImplementation = r1     // Catch:{ all -> 0x0084 }
            r2 = 2
            goto L_0x0082
        L_0x0080:
            r10.iidImplementation = r2     // Catch:{ all -> 0x0084 }
        L_0x0082:
            monitor-exit(r10)
            return r2
        L_0x0084:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.Metadata.getIidImplementation():int");
    }

    /* access modifiers changed from: package-private */
    public boolean isGmscorePresent() {
        return getIidImplementation() != 0;
    }
}
