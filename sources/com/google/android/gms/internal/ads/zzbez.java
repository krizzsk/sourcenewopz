package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbez implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzest;

    zzbez(JsResult jsResult) {
        this.zzest = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzest.cancel();
    }
}
