package com.didichuxing.dfbasesdk.logupload;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.data.BaseInnerResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.utils.DFApi;
import java.util.List;

class LogUploader {

    /* renamed from: a */
    public static final int f46606a = 1;

    /* renamed from: b */
    private final String f46607b;

    /* renamed from: c */
    private final Handler f46608c = new UpHandler(Looper.getMainLooper());

    /* renamed from: d */
    private final Handler f46609d;

    LogUploader(Handler handler, String str) {
        this.f46609d = handler;
        this.f46607b = str;
    }

    /* renamed from: a */
    public Handler mo115662a() {
        return this.f46608c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33462a(int i, Object obj) {
        Message obtain = Message.obtain(this.f46609d);
        obtain.what = i;
        obtain.obj = obj;
        obtain.sendToTarget();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33465a(UploadObj uploadObj) {
        if (uploadObj.needUpload()) {
            final List<Object> list = uploadObj.ids;
            DFApi.postWithoutEnv(this.f46607b, uploadObj.jsonBody, new AbsOkHttpCallback<BaseInnerResult>() {
                public void onSuccess(BaseInnerResult baseInnerResult) {
                    LogUploader.this.m33462a(2, (Object) list);
                }

                public void onFailed(int i, String str) {
                    LogUploader.this.m33462a(3, (Object) list);
                }
            });
        }
    }

    private class UpHandler extends Handler {
        private UpHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                LogUploader.this.m33465a((UploadObj) message.obj);
            }
        }
    }
}
