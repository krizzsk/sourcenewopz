package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzqs implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbrn = ((Long) zzww.zzra().zzd(zzabq.zzcrg)).longValue();
    private final Context zzaai;
    private final PowerManager zzaaj;
    private final KeyguardManager zzaak;
    private WeakReference<ViewTreeObserver> zzaam;
    private int zzaaq = -1;
    private final WindowManager zzbro;
    private BroadcastReceiver zzbrp;
    private WeakReference<View> zzbrq;
    private zzra zzbrr;
    private zzbp zzbrs = new zzbp(zzbrn);
    private boolean zzbrt = false;
    private final HashSet<zzqw> zzbru = new HashSet<>();
    private final Rect zzbrv;
    private final DisplayMetrics zzxe;
    private Application zzyi;

    public zzqs(Context context, View view) {
        this.zzaai = context.getApplicationContext();
        this.zzbro = (WindowManager) context.getSystemService("window");
        this.zzaaj = (PowerManager) this.zzaai.getSystemService("power");
        this.zzaak = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzaai;
        if (context2 instanceof Application) {
            this.zzyi = (Application) context2;
            this.zzbrr = new zzra((Application) context2, this);
        }
        this.zzxe = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzbrv = rect;
        rect.right = this.zzbro.getDefaultDisplay().getWidth();
        this.zzbrv.bottom = this.zzbro.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbrq;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbrq = new WeakReference<>(view);
        if (view != null) {
            if (zzr.zzkx().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzqw zzqw) {
        this.zzbru.add(zzqw);
        zzbu(3);
    }

    public final void zzb(zzqw zzqw) {
        this.zzbru.remove(zzqw);
    }

    private final void zzcu() {
        zzj.zzegq.post(new zzqv(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzaaq = -1;
        zzf(view);
        zzbu(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzaaq = -1;
        zzbu(3);
        zzcu();
        zzg(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbrq != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzbrq.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzaaq = i;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzcu();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbu(3);
        zzcu();
    }

    public final void onActivityStopped(Activity activity) {
        zzbu(3);
        zzcu();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbu(3);
        zzcu();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbu(3);
        zzcu();
    }

    public final void onGlobalLayout() {
        zzbu(2);
        zzcu();
    }

    public final void onScrollChanged() {
        zzbu(1);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbu(int r32) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.util.HashSet<com.google.android.gms.internal.ads.zzqw> r0 = r1.zzbru
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.zzbrq
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r2 != r5) goto L_0x001f
            r6 = 1
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            if (r3 != 0) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r0 = 2
            int[] r12 = new int[r0]
            int[] r0 = new int[r0]
            if (r3 == 0) goto L_0x0077
            boolean r13 = r3.getGlobalVisibleRect(r9)
            boolean r14 = r3.getLocalVisibleRect(r10)
            r3.getHitRect(r11)
            r3.getLocationOnScreen(r12)     // Catch:{ Exception -> 0x0052 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r0 = move-exception
            java.lang.String r15 = "Failure getting view location."
            com.google.android.gms.ads.internal.util.zzd.zzc(r15, r0)
        L_0x0058:
            r0 = r12[r4]
            r8.left = r0
            r0 = r12[r5]
            r8.top = r0
            int r0 = r8.left
            int r12 = r3.getWidth()
            int r0 = r0 + r12
            r8.right = r0
            int r0 = r8.top
            int r12 = r3.getHeight()
            int r0 = r0 + r12
            r8.bottom = r0
            r24 = r13
            r26 = r14
            goto L_0x007b
        L_0x0077:
            r24 = 0
            r26 = 0
        L_0x007b:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcrj
            com.google.android.gms.internal.ads.zzabm r12 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r12.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0094
            if (r3 == 0) goto L_0x0094
            java.util.List r0 = r1.zzi(r3)
            goto L_0x0098
        L_0x0094:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0098:
            r30 = r0
            r0 = 8
            if (r3 == 0) goto L_0x00a3
            int r12 = r3.getWindowVisibility()
            goto L_0x00a5
        L_0x00a3:
            r12 = 8
        L_0x00a5:
            int r13 = r1.zzaaq
            r14 = -1
            if (r13 == r14) goto L_0x00ab
            r12 = r13
        L_0x00ab:
            if (r7 != 0) goto L_0x00c2
            com.google.android.gms.ads.internal.zzr.zzkv()
            android.os.PowerManager r7 = r1.zzaaj
            android.app.KeyguardManager r13 = r1.zzaak
            boolean r7 = com.google.android.gms.ads.internal.util.zzj.zza((android.view.View) r3, (android.os.PowerManager) r7, (android.app.KeyguardManager) r13)
            if (r7 == 0) goto L_0x00c2
            if (r24 == 0) goto L_0x00c2
            if (r26 == 0) goto L_0x00c2
            if (r12 != 0) goto L_0x00c2
            r7 = 1
            goto L_0x00c3
        L_0x00c2:
            r7 = 0
        L_0x00c3:
            if (r6 == 0) goto L_0x00d2
            com.google.android.gms.ads.internal.util.zzbp r6 = r1.zzbrs
            boolean r6 = r6.tryAcquire()
            if (r6 != 0) goto L_0x00d2
            boolean r6 = r1.zzbrt
            if (r7 != r6) goto L_0x00d2
            return
        L_0x00d2:
            if (r7 != 0) goto L_0x00db
            boolean r6 = r1.zzbrt
            if (r6 != 0) goto L_0x00db
            if (r2 != r5) goto L_0x00db
            return
        L_0x00db:
            com.google.android.gms.internal.ads.zzqx r2 = new com.google.android.gms.internal.ads.zzqx
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzr.zzlc()
            long r16 = r6.elapsedRealtime()
            android.os.PowerManager r6 = r1.zzaaj
            boolean r18 = r6.isScreenOn()
            if (r3 == 0) goto L_0x00fa
            com.google.android.gms.ads.internal.util.zzr r6 = com.google.android.gms.ads.internal.zzr.zzkx()
            boolean r6 = r6.isAttachedToWindow(r3)
            if (r6 == 0) goto L_0x00fa
            r19 = 1
            goto L_0x00fc
        L_0x00fa:
            r19 = 0
        L_0x00fc:
            if (r3 == 0) goto L_0x0105
            int r0 = r3.getWindowVisibility()
            r20 = r0
            goto L_0x0107
        L_0x0105:
            r20 = 8
        L_0x0107:
            android.graphics.Rect r0 = r1.zzbrv
            android.graphics.Rect r21 = r1.zza((android.graphics.Rect) r0)
            android.graphics.Rect r22 = r1.zza((android.graphics.Rect) r8)
            android.graphics.Rect r23 = r1.zza((android.graphics.Rect) r9)
            android.graphics.Rect r25 = r1.zza((android.graphics.Rect) r10)
            android.graphics.Rect r27 = r1.zza((android.graphics.Rect) r11)
            android.util.DisplayMetrics r0 = r1.zzxe
            float r0 = r0.density
            r15 = r2
            r28 = r0
            r29 = r7
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            java.util.HashSet<com.google.android.gms.internal.ads.zzqw> r0 = r1.zzbru
            java.util.Iterator r0 = r0.iterator()
        L_0x012f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x013f
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.ads.zzqw r3 = (com.google.android.gms.internal.ads.zzqw) r3
            r3.zza(r2)
            goto L_0x012f
        L_0x013f:
            r1.zzbrt = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzbu(int):void");
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbv(rect.left), zzbv(rect.top), zzbv(rect.right), zzbv(rect.bottom));
    }

    private final int zzbv(int i) {
        return (int) (((float) i) / this.zzxe.density);
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzr.zzkz().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaam = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbrp == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbrp = new zzqu(this);
            zzr.zzlq().zza(this.zzaai, this.zzbrp, intentFilter);
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbrr);
            } catch (Exception e) {
                zzd.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzaam != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzaam.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaam = null;
            }
        } catch (Exception e) {
            zzd.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzd.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbrp != null) {
            try {
                zzr.zzlq().zza(this.zzaai, this.zzbrp);
            } catch (IllegalStateException e3) {
                zzd.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzr.zzkz().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbrp = null;
        }
        Application application = this.zzyi;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbrr);
            } catch (Exception e5) {
                zzd.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void zzen(long j) {
        this.zzbrs.zzfc(j);
    }

    public final void zzlx() {
        this.zzbrs.zzfc(zzbrn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzly() {
        zzbu(3);
    }
}
