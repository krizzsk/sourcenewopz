package com.didi.component.safetoolkit.views.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ViewSizeAnimation extends Animation {

    /* renamed from: a */
    private int f15452a;

    /* renamed from: b */
    private int f15453b;

    /* renamed from: c */
    private int f15454c;

    /* renamed from: d */
    private int f15455d;

    /* renamed from: e */
    private View f15456e;

    /* renamed from: f */
    private AnimationUpdater f15457f;

    /* renamed from: g */
    private float f15458g;

    public interface AnimationUpdater {
        void onUpdate(int i, int i2, int i3, int i4, float f);
    }

    public boolean willChangeBounds() {
        return true;
    }

    public ViewSizeAnimation(View view) {
        this.f15456e = view;
        this.f15453b = -1;
        this.f15455d = -1;
    }

    public ViewSizeAnimation(View view, int i, int i2) {
        this.f15456e = view;
        this.f15453b = i;
        this.f15455d = i2;
    }

    public ViewSizeAnimation(View view, int i) {
        this.f15456e = view;
        this.f15453b = -1;
        this.f15455d = i;
    }

    public void setTargetWidth(int i) {
        this.f15455d = i;
    }

    public void setTargetHeight(int i) {
        this.f15453b = i;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f, Transformation transformation) {
        if (this.f15458g != f) {
            this.f15458g = f;
            if (this.f15453b != -1) {
                ViewGroup.LayoutParams layoutParams = this.f15456e.getLayoutParams();
                int i = this.f15452a;
                layoutParams.height = i + ((int) (((float) (this.f15453b - i)) * f));
            }
            if (this.f15455d != -1) {
                ViewGroup.LayoutParams layoutParams2 = this.f15456e.getLayoutParams();
                int i2 = this.f15454c;
                layoutParams2.width = i2 + ((int) (((float) (this.f15455d - i2)) * f));
            }
            this.f15456e.requestLayout();
            AnimationUpdater animationUpdater = this.f15457f;
            if (animationUpdater != null) {
                animationUpdater.onUpdate(this.f15452a, this.f15454c, this.f15453b, this.f15455d, f);
            }
        }
    }

    public void initialize(int i, int i2, int i3, int i4) {
        this.f15452a = i2;
        this.f15454c = i;
        super.initialize(i, i2, i3, i4);
    }

    public void setAnimationUpdater(AnimationUpdater animationUpdater) {
        this.f15457f = animationUpdater;
    }
}
