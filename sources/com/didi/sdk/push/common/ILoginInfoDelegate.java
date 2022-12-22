package com.didi.sdk.push.common;

public interface ILoginInfoDelegate {
    LoginParams getLoginParams();

    boolean isTestEnviroment();
}
