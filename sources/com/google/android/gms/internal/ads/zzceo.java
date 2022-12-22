package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzceo implements zzaeg {
    private final /* synthetic */ zzcfl zzgik;
    private final /* synthetic */ ViewGroup zzgil;
    private final /* synthetic */ zzcen zzgim;

    zzceo(zzcen zzcen, zzcfl zzcfl, ViewGroup viewGroup) {
        this.zzgim = zzcen;
        this.zzgik = zzcfl;
        this.zzgil = viewGroup;
    }

    public final void zztp() {
        if (zzcen.zza(this.zzgik, zzcel.zzgib)) {
            this.zzgik.onClick(this.zzgil);
        }
    }

    public final void zzc(MotionEvent motionEvent) {
        this.zzgik.onTouch((View) null, motionEvent);
    }

    public final JSONObject zztq() {
        return this.zzgik.zztq();
    }
}
