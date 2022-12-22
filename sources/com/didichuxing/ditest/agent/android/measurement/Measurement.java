package com.didichuxing.ditest.agent.android.measurement;

public interface Measurement {
    void finish();

    long getEndTime();

    double getEndTimeInSeconds();

    long getExclusiveTime();

    double getExclusiveTimeInSeconds();

    String getName();

    long getStartTime();

    double getStartTimeInSeconds();

    MeasurementType getType();

    boolean isFinished();
}
