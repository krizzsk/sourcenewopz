package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzna implements zznd, zzne {
    private final Uri uri;
    private final Handler zzafa;
    private final zzif zzafe;
    private zzid zzafl;
    private final int zzbdw;
    private final zzmz zzbdx;
    private zznd zzbdy;
    private final String zzbea = null;
    private final zzoq zzbfe;
    private final zzkb zzbff;
    private final int zzbfg;
    private boolean zzbfh;

    public zzna(Uri uri2, zzoq zzoq, zzkb zzkb, int i, Handler handler, zzmz zzmz, String str, int i2) {
        this.uri = uri2;
        this.zzbfe = zzoq;
        this.zzbff = zzkb;
        this.zzbdw = i;
        this.zzafa = handler;
        this.zzbdx = zzmz;
        this.zzbfg = i2;
        this.zzafe = new zzif();
    }

    public final void zzid() throws IOException {
    }

    public final void zza(zzhh zzhh, boolean z, zznd zznd) {
        this.zzbdy = zznd;
        zzns zzns = new zzns(-9223372036854775807L, false);
        this.zzafl = zzns;
        zznd.zzb(zzns, (Object) null);
    }

    public final zznc zza(int i, zzol zzol) {
        zzpg.checkArgument(i == 0);
        return new zzms(this.uri, this.zzbfe.zzit(), this.zzbff.zzgv(), this.zzbdw, this.zzafa, this.zzbdx, this, zzol, (String) null, this.zzbfg);
    }

    public final void zzb(zznc zznc) {
        ((zzms) zznc).release();
    }

    public final void zzie() {
        this.zzbdy = null;
    }

    public final void zzb(zzid zzid, Object obj) {
        boolean z = false;
        if (zzid.zza(0, this.zzafe, false).zzaiz != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzbfh || z) {
            this.zzafl = zzid;
            this.zzbfh = z;
            this.zzbdy.zzb(zzid, (Object) null);
        }
    }
}
