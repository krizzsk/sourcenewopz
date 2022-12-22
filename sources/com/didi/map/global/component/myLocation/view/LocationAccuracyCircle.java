package com.didi.map.global.component.myLocation.view;

import android.animation.ValueAnimator;
import com.didi.common.map.Map;
import com.didi.common.map.model.Circle;
import com.didi.common.map.model.CircleOptions;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;

public class LocationAccuracyCircle {

    /* renamed from: l */
    private static final float f26056l = 2.0f;

    /* renamed from: m */
    private static final float f26057m = 30.0f;

    /* renamed from: n */
    private static final float f26058n = 500.0f;

    /* renamed from: o */
    private static final float f26059o = 20.0f;

    /* renamed from: p */
    private static final long f26060p = 200;

    /* renamed from: q */
    private static final String f26061q = "LocationAccuracyCircle";

    /* renamed from: a */
    private Map f26062a;

    /* renamed from: b */
    private Circle f26063b;

    /* renamed from: c */
    private LatLng f26064c;

    /* renamed from: d */
    private LatLng f26065d;

    /* renamed from: e */
    private ShowStatus f26066e;

    /* renamed from: f */
    private int f26067f = 456958182;

    /* renamed from: g */
    private int f26068g = -3874057;

    /* renamed from: h */
    private float f26069h;

    /* renamed from: i */
    private float f26070i;

    /* renamed from: j */
    private float f26071j;

    /* renamed from: k */
    private boolean f26072k = false;

    public enum ShowStatus {
        SHOW,
        HIDE
    }

    public LocationAccuracyCircle(Map map, LocationAccuracyCircleOptions locationAccuracyCircleOptions) {
        if (map == null || locationAccuracyCircleOptions == null) {
            DLog.m7384d(f26061q, " create fail...", new Object[0]);
            return;
        }
        this.f26062a = map;
        this.f26072k = true;
        this.f26064c = locationAccuracyCircleOptions.getPosition();
        this.f26069h = locationAccuracyCircleOptions.getAccuracy();
        this.f26070i = locationAccuracyCircleOptions.getDefMinAccuracy() > 0.0f ? locationAccuracyCircleOptions.getDefMinAccuracy() : 30.0f;
        this.f26071j = locationAccuracyCircleOptions.getDefMaxAccuracy() > 0.0f ? locationAccuracyCircleOptions.getDefMaxAccuracy() : f26058n;
    }

    public void show() {
        if (this.f26066e != ShowStatus.SHOW && this.f26072k) {
            this.f26066e = ShowStatus.SHOW;
            if (this.f26064c != null && this.f26069h > this.f26070i) {
                m18489a();
            }
        }
    }

    public void hide() {
        this.f26066e = ShowStatus.HIDE;
        m18493c();
    }

    public boolean isShowing() {
        return this.f26066e == ShowStatus.SHOW;
    }

    public void update(LatLng latLng, float f) {
        if (this.f26072k && this.f26066e == ShowStatus.SHOW) {
            this.f26065d = this.f26064c;
            this.f26064c = latLng;
            this.f26069h = f;
            if (latLng == null || f <= this.f26070i) {
                m18493c();
            } else {
                m18489a();
            }
        }
    }

    /* renamed from: a */
    private void m18489a() {
        float f;
        m18494d();
        Circle circle = this.f26063b;
        if (circle != null) {
            f = (float) circle.getRadius();
            if (m18491a(this.f26064c, this.f26065d)) {
                this.f26063b.setCenter(this.f26064c);
            }
        } else {
            f = this.f26069h;
            m18492b();
        }
        if (this.f26063b != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, this.f26069h});
            ofFloat.setDuration(200);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LocationAccuracyCircle.this.m18490a(valueAnimator);
                }
            });
            ofFloat.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18490a(ValueAnimator valueAnimator) {
        Float f = (Float) valueAnimator.getAnimatedValue();
        Circle circle = this.f26063b;
        if (circle != null) {
            circle.setRadius((double) f.floatValue());
        }
    }

    /* renamed from: b */
    private void m18492b() {
        this.f26063b = this.f26062a.addCircle(new CircleOptions().center(this.f26064c).radius((double) this.f26069h).fillColor(this.f26067f).strokeColor(this.f26068g).strokeWidth(2.0f));
    }

    /* renamed from: c */
    private void m18493c() {
        Circle circle;
        Map map = this.f26062a;
        if (map != null && (circle = this.f26063b) != null) {
            map.remove(circle);
            this.f26063b = null;
        }
    }

    /* renamed from: d */
    private void m18494d() {
        float f = this.f26069h;
        float f2 = this.f26071j;
        if (f > f2) {
            this.f26069h = f2;
        }
    }

    /* renamed from: a */
    private boolean m18491a(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return false;
        }
        try {
            int i = (int) ((latLng.longitude * 1000000.0d) - (latLng2.longitude * 1000000.0d));
            if (((float) Math.abs((int) ((latLng.latitude * 1000000.0d) - (latLng2.latitude * 1000000.0d)))) >= 20.0f || ((float) Math.abs(i)) >= 20.0f) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
