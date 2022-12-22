package com.didichuxing.comp.telecom.core.request;

import android.os.Build;
import com.didi.sdk.push.ServerParam;
import com.didi.soda.web.config.WebConstant;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.request.model.CallEventResponse;
import com.didichuxing.comp.telecom.core.request.model.CallListResponse;
import com.didichuxing.comp.telecom.core.voip.RoomInfo;
import com.didichuxing.comp.telecom.core.voip.VoipCallModel;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J(\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/request/VoipCallRequest;", "", "()V", "REPORT_ANSWERED", "", "REPORT_BUSY", "REPORT_CALL_IN", "REPORT_CANCEL_MAKE_CALL", "REPORT_HANG_UP", "REPORT_HANG_UP_BACKGROUND", "REPORT_HANG_UP_FOREGROUND", "REPORT_REJECT", "REPORT_UNANSWERED", "TAG", "buildRequestCommonParams", "", "getRequestUrl", "requestCallList", "", "bizParams", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didichuxing/comp/telecom/core/request/model/CallListResponse;", "requestEventReport", "event", "voipModel", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "Lcom/didichuxing/comp/telecom/core/request/model/CallEventResponse;", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: CallRequest.kt */
public final class VoipCallRequest {
    public static final VoipCallRequest INSTANCE = new VoipCallRequest();
    public static final String REPORT_ANSWERED = "answered";
    public static final String REPORT_BUSY = "busy";
    public static final String REPORT_CALL_IN = "call_in";
    public static final String REPORT_CANCEL_MAKE_CALL = "cf_hang_up";
    public static final String REPORT_HANG_UP = "hang_up";
    public static final String REPORT_HANG_UP_BACKGROUND = "b_hang_up";
    public static final String REPORT_HANG_UP_FOREGROUND = "f_hang_up";
    public static final String REPORT_REJECT = "reject";
    public static final String REPORT_UNANSWERED = "unanswered";

    /* renamed from: a */
    private static final String f46397a = "VoipCallRequest";

    private VoipCallRequest() {
    }

    public final void requestCallList(Map<String, ? extends Object> map, RpcService.Callback<CallListResponse> callback) {
        int i;
        CallManagerAssist.ParamsProvider paramsProvider;
        String appPushType;
        Intrinsics.checkParameterIsNotNull(map, "bizParams");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        String a = m33282a();
        Map<String, Object> b = m33283b();
        CallManagerAssist instance2 = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
        RequestCallListService requestCallListService = (RequestCallListService) new RpcServiceFactory(instance2.getAppContext()).newRpcService(RequestCallListService.class, a);
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        Map map2 = hashMap;
        if (config == null || (paramsProvider = config.getParamsProvider()) == null || (appPushType = paramsProvider.getAppPushType()) == null || (i = StringsKt.toIntOrNull(appPushType)) == null) {
            i = -1;
        }
        map2.put(ServerParam.PARAM_APP_TYPE_PUSH, i);
        map2.put("network", Integer.valueOf(NetworkUtil.getNetworkType()));
        requestCallListService.request(b, map2, callback);
    }

    public static /* synthetic */ void requestEventReport$default(VoipCallRequest voipCallRequest, String str, VoipCallModel voipCallModel, RpcService.Callback callback, int i, Object obj) {
        if ((i & 4) != 0) {
            callback = null;
        }
        voipCallRequest.requestEventReport(str, voipCallModel, callback);
    }

    public final void requestEventReport(String str, VoipCallModel voipCallModel, RpcService.Callback<CallEventResponse> callback) {
        String str2;
        int i;
        CallManagerAssist.ParamsProvider paramsProvider;
        String appPushType;
        String clientId;
        Intrinsics.checkParameterIsNotNull(str, "event");
        Intrinsics.checkParameterIsNotNull(voipCallModel, "voipModel");
        CallLogUtil.logI(f46397a, "requestEventReport - " + str + ' ' + voipCallModel);
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        String a = m33282a();
        Map<String, Object> b = m33283b();
        CallManagerAssist instance2 = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
        RequestEventReportService requestEventReportService = (RequestEventReportService) new RpcServiceFactory(instance2.getAppContext()).newRpcService(RequestEventReportService.class, a);
        RoomInfo roomInfo = voipCallModel.getRoomInfo();
        Map hashMap = new HashMap();
        String voipSessionId = voipCallModel.getVoipSessionId();
        String str3 = "";
        if (voipSessionId == null) {
            voipSessionId = str3;
        }
        hashMap.put("voip_session_id", voipSessionId);
        if (roomInfo == null || (str2 = roomInfo.getRoomId()) == null) {
            str2 = str3;
        }
        hashMap.put("room_id", str2);
        if (!(roomInfo == null || (clientId = roomInfo.getClientId()) == null)) {
            str3 = clientId;
        }
        hashMap.put("client_id", str3);
        hashMap.put("event_type", str);
        if (config == null || (paramsProvider = config.getParamsProvider()) == null || (appPushType = paramsProvider.getAppPushType()) == null || (i = StringsKt.toIntOrNull(appPushType)) == null) {
            i = -1;
        }
        hashMap.put(ServerParam.PARAM_APP_TYPE_PUSH, i);
        hashMap.put("event_time", Long.valueOf(CallManagerAssist.getTimeMillis() / ((long) 1000)));
        requestEventReportService.request(b, hashMap, new VoipCallRequest$requestEventReport$callback1$1());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        r0 = (r0 = r0.getHostProvider()).getCallApiHost();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String m33282a() {
        /*
            r2 = this;
            boolean r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.isRelease()
            if (r0 == 0) goto L_0x0025
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r1 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x0022
            com.didichuxing.comp.telecom.core.CallManagerAssist$HostProvider r0 = r0.getHostProvider()
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r0.getCallApiHost()
            if (r0 == 0) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            java.lang.String r0 = ""
            goto L_0x0027
        L_0x0025:
            java.lang.String r0 = "https://ccvoip-pre.didiglobal.com"
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.request.VoipCallRequest.m33282a():java.lang.String");
    }

    /* renamed from: b */
    private final Map<String, Object> m33283b() {
        CallManagerAssist.ParamsProvider paramsProvider;
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config == null || (paramsProvider = config.getParamsProvider()) == null) {
            return MapsKt.emptyMap();
        }
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("app_version", paramsProvider.getAppVersion());
        hashMap.put("token", paramsProvider.getToken());
        hashMap.put("platform", paramsProvider.getPlatform());
        hashMap.put("iso_country", paramsProvider.getCountryCode());
        hashMap.put(WebConstant.SYSTEM_ENTRANCE_PLATFORM, Build.VERSION.RELEASE);
        hashMap.put("model", Build.BRAND);
        hashMap.put("terminal_id", paramsProvider.getTerminalId());
        CallManagerAssist instance2 = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config2 = instance2.getConfig();
        Intrinsics.checkExpressionValueIsNotNull(config2, "CallManagerAssist.getInstance().config");
        hashMap.put("env", config2.getEnv() == 1 ? "sim" : "production");
        return hashMap;
    }
}
