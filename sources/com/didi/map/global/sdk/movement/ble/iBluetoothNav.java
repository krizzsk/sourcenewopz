package com.didi.map.global.sdk.movement.ble;

import com.didi.map.global.sdk.movement.ble.BlueToothEngine;

public interface iBluetoothNav {
    void onDestroy();

    void onReceiveDriverLocation(BlueToothEngine.LocationInfo locationInfo);

    void onReceivePaxLocation(BlueToothEngine.LocationInfo locationInfo);

    void onReceiveRssi(int i);

    void setOnBleNavListener(onBleNavListener onblenavlistener);
}
