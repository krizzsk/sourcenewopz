package com.component.android.comp_location.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.taxis99.R;

public class GlobalLocationViewV2 extends GlobalHomeLocationView {

    /* renamed from: a */
    ObjectAnimator f3312a;

    /* renamed from: b */
    ObjectAnimator f3313b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f3314c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f3315d;

    public void doAnim(int i, int i2) {
    }

    public GlobalLocationViewV2(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        super.onInflate(view);
        ViewGroup.LayoutParams layoutParams = this.mOverviewBtn.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mOverviewBtn.setLayoutParams(layoutParams);
        this.mOverviewParentBtn.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams2 = this.mOverviewBtn.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = -2;
        this.mResetBtnView.setLayoutParams(layoutParams2);
        this.mResetBtnView.setImageResource(R.drawable.global_confirm_location_resetview_bg);
        this.mResetBtnParentView.setPadding(0, 0, 0, 0);
    }

    public void setOverviewVisibility(int i) {
        super.show();
        if (this.mOverviewParentBtn != null) {
            this.mOverviewParentBtn.setVisibility(i);
            this.mOverviewParentBtn.setPadding(0, 0, 0, 0);
            if (i == 0) {
                this.mResetBtnParentView.setTranslationY((float) (-UiUtils.dip2px(this.mContext, -25.0f)));
                return;
            }
            this.mResetBtnParentView.setTranslationY(0.0f);
        }
    }

    public void setTranslationY(int i) {
        super.setTranslationY(i + UiUtils.dip2px(getContext(), 4.0f));
    }

    /* renamed from: a */
    private void m2255a() {
        if (!this.f3315d) {
            if (this.mResetBtnView == null || this.mResetBtnView.getAlpha() != 1.0f) {
                GLog.m7965d("doAnim", "doAppearAnim");
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mResetBtnView, "alpha", new float[]{0.0f, 1.0f});
                this.f3313b = ofFloat;
                ofFloat.setDuration(300);
                this.f3313b.setRepeatCount(0);
                this.f3313b.setRepeatMode(1);
                this.f3313b.setStartDelay(0);
                this.f3313b.setInterpolator(new LinearInterpolator());
                this.f3313b.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = GlobalLocationViewV2.this.f3315d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean unused = GlobalLocationViewV2.this.f3315d = false;
                    }
                });
                this.f3313b.start();
            }
        }
    }

    /* renamed from: b */
    private void m2257b() {
        if (!this.f3314c) {
            if (this.mResetBtnView == null || this.mResetBtnView.getAlpha() != 0.0f) {
                GLog.m7965d("doAnim", "doDisAppearAnim");
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mResetBtnView, "alpha", new float[]{1.0f, 0.0f});
                this.f3312a = ofFloat;
                ofFloat.setDuration(300);
                this.f3312a.setRepeatCount(0);
                this.f3312a.setRepeatMode(1);
                this.f3312a.setStartDelay(0);
                this.f3312a.setInterpolator(new LinearInterpolator());
                this.f3312a.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = GlobalLocationViewV2.this.f3314c = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean unused = GlobalLocationViewV2.this.f3314c = false;
                    }
                });
                this.f3312a.start();
            }
        }
    }

    public void setAlpha(float f) {
        if (this.mResetBtnView != null) {
            this.mResetBtnView.setAlpha(f);
        }
    }
}
