package com.didi.hawaii.mapsdkv2.core;

public interface MapDataUpdateHandler {
    void onDownloadDynamicLayer(GLBaseMapView gLBaseMapView, BaseMapData baseMapData, boolean z, String str, byte[] bArr);

    void onUpdateBaseMapData(GLBaseMapView gLBaseMapView, BaseMapData baseMapData, String str);

    int onUpdateTrafficData(GLBaseMapView gLBaseMapView, BaseMapData baseMapData);
}
