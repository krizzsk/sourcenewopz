package com.didi.map.global.sdk.movement.sensor;

public interface onDidiMovementListener {
    void onMovementChanged(Movement movement);

    void onNewStep(int i);

    void onPdrPointChanged(PdrPoint pdrPoint);

    void onPrintLog(String str);

    void onShowLine(float f);
}
