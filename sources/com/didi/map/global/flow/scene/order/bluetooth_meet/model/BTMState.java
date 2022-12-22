package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/BTMState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_PERMISSION", "BLUETOOTH_TURNOFF", "PAIRING", "PAIRING_FAILURE", "PAIRED", "INIT_DIRECTION", "RIGHT_DIRECTION", "WRONG_DIRECTION", "WRONG_DIRECTION_TOTALLY", "VERY_NEAR", "ON_BOARD", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BTMViewModel.kt */
public enum BTMState {
    NO_PERMISSION(0),
    BLUETOOTH_TURNOFF(1),
    PAIRING(2),
    PAIRING_FAILURE(3),
    PAIRED(4),
    INIT_DIRECTION(5),
    RIGHT_DIRECTION(6),
    WRONG_DIRECTION(7),
    WRONG_DIRECTION_TOTALLY(8),
    VERY_NEAR(9),
    ON_BOARD(10);
    
    private final int value;

    private BTMState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
