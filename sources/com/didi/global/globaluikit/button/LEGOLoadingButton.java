package com.didi.global.globaluikit.button;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.passenger.C10448R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class LEGOLoadingButton extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f22347a = LEGOLoadingButton.class.getSimpleName();

    /* renamed from: b */
    private Context f22348b;

    /* renamed from: c */
    private String f22349c;

    /* renamed from: d */
    private ColorStateList f22350d;

    /* renamed from: e */
    private int f22351e;

    /* renamed from: f */
    private String f22352f;

    /* renamed from: g */
    private int f22353g;

    /* renamed from: h */
    private Drawable f22354h;

    /* renamed from: i */
    private View f22355i;

    /* renamed from: j */
    private FrameLayout f22356j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextView f22357k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LottieAnimationView f22358l;

    /* renamed from: m */
    private boolean f22359m;

    /* renamed from: n */
    private int f22360n;

    /* renamed from: o */
    private ValueAnimator f22361o;

    /* renamed from: p */
    private ObjectAnimator f22362p;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LoadingLottieAssertRes {
        public static final String _99_button_loading_main_json = "_99_button_loading_main_json.json";
        public static final String _global_button_loading_main_json = "_global_button_loading_main_json.json";
        public static final String button_loading_secondary_json = "button_loading_secondary_json.json";
    }

    public LEGOLoadingButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOLoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOLoadingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22359m = false;
        this.f22360n = 0;
        this.f22348b = context;
        setLayerType(1, (Paint) null);
        m16117a(context, attributeSet);
        m16119b();
    }

    /* renamed from: a */
    private void m16117a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.LEGOLoadingButton);
        this.f22352f = obtainStyledAttributes.getString(1);
        this.f22353g = obtainStyledAttributes.getResourceId(2, 0);
        this.f22349c = obtainStyledAttributes.getString(3);
        this.f22350d = obtainStyledAttributes.getColorStateList(4);
        this.f22351e = (int) obtainStyledAttributes.getDimension(5, 0.0f);
        this.f22354h = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private void m16119b() {
        View inflate = LayoutInflater.from(this.f22348b).inflate(R.layout.globaluikit_button_layout, this, false);
        this.f22355i = inflate;
        this.f22356j = (FrameLayout) inflate.findViewById(R.id.globaluikit_btn_root);
        this.f22357k = (TextView) this.f22355i.findViewById(R.id.globaluikit_btn_text);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f22355i.findViewById(R.id.globaluikit_btn_lav);
        this.f22358l = lottieAnimationView;
        lottieAnimationView.setRepeatCount(-1);
        if (!TextUtils.isEmpty(this.f22352f)) {
            this.f22358l.setAnimation(this.f22352f);
        } else {
            int i = this.f22353g;
            if (i != 0) {
                this.f22358l.setAnimation(i);
            }
        }
        setButtonText(this.f22349c);
        setButtonTextColor(this.f22350d);
        setButtonTextSize((float) UnitUtils.px2sp(this.f22348b, (float) this.f22351e));
        setButtonBackground(this.f22354h);
        setBackground(this.f22354h);
        addView(this.f22355i);
    }

    public void setLoading(boolean z) {
        if (this.f22359m != z) {
            String str = f22347a;
            SystemUtils.log(3, str, "setLoading: isLoading " + this.f22359m + " loading " + z, (Throwable) null, "com.didi.global.globaluikit.button.LEGOLoadingButton", 306);
            if (z) {
                int textSize = (int) this.f22357k.getTextSize();
                this.f22360n = textSize;
                ValueAnimator duration = ValueAnimator.ofInt(new int[]{textSize, textSize / 2}).setDuration(500);
                this.f22361o = duration;
                duration.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
                this.f22361o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        String a = LEGOLoadingButton.f22347a;
                        SystemUtils.log(3, a, "onAnimationUpdate: size -> " + intValue, (Throwable) null, "com.didi.global.globaluikit.button.LEGOLoadingButton$1", 320);
                        LEGOLoadingButton.this.f22357k.setTextSize(0, (float) intValue);
                    }
                });
                this.f22361o.start();
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.f22357k, "alpha", new float[]{1.0f, 0.0f}).setDuration(500);
                this.f22362p = duration2;
                duration2.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
                this.f22362p.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationEnd(Animator animator) {
                        LEGOLoadingButton.this.f22358l.setVisibility(0);
                        LEGOLoadingButton.this.f22358l.playAnimation();
                    }
                });
                this.f22362p.start();
            } else {
                ValueAnimator valueAnimator = this.f22361o;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f22361o.cancel();
                }
                ObjectAnimator objectAnimator = this.f22362p;
                if (objectAnimator != null && objectAnimator.isRunning()) {
                    this.f22362p.cancel();
                }
                if (this.f22358l.isAnimating()) {
                    this.f22358l.cancelAnimation();
                    this.f22358l.setVisibility(8);
                }
                this.f22357k.setTextSize(0, (float) this.f22360n);
                this.f22357k.setAlpha(1.0f);
            }
            this.f22359m = z;
        }
    }

    public void setLottieRes(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f22358l.setAnimation(str);
        }
    }

    public void setLottieRawRes(int i) {
        if (i != 0) {
            this.f22358l.setAnimation(i);
        }
    }

    public void setButtonText(String str) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setButtonBackground(Drawable drawable) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setBackground(drawable);
        }
        setBackground(drawable);
    }

    public void setButtonEnable(boolean z) {
        if (!this.f22359m || !z) {
            TextView textView = this.f22357k;
            if (textView != null) {
                textView.setEnabled(z);
            }
            setEnabled(z);
        }
    }

    public void setButtonClickable(boolean z) {
        if (!this.f22359m || !z) {
            TextView textView = this.f22357k;
            if (textView != null) {
                textView.setClickable(z);
            }
            setClickable(z);
        }
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setButtonTextSize(float f) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setTextSize(f);
            this.f22360n = (int) this.f22357k.getTextSize();
        }
    }

    public void setButtonTextStyle(Typeface typeface, int i) {
        TextView textView = this.f22357k;
        if (textView != null) {
            textView.setTypeface(typeface, i);
        }
    }
}
