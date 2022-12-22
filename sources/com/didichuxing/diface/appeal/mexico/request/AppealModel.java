package com.didichuxing.diface.appeal.mexico.request;

import android.content.Context;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.HttpParamUtils;
import com.didichuxing.diface.appeal.mexico.model.AppealParameters;
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

public class AppealModel {

    /* renamed from: b */
    private static final String f47080b = "dd_face_global_appeal_get_config";

    /* renamed from: a */
    private final IAppealRequester f47081a;

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    public interface IAppealRequester extends RpcService {
        @Serialization(GsonSerializer.class)
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void getGuideInfo(@QueryParameter("") Map<String, Object> map, @BodyParameter("") AppealParam appealParam, AbsRpcCallback<NewBaseResult<AppealParameters>, AppealParameters> absRpcCallback);
    }

    public AppealModel(Context context) {
        this.f47081a = (IAppealRequester) new RpcServiceFactory(context).newRpcService(IAppealRequester.class, HttpUtils.getHostNew(f47080b));
    }

    public void fetchAppealInfo(AppealParam appealParam, AbsRpcCallback<NewBaseResult<AppealParameters>, AppealParameters> absRpcCallback) {
        this.f47081a.getGuideInfo(HttpParamUtils.getQueryParam(new Gson().toJson((Object) appealParam)), appealParam, absRpcCallback);
    }
}
