package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzaaa extends RemoteCreator<zzym> {
    public zzaaa() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final zzyh zzh(Context context) {
        try {
            IBinder zzb = ((zzym) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), 204890000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzyh) {
                return (zzyh) queryLocalInterface;
            }
            return new zzyj(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbao.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzym) {
            return (zzym) queryLocalInterface;
        }
        return new zzyl(iBinder);
    }
}
