package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzerl extends zzerj implements zzbs {
    private int flags;
    private int version;

    protected zzerl(String str) {
        super(str);
    }

    public final int getVersion() {
        if (!this.zzjeb) {
            zzbni();
        }
        return this.version;
    }

    /* access modifiers changed from: protected */
    public final long zzr(ByteBuffer byteBuffer) {
        this.version = zzbp.zza(byteBuffer.get());
        this.flags = (zzbp.zzg(byteBuffer) << 8) + 0 + zzbp.zza(byteBuffer.get());
        return 4;
    }
}
