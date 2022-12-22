package com.didi.addressold.fastframe;

public interface IView {
    void dismissProgressDialog();

    String getString(int i);

    void onHttpRequestSuccess();

    void showContentView();

    void showEmptyView();

    void showProgressDialog(String str, boolean z);

    void showProgressDialog(boolean z);

    void showToastComplete(String str);

    void showToastError(String str);

    void showToastError(String str, boolean z);
}
