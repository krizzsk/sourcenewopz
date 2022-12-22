package com.didi.component.realtimeprice;

import com.didi.component.core.IView;
import com.didi.component.realtimeprice.model.CouponAssistantModel;
import com.didi.component.realtimeprice.model.PayInfo;
import com.didi.component.realtimeprice.model.RealTimePrice;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;

public interface IRealTimePriceView extends IView<AbsRealTimePricePresenter> {

    public interface OnActionListener {
        void onClickAction();

        void paywayChange(PayInfo payInfo);
    }

    void hideLoading();

    void hideNewbieGuide();

    void hideOnTripCoupon();

    boolean isLoading();

    void setClickable(boolean z);

    void setCoupon(LEGORichInfo lEGORichInfo);

    void setCouponAssistant(CouponAssistantModel couponAssistantModel);

    void setData(PayInfo payInfo);

    void setData(RealTimePrice realTimePrice);

    void setOnActionListener(OnActionListener onActionListener);

    void setPayWay(String str);

    void setPriceDesc(String str);

    void showFixedPriceGuidePopup(String str);

    void showLoading();

    void showNewbieGuide(String str);
}
