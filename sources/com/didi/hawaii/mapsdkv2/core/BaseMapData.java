package com.didi.hawaii.mapsdkv2.core;

public interface BaseMapData {
    void cancelBaseMapDataTask(String str);

    void cancelMapDynamicLayerLoadTask(String str);

    int fetchTrafficBlockData(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    String getTrafficUpdateUrl();

    void refreshBaseMapData(byte[] bArr, String str, int i);

    void refreshDynamicLayerMapData(String str, byte[] bArr, int i);

    int refreshTrafficData(byte[] bArr, byte[] bArr2, int i);
}
