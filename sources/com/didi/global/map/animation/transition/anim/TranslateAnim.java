package com.didi.global.map.animation.transition.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.SodaAnimEngine;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.callback.OnTranslateAnimEndCallback;
import com.didi.global.map.animation.transition.util.AngleManager;
import com.didi.global.map.animation.transition.util.AngleUtil;
import com.didi.global.map.animation.transition.util.LogUtil;
import com.didi.global.map.animation.transition.util.SphericalUtil;
import java.util.LinkedList;
import java.util.Queue;

public class TranslateAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22804a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f22805b;

    /* renamed from: c */
    private FrameAnim f22806c;

    /* renamed from: d */
    private ValueAnimator f22807d;

    /* renamed from: e */
    private long f22808e = 3000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Queue<LatLng> f22809f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f22810g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LatLng f22811h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LatLng f22812i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f22813j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public OnTranslateAnimEndCallback f22814k;

    public TranslateAnim(Context context, Marker marker) {
        this.f22804a = context;
        this.f22805b = marker;
        this.f22810g = marker.getPosition();
        this.f22811h = marker.getPosition();
        this.f22809f = new LinkedList();
        m16407a();
    }

    /* renamed from: a */
    private void m16407a() {
        FrameAnim frameAnim = new FrameAnim(this.f22804a, this.f22805b);
        this.f22806c = frameAnim;
        frameAnim.setInfinite(false);
        this.f22806c.setOnFrameAnimEndCallback(new OnFrameAnimEndCallback() {
            public void onFrameAnimEnd() {
                AngleManager.getInstant().setFromIndex(TranslateAnim.this.f22813j);
                TranslateAnim.this.f22805b.setIcon(TranslateAnim.this.f22804a, BitmapDescriptorFactory.fromResource(TranslateAnim.this.f22804a, AngleManager.getInstant().getRunningFrame(TranslateAnim.this.f22804a)));
                TranslateAnim translateAnim = TranslateAnim.this;
                LatLng unused = translateAnim.f22811h = translateAnim.f22805b.getPosition();
                TranslateAnim.this.m16410b();
            }
        });
    }

    public void setTranslateIntervalTime(long j) {
        this.f22808e = j;
        ValueAnimator valueAnimator = this.f22807d;
        if (valueAnimator != null) {
            valueAnimator.setDuration(j);
        }
    }

    public void setOnTranslateAnimEndCallback(OnTranslateAnimEndCallback onTranslateAnimEndCallback) {
        this.f22814k = onTranslateAnimEndCallback;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f22807d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doTranslateAnim(LatLng latLng) {
        Marker marker = this.f22805b;
        if (marker == null || marker.getPosition() == null || latLng == null) {
            LogUtil.m16419e("doTranslateAnim() mMarker == null || mMarker.getPosition() == null || toLocation == null");
            OnTranslateAnimEndCallback onTranslateAnimEndCallback = this.f22814k;
            if (onTranslateAnimEndCallback != null) {
                onTranslateAnimEndCallback.onTranslateAnimEnd();
                return;
            }
            return;
        }
        if (this.f22809f == null) {
            this.f22809f = new LinkedList();
        }
        LatLng position = this.f22805b.getPosition();
        this.f22810g = position;
        double computeDistanceBetween = SphericalUtil.computeDistanceBetween(position, latLng);
        if (computeDistanceBetween > SodaAnimEngine.DistanceThreshold) {
            LogUtil.m16421w("doTranslateAnim() distance = " + computeDistanceBetween);
            this.f22805b.setPosition(latLng);
            this.f22809f.clear();
            OnTranslateAnimEndCallback onTranslateAnimEndCallback2 = this.f22814k;
            if (onTranslateAnimEndCallback2 != null) {
                onTranslateAnimEndCallback2.onTranslateAnimEnd();
                return;
            }
            return;
        }
        this.f22809f.offer(latLng);
        int indexByLatLng = AngleUtil.getIndexByLatLng(this.f22810g, latLng);
        this.f22813j = indexByLatLng;
        if (indexByLatLng == AngleManager.getInstant().getToIndex()) {
            m16410b();
            return;
        }
        AngleManager.getInstant().setToIndex(this.f22813j);
        this.f22806c.setFrames(AngleManager.getInstant().getRotateFrames(this.f22804a));
        this.f22806c.doFrameAnim(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m16410b() {
        LatLng poll = this.f22809f.poll();
        this.f22812i = poll;
        if (this.f22811h == null || poll == null) {
            LogUtil.m16419e("doTranslateAnimInternal() mFromLocation == null || mToLocation == null");
            OnTranslateAnimEndCallback onTranslateAnimEndCallback = this.f22814k;
            if (onTranslateAnimEndCallback != null) {
                onTranslateAnimEndCallback.onTranslateAnimEnd();
                return;
            }
            return;
        }
        if (this.f22807d == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f22807d = ofFloat;
            ofFloat.setDuration(this.f22808e);
            this.f22807d.setInterpolator(new LinearInterpolator());
            this.f22807d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float f = (Float) valueAnimator.getAnimatedValue();
                    if (TranslateAnim.this.f22805b != null && f != null && f.floatValue() >= 0.0f && f.floatValue() <= 1.0f) {
                        if (((double) f.floatValue()) <= 1.0E-6d) {
                            TranslateAnim translateAnim = TranslateAnim.this;
                            LatLng unused = translateAnim.f22811h = translateAnim.f22805b.getPosition();
                        }
                        if (TranslateAnim.this.f22811h != null && TranslateAnim.this.f22812i != null) {
                            TranslateAnim translateAnim2 = TranslateAnim.this;
                            LatLng unused2 = translateAnim2.f22810g = SphericalUtil.interpolate(translateAnim2.f22811h, TranslateAnim.this.f22812i, (double) f.floatValue());
                            TranslateAnim.this.f22805b.setPosition(TranslateAnim.this.f22810g);
                        }
                    }
                }
            });
            this.f22807d.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    TranslateAnim translateAnim = TranslateAnim.this;
                    LatLng unused = translateAnim.f22810g = translateAnim.f22805b.getPosition();
                    TranslateAnim translateAnim2 = TranslateAnim.this;
                    LatLng unused2 = translateAnim2.f22811h = translateAnim2.f22805b.getPosition();
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (TranslateAnim.this.f22809f == null || TranslateAnim.this.f22809f.size() <= 0) {
                        TranslateAnim translateAnim = TranslateAnim.this;
                        LatLng unused = translateAnim.f22810g = translateAnim.f22805b.getPosition();
                        TranslateAnim translateAnim2 = TranslateAnim.this;
                        LatLng unused2 = translateAnim2.f22811h = translateAnim2.f22805b.getPosition();
                        AngleManager.getInstant().setFromIndex(TranslateAnim.this.f22813j);
                        AngleManager.getInstant().setToIndex(TranslateAnim.this.f22813j);
                        if (TranslateAnim.this.f22814k != null) {
                            TranslateAnim.this.f22814k.onTranslateAnimEnd();
                            return;
                        }
                        return;
                    }
                    LogUtil.m16421w("onAnimationEnd mQueue.size(): " + TranslateAnim.this.f22809f.size());
                    TranslateAnim translateAnim3 = TranslateAnim.this;
                    translateAnim3.doTranslateAnim((LatLng) translateAnim3.f22809f.poll());
                }
            });
        }
        this.f22807d.start();
    }

    public void destory() {
        this.f22810g = null;
        this.f22811h = null;
        this.f22812i = null;
        this.f22814k = null;
        Queue<LatLng> queue = this.f22809f;
        if (queue != null) {
            queue.clear();
        }
        FrameAnim frameAnim = this.f22806c;
        if (frameAnim != null) {
            frameAnim.destory();
            this.f22806c = null;
        }
        ValueAnimator valueAnimator = this.f22807d;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.f22807d.end();
            }
            this.f22807d.removeAllUpdateListeners();
            this.f22807d.removeAllListeners();
            this.f22807d = null;
        }
    }
}
