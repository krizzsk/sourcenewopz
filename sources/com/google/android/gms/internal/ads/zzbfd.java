package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfd implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzesu;

    zzbfd(JsPromptResult jsPromptResult) {
        this.zzesu = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzesu.cancel();
    }
}
