package com.sdk.poibase.model.reversegeotop;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface RpcServiceReverse extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/reversegeotop")
    @Deserialization(GsonDeserializer.class)
    Object fetchReverseLocation(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<ReverseResult> callback);
}
