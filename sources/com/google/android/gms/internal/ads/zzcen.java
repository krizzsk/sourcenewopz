package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcen {
    private final Executor executor;
    private final zzaei zzdpr;
    private final zzf zzecl;
    private final Executor zzfur;
    private final zzdpm zzfzg;
    private final zzcdr zzgeo;
    private final zzcdv zzgfq;
    private final zzcdm zzgfz;
    private final zzcev zzgii;
    private final zzcfd zzgij;

    public zzcen(zzf zzf, zzdpm zzdpm, zzcdv zzcdv, zzcdr zzcdr, zzcev zzcev, zzcfd zzcfd, Executor executor2, Executor executor3, zzcdm zzcdm) {
        this.zzecl = zzf;
        this.zzfzg = zzdpm;
        this.zzdpr = zzdpm.zzdpr;
        this.zzgfq = zzcdv;
        this.zzgeo = zzcdr;
        this.zzgii = zzcev;
        this.zzgij = zzcfd;
        this.zzfur = executor2;
        this.executor = executor3;
        this.zzgfz = zzcdm;
    }

    public final void zza(zzcfl zzcfl) {
        this.zzfur.execute(new zzcem(this, zzcfl));
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    public final void zzg(zzcfl zzcfl) {
        if (zzcfl != null && this.zzgii != null && zzcfl.zzapo() != null && this.zzgfq.zzapa()) {
            try {
                zzcfl.zzapo().addView(this.zzgii.zzapz());
            } catch (zzbfu e) {
                zzd.zza("web view can not be obtained", e);
            }
        }
    }

    public final void zzh(zzcfl zzcfl) {
        if (zzcfl != null) {
            Context context = zzcfl.zzakl().getContext();
            if (zzbn.zza(context, this.zzgfq.zzghi)) {
                if (!(context instanceof Activity)) {
                    zzd.zzdz("Activity context is needed for policy validator.");
                } else if (this.zzgij != null && zzcfl.zzapo() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzgij.zza(zzcfl.zzapo(), windowManager), zzbn.zzaaj());
                    } catch (zzbfu e) {
                        zzd.zza("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcfl zzcfl, String[] strArr) {
        Map<String, WeakReference<View>> zzapr = zzcfl.zzapr();
        if (zzapr == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzapr.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzaos = this.zzgeo.zzaos();
        if (zzaos == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzaos.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzaos.getParent()).removeView(zzaos);
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcub)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzaos, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzgeo.zzaos() == null) {
            return;
        }
        if (2 == this.zzgeo.zzaoo() || 1 == this.zzgeo.zzaoo()) {
            this.zzecl.zza(this.zzfzg.zzhny, String.valueOf(this.zzgeo.zzaoo()), z);
        } else if (6 == this.zzgeo.zzaoo()) {
            this.zzecl.zza(this.zzfzg.zzhny, "2", z);
            this.zzecl.zza(this.zzfzg.zzhny, "1", z);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzi(com.google.android.gms.internal.ads.zzcfl r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzcdv r0 = r9.zzgfq
            boolean r0 = r0.zzapc()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcdv r0 = r9.zzgfq
            boolean r0 = r0.zzapb()
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            r3 = 0
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "1098"
            java.lang.String r4 = "3011"
            java.lang.String[] r0 = new java.lang.String[]{r0, r4}
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r4 >= r5) goto L_0x0037
            r5 = r0[r4]
            android.view.View r5 = r10.zzgd(r5)
            if (r5 == 0) goto L_0x0034
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0034
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto L_0x0038
        L_0x0034:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            android.view.View r4 = r10.zzakl()
            android.content.Context r4 = r4.getContext()
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            com.google.android.gms.internal.ads.zzcdr r7 = r9.zzgeo
            android.view.View r7 = r7.zzaop()
            if (r7 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzcdr r4 = r9.zzgeo
            android.view.View r4 = r4.zzaop()
            com.google.android.gms.internal.ads.zzaei r7 = r9.zzdpr
            if (r7 != 0) goto L_0x005e
            goto L_0x009b
        L_0x005e:
            if (r0 != 0) goto L_0x009b
            int r7 = r7.zzbof
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r7)
            r4.setLayoutParams(r6)
            goto L_0x009b
        L_0x0069:
            com.google.android.gms.internal.ads.zzcdr r7 = r9.zzgeo
            com.google.android.gms.internal.ads.zzaek r7 = r7.zztu()
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzaed
            if (r7 != 0) goto L_0x0075
            r4 = r3
            goto L_0x009b
        L_0x0075:
            com.google.android.gms.internal.ads.zzcdr r7 = r9.zzgeo
            com.google.android.gms.internal.ads.zzaek r7 = r7.zztu()
            com.google.android.gms.internal.ads.zzaed r7 = (com.google.android.gms.internal.ads.zzaed) r7
            if (r0 != 0) goto L_0x0086
            int r8 = r7.zztm()
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r8)
        L_0x0086:
            com.google.android.gms.internal.ads.zzaec r8 = new com.google.android.gms.internal.ads.zzaec
            r8.<init>(r4, r7, r6)
            com.google.android.gms.internal.ads.zzabf<java.lang.String> r4 = com.google.android.gms.internal.ads.zzabq.zzcty
            com.google.android.gms.internal.ads.zzabm r6 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8.setContentDescription(r4)
            r4 = r8
        L_0x009b:
            r6 = -1
            if (r4 == 0) goto L_0x00e0
            android.view.ViewParent r7 = r4.getParent()
            boolean r7 = r7 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00af
            android.view.ViewParent r7 = r4.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r4)
        L_0x00af:
            if (r0 == 0) goto L_0x00b8
            r5.removeAllViews()
            r5.addView(r4)
            goto L_0x00d9
        L_0x00b8:
            com.google.android.gms.ads.formats.AdChoicesView r0 = new com.google.android.gms.ads.formats.AdChoicesView
            android.view.View r5 = r10.zzakl()
            android.content.Context r5 = r5.getContext()
            r0.<init>(r5)
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r6, r6)
            r0.setLayoutParams(r5)
            r0.addView(r4)
            android.widget.FrameLayout r5 = r10.zzapo()
            if (r5 == 0) goto L_0x00d9
            r5.addView(r0)
        L_0x00d9:
            java.lang.String r0 = r10.zzapt()
            r10.zza(r0, r4, r2)
        L_0x00e0:
            java.lang.String[] r0 = com.google.android.gms.internal.ads.zzcel.zzgib
            int r2 = r0.length
        L_0x00e3:
            if (r1 >= r2) goto L_0x00f5
            r4 = r0[r1]
            android.view.View r4 = r10.zzgd(r4)
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00f2
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            goto L_0x00f6
        L_0x00f2:
            int r1 = r1 + 1
            goto L_0x00e3
        L_0x00f5:
            r4 = r3
        L_0x00f6:
            java.util.concurrent.Executor r0 = r9.executor
            com.google.android.gms.internal.ads.zzcep r1 = new com.google.android.gms.internal.ads.zzcep
            r1.<init>(r9, r4)
            r0.execute(r1)
            if (r4 == 0) goto L_0x01ae
            boolean r0 = r9.zza((android.view.ViewGroup) r4)
            if (r0 == 0) goto L_0x011f
            com.google.android.gms.internal.ads.zzcdr r0 = r9.zzgeo
            com.google.android.gms.internal.ads.zzbfi r0 = r0.zzaot()
            if (r0 == 0) goto L_0x01ae
            com.google.android.gms.internal.ads.zzcdr r0 = r9.zzgeo
            com.google.android.gms.internal.ads.zzbfi r0 = r0.zzaot()
            com.google.android.gms.internal.ads.zzceo r1 = new com.google.android.gms.internal.ads.zzceo
            r1.<init>(r9, r10, r4)
            r0.zza((com.google.android.gms.internal.ads.zzaeg) r1)
            return
        L_0x011f:
            r4.removeAllViews()
            android.view.View r0 = r10.zzakl()
            if (r0 == 0) goto L_0x012d
            android.content.Context r0 = r0.getContext()
            goto L_0x012e
        L_0x012d:
            r0 = r3
        L_0x012e:
            if (r0 == 0) goto L_0x01ae
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabq.zzctx
            com.google.android.gms.internal.ads.zzabm r2 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzcdm r1 = r9.zzgfz
            com.google.android.gms.internal.ads.zzaer r1 = r1.zzue()
            if (r1 == 0) goto L_0x01ae
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zztr()     // Catch:{ RemoteException -> 0x014f }
            goto L_0x0161
        L_0x014f:
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.ads.internal.util.zzd.zzez(r10)
            return
        L_0x0155:
            com.google.android.gms.internal.ads.zzcdr r1 = r9.zzgeo
            com.google.android.gms.internal.ads.zzaes r1 = r1.zzaoq()
            if (r1 == 0) goto L_0x01ae
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zztn()     // Catch:{ RemoteException -> 0x01a9 }
        L_0x0161:
            if (r1 == 0) goto L_0x01ae
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            if (r1 == 0) goto L_0x01ae
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r0)
            r2.setImageDrawable(r1)
            if (r10 == 0) goto L_0x0179
            com.google.android.gms.dynamic.IObjectWrapper r3 = r10.zzapu()
        L_0x0179:
            if (r3 == 0) goto L_0x0198
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r10 = com.google.android.gms.internal.ads.zzabq.zzcys
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r10 = r0.zzd(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x018e
            goto L_0x0198
        L_0x018e:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            r2.setScaleType(r10)
            goto L_0x019d
        L_0x0198:
            android.widget.ImageView$ScaleType r10 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            r2.setScaleType(r10)
        L_0x019d:
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r6, r6)
            r2.setLayoutParams(r10)
            r4.addView(r2)
            goto L_0x01ae
        L_0x01a9:
            java.lang.String r10 = "Could not get drawable from image"
            com.google.android.gms.ads.internal.util.zzd.zzez(r10)
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcen.zzi(com.google.android.gms.internal.ads.zzcfl):void");
    }
}
