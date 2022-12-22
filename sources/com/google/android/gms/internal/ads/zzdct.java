package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzdct implements zzdhb {
    private final ArrayList zzhdq;

    zzdct(ArrayList arrayList) {
        this.zzhdq = arrayList;
    }

    public final void zzr(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzhdq);
    }
}
