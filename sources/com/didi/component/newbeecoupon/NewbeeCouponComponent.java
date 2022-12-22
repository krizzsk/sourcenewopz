package com.didi.component.newbeecoupon;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.newbeecoupon.presenter.AbsNewbeeCouponPresenter;
import com.didi.component.newbeecoupon.presenter.NewNewCouponPresenter;
import com.didi.component.newbeecoupon.view.INewbeeCouponView;
import com.didi.component.newbeecoupon.view.NewNewCouponView;

@ComponentRegister(product = "ride", type = "newbee_coupon")
public class NewbeeCouponComponent extends BaseComponent<INewbeeCouponView, AbsNewbeeCouponPresenter> {
    /* access modifiers changed from: protected */
    public INewbeeCouponView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new NewNewCouponView(componentParams.bizCtx.getContext());
    }

    /* access modifiers changed from: protected */
    public AbsNewbeeCouponPresenter onCreatePresenter(ComponentParams componentParams) {
        return new NewNewCouponPresenter(componentParams);
    }
}
