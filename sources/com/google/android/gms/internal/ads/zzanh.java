package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzanh implements Runnable {
    private final Context zzclh;
    private final zzane zzdmw;
    private final String zzdmx;

    zzanh(zzane zzane, Context context, String str) {
        this.zzdmw = zzane;
        this.zzclh = context;
        this.zzdmx = str;
    }

    public final void run() {
        Context context = this.zzclh;
        String str = this.zzdmx;
        zzabq.initialize(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzww.zzra().zzd(zzabq.zzcov)).booleanValue());
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
            bundle.putString("ad_storage", "denied");
            bundle.putString("analytics_storage", "denied");
        }
        try {
            ((zzbhc) zzban.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzang.zzbys)).zza(ObjectWrapper.wrap(context), new zzanf(AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle)));
        } catch (RemoteException | zzbap | NullPointerException e) {
            zzbao.zze("#007 Could not call remote method.", e);
        }
    }
}
