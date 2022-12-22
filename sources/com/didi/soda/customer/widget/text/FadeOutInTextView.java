package com.didi.soda.customer.widget.text;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.soda.customer.animation.CustomerInterpolator;

public class FadeOutInTextView extends RichTextView {

    /* renamed from: a */
    private AnimatorSet f42232a;

    public FadeOutInTextView(Context context) {
        super(context);
        m29773a();
    }

    public FadeOutInTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29773a();
    }

    public FadeOutInTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m29773a();
    }

    public void showTextOnAnim(CharSequence charSequence) {
        CharSequence text = getText();
        if (TextUtils.isEmpty(text) || text.equals(charSequence)) {
            super.setText(charSequence);
        } else {
            m29774a(text, charSequence);
        }
    }

    /* renamed from: a */
    private void m29774a(final CharSequence charSequence, final CharSequence charSequence2) {
        if (!this.f42232a.isRunning()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f});
            ofFloat.setDuration(100);
            ofFloat2.setDuration(100);
            ofFloat.setInterpolator(getInterpolator());
            ofFloat2.setInterpolator(getInterpolator());
            ofFloat.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    this.setText(charSequence2);
                }

                public void onAnimationStart(Animator animator) {
                    this.setText(charSequence);
                }
            });
            this.f42232a.play(ofFloat2).after(ofFloat);
            this.f42232a.start();
        }
    }

    private TimeInterpolator getInterpolator() {
        return CustomerInterpolator.newInstance();
    }

    /* renamed from: a */
    private void m29773a() {
        this.f42232a = new AnimatorSet();
    }
}
