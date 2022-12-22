package com.didi.map.base;

import com.didi.map.outer.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;

public class TrafficEventRoutePoint implements Comparable<TrafficEventRoutePoint> {
    public int accessType;
    public ArrayList<String> bubbleText = new ArrayList<>(2);
    public String[] bubbleTextNav;
    public int coorIdx;
    public long eventId;
    public boolean isFake;
    public long mRouteId;
    public int mSubId;
    public int mType;
    public int minShowLevel;
    public LatLng pos;
    public int rank;
    public int shapeOffset;
    public int status = 0;
    public String thumbnail_url;
    public int vPriority;
    public String vThumbnailUrl;

    public String toString() {
        return "TrafficEventRoutePoint{eventId=" + this.eventId + ", mSubId=" + this.mSubId + ", mType=" + this.mType + ", shapeOffset=" + this.shapeOffset + ", coorIdx=" + this.coorIdx + ", accessType=" + this.accessType + ", bubbleText=" + this.bubbleText + ", pos=" + this.pos + ", minShowLevel=" + this.minShowLevel + ", isFake=" + this.isFake + ", rank=" + this.rank + ", bubbleTextNav=" + Arrays.toString(this.bubbleTextNav) + ", status=" + this.status + ", mRouteId=" + this.mRouteId + ", thumbnail_url='" + this.thumbnail_url + '\'' + ", vThumbnailUrl='" + this.vThumbnailUrl + '\'' + ", vPriority=" + this.vPriority + '}';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (com.didi.map.base.TrafficEventRoutePoint) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.didi.map.base.TrafficEventRoutePoint
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            com.didi.map.base.TrafficEventRoutePoint r5 = (com.didi.map.base.TrafficEventRoutePoint) r5
            int r1 = r5.mType
            if (r1 != r1) goto L_0x0023
            boolean r1 = r5.isFake
            boolean r3 = r4.isFake
            if (r1 != r3) goto L_0x0023
            com.didi.map.outer.model.LatLng r1 = r4.pos
            if (r1 == 0) goto L_0x0023
            com.didi.map.outer.model.LatLng r5 = r5.pos
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.base.TrafficEventRoutePoint.equals(java.lang.Object):boolean");
    }

    public int compareTo(TrafficEventRoutePoint trafficEventRoutePoint) {
        int i = this.rank;
        int i2 = trafficEventRoutePoint.rank;
        if (i != i2) {
            return i > i2 ? -1 : 1;
        }
        if (getTrafficIconTypePriority(this.mType) == getTrafficIconTypePriority(trafficEventRoutePoint.mType)) {
            return 0;
        }
        return getTrafficIconTypePriority(this.mType) > getTrafficIconTypePriority(trafficEventRoutePoint.mType) ? -1 : 1;
    }

    public static int getTrafficIconTypePriority(int i) {
        switch (i / 100) {
            case 0:
                return 210;
            case 1:
                return 209;
            case 2:
                return 208;
            case 3:
                return 207;
            case 4:
                return 205;
            case 5:
                return 206;
            case 6:
                return 204;
            case 7:
                return 203;
            default:
                return 0;
        }
    }
}
