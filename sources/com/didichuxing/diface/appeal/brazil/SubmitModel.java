package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.appeal.SubmitParam;
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
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubmitModel {

    /* renamed from: b */
    private static final String f47059b = "dd_face_global_appeal_material_submit";

    /* renamed from: c */
    private static final String f47060c = "dd_face_global_appeal_material_submit_v2";

    /* renamed from: a */
    private Context f47061a;

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    public interface ISubmitRequester extends RpcService {
        @Serialization(MultipartSerializer.class)
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        void submit(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, RpcService.Callback<SubmitResult> callback);
    }

    public SubmitModel(Context context) {
        this.f47061a = context.getApplicationContext();
    }

    public void submit(SubmitParam submitParam, List<String> list, List<File> list2, final AbsHttpCallback<SubmitResult> absHttpCallback) {
        ISubmitRequester iSubmitRequester = (ISubmitRequester) new RpcServiceFactory(this.f47061a).newRpcService(ISubmitRequester.class, HttpUtils.getHostNew(f47060c));
        String json = new Gson().toJson((Object) submitParam);
        Map<String, Object> queryParam = HttpParamUtils.getQueryParam(json);
        TreeMap<String, Object> convertObj2Map = HttpParamUtils.convertObj2Map(json);
        if (convertObj2Map == null) {
            convertObj2Map = new TreeMap<>();
        }
        if (!(list == null || list2 == null || list.size() != list2.size())) {
            for (int i = 0; i < list.size(); i++) {
                convertObj2Map.put(list.get(i), list2.get(i));
            }
        }
        iSubmitRequester.submit(queryParam, convertObj2Map, new RpcService.Callback<SubmitResult>() {
            public void onSuccess(SubmitResult submitResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, submitResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
