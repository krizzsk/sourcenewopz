package com.didi.component.framework.template.common;

import com.didi.component.common.base.ComponentWrap;
import com.didi.component.core.IGroupView;

public interface ICommonTemplateView extends IGroupView<CommonTemplatePresenter> {
    void beforeOutAnimation();

    void hideBottomSheet();

    void hideLoading();

    void hidePayProcessLoading();

    boolean hidePopupComponent(String str);

    void hideSugPageContainer();

    void showBottomSheet();

    void showLoadingOnTitleBar();

    void showPayProcessLoading();

    void showPayProcessLoading4XPanel();

    void showPopupComponent(ComponentWrap componentWrap);

    void showSugPageContainer();
}
