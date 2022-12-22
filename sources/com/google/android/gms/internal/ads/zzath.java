package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzath extends zzatb {
    private final /* synthetic */ UpdateClickUrlCallback zzdvc;

    zzath(zzatf zzatf, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdvc = updateClickUrlCallback;
    }

    public final void onSuccess(List<Uri> list) {
        this.zzdvc.onSuccess(list.get(0));
    }

    public final void onError(String str) {
        this.zzdvc.onFailure(str);
    }
}
