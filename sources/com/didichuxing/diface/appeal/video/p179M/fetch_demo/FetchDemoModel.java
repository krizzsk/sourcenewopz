package com.didichuxing.diface.appeal.video.p179M.fetch_demo;

import android.content.Context;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.didichuxing.diface.appeal.video.M.fetch_demo.FetchDemoModel */
public class FetchDemoModel {

    /* renamed from: a */
    private Context f47129a;

    /* renamed from: com.didichuxing.diface.appeal.video.M.fetch_demo.FetchDemoModel$IFetchDemoRequester */
    public interface IFetchDemoRequester extends RpcService {
        @Serialization(GsonSerializer.class)
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void fetch(@QueryParameter("") Map<String, Object> map, @BodyParameter("") FetchDemoParam fetchDemoParam, RpcService.Callback<FetchDemoResult> callback);
    }

    public FetchDemoModel(Context context) {
        this.f47129a = context.getApplicationContext();
    }

    public void fetch(final AbsHttpCallback<FetchDemoResult> absHttpCallback) {
        Gson gson = new Gson();
        FetchDemoParam fetchDemoParam = new FetchDemoParam();
        ((IFetchDemoRequester) new RpcServiceFactory(this.f47129a).newRpcService(IFetchDemoRequester.class, HttpUtils.getHost())).fetch(HttpParamUtils.getQueryParam(gson.toJson((Object) fetchDemoParam), HttpUtils.API_FETCH_DEMO), fetchDemoParam, new RpcService.Callback<FetchDemoResult>() {
            public void onSuccess(FetchDemoResult fetchDemoResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, fetchDemoResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
