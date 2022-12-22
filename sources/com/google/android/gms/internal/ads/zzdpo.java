package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdpo {
    /* access modifiers changed from: private */
    public boolean zzbns;
    /* access modifiers changed from: private */
    public zzvt zzbpy;
    /* access modifiers changed from: private */
    public zzaei zzdpr;
    /* access modifiers changed from: private */
    public zzajy zzdxd;
    /* access modifiers changed from: private */
    public int zzhby = 1;
    /* access modifiers changed from: private */
    public boolean zzhdn = false;
    /* access modifiers changed from: private */
    public zzye zzhnv;
    /* access modifiers changed from: private */
    public zzaaz zzhnw;
    /* access modifiers changed from: private */
    public zzvq zzhnx;
    /* access modifiers changed from: private */
    public String zzhny;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhnz;
    /* access modifiers changed from: private */
    public ArrayList<String> zzhoa;
    /* access modifiers changed from: private */
    public zzwc zzhob;
    /* access modifiers changed from: private */
    public AdManagerAdViewOptions zzhoc;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzhod;
    /* access modifiers changed from: private */
    public zzxy zzhoe;
    /* access modifiers changed from: private */
    public zzdpb zzhog = new zzdpb();

    public final zzdpo zzh(zzvq zzvq) {
        this.zzhnx = zzvq;
        return this;
    }

    public final zzvq zzawd() {
        return this.zzhnx;
    }

    public final zzdpo zzg(zzvt zzvt) {
        this.zzbpy = zzvt;
        return this;
    }

    public final zzdpo zzbr(boolean z) {
        this.zzhdn = z;
        return this;
    }

    public final zzvt zzkk() {
        return this.zzbpy;
    }

    public final zzdpo zzc(zzye zzye) {
        this.zzhnv = zzye;
        return this;
    }

    public final zzdpo zzgt(String str) {
        this.zzhny = str;
        return this;
    }

    public final String zzawe() {
        return this.zzhny;
    }

    public final zzdpo zzc(zzaaz zzaaz) {
        this.zzhnw = zzaaz;
        return this;
    }

    public final zzdpb zzawf() {
        return this.zzhog;
    }

    public final zzdpo zzbs(boolean z) {
        this.zzbns = z;
        return this;
    }

    public final zzdpo zzem(int i) {
        this.zzhby = i;
        return this;
    }

    public final zzdpo zzc(ArrayList<String> arrayList) {
        this.zzhnz = arrayList;
        return this;
    }

    public final zzdpo zzd(ArrayList<String> arrayList) {
        this.zzhoa = arrayList;
        return this;
    }

    public final zzdpo zzd(zzaei zzaei) {
        this.zzdpr = zzaei;
        return this;
    }

    public final zzdpo zzb(zzwc zzwc) {
        this.zzhob = zzwc;
        return this;
    }

    public final zzdpo zzb(zzajy zzajy) {
        this.zzdxd = zzajy;
        this.zzhnw = new zzaaz(false, true, false);
        return this;
    }

    public final zzdpo zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhod = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbns = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhoe = publisherAdViewOptions.zzjz();
        }
        return this;
    }

    public final zzdpo zzb(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzhoc = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zzbns = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzdpo zzc(zzdpm zzdpm) {
        this.zzhog.zza(zzdpm.zzhof);
        this.zzhnx = zzdpm.zzhnx;
        this.zzbpy = zzdpm.zzbpy;
        this.zzhnv = zzdpm.zzhnv;
        this.zzhny = zzdpm.zzhny;
        this.zzhnw = zzdpm.zzhnw;
        this.zzhnz = zzdpm.zzhnz;
        this.zzhoa = zzdpm.zzhoa;
        this.zzdpr = zzdpm.zzdpr;
        this.zzhob = zzdpm.zzhob;
        zzdpo zzb = zzb(zzdpm.zzhoc).zzb(zzdpm.zzhod);
        zzb.zzhdn = zzdpm.zzhdn;
        return zzb;
    }

    public final zzdpm zzawg() {
        Preconditions.checkNotNull(this.zzhny, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbpy, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhnx, "ad request must not be null");
        return new zzdpm(this);
    }

    public final boolean zzawh() {
        return this.zzhdn;
    }
}
