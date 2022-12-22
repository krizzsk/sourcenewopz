package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdvc extends zzduy {
    private String zzhvq;
    private Boolean zzhvr;
    private Boolean zzhvs;

    zzdvc() {
    }

    public final zzduy zzhf(String str) {
        if (str != null) {
            this.zzhvq = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzduy zzbt(boolean z) {
        this.zzhvr = Boolean.valueOf(z);
        return this;
    }

    public final zzduy zzbu(boolean z) {
        this.zzhvs = true;
        return this;
    }

    public final zzduz zzayn() {
        String str = "";
        if (this.zzhvq == null) {
            str = str.concat(" clientVersion");
        }
        if (this.zzhvr == null) {
            str = String.valueOf(str).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhvs == null) {
            str = String.valueOf(str).concat(" isGooglePlayServicesAvailable");
        }
        if (str.isEmpty()) {
            return new zzdva(this.zzhvq, this.zzhvr.booleanValue(), this.zzhvs.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
