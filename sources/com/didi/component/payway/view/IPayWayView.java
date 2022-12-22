package com.didi.component.payway.view;

import com.didi.component.core.IView;
import com.didi.component.payway.callback.NewPopShowResultListener;
import com.didi.component.payway.presenter.AbsPayWayPresenter;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import java.util.List;

public interface IPayWayView extends IView<AbsPayWayPresenter> {
    void changeEnableColor(boolean z);

    void dismissPopup();

    String getContent();

    List<String> getIcon();

    void hide();

    void hideLoading();

    void hidePayWayLabel();

    boolean isClickable();

    void notifyUpdate();

    void setClickable(boolean z);

    void setContentDescription(String str);

    void setLabel(List<PayWayModel.PayWayItem> list);

    void setLabel(List<PayWayModel.PayWayItem> list, String str);

    void show();

    void showGuildPopup(String str, boolean z);

    void showLoading();

    void showNewPopup(BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener);

    void showPayWayCouponPopup(int i, int i2, String str, String str2);

    void showPayWayLabel();

    void showRedDot(boolean z);
}
