package com.didichuxing.diface.biz.bioassay.fpp.p182M.compare;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
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

/* renamed from: com.didichuxing.diface.biz.bioassay.fpp.M.compare.CompareModel */
public class CompareModel {

    /* renamed from: a */
    private Context f47226a;

    /* renamed from: com.didichuxing.diface.biz.bioassay.fpp.M.compare.CompareModel$IFppCompareRequester */
    public interface IFppCompareRequester extends RpcService {
        @Serialization(MultipartSerializer.class)
        @Post(contentType = "multipart/form-data")
        @Deserialization(GsonDeserializer.class)
        void compare(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, RpcService.Callback<CompareResult> callback);
    }

    public CompareModel(Context context) {
        this.f47226a = context.getApplicationContext();
    }

    public void compare(CompareParam compareParam, List<String> list, List<File> list2, final AbsHttpCallback<CompareResult> absHttpCallback) {
        IFppCompareRequester iFppCompareRequester = (IFppCompareRequester) new RpcServiceFactory(this.f47226a).newRpcService(IFppCompareRequester.class, HttpUtils.getHost());
        String json = new Gson().toJson((Object) compareParam);
        Map<String, Object> queryParam = HttpParamUtils.getQueryParam(json, HttpUtils.API_COMPARE);
        TreeMap<String, Object> convertObj2Map = HttpParamUtils.convertObj2Map(json);
        if (convertObj2Map == null) {
            convertObj2Map = new TreeMap<>();
        }
        if (!(list == null || list2 == null || list.size() != list2.size())) {
            for (int i = 0; i < list.size(); i++) {
                convertObj2Map.put(list.get(i), list2.get(i));
            }
        }
        iFppCompareRequester.compare(queryParam, convertObj2Map, new RpcService.Callback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, compareResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
