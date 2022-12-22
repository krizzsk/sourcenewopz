package com.didi.travel.psnger.core.poll;

import com.didi.travel.psnger.utils.LogUtil;

public class BasePoller implements IPollProtocol {
    protected long mFrequencyTime;

    public boolean checkPollerRunning() {
        return false;
    }

    public int getPollRunningTime() {
        return 0;
    }

    public void registerPollCallback(IPollCallbackProtocol iPollCallbackProtocol) {
    }

    public void startPoll(long j, long j2, long j3) {
    }

    public void startPoll(long j, long j2, long j3, boolean z) {
    }

    public void stopPoll() {
    }

    public void updatePollFrequenceTime(long j) {
        LogUtil.m31432fi("updatePollFrequenceTime time=" + j);
        this.mFrequencyTime = j;
    }

    public long getCurFrequencyTime() {
        return this.mFrequencyTime;
    }
}
