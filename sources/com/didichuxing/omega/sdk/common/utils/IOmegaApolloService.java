package com.didichuxing.omega.sdk.common.utils;

public interface IOmegaApolloService {
    boolean allow(String str);

    <T> T getParams(String str, String str2, T t);
}
