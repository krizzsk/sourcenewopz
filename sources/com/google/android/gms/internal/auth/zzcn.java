package com.google.android.gms.internal.auth;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.content.PermissionChecker;
import com.didi.sdk.apm.SystemUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzcn implements zzck {
    private static zzcn zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzcn() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzcn(Context context) {
        this.zzb = context;
        this.zzc = new zzcm(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzcb.zza, true, this.zzc);
    }

    static zzcn zza(Context context) {
        zzcn zzcn;
        synchronized (zzcn.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcn(context) : new zzcn();
            }
            zzcn = zza;
        }
        return zzcn;
    }

    static synchronized void zze() {
        synchronized (zzcn.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzc */
    public final String zzb(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzci.zza(new zzcl(this, str));
        } catch (IllegalStateException | SecurityException e) {
            Throwable th = e;
            String valueOf = String.valueOf(str);
            SystemUtils.log(6, "GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), th, "com.google.android.gms.internal.auth.zzcn", 2);
            return null;
        }
    }

    public final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
