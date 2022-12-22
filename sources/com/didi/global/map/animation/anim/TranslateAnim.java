package com.didi.global.map.animation.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.SodaAnimEngine;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.util.AngleManager;
import com.didi.global.map.animation.util.AngleUtil;
import com.didi.global.map.animation.util.LogUtil;
import com.didi.global.map.animation.util.SphericalUtil;
import java.util.LinkedList;
import java.util.Queue;

public class TranslateAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22737a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f22738b;

    /* renamed from: c */
    private FrameAnim f22739c;

    /* renamed from: d */
    private ValueAnimator f22740d;

    /* renamed from: e */
    private long f22741e = 3000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<LatLng> f22742f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f22743g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LatLng f22744h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LatLng f22745i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f22746j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnTranslateAnimEndCallback f22747k;

    public TranslateAnim(Context context, Marker marker) {
        this.f22737a = context;
        this.f22738b = marker;
        this.f22743g = marker.getPosition();
        this.f22744h = marker.getPosition();
        this.f22742f = new LinkedList();
        m16365a();
    }

    /* renamed from: a */
    private void m16365a() {
        FrameAnim frameAnim = new FrameAnim(this.f22737a, this.f22738b);
        this.f22739c = frameAnim;
        frameAnim.setInfinite(false);
        this.f22739c.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
            public void onFrameAnimEnd() {
                AngleManager.getInstant().setFromIndex(TranslateAnim.this.f22746j);
                TranslateAnim.this.f22738b.setIcon(TranslateAnim.this.f22737a, BitmapDescriptorFactory.fromResource(TranslateAnim.this.f22737a, AngleManager.getInstant().getRunningFrame(TranslateAnim.this.f22737a)));
                TranslateAnim translateAnim = TranslateAnim.this;
                LatLng unused = translateAnim.f22744h = translateAnim.f22738b.getPosition();
                TranslateAnim.this.m16368b();
            }
        });
    }

    public void setTranslateIntervalTime(long j) {
        this.f22741e = j;
        ValueAnimator valueAnimator = this.f22740d;
        if (valueAnimator != null) {
            valueAnimator.setDuration(j);
        }
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f22747k = onTranslateAnimEndCallback;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f22740d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doTranslateAnim(LatLng latLng) {
        Marker marker = this.f22738b;
        if (marker == null || marker.getPosition() == null || latLng == null) {
            LogUtil.m16428e("doTranslateAnim() mMarker == null || mMarker.getPosition() == null || toLocation == null");
            return;
        }
        if (this.f22742f == null) {
            this.f22742f = new LinkedList();
        }
        LatLng position = this.f22738b.getPosition();
        this.f22743g = position;
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(position, latLng);
        if (computeDistanceBetween > SodaAnimEngine.DistanceThreshold) {
            LogUtil.m16430w("doTranslateAnim() distance = " + computeDistanceBetween);
            this.f22738b.setPosition(latLng);
            this.f22742f.clear();
            return;
        }
        this.f22742f.offer(latLng);
        int indexByLatLng = AngleUtil.getIndexByLatLng(this.f22743g, latLng);
        this.f22746j = indexByLatLng;
        if (indexByLatLng == AngleManager.getInstant().getToIndex()) {
            m16368b();
            return;
        }
        AngleManager.getInstant().setToIndex(this.f22746j);
        this.f22739c.setFrames(AngleManager.getInstant().getRotateFrames(this.f22737a));
        this.f22739c.doFrameAnim(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16368b() {
        LatLng poll = this.f22742f.poll();
        this.f22745i = poll;
        if (this.f22744h == null || poll == null) {
            LogUtil.m16428e("doTranslateAnimInternal() mFromLocation == null || mToLocation == null");
            return;
        }
        if (this.f22740d == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f22740d = ofFloat;
            ofFloat.setDuration(this.f22741e);
            this.f22740d.setInterpolator(new LinearInterpolator());
            this.f22740d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float f = (Float) valueAnimator.getAnimatedValue();
                    if (TranslateAnim.this.f22738b != null && f != null && f.floatValue() >= 0.0f && f.floatValue() <= 1.0f) {
                        if (((double) f.floatValue()) <= 1.0E-6d) {
                            TranslateAnim translateAnim = TranslateAnim.this;
                            LatLng unused = translateAnim.f22744h = translateAnim.f22738b.getPosition();
                        }
                        if (TranslateAnim.this.f22744h != null && TranslateAnim.this.f22745i != null) {
                            TranslateAnim translateAnim2 = TranslateAnim.this;
                            LatLng unused2 = translateAnim2.f22743g = SphericalUtil.interpolate(translateAnim2.f22744h, TranslateAnim.this.f22745i, (double) f.floatValue());
                            TranslateAnim.this.f22738b.setPosition(TranslateAnim.this.f22743g);
                        }
                    }
                }
            });
            this.f22740d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TranslateAnim translateAnim = TranslateAnim.this;
                    LatLng unused = translateAnim.f22743g = translateAnim.f22738b.getPosition();
                    TranslateAnim translateAnim2 = TranslateAnim.this;
                    LatLng unused2 = translateAnim2.f22744h = translateAnim2.f22738b.getPosition();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (TranslateAnim.this.f22742f == null || TranslateAnim.this.f22742f.size() <= 0) {
                        TranslateAnim translateAnim = TranslateAnim.this;
                        LatLng unused = translateAnim.f22743g = translateAnim.f22738b.getPosition();
                        TranslateAnim translateAnim2 = TranslateAnim.this;
                        LatLng unused2 = translateAnim2.f22744h = translateAnim2.f22738b.getPosition();
                        AngleManager.getInstant().setFromIndex(TranslateAnim.this.f22746j);
                        AngleManager.getInstant().setToIndex(TranslateAnim.this.f22746j);
                        if (TranslateAnim.this.f22747k != null) {
                            TranslateAnim.this.f22747k.onTranslateAnimEnd();
                            return;
                        }
                        return;
                    }
                    LogUtil.m16430w("onAnimationEnd mQueue.size(): " + TranslateAnim.this.f22742f.size());
                    TranslateAnim translateAnim3 = TranslateAnim.this;
                    translateAnim3.doTranslateAnim((LatLng) translateAnim3.f22742f.poll());
                }
            });
        }
        this.f22740d.start();
    }

    public void destory() {
        this.f22743g = null;
        this.f22744h = null;
        this.f22745i = null;
        this.f22747k = null;
        Queue<LatLng> queue = this.f22742f;
        if (queue != null) {
            queue.clear();
        }
        FrameAnim frameAnim = this.f22739c;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22739c = null;
        }
        ValueAnimator valueAnimator = this.f22740d;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f22740d.end();
            }
            this.f22740d.removeAllUpdateListeners();
            this.f22740d.removeAllListeners();
            this.f22740d = null;
        }
    }
}
