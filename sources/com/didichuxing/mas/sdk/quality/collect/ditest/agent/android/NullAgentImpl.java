package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Encoder;
import java.util.concurrent.locks.ReentrantLock;

public class NullAgentImpl implements AgentImpl {
    public static final NullAgentImpl instance = new NullAgentImpl();

    /* renamed from: a */
    private final ReentrantLock f47890a = new ReentrantLock();

    /* renamed from: b */
    private int f47891b;

    /* renamed from: c */
    private final AgentConfiguration f47892c = new AgentConfiguration();

    public void addNetEventLog(HttpTransactionMeasurement httpTransactionMeasurement) {
    }

    public void addTrafficToMonitor(long j) {
    }

    public boolean canUploadNetErrEvent() {
        return false;
    }

    public void disable() {
    }

    public String getNetworkCarrier() {
        return "unknown";
    }

    public String getNetworkWanType() {
        return "unknown";
    }

    public int getStackTraceLimit() {
        return 0;
    }

    public boolean isApmNetEnable() {
        return false;
    }

    public boolean isApmUiEnable() {
        return false;
    }

    public boolean isDisabled() {
        return true;
    }

    public boolean isUploadErrorDiag() {
        return false;
    }

    public boolean isUploadNetPerf() {
        return false;
    }

    public void setLocation(String str, String str2) {
    }

    public void start() {
    }

    public void stop() {
    }

    public boolean upperLimitToday(String str, long j) {
        return true;
    }

    public int getResponseBodyLimit() {
        return this.f47891b;
    }

    public void setResponseBodyLimit(int i) {
        this.f47891b = i;
    }

    public Encoder getEncoder() {
        return new Encoder() {
            public String encode(byte[] bArr) {
                return new String(bArr);
            }
        };
    }

    public AgentConfiguration getAgentConfig() {
        return new AgentConfiguration();
    }
}
