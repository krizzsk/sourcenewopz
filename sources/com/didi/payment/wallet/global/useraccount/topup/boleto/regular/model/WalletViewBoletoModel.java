package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.Map;

public class WalletViewBoletoModel {

    /* renamed from: a */
    private static final String f31939a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private WalletViewBoletoRpcService f31940b;

    /* renamed from: c */
    private Context f31941c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletViewBoletoRpcService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/email")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object sendEmail(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletBoletoSendEmailResp> callback);
    }

    public WalletViewBoletoModel(Context context) {
        this.f31941c = context;
        this.f31940b = (WalletViewBoletoRpcService) new RpcServiceFactory(context).newRpcService(WalletViewBoletoRpcService.class, "https://wallet.didiglobal.com");
    }

    public void sendEmail(WalletBoletoResp walletBoletoResp, RpcService.Callback<WalletBoletoSendEmailResp> callback) {
        HashMap<String, Object> a = m22610a(this.f31941c);
        HashMap hashMap = new HashMap();
        hashMap.put("currency", walletBoletoResp.currency);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("text", walletBoletoResp.amount.getContent());
        hashMap.put("amount", hashMap2);
        hashMap.put("url", walletBoletoResp.url);
        hashMap.put("typeableLine", walletBoletoResp.typeableLine);
        hashMap.put("status", walletBoletoResp.status);
        hashMap.put("expiryTime", walletBoletoResp.expiryTime);
        hashMap.put("accountEmail", walletBoletoResp.accountEmail);
        hashMap.put("receiverEmail", walletBoletoResp.receiverEmail);
        this.f31940b.sendEmail(a, hashMap, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m22610a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
