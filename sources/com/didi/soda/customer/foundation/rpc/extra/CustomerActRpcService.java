package com.didi.soda.customer.foundation.rpc.extra;

import com.didi.soda.customer.foundation.rpc.entity.RedeemPageEntity;
import com.didi.soda.customer.foundation.rpc.entity.RedeemResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.SideBarRedeemEntity;
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
public interface CustomerActRpcService extends RpcService {
    @Serialization(CustomerFormSerializer.class)
    @Path("/act-api/api/code/redeemPage")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc redeemPage(@BodyParameter("code") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<RedeemPageEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/act-api/api/code/redeemResult")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc redeemResult(@BodyParameter("rid") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<RedeemResultEntity> customerRpcCallback);

    @Serialization(CustomerFormSerializer.class)
    @Path("/act-api/api/code/sidebarRedeem")
    @Post
    @Deserialization(CustomerDataDeserializer.class)
    Rpc sidebarRedeem(@BodyParameter("code") String str, @TargetThread(ThreadType.MAIN) CustomerRpcCallback<SideBarRedeemEntity> customerRpcCallback);
}
