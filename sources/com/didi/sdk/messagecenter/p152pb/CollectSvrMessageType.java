package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.CollectSvrMessageType */
public enum CollectSvrMessageType implements ProtoEnum {
    kCollectSvrMessageTypeCollectSvrCoordinateReq(1),
    kCollectSvrMessageTypeCollectSvrOrderFilterReq(2);
    
    private final int value;

    private CollectSvrMessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
