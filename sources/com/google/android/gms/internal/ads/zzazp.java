package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzazp implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbbe zzedv;

    zzazp(zzazm zzazm, Context context, zzbbe zzbbe) {
        this.val$context = context;
        this.zzedv = zzbbe;
    }

    public final void run() {
        try {
            this.zzedv.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzedv.setException(e);
            zzbao.zzc("Exception while getting advertising Id info", e);
        }
    }
}
