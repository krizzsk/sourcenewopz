package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzavr extends RemoteCreator<zzavl> {
    public zzavr() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzavg zzc(Context context, zzann zzann) {
        try {
            IBinder zzd = ((zzavl) getRemoteCreatorInstance(context)).zzd(ObjectWrapper.wrap(context), zzann, 204890000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzavg) {
                return (zzavg) queryLocalInterface;
            }
            return new zzavi(zzd);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbao.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzavl) {
            return (zzavl) queryLocalInterface;
        }
        return new zzavk(iBinder);
    }
}
