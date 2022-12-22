package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcdf extends zzbpc {
    private final Context context;
    private final zzbar zzbpx;
    private final zzei zzeus;
    private final Executor zzfur;
    private final zzcdy zzfwx;
    private final zzaya zzfyl;
    private final zzcdr zzgeo;
    private final zzcdz zzgfo;
    private final zzcen zzgfp;
    private final zzcdv zzgfq;
    private final zzeru<zzchm> zzgfr;
    private final zzeru<zzchk> zzgfs;
    private final zzeru<zzcht> zzgft;
    private final zzeru<zzchg> zzgfu;
    private final zzeru<zzcho> zzgfv;
    /* access modifiers changed from: private */
    public zzcfl zzgfw;
    private boolean zzgfx;
    private boolean zzgfy = false;
    private final zzcdm zzgfz;
    private final zzdah zzgga;
    /* access modifiers changed from: private */
    public final Map<String, Boolean> zzggb;
    private final List<zzqs> zzggc;
    private final zzqz zzggd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcdf(zzbpf zzbpf, Executor executor, zzcdr zzcdr, zzcdz zzcdz, zzcen zzcen, zzcdv zzcdv, zzcdy zzcdy, zzeru<zzchm> zzeru, zzeru<zzchk> zzeru2, zzeru<zzcht> zzeru3, zzeru<zzchg> zzeru4, zzeru<zzcho> zzeru5, zzaya zzaya, zzei zzei, zzbar zzbar, Context context2, zzcdm zzcdm, zzdah zzdah, zzqz zzqz) {
        super(zzbpf);
        this.zzfur = executor;
        this.zzgeo = zzcdr;
        this.zzgfo = zzcdz;
        this.zzgfp = zzcen;
        this.zzgfq = zzcdv;
        this.zzfwx = zzcdy;
        this.zzgfr = zzeru;
        this.zzgfs = zzeru2;
        this.zzgft = zzeru3;
        this.zzgfu = zzeru4;
        this.zzgfv = zzeru5;
        this.zzfyl = zzaya;
        this.zzeus = zzei;
        this.zzbpx = zzbar;
        this.context = context2;
        this.zzgfz = zzcdm;
        this.zzgga = zzdah;
        this.zzggb = new HashMap();
        this.zzggc = new ArrayList();
        this.zzggd = zzqz;
    }

    public final void zzakv() {
        this.zzfur.execute(new zzcde(this));
        if (this.zzgeo.zzaoo() != 7) {
            Executor executor = this.zzfur;
            zzcdz zzcdz = this.zzgfo;
            zzcdz.getClass();
            executor.execute(zzcdh.zza(zzcdz));
        }
        super.zzakv();
    }

    public final synchronized void zzfx(String str) {
        this.zzgfo.zzfx(str);
    }

    public final synchronized void zzaod() {
        if (!this.zzgfx) {
            this.zzgfo.zzaod();
        }
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzgfo.zzf(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzgfx) {
            return true;
        }
        boolean zzh = this.zzgfo.zzh(bundle);
        this.zzgfx = zzh;
        return zzh;
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzgfo.zzg(bundle);
    }

    public final synchronized void destroy() {
        this.zzfur.execute(new zzcdg(this));
        super.destroy();
    }

    public final synchronized void zza(zzcfl zzcfl) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrx)).booleanValue()) {
            zzj.zzegq.post(new zzcdj(this, zzcfl));
        } else {
            zzf(zzcfl);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final void zzf(zzcfl zzcfl) {
        JSONObject jSONObject;
        Iterator<String> keys;
        View view;
        zzdy zzcb;
        this.zzgfw = zzcfl;
        this.zzgfp.zza(zzcfl);
        this.zzgfo.zza(zzcfl.zzakl(), zzcfl.zzapr(), zzcfl.zzaps(), (View.OnTouchListener) zzcfl, (View.OnClickListener) zzcfl);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsu)).booleanValue() && (zzcb = this.zzeus.zzcb()) != null) {
            zzcb.zzb(zzcfl.zzakl());
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcry)).booleanValue() && this.zzeux.zzhnb && (jSONObject = this.zzeux.zzhna) != null && (keys = jSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String next = keys.next();
                WeakReference weakReference = this.zzgfw.zzapq().get(next);
                this.zzggb.put(next, false);
                if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                    zzqs zzqs = new zzqs(this.context, view);
                    this.zzggc.add(zzqs);
                    zzqs.zza((zzqw) new zzcdk(this, next));
                }
            }
        }
        if (zzcfl.zzapp() != null) {
            zzcfl.zzapp().zza((zzqw) this.zzfyl);
        }
    }

    public final synchronized void zzc(zzcfl zzcfl) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcrx)).booleanValue()) {
            zzj.zzegq.post(new zzcdi(this, zzcfl));
        } else {
            zze(zzcfl);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final void zze(zzcfl zzcfl) {
        this.zzgfo.zza(zzcfl.zzakl(), zzcfl.zzapq());
        if (zzcfl.zzapo() != null) {
            zzcfl.zzapo().setClickable(false);
            zzcfl.zzapo().removeAllViews();
        }
        if (zzcfl.zzapp() != null) {
            zzcfl.zzapp().zzb(this.zzfyl);
        }
        this.zzgfw = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzcen r0 = r8.zzgfp     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcfl r1 = r8.zzgfw     // Catch:{ all -> 0x0045 }
            r0.zzg(r1)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcdz r2 = r8.zzgfo     // Catch:{ all -> 0x0045 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zza((android.view.View) r3, (android.view.View) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r6, (boolean) r7)     // Catch:{ all -> 0x0045 }
            boolean r9 = r8.zzgfy     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzabq.zzctv     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzabm r10 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r10.zzd(r9)     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0045 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzcdr r9 = r8.zzgeo     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbfi r9 = r9.zzaot()     // Catch:{ all -> 0x0045 }
            if (r9 != 0) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            com.google.android.gms.internal.ads.zzcdr r9 = r8.zzgeo     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbfi r9 = r9.zzaot()     // Catch:{ all -> 0x0045 }
            java.lang.String r10 = "onSdkAdUserInteractionClick"
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0045 }
            r11.<init>()     // Catch:{ all -> 0x0045 }
            r9.zza((java.lang.String) r10, (java.util.Map<java.lang.String, ?>) r11)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return
        L_0x0043:
            monitor-exit(r8)
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdf.zza(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgfo.zza(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r5, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r6, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r7, boolean r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzgfx     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcry     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00ad }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x00ad }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ad }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ad }
            r1 = 1
            if (r0 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzdot r0 = r4.zzeux     // Catch:{ all -> 0x00ad }
            boolean r0 = r0.zzhnb     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x004b
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r4.zzggb     // Catch:{ all -> 0x00ad }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00ad }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ad }
        L_0x002a:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x00ad }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00ad }
            java.util.Map<java.lang.String, java.lang.Boolean> r3 = r4.zzggb     // Catch:{ all -> 0x00ad }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x00ad }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00ad }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00ad }
            if (r2 != 0) goto L_0x002a
            r0 = 0
            goto L_0x0047
        L_0x0046:
            r0 = 1
        L_0x0047:
            if (r0 != 0) goto L_0x004b
            monitor-exit(r4)
            return
        L_0x004b:
            if (r8 == 0) goto L_0x005d
            com.google.android.gms.internal.ads.zzcen r8 = r4.zzgfp     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzcfl r0 = r4.zzgfw     // Catch:{ all -> 0x00ad }
            r8.zzh(r0)     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzcdz r8 = r4.zzgfo     // Catch:{ all -> 0x00ad }
            r8.zzb(r5, r6, r7)     // Catch:{ all -> 0x00ad }
            r4.zzgfx = r1     // Catch:{ all -> 0x00ad }
            monitor-exit(r4)
            return
        L_0x005d:
            if (r8 != 0) goto L_0x00ab
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r8 = com.google.android.gms.internal.ads.zzabq.zzcuc     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x00ad }
            java.lang.Object r8 = r0.zzd(r8)     // Catch:{ all -> 0x00ad }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00ad }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00ad }
            if (r8 == 0) goto L_0x00ab
            if (r6 == 0) goto L_0x00ab
            java.util.Set r8 = r6.entrySet()     // Catch:{ all -> 0x00ad }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00ad }
        L_0x007b:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00ab
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00ad }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00ad }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00ad }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x00ad }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00ad }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x007b
            boolean r0 = zzz(r0)     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x007b
            com.google.android.gms.internal.ads.zzcen r8 = r4.zzgfp     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzcfl r0 = r4.zzgfw     // Catch:{ all -> 0x00ad }
            r8.zzh(r0)     // Catch:{ all -> 0x00ad }
            com.google.android.gms.internal.ads.zzcdz r8 = r4.zzgfo     // Catch:{ all -> 0x00ad }
            r8.zzb(r5, r6, r7)     // Catch:{ all -> 0x00ad }
            r4.zzgfx = r1     // Catch:{ all -> 0x00ad }
            monitor-exit(r4)
            return
        L_0x00ab:
            monitor-exit(r4)
            return
        L_0x00ad:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdf.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zzgfo.zza(view, map, map2);
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzgfo.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzagr zzagr) {
        this.zzgfo.zza(zzagr);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzgfo.cancelUnconfirmedClick();
    }

    public final synchronized void zza(zzys zzys) {
        this.zzgfo.zza(zzys);
    }

    public final synchronized void zza(zzyo zzyo) {
        this.zzgfo.zza(zzyo);
    }

    public final synchronized void zzud() {
        this.zzgfo.zzud();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzgfw == null) {
            zzd.zzdz("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzfur.execute(new zzcdl(this, this.zzgfw instanceof zzcei));
        }
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzgfo.isCustomClickGestureEnabled();
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    public final boolean zzaoj() {
        return this.zzgfq.zzapb();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(java.lang.String r16, boolean r17) {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.ads.zzcdv r1 = r0.zzgfq
            boolean r1 = r1.zzaok()
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            com.google.android.gms.internal.ads.zzcdr r1 = r0.zzgeo
            com.google.android.gms.internal.ads.zzbfi r1 = r1.zzaou()
            com.google.android.gms.internal.ads.zzcdr r2 = r0.zzgeo
            com.google.android.gms.internal.ads.zzbfi r2 = r2.zzaot()
            if (r1 != 0) goto L_0x001b
            if (r2 != 0) goto L_0x001b
            return
        L_0x001b:
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            if (r2 == 0) goto L_0x0025
            r3 = 1
        L_0x0025:
            r6 = 0
            if (r5 == 0) goto L_0x002a
        L_0x0028:
            r10 = r6
            goto L_0x0032
        L_0x002a:
            if (r3 == 0) goto L_0x0030
            java.lang.String r6 = "javascript"
            r1 = r2
            goto L_0x0028
        L_0x0030:
            r1 = r6
            r10 = r1
        L_0x0032:
            android.webkit.WebView r5 = r1.getWebView()
            if (r5 != 0) goto L_0x003e
            java.lang.String r1 = "Webview is null in InternalNativeAd"
            com.google.android.gms.ads.internal.util.zzd.zzez(r1)
            return
        L_0x003e:
            com.google.android.gms.internal.ads.zzasb r5 = com.google.android.gms.ads.internal.zzr.zzlk()
            android.content.Context r6 = r0.context
            boolean r5 = r5.zzm(r6)
            if (r5 != 0) goto L_0x0050
            java.lang.String r1 = "Failed to initialize omid in InternalNativeAd"
            com.google.android.gms.ads.internal.util.zzd.zzez(r1)
            return
        L_0x0050:
            com.google.android.gms.internal.ads.zzbar r5 = r0.zzbpx
            int r5 = r5.zzeka
            com.google.android.gms.internal.ads.zzbar r6 = r0.zzbpx
            int r6 = r6.zzekb
            r7 = 23
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r5)
            java.lang.String r5 = "."
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabq.zzcwl
            com.google.android.gms.internal.ads.zzabm r7 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r5 = r7.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00b1
            if (r3 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzasc r5 = com.google.android.gms.internal.ads.zzasc.zzdsm
            com.google.android.gms.internal.ads.zzase r7 = com.google.android.gms.internal.ads.zzase.DEFINED_BY_JAVASCRIPT
        L_0x0086:
            r13 = r5
            r12 = r7
            goto L_0x009a
        L_0x0089:
            com.google.android.gms.internal.ads.zzasc r5 = com.google.android.gms.internal.ads.zzasc.NATIVE_DISPLAY
            com.google.android.gms.internal.ads.zzcdr r7 = r0.zzgeo
            int r7 = r7.zzaoo()
            r8 = 3
            if (r7 != r8) goto L_0x0097
            com.google.android.gms.internal.ads.zzase r7 = com.google.android.gms.internal.ads.zzase.UNSPECIFIED
            goto L_0x0086
        L_0x0097:
            com.google.android.gms.internal.ads.zzase r7 = com.google.android.gms.internal.ads.zzase.ONE_PIXEL
            goto L_0x0086
        L_0x009a:
            com.google.android.gms.internal.ads.zzasb r5 = com.google.android.gms.ads.internal.zzr.zzlk()
            android.webkit.WebView r7 = r1.getWebView()
            com.google.android.gms.internal.ads.zzdot r8 = r0.zzeux
            java.lang.String r14 = r8.zzcig
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zzb(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00c3
        L_0x00b1:
            com.google.android.gms.internal.ads.zzasb r5 = com.google.android.gms.ads.internal.zzr.zzlk()
            android.webkit.WebView r7 = r1.getWebView()
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zza(r6, r7, r8, r9, r10, r11)
        L_0x00c3:
            if (r5 != 0) goto L_0x00cb
            java.lang.String r1 = "Failed to create omid session in InternalNativeAd"
            com.google.android.gms.ads.internal.util.zzd.zzez(r1)
            return
        L_0x00cb:
            com.google.android.gms.internal.ads.zzcdr r6 = r0.zzgeo
            r6.zzau(r5)
            r1.zzar(r5)
            if (r3 == 0) goto L_0x00e4
            android.view.View r2 = r2.getView()
            if (r2 == 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzasb r3 = com.google.android.gms.ads.internal.zzr.zzlk()
            r3.zza(r5, r2)
        L_0x00e2:
            r0.zzgfy = r4
        L_0x00e4:
            if (r17 == 0) goto L_0x0109
            com.google.android.gms.internal.ads.zzasb r2 = com.google.android.gms.ads.internal.zzr.zzlk()
            r2.zzac(r5)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabq.zzcwn
            com.google.android.gms.internal.ads.zzabm r3 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0109
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.lang.String r3 = "onSdkLoaded"
            r1.zza((java.lang.String) r3, (java.util.Map<java.lang.String, ?>) r2)
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdf.zzk(java.lang.String, boolean):void");
    }

    public final boolean zzaok() {
        return this.zzgfq.zzaok();
    }

    public final void zzaa(View view) {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        boolean z = this.zzgeo.zzaou() != null;
        if (this.zzgfq.zzaok() && zzaov != null && z && view != null) {
            zzr.zzlk().zza(zzaov, view);
        }
    }

    public final void zzab(View view) {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        if (this.zzgfq.zzaok() && zzaov != null && view != null) {
            zzr.zzlk().zzb(zzaov, view);
        }
    }

    public final zzcdm zzaol() {
        return this.zzgfz;
    }

    public final synchronized void zza(zzyx zzyx) {
        this.zzgga.zzc(zzyx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzbl(boolean z) {
        this.zzgfo.zza(this.zzgfw.zzakl(), this.zzgfw.zzapq(), this.zzgfw.zzapr(), z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaom() {
        this.zzgfo.destroy();
        this.zzgeo.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaon() {
        try {
            int zzaoo = this.zzgeo.zzaoo();
            if (zzaoo != 1) {
                if (zzaoo != 2) {
                    if (zzaoo != 3) {
                        if (zzaoo != 6) {
                            if (zzaoo != 7) {
                                zzd.zzex("Wrong native template id!");
                            } else if (this.zzfwx.zzaph() != null) {
                                this.zzfwx.zzaph().zza(this.zzgfu.get());
                            }
                        } else if (this.zzfwx.zzapf() != null) {
                            zzk("Google", true);
                            this.zzfwx.zzapf().zza(this.zzgft.get());
                        }
                    } else if (this.zzfwx.zzgb(this.zzgeo.getCustomTemplateId()) != null) {
                        if (this.zzgeo.zzaot() != null) {
                            zzk("Google", true);
                        }
                        this.zzfwx.zzgb(this.zzgeo.getCustomTemplateId()).zza(this.zzgfv.get());
                    }
                } else if (this.zzfwx.zzape() != null) {
                    zzk("Google", true);
                    this.zzfwx.zzape().zza(this.zzgfs.get());
                }
            } else if (this.zzfwx.zzapd() != null) {
                zzk("Google", true);
                this.zzfwx.zzapd().zza(this.zzgfr.get());
            }
        } catch (RemoteException e) {
            zzd.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }
}
