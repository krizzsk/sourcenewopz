package com.map.sdk.nav.libc.common;

public class DMKMapMatchConfig {
    public float corner_yaw_distance_ratio;
    public int corner_yaw_strategy;
    public float filterAccuracy;
    public int m_Max_offsetRadius;
    public int m_Min_offsetRadius;
    public float m_valid_angleDiff;
    public int yaw_Max_offsetRadius;
    public int yaw_Min_offsetRadius;
    public int yaw_accuracy_offset;
    public float yaw_direct_speed;
    public float yaw_outWay_credit;
    public float yaw_valid_angleDiff;

    public byte[] toBytes() {
        byte[] bArr = new byte[16];
        System.arraycopy(MapSerializeUtil.floatToBytes(this.filterAccuracy), 0, bArr, 0, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.m_Min_offsetRadius), 0, bArr, 4, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.m_Max_offsetRadius), 0, bArr, 8, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.yaw_Min_offsetRadius), 0, bArr, 12, 4);
        System.arraycopy(MapSerializeUtil.intToBytes(this.yaw_Max_offsetRadius), 0, bArr, 16, 4);
        System.arraycopy(MapSerializeUtil.floatToBytes(this.m_valid_angleDiff), 0, bArr, 20, 4);
        System.arraycopy(MapSerializeUtil.floatToBytes(this.yaw_valid_angleDiff), 0, bArr, 24, 4);
        return bArr;
    }
}
