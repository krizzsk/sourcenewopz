package com.didichuxing.sofa.animation;

import android.view.View;

public class SofaAnimatorCompat {

    /* renamed from: a */
    private static int f49079a = 1;

    private SofaAnimatorCompat() {
    }

    public static void doRealAnimation() {
        f49079a = 1;
    }

    public static void doFakeAnimation() {
        f49079a = 2;
    }

    /* renamed from: a */
    private static AnimatorBuilder m35316a() {
        int i = f49079a;
        if (i == 1) {
            return new C16477x();
        }
        if (i != 2) {
            return new C16477x();
        }
        return new C16469o();
    }

    /* renamed from: b */
    private static ValueAnimatorBuilder m35317b() {
        return new ValueAnimatorBuilder();
    }

    public static AnimatorBuilder play(View view) {
        AnimatorBuilder a = m35316a();
        a.play(view);
        return a;
    }

    public static ValueAnimatorBuilder valueAnimation() {
        return m35317b();
    }

    public static Animator playTogether(Animator... animatorArr) {
        if (animatorArr == null || animatorArr.length == 0) {
            throw new IllegalArgumentException("No animator to play!");
        } else if (animatorArr[0] instanceof C16475v) {
            return m35317b().playTogether(animatorArr);
        } else {
            return m35316a().playTogether(animatorArr);
        }
    }

    public static Animator playSequentially(Animator... animatorArr) {
        if (animatorArr == null || animatorArr.length == 0) {
            throw new IllegalArgumentException("No animator to play!");
        } else if (animatorArr[0] instanceof C16475v) {
            return m35317b().playSequentially(animatorArr);
        } else {
            return m35316a().playSequentially(animatorArr);
        }
    }
}
