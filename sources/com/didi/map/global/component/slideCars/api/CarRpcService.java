package com.didi.map.global.component.slideCars.api;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

public interface CarRpcService extends RpcService {
    @Serialization(FormSerializer.class)
    @Path("gulfstream/realtimeDriverStat/get_driver_loc_json")
    @Post
    @Deserialization(GsonDeserializer.class)
    void getMultiCarNavigators(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<NearDriver> callbackV2);

    @Serialization(FormSerializer.class)
    @Path("gulfstream/realtimeDriverStat/get_driver_loc_by_id_json")
    @Post
    @Deserialization(GsonDeserializer.class)
    void getSingleCarNavigator(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<NearDriver> callbackV2);
}
