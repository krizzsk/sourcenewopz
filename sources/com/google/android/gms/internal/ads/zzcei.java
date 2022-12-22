package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcei extends zzafc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcfl {
    private final WeakReference<View> zzght;
    private final Map<String, WeakReference<View>> zzghu = new HashMap();
    private final Map<String, WeakReference<View>> zzghv = new HashMap();
    private final Map<String, WeakReference<View>> zzghw = new HashMap();
    private zzcdf zzghx;
    private zzqs zzghy;

    public zzcei(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzr.zzls();
        zzbbm.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzr.zzls();
        zzbbm.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzght = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzghu.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzghw.putAll(this.zzghu);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzghv.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzghw.putAll(this.zzghv);
        this.zzghy = new zzqs(view.getContext(), view);
    }

    public final FrameLayout zzapo() {
        return null;
    }

    public final synchronized void unregisterNativeAd() {
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
            this.zzghx = null;
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcdf)) {
            zzd.zzez("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
        }
        if (((zzcdf) unwrap).zzaoj()) {
            zzcdf zzcdf = (zzcdf) unwrap;
            this.zzghx = zzcdf;
            zzcdf.zza((zzcfl) this);
            this.zzghx.zzaa(zzakl());
            return;
        }
        zzd.zzex("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    public final View zzakl() {
        return (View) this.zzght.get();
    }

    public final zzqs zzapp() {
        return this.zzghy;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzghw     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzghu     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzghv     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzghw     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzghu     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcei.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final synchronized Map<String, WeakReference<View>> zzapq() {
        return this.zzghw;
    }

    public final synchronized Map<String, WeakReference<View>> zzapr() {
        return this.zzghu;
    }

    public final synchronized Map<String, WeakReference<View>> zzaps() {
        return this.zzghv;
    }

    public final synchronized View zzgd(String str) {
        WeakReference weakReference = this.zzghw.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized String zzapt() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    public final synchronized IObjectWrapper zzapu() {
        return null;
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzghx != null) {
            this.zzghx.zza(view, motionEvent, zzakl());
        }
        return false;
    }

    public final synchronized void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.zzghx != null) {
            this.zzghx.zza(view, zzakl(), zzapq(), zzapr(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzghx != null) {
            this.zzghx.zzb(zzakl(), zzapq(), zzapr(), zzcdf.zzz(zzakl()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzghx != null) {
            this.zzghx.zzb(zzakl(), zzapq(), zzapr(), zzcdf.zzz(zzakl()));
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        if (this.zzghx != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzd.zzez("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzghx.setClickConfirmingView((View) unwrap);
        }
    }

    public final synchronized JSONObject zztq() {
        return null;
    }
}
