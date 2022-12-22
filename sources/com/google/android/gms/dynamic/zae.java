package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
final class zae implements View.OnClickListener {
    final /* synthetic */ Context zaa;
    final /* synthetic */ Intent zab;

    zae(Context context, Intent intent) {
        this.zaa = context;
        this.zab = intent;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        try {
            this.zaa.startActivity(this.zab);
        } catch (ActivityNotFoundException e) {
            SystemUtils.log(6, "DeferredLifecycleHelper", "Failed to start resolution intent", e, "com.google.android.gms.dynamic.zae", 2);
        }
    }
}
