package com.didi.drouter.service;

public interface ICallServiceN<Result> {
    Result call(Object... objArr);
}
