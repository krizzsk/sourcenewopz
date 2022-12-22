package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final /* synthetic */ class zzawu implements zzbaq {
    static final zzbaq zzbys = new zzawu();

    private zzawu() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzawl) {
            return (zzawl) queryLocalInterface;
        }
        return new zzawk(iBinder);
    }
}
