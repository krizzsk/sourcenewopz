package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaok implements MediationAdRequest {
    private final String zzadx;
    private final int zzcib;
    private final boolean zzcim;
    private final int zzdos;
    private final int zzdot;
    private final Date zznc;
    private final Set<String> zzne;
    private final boolean zznf;
    private final Location zzng;

    public zzaok(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zznc = date;
        this.zzcib = i;
        this.zzne = set;
        this.zzng = location;
        this.zznf = z;
        this.zzdos = i2;
        this.zzcim = z2;
        this.zzdot = i3;
        this.zzadx = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zznc;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcib;
    }

    public final Set<String> getKeywords() {
        return this.zzne;
    }

    public final Location getLocation() {
        return this.zzng;
    }

    public final boolean isTesting() {
        return this.zznf;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdos;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcim;
    }
}
