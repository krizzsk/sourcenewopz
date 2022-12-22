package com.didi.global.map.animation.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.util.LogUtil;
import java.util.List;

public class FrameAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22708a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f22709b;

    /* renamed from: c */
    private List<Circle> f22710c;

    /* renamed from: d */
    private ValueAnimator f22711d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int[] f22712e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f22713f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f22714g;

    /* renamed from: h */
    private boolean f22715h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnFrameAnimEndCallback f22716i;

    /* renamed from: j */
    private RippleCircle f22717j;

    /* renamed from: k */
    private RippleAnimParam f22718k;

    /* renamed from: l */
    private int f22719l = 100;

    public FrameAnim(Context context, Marker marker, List<Circle> list, RippleAnimParam rippleAnimParam) {
        this.f22708a = context;
        this.f22709b = marker;
        this.f22718k = rippleAnimParam;
        this.f22710c = list;
    }

    public FrameAnim(Context context, Marker marker) {
        this.f22708a = context;
        this.f22709b = marker;
    }

    public void setFrames(int[] iArr) {
        this.f22712e = iArr;
        this.f22713f = iArr != null ? iArr.length : 0;
    }

    public void setFrameIntervalTimeMillis(int i) {
        this.f22719l = i;
    }

    public void setInfinite(boolean z) {
        this.f22715h = z;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f22711d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doFrameAnim(boolean z) {
        if (this.f22712e == null || this.f22713f <= 0) {
            LogUtil.m16428e("FrameAnim doFrameAnim() mFrames == null || mFramesCount <= 0");
        } else if (z || this.f22711d != null) {
            if (this.f22711d == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f22713f});
                this.f22711d = ofInt;
                ofInt.setInterpolator(new LinearInterpolator());
                if (this.f22715h) {
                    this.f22711d.setRepeatMode(1);
                    this.f22711d.setRepeatCount(-1);
                }
                this.f22711d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num = (Integer) valueAnimator.getAnimatedValue();
                        if (num != null && FrameAnim.this.f22709b != null && FrameAnim.this.f22712e != null && num.intValue() != FrameAnim.this.f22714g && num.intValue() < FrameAnim.this.f22713f) {
                            int unused = FrameAnim.this.f22714g = num.intValue();
                            FrameAnim.this.f22709b.setIcon(FrameAnim.this.f22708a, BitmapDescriptorFactory.fromResource(FrameAnim.this.f22708a, FrameAnim.this.f22712e[num.intValue()]));
                        }
                    }
                });
                this.f22711d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (FrameAnim.this.f22716i != null) {
                            FrameAnim.this.f22716i.onFrameAnimEnd();
                        }
                    }
                });
            }
            if (z) {
                if (!this.f22711d.isRunning()) {
                    this.f22711d.setDuration((long) (this.f22719l * this.f22713f));
                    this.f22711d.start();
                }
            } else if (this.f22711d.isRunning()) {
                this.f22711d.end();
            }
        } else {
            LogUtil.m16428e("FrameAnim doFrameAnim() anim = false && mAnimator = null)");
            OnFrameAnimEndCallback onFrameAnimEndCallback = this.f22716i;
            if (onFrameAnimEndCallback != null) {
                onFrameAnimEndCallback.onFrameAnimEnd();
            }
        }
    }

    public void doRippleAnim(boolean z) {
        if (z) {
            if (this.f22717j == null) {
                this.f22717j = new RippleCircle(this.f22710c, this.f22709b, this.f22718k);
            }
            this.f22717j.show();
            return;
        }
        RippleCircle rippleCircle = this.f22717j;
        if (rippleCircle != null) {
            rippleCircle.hide();
        }
    }

    public void setOnFrameAnimEndCallback(OnFrameAnimEndCallback onFrameAnimEndCallback) {
        this.f22716i = onFrameAnimEndCallback;
    }

    public void destory() {
        if (this.f22711d != null) {
            doFrameAnim(false);
            doRippleAnim(false);
            this.f22711d.removeAllUpdateListeners();
            this.f22711d.removeAllListeners();
            this.f22711d = null;
        }
        this.f22716i = null;
        this.f22712e = null;
        this.f22713f = 0;
        this.f22714g = 0;
        this.f22715h = true;
    }
}
