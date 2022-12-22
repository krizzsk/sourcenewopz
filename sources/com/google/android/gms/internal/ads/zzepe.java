package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzepe extends zzelr {
    private final zzepg zziwu = new zzepg(this.zziww, (zzepe) null);
    private zzelv zziwv = zzblh();
    private final /* synthetic */ zzepf zziww;

    zzepe(zzepf zzepf) {
        this.zziww = zzepf;
    }

    private final zzelv zzblh() {
        if (this.zziwu.hasNext()) {
            return (zzelv) ((zzelx) this.zziwu.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zziwv != null;
    }

    public final byte nextByte() {
        zzelv zzelv = this.zziwv;
        if (zzelv != null) {
            byte nextByte = zzelv.nextByte();
            if (!this.zziwv.hasNext()) {
                this.zziwv = zzblh();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
