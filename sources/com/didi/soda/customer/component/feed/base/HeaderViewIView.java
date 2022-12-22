package com.didi.soda.customer.component.feed.base;

public interface HeaderViewIView {

    public enum Mode {
        ENABLED,
        DISABLED
    }

    void dismissPullToRefresh();
}
