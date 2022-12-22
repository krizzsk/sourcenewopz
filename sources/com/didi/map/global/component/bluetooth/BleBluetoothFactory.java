package com.didi.map.global.component.bluetooth;

import com.didi.map.global.component.bluetooth.client.BleBluetoothClient;
import com.didi.map.global.component.bluetooth.client.IBleBluetoothClientInterface;
import com.didi.map.global.component.bluetooth.server.BleBluetoothServer;
import com.didi.map.global.component.bluetooth.server.IBleBluetoothServerInterface;

public class BleBluetoothFactory {
    public static IBleBluetoothClientInterface getClient() {
        return new BleBluetoothClient();
    }

    public static IBleBluetoothServerInterface getServer() {
        return new BleBluetoothServer();
    }
}
