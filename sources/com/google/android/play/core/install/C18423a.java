package com.google.android.play.core.install;

/* renamed from: com.google.android.play.core.install.a */
final class C18423a extends InstallState {

    /* renamed from: a */
    private final int f53121a;

    /* renamed from: b */
    private final long f53122b;

    /* renamed from: c */
    private final long f53123c;

    /* renamed from: d */
    private final int f53124d;

    /* renamed from: e */
    private final String f53125e;

    C18423a(int i, long j, long j2, int i2, String str) {
        this.f53121a = i;
        this.f53122b = j;
        this.f53123c = j2;
        this.f53124d = i2;
        if (str != null) {
            this.f53125e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final long bytesDownloaded() {
        return this.f53122b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            return this.f53121a == installState.installStatus() && this.f53122b == installState.bytesDownloaded() && this.f53123c == installState.totalBytesToDownload() && this.f53124d == installState.installErrorCode() && this.f53125e.equals(installState.packageName());
        }
    }

    public final int hashCode() {
        int i = this.f53121a;
        long j = this.f53122b;
        long j2 = this.f53123c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f53124d) * 1000003) ^ this.f53125e.hashCode();
    }

    public final int installErrorCode() {
        return this.f53124d;
    }

    public final int installStatus() {
        return this.f53121a;
    }

    public final String packageName() {
        return this.f53125e;
    }

    public final String toString() {
        int i = this.f53121a;
        long j = this.f53122b;
        long j2 = this.f53123c;
        int i2 = this.f53124d;
        String str = this.f53125e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f53123c;
    }
}
