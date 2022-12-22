package com.didi.soda.customer.widget.headerview.tabitem;

public interface ITab<T> {
    void setSelectedState(boolean z, boolean z2);

    void updateTabView(T t, int i, int i2);
}
