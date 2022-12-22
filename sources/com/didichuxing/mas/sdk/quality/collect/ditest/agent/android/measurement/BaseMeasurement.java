package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;

public class BaseMeasurement implements Measurement {

    /* renamed from: a */
    private static final AgentLog f48004a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private MeasurementType f48005b;

    /* renamed from: c */
    private String f48006c;

    /* renamed from: d */
    private long f48007d;

    /* renamed from: e */
    private long f48008e;

    /* renamed from: f */
    private long f48009f;

    /* renamed from: g */
    private boolean f48010g;

    public BaseMeasurement(MeasurementType measurementType) {
        mo118251a(measurementType);
    }

    public BaseMeasurement(Measurement measurement) {
        mo118251a(measurement.getType());
        setName(measurement.getName());
        setStartTime(measurement.getStartTime());
        setEndTime(measurement.getEndTime());
        setExclusiveTime(measurement.getExclusiveTime());
        this.f48010g = measurement.isFinished();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo118251a(MeasurementType measurementType) {
        m34267a();
        this.f48005b = measurementType;
    }

    public void setName(String str) {
        m34267a();
        this.f48006c = str;
    }

    public void setStartTime(long j) {
        m34267a();
        this.f48007d = j;
    }

    public void setEndTime(long j) {
        m34267a();
        if (j < this.f48007d) {
            AgentLog agentLog = f48004a;
            agentLog.error("Measurement end time must not precede start time - startTime: " + this.f48007d + " endTime: " + j);
            return;
        }
        this.f48008e = j;
    }

    public void setExclusiveTime(long j) {
        m34267a();
        this.f48009f = j;
    }

    public MeasurementType getType() {
        return this.f48005b;
    }

    public String getName() {
        return this.f48006c;
    }

    public long getStartTime() {
        return this.f48007d;
    }

    public double getStartTimeInSeconds() {
        return ((double) this.f48007d) / 1000.0d;
    }

    public long getEndTime() {
        return this.f48008e;
    }

    public double getEndTimeInSeconds() {
        return ((double) this.f48008e) / 1000.0d;
    }

    public long getExclusiveTime() {
        return this.f48009f;
    }

    public double getExclusiveTimeInSeconds() {
        return ((double) this.f48009f) / 1000.0d;
    }

    public void finish() {
        if (!this.f48010g) {
            this.f48010g = true;
            return;
        }
        throw new MeasurementException("Finish called on already finished Measurement");
    }

    public boolean isFinished() {
        return this.f48010g;
    }

    /* renamed from: a */
    private void m34267a() {
        if (this.f48010g) {
            throw new MeasurementException("Attempted to modify finished Measurement");
        }
    }

    public String toString() {
        return "BaseMeasurement{type=" + this.f48005b + ", name='" + this.f48006c + '\'' + ", startTime=" + this.f48007d + ", endTime=" + this.f48008e + ", exclusiveTime=" + this.f48009f + ", finished=" + this.f48010g + '}';
    }
}
