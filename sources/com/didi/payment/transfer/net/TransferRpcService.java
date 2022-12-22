package com.didi.payment.transfer.net;

import com.didi.payment.transfer.accounts.presenter.TransAccountRecordResp;
import com.didi.payment.transfer.accounts.presenter.TransVerifyAccountResp;
import com.didi.payment.transfer.channels.TransChannelResp;
import com.didi.payment.transfer.channels.presenter.TransAccountStatusResp;
import com.didi.payment.transfer.fillamount.TransCreateOrderResp;
import com.didi.payment.transfer.fillamount.TransServiceFeeResp;
import com.didi.payment.transfer.fillphone.TransCountryCodeResp;
import com.didi.payment.transfer.newaccount.TransBankAccountTypeResp;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.transfer.orderdetail.presenter.TransRemindMsgResp;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
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
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.Map;

@Path("/api/v0")
@Interception({TransferRpcRequestInterceptor.class})
@Timeout(connectTimeout = 30000)
public interface TransferRpcService extends RpcService {
    @Serialization(GsonSerializer.class)
    @Path("/transfer/cancel")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object cancelTransferOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransRemindMsgResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/transfer/checkTel")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object check99AccountByTel(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransVerifyAccountResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/account/status")
    @Deserialization(GsonDeserializer.class)
    Object checkAccountStatus(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransAccountStatusResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/didipay/order")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object createTransOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransCreateOrderResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/transfer/bank/option")
    @Deserialization(GsonDeserializer.class)
    Object getBankAccountTypeList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransBankAccountTypeResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/didipay/order/history")
    @Deserialization(GsonDeserializer.class)
    Object getHistoryList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransHistoryListResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/transfer/countryCodeList")
    @Deserialization(GsonDeserializer.class)
    Object queryCountryList(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransCountryCodeResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/didipay/order/status")
    @Deserialization(GsonDeserializer.class)
    Object queryOrderStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransPayResultResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/transfer/getFee")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object queryServiceFee(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransServiceFeeResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/transfer/receiver")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object queryTransferAccounts(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransAccountRecordResp> callback);

    @Serialization(GsonSerializer.class)
    @Path("/transfer/getRemind")
    @Post(contentType = "application/json")
    @Deserialization(GsonDeserializer.class)
    Object requestRemindRecieveMsg(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransRemindMsgResp> callback);

    @Get
    @Serialization(GsonSerializer.class)
    @Path("/transfer/channel")
    @Deserialization(GsonDeserializer.class)
    Object requestTransferMethods(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<TransChannelResp> callback);
}
