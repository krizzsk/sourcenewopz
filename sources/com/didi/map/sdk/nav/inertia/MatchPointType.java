package com.didi.map.sdk.nav.inertia;

public enum MatchPointType {
    GPS(0),
    WIFI(1),
    MOBILE_STATION(2),
    UNKNOWN(3);
    
    public final int type;

    private MatchPointType(int i) {
        this.type = i;
    }

    public int value() {
        return this.type;
    }

    public static MatchPointType valueOf(int i) {
        MatchPointType matchPointType = GPS;
        for (MatchPointType matchPointType2 : values()) {
            if (i == matchPointType2.type) {
                return matchPointType2;
            }
        }
        return matchPointType;
    }

    public String toString() {
        return "MatchPointType{type=" + this.type + '}';
    }
}
