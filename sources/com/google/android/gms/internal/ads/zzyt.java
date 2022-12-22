package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzyt implements MuteThisAdReason {
    private final String description;
    private zzys zzckj;

    public zzyt(zzys zzys) {
        String str;
        this.zzckj = zzys;
        try {
            str = zzys.getDescription();
        } catch (RemoteException e) {
            zzbao.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final zzys zzrl() {
        return this.zzckj;
    }

    public final String toString() {
        return this.description;
    }
}
