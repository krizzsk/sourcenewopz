package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.a */
final class C18548a extends SplitInstallSessionState {

    /* renamed from: a */
    private final int f53261a;

    /* renamed from: b */
    private final int f53262b;

    /* renamed from: c */
    private final int f53263c;

    /* renamed from: d */
    private final long f53264d;

    /* renamed from: e */
    private final long f53265e;

    /* renamed from: f */
    private final List<String> f53266f;

    /* renamed from: g */
    private final List<String> f53267g;

    /* renamed from: h */
    private final PendingIntent f53268h;

    /* renamed from: i */
    private final List<Intent> f53269i;

    C18548a(int i, int i2, int i3, long j, long j2, List<String> list, List<String> list2, PendingIntent pendingIntent, List<Intent> list3) {
        this.f53261a = i;
        this.f53262b = i2;
        this.f53263c = i3;
        this.f53264d = j;
        this.f53265e = j2;
        this.f53266f = list;
        this.f53267g = list2;
        this.f53268h = pendingIntent;
        this.f53269i = list3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final List<String> mo149263a() {
        return this.f53266f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final List<String> mo149264b() {
        return this.f53267g;
    }

    public final long bytesDownloaded() {
        return this.f53264d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final List<Intent> mo149266c() {
        return this.f53269i;
    }

    public final boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        PendingIntent pendingIntent;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SplitInstallSessionState) {
            SplitInstallSessionState splitInstallSessionState = (SplitInstallSessionState) obj;
            if (this.f53261a == splitInstallSessionState.sessionId() && this.f53262b == splitInstallSessionState.status() && this.f53263c == splitInstallSessionState.errorCode() && this.f53264d == splitInstallSessionState.bytesDownloaded() && this.f53265e == splitInstallSessionState.totalBytesToDownload() && ((list = this.f53266f) != null ? list.equals(splitInstallSessionState.mo149263a()) : splitInstallSessionState.mo149263a() == null) && ((list2 = this.f53267g) != null ? list2.equals(splitInstallSessionState.mo149264b()) : splitInstallSessionState.mo149264b() == null) && ((pendingIntent = this.f53268h) != null ? pendingIntent.equals(splitInstallSessionState.resolutionIntent()) : splitInstallSessionState.resolutionIntent() == null)) {
                List<Intent> list3 = this.f53269i;
                List<Intent> c = splitInstallSessionState.mo149266c();
                if (list3 != null ? list3.equals(c) : c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int errorCode() {
        return this.f53263c;
    }

    public final int hashCode() {
        int i = this.f53261a;
        int i2 = this.f53262b;
        int i3 = this.f53263c;
        long j = this.f53264d;
        long j2 = this.f53265e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f53266f;
        int i5 = 0;
        int hashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f53267g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f53268h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f53269i;
        if (list3 != null) {
            i5 = list3.hashCode();
        }
        return hashCode3 ^ i5;
    }

    @Deprecated
    public final PendingIntent resolutionIntent() {
        return this.f53268h;
    }

    public final int sessionId() {
        return this.f53261a;
    }

    public final int status() {
        return this.f53262b;
    }

    public final String toString() {
        int i = this.f53261a;
        int i2 = this.f53262b;
        int i3 = this.f53263c;
        long j = this.f53264d;
        long j2 = this.f53265e;
        String valueOf = String.valueOf(this.f53266f);
        String valueOf2 = String.valueOf(this.f53267g);
        String valueOf3 = String.valueOf(this.f53268h);
        String valueOf4 = String.valueOf(this.f53269i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f53265e;
    }
}
