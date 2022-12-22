package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbab {
    private String zzdvq = "0";
    private BigInteger zzefl = BigInteger.ONE;

    public final synchronized String zzyv() {
        String bigInteger;
        bigInteger = this.zzefl.toString();
        this.zzefl = this.zzefl.add(BigInteger.ONE);
        this.zzdvq = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzyw() {
        return this.zzdvq;
    }
}
