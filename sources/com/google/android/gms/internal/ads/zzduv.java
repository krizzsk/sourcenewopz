package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzduv {
    private static volatile zzbw.zza.zzc zzhvo = zzbw.zza.zzc.UNKNOWN;
    private final Context context;
    private final Executor executor;
    private final Task<zzue> zzhvn;

    static void zza(zzbw.zza.zzc zzc) {
        zzhvo = zzc;
    }

    public static zzduv zza(Context context2, Executor executor2) {
        return new zzduv(context2, executor2, Tasks.call(executor2, new zzdux(context2)));
    }

    private zzduv(Context context2, Executor executor2, Task<zzue> task) {
        this.context = context2;
        this.executor = executor2;
        this.zzhvn = task;
    }

    public final Task<Boolean> zzh(int i, long j) {
        return zza(i, j, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, (Exception) null, str, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return zza(i, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzb(int i, long j, String str) {
        return zza(i, j, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.zzb zzd = zzbw.zza.zzs().zzo(this.context.getPackageName()).zzd(j);
        zzd.zzb(zzhvo);
        if (exc != null) {
            zzd.zzp(zzdys.zza(exc)).zzq(exc.getClass().getName());
        }
        if (str2 != null) {
            zzd.zzr(str2);
        }
        if (str != null) {
            zzd.zzs(str);
        }
        return this.zzhvn.continueWith(this.executor, new zzduw(zzd, i));
    }

    static final /* synthetic */ Boolean zza(zzbw.zza.zzb zzb, int i, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return false;
        }
        zzui zzf = ((zzue) task.getResult()).zzf(((zzbw.zza) ((zzena) zzb.zzbjv())).toByteArray());
        zzf.zzby(i);
        zzf.log();
        return true;
    }

    static final /* synthetic */ zzue zzcn(Context context2) throws Exception {
        return new zzue(context2, "GLAS", (String) null);
    }
}
