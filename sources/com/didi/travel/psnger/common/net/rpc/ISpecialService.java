package com.didi.travel.psnger.common.net.rpc;

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
import java.util.HashMap;
import java.util.Map;

public interface ISpecialService extends RpcService {
    @Path("/resapi/activity/getMulti")
    @Post
    @Deserialization(StringDeserializer.class)
    void getActivityMulti(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Get
    @Path("/resapi/activity/get")
    @Deserialization(StringDeserializer.class)
    void getActivityRes(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("gulfstream/horae/v1/carpool/pGetCommuteConfig")
    @Post
    @Deserialization(StringDeserializer.class)
    void getCommuteConfig(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Serialization(FormSerializer.class)
    @Path("platformdiversion/guide")
    @Post(contentType = "application/x-www-form-urlencoded")
    @Deserialization(StringDeserializer.class)
    Object getDiversion(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("gulfstream/passenger/v2/other/pMapRouteInfo")
    @Post
    @Deserialization(StringDeserializer.class)
    Object getMapRouteInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("gulfstream/realtimeDriverStat/get_driver_loc_json")
    @Post
    @Deserialization(StringDeserializer.class)
    void sendLocationCallNearDrivers(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);

    @Path("gulfstream/realtimeDriverStat/get_driver_loc_by_id_json")
    @Post
    @Deserialization(StringDeserializer.class)
    void sendOnServiceNearDrivers(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
