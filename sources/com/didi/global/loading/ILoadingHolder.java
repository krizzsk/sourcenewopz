package com.didi.global.loading;

import android.view.View;

public interface ILoadingHolder {
    View getFallbackView();

    LoadingConfig getLoadingConfig();
}
