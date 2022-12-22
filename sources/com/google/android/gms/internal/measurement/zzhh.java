package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import androidx.core.content.PermissionChecker;
import com.didi.sdk.apm.SystemUtils;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final class zzhh implements zzhe {
    private static zzhh zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzhh() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhh(Context context) {
        this.zzb = context;
        this.zzc = new zzhg(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzgv.zza, true, this.zzc);
    }

    static zzhh zza(Context context) {
        zzhh zzhh;
        synchronized (zzhh.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhh(context) : new zzhh();
            }
            zzhh = zza;
        }
        return zzhh;
    }

    static synchronized void zzc() {
        synchronized (zzhh.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* renamed from: zzb */
    public final String zze(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzhc.zza(new zzhf(this, str));
        } catch (IllegalStateException | SecurityException e) {
            Throwable th = e;
            String valueOf = String.valueOf(str);
            SystemUtils.log(6, "GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), th, "com.google.android.gms.internal.measurement.zzhh", 2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzgv.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
