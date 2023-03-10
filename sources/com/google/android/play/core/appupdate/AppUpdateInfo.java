package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

public abstract class AppUpdateInfo {
    /* renamed from: a */
    public static AppUpdateInfo m37370a(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        return new C18284t(str, i, i2, i3, num, i4, j, j2, j3, j4, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4);
    }

    /* renamed from: b */
    private final boolean m37371b(AppUpdateOptions appUpdateOptions) {
        return appUpdateOptions.allowAssetPackDeletion() && mo148769a() <= mo148772b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract long mo148769a();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final PendingIntent mo148770a(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() != 0) {
            if (appUpdateOptions.appUpdateType() == 1) {
                if (mo148774c() != null) {
                    return mo148774c();
                }
                if (m37371b(appUpdateOptions)) {
                    return mo148777e();
                }
            }
            return null;
        } else if (mo148776d() != null) {
            return mo148776d();
        } else {
            if (m37371b(appUpdateOptions)) {
                return mo148778f();
            }
            return null;
        }
    }

    public abstract int availableVersionCode();

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract long mo148772b();

    public abstract long bytesDownloaded();

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public abstract PendingIntent mo148774c();

    public abstract Integer clientVersionStalenessDays();

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public abstract PendingIntent mo148776d();

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public abstract PendingIntent mo148777e();

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public abstract PendingIntent mo148778f();

    public abstract int installStatus();

    public boolean isUpdateTypeAllowed(int i) {
        return mo148770a(AppUpdateOptions.defaultOptions(i)) != null;
    }

    public boolean isUpdateTypeAllowed(AppUpdateOptions appUpdateOptions) {
        return mo148770a(appUpdateOptions) != null;
    }

    public abstract String packageName();

    public abstract long totalBytesToDownload();

    public abstract int updateAvailability();

    public abstract int updatePriority();
}
