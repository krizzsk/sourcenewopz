package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzef extends zzea {
    public static zzef zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcv.zzno);
    }

    public static zzef zzb(String str, Context context, boolean z, int i) {
        zza(context, z);
        zza(str, context, z, i);
        return new zzef(context, str, z, i);
    }

    private zzef(Context context, String str, boolean z, int i) {
        super(context, str, z, i);
    }

    /* access modifiers changed from: protected */
    public final List<Callable<Void>> zza(zzfc zzfc, Context context, zzcf.zza.zzb zzb, zzcb.zza zza) {
        if (zzfc.zzch() == null || !this.zzxk) {
            return super.zza(zzfc, context, zzb, zza);
        }
        int zzbv = zzfc.zzbv();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zza(zzfc, context, zzb, zza));
        arrayList.add(new zzfw(zzfc, "+TO/Mpw5B9Ysegk2ohW075Jqflr1OZ9qfpBhm7dfWn/YVCIrMVqb+Yemq/MJcA7W", "NFKeWWLJ9pOo7U7UIrMCAjT+FIdaFD6BH0lqisOKm88=", zzb, zzbv, 24));
        return arrayList;
    }
}
