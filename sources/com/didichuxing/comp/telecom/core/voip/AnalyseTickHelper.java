package com.didichuxing.comp.telecom.core.voip;

import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import com.didichuxing.comp.telecom.core.CallRole;
import com.didichuxing.comp.telecom.core.CallStateKt;
import com.didichuxing.comp.telecom.core.base.ICall;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/voip/AnalyseTickHelper;", "", "()V", "SDK_CONNECTED", "", "SDK_DIS_ERROR", "SDK_JOIN_FAIL", "SDK_SESSION_DESTROY", "STEP_ANSWER", "STEP_CALLOUT", "STEP_GRANTED", "STEP_INCALL", "STEP_STOPCALL", "tickEvent", "", "event", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "model", "Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;", "role", "Lcom/didichuxing/comp/telecom/core/CallRole;", "tickPushArrived", "pushTye", "", "(Lcom/didichuxing/comp/telecom/core/voip/VoipCallModel;Ljava/lang/Integer;)V", "tickSdkConnected", "timeMillis", "", "tickSdkEvents", "type", "tickUserActions", "tickVoipSteps", "step", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: AnalyseTickHelper.kt */
public final class AnalyseTickHelper {
    public static final AnalyseTickHelper INSTANCE = new AnalyseTickHelper();
    public static final String SDK_CONNECTED = "connected";
    public static final String SDK_DIS_ERROR = "disconnectedByError";
    public static final String SDK_JOIN_FAIL = "joinFailed";
    public static final String SDK_SESSION_DESTROY = "sessionDestroy";
    public static final String STEP_ANSWER = "answer";
    public static final String STEP_CALLOUT = "callout";
    public static final String STEP_GRANTED = "granted";
    public static final String STEP_INCALL = "incall";
    public static final String STEP_STOPCALL = "stopcall";

    private AnalyseTickHelper() {
    }

    public final void tickSdkConnected(long j, VoipCallModel voipCallModel, CallRole callRole) {
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("type", SDK_CONNECTED);
        map.put("timecost", Long.valueOf(j / 1000));
        m33295a("ibt_call_voip_sdk_callback_bt", hashMap, voipCallModel, callRole);
    }

