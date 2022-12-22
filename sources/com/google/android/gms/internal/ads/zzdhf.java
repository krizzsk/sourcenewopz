package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdhf implements Callable {
    private final Object zzdms;
    private final List zzhfu;

    zzdhf(List list, Object obj) {
        this.zzhfu = list;
        this.zzdms = obj;
    }

    public final Object call() {
        List<zzebt> list = this.zzhfu;
        Object obj = this.zzdms;
        for (zzebt zzebt : list) {
            zzdhb zzdhb = (zzdhb) zzebt.get();
            if (zzdhb != null) {
                zzdhb.zzr(obj);
            }
        }
        return obj;
    }
}
