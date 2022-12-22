package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfe implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzesu;

    zzbfe(JsPromptResult jsPromptResult) {
        this.zzesu = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzesu.cancel();
    }
}
