package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android;

import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.measurement.http.HttpTransactionMeasurement;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util.Encoder;

public interface AgentImpl {
    void addNetEventLog(HttpTransactionMeasurement httpTransactionMeasurement);

    void addTrafficToMonitor(long j);

    boolean canUploadNetErrEvent();

    void disable();

    AgentConfiguration getAgentConfig();

    Encoder getEncoder();

    String getNetworkCarrier();

    String getNetworkWanType();

    int getResponseBodyLimit();

    boolean isApmNetEnable();

    boolean isApmUiEnable();

    boolean isDisabled();

    boolean isUploadErrorDiag();

    boolean isUploadNetPerf();

    void setLocation(String str, String str2);

    void start();

    void stop();

    boolean upperLimitToday(String str, long j);
}
