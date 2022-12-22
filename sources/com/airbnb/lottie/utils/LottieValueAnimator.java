package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* renamed from: a */
    private float f1684a = 1.0f;

    /* renamed from: b */
    private boolean f1685b = false;

    /* renamed from: c */
    private long f1686c = 0;

    /* renamed from: d */
    private float f1687d = 0.0f;

    /* renamed from: e */
    private int f1688e = 0;

    /* renamed from: f */
    private float f1689f = -2.14748365E9f;

    /* renamed from: g */
    private float f1690g = 2.14748365E9f;

    /* renamed from: h */
    private LottieComposition f1691h;
    protected boolean running = false;

    public Object getAnimatedValue() {
        return Float.valueOf(getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.f1691h;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f1687d - lottieComposition.getStartFrame()) / (this.f1691h.getEndFrame() - this.f1691h.getStartFrame());
    }

    public float getAnimatedFraction() {
        float minFrame;
        float maxFrame;
        float minFrame2;
        if (this.f1691h == null) {
            return 0.0f;
        }
        if (m1468e()) {
            minFrame = getMaxFrame() - this.f1687d;
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        } else {
            minFrame = this.f1687d - getMinFrame();
            maxFrame = getMaxFrame();
            minFrame2 = getMinFrame();
        }
        return minFrame / (maxFrame - minFrame2);
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.f1691h;
        if (lottieComposition == null) {
            return 0;
        }
        return (long) lottieComposition.getDuration();
    }

    public float getFrame() {
        return this.f1687d;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void doFrame(long j) {
        postFrameCallback();
        if (this.f1691h != null && isRunning()) {
            C1429L.beginSection("LottieValueAnimator#doFrame");
            long j2 = this.f1686c;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float d = ((float) j3) / m1467d();
            float f = this.f1687d;
            if (m1468e()) {
                d = -d;
            }
            float f2 = f + d;
            this.f1687d = f2;
            boolean z = !MiscUtils.contains(f2, getMinFrame(), getMaxFrame());
            this.f1687d = MiscUtils.clamp(this.f1687d, getMinFrame(), getMaxFrame());
            this.f1686c = j;
            mo15535c();
            if (z) {
                if (getRepeatCount() == -1 || this.f1688e < getRepeatCount()) {
                    mo15529a();
                    this.f1688e++;
                    if (getRepeatMode() == 2) {
                        this.f1685b = !this.f1685b;
                        reverseAnimationSpeed();
                    } else {
                        this.f1687d = m1468e() ? getMaxFrame() : getMinFrame();
                    }
                    this.f1686c = j;
                } else {
                    this.f1687d = this.f1684a < 0.0f ? getMinFrame() : getMaxFrame();
                    removeFrameCallback();
                    mo15534b(m1468e());
                }
            }
            m1469f();
            C1429L.endSection("LottieValueAnimator#doFrame");
        }
    }

    /* renamed from: d */
    private float m1467d() {
        LottieComposition lottieComposition = this.f1691h;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.getFrameRate()) / Math.abs(this.f1684a);
    }

    public void clearComposition() {
        this.f1691h = null;
        this.f1689f = -2.14748365E9f;
        this.f1690g = 2.14748365E9f;
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean z = this.f1691h == null;
        this.f1691h = lottieComposition;
        if (z) {
            setMinAndMaxFrames((float) ((int) Math.max(this.f1689f, lottieComposition.getStartFrame())), (float) ((int) Math.min(this.f1690g, lottieComposition.getEndFrame())));
        } else {
            setMinAndMaxFrames((float) ((int) lottieComposition.getStartFrame()), (float) ((int) lottieComposition.getEndFrame()));
        }
        float f = this.f1687d;
        this.f1687d = 0.0f;
        setFrame((float) ((int) f));
        mo15535c();
    }

    public void setFrame(float f) {
        if (this.f1687d != f) {
            this.f1687d = MiscUtils.clamp(f, getMinFrame(), getMaxFrame());
            this.f1686c = 0;
            mo15535c();
        }
    }

    public void setMinFrame(int i) {
        setMinAndMaxFrames((float) i, (float) ((int) this.f1690g));
    }

    public void setMaxFrame(float f) {
        setMinAndMaxFrames(this.f1689f, f);
    }

    public void setMinAndMaxFrames(float f, float f2) {
        if (f <= f2) {
            LottieComposition lottieComposition = this.f1691h;
            float startFrame = lottieComposition == null ? -3.4028235E38f : lottieComposition.getStartFrame();
            LottieComposition lottieComposition2 = this.f1691h;
            float endFrame = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
            this.f1689f = MiscUtils.clamp(f, startFrame, endFrame);
            this.f1690g = MiscUtils.clamp(f2, startFrame, endFrame);
            setFrame((float) ((int) MiscUtils.clamp(this.f1687d, f, f2)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.f1684a = f;
    }

    public float getSpeed() {
        return this.f1684a;
    }

    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f1685b) {
            this.f1685b = false;
            reverseAnimationSpeed();
        }
    }

    public void playAnimation() {
        this.running = true;
        mo15530a(m1468e());
        setFrame((float) ((int) (m1468e() ? getMaxFrame() : getMinFrame())));
        this.f1686c = 0;
        this.f1688e = 0;
        postFrameCallback();
    }

    public void endAnimation() {
        removeFrameCallback();
        mo15534b(m1468e());
    }

    public void pauseAnimation() {
        removeFrameCallback();
    }

    public void resumeAnimation() {
        this.running = true;
        postFrameCallback();
        this.f1686c = 0;
        if (m1468e() && getFrame() == getMinFrame()) {
            this.f1687d = getMaxFrame();
        } else if (!m1468e() && getFrame() == getMaxFrame()) {
            this.f1687d = getMinFrame();
        }
    }

    public void cancel() {
        mo15533b();
        removeFrameCallback();
    }

    /* renamed from: e */
    private boolean m1468e() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.f1691h;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.f1689f;
        return f == -2.14748365E9f ? lottieComposition.getStartFrame() : f;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.f1691h;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f = this.f1690g;
        return f == 2.14748365E9f ? lottieComposition.getEndFrame() : f;
    }

    /* access modifiers changed from: protected */
    public void postFrameCallback() {
        if (isRunning()) {
            removeFrameCallback(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    /* access modifiers changed from: protected */
    public void removeFrameCallback() {
        removeFrameCallback(true);
    }

    /* access modifiers changed from: protected */
    public void removeFrameCallback(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    /* renamed from: f */
    private void m1469f() {
        if (this.f1691h != null) {
            float f = this.f1687d;
            if (f < this.f1689f || f > this.f1690g) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f1689f), Float.valueOf(this.f1690g), Float.valueOf(this.f1687d)}));
            }
        }
    }
}
