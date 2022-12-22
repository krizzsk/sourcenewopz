package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdva extends zzduz {
    private final String zzhvq;
    private final boolean zzxk;
    private final boolean zzzo;

    private zzdva(String str, boolean z, boolean z2) {
        this.zzhvq = str;
        this.zzxk = z;
        this.zzzo = z2;
    }

    public final String zzayo() {
        return this.zzhvq;
    }

    public final boolean zzayp() {
        return this.zzxk;
    }

    public final boolean zzcn() {
        return this.zzzo;
    }

    public final String toString() {
        String str = this.zzhvq;
        boolean z = this.zzxk;
        boolean z2 = this.zzzo;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzduz) {
            zzduz zzduz = (zzduz) obj;
            return this.zzhvq.equals(zzduz.zzayo()) && this.zzxk == zzduz.zzayp() && this.zzzo == zzduz.zzcn();
        }
    }

    public final int hashCode() {
        int i = 1231;
        int hashCode = (((this.zzhvq.hashCode() ^ 1000003) * 1000003) ^ (this.zzxk ? 1231 : 1237)) * 1000003;
        if (!this.zzzo) {
            i = 1237;
        }
        return hashCode ^ i;
    }
}
