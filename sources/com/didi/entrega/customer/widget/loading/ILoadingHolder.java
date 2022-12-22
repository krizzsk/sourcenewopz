package com.didi.entrega.customer.widget.loading;

import android.view.View;

public interface ILoadingHolder {
    View getFallbackView();

    LoadingConfig getLoadingConfig();
}
