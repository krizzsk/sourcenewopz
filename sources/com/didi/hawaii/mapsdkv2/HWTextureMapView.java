package com.didi.hawaii.mapsdkv2;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.hawaii.mapsdkv2.core.GLHttpClient;
import com.didi.hawaii.net.NetUtil;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.map.outer.map.MapOptions;
import com.didi.map.outer.map.OnMapReadyCallback;

public class HWTextureMapView extends HWTextureMapViewInner {
    public void setZOrderMediaOverlay(boolean z) {
    }

    public /* bridge */ /* synthetic */ void dumpInspectInfo() {
        super.dumpInspectInfo();
    }

    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    public /* bridge */ /* synthetic */ void setOnMapReadyCallback(OnMapReadyCallback onMapReadyCallback) {
        super.setOnMapReadyCallback(onMapReadyCallback);
    }

    public HWTextureMapView(Context context) {
        super(context);
    }

    public HWTextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HWTextureMapView(Context context, MapOptions mapOptions) {
        super(context, mapOptions);
    }

    /* access modifiers changed from: protected */
    public GLHttpClient getHttpClient() {
        return new HWGLHttpClient();
    }

    private static class HWGLHttpClient implements GLHttpClient {
        private HWGLHttpClient() {
        }

        public void doGet(String str, final GLHttpClient.Callback callback) {
            AsyncNetUtils.doGet(str, new AsyncNetUtils.Callback() {
                public void onSuccess(byte[] bArr) {
                    callback.onSuccess(200, bArr);
                }

                public void onFailed(int i, Exception exc) {
                    callback.onFailed(i, exc);
                }
            });
        }

        public void doPost(String str, byte[] bArr, final GLHttpClient.Callback callback) {
            AsyncNetUtils.doPost(str, bArr, new AsyncNetUtils.Callback() {
                public void onSuccess(byte[] bArr) {
                    callback.onSuccess(200, bArr);
                }

                public void onFailed(int i, Exception exc) {
                    callback.onFailed(i, exc);
                }
            });
        }

        public GLHttpClient.Res doGet(String str) {
            try {
                NetUtil.NetResponse doGet = NetUtil.doGet(str);
                if (doGet == null) {
                    return null;
                }
                GLHttpClient.Res res = new GLHttpClient.Res();
                res.bytes = doGet.bytResponse;
                res.retCode = 200;
                return res;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public GLHttpClient.Res doPost(String str, byte[] bArr) {
            try {
                NetUtil.NetResponse doPost = NetUtil.doPost(str, bArr);
                if (doPost == null) {
                    return null;
                }
                GLHttpClient.Res res = new GLHttpClient.Res();
                res.bytes = doPost.bytResponse;
                res.retCode = 200;
                return res;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
