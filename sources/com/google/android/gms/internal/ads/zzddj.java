package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzddj implements zzdhb {
    private final ArrayList zzhdq;

    zzddj(ArrayList arrayList) {
        this.zzhdq = arrayList;
    }

    public final void zzr(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzhdq);
    }
}
