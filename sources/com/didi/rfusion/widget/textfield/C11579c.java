package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.animation.RFAnimatorSetCompat;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.rfusion.widget.textfield.c */
/* compiled from: RFIndicatorViewController */
final class C11579c {

    /* renamed from: a */
    static final int f33888a = 0;

    /* renamed from: b */
    static final int f33889b = 1;

    /* renamed from: c */
    static final int f33890c = 2;

    /* renamed from: d */
    private static final int f33891d = 217;

    /* renamed from: e */
    private static final int f33892e = 167;

    /* renamed from: f */
    private static final int f33893f = 0;

    /* renamed from: g */
    private static final int f33894g = 1;

    /* renamed from: h */
    private static final int f33895h = 2;

    /* renamed from: A */
    private int f33896A;

    /* renamed from: B */
    private ColorStateList f33897B;

    /* renamed from: C */
    private Typeface f33898C;

    /* renamed from: i */
    private final Context f33899i;

    /* renamed from: j */
    private final RFTextInputLayout f33900j;

    /* renamed from: k */
    private LinearLayout f33901k;

    /* renamed from: l */
    private int f33902l;

    /* renamed from: m */
    private FrameLayout f33903m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator f33904n;

    /* renamed from: o */
    private final float f33905o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f33906p;

    /* renamed from: q */
    private int f33907q;

    /* renamed from: r */
    private CharSequence f33908r;

    /* renamed from: s */
    private boolean f33909s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public RFTextView f33910t;

    /* renamed from: u */
    private CharSequence f33911u;

    /* renamed from: v */
    private int f33912v;

    /* renamed from: w */
    private ColorStateList f33913w;

    /* renamed from: x */
    private CharSequence f33914x;

    /* renamed from: y */
    private boolean f33915y;

    /* renamed from: z */
    private RFTextView f33916z;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo88396a(int i) {
        return i == 0 || i == 1;
    }

