package com.didi.drouter.service;

public interface ICallService {
    <T> T call(Object... objArr);
}
