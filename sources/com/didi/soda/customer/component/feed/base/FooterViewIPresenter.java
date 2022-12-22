package com.didi.soda.customer.component.feed.base;

public interface FooterViewIPresenter {
    void hideFooterStubView();

    void onFooterErrorClicked();

    void onFooterNoMoreClicked();

    void onFooterSignInClicked();

    void onLoadMore();

    void showFooterStubView();

    boolean updateFooterStubViewHeight(int i);
}
