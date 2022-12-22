package com.map.sdk.nav.libc.common;

import java.util.Locale;

public class RouteGuidanceGPSPoint {
    public int accuracy;
    public float heading;
    public int matchedStatus;
    public RouteGuidanceGPSPoint originMatchPoint;
    public GeoPoint point = new GeoPoint();
    public int segmentIndex;
    public int shapeOffSet;
    public int source;
    public long timestamp;
    public float velocity;

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[8];
        objArr[0] = Convertor.convert2LatLngFromGeoPoint(this.point);
        objArr[1] = Integer.valueOf(this.segmentIndex);
        objArr[2] = Integer.valueOf(this.shapeOffSet);
        objArr[3] = Float.valueOf(this.heading);
        objArr[4] = Integer.valueOf(this.accuracy);
        objArr[5] = Float.valueOf(this.velocity);
        objArr[6] = Integer.valueOf(this.source);
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = this.originMatchPoint;
        objArr[7] = routeGuidanceGPSPoint == null ? "empty" : routeGuidanceGPSPoint.toString();
        return String.format(locale, "matchPoint:%s, segmentIndex:%d, shapeOffSet:%d, heading:%.2f, accuracy:%d, velocity:%.2f, source:%d, 【originMatchPoint:%s】", objArr);
    }

    public String getLogStr() {
        return "cooridx=" + this.segmentIndex + "||lng=" + this.point.getLongitudeE6() + "||lat=" + this.point.getLatitudeE6() + "||dir=" + this.heading + "||timestamp=" + this.timestamp + "||speed=" + this.velocity;
    }

    public String getGpsLogStr() {
        return this.point.toString() + "," + this.accuracy + "," + this.heading + "," + this.velocity + "," + this.timestamp + ",0.0";
    }

    public RouteGuidanceGPSPoint copy() {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = new GeoPoint(this.point);
        routeGuidanceGPSPoint.velocity = this.velocity;
        routeGuidanceGPSPoint.timestamp = this.timestamp;
        routeGuidanceGPSPoint.source = this.source;
        routeGuidanceGPSPoint.shapeOffSet = this.shapeOffSet;
        routeGuidanceGPSPoint.segmentIndex = this.segmentIndex;
        routeGuidanceGPSPoint.matchedStatus = this.matchedStatus;
        routeGuidanceGPSPoint.heading = this.heading;
        routeGuidanceGPSPoint.accuracy = this.accuracy;
        return routeGuidanceGPSPoint;
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[40];
        System.arraycopy(MapSerializeUtil.intToBytes(this.segmentIndex), 0, bArr, 0, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.shapeOffSet), 0, bArr, 4, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.point.getLongitudeE6()), 0, bArr, 8, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.point.getLatitudeE6()), 0, bArr, 12, 4);
        System.arraycopy(MapSerializeUtil.floatToBytes(this.heading), 0, bArr, 16, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.accuracy), 0, bArr, 20, 4);
        System.arraycopy(MapSerializeUtil.floatToBytes(this.velocity), 0, bArr, 24, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.source), 0, bArr, 28, 4);
        System.arraycopy(MapSerializeUtil.longToBytes(this.timestamp), 0, bArr, 32, 8);
        return bArr;
    }

    public static RouteGuidanceGPSPoint fromBytes(byte[] bArr) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        routeGuidanceGPSPoint.segmentIndex = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 4, bArr2, 0, 4);
        routeGuidanceGPSPoint.shapeOffSet = MapSerializeUtil.bytesToInt(bArr2);
        int bytesToInt = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        routeGuidanceGPSPoint.point = TransformUtil.serverPointToGeoPoint(bytesToInt, MapSerializeUtil.bytesToInt(bArr2));
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        routeGuidanceGPSPoint.heading = MapSerializeUtil.bytesToFloat(bArr2);
        System.arraycopy(bArr, 16, bArr2, 0, 4);
        routeGuidanceGPSPoint.accuracy = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 20, bArr2, 0, 4);
        routeGuidanceGPSPoint.velocity = MapSerializeUtil.bytesToFloat(bArr2);
        System.arraycopy(bArr, 24, bArr2, 0, 4);
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArr, 28, bArr3, 0, 8);
        routeGuidanceGPSPoint.timestamp = MapSerializeUtil.bytesToLong(bArr3);
        return routeGuidanceGPSPoint;
    }

    public void fromBytesUpdate(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        this.segmentIndex = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 4, bArr2, 0, 4);
        this.shapeOffSet = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 8, bArr2, 0, 4);
        int bytesToInt = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 12, bArr2, 0, 4);
        int bytesToInt2 = MapSerializeUtil.bytesToInt(bArr2);
        this.point.setLongitudeE6(bytesToInt);
        this.point.setLatitudeE6(bytesToInt2);
        System.arraycopy(bArr, 16, bArr2, 0, 4);
        this.heading = MapSerializeUtil.bytesToFloat(bArr2);
        System.arraycopy(bArr, 20, bArr2, 0, 4);
        this.accuracy = MapSerializeUtil.bytesToInt(bArr2);
        System.arraycopy(bArr, 24, bArr2, 0, 4);
        this.velocity = MapSerializeUtil.bytesToFloat(bArr2);
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArr, 32, bArr3, 0, 8);
        this.timestamp = MapSerializeUtil.bytesToLong(bArr3);
    }
}
