package com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed;

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

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedModel */
public class ReportFailedModel {

    /* renamed from: b */
    private static final String f47161b = "dd_face_global_report_living_fail";

    /* renamed from: a */
    private Context f47162a;

    /* renamed from: com.didichuxing.diface.biz.bioassay.alpha.M.report_failed.ReportFailedModel$IReportFailedRequester */
    public interface IReportFailedRequester extends RpcService {
        @Serialization(GsonSerializer.class)
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void report(@QueryParameter("") Map<String, Object> map, @BodyParameter("") ReportFailedParam reportFailedParam, RpcService.Callback<ReportFailedResult> callback);
    }

    public ReportFailedModel(Context context) {
        this.f47162a = context.getApplicationContext();
    }

    public void report(ReportFailedParam reportFailedParam, final AbsHttpCallback<ReportFailedResult> absHttpCallback) {
        ((IReportFailedRequester) new RpcServiceFactory(this.f47162a).newRpcService(IReportFailedRequester.class, HttpUtils.getHostNew(f47161b))).report(HttpParamUtils.getQueryParam(new Gson().toJson((Object) reportFailedParam)), reportFailedParam, new RpcService.Callback<ReportFailedResult>() {
            public void onSuccess(ReportFailedResult reportFailedResult) {
                HttpUtils.successCallbackSwitch(absHttpCallback, reportFailedResult);
            }

            public void onFailure(IOException iOException) {
                HttpUtils.failedCallbackSwitch(absHttpCallback, iOException);
            }
        });
    }
}
