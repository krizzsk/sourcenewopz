package com.didi.nova.assembly.p127ui.shimmer;

import com.didi.nova.assembly.p127ui.shimmer.ShimmerViewHelper;

/* renamed from: com.didi.nova.assembly.ui.shimmer.ShimmerViewBase */
public interface ShimmerViewBase {
    float getGradientX();

    int getPrimaryColor();

    int getReflectionColor();

    boolean isSetUp();

    boolean isShimmering();

    void setAnimationSetupCallback(ShimmerViewHelper.AnimationSetupCallback animationSetupCallback);

    void setGradientX(float f);

    void setPrimaryColor(int i);

    void setReflectionColor(int i);

    void setShimmering(boolean z);
}
