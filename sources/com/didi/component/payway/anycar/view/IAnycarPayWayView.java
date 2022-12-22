package com.didi.component.payway.anycar.view;

import com.didi.component.core.IView;
import com.didi.component.payway.anycar.callback.NewPopShowResultListener;
import com.didi.component.payway.anycar.presenter.AbsPayWayPresenter;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarPayModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import java.util.List;

public interface IAnycarPayWayView extends IView<AbsPayWayPresenter> {
    void changeEnableColor(boolean z);

    void dismissPopup();

    String getContent();

    List<String> getIcon();

    void hide();

    void hideLoading();

    boolean isClickable();

    void notifyUpdate();

    void setClickable(boolean z);

    void setContentDescription(String str);

    void setData(AnyCarPayModel anyCarPayModel);

    void setLabel(List<PayWayModel.PayWayItem> list);

    void setLabel(List<PayWayModel.PayWayItem> list, String str);

    void show();

    void showNewPopup(BubbleItemModel bubbleItemModel, NewPopShowResultListener newPopShowResultListener);

    void showRedDot(boolean z);
}
