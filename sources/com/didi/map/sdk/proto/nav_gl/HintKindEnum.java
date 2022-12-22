package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.ProtoEnum;

public enum HintKindEnum implements ProtoEnum {
    SEG_HINT_NONE(0),
    SEG_HINT_ELEVATED(1),
    SEG_HINT_DOWNSTAIRS(2),
    SEG_HINT_MAIN_ROAD(3),
    SEG_HINT_SERVING_ROAD(4),
    SEG_HINT_2_DIRECTION_ROAD(5),
    SEG_HINT_DOWNSTAIRS_MAIN_ROAD(6),
    SEG_HINT_DOWNSTAIRS_SERVING_ROAD(7);
    
    private final int value;

    private HintKindEnum(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
