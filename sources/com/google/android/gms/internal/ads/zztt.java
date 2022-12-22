package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zztt implements Runnable {
    private final zztq zzbwm;
    private final zztj zzbwn;
    private final zzti zzbwo;
    private final zzbbe zzbwp;

    zztt(zztq zztq, zztj zztj, zzti zzti, zzbbe zzbbe) {
        this.zzbwm = zztq;
        this.zzbwn = zztj;
        this.zzbwo = zzti;
        this.zzbwp = zzbbe;
    }

    public final void run() {
        zzth zzth;
        zztq zztq = this.zzbwm;
        zztj zztj = this.zzbwn;
        zzti zzti = this.zzbwo;
        zzbbe zzbbe = this.zzbwp;
        try {
            zztn zznj = zztj.zznj();
            if (zztj.zznk()) {
                zzth = zznj.zzc(zzti);
            } else {
                zzth = zznj.zza(zzti);
            }
            if (!zzth.zznc()) {
                zzbbe.setException(new RuntimeException("No entry contents."));
                zztq.zzbwj.disconnect();
                return;
            }
            zztv zztv = new zztv(zztq, zzth.zznd(), 1);
            int read = zztv.read();
            if (read != -1) {
                zztv.unread(read);
                zzbbe.set(zztw.zza(zztv, zzth.zznf(), zzth.zzni(), zzth.zznh(), zzth.zzng()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzd.zzc("Unable to obtain a cache service instance.", e);
            zzbbe.setException(e);
            zztq.zzbwj.disconnect();
        }
    }
}
