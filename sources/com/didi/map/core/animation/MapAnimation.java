package com.didi.map.core.animation;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.didi.map.core.point.GeoPoint;
import com.didi.trackupload.sdk.Constants;

public abstract class MapAnimation {

    /* renamed from: a */
    private boolean f24709a = false;
    protected InnerAnimationListener animationListener = null;
    protected SetAnimatePropertyListener animationProperty = null;

    /* renamed from: b */
    private boolean f24710b = false;

    /* renamed from: c */
    private boolean f24711c = false;

    /* renamed from: d */
    private Interpolator f24712d = new LinearInterpolator();
    protected long iDuration = Constants.SUBTITUDE_LOC_EFFECTIVE_TIME;
    protected long ltimeStart = 0;
    protected long ltimeStartOffset = 0;

    public interface InnerAnimationListener {
        void onAnimationFinish();

        void onAnimationStart();
    }

    public interface SetAnimatePropertyListener {
        void setAlpha(float f);

        void setPosition(int i, int i2);

        void setRatio(float f);

        void setRotate(float f, float f2, float f3, float f4);

        void setScale(float f, float f2);
    }

    /* access modifiers changed from: protected */
    public abstract void performAnimation(float f, Interpolator interpolator);

    public void setAnimationListener(InnerAnimationListener innerAnimationListener) {
        this.animationListener = innerAnimationListener;
    }

    public void setAnimationProperty(SetAnimatePropertyListener setAnimatePropertyListener) {
        this.animationProperty = setAnimatePropertyListener;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f24712d = interpolator;
    }

    public Interpolator getInterpolator() {
        return this.f24712d;
    }

    /* renamed from: a */
    private long m17575a() {
        return SystemClock.uptimeMillis();
    }

    public void setDuration(long j) {
        this.iDuration = j;
    }

    public void setDelay(long j) {
        this.ltimeStartOffset = j;
    }

    public boolean startAnimation(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (this.iDuration <= 0) {
            return false;
        }
        this.f24710b = true;
        this.ltimeStart = m17575a();
        this.f24709a = true;
        InnerAnimationListener innerAnimationListener = this.animationListener;
        if (innerAnimationListener != null) {
            innerAnimationListener.onAnimationStart();
        }
        return true;
    }

    public void stopAnimation() {
        this.f24709a = false;
    }

    public boolean isRunning() {
        return this.f24709a;
    }

    public void drawAnimation() {
        InnerAnimationListener innerAnimationListener;
        if (this.f24709a) {
            long a = m17575a() - (this.ltimeStart + this.ltimeStartOffset);
            if (a < 0) {
                a = 0;
            }
            float f = ((float) a) / ((float) this.iDuration);
            if (f > 1.0f) {
                this.f24709a = false;
                performAnimation(1.0f, this.f24712d);
                InnerAnimationListener innerAnimationListener2 = this.animationListener;
                if (innerAnimationListener2 != null) {
                    innerAnimationListener2.onAnimationFinish();
                }
                this.f24711c = true;
                return;
            }
            performAnimation(f, this.f24712d);
        } else if (!this.f24711c && (innerAnimationListener = this.animationListener) != null) {
            innerAnimationListener.onAnimationFinish();
        }
    }

    public boolean isStarted() {
        return this.f24710b;
    }

    public boolean isEnded() {
        return this.f24711c;
    }
}
