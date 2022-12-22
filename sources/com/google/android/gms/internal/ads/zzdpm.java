package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzj;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpm {
    public final zzvt zzbpy;
    public final zzaei zzdpr;
    public final zzajy zzdxd;
    public final int zzhby;
    public final boolean zzhdn;
    public final zzye zzhnv;
    public final zzaaz zzhnw;
    public final zzvq zzhnx;
    public final String zzhny;
    public final ArrayList<String> zzhnz;
    public final ArrayList<String> zzhoa;
    public final zzwc zzhob;
    public final AdManagerAdViewOptions zzhoc;
    public final PublisherAdViewOptions zzhod;
    public final zzxy zzhoe;
    public final zzdoz zzhof;

    private zzdpm(zzdpo zzdpo) {
        zzaaz zzaaz;
        zzaei zzaei;
        this.zzbpy = zzdpo.zzbpy;
        this.zzhny = zzdpo.zzhny;
        this.zzhnv = zzdpo.zzhnv;
        this.zzhnx = new zzvq(zzdpo.zzhnx.versionCode, zzdpo.zzhnx.zzcia, zzdpo.zzhnx.extras, zzdpo.zzhnx.zzcib, zzdpo.zzhnx.zzcic, zzdpo.zzhnx.zzcid, zzdpo.zzhnx.zzadv, zzdpo.zzhnx.zzbns || zzdpo.zzbns, zzdpo.zzhnx.zzcie, zzdpo.zzhnx.zzcif, zzdpo.zzhnx.zzng, zzdpo.zzhnx.zzcig, zzdpo.zzhnx.zzcih, zzdpo.zzhnx.zzcii, zzdpo.zzhnx.zzcij, zzdpo.zzhnx.zzcik, zzdpo.zzhnx.zzcil, zzdpo.zzhnx.zzcim, zzdpo.zzhnx.zzcip, zzdpo.zzhnx.zzadw, zzdpo.zzhnx.zzadx, zzdpo.zzhnx.zzcin, zzj.zzdl(zzdpo.zzhnx.zzcio));
        if (zzdpo.zzhnw != null) {
            zzaaz = zzdpo.zzhnw;
        } else {
            zzaaz = zzdpo.zzdpr != null ? zzdpo.zzdpr.zzdgy : null;
        }
        this.zzhnw = zzaaz;
        this.zzhnz = zzdpo.zzhnz;
        this.zzhoa = zzdpo.zzhoa;
        if (zzdpo.zzhnz == null) {
            zzaei = null;
        } else if (zzdpo.zzdpr == null) {
            zzaei = new zzaei(new NativeAdOptions.Builder().build());
        } else {
            zzaei = zzdpo.zzdpr;
        }
        this.zzdpr = zzaei;
        this.zzhob = zzdpo.zzhob;
        this.zzhby = zzdpo.zzhby;
        this.zzhoc = zzdpo.zzhoc;
        this.zzhod = zzdpo.zzhod;
        this.zzhoe = zzdpo.zzhoe;
        this.zzdxd = zzdpo.zzdxd;
        this.zzhof = new zzdoz(zzdpo.zzhog);
        this.zzhdn = zzdpo.zzhdn;
    }

    public final zzagm zzawb() {
        if (this.zzhod == null && this.zzhoc == null) {
            return null;
        }
        PublisherAdViewOptions publisherAdViewOptions = this.zzhod;
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzjv();
        }
        return this.zzhoc.zzjv();
    }
}
