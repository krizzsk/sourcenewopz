package com.didi.map.global.component.bluetooth.client;

public interface IBleBluetoothClientCallback {
    void onDriverInfoResult(DriverInfoResult driverInfoResult);

    void onRssiInfoResult(RssiInfoResult rssiInfoResult);

    void onStateChange(ClientState clientState);
}
