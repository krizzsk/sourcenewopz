package com.didichuxing.sofa.animation;

import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

/* renamed from: com.didichuxing.sofa.animation.k */
/* compiled from: CommonAnimationHelper */
class C16465k {

    /* renamed from: a */
    private static final String f49104a = "CommonAnimationHelper";

    /* renamed from: b */
    private static float[] f49105b = {0.0f, 1.0f};

    /* renamed from: c */
    private static float[] f49106c = {1.0f, 0.0f};

    C16465k() {
    }

    /* renamed from: a */
    static AnimatorBuilder m35327a(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.alpha(f49105b).decelerate();
    }

    /* renamed from: b */
    static AnimatorBuilder m35329b(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.alpha(f49106c).decelerate();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static float[] m35336e(View view) {
        float f = (float) (-view.getHeight());
        float y = view.getY();
        LoggerUtil.m35314d(f49104a, "getTranslateInFromTopValues view: " + view + "[y: " + y + Const.jaRight);
        if (y < 0.0f) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                LoggerUtil.m35314d(f49104a, "getTranslateInFromTopValues parent: " + viewGroup + "[top padding: " + viewGroup.getPaddingTop() + Const.jaRight);
                y = (float) viewGroup.getPaddingTop();
            } else {
                y = 0.0f;
            }
        }
        LoggerUtil.m35314d(f49104a, "translateInFromTop valueFrom: " + f + " valueTo: " + y);
        return new float[]{f, y};
    }

    /* renamed from: c */
    static AnimatorBuilder m35331c(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo121073y(m35336e(target));
        } else {
            animatorBuilder.mo121027a((Runnable) new CommonAnimationHelper$1(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static float[] m35338f(View view) {
        float y = view.getY();
        float f = (float) (-view.getHeight());
        LoggerUtil.m35314d(f49104a, "translateOutToTop valueFrom: " + y + " valueTo: " + f);
        return new float[]{y, f};
    }

    /* renamed from: d */
    static AnimatorBuilder m35333d(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo121073y(m35338f(target));
        } else {
            animatorBuilder.mo121027a((Runnable) new CommonAnimationHelper$2(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static float[] m35340g(View view) {
        float height = (float) view.getRootView().getHeight();
        float y = view.getY();
        LoggerUtil.m35314d(f49104a, "translateInFromBottom valueFrom: " + height + " valueTo: " + y);
        return new float[]{height, y};
    }

    /* renamed from: e */
    static AnimatorBuilder m35335e(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo121073y(m35340g(target));
        } else {
            animatorBuilder.mo121027a((Runnable) new CommonAnimationHelper$3(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static float[] m35342h(View view) {
        View rootView = view.getRootView();
        float y = view.getY();
        float height = (float) rootView.getHeight();
        LoggerUtil.m35314d(f49104a, "translateOutToBottom valueFrom: " + y + " valueTo: " + height);
        return new float[]{y, height};
    }

    /* renamed from: f */
    static AnimatorBuilder m35337f(AnimatorBuilder animatorBuilder) {
        View target = animatorBuilder.getTarget();
        if (target == null) {
            return animatorBuilder;
        }
        if (target.getVisibility() != 8) {
            animatorBuilder.mo121073y(m35342h(target));
        } else {
            animatorBuilder.mo121027a((Runnable) new CommonAnimationHelper$4(animatorBuilder, target));
        }
        animatorBuilder.decelerate();
        return animatorBuilder;
    }

    /* renamed from: g */
    static AnimatorBuilder m35339g(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.scaleX(f49105b).scaleY(f49105b);
    }

    /* renamed from: h */
    static AnimatorBuilder m35341h(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.scaleX(f49106c).scaleY(f49106c);
    }

    /* renamed from: i */
    static AnimatorBuilder m35343i(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.rotate(0.0f, 360.0f);
    }

    /* renamed from: j */
    static AnimatorBuilder m35344j(AnimatorBuilder animatorBuilder) {
        return animatorBuilder.rotate(360.0f, 0.0f);
    }
}
