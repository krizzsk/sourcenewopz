package com.didi.component.comp_flex.option;

import com.didi.component.core.IView;

public interface IFlexOptionView extends IView<FlexOptionPresenter> {
    void onDestroy();

    void setOperationPanelModel(OperationPanelModel operationPanelModel);

    void setVisibility(int i);

    void showOptionPop();
}
