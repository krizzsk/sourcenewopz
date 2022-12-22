package com.didi.global.loading;

public interface ILoadingable {
    void hideLoading();

    boolean isLoading();

    void showLoading();

    void showLoading(LoadingConfig loadingConfig);
}
