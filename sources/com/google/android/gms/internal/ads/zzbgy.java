package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbgy extends MutableContextWrapper {
    private Context zzaai;
    private Activity zzeji;
    private Context zzewt;

    public zzbgy(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final void setBaseContext(Context context) {
        this.zzaai = context.getApplicationContext();
        this.zzeji = context instanceof Activity ? (Activity) context : null;
        this.zzewt = context;
        super.setBaseContext(this.zzaai);
    }

    public final void startActivity(Intent intent) {
        Activity activity = this.zzeji;
        if (activity != null) {
            activity.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.zzaai.startActivity(intent);
    }

    public final Activity zzabx() {
        return this.zzeji;
    }

    public final Object getSystemService(String str) {
        return this.zzewt.getSystemService(str);
    }

    public final Context zzaea() {
        return this.zzewt;
    }
}
