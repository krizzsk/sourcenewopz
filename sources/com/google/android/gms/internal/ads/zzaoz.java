package com.google.android.gms.internal.ads;

import android.location.Location;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaoz implements NativeMediationAdRequest {
    private final String zzadx;
    private final int zzcib;
    private final boolean zzcim;
    private final int zzdos;
    private final int zzdot;
    private final zzaei zzdpr;
    private final List<String> zzdps = new ArrayList();
    private final Map<String, Boolean> zzdpt = new HashMap();
    private final Date zznc;
    private final Set<String> zzne;
    private final boolean zznf;
    private final Location zzng;

    public zzaoz(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzaei zzaei, List<String> list, boolean z2, int i3, String str) {
        this.zznc = date;
        this.zzcib = i;
        this.zzne = set;
        this.zzng = location;
        this.zznf = z;
        this.zzdos = i2;
        this.zzdpr = zzaei;
        this.zzcim = z2;
        this.zzdot = i3;
        this.zzadx = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzdpt.put(split[1], true);
                        } else if (SDKConsts.BOOLEAN_FALSE.equals(split[2])) {
                            this.zzdpt.put(split[1], false);
                        }
                    }
                } else {
                    this.zzdps.add(next);
                }
            }
        }
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

    public final NativeAdOptions getNativeAdOptions() {
        return zzaei.zzc(this.zzdpr);
    }

    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzaei.zzb(this.zzdpr);
    }

    public final boolean isAdMuted() {
        return zzzs.zzry().zzrh();
    }

    public final float getAdVolume() {
        return zzzs.zzry().zzrg();
    }

    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdps;
        if (list != null) {
            return list.contains("2") || this.zzdps.contains("6");
        }
        return false;
    }

    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdps;
        return list != null && list.contains("6");
    }

    public final boolean isContentAdRequested() {
        List<String> list = this.zzdps;
        if (list != null) {
            return list.contains("1") || this.zzdps.contains("6");
        }
        return false;
    }

    public final boolean zzvw() {
        List<String> list = this.zzdps;
        return list != null && list.contains("3");
    }

    public final Map<String, Boolean> zzvx() {
        return this.zzdpt;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcim;
    }
}
