package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdce implements zzdhb<Bundle> {
    private final Context context;
    private final zzvt zzbpy;
    private final List<Parcelable> zzhdf;

    public zzdce(Context context2, zzvt zzvt, List<Parcelable> list) {
        this.context = context2;
        this.zzbpy = zzvt;
        this.zzhdf = list;
    }

    public final /* synthetic */ void zzr(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (zzadp.zzdfk.get().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzr.zzkv();
            bundle2.putString("activity", zzj.zzas(this.context));
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzbpy.width);
            bundle3.putInt("height", this.zzbpy.height);
            bundle2.putBundle("size", bundle3);
            if (this.zzhdf.size() > 0) {
                List<Parcelable> list = this.zzhdf;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle("view_hierarchy", bundle2);
        }
    }
}
