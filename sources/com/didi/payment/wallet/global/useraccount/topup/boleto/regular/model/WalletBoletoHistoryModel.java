package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
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

public class WalletBoletoHistoryModel {

    /* renamed from: a */
    private static final String f31936a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private WalletBoletoHistoryRpcService f31937b;

    /* renamed from: c */
    private Context f31938c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletBoletoHistoryRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/boleto/history")
        @Deserialization(GsonDeserializer.class)
        Object requestBoletoHistory(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBoletoHistoryResp> callback);
    }

    public WalletBoletoHistoryModel(Context context) {
        this.f31938c = context;
        this.f31937b = (WalletBoletoHistoryRpcService) new RpcServiceFactory(context).newRpcService(WalletBoletoHistoryRpcService.class, "https://wallet.didiglobal.com");
    }

    public void requestBoletoHistory(RpcService.Callback<WalletBoletoHistoryResp> callback) {
        this.f31937b.requestBoletoHistory(m22609a(this.f31938c), callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m22609a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
