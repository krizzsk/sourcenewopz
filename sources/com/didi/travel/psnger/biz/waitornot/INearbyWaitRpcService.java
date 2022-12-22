package com.didi.travel.psnger.biz.waitornot;

import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface INearbyWaitRpcService extends RpcService {
    @Serialization(FormSerializer.class)
    @Path("/gulfstream/passenger/v2/other/pUpdateOrderInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    void confirmNearbyWait(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("/gulfstream/passenger/v2/other/pUpdateCompanyOrder")
    @Deserialization(StringDeserializer.class)
    void updateCompanyOrderInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
