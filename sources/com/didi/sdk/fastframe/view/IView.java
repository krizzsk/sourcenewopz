package com.didi.sdk.fastframe.view;

import android.os.Bundle;
import com.didi.sdk.login.view.CommonDialog;

public interface IView {
    void dismissProgressDialog();

    String getString(int i);

    boolean inContentView();

    void loadContentView(Bundle bundle);

    void showContentView();

    void showDialog(String str, String str2, String str3, String str4, CommonDialog.ButtonType buttonType, CommonDialog.CommonDialogListener commonDialogListener);

    void showEmptyView();

    void showProgressDialog(String str, boolean z);

    void showProgressDialog(boolean z);

    void showToast(String str);

    void showToastComplete(String str);

    void showToastComplete(String str, boolean z);

    void showToastError(String str);

    void showToastError(String str, boolean z);

    void showToastInfo(String str);

    void showToastInfo(String str, boolean z);
}
