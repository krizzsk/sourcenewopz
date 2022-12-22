package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzmy {
    private final zzkc zzaru;
    private final zzka[] zzbfc;
    private zzka zzbfd;

    public zzmy(zzka[] zzkaArr, zzkc zzkc) {
        this.zzbfc = zzkaArr;
        this.zzaru = zzkc;
    }

    public final zzka zza(zzjz zzjz, Uri uri) throws IOException, InterruptedException {
        zzka zzka = this.zzbfd;
        if (zzka != null) {
            return zzka;
        }
        zzka[] zzkaArr = this.zzbfc;
        int length = zzkaArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zzka zzka2 = zzkaArr[i];
            try {
                if (zzka2.zza(zzjz)) {
                    this.zzbfd = zzka2;
                    zzjz.zzgu();
                    break;
                }
                i++;
            } catch (EOFException unused) {
            } finally {
                zzjz.zzgu();
            }
        }
        zzka zzka3 = this.zzbfd;
        if (zzka3 != null) {
            zzka3.zza(this.zzaru);
            return this.zzbfd;
        }
        String zza = zzpt.zza((Object[]) this.zzbfc);
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(zza);
        sb.append(") could read the stream.");
        throw new zznt(sb.toString(), uri);
    }

    public final void release() {
        zzka zzka = this.zzbfd;
        if (zzka != null) {
            zzka.release();
            this.zzbfd = null;
        }
    }
}
