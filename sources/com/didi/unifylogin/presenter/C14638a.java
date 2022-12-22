package com.didi.unifylogin.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.customview.AbsLoginTitleBar;
import com.taxis99.R;

/* renamed from: com.didi.unifylogin.presenter.a */
/* compiled from: ViewAnimatorHelper */
final class C14638a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AbsLoginTitleBar f44846a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f44847b;

    /* renamed from: c */
    private final ImageView f44848c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final View f44849d;

    /* renamed from: e */
    private final TextView f44850e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final TextView f44851f;

    /* renamed from: g */
    private final View f44852g;

    /* renamed from: h */
    private final View f44853h;

    /* renamed from: i */
    private final View f44854i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final View f44855j;

    /* renamed from: k */
    private final View f44856k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final View f44857l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final View f44858m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final View f44859n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final View f44860o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public final EditText f44861p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public final View f44862q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final View f44863r;

    /* renamed from: s */
    private AnimatorSet f44864s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public AnimatorSet f44865t;

    C14638a(View view, AbsLoginTitleBar absLoginTitleBar) {
        this.f44846a = absLoginTitleBar;
        this.f44847b = view.findViewById(R.id.ll_scene_pre_container);
        this.f44848c = (ImageView) view.findViewById(R.id.iv_login_pre_bg);
        this.f44849d = view.findViewById(R.id.login_unify_fragment_phone_container);
        this.f44850e = (TextView) view.findViewById(R.id.tv_pre_phone_title);
        this.f44852g = view.findViewById(R.id.fl_pre_phone_container);
        this.f44853h = view.findViewById(R.id.v_pre_line);
        this.f44854i = view.findViewById(R.id.gv_third_party2);
        this.f44855j = view.findViewById(R.id.rl_third_party_hint);
        this.f44856k = view.findViewById(R.id.ll_law2);
        this.f44857l = view.findViewById(R.id.tv_title);
        this.f44858m = view.findViewById(R.id.tv_sub_title);
        this.f44859n = view.findViewById(R.id.rl_phone_container);
        this.f44862q = view.findViewById(R.id.btn_next);
        this.f44861p = (EditText) view.findViewById(R.id.et_phone);
        this.f44860o = view.findViewById(R.id.v_line);
        this.f44863r = view.findViewById(R.id.iv_clear_phone);
        this.f44851f = (TextView) view.findViewById(R.id.et_phone2);
        m32176c();
        m32178d();
    }

    /* renamed from: c */
    private void m32176c() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 0.5f}).setDuration(200);
        duration.addUpdateListener(new ViewAnimatorHelper$1(this));
        duration.addListener(new ViewAnimatorHelper$2(this));
        duration.setInterpolator(new LinearInterpolator());
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f}).setDuration(200);
        duration2.addUpdateListener(new ViewAnimatorHelper$3(this));
        duration2.addListener(new ViewAnimatorHelper$4(this));
        duration2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f44864s = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        this.f44864s.playSequentially(new Animator[]{duration, duration2});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo112756a() {
        this.f44864s.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo112757b() {
        this.f44861p.clearFocus();
        KeyboardHelper.hideInputMethod(this.f44861p.getContext(), this.f44861p);
        this.f44847b.postDelayed(new ViewAnimatorHelper$5(this), 50);
    }

    /* renamed from: d */
    private void m32178d() {
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f}).setDuration(200);
        duration.addUpdateListener(new ViewAnimatorHelper$6(this));
        duration.addListener(new ViewAnimatorHelper$7(this));
        duration.setInterpolator(new LinearInterpolator());
        ValueAnimator duration2 = ValueAnimator.ofFloat(new float[]{0.5f, 0.0f}).setDuration(200);
        duration2.addUpdateListener(new ViewAnimatorHelper$8(this));
        duration2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f44865t = animatorSet;
        animatorSet.setInterpolator(new LinearInterpolator());
        this.f44865t.playSequentially(new Animator[]{duration, duration2});
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32172a(float f) {
        float f2 = 0.0f;
        if (f <= 0.5f) {
            this.f44847b.setTranslationY(((float) (-this.f44848c.getHeight())) * f * 2.0f);
            float f3 = 1.0f - (f * 2.0f);
            if (f3 >= 0.0f) {
                f2 = f3;
            }
            this.f44850e.setAlpha(f2);
            this.f44852g.setAlpha(f2);
            this.f44853h.setAlpha(f2);
            this.f44854i.setAlpha(f2);
            this.f44856k.setAlpha(f2);
            return;
        }
        float f4 = (f - 0.5f) * 2.0f;
        if (f4 >= 0.0f) {
            f2 = f4;
        }
        this.f44857l.setAlpha(f2);
        this.f44860o.setAlpha(f2);
        this.f44858m.setAlpha(f2);
        this.f44859n.setAlpha(f2);
        this.f44862q.setAlpha(f2);
        this.f44863r.setAlpha(f2);
    }
}
