package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;
import com.didi.autotracker.AutoTrackHelper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfg implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzesu;
    private final /* synthetic */ EditText zzesw;

    zzbfg(JsPromptResult jsPromptResult, EditText editText) {
        this.zzesu = jsPromptResult;
        this.zzesw = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
        this.zzesu.confirm(this.zzesw.getText().toString());
    }
}
