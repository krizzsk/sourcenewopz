package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzr;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzdqw {
    private final int maxEntries;
    private final LinkedList<zzdrj<?>> zzhpw = new LinkedList<>();
    private final int zzhpx;
    private final zzdrz zzhpy;

    public zzdqw(int i, int i2) {
        this.maxEntries = i;
        this.zzhpx = i2;
        this.zzhpy = new zzdrz();
    }

    public final boolean zzb(zzdrj<?> zzdrj) {
        this.zzhpy.zzaxm();
        zzawt();
        if (this.zzhpw.size() == this.maxEntries) {
            return false;
        }
        this.zzhpw.add(zzdrj);
        return true;
    }

    public final zzdrj<?> zzawo() {
        this.zzhpy.zzaxm();
        zzawt();
        if (this.zzhpw.isEmpty()) {
            return null;
        }
        zzdrj<?> remove = this.zzhpw.remove();
        if (remove != null) {
            this.zzhpy.zzaxn();
        }
        return remove;
    }

    public final int size() {
        zzawt();
        return this.zzhpw.size();
    }

    public final long getCreationTimeMillis() {
        return this.zzhpy.getCreationTimeMillis();
    }

    public final long zzawp() {
        return this.zzhpy.zzawp();
    }

    public final int zzawq() {
        return this.zzhpy.zzawq();
    }

    public final String zzawr() {
        return this.zzhpy.zzaxc();
    }

    public final zzdry zzaws() {
        return this.zzhpy.zzaxp();
    }

    private final void zzawt() {
        while (!this.zzhpw.isEmpty()) {
            if (zzr.zzlc().currentTimeMillis() - this.zzhpw.getFirst().zzhrl >= ((long) this.zzhpx)) {
                this.zzhpy.zzaxo();
                this.zzhpw.remove();
            } else {
                return;
            }
        }
    }
}
