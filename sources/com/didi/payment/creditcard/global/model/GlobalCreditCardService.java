package com.didi.payment.creditcard.global.model;

import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.creditcard.global.model.bean.BindCardInfo;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.PollResult;
import com.didi.payment.creditcard.global.model.bean.PublicKeyInfo;
import com.didi.payment.creditcard.global.model.bean.SignCancelCheckResult;
import com.didi.payment.creditcard.global.model.bean.SignCancelResult;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.model.bean.SignThreeDSResult;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
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
public interface GlobalCreditCardService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdCancel")
    @Deserialization(GsonDeserializer.class)
    Object cancelSign(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignCancelResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdCancelPreCheck")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object cancelSignCheck(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignCancelCheckResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withhold/checkCardNo")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object checkCardNo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdSign")
    @Post
    @Deserialization(GsonDeserializer.class)
    void doSign(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignResult> callback);

    @Serialization(FormSerializer.class)
    @Path("/web_wallet/passenger/paymentSignThreeDSDetails")
    @Post
    @Deserialization(GsonDeserializer.class)
    void doSignThreeDSDetails(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SignThreeDSResult> callback);

    @Serialization(FormSerializer.class)
    @Path("/web_wallet/passenger/ocr/verify")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object orcVerify(@BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<OCRVerifyInfo> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withhold/v1/channel/key/query")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object queryPublicKey(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PublicKeyInfo> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/withholdPollingQuery")
    @Post
    @Deserialization(GsonDeserializer.class)
    void querySignResult(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PollResult> callback);

    @Serialization(GsonSerializer.class)
    @Path("/web_wallet/passenger/signrule")
    @Post
    @Deserialization(GsonDeserializer.class)
    Object requestBindCardSignInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BindCardInfo> callback);
}
