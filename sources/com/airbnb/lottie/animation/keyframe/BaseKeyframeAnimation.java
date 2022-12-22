package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.C1429L;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseKeyframeAnimation<K, A> {

    /* renamed from: a */
    final List<AnimationListener> f1318a = new ArrayList(1);

    /* renamed from: b */
    private boolean f1319b = false;

    /* renamed from: c */
    private final KeyframesWrapper<K> f1320c;

    /* renamed from: d */
    private A f1321d = null;

    /* renamed from: e */
    private float f1322e = -1.0f;

    /* renamed from: f */
    private float f1323f = -1.0f;
    protected float progress = 0.0f;
    protected LottieValueCallback<A> valueCallback;

    public interface AnimationListener {
        void onValueChanged();
    }

    private interface KeyframesWrapper<T> {
        Keyframe<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f);

        boolean isEmpty();

        boolean isValueChanged(float f);
    }

    /* access modifiers changed from: package-private */
    public abstract A getValue(Keyframe<K> keyframe, float f);

    BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        this.f1320c = m1285a(list);
    }

    public void setIsDiscrete() {
        this.f1319b = true;
    }

    public void addUpdateListener(AnimationListener animationListener) {
        this.f1318a.add(animationListener);
    }

    public void setProgress(float f) {
        if (!this.f1320c.isEmpty()) {
            if (f < m1286c()) {
                f = m1286c();
            } else if (f > mo15226b()) {
                f = mo15226b();
            }
            if (f != this.progress) {
                this.progress = f;
                if (this.f1320c.isValueChanged(f)) {
                    notifyListeners();
                }
            }
        }
    }

    public void notifyListeners() {
        for (int i = 0; i < this.f1318a.size(); i++) {
            this.f1318a.get(i).onValueChanged();
        }
    }

    /* access modifiers changed from: protected */
    public Keyframe<K> getCurrentKeyframe() {
        C1429L.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        Keyframe<K> currentKeyframe = this.f1320c.getCurrentKeyframe();
        C1429L.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo15224a() {
        if (this.f1319b) {
            return 0.0f;
        }
        Keyframe currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.progress - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    /* access modifiers changed from: protected */
    public float getInterpolatedCurrentKeyframeProgress() {
        Keyframe currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.interpolator.getInterpolation(mo15224a());
    }

    /* renamed from: c */
    private float m1286c() {
        if (this.f1322e == -1.0f) {
            this.f1322e = this.f1320c.getStartDelayProgress();
        }
        return this.f1322e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo15226b() {
        if (this.f1323f == -1.0f) {
            this.f1323f = this.f1320c.getEndProgress();
        }
        return this.f1323f;
    }

    public A getValue() {
        float interpolatedCurrentKeyframeProgress = getInterpolatedCurrentKeyframeProgress();
        if (this.valueCallback == null && this.f1320c.isCachedValueEnabled(interpolatedCurrentKeyframeProgress)) {
            return this.f1321d;
        }
        A value = getValue(getCurrentKeyframe(), interpolatedCurrentKeyframeProgress);
        this.f1321d = value;
        return value;
    }

    public float getProgress() {
        return this.progress;
    }

    public void setValueCallback(LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.valueCallback;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation((BaseKeyframeAnimation<?, ?>) null);
        }
        this.valueCallback = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    /* renamed from: a */
    private static <T> KeyframesWrapper<T> m1285a(List<? extends Keyframe<T>> list) {
        if (list.isEmpty()) {
            return new EmptyKeyframeWrapper();
        }
        if (list.size() == 1) {
            return new SingleKeyframeWrapper(list);
        }
        return new KeyframesWrapperImpl(list);
    }

    private static final class EmptyKeyframeWrapper<T> implements KeyframesWrapper<T> {
        public float getEndProgress() {
            return 1.0f;
        }

        public float getStartDelayProgress() {
            return 0.0f;
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean isValueChanged(float f) {
            return false;
        }

        private EmptyKeyframeWrapper() {
        }

        public Keyframe<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        public boolean isCachedValueEnabled(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class SingleKeyframeWrapper<T> implements KeyframesWrapper<T> {
        private float cachedInterpolatedProgress = -1.0f;
        private final Keyframe<T> keyframe;

        public boolean isEmpty() {
            return false;
        }

        SingleKeyframeWrapper(List<? extends Keyframe<T>> list) {
            this.keyframe = (Keyframe) list.get(0);
        }

        public boolean isValueChanged(float f) {
            return !this.keyframe.isStatic();
        }

        public Keyframe<T> getCurrentKeyframe() {
            return this.keyframe;
        }

        public float getStartDelayProgress() {
            return this.keyframe.getStartProgress();
        }

        public float getEndProgress() {
            return this.keyframe.getEndProgress();
        }

        public boolean isCachedValueEnabled(float f) {
            if (this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedInterpolatedProgress = f;
            return false;
        }
    }

    private static final class KeyframesWrapperImpl<T> implements KeyframesWrapper<T> {
        private Keyframe<T> cachedCurrentKeyframe = null;
        private float cachedInterpolatedProgress = -1.0f;
        private Keyframe<T> currentKeyframe;
        private final List<? extends Keyframe<T>> keyframes;

        public boolean isEmpty() {
            return false;
        }

        KeyframesWrapperImpl(List<? extends Keyframe<T>> list) {
            this.keyframes = list;
            this.currentKeyframe = findKeyframe(0.0f);
        }

        public boolean isValueChanged(float f) {
            if (this.currentKeyframe.containsProgress(f)) {
                return !this.currentKeyframe.isStatic();
            }
            this.currentKeyframe = findKeyframe(f);
            return true;
        }

        private Keyframe<T> findKeyframe(float f) {
            List<? extends Keyframe<T>> list = this.keyframes;
            Keyframe<T> keyframe = (Keyframe) list.get(list.size() - 1);
            if (f >= keyframe.getStartProgress()) {
                return keyframe;
            }
            for (int size = this.keyframes.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = (Keyframe) this.keyframes.get(size);
                if (this.currentKeyframe != keyframe2 && keyframe2.containsProgress(f)) {
                    return keyframe2;
                }
            }
            return (Keyframe) this.keyframes.get(0);
        }

        public Keyframe<T> getCurrentKeyframe() {
            return this.currentKeyframe;
        }

        public float getStartDelayProgress() {
            return ((Keyframe) this.keyframes.get(0)).getStartProgress();
        }

        public float getEndProgress() {
            List<? extends Keyframe<T>> list = this.keyframes;
            return ((Keyframe) list.get(list.size() - 1)).getEndProgress();
        }

        public boolean isCachedValueEnabled(float f) {
            if (this.cachedCurrentKeyframe == this.currentKeyframe && this.cachedInterpolatedProgress == f) {
                return true;
            }
            this.cachedCurrentKeyframe = this.currentKeyframe;
            this.cachedInterpolatedProgress = f;
            return false;
        }
    }
}
