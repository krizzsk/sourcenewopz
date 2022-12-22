package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzue {
    zzhb zzbyt;
    boolean zzbyu;

    public final zzui zzf(byte[] bArr) {
        return new zzui(this, bArr);
    }

    public zzue(Context context, String str, String str2) {
        zzabq.initialize(context);
        try {
            this.zzbyt = (zzhb) zzban.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzud.zzbys);
            ObjectWrapper.wrap(context);
            this.zzbyt.zza(ObjectWrapper.wrap(context), str, (String) null);
            this.zzbyu = true;
        } catch (RemoteException | zzbap | NullPointerException unused) {
            zzbao.zzdz("Cannot dynamite load clearcut");
        }
    }

    public zzue(Context context) {
        zzabq.initialize(context);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue()) {
            try {
                this.zzbyt = (zzhb) zzban.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzug.zzbys);
                ObjectWrapper.wrap(context);
                this.zzbyt.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbyu = true;
            } catch (RemoteException | zzbap | NullPointerException unused) {
                zzbao.zzdz("Cannot dynamite load clearcut");
            }
        }
    }

    public zzue() {
    }
}
