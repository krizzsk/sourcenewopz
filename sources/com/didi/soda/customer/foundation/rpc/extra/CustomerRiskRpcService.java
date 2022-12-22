package com.didi.soda.customer.foundation.rpc.extra;

import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface CustomerRiskRpcService extends RpcService {
    @Path("shepherd/api/fb/risk")
    @Post
    @Deserialization(StringDeserializer.class)
    void uploadFacebookToken(@QueryParameter("") @BodyParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<String> callback);
}
