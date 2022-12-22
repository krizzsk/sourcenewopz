package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcd implements zzdhe<zzdce> {
    private final Context context;
    private final zzdpm zzfzg;
    private final zzebs zzhdd;
    private final View zzhde;

    public zzdcd(zzebs zzebs, Context context2, zzdpm zzdpm, ViewGroup viewGroup) {
        this.zzhdd = zzebs;
        this.context = context2;
        this.zzfzg = zzdpm;
        this.zzhde = viewGroup;
    }

    public final zzebt<zzdce> zzatu() {
        return this.zzhdd.zze(new zzdcg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdce zzatv() throws Exception {
        Context context2 = this.context;
        zzvt zzvt = this.zzfzg.zzbpy;
        ArrayList arrayList = new ArrayList();
        View view = this.zzhde;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzdce(context2, zzvt, arrayList);
    }
}
