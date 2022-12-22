package com.didiglobal.pay.paysecure.prepaidcard.net;

import android.os.Build;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
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
import com.didiglobal.pay.paysecure.PaySecure;
import com.didiglobal.pay.paysecure.net.PaySecureGsonDeserializer;
import com.didiglobal.pay.paysecure.net.PaySecureNetInterceptor;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.didiglobal.pay.paysecure.prepaidcard.resp.ActiveCardResp;
import com.didiglobal.pay.paysecure.prepaidcard.resp.VerifyCardNoResp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fJ(\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0011H\u0002JN\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\r0\fJB\u0010\u0016\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\r0\fJl\u0010\u0019\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest;", "", "()V", "service", "Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest$PrepaidCardNet;", "activateCard", "", "cardId", "", "scene", "cardSessionId", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/ActiveCardResp;", "getBaseParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setCardPassword", "encryptPassword", "encryptKey", "sessionId", "verifyCardNo", "verifyContent", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "verifyPassword", "source", "passwordType", "payPasswordToken", "PrepaidCardNet", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: PrepaidCardRequest.kt */
public final class PrepaidCardRequest {

    /* renamed from: a */
    private final PrepaidCardNet f50406a;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH'JP\u0010\r\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b0\nH'JN\u0010\u000e\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0014\b\u0001\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nH'JP\u0010\u0010\u001a\u00020\u00032\u0016\b\u0001\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0016\b\u0001\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b0\nH'¨\u0006\u0011"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/net/PrepaidCardRequest$PrepaidCardNet;", "Lcom/didichuxing/foundation/rpc/RpcService;", "activateCard", "", "queryParameter", "", "", "", "param", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didiglobal/pay/paysecure/net/pojo/response/PaySecureResponse;", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/ActiveCardResp;", "setCardPassword", "verifyCardNo", "Lcom/didiglobal/pay/paysecure/prepaidcard/resp/VerifyCardNoResp;", "verifyPassword", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    @Interception({PaySecureNetInterceptor.class})
    /* compiled from: PrepaidCardRequest.kt */
    public interface PrepaidCardNet extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/activate")
        @Post(contentType = "application/json")
        @Deserialization(PaySecureGsonDeserializer.class)
        void activateCard(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<ActiveCardResp>> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/set/password")
        @Post(contentType = "application/json")
        @Deserialization(PaySecureGsonDeserializer.class)
        void setCardPassword(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<String>> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/verify/last4digits")
        @Post(contentType = "application/json")
        @Deserialization(PaySecureGsonDeserializer.class)
        void verifyCardNo(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<VerifyCardNoResp>> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/verify/password")
        @Post(contentType = "application/json")
        @Deserialization(PaySecureGsonDeserializer.class)
        void verifyPassword(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PaySecureResponse<Object>> callback);
    }

    public PrepaidCardRequest() {
        RpcService newRpcService = new RpcServiceFactory(PaySecure.INSTANCE.getAppContext()).newRpcService(PrepaidCardNet.class, "https://wallet.didiglobal.com");
        Intrinsics.checkExpressionValueIsNotNull(newRpcService, "RpcServiceFactory(PaySec…let.didiglobal.com\"\n    )");
        this.f50406a = (PrepaidCardNet) newRpcService;
    }

    public final void verifyCardNo(String str, String str2, String str3, String str4, RpcService.Callback<PaySecureResponse<VerifyCardNoResp>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cardId", str);
        linkedHashMap.put("scene", str2);
        linkedHashMap.put("sessionId", str4);
        linkedHashMap.put("last4Digits", str3);
        this.f50406a.verifyCardNo(m36258a(), linkedHashMap, callback);
    }

    public final void verifyPassword(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, RpcService.Callback<PaySecureResponse<Object>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map a = m36258a();
        a.put("cardId", str);
        a.put("encryptPassword", str2);
        a.put("source", str3);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cardId", str);
        linkedHashMap.put("encryptPassword", str2);
        linkedHashMap.put("scene", str4);
        linkedHashMap.put("sessionId", str5);
        linkedHashMap.put("encryptKey", str6);
        linkedHashMap.put("passwordType", str7);
        linkedHashMap.put("payPasswordToken", str8);
        this.f50406a.verifyPassword(a, linkedHashMap, callback);
    }

    public final void setCardPassword(String str, String str2, String str3, String str4, String str5, RpcService.Callback<PaySecureResponse<String>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cardId", str);
        linkedHashMap.put("encryptPassword", str2);
        linkedHashMap.put("encryptKey", str3);
        linkedHashMap.put("sessionId", str4);
        linkedHashMap.put("scene", str5);
        this.f50406a.setCardPassword(m36258a(), linkedHashMap, callback);
    }

    public final void activateCard(String str, String str2, String str3, RpcService.Callback<PaySecureResponse<ActiveCardResp>> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("cardId", str);
        linkedHashMap.put("sessionId", str3);
        linkedHashMap.put("scene", str2);
        this.f50406a.activateCard(m36258a(), linkedHashMap, callback);
    }

    /* renamed from: a */
    private final HashMap<String, Object> m36258a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        Map map = hashMap;
        map.put("token", PaySecure.INSTANCE.getConfig().getNetParamListener().getToken());
        map.put("terminal_id", PaySecure.INSTANCE.getConfig().getTerminalId());
        map.put("app_version", SystemUtil.getVersionName(PaySecure.INSTANCE.getAppContext()));
        map.put("partner_id", "");
        map.put("suuid", SecurityUtil.getUUID());
        map.put("appid", PaySecure.INSTANCE.getConfig().getAppId());
        map.put("os", "android");
        map.put("model", Build.MODEL);
        map.put("lat", Double.valueOf(PaySecure.INSTANCE.getConfig().getNetParamListener().getLat()));
        map.put("lng", Double.valueOf(PaySecure.INSTANCE.getConfig().getNetParamListener().getLng()));
        return hashMap;
    }
}
