package com.didi.travel.psnger.biz.waitornot;

import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface IOrderInfoRpcService extends RpcService {
    @Get
    @Serialization(GsonSerializer.class)
    @Path("/gulfstream/passenger/v2/other/pGetOrderMatchInfo")
    @Deserialization(StringDeserializer.class)
    void getOrderMatchInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
