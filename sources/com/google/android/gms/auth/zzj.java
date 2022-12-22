package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzj implements zzk<Boolean> {
    final /* synthetic */ String zza;

    zzj(String str) {
        this.zza = str;
    }

    public final /* synthetic */ Object zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zzg = zze.zzb(iBinder).zzg(this.zza);
        Object unused = zzl.zzi(zzg);
        String string = zzg.getString("Error");
        Intent intent = (Intent) zzg.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (zzby.SUCCESS.equals(zza2)) {
            return true;
        }
        if (zzby.zzb(zza2)) {
            Logger zzc = zzl.zzd;
            String valueOf = String.valueOf(zza2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            zzc.mo136184w("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
