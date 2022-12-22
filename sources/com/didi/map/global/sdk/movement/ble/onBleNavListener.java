package com.didi.map.global.sdk.movement.ble;

public interface onBleNavListener {
    void onBleNavGuide(BleNavGuide bleNavGuide);

    void onNavArrived(int i);
}
