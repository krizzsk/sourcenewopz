package com.android.didi.safetoolkit;

public interface UIStuff {
    void closePDialog();

    boolean isWaitDialogShowing();

    void showPDialog();

    void showPDialog(String str);

    void showPDialog(String str, boolean z);

    void showToast(int i);

    void showToast(int i, int i2);

    void showToast(String str);

    void showToast(String str, int i);
}
