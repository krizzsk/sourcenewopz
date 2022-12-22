package com.didi.hawaii.mapsdkv2;

import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.BaseMapData;
import com.didi.hawaii.mapsdkv2.core.GLHttpClient;

class HWMapDataHandler$1 implements Runnable {
    final /* synthetic */ C9015b this$0;
    final /* synthetic */ BaseMapData val$baseMapData;
    final /* synthetic */ int val$language;
    final /* synthetic */ String val$tileIndex;

    HWMapDataHandler$1(C9015b bVar, int i, String str, BaseMapData baseMapData) {
        this.this$0 = bVar;
        this.val$language = i;
        this.val$tileIndex = str;
        this.val$baseMapData = baseMapData;
    }

    public void run() {
        final String a = this.this$0.m16909a(this.val$language, this.val$tileIndex);
        this.this$0.f23782l.doGet(a, new GLHttpClient.Callback() {
            public void onSuccess(int i, byte[] bArr) {
                HWMapDataHandler$1.this.val$baseMapData.refreshBaseMapData(bArr, HWMapDataHandler$1.this.val$tileIndex, HWMapDataHandler$1.this.val$language);
            }

            public void onFailed(int i, Exception exc) {
                HWMapDataHandler$1.this.val$baseMapData.cancelBaseMapDataTask(HWMapDataHandler$1.this.val$tileIndex);
                MapLog.m16915e("HWMapDataHandler", "Failed to fetch " + a + " because of " + exc);
            }
        });
    }
}
