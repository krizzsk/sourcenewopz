package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bh */
final class C18325bh extends AssetPackState {

    /* renamed from: a */
    private final String f52813a;

    /* renamed from: b */
    private final int f52814b;

    /* renamed from: c */
    private final int f52815c;

    /* renamed from: d */
    private final long f52816d;

    /* renamed from: e */
    private final long f52817e;

    /* renamed from: f */
    private final int f52818f;

    /* renamed from: g */
    private final int f52819g;

    C18325bh(String str, int i, int i2, long j, long j2, int i3, int i4) {
        if (str != null) {
            this.f52813a = str;
            this.f52814b = i;
            this.f52815c = i2;
            this.f52816d = j;
            this.f52817e = j2;
            this.f52818f = i3;
            this.f52819g = i4;
            return;
        }
        throw new NullPointerException("Null name");
    }

    /* renamed from: a */
    public final int mo148863a() {
        return this.f52819g;
    }

    public final long bytesDownloaded() {
        return this.f52816d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f52813a.equals(assetPackState.name()) && this.f52814b == assetPackState.status() && this.f52815c == assetPackState.errorCode() && this.f52816d == assetPackState.bytesDownloaded() && this.f52817e == assetPackState.totalBytesToDownload() && this.f52818f == assetPackState.transferProgressPercentage() && this.f52819g == assetPackState.mo148863a();
        }
    }

    public final int errorCode() {
        return this.f52815c;
    }

    public final int hashCode() {
        int hashCode = this.f52813a.hashCode();
        int i = this.f52814b;
        int i2 = this.f52815c;
        long j = this.f52816d;
        long j2 = this.f52817e;
        return ((((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f52818f) * 1000003) ^ this.f52819g;
    }

    public final String name() {
        return this.f52813a;
    }

    public final int status() {
        return this.f52814b;
    }

    public final String toString() {
        String str = this.f52813a;
        int i = this.f52814b;
        int i2 = this.f52815c;
        long j = this.f52816d;
        long j2 = this.f52817e;
        int i3 = this.f52818f;
        int i4 = this.f52819g;
        StringBuilder sb = new StringBuilder(str.length() + 217);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append(", updateAvailability=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f52817e;
    }

    public final int transferProgressPercentage() {
        return this.f52818f;
    }
}