    public final void tickSdkEvents(String str, VoipCallModel voipCallModel, CallRole callRole) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        m33295a("ibt_call_voip_sdk_callback_bt", hashMap, voipCallModel, callRole);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        if (r8.equals("cf_hang_up") != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bd, code lost:
        if (r8.equals("busy") != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if (r8.equals("reject") != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        r1.put("style", com.didichuxing.comp.telecom.core.CallStateKt.toStr(com.didichuxing.comp.telecom.core.CallRole.CALL_MAKER));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d8, code lost:
        if (r8.equals(com.didichuxing.comp.telecom.core.voip.VoipCallModelKt.PUSH_EVENT_INCOMECALL) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00da, code lost:
        r1.put("style", com.didichuxing.comp.telecom.core.CallStateKt.toStr(com.didichuxing.comp.telecom.core.CallRole.CALLEE));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tickPushArrived(com.didichuxing.comp.telecom.core.voip.VoipCallModel r8, java.lang.Integer r9) {
        /*
            r7 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            java.lang.String r0 = r8.getEvent()
            if (r0 == 0) goto L_0x00fb
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "type"
            r1.put(r2, r0)
            com.didichuxing.comp.telecom.core.CallManagerAssist r0 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            java.lang.String r2 = "CallManagerAssist.getInstance()"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r0 = r0.getConfig()
            if (r0 == 0) goto L_0x0031
            com.didichuxing.comp.telecom.core.CallManagerAssist$AppServiceProvider r0 = r0.getAppServiceProvider()
            if (r0 == 0) goto L_0x0031
            long r3 = r0.serverTime()
            goto L_0x0035
        L_0x0031:
            long r3 = java.lang.System.currentTimeMillis()
        L_0x0035:
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            java.lang.Long r0 = r8.getEventTime()
            if (r0 == 0) goto L_0x004f
            java.lang.Number r0 = (java.lang.Number) r0
            long r5 = r0.longValue()
            long r5 = r3 - r5
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            java.lang.String r5 = "interval"
            r1.put(r5, r0)
        L_0x004f:
            java.lang.Long r0 = r8.getExpireTime()
            if (r0 == 0) goto L_0x006b
            java.lang.Number r0 = (java.lang.Number) r0
            long r5 = r0.longValue()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "expired"
            r1.put(r3, r0)
        L_0x006b:
            if (r9 == 0) goto L_0x007c
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "from"
            r1.put(r0, r9)
        L_0x007c:
            java.lang.String r9 = r8.getVoipSessionId()
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r9 = r0
        L_0x0086:
            java.lang.String r3 = "voip_session_id"
            r1.put(r3, r9)
            com.didichuxing.comp.telecom.core.voip.RoomInfo r9 = r8.getRoomInfo()
            if (r9 == 0) goto L_0x0098
            java.lang.String r9 = r9.getRoomId()
            if (r9 == 0) goto L_0x0098
            r0 = r9
        L_0x0098:
            java.lang.String r9 = "room_id"
            r1.put(r9, r0)
            java.lang.String r8 = r8.getEvent()
            if (r8 != 0) goto L_0x00a4
            goto L_0x00e3
        L_0x00a4:
            int r9 = r8.hashCode()
            java.lang.String r0 = "style"
            switch(r9) {
                case -1020452985: goto L_0x00d2;
                case -934710369: goto L_0x00c0;
                case 3035641: goto L_0x00b7;
                case 1099376044: goto L_0x00ae;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            goto L_0x00e3
        L_0x00ae:
            java.lang.String r9 = "cf_hang_up"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00e3
            goto L_0x00da
        L_0x00b7:
            java.lang.String r9 = "busy"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00e3
            goto L_0x00c8
        L_0x00c0:
            java.lang.String r9 = "reject"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00e3
        L_0x00c8:
            com.didichuxing.comp.telecom.core.CallRole r8 = com.didichuxing.comp.telecom.core.CallRole.CALL_MAKER
            java.lang.String r8 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r8)
            r1.put(r0, r8)
            goto L_0x00e3
        L_0x00d2:
            java.lang.String r9 = "incomecall"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00e3
        L_0x00da:
            com.didichuxing.comp.telecom.core.CallRole r8 = com.didichuxing.comp.telecom.core.CallRole.CALLEE
            java.lang.String r8 = com.didichuxing.comp.telecom.core.CallStateKt.toStr(r8)
            r1.put(r0, r8)
        L_0x00e3:
            com.didichuxing.comp.telecom.core.CallManagerAssist r8 = com.didichuxing.comp.telecom.core.CallManagerAssist.getInstance()
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r8, r2)
            com.didichuxing.comp.telecom.core.CallManagerAssist$CallManagerConfig r8 = r8.getConfig()
            if (r8 == 0) goto L_0x00fb
            com.didichuxing.comp.telecom.core.CallManagerAssist$AppServiceProvider r8 = r8.getAppServiceProvider()
            if (r8 == 0) goto L_0x00fb
            java.lang.String r9 = "ibt_call_voip_push_bt"
            r8.tickEvent(r9, r1)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.comp.telecom.core.voip.AnalyseTickHelper.tickPushArrived(com.didichuxing.comp.telecom.core.voip.VoipCallModel, java.lang.Integer):void");
    }

    public final void tickVoipSteps(String str, VoipCallModel voipCallModel, CallRole callRole) {
        Intrinsics.checkParameterIsNotNull(str, DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP);
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaTraceService.MAS_MONITOR_EVENT.KEY.STEP, str);
        m33295a("ibt_call_voip_steps_bt", hashMap, voipCallModel, callRole);
    }

    public final void tickUserActions(String str, VoipCallModel voipCallModel, CallRole callRole) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        m33295a("ibt_call_voip_actions_bt", hashMap, voipCallModel, callRole);
    }

    /* renamed from: a */
    static /* synthetic */ void m33294a(AnalyseTickHelper analyseTickHelper, String str, HashMap hashMap, VoipCallModel voipCallModel, CallRole callRole, int i, Object obj) {
        if ((i & 4) != 0) {
            voipCallModel = null;
        }
        if ((i & 8) != 0) {
            callRole = null;
        }
        analyseTickHelper.m33295a(str, hashMap, voipCallModel, callRole);
    }

    /* renamed from: a */
    private final void m33295a(String str, HashMap<String, Object> hashMap, VoipCallModel voipCallModel, CallRole callRole) {
        CallManagerAssist.AppServiceProvider appServiceProvider;
        String roomId;
        if (callRole != null) {
            hashMap.put("style", CallStateKt.toStr(callRole));
        }
        if (voipCallModel == null) {
            ICall mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall();
            if (!(mCurrentCall instanceof VoipAudioCall)) {
                mCurrentCall = null;
            }
            VoipAudioCall voipAudioCall = (VoipAudioCall) mCurrentCall;
            voipCallModel = voipAudioCall != null ? voipAudioCall.getVoipCallModel() : null;
        }
        if (voipCallModel != null) {
            Map map = hashMap;
            String voipSessionId = voipCallModel.getVoipSessionId();
            String str2 = "";
            if (voipSessionId == null) {
                voipSessionId = str2;
            }
            map.put("voip_session_id", voipSessionId);
            RoomInfo roomInfo = voipCallModel.getRoomInfo();
            if (!(roomInfo == null || (roomId = roomInfo.getRoomId()) == null)) {
                str2 = roomId;
            }
            map.put("room_id", str2);
        }
        CallManagerAssist instance = CallManagerAssist.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
        CallManagerAssist.CallManagerConfig config = instance.getConfig();
        if (config != null && (appServiceProvider = config.getAppServiceProvider()) != null) {
            appServiceProvider.tickEvent(str, hashMap);
        }
    }
}
