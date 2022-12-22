package com.didi.sdk.global.paypal.model;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.sdk.fastframe.entity.RpcBase;
import com.didi.sdk.global.paypal.model.bean.PayPalSignCancelResult;
import com.didi.sdk.global.paypal.model.bean.PayPalSignResult;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

@Interception({RequestMonitorInterceptor.class})
public interface PayPalService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdCancel")
    @Deserialization(GsonDeserializer.class)
    Object cancelSign(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PayPalSignCancelResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdSign")
    @Post
    @Deserialization(GsonDeserializer.class)
    void requestPaypalSignInfo(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PayPalSignResult> callback);

    @Serialization(FormSerializer.class)
    @Path("/web_wallet/passenger/withhold/verify")
    @Post
    @Deserialization(GsonDeserializer.class)
    void verifyPaypal(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<RpcBase> callback);
}
