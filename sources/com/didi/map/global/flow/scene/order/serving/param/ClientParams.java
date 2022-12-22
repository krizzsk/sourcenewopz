package com.didi.map.global.flow.scene.order.serving.param;

public class ClientParams {
    public String clientVersion;
    public String countryId;
    public String imei;

    public ClientParams(String str, String str2, String str3) {
        this.clientVersion = str;
        this.countryId = str2;
        this.imei = str3;
    }

    public String toString() {
        return "ClientParams{clientVersion='" + this.clientVersion + '\'' + ", countryId='" + this.countryId + '\'' + ", imei='" + this.imei + '\'' + '}';
    }
}
