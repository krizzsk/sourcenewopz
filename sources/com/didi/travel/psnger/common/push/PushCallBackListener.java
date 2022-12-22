package com.didi.travel.psnger.common.push;

public interface PushCallBackListener<T> {
    void onReceive(T t);
}
