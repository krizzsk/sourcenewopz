package com.didi.payment.paymethod.server.global;

import com.didi.payment.base.interceptor.HeaderInterceptor;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.paymethod.server.global.response.BalanceQueryResp;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.server.global.response.SignResultResp;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.Map;

@Path("/web_wallet/passenger")
@Interception({HeaderInterceptor.class, RequestMonitorInterceptor.class})
@Timeout(connectTimeout = 30000)
public interface GlobalRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/withholdCancel")
    @Deserialization(GsonDeserializer.class)
    Object cancelSign(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignCancelResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/withholdPollingQuery")
    @Deserialization(GsonDeserializer.class)
    Object pollSignStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignPollingQueryResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/queryPaypayBalance")
    @Deserialization(GsonDeserializer.class)
    Object queryBalance(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BalanceQueryResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/withholdSign")
    @Deserialization(GsonDeserializer.class)
    Object sign(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignResultResp> callback);
}
