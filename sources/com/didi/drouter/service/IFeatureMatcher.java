package com.didi.drouter.service;

public interface IFeatureMatcher<T> {
    boolean match(T t);
}
