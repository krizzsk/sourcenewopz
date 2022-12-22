package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum PushStrategy implements ProtoEnum {
    kPushStrategyNoResponse(1),
    kPushStrategyStatResponse(2),
    kPushStrategyTryBest(3),
    kPushStrategyMobileMsg(4);
    
    private final int value;

    private PushStrategy(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
