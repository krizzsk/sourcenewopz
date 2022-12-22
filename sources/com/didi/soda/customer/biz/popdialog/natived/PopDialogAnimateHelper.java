package com.didi.soda.customer.biz.popdialog.natived;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/PopDialogAnimateHelper;", "", "()V", "ALPHA", "", "APPREAR_ANIMATE_DURATION", "", "BACKGOUND_COLOR", "DISAPPREAR_ANIMATE_DURATION", "SCALE_X", "SCALE_Y", "appearDialogWithAnimate", "", "popView", "Lcom/didi/soda/customer/biz/popdialog/natived/DialogAnimateInterface;", "disAppearDialogWithAnimate", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PopDialogAnimateHelper.kt */
public final class PopDialogAnimateHelper {
    public static final String ALPHA = "alpha";
    public static final long APPREAR_ANIMATE_DURATION = 300;
    public static final String BACKGOUND_COLOR = "backgroundColor";
    public static final long DISAPPREAR_ANIMATE_DURATION = 100;
    public static final PopDialogAnimateHelper INSTANCE = new PopDialogAnimateHelper();
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";

    private PopDialogAnimateHelper() {
    }

    @JvmStatic
    public static final void appearDialogWithAnimate(DialogAnimateInterface dialogAnimateInterface) {
        Intrinsics.checkNotNullParameter(dialogAnimateInterface, "popView");
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.25f, 1.0f);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{0.0f, 1.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(dialogAnimateInterface.getContentView(), new PropertyValuesHolder[]{ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(p…entView(),scaleX, scaleY)");
        ofPropertyValuesHolder.setInterpolator(create);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(dialogAnimateInterface.getContentView(), new PropertyValuesHolder[]{ofFloat3});
        ofPropertyValuesHolder2.setInterpolator(PathInterpolatorCompat.create(0.1f, 0.0f, 0.9f, 1.0f));
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(p…f, 0.9f, 1.0f))\n        }");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(dialogAnimateInterface.getRootView(), "backgroundColor", new int[]{ResourceHelper.getColor(R.color.customer_color_0025262D), ResourceHelper.getColor(R.color.customer_color_9925262D)});
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setInterpolator(PathInterpolatorCompat.create(1.0f, 0.0f, 0.95f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2, ofInt});
        animatorSet.setDuration(300);
        animatorSet.addListener(new PopDialogAnimateHelper$appearDialogWithAnimate$animatorSet$1$1(dialogAnimateInterface));
        animatorSet.start();
    }

    @JvmStatic
    public static final void disAppearDialogWithAnimate(DialogAnimateInterface dialogAnimateInterface) {
        Intrinsics.checkNotNullParameter(dialogAnimateInterface, "popView");
        Interpolator create = PathInterpolatorCompat.create(0.75f, 0.0f, 0.67f, 1.0f);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(dialogAnimateInterface.getContentView(), new PropertyValuesHolder[]{ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(p…entView(),scaleX, scaleY)");
        ofPropertyValuesHolder.setInterpolator(create);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(dialogAnimateInterface.getContentView(), new PropertyValuesHolder[]{ofFloat3});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(p….getContentView(), alpha)");
        ObjectAnimator ofInt = ObjectAnimator.ofInt(dialogAnimateInterface.getRootView(), "backgroundColor", new int[]{ResourceHelper.getColor(R.color.customer_color_9925262D), ResourceHelper.getColor(R.color.customer_color_0025262D)});
        ofInt.setEvaluator(new ArgbEvaluator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder2, ofInt});
        animatorSet.setDuration(100);
        animatorSet.addListener(new C13639x2a9184cf(dialogAnimateInterface));
        animatorSet.start();
    }
}
