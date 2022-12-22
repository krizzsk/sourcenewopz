package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
final class zzate extends zzatb {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzduz;

    zzate(zzatf zzatf, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzduz = updateImpressionUrlsCallback;
    }

    public final void onSuccess(List<Uri> list) {
        this.zzduz.onSuccess(list);
    }

    public final void onError(String str) {
        this.zzduz.onFailure(str);
    }
}
