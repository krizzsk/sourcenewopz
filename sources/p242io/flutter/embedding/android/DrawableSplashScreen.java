package p242io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import p242io.flutter.embedding.android.SplashScreen;

@Deprecated
/* renamed from: io.flutter.embedding.android.DrawableSplashScreen */
public final class DrawableSplashScreen implements SplashScreen {

    /* renamed from: a */
    private final Drawable f57353a;

    /* renamed from: b */
    private final ImageView.ScaleType f57354b;

    /* renamed from: c */
    private final long f57355c;

    /* renamed from: d */
    private DrawableSplashScreenView f57356d;

    public /* synthetic */ boolean doesSplashViewRememberItsTransition() {
        return SplashScreen.CC.$default$doesSplashViewRememberItsTransition(this);
    }

    public /* synthetic */ Bundle saveSplashScreenState() {
        return SplashScreen.CC.$default$saveSplashScreenState(this);
    }

    public DrawableSplashScreen(Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500);
    }

    public DrawableSplashScreen(Drawable drawable, ImageView.ScaleType scaleType, long j) {
        this.f57353a = drawable;
        this.f57354b = scaleType;
        this.f57355c = j;
    }

    public View createSplashView(Context context, Bundle bundle) {
        DrawableSplashScreenView drawableSplashScreenView = new DrawableSplashScreenView(context);
        this.f57356d = drawableSplashScreenView;
        drawableSplashScreenView.setSplashDrawable(this.f57353a, this.f57354b);
        return this.f57356d;
    }

    public void transitionToFlutter(final Runnable runnable) {
        DrawableSplashScreenView drawableSplashScreenView = this.f57356d;
        if (drawableSplashScreenView == null) {
            runnable.run();
        } else {
            drawableSplashScreenView.animate().alpha(0.0f).setDuration(this.f57355c).setListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }

                public void onAnimationCancel(Animator animator) {
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: io.flutter.embedding.android.DrawableSplashScreen$DrawableSplashScreenView */
    public static class DrawableSplashScreenView extends ImageView {
        public DrawableSplashScreenView(Context context) {
            this(context, (AttributeSet) null, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        public DrawableSplashScreenView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        public void setSplashDrawable(Drawable drawable) {
            setSplashDrawable(drawable, ImageView.ScaleType.FIT_XY);
        }

        public void setSplashDrawable(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }
    }
}
