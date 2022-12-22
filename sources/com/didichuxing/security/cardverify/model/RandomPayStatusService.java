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
import com.didichuxing.security.cardverify.model.bean.WithdrawPageInfo;
import java.util.Map;

public interface RandomPayStatusService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/sec/risk-gateway/common/request_random_payment_status_24h")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object requestWithdrawInfo(@BodyParameter("data") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WithdrawPageInfo> callback);
}
