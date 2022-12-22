package com.didi.sdk.componentconfig;

import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface ComponentService extends RpcService {
    @Path("/api/component")
    @Deserialization(StringDeserializer.class)
    Object getComponentConfig(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.WORKER) RpcService.Callback<String> callback);
}
