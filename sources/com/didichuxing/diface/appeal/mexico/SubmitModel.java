package com.didichuxing.diface.appeal.mexico;

import android.content.Context;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.utils.HttpUtils;
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
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubmitModel {

    /* renamed from: b */
    private static final String f47073b = "dd_face_global_appeal_material_submit_global";

    /* renamed from: a */
    private final ISubmitRequester f47074a;

    @Timeout(connectTimeout = 60000, readTimeout = 60000, writeTimeout = 60000)
    public interface ISubmitRequester extends RpcService {
        @Serialization(MultipartSerializer.class)
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        void submit(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, AbsRpcCallback<NewBaseResult<SubmitResult>, SubmitResult> absRpcCallback);
    }

    public SubmitModel(Context context) {
        this.f47074a = (ISubmitRequester) new RpcServiceFactory(context).newRpcService(ISubmitRequester.class, HttpUtils.getHostNew(f47073b));
    }

    public void submit(GlobalSubmitParam globalSubmitParam, List<String> list, List<File> list2, AbsRpcCallback<NewBaseResult<SubmitResult>, SubmitResult> absRpcCallback) {
        String json = new Gson().toJson((Object) globalSubmitParam);
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
        this.f47074a.submit(queryParam, convertObj2Map, absRpcCallback);
    }
}
