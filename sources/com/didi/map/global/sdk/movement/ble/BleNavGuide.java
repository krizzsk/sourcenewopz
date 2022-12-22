package com.didi.map.global.sdk.movement.ble;

public class BleNavGuide {
    public float direct_pax_toDriver;
    public double eda;
    public int type;

    public String toString() {
        return "BleNavGuide :,toDriver = " + this.direct_pax_toDriver + ", eda = " + this.eda + ", type = " + this.type;
    }
}