    public C11579c(RFTextInputLayout rFTextInputLayout) {
        Context context = rFTextInputLayout.getContext();
        this.f33899i = context;
        this.f33900j = rFTextInputLayout;
        this.f33905o = RFResUtils.getDimens(context, R.dimen.rf_dimen_5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88394a(CharSequence charSequence) {
        mo88403c();
        this.f33914x = charSequence;
        this.f33916z.setText(charSequence);
        if (this.f33906p != 2) {
            this.f33907q = 2;
        }
        m23891a(this.f33906p, this.f33907q, m23895a((TextView) this.f33916z, charSequence));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88390a() {
        mo88403c();
        if (this.f33906p == 2) {
            this.f33907q = 0;
        }
        m23891a(this.f33906p, this.f33907q, m23895a((TextView) this.f33916z, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88401b(CharSequence charSequence) {
        mo88403c();
        this.f33908r = charSequence;
        this.f33910t.setText(charSequence);
        if (this.f33906p != 1) {
            this.f33907q = 1;
        }
        m23891a(this.f33906p, this.f33907q, m23895a((TextView) this.f33910t, charSequence));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88397b() {
        this.f33908r = null;
        mo88403c();
        if (this.f33906p == 1) {
            if (!this.f33915y || TextUtils.isEmpty(this.f33914x)) {
                this.f33907q = 0;
            } else {
                this.f33907q = 2;
            }
        }
        m23891a(this.f33906p, this.f33907q, m23895a((TextView) this.f33910t, (CharSequence) null));
    }

    /* renamed from: a */
    private boolean m23895a(TextView textView, CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f33900j) && this.f33900j.isEnabled() && (this.f33907q != this.f33906p || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: a */
    private void m23891a(int i, int i2, boolean z) {
        boolean z2 = z;
        if (i != i2) {
            if (z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f33904n = animatorSet;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = arrayList;
                int i3 = i;
                int i4 = i2;
                m23894a(arrayList2, this.f33915y, this.f33916z, 2, i3, i4);
                m23894a(arrayList2, this.f33909s, this.f33910t, 1, i3, i4);
                RFAnimatorSetCompat.playTogether(animatorSet, arrayList);
                animatorSet.addListener(new RFIndicatorViewController$1(this, i2, m23896d(i), i, m23896d(i2)));
                animatorSet.start();
            } else {
                m23890a(i, i2);
            }
            this.f33900j.mo88272a();
            this.f33900j.mo88278a(z2);
            this.f33900j.mo88289e();
        }
    }

    /* renamed from: a */
    private void m23890a(int i, int i2) {
        TextView d;
        TextView d2;
        if (i != i2) {
            if (!(i2 == 0 || (d2 = m23896d(i2)) == null)) {
                d2.setVisibility(0);
                d2.setAlpha(1.0f);
            }
            if (!(i == 0 || (d = m23896d(i)) == null)) {
                d.setVisibility(4);
                if (i == 1) {
                    d.setText((CharSequence) null);
                }
            }
            this.f33906p = i2;
        }
    }

    /* renamed from: a */
    private void m23894a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                list.add(m23888a(textView, i3 == i));
                if (i3 == i) {
                    list.add(m23887a(textView));
                }
            }
        }
    }

    /* renamed from: a */
    private ObjectAnimator m23888a(TextView textView, boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{z ? 1.0f : 0.0f});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    /* renamed from: a */
    private ObjectAnimator m23887a(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f33905o, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(RFAnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo88403c() {
        Animator animator = this.f33904n;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: d */
    private TextView m23896d(int i) {
        if (i == 1) {
            return this.f33910t;
        }
        if (i != 2) {
            return null;
        }
        return this.f33916z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo88406d() {
        if (m23899r()) {
            this.f33900j.getEditText();
            ViewCompat.setPaddingRelative(this.f33901k, 0, (int) RFResUtils.getDimens(this.f33899i, R.dimen.rf_dimen_20), 0, 0);
        }
    }

    /* renamed from: r */
    private boolean m23899r() {
        return (this.f33901k == null || this.f33900j.getEditText() == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88393a(TextView textView, int i) {
        if (this.f33901k == null && this.f33903m == null) {
            LinearLayout linearLayout = new LinearLayout(this.f33899i);
            this.f33901k = linearLayout;
            linearLayout.setOrientation(0);
            this.f33900j.addView(this.f33901k, -1, -2);
            this.f33903m = new FrameLayout(this.f33899i);
            this.f33901k.addView(this.f33903m, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f33900j.getEditText() != null) {
                mo88406d();
            }
        }
        if (mo88396a(i)) {
            this.f33903m.setVisibility(0);
            this.f33903m.addView(textView);
        } else {
            this.f33901k.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f33901k.setVisibility(0);
        this.f33902l++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88400b(TextView textView, int i) {
        FrameLayout frameLayout;
        if (this.f33901k != null) {
            if (!mo88396a(i) || (frameLayout = this.f33903m) == null) {
                this.f33901k.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i2 = this.f33902l - 1;
            this.f33902l = i2;
            m23892a((ViewGroup) this.f33901k, i2);
        }
    }

    /* renamed from: a */
    private void m23892a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88395a(boolean z) {
        if (this.f33909s != z) {
            mo88403c();
            if (z) {
                this.f33910t = new RFTextView(this.f33899i);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f33910t.setTextAlignment(5);
                }
                Typeface typeface = this.f33898C;
                if (typeface != null) {
                    this.f33910t.setTypeface(typeface);
                }
                mo88398b(this.f33912v);
                mo88391a(this.f33913w);
                mo88405c(this.f33911u);
                this.f33910t.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f33910t, 1);
                mo88393a((TextView) this.f33910t, 0);
            } else {
                mo88397b();
                mo88400b(this.f33910t, 0);
                this.f33910t = null;
                this.f33900j.mo88272a();
                this.f33900j.mo88289e();
            }
            this.f33909s = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo88407e() {
        return this.f33909s;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo88408f() {
        return this.f33915y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88402b(boolean z) {
        if (this.f33915y != z) {
            mo88403c();
            if (z) {
                this.f33916z = new RFTextView(this.f33899i);
                if (Build.VERSION.SDK_INT >= 17) {
                    this.f33916z.setTextAlignment(5);
                }
                Typeface typeface = this.f33898C;
                if (typeface != null) {
                    this.f33916z.setTypeface(typeface);
                }
                this.f33916z.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.f33916z, 1);
                mo88404c(this.f33896A);
                mo88399b(this.f33897B);
                mo88393a((TextView) this.f33916z, 1);
            } else {
                mo88390a();
                mo88400b(this.f33916z, 1);
                this.f33916z = null;
                this.f33900j.mo88272a();
                this.f33900j.mo88289e();
            }
            this.f33915y = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo88409g() {
        return m23897e(this.f33906p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo88410h() {
        return m23897e(this.f33907q);
    }

    /* renamed from: e */
    private boolean m23897e(int i) {
        if (i != 1 || this.f33910t == null || TextUtils.isEmpty(this.f33908r)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo88411i() {
        return m23898f(this.f33906p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public boolean mo88412j() {
        return m23898f(this.f33907q);
    }

    /* renamed from: f */
    private boolean m23898f(int i) {
        return i == 2 && this.f33916z != null && !TextUtils.isEmpty(this.f33914x);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public CharSequence mo88413k() {
        return this.f33908r;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public CharSequence mo88414l() {
        return this.f33914x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88392a(Typeface typeface) {
        if (typeface != this.f33898C) {
            this.f33898C = typeface;
            m23893a((TextView) this.f33910t, typeface);
            m23893a((TextView) this.f33916z, typeface);
        }
    }

    /* renamed from: a */
    private void m23893a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public int mo88415m() {
        RFTextView rFTextView = this.f33910t;
        if (rFTextView != null) {
            return rFTextView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public ColorStateList mo88416n() {
        RFTextView rFTextView = this.f33910t;
        if (rFTextView != null) {
            return rFTextView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo88391a(ColorStateList colorStateList) {
        this.f33913w = colorStateList;
        RFTextView rFTextView = this.f33910t;
        if (rFTextView != null && colorStateList != null) {
            rFTextView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88398b(int i) {
        this.f33912v = i;
        RFTextView rFTextView = this.f33910t;
        if (rFTextView != null) {
            this.f33900j.mo88275a(rFTextView, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo88405c(CharSequence charSequence) {
        this.f33911u = charSequence;
        RFTextView rFTextView = this.f33910t;
        if (rFTextView != null) {
            rFTextView.setContentDescription(charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public CharSequence mo88417o() {
        return this.f33911u;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public int mo88418p() {
        RFTextView rFTextView = this.f33916z;
        if (rFTextView != null) {
            return rFTextView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public ColorStateList mo88419q() {
        RFTextView rFTextView = this.f33916z;
        if (rFTextView != null) {
            return rFTextView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo88399b(ColorStateList colorStateList) {
        this.f33897B = colorStateList;
        RFTextView rFTextView = this.f33916z;
        if (rFTextView != null && colorStateList != null) {
            rFTextView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo88404c(int i) {
        this.f33896A = i;
        RFTextView rFTextView = this.f33916z;
        if (rFTextView != null) {
            TextViewCompat.setTextAppearance(rFTextView, i);
            this.f33916z.setTypeface(1);
        }
    }
}
