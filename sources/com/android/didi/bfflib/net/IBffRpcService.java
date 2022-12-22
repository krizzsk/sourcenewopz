package com.android.didi.bfflib.net;

import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

interface IBffRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/halo/v1/multi/ability")
    @Post(contentType = "application/json")
    @Deserialization(StringDeserializer.class)
    void ability(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Serialization(GsonSerializer.class)
    @Path("/halo/v1/multi/ability")
    @Post(contentType = "application/json")
    @Deserialization(StringDeserializer.class)
    void abilityV2(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<String> callbackV2);
}
