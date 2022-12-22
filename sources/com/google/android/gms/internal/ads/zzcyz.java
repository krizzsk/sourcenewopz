package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcyz {
    private final zzckb zzgph;
    private final ConcurrentHashMap<String, zzaqa> zzhad = new ConcurrentHashMap<>();

    public zzcyz(zzckb zzckb) {
        this.zzgph = zzckb;
    }

    public final void zzgo(String str) {
        try {
            this.zzhad.put(str, this.zzgph.zzdi(str));
        } catch (RemoteException e) {
            zzd.zzc("Couldn't create RTB adapter : ", e);
        }
    }

    @CheckForNull
    public final zzaqa zzgp(String str) {
        if (this.zzhad.containsKey(str)) {
            return this.zzhad.get(str);
        }
        return null;
    }
}
