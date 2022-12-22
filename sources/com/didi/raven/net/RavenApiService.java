package com.didi.raven.net;

import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.JSONDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public interface RavenApiService extends RpcService {
    @Serialization(FormSerializer.class)
    @Timeout(connectTimeout = 15000, readTimeout = 15000, writeTimeout = 15000)
    @Post
    @Deserialization(JSONDeserializer.class)
    void track(@BodyParameter("") Map<String, Object> map, @QueryParameter("lid") String str, @TargetThread(ThreadType.MAIN) RpcService.Callback<JSONObject> callback);

    @Serialization(GsonSerializer.class)
    @Post(contentType = "application/json")
    @Deserialization(JSONDeserializer.class)
    void trackPoolData(@BodyParameter("v") List<HashMap<String, Object>> list, @TargetThread(ThreadType.MAIN) RpcService.Callback<JSONObject> callback);
}
