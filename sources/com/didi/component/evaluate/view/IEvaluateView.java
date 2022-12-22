package com.didi.component.evaluate.view;

import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IView;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarTipInfo;
import java.util.List;

public interface IEvaluateView extends IView {

    public interface EvaluateListener {
        boolean loadThanksBonus(boolean z, boolean z2, int i);

        void onEvaluateTagSelectChange(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl, boolean z);

        void onLoadData();

        void onSubmit(List<EvaluateTag> list, String str, String str2);
    }

    public interface OnCancelListener {
        void onCancel();
    }

    public interface OnCloseListener {
        void onClose();

        void onCloseWithOutOmega();
    }

    void close();

    void closeWithoutOmega();

    int getStyle();

    void hideLoading();

    void initIsInFiveStar(boolean z);

    void onAdd();

    void onPause();

    void onRemove();

    void onResume();

    void refreshThanksTipData(CarTipInfo carTipInfo);

    void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list);

    void setCardTitle(String str);

    void setCommentAreaVisibility(boolean z);

    void setCommentContent(String str);

    void setDefaultDriverIcon(int i);

    void setDriverIconAndName(String str, String str2);

    void setEvaluateListener(EvaluateListener evaluateListener);

    void setLevel(int i);

    void setOnCancelListener(OnCancelListener onCancelListener);

    void setOnCloseListener(OnCloseListener onCloseListener);

    void setOnRetryListener(OnRetryListener onRetryListener);

    void setRefineGuide(String str);

    void setSymbol(String str);

    void setTagTitle(String str, String str2);

    void setTags(List<EvaluateTag> list);

    void showHeader();

    void showLoading();

    void showLoadingFail(boolean z);

    void showSubmitFail();

    void showSubmitSuccess();

    void showUnMatchResult(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z);

    void showUnMatchSubmit(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z);
}
