package com.didi.map.global.component.bluetooth.client;

public enum ClientState {
    Scanning("正在扫描"),
    ScanSuccess("扫描成功"),
    ScanFailure("扫描失败"),
    Connecting("正在链接"),
    ConnectSuccess("链接成功"),
    ConnectFailure("链接失败");
    
    private final String state;

    private ClientState(String str) {
        this.state = str;
    }

    public String toString() {
        return this.state;
    }
}
