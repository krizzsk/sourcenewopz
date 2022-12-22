package com.didi.soda.cart.component.globalmini.lazy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.cart.component.globalmini.lazy.Contract;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;

public class CustomerGlobalMiniCartLazyView extends Contract.AbsGlobalMiniCartView {

    /* renamed from: a */
    private static final float f39986a = 0.0f;

    /* renamed from: b */
    private static final float f39987b = 500.0f;

    /* renamed from: c */
    private static final int f39988c = 500;

    /* renamed from: d */
    private static final int f39989d = 120;

    /* renamed from: e */
    private static final int f39990e = 300;

    /* renamed from: f */
    private static final String f39991f = "CustomerMiniCartView";

    /* renamed from: g */
    private boolean f39992g = false;

    /* renamed from: h */
    private View.OnClickListener f39993h;
    @BindView(18007)
    RFMainButton mButton;
    @BindView(18006)
    FrameLayout mContainer;
    @BindView(17866)
    ConstraintLayout mOfferPassParent;
    @BindView(18011)
    RichTextView mOfferPassText;

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.customer_component_mini_cart_container;
    }

    public boolean isCanShow() {
        return ((Contract.AbsGlobalMiniCartPresenter) getPresenter()).isCanShow();
    }

    public void hideAll() {
        if (this.mContainer.getVisibility() == 0 || this.mOfferPassParent.getVisibility() == 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContainer, View.TRANSLATION_Y, new float[]{0.0f, f39987b});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mOfferPassParent, View.TRANSLATION_Y, new float[]{0.0f, f39987b});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
        }
    }

    public void showAll() {
        if (this.mContainer.getVisibility() == 0 || this.mOfferPassParent.getVisibility() == 0) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContainer, View.TRANSLATION_Y, new float[]{f39987b, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mOfferPassParent, View.TRANSLATION_Y, new float[]{f39987b, 0.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.setDuration(500);
            animatorSet.start();
        }
    }

    public void setOnClickCartListener(View.OnClickListener onClickListener) {
        this.f39993h = onClickListener;
    }

    public void show() {
        if (!isShow() && ((Contract.AbsGlobalMiniCartPresenter) getPresenter()).isCanShow()) {
            this.f39992g = true;
            this.mContainer.setVisibility(0);
            float f = f39987b;
            TimeInterpolator linearInterpolator = new LinearInterpolator();
            if (GlobalContext.isEmbed()) {
                f = (float) this.mContainer.getHeight();
                linearInterpolator = CustomerInterpolator.newInstance();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContainer, View.TRANSLATION_Y, new float[]{f, 0.0f});
            ofFloat.setInterpolator(linearInterpolator);
            ofFloat.setDuration(500);
            ofFloat.start();
            LogUtil.m29104i(f39991f, "mini购物车展示");
        }
    }

    public void showLoading() {
        this.mButton.setLoading(true);
        DialogUtil.showBlockDialog(getScopeContext());
    }

    public boolean isShow() {
        return this.f39992g;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(new View.OnClickListener(onClickListener) {
            public final /* synthetic */ View.OnClickListener f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                CustomerGlobalMiniCartLazyView.this.m28503a(this.f$1, view);
            }
        });
        this.mContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28503a(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        View.OnClickListener onClickListener2 = this.f39993h;
        if (onClickListener2 != null) {
            onClickListener2.onClick(view);
        }
    }

    public void hide() {
        if (isShow()) {
            this.f39992g = false;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mContainer, View.TRANSLATION_Y, new float[]{0.0f, f39987b});
            ofFloat.setDuration(500);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.start();
            LogUtil.m29104i(f39991f, "mini购物车隐藏");
        }
    }

    public void hideLoading() {
        DialogUtil.hideBlockDialog();
        this.mButton.setLoading(false);
    }

    public void initButtonStyle() {
        this.mButton.setText(getResources().getString(R.string.customer_view_cart));
        this.mButton.setContentBackground(RFResUtils.getDrawable(getContext(), R.drawable.customer_selector_mini_car_bg));
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        initButtonStyle();
    }
}
