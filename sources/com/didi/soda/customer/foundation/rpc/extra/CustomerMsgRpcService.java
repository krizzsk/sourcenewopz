package com.didi.soda.customer.foundation.rpc.extra;

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

@Interception({CustomerParamsInterceptor.class})
public interface CustomerMsgRpcService extends RpcService {
    @Serialization(CustomerFormSerializer.class)
    @Path("server/msgmonitor/update")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc msgUpdate(@BodyParameter("p_id") String str, @BodyParameter("state") int i, @BodyParameter("app_type") int i2, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);
}
