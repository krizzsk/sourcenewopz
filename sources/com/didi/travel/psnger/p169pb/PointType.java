package com.didi.travel.psnger.p169pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.travel.psnger.pb.PointType */
public enum PointType implements ProtoEnum {
    NormalMatchPoint(0),
    OffRoadPoint(1),
    JumpPoint(2);
    
    private final int value;

    private PointType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
