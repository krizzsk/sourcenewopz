package com.didichuxing.diface.biz.bioassay.alpha.p180M.upload_capture;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.http.MultipartSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.upload_capture.UploadCaptureModel */
public class UploadCaptureModel {

    /* renamed from: b */
    private static volatile UploadCaptureModel f47163b;

    /* renamed from: a */
    private Context f47164a;

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.upload_capture.UploadCaptureModel$IUploadCaptureRequester */
    public interface IUploadCaptureRequester extends RpcService {
        @Serialization(MultipartSerializer.class)
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        void upload(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, RpcService.Callback<UploadCaptureResult> callback);
    }

    private UploadCaptureModel(Context context) {
        this.f47164a = context.getApplicationContext();
    }

    public static UploadCaptureModel getInstance(Context context) {
        if (f47163b == null) {
            synchronized (UploadCaptureModel.class) {
                if (f47163b == null) {
                    f47163b = new UploadCaptureModel(context);
                }
            }
        }
        return f47163b;
    }

    public void upload(String str, List<String> list, List<File> list2, final AbsHttpCallback<UploadCaptureResult> absHttpCallback) {
        IUploadCaptureRequester iUploadCaptureRequester = (IUploadCaptureRequester) new RpcServiceFactory(this.f47164a).newRpcService(IUploadCaptureRequester.class, HttpUtils.getHost());
        UploadCaptureParam uploadCaptureParam = new UploadCaptureParam();
        uploadCaptureParam.sessionId = str;
        String json = new Gson().toJson((Object) uploadCaptureParam);
        Map<String, Object> queryParam = HttpParamUtils.getQueryParam(json, HttpUtils.API_UPLOAD_CAPTURE);
        TreeMap<String, Object> convertObj2Map = HttpParamUtils.convertObj2Map(json);
        if (convertObj2Map == null) {
            convertObj2Map = new TreeMap<>();
        }
        if (!(list == null || list2 == null || list.size() != list2.size())) {
            for (int i = 0; i < list.size(); i++) {
                convertObj2Map.put(list.get(i), list2.get(i));
            }
        }
        final long currentTimeMillis = System.currentTimeMillis();
        iUploadCaptureRequester.upload(queryParam, convertObj2Map, new RpcService.Callback<UploadCaptureResult>() {
            public void onSuccess(UploadCaptureResult uploadCaptureResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, uploadCaptureResult);
                long currentTimeMillis = System.currentTimeMillis();
                LogUtils.m33563d("upload consume: " + (currentTimeMillis - currentTimeMillis) + "ms");
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
