package com.didi.map.global.sdk.movement.sensor;

import com.didi.entrega.customer.foundation.rpc.entity.AlertBtnEntity;

public enum Movement {
    STAY(AlertBtnEntity.ACTION_STAY),
    WALKING("walking");
    
    private final String key;

    private Movement(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }
}
