package com.didi.component.common.widget.loading;

import android.view.View;

public interface IDataLoadingView {
    View getView();

    void setId(int i);

    void setOnRetryListener(OnRetryListener onRetryListener);

    void showFail(String str);

    void showLoading();

    void showRetry();
}
