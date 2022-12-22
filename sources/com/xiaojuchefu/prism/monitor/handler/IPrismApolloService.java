package com.xiaojuchefu.prism.monitor.handler;

public interface IPrismApolloService {
    boolean allow(String str);

    <T> T getParams(String str, String str2, T t);
}
