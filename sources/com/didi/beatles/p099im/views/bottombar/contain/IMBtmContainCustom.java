package com.didi.beatles.p099im.views.bottombar.contain;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.picture.utils.IMDoubleUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainCustom */
class IMBtmContainCustom extends C4306a {

    /* renamed from: c */
    private ViewGroup f10019c;

    /* renamed from: d */
    private View f10020d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Callback f10021e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainCustom$Callback */
    interface Callback {
        void backToFunc();
    }

    IMBtmContainCustom(View view) {
        super(view);
        this.f10019c = (ViewGroup) view.findViewById(R.id.im_btm_cus_content);
        this.f10020d = view.findViewById(R.id.im_btm_cus_back);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44071a(Callback callback) {
        this.f10021e = callback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44070a(View view, boolean z) {
        this.f10019c.removeAllViews();
        this.f10019c.addView(view);
        if (z) {
            m6797b();
            this.f10020d.setVisibility(0);
            this.f10020d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!IMDoubleUtils.isFastDoubleClick()) {
                        IMBtmContainCustom.this.m6798c();
                    }
                }
            });
            return;
        }
        this.f10020d.setVisibility(8);
    }

    /* renamed from: b */
    private void m6797b() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10058a, R.anim.bts_im_actionsheet_dialog_in);
        this.f10019c.clearAnimation();
        this.f10019c.setAnimation(loadAnimation);
        loadAnimation.startNow();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6798c() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f10058a, R.anim.bts_im_actionsheet_dialog_out);
        this.f10019c.clearAnimation();
        this.f10019c.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (IMBtmContainCustom.this.f10021e != null) {
                    IMBtmContainCustom.this.f10021e.backToFunc();
                }
            }
        });
        loadAnimation.startNow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44069a() {
        this.f10021e = null;
        this.f10019c.clearAnimation();
        this.f10019c.removeAllViews();
    }
}
