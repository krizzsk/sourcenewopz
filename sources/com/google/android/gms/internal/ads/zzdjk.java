package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdjk implements zzesa<zzdhd<JSONObject>> {
    public static zzdhd<JSONObject> zza(zzazk zzazk, Object obj, zzdhy zzdhy, zzdiv zzdiv, zzeru<zzdhs> zzeru, zzeru<zzdic> zzeru2, zzeru<zzdig> zzeru3, zzeru<zzdim> zzeru4, zzeru<zzdir> zzeru5, zzeru<zzdja> zzeru6, zzeru<zzdjm> zzeru7, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdin) obj);
        hashSet.add(zzdhy);
        hashSet.add(zzdiv);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxs)).booleanValue()) {
            hashSet.add(zzeru.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxt)).booleanValue()) {
            hashSet.add(zzeru2.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxu)).booleanValue()) {
            hashSet.add(zzeru3.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxv)).booleanValue()) {
            hashSet.add(zzeru4.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcya)).booleanValue()) {
            hashSet.add(zzeru6.get());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyb)).booleanValue()) {
            hashSet.add(zzeru7.get());
        }
        return (zzdhd) zzesg.zzbd(new zzdhd(executor, hashSet));
    }

    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
