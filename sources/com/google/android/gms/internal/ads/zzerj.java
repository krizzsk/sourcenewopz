package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzerj implements zzbs {
    private static zzers zzdc = zzers.zzp(zzerj.class);
    private String type;
    private long zzaxf;
    private zzbr zzjdz;
    boolean zzjeb;
    private boolean zzjec;
    private ByteBuffer zzjed;
    private long zzjee;
    private long zzjef = -1;
    private zzerm zzjeg;
    private ByteBuffer zzjeh = null;

    private final synchronized void zzbnh() {
        if (!this.zzjec) {
            try {
                zzers zzers = zzdc;
                String valueOf = String.valueOf(this.type);
                zzers.zzip(valueOf.length() != 0 ? "mem mapping ".concat(valueOf) : new String("mem mapping "));
                this.zzjed = this.zzjeg.zzh(this.zzjee, this.zzjef);
                this.zzjec = true;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzl(ByteBuffer byteBuffer);

    protected zzerj(String str) {
        this.type = str;
        this.zzjec = true;
        this.zzjeb = true;
    }

    public final void zza(zzerm zzerm, ByteBuffer byteBuffer, long j, zzbn zzbn) throws IOException {
        long position = zzerm.position();
        this.zzjee = position;
        this.zzaxf = position - ((long) byteBuffer.remaining());
        this.zzjef = j;
        this.zzjeg = zzerm;
        zzerm.zzfd(zzerm.position() + j);
        this.zzjec = false;
        this.zzjeb = false;
        zzbni();
    }

    public final synchronized void zzbni() {
        zzbnh();
        zzers zzers = zzdc;
        String valueOf = String.valueOf(this.type);
        zzers.zzip(valueOf.length() != 0 ? "parsing details of ".concat(valueOf) : new String("parsing details of "));
        if (this.zzjed != null) {
            ByteBuffer byteBuffer = this.zzjed;
            this.zzjeb = true;
            byteBuffer.rewind();
            zzl(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.zzjeh = byteBuffer.slice();
            }
            this.zzjed = null;
        }
    }

    public final String getType() {
        return this.type;
    }

    public final void zza(zzbr zzbr) {
        this.zzjdz = zzbr;
    }
}
