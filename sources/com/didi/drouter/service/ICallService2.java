package com.didi.drouter.service;

public interface ICallService2<Param1, Param2, Result> {
    Result call(Param1 param1, Param2 param2);
}
