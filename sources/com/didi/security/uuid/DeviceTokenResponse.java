package com.didi.security.uuid;

import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import org.json.JSONObject;

public class DeviceTokenResponse {
    public int apiCode;
    public String deviceToken;
    public long expire;
    public int gatewayCode;
    public int httpcode;

    public static DeviceTokenResponse parse(int i, String str) {
        DeviceTokenResponse deviceTokenResponse = new DeviceTokenResponse();
        deviceTokenResponse.httpcode = i;
        deviceTokenResponse.gatewayCode = 0;
        deviceTokenResponse.apiCode = 0;
        deviceTokenResponse.deviceToken = null;
        deviceTokenResponse.expire = 0;
        deviceTokenResponse.m27304a(str);
        return deviceTokenResponse;
    }

    /* renamed from: a */
    private void m27304a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gatewayCode = jSONObject.getInt("apiCode");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2 != null) {
                    this.apiCode = jSONObject2.getInt("apiCode");
                    this.deviceToken = jSONObject2.getString(ParamsHelper.FLUTTER_DEVICE_TOKEN);
                    this.expire = jSONObject2.getLong("expire");
                }
            } catch (Exception unused) {
            }
        }
    }
}
