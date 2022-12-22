package com.didi.soda.customer.component.feed.base;

public interface FooterViewIView {

    public enum Mode {
        NONE,
        SIMPLE,
        MULTI_COLOR
    }

    boolean isFooterViewLoading();

    void showFooteSignInView();

    void showFooterEmptyView();

    void showFooterErrorView();

    void showFooterLoadingView();

    void showFooterNoMoreView();

    void showFooterNoNetView();

    void updateFooterViewPadding(int i, int i2, int i3, int i4);
}
