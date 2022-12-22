package com.didichuxing.xpanel.agent.net;

import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface XPanelRequestService extends RpcService {
    @Get
    @Path("agent/v2/feeds")
    @Deserialization(StringDeserializer.class)
    void getAgent(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("agent/v3/feeds")
    @Deserialization(StringDeserializer.class)
    void getAgentv3(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("agent/v2/feeds")
    @Deserialization(StringDeserializer.class)
    void getDebugAgent(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("agent/v3/update")
    @Deserialization(StringDeserializer.class)
    void queryUpdateCard(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
