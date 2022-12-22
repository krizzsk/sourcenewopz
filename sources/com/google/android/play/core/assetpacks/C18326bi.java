package com.google.android.play.core.assetpacks;

import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bi */
final class C18326bi extends AssetPackStates {

    /* renamed from: a */
    private final long f52820a;

    /* renamed from: b */
    private final Map<String, AssetPackState> f52821b;

    C18326bi(long j, Map<String, AssetPackState> map) {
        this.f52820a = j;
        this.f52821b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            return this.f52820a == assetPackStates.totalBytes() && this.f52821b.equals(assetPackStates.packStates());
        }
    }

    public final int hashCode() {
        long j = this.f52820a;
        return this.f52821b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    public final Map<String, AssetPackState> packStates() {
        return this.f52821b;
    }

    public final String toString() {
        long j = this.f52820a;
        String valueOf = String.valueOf(this.f52821b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
        sb.append("AssetPackStates{totalBytes=");
        sb.append(j);
        sb.append(", packStates=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytes() {
        return this.f52820a;
    }
}
