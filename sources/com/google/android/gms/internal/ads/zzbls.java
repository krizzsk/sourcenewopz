package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbls implements zzesa<Set<zzbzl<zzp>>> {
    private final zzesn<zzbli> zzeyk;
    private final zzesn<Executor> zzeyl;
    private final zzesn<JSONObject> zzfvl;

    private zzbls(zzesn<zzbli> zzesn, zzesn<Executor> zzesn2, zzesn<JSONObject> zzesn3) {
        this.zzeyk = zzesn;
        this.zzeyl = zzesn2;
        this.zzfvl = zzesn3;
    }

    public static zzbls zzd(zzesn<zzbli> zzesn, zzesn<Executor> zzesn2, zzesn<JSONObject> zzesn3) {
        return new zzbls(zzesn, zzesn2, zzesn3);
    }

    public final /* synthetic */ Object get() {
        Set set;
        zzbli zzbli = this.zzeyk.get();
        Executor executor = this.zzeyl.get();
        if (this.zzfvl.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbzl(zzbli, executor));
        }
        return (Set) zzesg.zzbd(set);
    }
}
