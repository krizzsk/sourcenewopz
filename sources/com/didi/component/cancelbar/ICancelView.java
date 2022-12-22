package com.didi.component.cancelbar;

import com.didi.component.core.IView;

public interface ICancelView extends IView<AbsCancelPresenter> {
    void setButtonInfo(CancelTextModel cancelTextModel);

    void setButtonText(String str);
}
