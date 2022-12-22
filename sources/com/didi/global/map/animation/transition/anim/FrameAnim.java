package com.didi.global.map.animation.transition.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.Marker;
import com.didi.global.map.animation.transition.callback.OnFrameAnimEndCallback;
import com.didi.global.map.animation.transition.util.LogUtil;
import java.util.List;

public class FrameAnim {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f22775a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Marker f22776b;

    /* renamed from: c */
    private List<Circle> f22777c;

    /* renamed from: d */
    private ValueAnimator f22778d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int[] f22779e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f22780f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f22781g;

    /* renamed from: h */
    private boolean f22782h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnFrameAnimEndCallback f22783i;

    /* renamed from: j */
    private RippleCircle f22784j;

    /* renamed from: k */
    private RippleAnimParam f22785k;

    /* renamed from: l */
    private int f22786l = 100;

    public FrameAnim(Context context, Marker marker, List<Circle> list, RippleAnimParam rippleAnimParam) {
        this.f22775a = context;
        this.f22776b = marker;
        this.f22785k = rippleAnimParam;
        this.f22777c = list;
    }

    public FrameAnim(Context context, Marker marker) {
        this.f22775a = context;
        this.f22776b = marker;
    }

    public void setFrames(int[] iArr) {
        this.f22779e = iArr;
        this.f22780f = iArr != null ? iArr.length : 0;
    }

    public void setFrameIntervalTimeMillis(int i) {
        this.f22786l = i;
    }

    public void setInfinite(boolean z) {
        this.f22782h = z;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator = this.f22778d;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void doFrameAnim(boolean z) {
        if (this.f22779e == null || this.f22780f <= 0) {
            LogUtil.m16419e("FrameAnim doFrameAnim() mFrames == null || mFramesCount <= 0");
        } else if (z || this.f22778d != null) {
            if (this.f22778d == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.f22780f});
                this.f22778d = ofInt;
                ofInt.setInterpolator(new LinearInterpolator());
                if (this.f22782h) {
                    this.f22778d.setRepeatMode(1);
                    this.f22778d.setRepeatCount(-1);
                }
                this.f22778d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num = (Integer) valueAnimator.getAnimatedValue();
                        if (num != null && FrameAnim.this.f22776b != null && FrameAnim.this.f22779e != null && num.intValue() != FrameAnim.this.f22781g && num.intValue() < FrameAnim.this.f22780f) {
                            int unused = FrameAnim.this.f22781g = num.intValue();
                            FrameAnim.this.f22776b.setIcon(FrameAnim.this.f22775a, BitmapDescriptorFactory.fromResource(FrameAnim.this.f22775a, FrameAnim.this.f22779e[num.intValue()]));
                        }
                    }
                });
                this.f22778d.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (FrameAnim.this.f22783i != null) {
                            FrameAnim.this.f22783i.onFrameAnimEnd();
                        }
                    }
                });
            }
            if (z) {
                if (!this.f22778d.isRunning()) {
                    this.f22778d.setDuration((long) (this.f22786l * this.f22780f));
                    this.f22778d.start();
                }
            } else if (this.f22778d.isRunning()) {
                this.f22778d.end();
            }
        } else {
            LogUtil.m16419e("FrameAnim doFrameAnim() anim = false && mAnimator = null)");
            OnFrameAnimEndCallback onFrameAnimEndCallback = this.f22783i;
            if (onFrameAnimEndCallback != null) {
                onFrameAnimEndCallback.onFrameAnimEnd();
            }
        }
    }

    public void doRippleAnim(boolean z) {
        if (z) {
            if (this.f22784j == null) {
                this.f22784j = new RippleCircle(this.f22777c, this.f22776b, this.f22785k);
            }
            this.f22784j.show();
            return;
        }
        RippleCircle rippleCircle = this.f22784j;
        if (rippleCircle != null) {
            rippleCircle.hide();
        }
    }

    public void setOnFrameAnimEndCallback(OnFrameAnimEndCallback onFrameAnimEndCallback) {
        this.f22783i = onFrameAnimEndCallback;
    }

    public void destory() {
        if (this.f22778d != null) {
            doFrameAnim(false);
            doRippleAnim(false);
            this.f22778d.removeAllUpdateListeners();
            this.f22778d.removeAllListeners();
            this.f22778d = null;
        }
        this.f22783i = null;
        this.f22779e = null;
        this.f22780f = 0;
        this.f22781g = 0;
        this.f22782h = true;
    }
}
