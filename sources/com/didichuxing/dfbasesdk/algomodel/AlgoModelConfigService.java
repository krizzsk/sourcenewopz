package com.didichuxing.dfbasesdk.algomodel;

import com.didichuxing.dfbasesdk.http.AccessSecurityGsonSerializer;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import java.util.Map;

public interface AlgoModelConfigService extends RpcService {
    @Serialization(AccessSecurityGsonSerializer.class)
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({AlgoModelConfigInterceptor.class})
    void getConfig(@QueryParameter("") Map<String, Object> map, @BodyParameter("") AlgoModelConfigParam algoModelConfigParam, RpcService.Callback<AlgoModelConfigResult> callback);

    @Serialization(AccessSecurityGsonSerializer.class)
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({AlgoModelConfigInterceptor.class})
    void requestReserve(@QueryParameter("") Map<String, Object> map, @BodyParameter("") AlgoModelConfigParam algoModelConfigParam, RpcService.Callback<AlgoModelConfigResult> callback);
}
