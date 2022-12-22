package com.didi.sdk.protobuf;

import com.squareup.wire.ProtoEnum;

public enum NodeType implements ProtoEnum {
    kNodeTypeMin(0),
    kNodeTypeApp(1),
    kNodeTypeConnSvr(2),
    kNodeTypeConnMasterSvr(3),
    kNodeTypeCdntSvr(4),
    kNodeTypeAuthSvr(5),
    kNodeTypePushSvr(6),
    kNodeTypeCollectSvr(7),
    kNodeTypeDispatchSvr(8),
    kNodeTypeMessageSvr(9),
    kNodeTypeSessionSvr(10),
    kNodeTypeFileSvr(11),
    kNodeTypeRepushSvr(12),
    kNodeTypeDbSvr(13),
    kNodeTypeCommonSvr(14),
    kNodeTypeTrans(15),
    kNodeTypeMax(16);
    
    private final int value;

    private NodeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
