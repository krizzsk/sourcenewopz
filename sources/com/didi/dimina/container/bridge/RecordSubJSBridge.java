package com.didi.dimina.container.bridge;

import android.media.MediaRecorder;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RecordSubJSBridge {

    /* renamed from: b */
    private static final int[] f16648b = {8000, 11025, 22050, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR};

    /* renamed from: a */
    MediaRecorder f16649a;

    /* renamed from: c */
    private final DMSandboxHelper f16650c;

    /* renamed from: d */
    private final DMMina f16651d;

    /* renamed from: e */
    private String f16652e;

    /* renamed from: f */
    private CallbackFunction f16653f;

    public RecordSubJSBridge(DMMina dMMina) {
        LogUtil.m13411i("RecordSubJSBridge init");
        this.f16651d = dMMina;
        this.f16650c = new DMSandboxHelper(dMMina.getConfig());
    }

    public void startRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            this.f16652e = this.f16650c.getSandboxTmpDir() + File.separator + System.currentTimeMillis() + ".amr";
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.f16649a = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.f16649a.setOutputFormat(3);
            this.f16649a.setOutputFile(this.f16652e);
            this.f16649a.setAudioEncoder(1);
            this.f16649a.setAudioChannels(1);
            this.f16649a.setAudioSamplingRate(f16648b[3]);
            this.f16649a.setAudioEncodingBitRate(96000);
            this.f16649a.prepare();
            this.f16649a.start();
            this.f16653f = callbackFunction;
        } catch (IllegalStateException e) {
            LogUtil.m13409e(e.getMessage());
        } catch (IOException unused) {
            LogUtil.m13409e("prepare() failed");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CallBackUtil.onSuccess(callbackFunction);
        MediaRecorder mediaRecorder = this.f16649a;
        if (mediaRecorder != null && this.f16653f != null) {
            try {
                mediaRecorder.stop();
                this.f16649a.release();
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", this.f16650c.filepath2url(this.f16652e));
                CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, this.f16653f);
            } catch (IllegalStateException e) {
                CallBackUtil.onFail(e.getMessage(), this.f16653f);
            }
        }
    }
}
