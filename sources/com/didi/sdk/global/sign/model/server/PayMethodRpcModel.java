package com.didi.sdk.global.sign.model.server;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.global.constant.GlobalServer;
import com.didi.sdk.global.paypal.model.bean.BaseResult;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.Map;

public class PayMethodRpcModel {

    /* renamed from: a */
    private PayMethodRpcService f36213a;

    /* renamed from: b */
    private Context f36214b;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface PayMethodRpcService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/web_wallet/international/external/wallet/all_entries/query")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestPayMethodList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PayMethodPageResponse> callback);

        @Serialization(GsonSerializer.class)
        @Path("/web_wallet/international/internal/pay/setCombinePaymentStatus")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object setCombinePaymentStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BaseResult> callback);
    }

    public PayMethodRpcModel(Context context) {
        this.f36214b = context;
        GlobalServer.initUrl();
        this.f36213a = (PayMethodRpcService) new RpcServiceFactory(context).newRpcService(PayMethodRpcService.class, GlobalServer.GLOBAL_HOST);
    }

    public void requestPayMethodList(RpcService.Callback<PayMethodPageResponse> callback) {
        this.f36213a.requestPayMethodList(m25601a(this.f36214b), callback);
    }

    public void setCombinePaymentStatus(boolean z, RpcService.Callback<BaseResult> callback) {
        HashMap<String, Object> a = m25601a(this.f36214b);
        a.put("enable", Boolean.valueOf(z));
        this.f36213a.setCombinePaymentStatus(a, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m25601a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
