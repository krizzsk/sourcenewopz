package com.didichuxing.diface.biz.preguide.model;

import android.content.Context;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.biz.guide.p183M.GuideParam;
import com.didichuxing.diface.data.PreGuideResult;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.google.gson.Gson;
import java.util.Map;

public class PreGuideModel {

    /* renamed from: b */
    private static final String f47481b = "dd_face_global_preguide";

    /* renamed from: a */
    private final IPreGuideHttpRequester f47482a;

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    public interface IPreGuideHttpRequester extends RpcService {
        @Serialization(GsonSerializer.class)
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void getGuideInfo(@QueryParameter("") Map<String, Object> map, @BodyParameter("") GuideParam guideParam, AbsRpcCallback<NewBaseResult<PreGuideResult>, PreGuideResult> absRpcCallback);
    }

    public PreGuideModel(Context context) {
        this.f47482a = (IPreGuideHttpRequester) new RpcServiceFactory(context).newRpcService(IPreGuideHttpRequester.class, HttpUtils.getHostNew(f47481b));
    }

    public void fetchGuideInfo(GuideParam guideParam, AbsRpcCallback<NewBaseResult<PreGuideResult>, PreGuideResult> absRpcCallback) {
        this.f47482a.getGuideInfo(HttpParamUtils.getQueryParam(new Gson().toJson((Object) guideParam)), guideParam, absRpcCallback);
    }
}
