package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.ArrayList;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdbr implements zzebi<ArrayList<Uri>> {
    private final /* synthetic */ zzasy zzhct;

    zzdbr(zzdbf zzdbf, zzasy zzasy) {
        this.zzhct = zzasy;
    }

    public final void zzb(Throwable th) {
        try {
            zzasy zzasy = this.zzhct;
            String valueOf = String.valueOf(th.getMessage());
            zzasy.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }

    public final /* synthetic */ void onSuccess(@Nonnull Object obj) {
        try {
            this.zzhct.onSuccess((ArrayList) obj);
        } catch (RemoteException e) {
            zzbao.zzc("", e);
        }
    }
}
