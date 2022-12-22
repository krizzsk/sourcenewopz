package com.didichuxing.dfbasesdk.utils;

import android.animation.ValueAnimator;
import android.os.Build;
import java.lang.reflect.Field;

public class AnimatorUtils {
    public static void ensureValueAnimatorEnable() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (declaredField.getFloat((Object) null) == 0.0f) {
                    declaredField.setFloat((Object) null, 1.0f);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
