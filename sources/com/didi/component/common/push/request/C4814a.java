package com.didi.component.common.push.request;

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
import java.util.Map;

/* renamed from: com.didi.component.common.push.request.a */
/* compiled from: IPushRpcService */
interface C4814a extends RpcService {
    @Get
    @Path("server/msgmonitor/pull")
    @Deserialization(StringDeserializer.class)
    /* renamed from: a */
    void mo47010a(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("server/msgmonitor/update")
    @Deserialization(StringDeserializer.class)
    /* renamed from: a */
    void mo47011a(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
