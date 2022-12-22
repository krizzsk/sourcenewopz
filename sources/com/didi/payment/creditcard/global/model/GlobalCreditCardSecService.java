package com.didi.payment.creditcard.global.model;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.creditcard.global.model.bean.WithdrawPageInfo;
import com.didi.payment.creditcard.global.model.bean.WithdrawPollResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawVerifyResult;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

@Interception({RequestMonitorInterceptor.class})
public interface GlobalCreditCardSecService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/sec/risk-gateway/common/request_random_payment")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object doWithdraw(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/sec/risk-gateway/common/request_random_payment_status")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object pollingQueryWithdrawStatus(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawPollResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/sec/risk-gateway/common/request_random_payment_status_24h")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object requestWithdrawInfo(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawPageInfo> callback);

    @Serialization(GsonSerializer.class)
    @Path("/sec/risk-gateway/common/request_random_payment_validate")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object verifyWithdraw(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawVerifyResult> callback);
}
