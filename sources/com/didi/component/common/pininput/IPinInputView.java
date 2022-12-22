package com.didi.component.common.pininput;

import com.didi.component.core.IGroupView;

public interface IPinInputView extends IGroupView {
    void dismissUploadingDialog();

    void finishWithResultCancel();

    void finishWithResultOk();

    void showPinCreatedView();

    void showPinInputView();

    void showUploadFailedToast();

    void showUploadingDialog();
}
