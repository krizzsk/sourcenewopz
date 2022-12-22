package com.didi.map.global.sdk.movement.ble;

import com.didi.map.global.sdk.movement.ble.BlueToothEngine;
import com.didi.map.global.sdk.movement.sensor.PdrPoint;

public class BluetoothPoint {
    public float direct = -1.0f;
    public BlueToothEngine.LocationInfo driverLoc;
    public BlueToothEngine.LocationInfo paxLoc;
    public PdrPoint point;
    public int rssi = 0;
    public long time;

    public BluetoothPoint(int i, float f, long j, BlueToothEngine.LocationInfo locationInfo, BlueToothEngine.LocationInfo locationInfo2, PdrPoint pdrPoint) {
        this.rssi = i;
        this.direct = f;
        this.time = j;
        this.driverLoc = locationInfo;
        this.paxLoc = locationInfo2;
        this.point = pdrPoint;
    }

    public String toString() {
        return "rssi= " + this.rssi + ", direct= " + this.direct + ", time= " + this.time + ", point" + this.point;
    }
}
