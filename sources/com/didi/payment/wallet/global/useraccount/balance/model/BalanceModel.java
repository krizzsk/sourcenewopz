package com.didi.payment.wallet.global.useraccount.balance.model;

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

public class BalanceModel {

    /* renamed from: a */
    private static final String f31809a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private BalanceRpcService f31810b;

    /* renamed from: c */
    private Context f31811c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface BalanceRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/statements")
        @Deserialization(GsonDeserializer.class)
        Object requestBalanceList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BalanceResp> callback);
    }

    public BalanceModel(Context context) {
        this.f31811c = context;
        this.f31810b = (BalanceRpcService) new RpcServiceFactory(context).newRpcService(BalanceRpcService.class, "https://wallet.didiglobal.com");
    }

    public void requestBalanceList(long j, int i, String str, RpcService.Callback<BalanceResp> callback) {
        HashMap<String, Object> a = m22546a(this.f31811c);
        a.put("start_index", Long.valueOf(j));
        a.put("page_size", 10);
        a.put("channel_id", Integer.valueOf(i));
        a.put("currency", str);
        this.f31810b.requestBalanceList(a, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m22546a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
