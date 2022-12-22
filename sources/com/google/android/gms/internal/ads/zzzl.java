package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzzl {
    private final int zzadv;
    private final int zzadw;
    private final String zzadx;
    private final boolean zzbns;
    private final int zzcib;
    private final String zzcie;
    private final String zzcig;
    private final Bundle zzcii;
    private final String zzcik;
    private final boolean zzcim;
    private final List<String> zzcin;
    private final int zzcio;
    private final Bundle zzckl;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzckm;
    private final SearchAdRequest zzckn;
    private final Set<String> zzcko;
    private final Set<String> zzckp;
    private final AdInfo zzckq;
    private final Date zznc;
    private final Set<String> zzne;
    private final Location zzng;

    public zzzl(zzzo zzzo) {
        this(zzzo, (SearchAdRequest) null);
    }

    public zzzl(zzzo zzzo, SearchAdRequest searchAdRequest) {
        this.zznc = zzzo.zznc;
        this.zzcig = zzzo.zzcig;
        this.zzcin = zzzo.zzcin;
        this.zzcib = zzzo.zzcib;
        this.zzne = Collections.unmodifiableSet(zzzo.zzcky);
        this.zzng = zzzo.zzng;
        this.zzbns = zzzo.zzbns;
        this.zzckl = zzzo.zzckl;
        this.zzckm = Collections.unmodifiableMap(zzzo.zzckz);
        this.zzcie = zzzo.zzcie;
        this.zzcik = zzzo.zzcik;
        this.zzckn = searchAdRequest;
        this.zzadv = zzzo.zzadv;
        this.zzcko = Collections.unmodifiableSet(zzzo.zzcla);
        this.zzcii = zzzo.zzcii;
        this.zzckp = Collections.unmodifiableSet(zzzo.zzclb);
        this.zzcim = zzzo.zzcim;
        this.zzckq = zzzo.zzckq;
        this.zzadw = zzzo.zzadw;
        this.zzadx = zzzo.zzadx;
        this.zzcio = zzzo.zzcio;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zznc;
    }

    public final String getContentUrl() {
        return this.zzcig;
    }

    public final List<String> zzrn() {
        return new ArrayList(this.zzcin);
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

    public final boolean getManualImpressionsEnabled() {
        return this.zzbns;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzckm.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzckl.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzckl.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.zzcie;
    }

    public final String zzro() {
        return this.zzcik;
    }

    public final SearchAdRequest zzrp() {
        return this.zzckn;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzzs.zzry().getRequestConfiguration();
        zzww.zzqw();
        String zzbp = zzbae.zzbp(context);
        return this.zzcko.contains(zzbp) || requestConfiguration.getTestDeviceIds().contains(zzbp);
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzrq() {
        return this.zzckm;
    }

    public final Bundle zzrr() {
        return this.zzckl;
    }

    public final int zzrs() {
        return this.zzadv;
    }

    public final Bundle getCustomTargeting() {
        return this.zzcii;
    }

    public final Set<String> zzrt() {
        return this.zzckp;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcim;
    }

    public final AdInfo zzru() {
        return this.zzckq;
    }

    public final int zzrv() {
        return this.zzadw;
    }

    public final String getMaxAdContentRating() {
        return this.zzadx;
    }

    public final int zzrw() {
        return this.zzcio;
    }
}
