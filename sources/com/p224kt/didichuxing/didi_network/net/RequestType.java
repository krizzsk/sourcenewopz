package com.p224kt.didichuxing.didi_network.net;

/* renamed from: com.kt.didichuxing.didi_network.net.RequestType */
public enum RequestType {
    REQUEST_TYPE_GET(1),
    REQUEST_TYPE_POST(2);
    
    private int mIntValue;

    private RequestType(int i) {
        this.mIntValue = i;
    }

    public static RequestType mapIntToValue(int i) {
        for (RequestType requestType : values()) {
            if (i == requestType.getIntValue()) {
                return requestType;
            }
        }
        return getDefault();
    }

    public static RequestType getDefault() {
        return REQUEST_TYPE_POST;
    }

    public int getIntValue() {
        return this.mIntValue;
    }
}
