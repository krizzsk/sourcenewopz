package com.didichuxing.sdk.alphaface.core.liveness;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.didichuxing.sdk.alphaface.core.AlphaFaceNativeProxy;
import com.didichuxing.sdk.alphaface.utils.AFLog;
import com.didichuxing.sdk.alphaface.utils.SkipFrame;
import java.util.concurrent.atomic.AtomicBoolean;

public class LivenessManager implements LifecycleObserver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AlphaFaceNativeProxy f48703a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final HandlerThread f48704b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f48705c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AtomicBoolean f48706d;

    /* renamed from: e */
    private final SkipFrame f48707e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final C16335a f48708f;

    /* renamed from: g */
    private final LivenessConfig f48709g;

    /* renamed from: h */
    private final C16337c f48710h;

    public LivenessManager(LivenessConfig livenessConfig) {
        this.f48706d = new AtomicBoolean(false);
        AlphaFaceNativeProxy afNative = AlphaFaceFacade.getInstance().getAfNative();
        this.f48703a = afNative;
        afNative.setLivenessThres(livenessConfig.getFrame_time_interval(), livenessConfig.getYaw_thresh(), livenessConfig.getPitch_thresh(), livenessConfig.getOcc_thresh(), livenessConfig.getIllum_thresh(), livenessConfig.getBlur_thresh());
        this.f48709g = livenessConfig;
        this.f48710h = new C16337c(this);
        HandlerThread handlerThread = new HandlerThread("LivenessManager");
        this.f48704b = handlerThread;
        handlerThread.start();
        this.f48705c = new Handler(this.f48704b.getLooper());
        this.f48707e = new SkipFrame(livenessConfig.getSkipTime());
        C16338d dVar = new C16338d(this);
        this.f48708f = dVar;
        dVar.mo120634a(new C16336b(this));
    }

    public LivenessManager(LivenessConfig livenessConfig, Lifecycle lifecycle) {
        this(livenessConfig);
        if (lifecycle != null) {
            lifecycle.addObserver(this);
        }
    }

    public void detect(byte[] bArr, int i, int i2, int i3, int i4, float f, float f2, float f3, boolean z) {
        if (!this.f48706d.get() && !this.f48707e.skip()) {
            final int i5 = i;
            final int i6 = i2;
            final byte[] bArr2 = bArr;
            final int i7 = i3;
            final boolean z2 = z;
            final int i8 = i4;
            final float f4 = f;
            final float f5 = f2;
            final float f6 = f3;
            this.f48705c.post(new Runnable() {
                public void run() {
                    int i;
                    int i2;
                    if (!LivenessManager.this.f48706d.get()) {
                        byte[] bArr = new byte[(i5 * i6 * 4)];
                        long currentTimeMillis = System.currentTimeMillis();
                        LivenessManager.this.f48703a.yuvToRGBA(bArr2, i5, i6, bArr, 360 - i7, false);
                        if (z2) {
                            i2 = i5;
                            i = i6;
                        } else {
                            i2 = i6;
                            i = i5;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        AFLog.m34998v("yuvToRGBA NV21 to Bitmap consume: " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                        LivenessManager.this.f48708f.mo120635a(bArr, i2, i, i8, f4, f5, f6);
                        return;
                    }
                    LivenessManager.this.f48705c.removeCallbacksAndMessages((Object) null);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AlphaFaceNativeProxy mo120616a() {
        return this.f48703a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public LivenessConfig mo120617b() {
        return this.f48709g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C16337c mo120618c() {
        return this.f48710h;
    }

    public void reset() {
        this.f48708f.mo120639d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void restart() {
        this.f48710h.onRestart();
        this.f48708f.mo120639d();
        this.f48706d.set(false);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void exit() {
        this.f48706d.set(true);
        this.f48705c.removeCallbacksAndMessages((Object) null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void release() {
        this.f48706d.set(true);
        Handler handler = this.f48705c;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f48705c.post(new Runnable() {
                public void run() {
                    LivenessManager.this.f48705c.removeCallbacksAndMessages((Object) null);
                    AlphaFaceFacade.getInstance().unInitModels();
                    if (LivenessManager.this.f48704b != null) {
                        LivenessManager.this.f48704b.quit();
                    }
                }
            });
        }
    }
}
