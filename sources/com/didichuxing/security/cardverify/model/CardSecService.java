package com.didichuxing.security.cardverify.model;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.security.cardverify.model.bean.WithdrawPollResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawResult;
import com.didichuxing.security.cardverify.model.bean.WithdrawVerifyResult;
import java.util.Map;

public interface CardSecService extends RpcService {
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
    @Path("/sec/risk-gateway/common/request_random_payment_validate")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object verifyWithdraw(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawVerifyResult> callback);
}
