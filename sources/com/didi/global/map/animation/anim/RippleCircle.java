package com.didi.global.map.animation.anim;

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
    private static final String f22725l = RippleCircle.class.getSimpleName();

    /* renamed from: a */
    private List<Circle> f22726a;

    /* renamed from: b */
    private Circle f22727b;

    /* renamed from: c */
    private Circle f22728c;

    /* renamed from: d */
    private LatLng f22729d;

    /* renamed from: e */
    private ShowStatus f22730e;

    /* renamed from: f */
    private int f22731f = 352321535;

    /* renamed from: g */
    private int f22732g = 335597741;

    /* renamed from: h */
    private float f22733h = 20.0f;

    /* renamed from: i */
    private float f22734i = 2.0f;

    /* renamed from: j */
    private long f22735j = 1800;

    /* renamed from: k */
    private long f22736k = 1150;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo67287a(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public RippleCircle(List<Circle> list, Marker marker) {
        this.f22726a = list;
        this.f22729d = marker.getPosition();
        m16359c();
    }

    public RippleCircle(List<Circle> list, Marker marker, RippleAnimParam rippleAnimParam) {
        this.f22726a = list;
        this.f22729d = marker.getPosition();
        if (rippleAnimParam != null) {
            this.f22731f = rippleAnimParam.getFillColor();
            this.f22732g = rippleAnimParam.getStrokeColor();
            this.f22733h = (float) rippleAnimParam.getAlpha();
            this.f22736k = (long) rippleAnimParam.getRadius();
            this.f22734i = (float) rippleAnimParam.getStrokeWidth();
            String str = f22725l;
            SystemUtils.log(4, str, "RippleAnimParam = " + rippleAnimParam, (Throwable) null, "com.didi.global.map.animation.anim.RippleCircle", 53);
        }
        m16359c();
    }

    public void show() {
        this.f22730e = ShowStatus.SHOW;
        m16356a();
    }

    public void hide() {
        this.f22730e = ShowStatus.HIDE;
        m16360d();
    }

    public boolean isShowing() {
        return this.f22730e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f22730e == ShowStatus.SHOW) {
            this.f22729d = latLng;
            m16356a();
        }
    }

    /* renamed from: a */
    private void m16356a() {
        m16360d();
        m16358b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1800.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.f22735j);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleCircle.this.m16357a(valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m16357a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        if (this.f22728c != null && this.f22727b != null) {
            if (0.0f <= f.floatValue() && f.floatValue() <= 1500.0f) {
                Float valueOf = Float.valueOf(f.floatValue() - 500.0f);
                Float valueOf2 = f.floatValue() >= 1000.0f ? Float.valueOf(1000.0f) : f;
                if (valueOf.floatValue() <= 0.0f) {
                    valueOf = Float.valueOf(0.0f);
                }
                this.f22727b.setRadius((double) (valueOf2.floatValue() * 0.001f * ((float) this.f22736k)));
                this.f22728c.setRadius((double) (valueOf.floatValue() * 0.001f * ((float) this.f22736k)));
            }
            Float.valueOf(1.0f);
            Float.valueOf(1.0f);
            if (f.floatValue() >= 700.0f && f.floatValue() <= 1300.0f) {
                Float valueOf3 = Float.valueOf(Math.abs((f.floatValue() - 1300.0f) / 600.0f));
                this.f22727b.setStrokeColor(mo67287a(this.f22732g, (int) (this.f22733h * valueOf3.floatValue())));
                this.f22727b.setFillColor(mo67287a(this.f22731f, (int) (this.f22733h * valueOf3.floatValue())));
            } else if (f.floatValue() >= 1200.0f && f.floatValue() <= 1800.0f) {
                Float valueOf4 = Float.valueOf(Math.abs((f.floatValue() - 1800.0f) / 600.0f));
                this.f22728c.setStrokeColor(mo67287a(this.f22732g, (int) (this.f22733h * valueOf4.floatValue())));
                this.f22728c.setFillColor(mo67287a(this.f22731f, (int) (this.f22733h * valueOf4.floatValue())));
            }
        }
    }

    /* renamed from: b */
    private void m16358b() {
        Circle circle = this.f22727b;
        if (circle != null) {
            circle.setVisible(true);
        }
        Circle circle2 = this.f22728c;
        if (circle2 != null) {
            circle2.setVisible(true);
        }
    }

    /* renamed from: c */
    private void m16359c() {
        List<Circle> list = this.f22726a;
        if (list != null && list.size() >= 2) {
            this.f22727b = this.f22726a.get(0);
            this.f22728c = this.f22726a.get(1);
            CircleOptions strokeWidth = new CircleOptions().center(this.f22729d).radius(0.0d).fillColor(this.f22731f).strokeColor(this.f22732g).strokeWidth(this.f22734i);
            this.f22728c.setOptions(strokeWidth);
            this.f22727b.setOptions(strokeWidth);
            this.f22727b.setVisible(false);
            this.f22728c.setVisible(false);
        }
    }

    /* renamed from: d */
    private void m16360d() {
        Circle circle = this.f22727b;
        if (circle != null) {
            circle.setRadius(0.0d);
            this.f22727b.setVisible(false);
        }
        Circle circle2 = this.f22728c;
        if (circle2 != null) {
            circle2.setRadius(0.0d);
            this.f22728c.setVisible(false);
        }
    }

    /* renamed from: e */
    private void m16361e() {
        Circle circle = this.f22727b;
        if (circle != null) {
            circle.remove();
            this.f22727b = null;
        }
        Circle circle2 = this.f22728c;
        if (circle2 != null) {
            circle2.remove();
            this.f22728c = null;
        }
    }
}
