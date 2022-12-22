package com.didi.sdk.sidebar.travelsafe;

import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;

public interface TravelSafetyService extends RpcService {
    @Serialization(FormSerializer.class)
    @Path("/passenger/syncTravelSafetySettings")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object syncAutoShareTravel(@QueryParameter("token") String str, @BodyParameter("params") String str2, @QueryParameter("type") int i, @TargetThread(ThreadType.MAIN) RpcService.Callback<TripSecurityResponse> callback);
}
