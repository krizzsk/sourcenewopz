package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.mozilla.javascript.typedarrays.Conversions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzeri extends zzerk implements zzbs {
    private String type;
    private long zzaxf;
    private zzbr zzjdz;
    private boolean zzjea;

    public zzeri(String str) {
        this.type = str;
    }

    public final void zza(zzbr zzbr) {
        this.zzjdz = zzbr;
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzerm zzerm, ByteBuffer byteBuffer, long j, zzbn zzbn) throws IOException {
        this.zzaxf = zzerm.position() - ((long) byteBuffer.remaining());
        this.zzjea = byteBuffer.remaining() == 16;
        zza(zzerm, j, zzbn);
    }

    public final void zza(zzerm zzerm, long j, zzbn zzbn) throws IOException {
        this.zzjeg = zzerm;
        this.zzjel = zzerm.position();
        this.zzbgk = this.zzjel - ((long) ((this.zzjea || 8 + j >= Conversions.THIRTYTWO_BIT) ? 16 : 8));
        zzerm.zzfd(zzerm.position() + j);
        this.zzate = zzerm.position();
        this.zzjej = zzbn;
    }
}
