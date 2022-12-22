package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public interface zzij {
    public static final ByteBuffer zzajm = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void flush();

    boolean isActive();

    void reset();

    boolean zzb(int i, int i2, int i3) throws zzii;

    boolean zzfi();

    int zzfn();

    int zzfo();

    void zzfp();

    ByteBuffer zzfq();

    void zzn(ByteBuffer byteBuffer);
}
