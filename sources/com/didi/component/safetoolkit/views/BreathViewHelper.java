package com.didi.component.safetoolkit.views;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class BreathViewHelper {
    public static void startBreath(ImageView imageView, ImageView imageView2) {
        if (imageView != null && imageView2 != null) {
            imageView.setVisibility(0);
            imageView2.setVisibility(0);
            startInnerAnimation(imageView);
            startOuterAnimation(imageView2);
        }
    }

    public static void startInnerAnimation(ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        scaleAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatCount(-1);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800);
        imageView.startAnimation(animationSet);
    }

    public static void startOuterAnimation(ImageView imageView) {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.4f, 1.8f, 1.4f, 1.8f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.1f);
        scaleAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatCount(-1);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(800);
        imageView.startAnimation(animationSet);
    }
}
