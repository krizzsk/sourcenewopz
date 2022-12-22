package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.hawaii.mapsdkv2.jni.SwigMapCallback;
import java.util.List;

class MapEngineImpl$2 extends SwigMapCallback {
    final /* synthetic */ C9186f this$0;
    final /* synthetic */ MapEngine.Callback val$mapEngineCallback;

    MapEngineImpl$2(C9186f fVar, MapEngine.Callback callback) {
        this.this$0 = fVar;
        this.val$mapEngineCallback = callback;
    }

    public Object OnGetText(String str, float f, int i, int i2, int i3, int i4, boolean z) {
        return this.val$mapEngineCallback.onLoadTextBitmap(str, (int) (((float) i) * f), i2, i3, i4, z);
    }

    /* access modifiers changed from: protected */
    public Object OnGetTextSize(String str, int i, boolean z) {
        return this.val$mapEngineCallback.onGetTextSize(str, i, z);
    }

    /* access modifiers changed from: protected */
    public void OnDownload(String str) {
        this.val$mapEngineCallback.onDownload(str);
    }

    /* access modifiers changed from: protected */
    public Object OnGetImage(int i, String str) {
        return this.val$mapEngineCallback.onLoadBitmap(i, str);
    }

    public void OnWriteFile(String str, byte[] bArr) {
        this.val$mapEngineCallback.onWriteFile(str, bArr);
    }

    /* access modifiers changed from: protected */
    public Object OnLoadHeatTile(int i, int i2, int i3) {
        if (this.this$0.f24026c != null) {
            return this.this$0.f24026c.onLoadTile(i, i2, i3);
        }
        return super.OnLoadHeatTile(i, i2, i3);
    }

    public void OnLabelOnRouteList(Object obj) {
        this.val$mapEngineCallback.onLabelOnRouteNew((List) obj);
    }

    public void OnMapDynamicLayerDownload(boolean z, String str, byte[] bArr, int i) {
        MapEngine.Callback callback = this.val$mapEngineCallback;
        if (callback != null) {
            callback.onDownloadDynamicLayer(z, str, bArr, i);
        }
    }
}
