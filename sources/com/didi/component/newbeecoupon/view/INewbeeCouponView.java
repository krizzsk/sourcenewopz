package com.didi.component.newbeecoupon.view;

import com.didi.component.common.model.HomeNewCouponModel;
import com.didi.component.core.IView;
import com.didi.component.newbeecoupon.presenter.AbsNewbeeCouponPresenter;

public interface INewbeeCouponView extends IView<AbsNewbeeCouponPresenter> {
    void dismiss();

    void setButtonText(String str);

    void setListData(HomeNewCouponModel homeNewCouponModel);

    void show();
}
