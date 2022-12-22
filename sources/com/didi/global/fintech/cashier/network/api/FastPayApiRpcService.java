package com.didi.global.fintech.cashier.network.api;

import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayLimitRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayStatusRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPaySubmitQuizRequest;
import com.didi.global.fintech.cashier.model.net.response.CashierBaseResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayLimitResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayStatusResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPaySubmitQuizResponse;
import com.didi.global.fintech.cashier.network.CashierInterceptor;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H'J(\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000b2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0007H'J(\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0007H'J(\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u000e2\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0007H'J(\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00132\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\b0\u0007H'J(\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00162\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\b0\u0007H'¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/network/api/FastPayApiRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "changePayLimit", "", "payInfoRequest", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayLimitRequest;", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$CallbackV2;", "Lcom/didi/global/fintech/cashier/model/net/response/CashierBaseResponse;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayLimitResponse;", "changePayOrder", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/ChangePayOrderRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "getFastPayInfo", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayInfoRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;", "getPayOrder", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "setFastPayStatus", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPayStatusRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayStatusResponse;", "submitQuiz", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/FastPaySubmitQuizRequest;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPaySubmitQuizResponse;", "cashier_network_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayApiRpcService.kt */
public interface FastPayApiRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/changePayLimit")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void changePayLimit(@BodyParameter("") ChangePayLimitRequest changePayLimitRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<ChangePayLimitResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/changePayOrder")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void changePayOrder(@BodyParameter("") ChangePayOrderRequest changePayOrderRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<ChangePayOrderResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/getFastPayInfo")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getFastPayInfo(@BodyParameter("") FastPayInfoRequest fastPayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<FastPayInfoResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/getPayOrder")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void getPayOrder(@BodyParameter("") FastPayInfoRequest fastPayInfoRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<FastPayOrderResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/setFastPayStatus")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void setFastPayStatus(@BodyParameter("") FastPayStatusRequest fastPayStatusRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<FastPayStatusResponse>> callbackV2);

    @Serialization(GsonSerializer.class)
    @Path("v1/fastpay/submitQuestionnaire")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    @Interception({CashierInterceptor.class})
    void submitQuiz(@BodyParameter("") FastPaySubmitQuizRequest fastPaySubmitQuizRequest, @TargetThread(ThreadType.MAIN) RpcService.CallbackV2<CashierBaseResponse<FastPaySubmitQuizResponse>> callbackV2);
}
