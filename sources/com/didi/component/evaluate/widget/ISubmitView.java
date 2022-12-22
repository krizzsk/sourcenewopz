package com.didi.component.evaluate.widget;

import android.view.View;

public interface ISubmitView {
    void hideLoading();

    void setEnable(boolean z);

    void setOnclickListener(View.OnClickListener onClickListener);

    void setTipHint(String str);

    void showLoading();

    void submitFail();

    void submitSuccess();
}
