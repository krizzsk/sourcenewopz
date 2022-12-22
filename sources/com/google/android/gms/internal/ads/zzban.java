package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzban {
    public static <T> T zza(Context context, String str, zzbaq<IBinder, T> zzbaq) throws zzbap {
        try {
            return zzbaq.apply(zzbx(context).instantiate(str));
        } catch (Exception e) {
            throw new zzbap(e);
        }
    }

    public static Context zzbw(Context context) throws zzbap {
        return zzbx(context).getModuleContext();
    }

    private static DynamiteModule zzbx(Context context) throws zzbap {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzbap(e);
        }
    }
}
