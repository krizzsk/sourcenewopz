package com.didi.addressnew.view;

import com.didi.sdk.address.address.entity.Address;

public interface ISugContainerOpCallback {
    Address getTargetAddress();

    void hideInputWindow();

    void onScrollToBottom();

    void onScrollToTop();

    void onSugContainerScrollChanged(int i, int i2, int i3, int i4);
}
