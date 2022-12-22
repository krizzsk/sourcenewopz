package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.RelationType */
public enum RelationType implements ProtoEnum {
    kRelationTypeRealTime(0),
    kRelationTypeReservation(1);
    
    private final int value;

    private RelationType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
