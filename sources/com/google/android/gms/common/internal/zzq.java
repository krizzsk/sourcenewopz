package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
final class zzq implements Handler.Callback {
    final /* synthetic */ zzr zza;

    /* synthetic */ zzq(zzr zzr, zzp zzp) {
        this.zza = zzr;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.zza.zzb) {
                zzn zzn = (zzn) message.obj;
                zzo zzo = (zzo) this.zza.zzb.get(zzn);
                if (zzo != null && zzo.zzi()) {
                    if (zzo.zzj()) {
                        zzo.zzg("GmsClientSupervisor");
                    }
                    this.zza.zzb.remove(zzn);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.zza.zzb) {
                zzn zzn2 = (zzn) message.obj;
                zzo zzo2 = (zzo) this.zza.zzb.get(zzn2);
                if (zzo2 != null && zzo2.zza() == 3) {
                    String valueOf = String.valueOf(zzn2);
                    SystemUtils.log(6, "GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception(), "com.google.android.gms.common.internal.zzq", 4);
                    ComponentName zzb = zzo2.zzb();
                    if (zzb == null) {
                        zzb = zzn2.zzb();
                    }
                    if (zzb == null) {
                        String zzd = zzn2.zzd();
                        Preconditions.checkNotNull(zzd);
                        zzb = new ComponentName(zzd, "unknown");
                    }
                    zzo2.onServiceDisconnected(zzb);
                }
            }
            return true;
        }
    }
}
