package com.didi.component.estimate.newui.view;

import com.didi.component.core.IView;
import com.didi.component.estimate.newui.presenter.NewEstimatePresenter;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.didi.travel.psnger.model.response.estimate.EstimateGlobalConfigModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import java.util.List;

public interface IV2EstimateView extends IView<AbsEstimatePresenter> {
    void backToRecommendData();

    void changeMargin(boolean z);

    void closeTipBubble();

    void dismissTips();

    int getMessageViewHeight();

    void hideLoading();

    void hideMessageView();

    void recommandSlide(float f);

    void setAbnormalView(List<EstimateAbnormalModel> list);

    void setEstimatePresenter(NewEstimatePresenter newEstimatePresenter);

    void setRecommendData(List<EstimateItemModel> list, List<EstimateItemModel> list2, EstimateItemModel estimateItemModel, EstimateGlobalConfigModel estimateGlobalConfigModel);

    void setScrollToBottom();

    void setScrollToTop();

    void showLoading();

    void showTipBubble(boolean z, boolean z2);

    void updateSelectItem();
}
