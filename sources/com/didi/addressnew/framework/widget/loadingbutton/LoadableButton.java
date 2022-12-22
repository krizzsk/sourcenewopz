package com.didi.addressnew.framework.widget.loadingbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.addressnew.framework.widget.DotLoader;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class LoadableButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private TextView f7440a;

    /* renamed from: b */
    private TextView f7441b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DotLoader f7442c;

    /* renamed from: d */
    private boolean f7443d = true;

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public LoadableButton(Context context) {
        super(context);
        m4680a();
    }

    public LoadableButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4680a();
    }

    public LoadableButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4680a();
    }

    /* renamed from: a */
    private void m4680a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.loadable_button, this);
        this.f7440a = (TextView) inflate.findViewById(R.id.bg);
        this.f7441b = (TextView) inflate.findViewById(R.id.text);
        try {
            int resIdByTheme = DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector);
            setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
            this.f7441b.setTextColor(ContextCompat.getColorStateList(getContext(), resIdByTheme));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        DotLoader dotLoader = (DotLoader) inflate.findViewById(R.id.text_dot_loader);
        this.f7442c = dotLoader;
        dotLoader.setVisibility(4);
        this.f7441b.setText("Button");
        setOnClickListener(this);
    }

    /* renamed from: a */
    private void m4681a(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 0.9f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 0.9f, 1.0f});
        ofFloat.setDuration(500);
        ofFloat2.setDuration(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((View) view.getParent()).invalidate();
            }
        });
        animatorSet.start();
    }

    /* renamed from: b */
    private void m4683b(final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 0.7f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 0.7f, 0.0f});
        ofFloat.setDuration(500);
        ofFloat2.setDuration(500);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 1.0f, 0.0f});
        ofFloat3.setDuration(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ((View) view.getParent()).invalidate();
            }
        });
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LoadableButton.this.f7442c.setVisibility(0);
                LoadableButton.this.f7442c.setNumberOfDots(3);
            }
        });
        animatorSet.start();
    }

    /* renamed from: b */
    private void m4682b() {
        this.f7441b.setAlpha(1.0f);
        this.f7441b.setScaleX(1.0f);
        this.f7441b.setScaleY(1.0f);
        ((View) this.f7441b.getParent()).invalidate();
    }

    public void playAnim() {
        m4681a((View) this.f7440a);
        m4683b(this.f7441b);
        this.f7443d = false;
    }

    public void setText(String str) {
        TextView textView = this.f7441b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTextSize(int i) {
        TextView textView = this.f7441b;
        if (textView != null) {
            textView.setTextSize((float) i);
        }
    }

    public void reset() {
        this.f7443d = true;
        this.f7442c.setVisibility(4);
        m4682b();
    }

    public void setBgEnabled(boolean z) {
        this.f7440a.setEnabled(z);
        if (z) {
            setBackgroundResource(R.drawable.load_btn_bg);
        } else {
            setBackgroundResource(R.drawable.button_bg_grey);
        }
    }

    public boolean isReseted() {
        return this.f7443d;
    }

    public void setTextStyle(Typeface typeface) {
        this.f7441b.setTypeface(typeface);
    }

    public DotLoader getDots() {
        return this.f7442c;
    }
}
