package com.didi.map.global.component.bluetooth.server;

public enum ServerState {
    OpenAdvertiserSuccess("打开广播成功"),
    OpenAdvertiserFailure("打开广播失败"),
    AddServiceSuccess("添加服务成功"),
    AddServiceFailure("添加服务失败");
    
    private final String state;

    private ServerState(String str) {
        this.state = str;
    }

    public String toString() {
        return this.state;
    }
}
