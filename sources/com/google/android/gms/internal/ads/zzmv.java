package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmv implements zzpb {
    private final Uri uri;
    private final zzon zzaoz;
    private final /* synthetic */ zzms zzbdv;
    private final zzmy zzbed;
    private final zzpi zzbee;
    private final zzkg zzbex = new zzkg();
    private volatile boolean zzbey;
    private boolean zzbez = true;
    private long zzbfa;
    /* access modifiers changed from: private */
    public long zzco = -1;

    public zzmv(zzms zzms, Uri uri2, zzon zzon, zzmy zzmy, zzpi zzpi) {
        this.zzbdv = zzms;
        this.uri = (Uri) zzpg.checkNotNull(uri2);
        this.zzaoz = (zzon) zzpg.checkNotNull(zzon);
        this.zzbed = (zzmy) zzpg.checkNotNull(zzmy);
        this.zzbee = zzpi;
    }

    public final void zze(long j, long j2) {
        this.zzbex.position = j;
        this.zzbfa = j2;
        this.zzbez = true;
    }

    public final void cancelLoad() {
        this.zzbey = true;
    }

    public final boolean zzib() {
        return this.zzbey;
    }

    public final void zzic() throws IOException, InterruptedException {
        int i = 0;
        while (i == 0 && !this.zzbey) {
            zzjx zzjx = null;
            try {
                long j = this.zzbex.position;
                long zza = this.zzaoz.zza(new zzos(this.uri, j, -1, this.zzbdv.zzbea));
                this.zzco = zza;
                if (zza != -1) {
                    this.zzco = zza + j;
                }
                zzjx zzjx2 = new zzjx(this.zzaoz, j, this.zzco);
                try {
                    zzka zza2 = this.zzbed.zza(zzjx2, this.zzaoz.getUri());
                    if (this.zzbez) {
                        zza2.zzc(j, this.zzbfa);
                        this.zzbez = false;
                    }
                    while (i == 0 && !this.zzbey) {
                        this.zzbee.block();
                        i = zza2.zza(zzjx2, this.zzbex);
                        if (zzjx2.getPosition() > this.zzbdv.zzbeb + j) {
                            j = zzjx2.getPosition();
                            this.zzbee.zziy();
                            this.zzbdv.handler.post(this.zzbdv.zzbeg);
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbex.position = zzjx2.getPosition();
                    }
                    zzpt.zza(this.zzaoz);
                } catch (Throwable th) {
                    th = th;
                    zzjx = zzjx2;
                    this.zzbex.position = zzjx.getPosition();
                    zzpt.zza(this.zzaoz);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (!(i == 1 || zzjx == null)) {
                    this.zzbex.position = zzjx.getPosition();
                }
                zzpt.zza(this.zzaoz);
                throw th;
            }
        }
    }
}
