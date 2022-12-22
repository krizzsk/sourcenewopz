package com.didichuxing.mas.sdk.quality.report.utils;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
