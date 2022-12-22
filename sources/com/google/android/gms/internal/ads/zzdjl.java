package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzbx;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdjl implements Callable {
    static final Callable zzhez = new zzdjl();

    private zzdjl() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzww.zzra().zzd(zzabq.zzcnx);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzww.zzra().zzd(zzabq.zzcny)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzbx.zzer(str2));
                }
            }
        }
        return new zzdjj(hashMap);
    }
}
