package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzbbz extends TextureView implements zzbcw {
    protected final zzbcj zzelw = new zzbcj();
    protected final zzbct zzelx;

    public zzbbz(Context context) {
        super(context);
        this.zzelx = new zzbct(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract long getTotalBytes();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbca zzbca);

    public abstract String zzaaw();

    public abstract long zzaba();

    public abstract int zzabb();

    public abstract void zzabc();

    public void zzdq(int i) {
    }

    public void zzdr(int i) {
    }

    public void zzds(int i) {
    }

    public void zzdt(int i) {
    }

    public void zzdu(int i) {
    }

    public abstract long zznh();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }
}
