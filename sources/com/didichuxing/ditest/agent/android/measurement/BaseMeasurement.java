package com.didichuxing.ditest.agent.android.measurement;

import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;

public class BaseMeasurement implements Measurement {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private long endTime;
    private long exclusiveTime;
    private boolean finished;
    private String name;
    private long startTime;
    private MeasurementType type;

    public BaseMeasurement(MeasurementType measurementType) {
        setType(measurementType);
    }

    public BaseMeasurement(Measurement measurement) {
        setType(measurement.getType());
        setName(measurement.getName());
        setStartTime(measurement.getStartTime());
        setEndTime(measurement.getEndTime());
        setExclusiveTime(measurement.getExclusiveTime());
        this.finished = measurement.isFinished();
    }

    /* access modifiers changed from: package-private */
    public void setType(MeasurementType measurementType) {
        throwIfFinished();
        this.type = measurementType;
    }

    public void setName(String str) {
        throwIfFinished();
        this.name = str;
    }

    public void setStartTime(long j) {
        throwIfFinished();
        this.startTime = j;
    }

    public void setEndTime(long j) {
        throwIfFinished();
        if (j < this.startTime) {
            AgentLog agentLog = log;
            agentLog.error("Measurement end time must not precede start time - startTime: " + this.startTime + " endTime: " + j);
            return;
        }
        this.endTime = j;
    }

    public void setExclusiveTime(long j) {
        throwIfFinished();
        this.exclusiveTime = j;
    }

    public MeasurementType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public double getStartTimeInSeconds() {
        return ((double) this.startTime) / 1000.0d;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public double getEndTimeInSeconds() {
        return ((double) this.endTime) / 1000.0d;
    }

    public long getExclusiveTime() {
        return this.exclusiveTime;
    }

    public double getExclusiveTimeInSeconds() {
        return ((double) this.exclusiveTime) / 1000.0d;
    }

    public void finish() {
        if (!this.finished) {
            this.finished = true;
            return;
        }
        throw new MeasurementException("Finish called on already finished Measurement");
    }

    public boolean isFinished() {
        return this.finished;
    }

    private void throwIfFinished() {
        if (this.finished) {
            throw new MeasurementException("Attempted to modify finished Measurement");
        }
    }

    public String toString() {
        return "BaseMeasurement{type=" + this.type + ", name='" + this.name + '\'' + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", exclusiveTime=" + this.exclusiveTime + ", finished=" + this.finished + '}';
    }
}
