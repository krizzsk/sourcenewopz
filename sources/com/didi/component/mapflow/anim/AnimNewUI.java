package com.didi.component.mapflow.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;

public final class AnimNewUI {
    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static ObjectAnimator getEnterTranslationX(Context context) {
        if (context == null) {
            return null;
        }
        Point point = new Point();
        getWindowManager(context).getDefaultDisplay().getSize(point);
        int i = point.x;
        int i2 = point.y;
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("translationX");
        objectAnimator.setFloatValues(new float[]{(float) i, 0.0f});
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_OUT));
        return objectAnimator;
    }

    public static ObjectAnimator getEnterAlphaAnim() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("alpha");
        objectAnimator.setDuration(500);
        objectAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        return objectAnimator;
    }

    public static ObjectAnimator getExitTranslationX(Context context) {
        if (context == null) {
            return null;
        }
        Point point = new Point();
        getWindowManager(context).getDefaultDisplay().getSize(point);
        int i = point.x;
        int i2 = point.y;
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("translationX");
        objectAnimator.setFloatValues(new float[]{0.0f, (float) i});
        objectAnimator.setDuration(500);
        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.CUBIC_OUT));
        return objectAnimator;
    }

    public static ObjectAnimator getExitAlphaAnim() {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setPropertyName("alpha");
        objectAnimator.setDuration(500);
        objectAnimator.setFloatValues(new float[]{1.0f, 0.0f});
        objectAnimator.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        return objectAnimator;
    }
}
