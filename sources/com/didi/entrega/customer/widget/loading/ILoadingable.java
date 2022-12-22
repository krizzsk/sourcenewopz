package com.didi.entrega.customer.widget.loading;

public interface ILoadingable {
    void hideLoading();

    boolean isLoading();

    void showLoading();

    void showLoading(LoadingConfig loadingConfig);
}
