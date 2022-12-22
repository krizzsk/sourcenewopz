package com.didi.travel.psnger.core.poll;

public interface IPollProtocol {
    boolean checkPollerRunning();

    long getCurFrequencyTime();

    int getPollRunningTime();

    void registerPollCallback(IPollCallbackProtocol iPollCallbackProtocol);

    void startPoll(long j, long j2, long j3);

    void startPoll(long j, long j2, long j3, boolean z);

    void stopPoll();

    void updatePollFrequenceTime(long j);
}
