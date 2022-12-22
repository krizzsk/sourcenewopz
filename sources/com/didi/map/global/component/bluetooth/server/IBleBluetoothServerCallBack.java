package com.didi.map.global.component.bluetooth.server;

public interface IBleBluetoothServerCallBack {
    BleServerData getReadData();

    void onStateChange(ServerState serverState);
}
