package com.didi.travel.psnger.gson;

public interface PostProcessable<T> {
    T gsonPostProcess();
}
