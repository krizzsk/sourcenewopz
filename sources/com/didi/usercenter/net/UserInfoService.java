package com.didi.usercenter.net;

import com.didi.usercenter.net.pojo.UpdateInfoResponse;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
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
import java.util.Map;

public interface UserInfoService extends RpcService {
    @Serialization(FormSerializer.class)
    @Path("/passenger/profile/setsingleoption")
    @Post
    @Deserialization(GsonDeserializer.class)
    void setSingleOption(@QueryParameter("") @BodyParameter("") Map<String, String> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<UpdateInfoResponse> callback);

    @Serialization(GsonSerializer.class)
    @Path("/passenger/updateprofile")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    void updateProfile(@QueryParameter("") @BodyParameter("") Map<String, String> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<UpdateInfoResponse> callback);
}
