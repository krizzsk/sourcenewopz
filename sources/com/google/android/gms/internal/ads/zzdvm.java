package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final /* synthetic */ class zzdvm implements OnFailureListener {
    private final zzdvl zzhwc;

    zzdvm(zzdvl zzdvl) {
        this.zzhwc = zzdvl;
    }

    public final void onFailure(Exception exc) {
        this.zzhwc.zzc(exc);
    }
}
