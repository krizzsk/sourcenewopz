package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjb {
    private final zzauj zzgrg;
    private final int zzgsm;

    public zzdjb(zzauj zzauj, int i) {
        this.zzgrg = zzauj;
        this.zzgsm = i;
    }

    public final String zzauu() {
        return this.zzgrg.packageName;
    }

    public final String zzauv() {
        return this.zzgrg.zzdys.getString("ms");
    }

    public final PackageInfo zzauw() {
        return this.zzgrg.zzdvo;
    }

    public final List<String> zzaux() {
        return this.zzgrg.zzdvy;
    }

    public final String zzauy() {
        return this.zzgrg.zzdyt;
    }

    public final int zzauz() {
        return this.zzgsm;
    }
}
