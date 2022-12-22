package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerDataDeserializer;
import com.didi.soda.customer.foundation.rpc.serializer.CustomerFormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.HashMap;

public interface CustomerPushRpcService extends RpcService {
    @Get
    @Serialization(CustomerFormSerializer.class)
    @Path("/server/idcollector/p_cidcollector")
    @Deserialization(CustomerDataDeserializer.class)
    void noticeMsgCenter(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<Object> customerRpcCallback);
}
