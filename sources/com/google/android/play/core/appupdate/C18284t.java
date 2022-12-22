package com.google.android.play.core.appupdate;

import android.app.PendingIntent;

/* renamed from: com.google.android.play.core.appupdate.t */
final class C18284t extends AppUpdateInfo {

    /* renamed from: a */
    private final String f52654a;

    /* renamed from: b */
    private final int f52655b;

    /* renamed from: c */
    private final int f52656c;

    /* renamed from: d */
    private final int f52657d;

    /* renamed from: e */
    private final Integer f52658e;

    /* renamed from: f */
    private final int f52659f;

    /* renamed from: g */
    private final long f52660g;

    /* renamed from: h */
    private final long f52661h;

    /* renamed from: i */
    private final long f52662i;

    /* renamed from: j */
    private final long f52663j;

    /* renamed from: k */
    private final PendingIntent f52664k;

    /* renamed from: l */
    private final PendingIntent f52665l;

    /* renamed from: m */
    private final PendingIntent f52666m;

    /* renamed from: n */
    private final PendingIntent f52667n;

    C18284t(String str, int i, int i2, int i3, Integer num, int i4, long j, long j2, long j3, long j4, PendingIntent pendingIntent, PendingIntent pendingIntent2, PendingIntent pendingIntent3, PendingIntent pendingIntent4) {
        String str2 = str;
        if (str2 != null) {
            this.f52654a = str2;
            this.f52655b = i;
            this.f52656c = i2;
            this.f52657d = i3;
            this.f52658e = num;
            this.f52659f = i4;
            this.f52660g = j;
            this.f52661h = j2;
            this.f52662i = j3;
            this.f52663j = j4;
            this.f52664k = pendingIntent;
            this.f52665l = pendingIntent2;
            this.f52666m = pendingIntent3;
            this.f52667n = pendingIntent4;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo148769a() {
        return this.f52662i;
    }

    public final int availableVersionCode() {
        return this.f52655b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo148772b() {
        return this.f52663j;
    }

    public final long bytesDownloaded() {
        return this.f52660g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final PendingIntent mo148774c() {
        return this.f52664k;
    }

    public final Integer clientVersionStalenessDays() {
        return this.f52658e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final PendingIntent mo148776d() {
        return this.f52665l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final PendingIntent mo148777e() {
        return this.f52666m;
    }

    public final boolean equals(Object obj) {
        Integer num;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateInfo) {
            AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
            if (this.f52654a.equals(appUpdateInfo.packageName()) && this.f52655b == appUpdateInfo.availableVersionCode() && this.f52656c == appUpdateInfo.updateAvailability() && this.f52657d == appUpdateInfo.installStatus() && ((num = this.f52658e) != null ? num.equals(appUpdateInfo.clientVersionStalenessDays()) : appUpdateInfo.clientVersionStalenessDays() == null) && this.f52659f == appUpdateInfo.updatePriority() && this.f52660g == appUpdateInfo.bytesDownloaded() && this.f52661h == appUpdateInfo.totalBytesToDownload() && this.f52662i == appUpdateInfo.mo148769a() && this.f52663j == appUpdateInfo.mo148772b() && ((pendingIntent = this.f52664k) != null ? pendingIntent.equals(appUpdateInfo.mo148774c()) : appUpdateInfo.mo148774c() == null) && ((pendingIntent2 = this.f52665l) != null ? pendingIntent2.equals(appUpdateInfo.mo148776d()) : appUpdateInfo.mo148776d() == null) && ((pendingIntent3 = this.f52666m) != null ? pendingIntent3.equals(appUpdateInfo.mo148777e()) : appUpdateInfo.mo148777e() == null)) {
                PendingIntent pendingIntent4 = this.f52667n;
                PendingIntent f = appUpdateInfo.mo148778f();
                if (pendingIntent4 != null ? pendingIntent4.equals(f) : f == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final PendingIntent mo148778f() {
        return this.f52667n;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f52654a.hashCode() ^ 1000003) * 1000003) ^ this.f52655b) * 1000003) ^ this.f52656c) * 1000003) ^ this.f52657d) * 1000003;
        Integer num = this.f52658e;
        int i = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        int i2 = this.f52659f;
        long j = this.f52660g;
        long j2 = this.f52661h;
        long j3 = this.f52662i;
        long j4 = this.f52663j;
        int i3 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        PendingIntent pendingIntent = this.f52664k;
        int hashCode3 = (i3 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.f52665l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.f52666m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.f52667n;
        if (pendingIntent4 != null) {
            i = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i;
    }

    public final int installStatus() {
        return this.f52657d;
    }

    public final String packageName() {
        return this.f52654a;
    }

    public final String toString() {
        String str = this.f52654a;
        int i = this.f52655b;
        int i2 = this.f52656c;
        int i3 = this.f52657d;
        String valueOf = String.valueOf(this.f52658e);
        int i4 = this.f52659f;
        long j = this.f52660g;
        long j2 = this.f52661h;
        long j3 = this.f52662i;
        long j4 = this.f52663j;
        String valueOf2 = String.valueOf(this.f52664k);
        long j5 = j4;
        String valueOf3 = String.valueOf(this.f52665l);
        String valueOf4 = String.valueOf(this.f52666m);
        long j6 = j3;
        String valueOf5 = String.valueOf(this.f52667n);
        int length = str.length();
        int length2 = String.valueOf(valueOf).length();
        int length3 = String.valueOf(valueOf2).length();
        int length4 = String.valueOf(valueOf3).length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        sb.append(", updateAvailability=");
        sb.append(i2);
        sb.append(", installStatus=");
        sb.append(i3);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", additionalSpaceRequired=");
        sb.append(j6);
        sb.append(", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf3);
        sb.append(", immediateDestructiveUpdateIntent=");
        sb.append(valueOf4);
        sb.append(", flexibleDestructiveUpdateIntent=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f52661h;
    }

    public final int updateAvailability() {
        return this.f52656c;
    }

    public final int updatePriority() {
        return this.f52659f;
    }
}
