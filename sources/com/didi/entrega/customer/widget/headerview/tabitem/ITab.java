package com.didi.entrega.customer.widget.headerview.tabitem;

public interface ITab<T> {
    void setSelectedState(boolean z);

    void updateTabView(T t, int i, int i2);
}
