package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbpc {
    protected final zzdot zzeux;
    protected final zzdpi zzftl;
    private final zzbts zzfym;
    private final zzbui zzfyn;
    private final zzdmi zzfyo;
    private final zzbsp zzfyp;
    private final zzbvl zzfyq;

    protected zzbpc(zzbpf zzbpf) {
        this.zzftl = zzbpf.zzftl;
        this.zzeux = zzbpf.zzeux;
        this.zzfym = zzbpf.zzfym;
        this.zzfyn = zzbpf.zzfyn;
        this.zzfyo = zzbpf.zzfyo;
        this.zzfyp = zzbpf.zzfyp;
        this.zzfyq = zzbpf.zzfyq;
    }

    public final zzbts zzalk() {
        return this.zzfym;
    }

    public void zzakv() {
        this.zzfyn.onAdLoaded();
    }

    public final zzbsp zzall() {
        return this.zzfyp;
    }

    public void destroy() {
        this.zzfym.zzcg((Context) null);
    }

    public final zzdmi zzalm() {
        return this.zzfyo;
    }

    public final zzbwp zzaln() {
        return this.zzfyq.zzaln();
    }
}
