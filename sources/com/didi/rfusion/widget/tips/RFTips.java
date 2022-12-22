package com.didi.rfusion.widget.tips;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.rfusion.utils.RFDisplayUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFTips extends FrameLayout {

    /* renamed from: a */
    private static final String f33930a = "RFTips";

    /* renamed from: b */
    private ImageView f33931b;

    /* renamed from: c */
    private RFTextView f33932c;

    /* renamed from: d */
    private RFIconView f33933d;

    /* renamed from: e */
    private ObjectAnimator f33934e;

    /* renamed from: f */
    private ObjectAnimator f33935f;

    /* renamed from: g */
    private ObjectAnimator f33936g;

    /* renamed from: h */
    private int f33937h;

    /* renamed from: i */
    private boolean f33938i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f33939j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f33940k;

    /* renamed from: l */
    private int f33941l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public OnTransitionListener f33942m;

    interface OnTransitionListener {
        void onTipsHide();

        void onTipsShow();
    }

    public RFTips(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTips(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFTips(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33937h = 0;
        this.f33938i = false;
        this.f33939j = true;
        this.f33940k = false;
        this.f33941l = 0;
        m23945a();
        m23948b();
        m23951c();
        m23952d();
    }

    /* renamed from: a */
    private void m23945a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_tips, this);
        this.f33931b = (ImageView) findViewById(R.id.rf_iv_icon);
        this.f33932c = (RFTextView) findViewById(R.id.rf_tv_content);
        this.f33933d = (RFIconView) findViewById(R.id.rf_iv_close);
        post(new Runnable() {
            public final void run() {
                RFTips.this.m23963l();
            }
        });
        setArrowLocation(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m23963l() {
        Rect rect = new Rect();
        this.f33933d.getHitRect(rect);
        setTouchDelegate(new TouchDelegate(new Rect(rect.left - ((int) RFResUtils.getDimens(R.dimen.rf_tips_close_margin_left)), rect.top - ((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_height)), rect.right + (((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_width)) * 2), rect.bottom + (((int) RFResUtils.getDimens(R.dimen.rf_tips_padding_width)) * 2)), this.f33933d));
    }

    /* renamed from: b */
    private void m23948b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, (float) (-RFDisplayUtils.dp2px(5.0f)), 0.0f})});
        this.f33934e = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setRepeatCount(-1);
        this.f33934e.setRepeatMode(2);
        Path path = new Path();
        path.quadTo(0.19f, 0.5f, 0.33f, 0.5f);
        path.cubicTo(0.5f, 0.55f, 0.5f, 1.0f, 1.0f, 1.0f);
        this.f33934e.setInterpolator(PathInterpolatorCompat.create(path));
        this.f33934e.setDuration(900);
        this.f33934e.setStartDelay(400);
    }

    /* renamed from: c */
    private void m23951c() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.0f, 1.0f}), ofFloat});
        this.f33935f = ofPropertyValuesHolder;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (RFTips.this.f33940k) {
                    RFTips.this.m23954e();
                }
                if (RFTips.this.f33942m != null) {
                    RFTips.this.f33942m.onTipsShow();
                }
            }
        });
        this.f33935f.setDuration(300);
        this.f33935f.setInterpolator(decelerateInterpolator);
    }

    /* renamed from: d */
    private void m23952d() {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{1.0f, 0.0f}), ofFloat});
        this.f33936g = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(300);
        this.f33936g.setInterpolator(decelerateInterpolator);
        this.f33936g.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                RFTips.this.m23956f();
                RFTips.super.setVisibility(8);
                if (RFTips.this.f33942m != null) {
                    RFTips.this.f33942m.onTipsHide();
                }
            }
        });
    }

    public void setIcon(int i) {
        this.f33931b.setVisibility(0);
        this.f33931b.setImageDrawable(RFResUtils.getDrawable(i));
    }

    public void setIcon(Drawable drawable) {
        if (drawable == null) {
            this.f33931b.setVisibility(8);
            return;
        }
        this.f33931b.setVisibility(0);
        this.f33931b.setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f33938i = true;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                RFTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RFTips.this.f33939j && RFTips.this.getVisibility() == 0) {
                    RFTips.this.m23960i();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f33935f.isRunning()) {
            this.f33935f.end();
        }
        if (this.f33936g.isRunning()) {
            this.f33936g.end();
        }
        m23956f();
        this.f33938i = false;
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        if (i == 0) {
            m23959h();
        } else {
            m23958g();
        }
    }

    public void setVisibility(int i) {
        if (getVisibility() != i) {
            if (!this.f33938i || !this.f33939j) {
                super.setVisibility(i);
            } else if (i == 0) {
                m23960i();
            } else if (i == 8) {
                m23961j();
            } else {
                super.setVisibility(i);
            }
        }
    }

    public void setIconVisible(boolean z) {
        this.f33931b.setVisibility(z ? 0 : 8);
    }

    public void setText(int i) {
        this.f33932c.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f33932c.setText(charSequence);
    }

    public void setType(int i) {
        if (this.f33941l != i) {
            this.f33941l = i;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.f33932c.setTextColor(RFResUtils.getColor(z ? R.color.rf_color_white_100_FFFFFF : R.color.rf_color_gery_1_0_000000));
            this.f33933d.setTextColor(RFResUtils.getColor(z ? R.color.rf_selector_tips_close_dark : R.color.rf_selector_tips_close));
            setArrowLocation(this.f33937h);
        }
    }

    public void setArrowLocation(int i) {
        this.f33937h = i;
        boolean z = this.f33941l == 1;
        if (i == 0) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_center_dark : R.drawable.rf_bg_tip_top_center);
        } else if (i == 1) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_left_dark : R.drawable.rf_bg_tip_top_left);
        } else if (i == 2) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_top_right_dark : R.drawable.rf_bg_tip_top_right);
        } else if (i == 3) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_center_dark : R.drawable.rf_bg_tip_bottom_center);
        } else if (i == 4) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_left_dark : R.drawable.rf_bg_tip_bottom_left);
        } else if (i == 5) {
            setBackgroundResource(z ? R.drawable.rf_bg_tip_bottom_right_dark : R.drawable.rf_bg_tip_bottom_right);
        }
    }

    public void setEnableTransition(boolean z) {
        this.f33939j = z;
    }

    public void startShake() {
        this.f33940k = true;
        m23954e();
    }

    public void stopShake() {
        this.f33940k = false;
        m23956f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m23954e() {
        if (!this.f33934e.isRunning() && this.f33938i) {
            this.f33934e.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m23956f() {
        if (this.f33934e.isRunning()) {
            this.f33934e.end();
        }
    }

    /* renamed from: g */
    private void m23958g() {
        if (this.f33934e.isRunning()) {
            this.f33934e.pause();
        }
    }

    /* renamed from: h */
    private void m23959h() {
        if (this.f33934e.isPaused()) {
            this.f33934e.resume();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m23960i() {
        if (this.f33936g.isRunning()) {
            this.f33936g.end();
        }
        super.setVisibility(0);
        m23962k();
        this.f33935f.start();
    }

    /* renamed from: j */
    private void m23961j() {
        if (this.f33935f.isRunning()) {
            this.f33935f.end();
        }
        m23962k();
        this.f33936g.start();
    }

    /* renamed from: k */
    private void m23962k() {
        int i;
        int i2;
        int i3 = this.f33937h;
        int i4 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i4 = getMeasuredWidth() / 2;
                    i = getMeasuredHeight();
                } else if (i3 == 4) {
                    i = getMeasuredHeight();
                } else if (i3 != 5) {
                    i2 = getMeasuredWidth() / 2;
                } else {
                    i4 = getMeasuredWidth();
                    i = getMeasuredHeight();
                }
                setPivotX((float) i4);
                setPivotY((float) i);
            }
            i2 = getMeasuredWidth();
            i4 = i2;
        }
        i = 0;
        setPivotX((float) i4);
        setPivotY((float) i);
    }

    public void setOnCloseListener(View.OnClickListener onClickListener) {
        this.f33933d.setOnClickListener(onClickListener);
        this.f33933d.setVisibility(onClickListener != null ? 0 : 8);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionListener(OnTransitionListener onTransitionListener) {
        this.f33942m = onTransitionListener;
    }
}
