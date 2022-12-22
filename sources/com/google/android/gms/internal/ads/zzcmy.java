package com.google.android.gms.internal.ads;

import android.content.Context;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcmy implements AppEventListener, zzbsy, zzbsz, zzbtp, zzbtq, zzbuj, zzbvm, zzdtm, zzve {
    private long startTime;
    private final List<Object> zzejx;
    private final zzcmm zzgpa;

    public zzcmy(zzcmm zzcmm, zzbhh zzbhh) {
        this.zzgpa = zzcmm;
        this.zzejx = Collections.singletonList(zzbhh);
    }

    public final void zzd(zzdpi zzdpi) {
    }

    public final void zzce(Context context) {
        zza((Class<?>) zzbtp.class, "onPause", context);
    }

    public final void zzcf(Context context) {
        zza((Class<?>) zzbtp.class, "onResume", context);
    }

    public final void zzcg(Context context) {
        zza((Class<?>) zzbtp.class, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, context);
    }

    public final void onAppEvent(String str, String str2) {
        zza((Class<?>) AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onAdLoaded() {
        long elapsedRealtime = zzr.zzlc().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzd.zzed(sb.toString());
        zza((Class<?>) zzbuj.class, "onAdLoaded", new Object[0]);
    }

    public final void zzd(zzvh zzvh) {
        zza((Class<?>) zzbsz.class, "onAdFailedToLoad", Integer.valueOf(zzvh.errorCode), zzvh.zzchs, zzvh.zzcht);
    }

    public final void onAdOpened() {
        zza((Class<?>) zzbsy.class, "onAdOpened", new Object[0]);
    }

    public final void onAdClosed() {
        zza((Class<?>) zzbsy.class, "onAdClosed", new Object[0]);
    }

    public final void onAdLeftApplication() {
        zza((Class<?>) zzbsy.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdClicked() {
        zza((Class<?>) zzve.class, "onAdClicked", new Object[0]);
    }

    public final void onAdImpression() {
        zza((Class<?>) zzbtq.class, "onAdImpression", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        zza((Class<?>) zzbsy.class, "onRewardedVideoStarted", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzavd zzavd, String str, String str2) {
        zza((Class<?>) zzbsy.class, "onRewarded", zzavd, str, str2);
    }

    public final void onRewardedVideoCompleted() {
        zza((Class<?>) zzbsy.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zza(zzdth zzdth, String str) {
        zza((Class<?>) zzdte.class, "onTaskCreated", str);
    }

    public final void zzb(zzdth zzdth, String str) {
        zza((Class<?>) zzdte.class, "onTaskStarted", str);
    }

    public final void zza(zzdth zzdth, String str, Throwable th) {
        zza((Class<?>) zzdte.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzc(zzdth zzdth, String str) {
        zza((Class<?>) zzdte.class, "onTaskSucceeded", str);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzcmm zzcmm = this.zzgpa;
        List<Object> list = this.zzejx;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcmm.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    public final void zzd(zzauj zzauj) {
        this.startTime = zzr.zzlc().elapsedRealtime();
        zza((Class<?>) zzbvm.class, "onAdRequest", new Object[0]);
    }
}
