package com.didichuxing.apollo.sdk;

import com.didichuxing.apollo.sdk.jsbridge.IJson;

public interface IToggle extends IJson {
    boolean allow();

    Integer getCachePlan();

    IExperiment getExperiment();

    Integer getLogRate();

    String getName();
}
