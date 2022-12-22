package com.didi.soda.bill.view.item.logic;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.util.DisplayUtils;
import java.util.ArrayList;

public class CartCouponAnimHelper {
    public static final String FOLLOW_TAG = "follow_tag";

    /* renamed from: a */
    private static ArrayList<String> f39247a = new ArrayList<>();
    public static boolean sLastFollowSelect = false;

    public static void showCouponSelectAnim(View view, final ImageView imageView) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.3f, 1.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 1.5f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 1.5f, 1.0f})});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedFraction() >= 0.5f) {
                    imageView.setSelected(true);
                    imageView.setAlpha(Math.abs(valueAnimator.getAnimatedFraction() - 0.5f) * 2.0f);
                    return;
                }
                imageView.setAlpha(0.0f);
                imageView.setSelected(false);
            }
        });
        ofPropertyValuesHolder.start();
    }

    public static void showCouponIconAnim(RecyclerView recyclerView, String str) {
        View findViewWithTag;
        if (!isCouponIconAnimShow(str) && (findViewWithTag = recyclerView.findViewWithTag(FOLLOW_TAG)) != null && findViewWithTag.isShown()) {
            int[] iArr = new int[2];
            findViewWithTag.getLocationOnScreen(iArr);
            Context context = findViewWithTag.getContext();
            if (iArr[1] <= DisplayUtils.getScreenHeight(context) - DisplayUtils.dip2px(context, 140.0f) && (findViewWithTag.getBackground() instanceof AnimationDrawable)) {
                ((AnimationDrawable) findViewWithTag.getBackground()).start();
                f39247a.add(str);
                findViewWithTag.setTag((Object) null);
            }
        }
    }

    public static boolean isCouponIconAnimShow(String str) {
        return f39247a.contains(str);
    }
}
