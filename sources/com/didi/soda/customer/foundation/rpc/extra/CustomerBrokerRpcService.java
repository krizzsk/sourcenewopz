package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.entity.splash.SplashEntity;
import com.didi.soda.customer.foundation.rpc.interceptor.CustomerParamsInterceptor;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerDataDeserializer;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerFormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.Rpc;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.ArrayList;

@Interception({CustomerParamsInterceptor.class})
public interface CustomerBrokerRpcService extends RpcService {
    @Serialization(CustomerFormSerializer.class)
    @Path("/skydome/batchGetActivityResource")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc batchGetActivityResource(@BodyParameter("pointIDs") ArrayList<String> arrayList, @BodyParameter("platform") String str, @BodyParameter("productId") String str2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<SplashEntity> customerRpcCallback);
}
