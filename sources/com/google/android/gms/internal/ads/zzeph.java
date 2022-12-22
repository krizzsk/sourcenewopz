package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeph {
    private final ArrayDeque<zzelq> zzixf;

    private zzeph() {
        this.zzixf = new ArrayDeque<>();
    }

    /* access modifiers changed from: private */
    public final zzelq zzc(zzelq zzelq, zzelq zzelq2) {
        zzam(zzelq);
        zzam(zzelq2);
        zzelq pop = this.zzixf.pop();
        while (!this.zzixf.isEmpty()) {
            pop = new zzepf(this.zzixf.pop(), pop, (zzepe) null);
        }
        return pop;
    }

    private final void zzam(zzelq zzelq) {
        while (!zzelq.zzbhm()) {
            if (zzelq instanceof zzepf) {
                zzepf zzepf = (zzepf) zzelq;
                zzam(zzepf.zziwz);
                zzelq = zzepf.zzixa;
            } else {
                String valueOf = String.valueOf(zzelq.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzia = zzia(zzelq.size());
        int zzhz = zzepf.zzhz(zzia + 1);
        if (this.zzixf.isEmpty() || this.zzixf.peek().size() >= zzhz) {
            this.zzixf.push(zzelq);
            return;
        }
        int zzhz2 = zzepf.zzhz(zzia);
        zzelq pop = this.zzixf.pop();
        while (!this.zzixf.isEmpty() && this.zzixf.peek().size() < zzhz2) {
            pop = new zzepf(this.zzixf.pop(), pop, (zzepe) null);
        }
        zzepf zzepf2 = new zzepf(pop, zzelq, (zzepe) null);
        while (!this.zzixf.isEmpty() && this.zzixf.peek().size() < zzepf.zzhz(zzia(zzepf2.size()) + 1)) {
            zzepf2 = new zzepf(this.zzixf.pop(), zzepf2, (zzepe) null);
        }
        this.zzixf.push(zzepf2);
    }

    private static int zzia(int i) {
        int binarySearch = Arrays.binarySearch(zzepf.zziwx, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzeph(zzepe zzepe) {
        this();
    }
}
