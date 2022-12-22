package com.didi.component.core;

import com.didi.component.core.PresenterGroup;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;

public interface IGroupView<P extends PresenterGroup> extends IView<P> {
    public static final String BACK_VISIBILITY = "back_visibility";

    void dismissDialog(int i);

    boolean isDialogShowing();

    void onDialogClicked(int i, int i2);

    void setBackVisible(boolean z);

    void setTitle(String str);

    void showDialog(DialogInfo dialogInfo);

    void showToast(ToastHandler.ToastInfo toastInfo);
}
