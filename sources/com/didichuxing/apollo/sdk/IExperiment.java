package com.didichuxing.apollo.sdk;

import com.didichuxing.apollo.sdk.jsbridge.IJson;

public interface IExperiment extends IJson {
    double getDoubleParam(String str, Double d);

    String getHitGroup();

    int getIntParam(String str, Integer num);

    @Deprecated
    <T> T getParam(String str, T t);

    String getStringParam(String str, String str2);

    String getTestKey();
}
