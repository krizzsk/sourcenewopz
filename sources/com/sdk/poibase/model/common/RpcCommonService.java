package com.sdk.poibase.model.common;

import com.didi.map.nettransformation.UrlRpcInterceptorV2;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

@Path("/fav")
@Interception({UrlRpcInterceptorV2.class})
public interface RpcCommonService extends RpcService {
    @Serialization(FormSerializer.class)
    @Path("/delete")
    @Post
    @Deserialization(GsonDeserializer.class)
    void deleteAddress(@BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcCommonDelete> callback);

    @Serialization(FormSerializer.class)
    @Path("/gets")
    @Post
    @Deserialization(GsonDeserializer.class)
    void getCommonAddress(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcCommon> callback);

    @Serialization(FormSerializer.class)
    @Path("/update")
    @Post
    @Deserialization(StringDeserializer.class)
    void setCommonAddress(@BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
