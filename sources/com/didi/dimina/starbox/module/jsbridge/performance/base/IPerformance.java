package com.didi.dimina.starbox.module.jsbridge.performance.base;

public interface IPerformance<T> {
    void registerProvider(IDataProvider<T> iDataProvider);
}
