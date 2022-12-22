package com.didichuxing.diface.biz.guide.p183M;

import android.content.Context;
import com.didichuxing.dfbasesdk.http.BizAccessInterceptor;
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
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.didichuxing.diface.biz.guide.M.GuideModel */
public class GuideModel {

    /* renamed from: b */
    private static final String f47463b = "dd_face_global_guide";

    /* renamed from: a */
    private Context f47464a;

    @Timeout(connectTimeout = 30000, readTimeout = 30000, writeTimeout = 30000)
    @Interception({BizAccessInterceptor.class})
    /* renamed from: com.didichuxing.diface.biz.guide.M.GuideModel$IGuideHttpRequester */
    public interface IGuideHttpRequester extends RpcService {
        @Serialization(GsonSerializer.class)
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void getGuideInfo(@QueryParameter("") Map<String, Object> map, @BodyParameter("") GuideParam guideParam, RpcService.Callback<GuideResult> callback);
    }

    public GuideModel(Context context) {
        this.f47464a = context.getApplicationContext();
    }

    public void fetchGuideInfo(GuideParam guideParam, final AbsHttpCallback<GuideResult> absHttpCallback) {
        ((IGuideHttpRequester) new RpcServiceFactory(this.f47464a).newRpcService(IGuideHttpRequester.class, HttpUtils.getHostNew(f47463b))).getGuideInfo(HttpParamUtils.getQueryParam(new Gson().toJson((Object) guideParam)), guideParam, new RpcService.Callback<GuideResult>() {
            public void onSuccess(GuideResult guideResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, guideResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
