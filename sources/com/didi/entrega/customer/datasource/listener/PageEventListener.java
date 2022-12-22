package com.didi.entrega.customer.datasource.listener;

public interface PageEventListener<T> {
    void onPageLoad(int i, T t);
}
