package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzajg implements zzu {
    private final Context context;
    /* access modifiers changed from: private */
    public volatile zzaiz zzdjx;

    public zzajg(Context context2) {
        this.context = context2;
    }

    public final zzz zza(zzab<?> zzab) throws zzap {
        zzaiy zzh = zzaiy.zzh(zzab);
        long elapsedRealtime = zzr.zzlc().elapsedRealtime();
        try {
            zzbbe zzbbe = new zzbbe();
            this.zzdjx = new zzaiz(this.context, zzr.zzlj().zzaai(), new zzajk(this, zzbbe), new zzajn(this, zzbbe));
            this.zzdjx.checkAvailabilityAndConnect();
            zzebt zza = zzebh.zza(zzebh.zzb(zzbbe, new zzajj(this, zzh), (Executor) zzbat.zzeke), (long) ((Integer) zzww.zzra().zzd(zzabq.zzcvj)).intValue(), TimeUnit.MILLISECONDS, zzbat.zzekh);
            zza.addListener(new zzajl(this), zzbat.zzeke);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zza.get();
            long elapsedRealtime2 = zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Http assets remote cache took ");
            sb.append(elapsedRealtime2);
            sb.append("ms");
            zzd.zzed(sb.toString());
            zzaja zzaja = (zzaja) new zzaue(parcelFileDescriptor).zza(zzaja.CREATOR);
            if (zzaja == null) {
                return null;
            }
            if (zzaja.zzdjw) {
                throw new zzap(zzaja.zzchs);
            } else if (zzaja.zzdju.length != zzaja.zzdjv.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < zzaja.zzdju.length; i++) {
                    hashMap.put(zzaja.zzdju[i], zzaja.zzdjv[i]);
                }
                return new zzz(zzaja.statusCode, zzaja.data, (Map<String, String>) hashMap, zzaja.zzak, zzaja.zzal);
            }
        } catch (InterruptedException | ExecutionException unused) {
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(zzr.zzlc().elapsedRealtime() - elapsedRealtime);
            sb2.append("ms");
            zzd.zzed(sb2.toString());
            return null;
        } catch (Throwable th) {
            long elapsedRealtime3 = zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3);
            sb3.append("ms");
            zzd.zzed(sb3.toString());
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        if (this.zzdjx != null) {
            this.zzdjx.disconnect();
            Binder.flushPendingCommands();
        }
    }
}
