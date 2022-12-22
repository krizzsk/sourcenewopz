package com.map.sdk.nav.libc.common;

public class DMKEventPoint {
    public int distance;
    public int eventIdx;
    public int eventPointType;
    public int geoIndex;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.geoIndex == ((DMKEventPoint) obj).geoIndex) {
            return true;
        }
        return false;
    }
}
