package com.didi.payment.wallet.global.risk;

import android.content.Context;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.screenshot.IRegisterScreenShotFirstListener;
import com.didi.payment.base.screenshot.ScreenShotListenManager;
import com.didi.payment.base.screenshot.ScreenShotListener;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.constant.GlobalServer;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/risk/RiskScreenShotImpl;", "Lcom/didi/payment/base/screenshot/IRegisterScreenShotFirstListener;", "()V", "mService", "Lcom/didi/payment/wallet/global/risk/RiskScreenShotImpl$RiskControlService;", "onRegister", "", "RiskControlService", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RiskScreenShotImpl.kt */
public final class RiskScreenShotImpl implements IRegisterScreenShotFirstListener {

    /* renamed from: a */
    private final RiskControlService f31778a;

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\ba\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H'¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/risk/RiskScreenShotImpl$RiskControlService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "uploadScreenShot", "", "body", "", "", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: RiskScreenShotImpl.kt */
    public interface RiskControlService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/risk-api/out/abnormalActionReport")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        void uploadScreenShot(@BodyParameter("") Map<String, ? extends Object> map);
    }

    public RiskScreenShotImpl() {
        RpcService newRpcService = new RpcServiceFactory(ApplicationContextProvider.Companion.getContext()).newRpcService(RiskControlService.class, GlobalServer.GLOBAL_ONLINE_ORIGIN_URL);
        Intrinsics.checkNotNullExpressionValue(newRpcService, "RpcServiceFactory(Applic…LINE_ORIGIN_URL\n        )");
        this.f31778a = (RiskControlService) newRpcService;
    }

    public void onRegister() {
        ScreenShotListenManager.INSTANCE.addListener(new ScreenShotListener() {
            public final void onScreenShot(Triple triple) {
                RiskScreenShotImpl.m22539a(RiskScreenShotImpl.this, triple);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22539a(RiskScreenShotImpl riskScreenShotImpl, Triple triple) {
        Intrinsics.checkNotNullParameter(riskScreenShotImpl, "this$0");
        Context context = ApplicationContextProvider.Companion.getContext();
        Map linkedHashMap = new LinkedHashMap();
        String terminalId = WalletCommonParamsUtil.getTerminalId(context);
        Intrinsics.checkNotNullExpressionValue(terminalId, "getTerminalId(context)");
        linkedHashMap.put("terminal_id", terminalId);
        String country = WalletCommonParamsUtil.getCountry(context);
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(context)");
        linkedHashMap.put("countryCode", country);
        String token = WalletCommonParamsUtil.getToken(context);
        Intrinsics.checkNotNullExpressionValue(token, "getToken(context)");
        linkedHashMap.put("token", token);
        Map linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("timestamp", String.valueOf(((Number) triple.getFirst()).longValue() / ((long) 1000)));
        Object third = triple.getThird();
        Intrinsics.checkNotNullExpressionValue(third, "activityInfo.third");
        linkedHashMap2.put("actionId", third);
        linkedHashMap2.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, "screenshot");
        Unit unit = Unit.INSTANCE;
        linkedHashMap.put("abnormalAction", new Map[]{linkedHashMap2});
        riskScreenShotImpl.f31778a.uploadScreenShot(linkedHashMap);
    }
}
