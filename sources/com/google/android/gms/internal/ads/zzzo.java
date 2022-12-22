package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzo {
    /* access modifiers changed from: private */
    public int zzadv = -1;
    /* access modifiers changed from: private */
    public int zzadw = -1;
    /* access modifiers changed from: private */
    public String zzadx;
    /* access modifiers changed from: private */
    public boolean zzbns = false;
    /* access modifiers changed from: private */
    public int zzcib = -1;
    /* access modifiers changed from: private */
    public String zzcie;
    /* access modifiers changed from: private */
    public String zzcig;
    /* access modifiers changed from: private */
    public final Bundle zzcii = new Bundle();
    /* access modifiers changed from: private */
    public String zzcik;
    /* access modifiers changed from: private */
    public boolean zzcim;
    /* access modifiers changed from: private */
    public final List<String> zzcin = new ArrayList();
    /* access modifiers changed from: private */
    public int zzcio = 60000;
    /* access modifiers changed from: private */
    public final Bundle zzckl = new Bundle();
    /* access modifiers changed from: private */
    public AdInfo zzckq;
    /* access modifiers changed from: private */
    public final HashSet<String> zzcky = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzckz = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcla = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzclb = new HashSet<>();
    /* access modifiers changed from: private */
    public Date zznc;
    /* access modifiers changed from: private */
    public Location zzng;

    public final void zzcf(String str) {
        this.zzcky.add(str);
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzckz.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzckl.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzckl.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzckl.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzckl.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzcg(String str) {
        this.zzcla.add(str);
    }

    public final void zzch(String str) {
        this.zzcla.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zznc = date;
    }

    public final void zzci(String str) {
        this.zzcig = str;
    }

    public final void zzc(List<String> list) {
        this.zzcin.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzbao.zzez("neighboring content URL should not be null or empty");
            } else {
                this.zzcin.add(next);
            }
        }
    }

    @Deprecated
    public final void zzda(int i) {
        this.zzcib = i;
    }

    public final void zza(Location location) {
        this.zzng = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbns = z;
    }

    public final void zzcj(String str) {
        this.zzcie = str;
    }

    public final void zzck(String str) {
        this.zzcik = str;
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzadv = z ? 1 : 0;
    }

    public final void zzd(String str, String str2) {
        this.zzcii.putString(str, str2);
    }

    public final void zzcl(String str) {
        this.zzclb.add(str);
    }

    @Deprecated
    public final void zzab(boolean z) {
        this.zzcim = z;
    }

    public final void zza(AdInfo adInfo) {
        this.zzckq = adInfo;
    }

    @Deprecated
    public final void zzdb(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadw = i;
        }
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadx = str;
        }
    }

    public final void zzdc(int i) {
        this.zzcio = i;
    }
}
