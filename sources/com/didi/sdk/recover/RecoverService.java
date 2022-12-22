package com.didi.sdk.recover;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface RecoverService extends RpcService {
    @Get
    @Path("/passenger/orderrecover")
    @Deserialization(GsonDeserializer.class)
    void orderRecover(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RecoverInfo> callback);

    @Get
    @Path("/passenger/orderrecover")
    @Deserialization(GsonDeserializer.class)
    void orderRecoverOnLine(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RecoverInfo> callback);
}
