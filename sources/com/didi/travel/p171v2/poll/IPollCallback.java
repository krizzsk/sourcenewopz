package com.didi.travel.p171v2.poll;

/* renamed from: com.didi.travel.v2.poll.IPollCallback */
public interface IPollCallback {
    int isContinue();

    void onPollTimeChanged(long j);

    void onPollTimeout();

    void onTick(int i);
}
