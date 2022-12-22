package com.didi.entrega.customer.component.feed.base;

public interface HeaderViewIView {

    public enum Mode {
        ENABLED,
        DISABLED
    }

    void dismissPullToRefresh();
}
