package com.didi.component.newbeecoupon.presenter;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.newbeecoupon.view.INewbeeCouponView;

public abstract class AbsNewbeeCouponPresenter extends BaseExpressPresenter<INewbeeCouponView> {
    public abstract void onMaskClicked();

    public abstract void onOpenSugClick();

    AbsNewbeeCouponPresenter(ComponentParams componentParams) {
        super(componentParams);
    }
}
