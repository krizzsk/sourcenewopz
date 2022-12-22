package com.didi.sdk.push;

public class BaseSetting implements ISetting {
    public String getSettings() {
        return "{ \"l\": [ { \"name\": \"push_new\", \"type\": 0, \"ver\": \"2\", \"supportJni2\":true, \"tls\":false, \"writeBufCheckRepeat\":5000, \"writeTimeout\":10000, \"priority\": 1 } ] }";
    }
}
