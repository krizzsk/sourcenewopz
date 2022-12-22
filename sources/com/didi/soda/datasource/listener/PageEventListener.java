package com.didi.soda.datasource.listener;

public interface PageEventListener<T> {
    void onPageLoad(int i, T t);
}
