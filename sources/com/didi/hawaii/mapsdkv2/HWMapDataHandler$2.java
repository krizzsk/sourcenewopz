package com.didi.hawaii.mapsdkv2;

import com.didi.hawaii.log.HwDLog;
import com.didi.hawaii.mapsdkv2.core.BaseMapData;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.GLHttpClient;

class HWMapDataHandler$2 implements Runnable {
    final /* synthetic */ C9015b this$0;
    final /* synthetic */ BaseMapData val$baseMapData;
    final /* synthetic */ GLBaseMapView val$baseMapView;
    final /* synthetic */ byte[] val$bodyContent;
    final /* synthetic */ boolean val$needAppendUserInfo;
    final /* synthetic */ String val$urlParams;

    HWMapDataHandler$2(C9015b bVar, String str, boolean z, byte[] bArr, GLBaseMapView gLBaseMapView, BaseMapData baseMapData) {
        this.this$0 = bVar;
        this.val$urlParams = str;
        this.val$needAppendUserInfo = z;
        this.val$bodyContent = bArr;
        this.val$baseMapView = gLBaseMapView;
        this.val$baseMapData = baseMapData;
    }

    public void run() {
        String str = this.this$0.m16908a() + this.val$urlParams;
        HwDLog.m16764d("________dynamicdebug_____", "" + str, new Object[0]);
        if (this.this$0.f23782l != null) {
            this.this$0.f23782l.doPost(str, this.val$bodyContent, new GLHttpClient.Callback() {
                public void onSuccess(int i, byte[] bArr) {
                    int i2 = 0;
                    HwDLog.m16764d("________dynamicdebug_____", "onSuccess", new Object[0]);
                    if (HWMapDataHandler$2.this.val$baseMapView != null) {
                        i2 = HWMapDataHandler$2.this.val$baseMapView.getLanguage();
                    }
                    if (HWMapDataHandler$2.this.val$baseMapData != null) {
                        HWMapDataHandler$2.this.val$baseMapData.refreshDynamicLayerMapData(HWMapDataHandler$2.this.val$urlParams, bArr, i2);
                    }
                }

                public void onFailed(int i, Exception exc) {
                    HwDLog.m16764d("________dynamicdebug_____", "onFailed", new Object[0]);
                    if (HWMapDataHandler$2.this.val$baseMapData != null) {
                        HWMapDataHandler$2.this.val$baseMapData.cancelMapDynamicLayerLoadTask(HWMapDataHandler$2.this.val$urlParams);
                    }
                }
            });
        }
    }
}
