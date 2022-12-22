package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zznf implements zzne {
    private final zzie zzafd = new zzie();
    private final zzne[] zzbfi;
    private final ArrayList<zzne> zzbfj;
    private zznd zzbfk;
    private zzid zzbfl;
    private Object zzbfm;
    private int zzbfn = -1;
    private zznh zzbfo;

    public zznf(zzne... zzneArr) {
        this.zzbfi = zzneArr;
        this.zzbfj = new ArrayList<>(Arrays.asList(zzneArr));
    }

    public final void zza(zzhh zzhh, boolean z, zznd zznd) {
        this.zzbfk = zznd;
        int i = 0;
        while (true) {
            zzne[] zzneArr = this.zzbfi;
            if (i < zzneArr.length) {
                zzneArr[i].zza(zzhh, false, new zzni(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzid() throws IOException {
        zznh zznh = this.zzbfo;
        if (zznh == null) {
            for (zzne zzid : this.zzbfi) {
                zzid.zzid();
            }
            return;
        }
        throw zznh;
    }

    public final zznc zza(int i, zzol zzol) {
        int length = this.zzbfi.length;
        zznc[] zzncArr = new zznc[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzncArr[i2] = this.zzbfi[i2].zza(i, zzol);
        }
        return new zzng(zzncArr);
    }

    public final void zzb(zznc zznc) {
        zzng zzng = (zzng) zznc;
        int i = 0;
        while (true) {
            zzne[] zzneArr = this.zzbfi;
            if (i < zzneArr.length) {
                zzneArr[i].zzb(zzng.zzbfp[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzie() {
        for (zzne zzie : this.zzbfi) {
            zzie.zzie();
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzid zzid, Object obj) {
        zznh zznh;
        if (this.zzbfo == null) {
            int zzfj = zzid.zzfj();
            for (int i2 = 0; i2 < zzfj; i2++) {
                zzid.zza(i2, this.zzafd, false);
            }
            if (this.zzbfn == -1) {
                this.zzbfn = zzid.zzfk();
            } else if (zzid.zzfk() != this.zzbfn) {
                zznh = new zznh(1);
                this.zzbfo = zznh;
            }
            zznh = null;
            this.zzbfo = zznh;
        }
        if (this.zzbfo == null) {
            this.zzbfj.remove(this.zzbfi[i]);
            if (i == 0) {
                this.zzbfl = zzid;
                this.zzbfm = obj;
            }
            if (this.zzbfj.isEmpty()) {
                this.zzbfk.zzb(this.zzbfl, this.zzbfm);
            }
        }
    }
}
