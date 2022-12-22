package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzdxt extends zzdxq {
    private final char zzhyu;

    zzdxt(char c) {
        this.zzhyu = c;
    }

    public final boolean zzc(char c) {
        return c == this.zzhyu;
    }

    public final String toString() {
        String zze = zzdxr.zzd(this.zzhyu);
        StringBuilder sb = new StringBuilder(String.valueOf(zze).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(zze);
        sb.append("')");
        return sb.toString();
    }
}
