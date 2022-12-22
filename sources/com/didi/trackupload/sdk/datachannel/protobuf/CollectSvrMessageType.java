package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.ProtoEnum;

public enum CollectSvrMessageType implements ProtoEnum {
    kCollectSvrMessageTypeCollectSvrCoordinateReq(1),
    kCollectSvrMessageTypeCollectSvrOrderFilterReq(2),
    kCollectSvrMessageTypeTrackUploadReq(3);
    
    private final int value;

    private CollectSvrMessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
