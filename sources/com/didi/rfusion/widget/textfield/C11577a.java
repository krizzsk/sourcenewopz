package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.widget.textfield.RFTextInputLayout;

/* renamed from: com.didi.rfusion.widget.textfield.a */
/* compiled from: RFClearTextEndIconDelegate */
class C11577a extends C11578b {

    /* renamed from: c */
    private static final int f33877c = 100;

    /* renamed from: d */
    private static final int f33878d = 150;

    /* renamed from: e */
    private static final float f33879e = 0.8f;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final TextWatcher f33880f = new RFClearTextEndIconDelegate$1(this);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final View.OnFocusChangeListener f33881g = new RFClearTextEndIconDelegate$2(this);

    /* renamed from: h */
    private final RFTextInputLayout.OnEditTextAttachedListener f33882h = new RFClearTextEndIconDelegate$3(this);

    /* renamed from: i */
    private AnimatorSet f33883i;

    /* renamed from: j */
    private ValueAnimator f33884j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public RFCheckableIconButton f33885k;

    C11577a(RFTextInputLayout rFTextInputLayout) {
        super(rFTextInputLayout);
        this.f33885k = rFTextInputLayout.getClearIcon();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88388a() {
        this.f33886a.setClearIconOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                C11577a.this.m23873a(view);
            }
        });
        this.f33886a.addOnEditTextAttachedListener(this.f33882h);
        m23880c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23873a(View view) {
        Editable text = this.f33886a.getEditText().getText();
        if (text != null) {
            text.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88389b() {
        EditText editText = this.f33886a.getEditText();
        if (editText != null) {
            editText.post(new RFClearTextEndIconDelegate$4(this, editText));
            if (editText.getOnFocusChangeListener() == this.f33881g) {
                editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23875a(boolean z) {
        boolean z2 = this.f33886a.isEnableClearText() == z;
        if (z && !this.f33883i.isRunning()) {
            this.f33884j.cancel();
            this.f33883i.start();
            if (z2) {
                this.f33883i.end();
            }
        } else if (!z) {
            this.f33883i.cancel();
            this.f33884j.start();
            if (z2) {
                this.f33884j.end();
            }
        }
    }

    /* renamed from: c */
    private void m23880c() {
        ValueAnimator d = m23881d();
        ValueAnimator a = m23871a(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f33883i = animatorSet;
        animatorSet.playTogether(new Animator[]{d, a});
        this.f33883i.addListener(new RFClearTextEndIconDelegate$5(this));
        ValueAnimator a2 = m23871a(1.0f, 0.0f);
        this.f33884j = a2;
        a2.addListener(new RFClearTextEndIconDelegate$6(this));
    }

    /* renamed from: a */
    private ValueAnimator m23871a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new RFClearTextEndIconDelegate$7(this));
        return ofFloat;
    }

    /* renamed from: d */
    private ValueAnimator m23881d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new RFClearTextEndIconDelegate$8(this));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m23878b(Editable editable) {
        return editable.length() > 0;
    }
}
