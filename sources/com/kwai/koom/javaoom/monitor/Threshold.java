package com.kwai.koom.javaoom.monitor;

public interface Threshold {
    boolean ascending();

    float maxValue();

    int overTimes();

    int pollInterval();

    float value();

    ThresholdValueType valueType();
}
