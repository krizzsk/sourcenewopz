package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcel extends zzaez implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcfl {
    public static final String[] zzgib = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, "3010"};
    private FrameLayout zzboi;
    private zzaer zzclt;
    private Map<String, WeakReference<View>> zzdva = new HashMap();
    private final int zzekb;
    private boolean zzevf = false;
    private zzcdf zzghx;
    private zzqs zzghy;
    private final String zzgia;
    private FrameLayout zzgic;
    private zzebs zzgid;
    private View zzgie;
    private IObjectWrapper zzgif = null;
    private boolean zzgig;

    public zzcel(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzgic = frameLayout;
        this.zzboi = frameLayout2;
        this.zzekb = 204890000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzgia = str;
        zzr.zzls();
        zzbbm.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzr.zzls();
        zzbbm.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgid = zzbat.zzeki;
        this.zzghy = new zzqs(this.zzgic.getContext(), this.zzgic);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzevf     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzdva     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzdva     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzekb     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbn.zzdn(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcel.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized IObjectWrapper zzco(String str) {
        return ObjectWrapper.wrap(zzgd(str));
    }

    public final synchronized View zzgd(String str) {
        if (this.zzevf) {
            return null;
        }
        WeakReference weakReference = this.zzdva.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzevf     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x0048 }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzcdf     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.ads.internal.util.zzd.zzez(r2)     // Catch:{ all -> 0x0048 }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzcdf r0 = r1.zzghx     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzcdf r0 = r1.zzghx     // Catch:{ all -> 0x0048 }
            r0.zzc(r1)     // Catch:{ all -> 0x0048 }
        L_0x001f:
            r1.zzapv()     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzcdf r2 = (com.google.android.gms.internal.ads.zzcdf) r2     // Catch:{ all -> 0x0048 }
            r1.zzghx = r2     // Catch:{ all -> 0x0048 }
            r2.zza((com.google.android.gms.internal.ads.zzcfl) r1)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzcdf r2 = r1.zzghx     // Catch:{ all -> 0x0048 }
            android.widget.FrameLayout r0 = r1.zzgic     // Catch:{ all -> 0x0048 }
            r2.zzaa(r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzcdf r2 = r1.zzghx     // Catch:{ all -> 0x0048 }
            android.widget.FrameLayout r0 = r1.zzboi     // Catch:{ all -> 0x0048 }
            r2.zzab(r0)     // Catch:{ all -> 0x0048 }
            boolean r2 = r1.zzgig     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzcdf r2 = r1.zzghx     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzcdm r2 = r2.zzaol()     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzaer r0 = r1.zzclt     // Catch:{ all -> 0x0048 }
            r2.zza(r0)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r1)
            return
        L_0x0048:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcel.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    private final synchronized void zzapv() {
        this.zzgid.execute(new zzcek(this));
    }

    public final synchronized void destroy() {
        if (!this.zzevf) {
            if (this.zzghx != null) {
                this.zzghx.zzc(this);
                this.zzghx = null;
            }
            this.zzdva.clear();
            this.zzgic.removeAllViews();
            this.zzboi.removeAllViews();
            this.zzdva = null;
            this.zzgic = null;
            this.zzboi = null;
            this.zzgie = null;
            this.zzghy = null;
            this.zzevf = true;
        }
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.zzghx != null) {
            this.zzghx.cancelUnconfirmedClick();
            this.zzghx.zza(view, this.zzgic, zzapq(), zzapr(), false);
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzghx != null) {
            this.zzghx.zza(view, motionEvent, (View) this.zzgic);
        }
        return false;
    }

    public final synchronized JSONObject zztq() {
        if (this.zzghx == null) {
            return null;
        }
        return this.zzghx.zza((View) this.zzgic, zzapq(), zzapr());
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzghx != null) {
            this.zzghx.zzb(this.zzgic, zzapq(), zzapr(), zzcdf.zzz(this.zzgic));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzghx != null) {
            this.zzghx.zzb(this.zzgic, zzapq(), zzapr(), zzcdf.zzz(this.zzgic));
        }
    }

    public final synchronized Map<String, WeakReference<View>> zzapq() {
        return this.zzdva;
    }

    public final synchronized Map<String, WeakReference<View>> zzapr() {
        return this.zzdva;
    }

    public final synchronized Map<String, WeakReference<View>> zzaps() {
        return null;
    }

    public final synchronized String zzapt() {
        return this.zzgia;
    }

    public final FrameLayout zzapo() {
        return this.zzboi;
    }

    public final zzqs zzapp() {
        return this.zzghy;
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        this.zzghx.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        if (!this.zzevf) {
            this.zzgif = iObjectWrapper;
        }
    }

    public final IObjectWrapper zzapu() {
        return this.zzgif;
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzgic, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzaer r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzevf     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.zzgig = r0     // Catch:{ all -> 0x001b }
            r1.zzclt = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzcdf r0 = r1.zzghx     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzcdf r0 = r1.zzghx     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzcdm r0 = r0.zzaol()     // Catch:{ all -> 0x001b }
            r0.zza(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcel.zza(com.google.android.gms.internal.ads.zzaer):void");
    }

    public final /* synthetic */ View zzakl() {
        return this.zzgic;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapw() {
        if (this.zzgie == null) {
            View view = new View(this.zzgic.getContext());
            this.zzgie = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzgic != this.zzgie.getParent()) {
            this.zzgic.addView(this.zzgie);
        }
    }
}
