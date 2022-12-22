package com.sdk.poibase.model.city;

import com.didi.map.nettransformation.UrlRpcInterceptorV2;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

@Path("/geo")
@Interception({UrlRpcInterceptorV2.class})
public interface RpcCityService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/cities")
    @Deserialization(GsonDeserializer.class)
    void getCityList(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcCities> callback);
}
