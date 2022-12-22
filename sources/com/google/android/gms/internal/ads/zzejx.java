package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzejx {
    private final zzekk zzimt;
    private final zzekk zzimu;

    public zzejx(byte[] bArr, byte[] bArr2) {
        this.zzimt = zzekk.zzr(bArr);
        this.zzimu = zzekk.zzr(bArr2);
    }

    public final byte[] zzbgo() {
        zzekk zzekk = this.zzimt;
        if (zzekk == null) {
            return null;
        }
        return zzekk.getBytes();
    }

    public final byte[] zzbgp() {
        zzekk zzekk = this.zzimu;
        if (zzekk == null) {
            return null;
        }
        return zzekk.getBytes();
    }
}
