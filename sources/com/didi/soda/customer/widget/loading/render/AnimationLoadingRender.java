package com.didi.soda.customer.widget.loading.render;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.soda.customer.widget.loading.ILoadingRender;

public abstract class AnimationLoadingRender extends BaseLoadingRender implements Animator.AnimatorListener {
    public static final String IMAGE_DRAWABLE_ID = "Loading::Animation::Image::Drawable::Id";

    /* renamed from: b */
    private ValueAnimator f42092b;
    protected Drawable mAnimationDrawable;
    protected ImageView mAnimationView;

    /* access modifiers changed from: protected */
    public abstract void computeRender(float f);

    /* access modifiers changed from: protected */
    public abstract void draw(Canvas canvas, Rect rect);

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public boolean isRunning() {
        return this.f42092b.isRunning();
    }

    public View onCreateView(Context context, Bundle bundle) {
        this.mAnimationView = createImageView(context);
        this.mAnimationDrawable = createImageDrawable(context, bundle);
        this.mAnimationView.setBackgroundColor(bundle.getInt("Loading::Background::Color", 0));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f42092b = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.f42092b.setRepeatMode(1);
        this.f42092b.setDuration(bundle.getLong("Loading::Duration", 1200));
        this.f42092b.setInterpolator(AnimationUtils.loadInterpolator(context, bundle.getInt("Loading::Interpolator::Id", 17563659)));
        this.f42092b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationLoadingRender.this.computeRender(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AnimationLoadingRender.this.m29690a();
            }
        });
        this.f42092b.addListener(this);
        return this.mAnimationView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.onLayoutView(view, viewGroup, viewGroup2);
        this.mAnimationView.setImageDrawable(this.mAnimationDrawable);
    }

    public void onStartLoading() {
        this.f42092b.start();
    }

    public void onStopLoading() {
        this.f42092b.cancel();
    }

    /* access modifiers changed from: protected */
    public ImageView createImageView(Context context) {
        return new LoadingImageView(context);
    }

    /* access modifiers changed from: protected */
    public Drawable createImageDrawable(Context context, Bundle bundle) {
        return new LoadingDrawable(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29690a() {
        for (ILoadingRender.Callback invalidateDrawable : this.f42093a) {
            invalidateDrawable.invalidateDrawable(this.mAnimationDrawable);
        }
    }

    class LoadingImageView extends AppCompatImageView {
        LoadingImageView(Context context) {
            super(context);
        }
    }

    class LoadingDrawable extends Drawable implements Animatable {
        private ILoadingRender.Callback mCallback;
        private ILoadingRender mLoadingRender;

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int i) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        LoadingDrawable(ILoadingRender iLoadingRender) {
            C138751 r1 = new ILoadingRender.SimpleCallback() {
                public void invalidateDrawable(Drawable drawable) {
                    super.invalidateDrawable(drawable);
                    LoadingDrawable.this.invalidateSelf();
                }

                public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                    super.scheduleDrawable(drawable, runnable, j);
                    LoadingDrawable.this.scheduleSelf(runnable, j);
                }

                public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                    super.unscheduleDrawable(drawable, runnable);
                    LoadingDrawable.this.unscheduleSelf(runnable);
                }
            };
            this.mCallback = r1;
            this.mLoadingRender = iLoadingRender;
            iLoadingRender.addCallback(r1);
        }

        public void draw(Canvas canvas) {
            if (!getBounds().isEmpty()) {
                ILoadingRender iLoadingRender = this.mLoadingRender;
                if (iLoadingRender instanceof AnimationLoadingRender) {
                    ((AnimationLoadingRender) iLoadingRender).draw(canvas, getBounds());
                }
            }
        }

        public int getIntrinsicHeight() {
            return this.mLoadingRender.getBorder().height();
        }

        public int getIntrinsicWidth() {
            return this.mLoadingRender.getBorder().width();
        }

        public boolean isRunning() {
            return this.mLoadingRender.isRunning();
        }

        public void start() {
            this.mLoadingRender.start();
        }

        public void stop() {
            this.mLoadingRender.stop();
        }
    }
}
