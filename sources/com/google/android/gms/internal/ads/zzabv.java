package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzabv {
    static List<String> zzso() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzacy.zzh("gad:dynamite_module:experiment_id", ""));
        zza(arrayList, zzadl.zzdet);
        zza(arrayList, zzadl.zzdeu);
        zza(arrayList, zzadl.zzdev);
        zza(arrayList, zzadl.zzdew);
        zza(arrayList, zzadl.zzdex);
        zza(arrayList, zzadl.zzdfd);
        zza(arrayList, zzadl.zzdey);
        zza(arrayList, zzadl.zzdez);
        zza(arrayList, zzadl.zzdfa);
        zza(arrayList, zzadl.zzdfb);
        zza(arrayList, zzadl.zzdfc);
        return arrayList;
    }

    static List<String> zzsp() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzadu.zzdfy);
        return arrayList;
    }

    private static void zza(List<String> list, zzacy<String> zzacy) {
        String str = zzacy.get();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
