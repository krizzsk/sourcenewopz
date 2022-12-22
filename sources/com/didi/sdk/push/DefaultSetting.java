package com.didi.sdk.push;

class DefaultSetting implements ISetting {
    private String DEFAULT_SETTINGS = "{ \"l\": [ { \"name\": \"push\", \"type\": 0, \"ver\": \"1\", \"supportJni2\":false, \"tls\":false, \"writeBufCheckRepeat\":5, \"writeTimeout\":10, \"priority\": 1 }, { \"name\": \"push_new\", \"type\": 0, \"ver\": \"2\", \"supportJni2\":true, \"tls\":true, \"writeBufCheckRepeat\":5, \"writeTimeout\":10, \"priority\": 2 } ] }";
    private String DEFAULT_SETTINGS2 = "{ \"l\": [ { \"name\": \"push_new\", \"type\": 0, \"ver\": \"2\", \"supportJni2\":true, \"tls\":true, \"writeBufCheckRepeat\":5, \"writeTimeout\":10, \"priority\": 1 } ] }";
    private String default_settings3 = "{\"l\":[{\"name\":\"push_new_v2\",\"type\":0,\"ver\":\"4\",\"supportJni2\":true,\"tls\":true,\"priority\":3,\"routeType\":0,\"writeTimeout\":10000,\"writeBufCheckRepeat\":5000,\"heartBeatInterval\":5,\"heartBeatRetryInterval\":5,\"confVersion\":0}]}";

    DefaultSetting() {
    }

    public String getSettings() {
        return this.DEFAULT_SETTINGS2;
    }
}
