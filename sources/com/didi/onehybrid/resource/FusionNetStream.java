package com.didi.onehybrid.resource;

import android.text.TextUtils;
import com.didi.onehybrid.resource.FusionBridgeStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FusionNetStream extends InputStream {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f29692a;

    /* renamed from: b */
    private Map<String, String> f29693b;

    /* renamed from: c */
    private FusionBridgeStream f29694c;

    /* renamed from: d */
    private boolean f29695d = true;

    public FusionNetStream(String str, Map<String, String> map) {
        this.f29692a = str;
        this.f29693b = map;
    }

    public int read() throws IOException {
        if (this.f29694c == null && this.f29695d) {
            m20851a();
        }
        FusionBridgeStream fusionBridgeStream = this.f29694c;
        if (fusionBridgeStream != null) {
            return fusionBridgeStream.read();
        }
        return -1;
    }

    /* renamed from: a */
    private void m20851a() {
        final FusionHttpClient fusionHttpClient = new FusionHttpClient(this.f29692a, this.f29693b);
        if (fusionHttpClient.connect() != 0) {
            this.f29695d = false;
        } else if (200 == fusionHttpClient.getResponseCode()) {
            final String headerValue = fusionHttpClient.getHeaderValue("Content-Type");
            final Map<String, List<String>> responseHeader = fusionHttpClient.getResponseHeader();
            FusionBridgeStream fusionBridgeStream = new FusionBridgeStream(fusionHttpClient.getResponseStream());
            this.f29694c = fusionBridgeStream;
            fusionBridgeStream.setOnCloseListener(new FusionBridgeStream.OnCloseListener() {
                public void onClose(boolean z, final ByteArrayOutputStream byteArrayOutputStream) {
                    if (!TextUtils.isEmpty(headerValue)) {
                        String str = headerValue.split(";")[0];
                        FusionAsynDispatcher.Instance.asynRunTask(new Runnable() {
                            public void run() {
                                FusionCacheClient.sInstance.saveHeaders(FusionNetStream.this.f29692a, responseHeader);
                                FusionCacheClient.sInstance.saveBody(FusionNetStream.this.f29692a, byteArrayOutputStream);
                                fusionHttpClient.disconnect();
                            }
                        }, 2, TimeUnit.SECONDS);
                    }
                }
            });
        } else {
            this.f29695d = false;
        }
    }

    public void close() throws IOException {
        super.close();
        FusionBridgeStream fusionBridgeStream = this.f29694c;
        if (fusionBridgeStream != null) {
            fusionBridgeStream.close();
        }
    }
}
