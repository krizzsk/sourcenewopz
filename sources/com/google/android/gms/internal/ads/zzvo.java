package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzvo extends RemoteCreator<zzxr> {
    public zzvo() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final zzxq zza(Context context, zzvt zzvt, String str, zzann zzann, int i) {
        try {
            IBinder zza = ((zzxr) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzvt, str, zzann, 204890000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxq) {
                return (zzxq) queryLocalInterface;
            }
            return new zzxs(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzbao.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzxr) {
            return (zzxr) queryLocalInterface;
        }
        return new zzxu(iBinder);
    }
}
