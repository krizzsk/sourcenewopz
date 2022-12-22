package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvr {
    public static final zzvr zzciq = new zzvr();

    protected zzvr() {
    }

    public static zzvq zza(Context context, zzzl zzzl) {
        List list;
        Context context2;
        zzvf zzvf;
        String str;
        zzzl zzzl2 = zzzl;
        Date birthday = zzzl.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzzl.getContentUrl();
        int gender = zzzl.getGender();
        Set<String> keywords = zzzl.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzzl2.isTestDevice(context2);
        Location location = zzzl.getLocation();
        Bundle networkExtrasBundle = zzzl2.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzzl.zzru() != null) {
            zzvf = new zzvf(zzzl.zzru().getAdString(), zzww.zzre().containsKey(zzzl.zzru().getQueryInfo()) ? zzww.zzre().get(zzzl.zzru().getQueryInfo()) : "");
        } else {
            zzvf = null;
        }
        boolean manualImpressionsEnabled = zzzl.getManualImpressionsEnabled();
        String publisherProvidedId = zzzl.getPublisherProvidedId();
        SearchAdRequest zzrp = zzzl.zzrp();
        zzaav zzaav = zzrp != null ? new zzaav(zzrp) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzww.zzqw();
            str = zzbae.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzzl.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzzs.zzry().getRequestConfiguration();
        return new zzvq(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzzl.zzrs(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzaav, location, contentUrl, zzzl.zzrr(), zzzl.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzzl.zzrt())), zzzl.zzro(), str, isDesignedForFamilies, zzvf, Math.max(zzzl.zzrv(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{zzzl.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()}), zzvu.zzciz), zzzl.zzrn(), zzzl.zzrw());
    }

    public static zzavt zza(Context context, zzzl zzzl, String str) {
        return new zzavt(zza(context, zzzl), str);
    }

    static final /* synthetic */ int zzc(String str, String str2) {
        return RequestConfiguration.zzadz.indexOf(str) - RequestConfiguration.zzadz.indexOf(str2);
    }
}
