package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbyo implements zzesa<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbxr zzgdc;

    private zzbyo(zzbxr zzbxr) {
        this.zzgdc = zzbxr;
    }

    public static zzbyo zzac(zzbxr zzbxr) {
        return new zzbyo(zzbxr);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
