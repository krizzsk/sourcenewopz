package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import p242io.socket.engineio.parser.Packet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbeu extends zzbek {
    public zzbeu(zzbcs zzbcs) {
        super(zzbcs);
    }

    public final void abort() {
    }

    public final boolean zzfh(String str) {
        zzbcs zzbcs = (zzbcs) this.zzerx.get();
        if (zzbcs != null) {
            zzbcs.zza(zzfi(str), (zzbek) this);
        }
        zzd.zzez("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfi(str), Packet.NOOP, "Noop cache is a noop.");
        return false;
    }
}
