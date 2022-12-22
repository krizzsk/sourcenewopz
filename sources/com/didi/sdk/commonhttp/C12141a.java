package com.didi.sdk.commonhttp;

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

/* renamed from: com.didi.sdk.commonhttp.a */
/* compiled from: IGeneralRpcService */
interface C12141a extends RpcService {
    @Get
    @Path("webapp/sharetrips/content")
    @Deserialization(StringDeserializer.class)
    /* renamed from: a */
    Object mo91344a(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
