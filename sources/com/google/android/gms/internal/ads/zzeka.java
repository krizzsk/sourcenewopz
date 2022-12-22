package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzeka implements zzecn {
    private final zzekn zzinb;
    private final zzeda zzinc;
    private final int zzind;

    public zzeka(zzekn zzekn, zzeda zzeda, int i) {
        this.zzinb = zzekn;
        this.zzinc = zzeda;
        this.zzind = i;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] zzn = this.zzinb.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzejn.zza(zzn, this.zzinc.zzk(zzejn.zza(bArr2, zzn, copyOf)));
    }
}
