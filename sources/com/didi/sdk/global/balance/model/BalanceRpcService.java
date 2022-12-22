package com.didi.sdk.global.balance.model;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

@Deprecated
@Interception({RequestMonitorInterceptor.class})
public interface BalanceRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/international/external/wallet/all_balance/query")
    @Post
    @Deserialization(GsonDeserializer.class)
    void queryBalanceAccountsInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BalancePageResponse> callback);
}
