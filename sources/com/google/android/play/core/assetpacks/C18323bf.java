package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.bf */
final class C18323bf extends AssetLocation {

    /* renamed from: a */
    private final String f52807a;

    /* renamed from: b */
    private final long f52808b;

    /* renamed from: c */
    private final long f52809c;

    C18323bf(String str, long j, long j2) {
        if (str != null) {
            this.f52807a = str;
            this.f52808b = j;
            this.f52809c = j2;
            return;
        }
        throw new NullPointerException("Null path");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.f52807a.equals(assetLocation.path()) && this.f52808b == assetLocation.offset() && this.f52809c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.f52807a.hashCode();
        long j = this.f52808b;
        long j2 = this.f52809c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final long offset() {
        return this.f52808b;
    }

    public final String path() {
        return this.f52807a;
    }

    public final long size() {
        return this.f52809c;
    }

    public final String toString() {
        String str = this.f52807a;
        long j = this.f52808b;
        long j2 = this.f52809c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
