package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzax;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zze extends zzk<byte[]> {
    final /* synthetic */ zzax zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zze(AccountTransferClient accountTransferClient, int i, zzax zzax) {
        super(1607, (zzb) null);
        this.zza = zzax;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzau zzau) throws RemoteException {
        zzau.zzg(new zzd(this, this), this.zza);
    }
}
