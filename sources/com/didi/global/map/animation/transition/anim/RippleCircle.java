package com.didi.global.map.animation.transition.anim;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class RippleCircle {

    /* renamed from: l */
    private static final String f22792l = RippleCircle.class.getSimpleName();

    /* renamed from: a */
    private List<Circle> f22793a;

    /* renamed from: b */
    private Circle f22794b;

    /* renamed from: c */
    private Circle f22795c;

    /* renamed from: d */
    private LatLng f22796d;

    /* renamed from: e */
    private ShowStatus f22797e;

    /* renamed from: f */
    private int f22798f = 352321535;

    /* renamed from: g */
    private int f22799g = 335597741;

    /* renamed from: h */
    private float f22800h = 20.0f;

    /* renamed from: i */
    private float f22801i = 2.0f;

    /* renamed from: j */
    private long f22802j = 1800;

    /* renamed from: k */
    private long f22803k = 1150;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo67356a(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public RippleCircle(List<Circle> list, Marker marker) {
        this.f22793a = list;
        this.f22796d = marker.getPosition();
        m16401c();
    }

    public RippleCircle(List<Circle> list, Marker marker, RippleAnimParam rippleAnimParam) {
        this.f22793a = list;
        this.f22796d = marker.getPosition();
        if (rippleAnimParam != null) {
            this.f22798f = rippleAnimParam.getFillColor();
            this.f22799g = rippleAnimParam.getStrokeColor();
            this.f22800h = (float) rippleAnimParam.getAlpha();
            this.f22803k = (long) rippleAnimParam.getRadius();
            this.f22801i = (float) rippleAnimParam.getStrokeWidth();
            String str = f22792l;
            SystemUtils.log(4, str, "RippleAnimParam = " + rippleAnimParam, (Throwable) null, "com.didi.global.map.animation.transition.anim.RippleCircle", 53);
        }
        m16401c();
    }

    public void show() {
        this.f22797e = ShowStatus.SHOW;
        m16398a();
    }

    public void hide() {
        this.f22797e = ShowStatus.HIDE;
        m16402d();
    }

    public boolean isShowing() {
        return this.f22797e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f22797e == ShowStatus.SHOW) {
            this.f22796d = latLng;
            m16398a();
        }
    }

    /* renamed from: a */
    private void m16398a() {
        m16402d();
        m16400b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1800.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.f22802j);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleCircle.this.m16399a(valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16399a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (this.f22795c != null && this.f22794b != null) {
            if (0.0f <= f.floatValue() && f.floatValue() <= 1500.0f) {
                Float valueOf = Float.valueOf(f.floatValue() - 500.0f);
                Float valueOf2 = f.floatValue() >= 1000.0f ? Float.valueOf(1000.0f) : f;
                if (valueOf.floatValue() <= 0.0f) {
                    valueOf = Float.valueOf(0.0f);
                }
                this.f22794b.setRadius((double) (valueOf2.floatValue() * 0.001f * ((float) this.f22803k)));
                this.f22795c.setRadius((double) (valueOf.floatValue() * 0.001f * ((float) this.f22803k)));
            }
            Float.valueOf(1.0f);
            Float.valueOf(1.0f);
            if (f.floatValue() >= 700.0f && f.floatValue() <= 1300.0f) {
                Float valueOf3 = Float.valueOf(Math.abs((f.floatValue() - 1300.0f) / 600.0f));
                this.f22794b.setStrokeColor(mo67356a(this.f22799g, (int) (this.f22800h * valueOf3.floatValue())));
                this.f22794b.setFillColor(mo67356a(this.f22798f, (int) (this.f22800h * valueOf3.floatValue())));
            } else if (f.floatValue() >= 1200.0f && f.floatValue() <= 1800.0f) {
                Float valueOf4 = Float.valueOf(Math.abs((f.floatValue() - 1800.0f) / 600.0f));
                this.f22795c.setStrokeColor(mo67356a(this.f22799g, (int) (this.f22800h * valueOf4.floatValue())));
                this.f22795c.setFillColor(mo67356a(this.f22798f, (int) (this.f22800h * valueOf4.floatValue())));
            }
        }
    }

    /* renamed from: b */
    private void m16400b() {
        Circle circle = this.f22794b;
        if (circle != null) {
            circle.setVisible(true);
        }
        Circle circle2 = this.f22795c;
        if (circle2 != null) {
            circle2.setVisible(true);
        }
    }

    /* renamed from: c */
    private void m16401c() {
        List<Circle> list = this.f22793a;
        if (list != null && list.size() >= 2) {
            this.f22794b = this.f22793a.get(0);
            this.f22795c = this.f22793a.get(1);
            CircleOptions strokeWidth = new CircleOptions().center(this.f22796d).radius(0.0d).fillColor(this.f22798f).strokeColor(this.f22799g).strokeWidth(this.f22801i);
            this.f22795c.setOptions(strokeWidth);
            this.f22794b.setOptions(strokeWidth);
            this.f22794b.setVisible(false);
            this.f22795c.setVisible(false);
        }
    }

    /* renamed from: d */
    private void m16402d() {
        Circle circle = this.f22794b;
        if (circle != null) {
            circle.setRadius(0.0d);
            this.f22794b.setVisible(false);
        }
        Circle circle2 = this.f22795c;
        if (circle2 != null) {
            circle2.setRadius(0.0d);
            this.f22795c.setVisible(false);
        }
    }

    /* renamed from: e */
    private void m16403e() {
        Circle circle = this.f22794b;
        if (circle != null) {
            circle.remove();
            this.f22794b = null;
        }
        Circle circle2 = this.f22795c;
        if (circle2 != null) {
            circle2.remove();
            this.f22795c = null;
        }
    }
}
